package com.example.domains.entities.dtos;

import org.springframework.data.rest.core.config.Projection;

import com.example.domains.entities.Film;
import com.fasterxml.jackson.annotation.JsonProperty;

@Projection(name = "peli-corta", types = { Film.class })
public interface PeliCorta {
	@JsonProperty("id") 
	int getFilmId();
	@JsonProperty("titulo") 
	String getTitle();
}
