package com.example.IoC;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class DependenciaMockImpl implements Dependencia {
	private int contador = 1;
	public DependenciaMockImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void algo() {
		System.err.println("Soy la dependencia simulada");
	}
	@Override
	public int getContador() { return contador; }
	@Override
	public void add() { ++contador; }
	@Override
	public void delete() { --contador; }
}
