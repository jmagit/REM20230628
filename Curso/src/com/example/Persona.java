package com.example;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;

import com.example.contracts.Grafico;

public abstract class Persona implements Grafico {
	public static class Asignatura {
		
	}
	public static final int EDAD_MINIMA = 16;
	public final int EDAD_JUBILACION;
	private int id;
	private String nombre, apellidos;
	private LocalDate fechaNacimiento;
	private LocalDate fechaBaja;
	private boolean conflictivo = false;
	private boolean activo = true;
	private transient int edad;
	BiConsumer<Object, String> notificacion = null;
	
//	public Persona(){
//		EDAD_JUBILACION = 67;
//	}
	
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
		assert nombre != null: "El nombre esta a nulo";
		assert !nombre.isBlank(): "El nombre no puede estar en blanco" ;
		this.nombre = nombre;
	}

	public Optional<String> getApellidos() {
		if(apellidos == null)
			return Optional.empty();
		return Optional.of(apellidos);
//		return Optional.ofNullable(apellidos);
	}

	protected void setApellidos(String apellidos) {
		if(apellidos == null)
			throw new IllegalArgumentException("El apellido es obligatoria");
		this.apellidos = apellidos;
	}
	protected void clearApellidos() {
		this.apellidos = null;
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
		if(ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now()) < EDAD_MINIMA)
			throw new IllegalArgumentException("No tiene la edad minima");
		this.fechaNacimiento = fechaNacimiento;
		edad = (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
		assert edad >= EDAD_MINIMA;
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
	
	public void jubilate(LocalDate fecha) throws Exception {
		if(fecha == null)
			throw new IllegalArgumentException("La fecha es obligatoria");
		if(isNotActivo())
			throw new Exception("No esta activo para jubilarse");

		if(edad < EDAD_JUBILACION)
			throw new Exception("No tiene edad para jubilarse");
		
		fechaBaja = fecha; // LocalDate.now();
		activo = false;
		onNotificacion("Se ha jubilado");
	}
	
	public abstract void expulsar();

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		return id == ((Persona) obj).id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	public <T> T generico(T p) {
		if(p instanceof String s) {
			return (T) ("Es la cadena " + s);
		} else if(p instanceof Integer i) {
			return (T)(Integer)(i*2);
		}
		return null;
		
	}
	public <T> T sinParam(Class<T> tipo) {
//		if(p instanceof String s) {
//			return (T) ("Es la cadena " + s);
//		} else if(p instanceof Integer i) {
//			return (T)(Integer)(i*2);
//		}
		return null;
		
	}
	
	public void addNotificacionListener(BiConsumer<Object, String> notificacion) {
		this.notificacion = notificacion;
	}
	
	public void removeNotificacionListener(BiConsumer<Object, String> notificacion) {
		this.notificacion = null;
	}
	protected void onNotificacion(String mensaje) {
		if(notificacion!= null) {
			notificacion.accept(this, mensaje);
		}
	}
}
