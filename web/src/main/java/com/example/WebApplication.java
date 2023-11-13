package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.IoC.EjemplosIoC;
import com.example.IoC.Inyectable;
import com.example.IoC.OtroComponente;
import com.example.IoC.Tonteria;

@SpringBootApplication
public class WebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Autowired
//	@Qualifier("antigua")
	Inyectable srv;

	@Autowired(required = false)
	OtroComponente comp;
	
	@Autowired
	Tonteria unaTonteria;
	
	@Autowired
	Tonteria unaTonteriaDep;
	
	@Autowired
	EjemplosIoC eje;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicacion arrancada");
		srv.run();
		srv.add();
		srv.cuantos();
		if(comp != null) comp.exec();
		unaTonteria.dime();
		unaTonteriaDep.dime();
		System.out.println(eje.toString());
		
//		var x = new EjemplosIoC(1, "Javi");
//		System.out.println(x.toString());
		
	}

}
