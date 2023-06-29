package com.example;

public enum DiasDeLaSemana {
	LUNES(1), MARTES(2), MIERCOLES(3), JUEVES(4), VIERNES(5), SABADO(6), DOMINGO(7);
	private int valor;
	private DiasDeLaSemana(int dia) {
		valor = dia;
	}
	int getValue() { return valor; }
	public static DiasDeLaSemana getEnum(int dia) {
		return switch (dia) {
		case 1 -> DiasDeLaSemana.LUNES;
		case 2 -> DiasDeLaSemana.MARTES;
		case 3 -> DiasDeLaSemana.MIERCOLES;
		case 4 -> DiasDeLaSemana.JUEVES;
		case 5 -> DiasDeLaSemana.VIERNES;
		case 6 -> DiasDeLaSemana.SABADO;
		case 7 -> DiasDeLaSemana.DOMINGO;
		default -> throw new IllegalArgumentException("Unexpected value: " + dia);
		};
	}
}
