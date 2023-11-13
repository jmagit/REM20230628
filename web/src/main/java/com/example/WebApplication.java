package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.IoC.Inyectable;
import com.example.IoC.OtroComponente;

@SpringBootApplication
public class WebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Autowired
	Inyectable srv;

	@Autowired
	OtroComponente comp;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicacion arrancada");
		srv.run();
		srv.add();
		srv.cuantos();
		comp.exec();
	}

}
