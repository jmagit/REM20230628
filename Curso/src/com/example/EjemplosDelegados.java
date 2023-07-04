package com.example;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

public class EjemplosDelegados {
	enum Tipo { bin, text, binDesc, textDesc }
	
	@FunctionalInterface
	interface Comp {
		int comp(String a, String b); // 1: a > b, 0: a == b; -1: a < b
		default int comp2(String a, String b) { return 0; }
	}
	
	void ejemplos() {
		class X implements Comp {
			@Override
			public int comp(String a, String b) {
				return a.compareTo(b);
			}
		}
		var x = new X();
		var y = new X();
		var bin = new Comp() {
			@Override
			public int comp(String a, String b) {
				return a.compareTo(b);
			}
		};
		String t[] = null;
		
//		var tt = ordena(t, bin);
//		tt = ordena(t, new Comp() {
//			@Override
//			public int comp(String a, String b) {
//				return a.compareToIgnoreCase(b);
//			}
//		});
		var tt = ordena(t, (a, b)-> a.compareToIgnoreCase(b));
		tt = ordena(t, (a, b)-> -a.compareToIgnoreCase(b));
	}
	
	String[] ordena(String t[], BiFunction<String, String, Integer> delegado) {
		int i = 0, j = 0;
		// ...
		switch (delegado.apply(t[i], t[j])) {
		case 1:
			//...
			break;
		case 0:
			//...
			break;
		default:
			//...
			break;
		}
		// ...
		return t;
	}
/*
	String[] ordena(String t[], Tipo tipo) {
		int i = 0, j = 0;
		// ...
		switch (tipo) {
		case Tipo.bin:
			
			break;

		default:
			break;
		}
		// ...
		return t;
	}
	String[] ordena(String t[]) {
		int i = 0, j = 0;
		// ...
		if(t[i] > t[j]) {
			
		} else if(t[i] == t[j]) {
			
		} else {
			
		}
		// ...
		return t;
	}
	String[] ordenaIC(String t[]) {
		int i = 0, j = 0;
		// ...
		if(t[i].toLowerCase() > t[j].toLowerCase()) {
			
		} else if(t[i].toLowerCase() == t[j].toLowerCase()) {
			
		} else {
			
		}
		// ...
		return t;
	}
*/
	}
