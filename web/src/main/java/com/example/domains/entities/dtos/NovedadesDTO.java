package com.example.domains.entities.dtos;

import java.util.List;

import com.example.domains.entities.Actor;
import com.example.domains.entities.Film;

import lombok.Value;

@Value
public class NovedadesDTO {
	List<Actor> actores;
	List<Film> peliculas;
}
