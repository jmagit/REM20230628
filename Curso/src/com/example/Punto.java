package com.example;

public record Punto(int x, int y) {
	public Punto resta(Punto p) {
		return new Punto(x - p.x, y - p.y);
	}
	public Punto resta(int delta) {
//		x = x - delta;
//		y = y - delta;
		return new Punto(x - delta, y - delta);
	}
}