package com.example.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.domains.contracts.services.ActorService;
import com.example.domains.entities.Actor;

public class CatalogoService {
	@Autowired
	ActorService actorService;
	// ...
	
	public CatalogoService() {
		// TODO Auto-generated constructor stub
	}

	public void novedades() {
		// TODO Auto-generated method stub
		return ;
	}

}
