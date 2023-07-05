package com.example.main;

import java.util.ServiceLoader;

import com.example.domains.contracts.Config;
import com.example.domains.services.PersonaServiceImpl;


public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ServiceLoader<Config> servicios = ServiceLoader.load(Config.class);
		servicios.forEach(Config::configure);
		
		
		var srv = new PersonaServiceImpl();
		srv.add(null);
	}

}
