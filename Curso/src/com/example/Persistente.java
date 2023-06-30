package com.example;

public interface Persistente {
	void save();
	default void dimeTuClase() {
		System.out.println(this.getClass().getName());
	}
}
