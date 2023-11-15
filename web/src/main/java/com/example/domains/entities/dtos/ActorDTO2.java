package com.example.domains.entities.dtos;

import lombok.Data;

@Data
public class ActorDTO2 {
	private int id;
	private String nombre;
	private String apellidos;

	public ActorDTO2(int actorId, String firstName, String lastName) {
		super();
		this.id = actorId;
		this.nombre = firstName;
		this.apellidos = lastName;
	}
}
