package com.examples.infraestructure.config;

import com.examples.contracts.Configuracion;

public class ConfiguracionImp implements Configuracion {

	@Override
	public void configurate(String conf) {
		System.out.println("soy el modulo de INFRAESTRUCTURA y me han dicho: " + conf);
	}

}
