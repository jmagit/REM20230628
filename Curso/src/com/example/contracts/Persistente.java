package com.example.contracts;

public interface Persistente {
	void save();
	default void dimeTuClase() {
		System.out.println(this.getClass().getName());
	}
}
