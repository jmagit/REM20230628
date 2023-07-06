package com.example;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.juegos.Juego;
import com.example.juegos.JuegoException;
import com.example.juegos.naipes.BarajaFrancesa;
import com.example.juegos.naipes.NaipeFrances;
import com.example.juegos.naipes.ValorNaipe;
import com.example.juegos.numero.JuegoDelNumero.NotificaEventArgs;
import com.example.vending.Maquina;

public class Principal {
	private static final Scanner teclado = new Scanner(System.in);
	private static final PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);

	public static void main(String[] args) {
		var app = new Principal();
//		app.juegoNumero();
//		app.juegoConClase();
//		app.decode("3+4+3,4-7*1=");
//		app.decode("0,1+0,2+0,7-0,9=");
//		try {
////			app.calcula("3+4+3,4-7*1=");
//			app.calcula("0,1+0,2+0,7-0,9=");
////			app.calculaList("3+4+3,4-7*1=");
////			app.calculaList("0,1+0,2+0,7-0,9=");
//		} catch (CalculadoraException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		double a = 0.1+0.2, b = 1 - 0.9;
//		System.out.println(Double.compare(a, 0.3) == 0 ? "Es igual":"Distintos");
//		System.out.println(a + " + " + Double.parseDouble(String.format("%.15f", b).replace(',','.'))  + " = " + (a+b));
		// System.out.println((new BigDecimal(0.1+0.2)).setScale(16,
		// RoundingMode.HALF_DOWN).doubleValue());
		app.naipes();
//		app.vending();
	}

	/**
	 * Juego de “Adivina el número que estoy pensando”, un número del 1 al 100, ya
	 * te diré si es mayor o menor que el mío, pero tienes 10 intentos como mucho.
	 */
	public void juegoNumero() {
		final int numeroBuscado = (new Random()).nextInt(99) + 1;
		int numeroIntroducido;
		int intentos = 0;
		boolean encontrado = false;
		do {
			try {
				intentos += 1;
				out.print("Dame tu número del 1 al 100 (" + intentos + " de 10): ");
				out.print("[" + numeroBuscado + "]: ");
				numeroIntroducido = Integer.parseInt(teclado.nextLine());
				if (numeroBuscado == numeroIntroducido) {
					encontrado = true;
					break;
				} else if (numeroBuscado > numeroIntroducido) {
					out.println("Mi número es mayor.");
				} else {
					out.println("Mi número es menor.");
				}
			} catch (NumberFormatException e) {
				intentos--;
				out.println("No es un número.");
			}
		} while (intentos < 10 /* && !encontrado */);
		if (encontrado) {
			out.println("Bieeen!!! Acertaste.");
		} else {
			out.println("Upsss! Se acabaron los intentos, el número era el " + numeroBuscado + ".");
		}
	}

	public void juegoConClase() {
		BiConsumer<Object, NotificaEventArgs> cancel = (sender, arg) -> {
			out.println("¿Quieres cancelar?:");
			arg.setCancel("s".equals(teclado.nextLine()));
		};
		try {
			Juego<String> juego = new com.example.juegos.numero.JuegoDelNumero();
			juego.inicializar();
			((com.example.juegos.numero.JuegoDelNumero) juego).addNotificaListener((sender, arg) -> {
				out.println("NOTIFICA: " + arg.getMsg());
			});
			((com.example.juegos.numero.JuegoDelNumero) juego).addNotificaListener(cancel);
			for (int intentos = 1; intentos <= 10; intentos++) {
				out.print("Dame tu número del 1 al 100 (" + (juego.getJugadas() + 1) + " de 10): ");
				try {
					juego.jugada(teclado.nextLine());
//                    out.println(juego.getResultado());
					if (juego.getFinalizado()) {
						break;
					}
					if (intentos == 2)
						((com.example.juegos.numero.JuegoDelNumero) juego).removeNotificaListener(cancel);
				} catch (JuegoException e) {
					if (e.getCause() instanceof NumberFormatException) {
						out.println(e.getMessage());
					} else {
						throw e;
					}
				}
			}
		} catch (JuegoException e) {
			e.printStackTrace();
		}
		out.println("Juego finalizado");
	}

	public void decode(String expresion) {
		if (expresion == null || "".equals(expresion)
				|| !Character.isDigit(expresion.charAt(0)) /* || !expresion.endsWith("=") */) {
			throw new java.lang.IllegalArgumentException("No es una expresión valida");
		}
		String operando = "";
		for (int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			if (Character.isDigit(ch)) {
				operando += ch;
			} else if (ch == ',') {
				if (operando.indexOf(ch) == -1) {
					operando += ch;
//                    operando += '.';
//				} else {
//					 throw new Exception("Ya existe separador decimal.");
				}
			} else if ("+-*/%=".indexOf(ch) >= 0) {
				if (operando.endsWith(",")) {
					operando += "0";
				}
				System.out.println(operando + " " + ch);
				if (ch == '=') {
					break;
				}
				operando = "";
			} else if (ch != ' ') {
//				throw new Exception("Carácter no valido.");
			}
		}
	}

	public double calcula(String expresion) throws CalculadoraException, Exception {
		if (expresion == null || "".equals(expresion) || !Character.isDigit(expresion.charAt(0))) {
			throw new java.lang.IllegalArgumentException("No es una expresión valida");
		}
		String operando = "";
		Calculadora calculadora = new Calculadora();
		for (int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			if (Character.isDigit(ch)) {
				operando += ch;
			} else if (ch == ',') {
				if (operando.indexOf(ch) == -1) {
					operando += ch;
				} else {
					// throw new Exception("Ya existe separador decimal.");
				}
			} else if ("+-*/%=".indexOf(ch) >= 0) {
				if (operando.endsWith(",")) {
					operando += "0";
				}
				calculadora.calcula(operando, ch);
				System.out.println(operando + "\t" + ch + "\t" + calculadora.getAcumulado());
				if (ch == '=') {
					break;
				}
				operando = "";
			} else if (ch != ' ') {
//				throw new Exception("Carácter no valido.");
			}
		}
		System.out.println(calculadora.getAcumulado());
		return calculadora.getAcumulado();
	}

	public List<Calculadora.Operacion> decodeToList(String expresion) {
		if (expresion == null || "".equals(expresion) || !Character.isDigit(expresion.charAt(0))) {
			throw new java.lang.IllegalArgumentException("No es una expresión valida");
		}
		List<Calculadora.Operacion> resulatado = new ArrayList<>();
		String operando = "";
		for (int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			if (Character.isDigit(ch)) {
				operando += ch;
			} else if (ch == ',') {
				if (operando.indexOf(ch) == -1) {
					operando += ch;
//                } else {
//                     throw new Exception("Ya existe separador decimal.");
				}
			} else if ("+-*/%=".indexOf(ch) >= 0) {
				if (operando.endsWith(",")) {
					operando += "0";
				}
				resulatado.add(new Calculadora.Operacion(operando, ch));
				if (ch == '=') {
					break;
				}
				operando = "";
//            } else if (ch != ' ') {
//				throw new Exception("Carácter no valido.");
			}
		}
		return resulatado;

	}

	public void calculaList(String expresion) throws CalculadoraException, Exception {
		try {
			var operaciones = decodeToList(expresion);
			for (Calculadora.Operacion operacion : operaciones) {
				System.out.println(operacion.operando() + " " + operacion.operador());
			}
			System.out.println((new Calculadora()).calcula(operaciones));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}

	private void naipes() {
		var b = new BarajaFrancesa();

		try {
			System.out.println("Baraja\n-------------------------------");
			Arrays.stream(b.getCartas()).forEach(System.out::println);
			System.out.println("\nMazo\n-------------------------------");
			b.barajar();
			b.getMazo().forEach(System.out::println);
			var manos = b.reparte(4, 5);
			manos.forEach(item -> {
				System.out.println("\nJugador\n-------------------------------");
				item.forEach(System.out::println);
			});
			System.out.println("\nQuedan " + b.getMazo().size());
			b.reparte(4, 5).forEach(item -> {
				System.out.println("\nJugador\n-------------------------------");
				item.forEach(System.out::println);
			});
			System.out.println("\nQuedan " + b.getMazo().size());
			System.out.println("\nPide 2");
			var mano = b.reparte(1, 2);
			mano.forEach(item -> {
				System.out.println("Jugador (mano)\n-------------------------------");
				item.forEach(System.out::println);
			});
			System.out.println("\nQuedan " + b.getMazo().size());
			b.apilar(mano.get(0));
			System.out.println("\nApila " + mano.get(0).size());
			b.getMazo().forEach(System.out::println);
			// b.apilar(mano.get(0));
			// b.apilar(List.of(new NaipeFrances(NaipeFrances.Palos.CORAZONES, (byte)1)));
			System.out.println("\nQuedan " + b.getMazo().size());
			Map<NaipeFrances.Palos, List<NaipeFrances>> grupos = manos.get(0).stream()
					   .collect(Collectors.groupingBy(NaipeFrances::getPalo));
			manos.stream()			   
			   .forEach(jugador -> { 
				   System.out.println("\nJugador\n-------------------------------");
				   jugador.stream().collect(Collectors.groupingBy(NaipeFrances::getPalo))
				   	.forEach((p, c) -> System.out.println(p + ": " + c.size()));
				   });
			manos.stream()			   
			   .forEach(jugador -> { 
				   System.out.println("\nJugador\n-------------------------------");
				   jugador.stream().collect(Collectors.groupingBy(NaipeFrances::getLiteral))
				   	.forEach((p, c) -> System.out.println(p + ": " + c.size()));
				   });
			System.out.println("\nValores\n-------------------------------");
			System.out.println("La reina vale " + ValorNaipe.REINA.valorNumerico);
			System.out.println("El valor 12 es " + ValorNaipe.toEnum(12));
			
		} catch (JuegoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void vending() {
		var maquina = new Maquina();
		cotilla(maquina);
		maquina.vender("1", "1111", 1);
		maquina.vender("2", "2222", 2);
		maquina.vender("1", "1111", 3);
		maquina.vender("2", "2222", 3);
		cotilla(maquina);
		maquina.reiniciaCreditos();
		maquina.reponerTodo();
		cotilla(maquina);
	}

	private void cotilla(Maquina maquina) {
		System.out.println("Saldo");
		maquina.saldos().forEach(System.out::println);
		System.out.println("Stock");
		maquina.stock().forEach(System.out::println);
		System.out.println("Consumos");
		maquina.consumos().forEach(System.out::println);
	}

}
