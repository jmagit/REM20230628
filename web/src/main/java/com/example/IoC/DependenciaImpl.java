package com.example.IoC;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DependenciaImpl implements Dependencia {
	private int contador = 0;
	public DependenciaImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void algo() {
		System.err.println("Soy la dependencia real");
	}
	@Override
	public int getContador() { return contador; }
	@Override
	public void add() { ++contador; }
	@Override
	public void delete() { --contador; }
}
