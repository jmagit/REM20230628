package com.example.domains.entities;

import java.time.LocalDate;

public interface Persona extends Comparable<Persona> {
	int getId();
	String getNombre();
	String getApellidos();
	LocalDate getFechaNacimiento();
	
//	String getNombreCompleto();
	default String getOtro() {
		return getApellidos() + ", " + getNombre();
	}
	
	default String getNombreCompleto() {
		return getNombre() + " " + getApellidos();
	}
}
