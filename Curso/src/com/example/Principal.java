package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal de la aplicacion
 */
public class Principal {

	/**
	 * Metodo principal de la clase
	 * 
	 * @param args Argumentos de la linea a comandos
	 */
	public static void main(String[] args) {
		variables();
	}
	
	public static void variables() {
		String cad = """
				Hola 
				mundo!
				""";
		int i, j;
		i=0;
		j = i;
		final int constante = 0, c2;
		c2 = 0;
		long l = i;
		i = (int)l;
		i = 'd';
		short corto = 'a' + 1;
		Math.abs((long)i);
		
		if(i > 0) {
			
		}
		Object o = "";
		
		((String)o).length();
		String string = null;
		string = new String(); // ""
		string.length();
		var x = new ArrayList<String>();
		((List)o).size();
//		x = "dd";
		
		int[][] tab = new int[5][5];
		tab[0][0] = 0;
		tab[1] = new int[3];
		var aux = tab[0];
		tab[0] = tab[1];
		tab[1] = aux;
		int[] t = { 1, 2, 3};	
		tab[2] = t;
		System.out.println(x);
		
	}

}
