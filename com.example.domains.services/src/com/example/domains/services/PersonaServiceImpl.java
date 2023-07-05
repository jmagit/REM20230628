package com.example.domains.services;

import java.util.List;

import com.example.domains.contracts.CRUDDomainService;
import com.example.domains.entities.Persona;

public class PersonaServiceImpl implements CRUDDomainService<Persona, Integer> {

	@Override
	public List<Persona> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Persona item) {
//		if(item.isInvalid())
//			throw ...
		System.out.println("Añadida persona");

	}

	@Override
	public void modify(Persona item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Persona item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

}
