package com.example.domains.entities.dtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.example.domains.entities.FilmActor;

public interface ActorAndTittle {
	@Value("#{target.actorId}")
	int getId();
	@Value("#{target.firstName + ' ' + target.lastName}")
	String getNombre();
}
