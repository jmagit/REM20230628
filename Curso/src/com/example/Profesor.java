package com.example;

import java.time.LocalDate;
import java.util.List;

public class Profesor extends Persona implements AutoCloseable {
	private double salario;
	private List<String> asignaturas;
	
	public Profesor() {
		super(0, "(Anonimo)", 67);
	}

	public Profesor(int id, String nombre, double salario) {
		super(id, nombre, 67);
		setSalario(salario);
	}

	public Profesor(int id, String nombre, String apellidos, LocalDate fechaNacimiento, boolean conflictivo, double salario) {
		super(id, nombre, apellidos, fechaNacimiento, conflictivo, 67);
		setSalario(salario);
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public void jubilate() throws Exception {
		super.jubilate();
		this.salario = 0;
	}
	
	@Override
	public void expulsar() {
		this.setConflictivo(true);
	}
	@Override
	public String toString() {
		return "Profe [id=" + getId() + ", nombre=" + getNombre() + ", apellidos=" + getApellidos() + "]";
	}
	
	@Override
	protected Profesor clone() throws CloneNotSupportedException {
		Profesor copia = (Profesor)super.clone();
		//copia.asignaturas = List.of(asignaturas);
		return copia;
	}
	@Override
	public void pintate() {
		System.out.println(toString());
	}

	@Override
	public void close() throws Exception {
		System.out.println("Finalizo: " + toString());
	}
	

//
//	@Override
//	protected void finalize() throws Throwable {
//		System.out.println("Finalizo: " + toString());
//		super.finalize();
//	}
}
