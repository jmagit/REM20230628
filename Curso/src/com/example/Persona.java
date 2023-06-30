package com.example;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;

public abstract class Persona {
	public static final int EDAD_MINIMA = 16;
	public final int EDAD_JUBILACION;
	private int id;
	private String nombre, apellidos;
	private LocalDate fechaNacimiento;
	private LocalDate fechaBaja;
	private boolean conflictivo = false;
	private boolean activo = true;
	private transient int edad;
	
	public Persona(){
		EDAD_JUBILACION = 67;
	}
	
	public Persona(int id, String nombre, int EDAD_JUBILACION) {
		setId(id);
		this.setNombre(nombre);
		this.EDAD_JUBILACION = EDAD_JUBILACION;
	}

	public Persona(int id, String nombre, String apellidos, LocalDate fechaNacimiento, boolean conflictivo,
			int EDAD_JUBILACION) {
		this(id, nombre, EDAD_JUBILACION);
		setApellidos(apellidos);
		setFechaNacimiento(fechaNacimiento);
		setConflictivo(conflictivo);
	}

	public int getId() { return id; }
	public void setId(int id) {
		if(this.id == id) return;
		if(id < 0) 
			throw new IllegalArgumentException("No puede ser negativo");
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public boolean hasFechaNacimiento() {
		return fechaNacimiento != null;
	}
	public LocalDate getFechaNacimiento() {
		if(fechaNacimiento == null)
			throw new NoSuchElementException("Falta la fecha de nacimiento");
		return fechaNacimiento; // (LocalDate)fechaNacimiento.clone();
	}

	public final void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("No puede ser una fecha futura");
		this.fechaNacimiento = fechaNacimiento;
		edad = (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		setFechaNacimiento(LocalDate.parse(fechaNacimiento, DateTimeFormatter.ISO_LOCAL_DATE));
	}

	public LocalDate getFechaBaja() {
		return fechaBaja;
	}

	protected void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public boolean isActivo() {
		return activo;
	}
	public boolean isNotActivo() {
		return !isActivo();
	}

	public boolean isConflictivo() {
		return conflictivo;
	}

	public void setConflictivo(boolean conflictivo) {
		this.conflictivo = conflictivo;
	}

	public int getEdad() {
		if(fechaNacimiento == null)
			throw new DateTimeException("Falta la fecha de nacimiento");
		return edad;
	}
	
	public void jubilate() throws Exception {
		if(isNotActivo())
			throw new Exception("No esta activo para jubilarse");

		if(edad < EDAD_JUBILACION)
			throw new Exception("No tiene edad para jubilarse");
		
		fechaBaja = LocalDate.now();
		activo = false;
	}
	
	public abstract void expulsar();
}
