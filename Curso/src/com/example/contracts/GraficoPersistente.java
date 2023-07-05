package com.example.contracts;

public interface GraficoPersistente extends Grafico, Persistente {

	@Override
	default void dimeTuClase() {
		Grafico.super.dimeTuClase();
		Persistente.super.dimeTuClase();
	}

}
