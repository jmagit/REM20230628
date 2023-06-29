package com.example;

import java.time.Instant;
import java.util.Date;

public abstract class Persona {
	public static final int EDAD_MINIMA = 16;
	public final int EDAD_JUBILACION;
	private int id;
	private String nombre, apellidos;
	private Date fechaNacimiento;
	private boolean conflictivo = false;
	private transient int edad;
	
	public Persona(){
		EDAD_JUBILACION = 67;
	}
	
	public Persona(int id, String nombre, int EDAD_JUBILACION) {
		setId(id);;
		this.setNombre(nombre);
		this.EDAD_JUBILACION = EDAD_JUBILACION;
	}

	public Persona(int id, String nombre, String apellidos, Date fechaNacimiento, boolean conflictivo,
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

	public Date getFechaNacimiento() {
		return (Date)fechaNacimiento.clone();
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		if(fechaNacimiento.after(Date.from(Instant.now())))
			throw new IllegalArgumentException("No puede ser una fecha futura");
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isConflictivo() {
		return conflictivo;
	}

	public void setConflictivo(boolean conflictivo) {
		this.conflictivo = conflictivo;
	}

	public int getEdad() {
		return edad;
	}
	
}
