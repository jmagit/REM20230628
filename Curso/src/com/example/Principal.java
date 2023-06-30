package com.example;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Clase principal de la aplicacion
 */
public class Principal {

	/**
	 * Método principal de la clase
	 * 
	 * @param args Argumentos de la linea a comandos
	 */
	public static void main(String[] args) {
		facturas();
	}

	public static void facturas() {
		var f = new Factura(666);
		var ff = new Factura(123);
		f.addLinea(1, 1, 1, 100);
		ff.addLinea(1, 2, 2, 10);
		System.out.println(f.getLineas().get(0));
		f.setNumeroFactura(222);
		System.out.println(f.getLineas().get(0));
		System.out.println(ff.getLineas().get(0));
		class Fact extends Factura {
			public Fact(int numeroFactura) {
				super(numeroFactura);
			}

			@Override
			public void addLinea(int numero, int idProducto, int cantidad, double precioUnitario) {
				// TODO Auto-generated method stub
				super.addLinea(numero, idProducto, cantidad, precioUnitario);
			}
		}
		Factura l = new Fact(1234), ll =  new Fact(234);
		
	}

	public static void clases() {
		Persona p = new Profesor(1, "Pepito", 1000);
//		System.out.println(Date.from(Instant.now()).toLocaleString());
//		p.setFechaNacimiento(new Date(100, 1, 1));
//		System.out.println(p.getFechaNacimiento().toLocaleString());
//		p.getFechaNacimiento().setYear(2025);
//		System.out.println(p.getFechaNacimiento().toLocaleString());
//		p.setFechaNacimiento(new Date(1025, 1, 1));
		p.setFechaNacimiento(LocalDate.of(2000, 6, 30));
		System.out.println(p.getFechaNacimiento());
		System.out.println(p.getEdad());
		p.setFechaNacimiento("2023-06-29");
		System.out.println(p.getFechaNacimiento());
		System.out.println(p.getEdad());
		//p.setFechaNacimiento(LocalDate.of(2030, 6, 30));
		Persona.Asignatura asignatura = new Persona.Asignatura();
	}

	public static void enumerados() {
		DiasDeLaSemana dia = DiasDeLaSemana.LUNES;
		DiasLaborables x = DiasLaborables.LUNES;
		Factura.Estado estado = Factura.Estado.PENDIENTE;
		
		if(dia.toLaborable() == DiasLaborables.LUNES) {
			System.out.println(dia.getValue());
			dia = DiasDeLaSemana.getEnum(3);
			System.out.println(dia.toString());
			System.out.println(dia.getValue());
			dia = DiasDeLaSemana.valueOf("SABADO");
			System.out.println(dia.toString());
		}
	}

	public static void operadores() {
		BigDecimal decimal;
		int i = 3, j = 2;
		boolean b, a = true;
//		i = (j = 0) + 1;
//		if(b = a) {
//			
//		}
		System.out.println((double) i / j);
		System.out.println(Math.round(0.1 + 0.2) == 0.3);
		System.out.println(1 - 0.9);
		String cad = null;
		Object o = cad;
		if (o instanceof String) {
			String l = (String) o;
			l.length();
		}
		if (o instanceof String l) {
			l.length();
		}
		if (cad != null && cad.length() > 0) {
		}
//		exterior: while (true) {
//			if (i > 0)
//				break;
//			if(j == 0) {
//				continue;
//			} 
//			if(j == 1) {
//				
//			}
//			}
//			switch (i) {
//			case 1:
//				break exterior;
//			default:
//
//			}
//			while (true) {
//				if (i > 0)
//					break exterior;
//			}
//		}

	}

	public static void variables() {
		String cad = """
				Hola
				mundo!
				""";
		int i, j;
		i = 0;
		j = i;
		final int constante = 0, c2;
		c2 = 0;
		long l = i;
		i = (int) l;
		i = 'd';
		short corto = 'a' + 1;
		Math.abs((long) i);

		if (i > 0) {

		}
		Object o = "";

		((String) o).length();
		String string = null;
		string = new String(); // ""
		string.length();
		var x = new ArrayList<String>();
		((List) o).size();
//		x = "dd";

		int[][] tab = new int[5][5];
		tab[0][0] = 0;
		tab[1] = new int[3];
		var aux = tab[0];
		tab[0] = tab[1];
		tab[1] = aux;
		int[] t = { 1, 2, 3 };
		tab[2] = t;
		System.out.println(x);

	}

}
