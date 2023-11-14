package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.IoC.EjemplosIoC;
import com.example.IoC.Inyectable;
import com.example.IoC.OtroComponente;
import com.example.IoC.Tonteria;
import com.example.domains.contracts.reposiries.ActorRepository;
import com.example.domains.entities.Actor;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class WebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

//	@Autowired
////	@Qualifier("antigua")
//	Inyectable srv;
//
//	@Autowired(required = false)
//	OtroComponente comp;
//	
//	@Autowired
//	Tonteria unaTonteria;
//	
//	@Autowired
//	Tonteria unaTonteriaDep;
//	
//	@Autowired
//	EjemplosIoC eje;
	
	@Autowired
	ActorRepository dao;
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicacion arrancada");
		
//		dao.save(new Actor(0, "Pepito", "Grillo"));
//		var item = dao.findById(201);
//		if(item.isPresent()) {
//			Actor actor = item.get();
//			actor.setFirstName(actor.getFirstName().toUpperCase());
//			dao.save(actor);
//		}
//		dao.deleteById(201);
//		dao.findAll().forEach(System.out::println);
//		dao.findTop5ByFirstNameStartingWithOrderByLastName("P").forEach(System.out::println);
//		dao.findTop5ByFirstNameStartingWith("P", Sort.by("firstName", "lastName").ascending()).forEach(System.out::println);
//		dao.findByActorIdGreaterThan(200).forEach(System.out::println);
//		dao.findNovedadesJPQL(200).forEach(System.out::println);
//		dao.findNovedadesSQL(200).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.greaterThan(root.get("actorId"), 200))
//			.forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.lessThan(root.get("actorId"), 10))
//			.forEach(System.out::println);
//		var item = dao.findById(1);
//		if(item.isPresent()) {
//			Actor actor = item.get();
//			System.out.println(actor);
//			actor.getFilmActors().forEach(p -> System.out.println(p.getFilm().getTitle()));
//		}
//		dao.findAll((root, query, builder) -> builder.lessThan(root.get("actorId"), 5))
//			.forEach(actor -> {
//				System.out.println(actor);
//				actor.getFilmActors().forEach(p -> System.out.println(p.getFilm().getTitle()));
//			});
		dao.findAll(PageRequest.of(0, 10, Sort.by("actorId"))).forEach(System.out::println);
	}
	
	@Transactional
	void transaccion() {
		
	}
	
	public void runIoC(String... args) throws Exception {
		System.out.println("Aplicacion arrancada");
//		srv.run();
//		srv.add();
//		srv.cuantos();
//		if(comp != null) comp.exec();
//		unaTonteria.dime();
//		unaTonteriaDep.dime();
//		System.out.println(eje.toString());
		
//		var x = new EjemplosIoC(1, "Javi");
//		System.out.println(x.toString());
		
	}

}
