package com.examples.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.examples.contracts.AlumnoRepository;
import com.examples.entities.Alumno;
import com.examples.uow.DataBase;

//import com.examples.entities.Alumno;

public class AlumnoRepositoryImp implements AlumnoRepository {
	DataBase db = new DataBase();

	public AlumnoRepositoryImp() {
		// db.open();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Alumno> get() {
		// leer db
		return new ArrayList<Alumno>();
	}

	@Override
	public Alumno get(int id) {
		// leer db
		return null;
	}
	
	@Override
	public void add(Alumno item) throws CloneNotSupportedException {
		// ...
		db.save();
	}
	
	@Override
	public void modify(Alumno item) {
	}
	
	@Override
	public void remove(int id) {
	}
}
