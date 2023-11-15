package com.example.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domains.contracts.services.ActorService;
import com.example.domains.entities.Actor;
import com.example.domains.entities.dtos.NovedadesDTO;

@Service
public class CatalogoServiceImpl implements CatalogoService {
	@Autowired
	ActorService actorService;
	// FilmService filmService;

	@Override
	public NovedadesDTO novedades() {
		var actors = actorService.novedades();
//		var film = filmService.novedades();
		
		return new NovedadesDTO(actorService.novedades(), null);
	}

}
