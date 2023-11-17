package com.example.application.resources;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.application.proxies.CatalogoProxy;
import com.example.domains.entities.dtos.PeliCortaDTO;

@RestController
@RequestMapping("/cotilla")
public class CotillaResource {
	@Autowired
	RestTemplate srvRest;
	@Autowired
	RestTemplate srvRestLB;
	@Autowired
	CatalogoProxy proxy;
	
	@GetMapping("/rt/pelis")
	List<PeliCortaDTO> getPelisRt() {
		ResponseEntity<List<PeliCortaDTO>> response = srvRest.exchange(
				"http://localhost:8010/peliculas/v1?mode=short", 
				HttpMethod.GET,
				HttpEntity.EMPTY, 
				new ParameterizedTypeReference<List<PeliCortaDTO>>() {
				});
		return response.getBody();
	}
	@GetMapping("/rt/pelis/lb")
	List<PeliCortaDTO> getPelisRtLb() {
		ResponseEntity<List<PeliCortaDTO>> response = srvRestLB.exchange(
				"lb://CATALOGO-SERVICE/peliculas/v1?mode=short", 
				HttpMethod.GET,
				HttpEntity.EMPTY, 
				new ParameterizedTypeReference<List<PeliCortaDTO>>() {
				});
		return response.getBody();
	}
	@GetMapping("/of/pelis")
	List<PeliCortaDTO> getPelisOF() {
		return proxy.getPelis();
	}
	@GetMapping("/rt/pelis/{id}")
	PeliCortaDTO getPeliRt(@PathVariable() int id) {
		return srvRest.getForObject("http://localhost:8010/peliculas/v1/{id}", PeliCortaDTO.class, id);
	}
	@GetMapping("/rt/pelis/lb/{id}")
	PeliCortaDTO getPeliRtLB(@PathVariable() int id) {
		return srvRestLB.getForObject("lb://CATALOGO-SERVICE/peliculas/v1/{id}", PeliCortaDTO.class, id);
	}
	@GetMapping("/of/pelis/{id}")
	PeliCortaDTO getPeliOf(@PathVariable() int id) {
		return proxy.getPeli(id);
	}
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping(path = "/descubre/cloud/{nombre}")
	public List<ServiceInstance> serviceUrl(String nombre) {
	    return discoveryClient.getInstances(nombre);
	}
	@GetMapping(path = "/balancea/rt")
	public List<String> getBalanceoRT() {
		List<String> rslt = new ArrayList<>();
		LocalDateTime inicio = LocalDateTime.now();
		rslt.add("Inicio: " + inicio);
		for(int i = 0; i < 11; i++)
			try {
				LocalTime ini = LocalTime.now();
				rslt.add(srvRestLB.getForObject("lb://CATALOGO-SERVICE/actuator/info", String.class)
						+ " (" + ini.until(LocalTime.now(), ChronoUnit.MILLIS) + " ms)" );
			} catch (Exception e) {
				rslt.add(e.getMessage());
			}
		LocalDateTime fin = LocalDateTime.now();
		rslt.add("Final: " + fin + " (" + inicio.until(fin, ChronoUnit.MILLIS) + " ms)");		
		return rslt;
	}
	@GetMapping(path = "/balancea/proxy")
	public List<String> getBalanceoProxy() {
		List<String> rslt = new ArrayList<>();
		for(int i = 0; i < 11; i++)
			try {
				rslt.add(proxy.getInfo());
			} catch (Exception e) {
				rslt.add(e.getMessage());
			}
		return rslt;
	}

}
