package com.example;

public interface Grafico {
	void pintate();
	default void dimeTuClase() {
		System.out.println(this.getClass().getName());
	}
}
