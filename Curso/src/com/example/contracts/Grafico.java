package com.example.contracts;

import com.example.exceptions.GraficosException;

public interface Grafico {
	void pintate() throws GraficosException;
	default void dimeTuClase() {
		System.out.println(this.getClass().getName());
	}
}
