package com.example.application.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.domains.entities.dtos.PeliCortaDTO;

@FeignClient(name = "CATALOGO-SERVICE"/*, url="http://localhost:8010"*/)
public interface CatalogoProxy {
	@GetMapping(path = "/actuator/info")
	String getInfo();
	@GetMapping("/peliculas/v1?mode=short")
	List<PeliCortaDTO> getPelis();
	@GetMapping("/peliculas/v1/{id}")
	PeliCortaDTO getPeli(@PathVariable() int id);
	@GetMapping("/peliculas/v1/{id}")
	PeliCortaDTO getCerrado(@PathVariable() int id, @RequestHeader(value="Authoritation", required = true) String token);
}
