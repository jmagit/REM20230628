package com.example.domains.services.config;

import com.example.domains.contracts.Config;

public class ConfigImpl implements Config {

	@Override
	public void configure() {
		System.out.println("Configurando com.example.domains.services");
	}

}
