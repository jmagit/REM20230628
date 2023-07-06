package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import com.example.contracts.PersonasRepository;
import com.example.exceptions.InvalidDataException;
import com.example.util.Autor;

@Autor
public class PersonasRepositoryMock implements PersonasRepository {
	private static List<Persona> listado;
	
	static {
		listado = new CopyOnWriteArrayList<>();
		listado.add(new Profesor(1, "Pepito", "Grillo", LocalDate.of(1979, 9, 9), true, 2000));
		listado.add(new Alumno(2, "Un", "Alumno", LocalDate.of(2000, 11, 12), 80));
		listado.add(new Alumno(3, "Otro", "Mas", LocalDate.of(2002, 1, 15), 80));
		listado.add(new Alumno(4, "Tercer", "Alumno", LocalDate.of(1999, 8, 18), 80));
		listado.add(new Alumno(6, "El", "Nuevo", LocalDate.of(1996, 2, 22), 80));
		listado.add(new Profesor(5, "Profe", "Refuerzo", LocalDate.of(1990, 1, 31), false, 1500));
//		Random rnd = new Random();
//		for(Persona p: listado)
//			if(p instanceof Alumno a) {
//				for(int i = 0, asignaturas = rnd.nextInt(10); i < asignaturas; i++)
//					((Alumno) p).addNota(i, rnd.nextInt(11));
//			}
	}

	@Override
	public List<Persona> getAll() {
//		return Collections.unmodifiableList(listado);
		return listado.stream()
//				.map(item -> {
//			try {
//				return (Persona)item.clone();
//			} catch (CloneNotSupportedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return null;
//			}
//		})
				.toList();
	}
	@Override
	public Optional<Persona> getOne(Integer id) {
		return listado.stream().filter(p -> p.getId() == id).findFirst();
	}
	@Override
	public Persona add(Persona item) {
		if(getOne(item.getId()).isPresent())
			throw new InvalidDataException("Duplicate key");
		listado.add(item);
		return item;
	}
	@Override
	public Persona modify(Persona item) {
		var indice = listado.indexOf(item);
		if(indice < 0)
			throw new InvalidDataException("Not found");
		listado.set(indice, item);
		return item;
	}
	@Override
	public void delete(Persona item) {
		if(!listado.remove(item))
			throw new InvalidDataException("Not found");
	}
	@Override
	public void deleteById(Integer id) {
		var item = getOne(id);
		if(item.isEmpty())
			throw new InvalidDataException("Not found");
		listado.remove(item.get());
	}
}