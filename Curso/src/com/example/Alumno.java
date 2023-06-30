package com.example;

import java.time.LocalDate;

public class Alumno extends Persona {

	public Alumno() {
		super(0, "(Anonimo)", 67);
	}
	public Alumno(int id, String nombre, int EDAD_JUBILACION) {
		super(id, nombre, EDAD_JUBILACION);
		// TODO Auto-generated constructor stub
	}

	public Alumno(int id, String nombre, String apellidos, LocalDate fechaNacimiento, boolean conflictivo,
			int EDAD_JUBILACION) {
		super(id, nombre, apellidos, fechaNacimiento, conflictivo, EDAD_JUBILACION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void expulsar() {
		// TODO Auto-generated method stub

	}
	@Override
	public void pintate() {
		System.out.println(toString());
	}
	

}
