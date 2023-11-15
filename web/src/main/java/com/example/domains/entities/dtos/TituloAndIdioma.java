package com.example.domains.entities.dtos;

import org.springframework.beans.factory.annotation.Value;

public interface TituloAndIdioma {
	interface Idioma {
		String getName();
	}
	String getTitle();
	@Value("#{target.language.name}")
	Idioma getIdioma();
	
	Idioma getLanguage();
}
