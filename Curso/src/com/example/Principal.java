package com.example;

import java.io.Serial;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import com.example.exceptions.GraficosException;
import com.example.util.Autor;
import com.example.Calculadora;
import com.example.contracts.Grafico;
import com.example.contracts.PersonasRepository;

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
		try {
//			reflexion("com.example.Calculadora", "calc");
//			reflexion("com.example.Falsa", "divide");
			consultas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void paralelos() {
		List<Integer> listOfIntegers = List.of(22,23,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		System.out.println("Sequential Stream: ");
		listOfIntegers.stream().parallel().map(v -> v*v).sequential().sorted().forEach(e -> System.out.print(e + " "));
		System.out.println("\nParallel Stream: ");
		listOfIntegers.parallelStream().map(v -> v*v).sequential().sorted().forEach(e -> System.out.print(e + " "));

	}

	public static void consultas() throws Exception {
		PersonasRepository dao = new PersonasRepositoryMock();
		dao.add(new Profesor(22, "El", "Nuevo", LocalDate.of(1969, 9, 9), true, 1000));
		var copia = dao.getAll();
		dao.getAll().forEach(System.out::println);
		((Profesor) copia.get(0)).setSalario(1000);
		System.out.println("Consulta");
//		double acumulado = 0;
//		for(var item: dao.getAll()) {
//			if(item instanceof Profesor p) {
//				acumulado = acumulado + p.getSalario();
//			}
//		}
//		System.out.println("Total salario: " + acumulado);	
		System.out.println("Total salario: " + dao.getAll().stream().filter(item -> item instanceof Profesor)
//					.map(item -> ((Profesor)item).getSalario())
//					.reduce(1000.0, (acumulado, p) -> acumulado + p )
//					.reduce(999990.0, (acumulado, p) -> acumulado < p ? acumulado : p )
				.map(item -> ((Profesor) item))
				.peek(item -> System.out.println(item.getId() + ": " + item.getSalario()))
				.reduce(null, (actual, p) -> actual == null || actual.getSalario() < p.getSalario() ? p : actual));
		System.out.println("Total salario: " + dao.getAll().stream().filter(item -> item instanceof Profesor)
				.mapToDouble(item -> ((Profesor) item).getSalario()).average());
		System.out.println("Mayor salario: " + dao.getAll().stream().filter(item -> item instanceof Profesor)
				.map(item -> ((Profesor) item)).max((a, b) -> -Double.compare(a.getEdad(), b.getEdad())));
		System.out.println("Mayor salario: " + dao.getAll().stream().filter(new Predicate<Persona>() {
			@Override
			public boolean test(Persona item) {
				return item instanceof Profesor;
			}
		}).map(new Function<Persona, Profesor>() {

			@Override
			public Profesor apply(Persona item) {
				return ((Profesor) item);
			}
		}).max(new Comparator<Profesor>() {
			@Override
			public int compare(Profesor a, Profesor b) {
				return -Double.compare(a.getEdad(), b.getEdad());
			}
		}));
		boolean soloProfes = false, confictivos = true, paginado = false;
		int page = 1, rows = 2;
		var flujo = dao.getAll().stream().filter(item -> item.hasFechaNacimiento())
				.sorted((a, b) -> -a.getEdad() + b.getEdad());
		if (soloProfes)
			flujo = flujo.filter(item -> item instanceof Profesor);
		if (paginado)
			flujo = flujo.skip(page * rows).limit(rows);
		flujo.forEach(System.out::println);
//		flujo.forEach(System.out::println);
		//
//		.forEach(item -> System.out.println(item.getSalario()));
//		dao.getAll().stream()
//			.filter(item -> item instanceof Profesor)
//			.map(item -> ((Profesor)item))
//			.
//			.forEach(item -> System.out.println(item.getSalario()));
	}

	public static void colecciones() throws Exception {
		var list = List.of(new Profesor(2, "Uno", 1000), new Profesor(2, "Otro", 1000));
		System.out.println(list.get(0).equals(list.get(1)) ? "equals" : "no equals");
		System.out.println(list.get(0).hashCode() == list.get(1).hashCode() ? "hashCode" : "no hashCode");
		System.out.println(list.get(0).compareTo(list.get(1)) == 0 ? "compareTo" : "no compareTo");
		System.out.println(list.get(0).compareTo(list.get(1)));
		var conjunto = new HashSet<>();
		conjunto.addAll(list);
		System.out.println(conjunto.size());
		var inmutable = Collections.unmodifiableSet(conjunto);
		System.out.println(inmutable.size());
//		inmutable.add(new Profesor(3, "Uno", 1000));
//		System.out.println(inmutable.size());
		PersonasRepository dao = new PersonasRepositoryMock();
		dao.getAll().forEach(System.out::println);
		dao.add(new Profesor(22, "Ejemplo add", 1000));
//		var item = dao.getOne(1);
//		if(item.isPresent()) {
//			var p = item.get();
//			p.setNombre(p.getNombre().toUpperCase());
//			dao.modify(p);
//		}
//		dao.deleteById(6);
//		dao.getAll().forEach(System.out::println);
		dao.getAll().stream().filter(item -> item instanceof Profesor).forEach(System.out::println);
	}

	public static void biblioteca() throws Exception {
		String cad = "";
		for (var i = 0; i < 100; i++) {
			cad += "X";
		}
		System.out.println(cad);
		boolean a = false;
		// ...
		if (!a) {
		}
		StringBuilder sb = new StringBuilder("");
		for (var i = 0; i < 100; i++) {
			sb.append("X");
		}
		System.out.println(sb.toString());

	}

	public static void anotaciones() throws Exception {
		for (var a : com.example.Calculadora.class.getAnnotations())
			System.out.println(a.annotationType().getName());
		System.out.println(com.example.Calculadora.class.getAnnotation(Autor.class).nombre());
		System.out.println(Profesor.class.getAnnotation(Autor.class).nombre());
	}

	public static void reflexion(String clase, String metodo) throws Exception {
		Class tipo = Class.forName(clase);
		Object object = tipo.newInstance();
		var m = tipo.getMethod(metodo, String.class, Character.TYPE);
		System.out.println(m.invoke(object, "3", '+'));
		System.out.println(m.invoke(object, "2", '='));
	}

	public static void reflexion() throws Exception {
		var clase = "com.example.Calculadora";
		var metodo = "calc";
		Class tipo = Class.forName(clase);
		Object object = tipo.newInstance();
		for (var cmp : tipo.getDeclaredFields())
			System.out.println(cmp.getName());
		Field cmp = tipo.getDeclaredField("acumulado");
		cmp.setAccessible(true);
		System.out.println(cmp.get(object));
		cmp.set(object, new BigDecimal(-1));
		System.out.println(cmp.get(object));
		for (var m : tipo.getMethods()) {
			System.out.println(m.getName());
			if (m.getName().equals(metodo)) {
				System.out.println(m.invoke(object, "3", '+'));
				System.out.println(m.invoke(object, "2", '='));
			}
		}
		for (var m : tipo.getDeclaredFields()) {
			System.out.println(m.getName());
		}

//		var m = tipo.getMethod(null, null)
	}

	public static void registros() throws Exception {
		var p1 = new Coordenada(10, 10);
		System.out.println(p1);
		System.out.println(p1.getX() + ":" + p1.getY());
		var p2 = new Punto(11, 11);
		System.out.println(p2);
		System.out.println(p2.x() + ":" + p2.y());
		System.out.println(p2.resta(new Punto(2, 2)));
		System.out.println(p2.resta(1));
		System.out.println(p2);
	}

	public static double divide(double a, double b) {
		return a / b;
	}

	public static double calcula(double a, double b, BinaryOperator<Double> calc) {
		return calc.apply(a, b);
	}

	@Deprecated
	public static class Calculadora {
		public double suma(double a, double b) {
			return a + b;
		}

		public double divide(double a, double b) {
			return a / b;
		}

		public String divide(String a, char b) {
			return "Hola mundo";
		}

	}

	public static void delegados() throws Exception {
		BinaryOperator<Double> op = (a, b) -> a + b;

		System.out.println(calcula(2.0, 3.0, op));
		op = (a, b) -> a * b;
		System.out.println(calcula(2.0, 3.0, op));
		System.out.println(calcula(2.0, 3.0, (a, b) -> {
			double rslt;
			rslt = a - b;
			return rslt;
		}));
		System.out.println(calcula(2.0, 3.0, (a, b) -> a - b));
		System.out.println(calcula(2.0, 3.0, new BinaryOperator<Double>() {
			@Override
			public Double apply(Double a, Double b) {
				return a - b;
			}
		}));

		System.out.println(calcula(2.0, 3.0, Principal::divide));
		var c = new Calculadora();
		System.out.println(calcula(2.0, 3.0, c::suma));
		System.out.println(calcula(2.0, 3.0, c::divide));
		var t = List.of(1, 2, 3);
		t.forEach(System.out::println);
		t.forEach(item -> {
			System.out.println(item);
		});
		var list = List.of(new Profesor(1, "Uno", 1000), new Profesor(2, "Otro", 1000));
		BiConsumer<Object, String> ev = (o, m) -> {
			System.out.println(((Persona) o).getNombre() + " " + m);
		};
		list.forEach(item -> item.addNotificacionListener(ev));
		list.forEach(Profesor::pinta);
		list.get(0).setFechaNacimiento("1955-10-01");
		list.get(0).jubilate();
		list.forEach(item -> {
			item.pinta();
		});
		list.get(1).removeNotificacionListener(ev);
		list.get(1).setFechaNacimiento("1950-10-01");
		list.get(1).jubilate();

	}

	public static void genericos() {
//		EjemplosGenericos.Elemento e = new EjemplosGenericos.(28, "Madrid");
//		e = new EjemplosGenericos.Elemento("8", "Barcelona");
//		e.setKey('8');
//		e.setKey(8);
//		EjemplosGenericos.ElementoInt e2 = new EjemplosGenericos.ElementoInt(28, "Madrid");
//		e2.setKey("8");
//		e2 = new EjemplosGenericos.ElementoInt("8", "Barcelona");
		EjemplosGenericos.Elemento<Integer, String> e = new EjemplosGenericos.Elemento(28, "Madrid");
		e = new EjemplosGenericos.Elemento("8", "Barcelona");
		e.setKey(8);
		EjemplosGenericos.Elemento<Character, String> s = new EjemplosGenericos.Elemento('H', "Hombre");
		s.setKey('8');
		Object o = s;
		if (o instanceof EjemplosGenericos.Elemento ele && ele.getKey() instanceof Integer) {

		} else if (o instanceof EjemplosGenericos.Elemento ele && ele.getKey() instanceof Integer) {

		}
//		EjemplosGenericos.Elemento<Integer, Profesor> e = new EjemplosGenericos.Elemento(28, new Profesor());
//		e = new EjemplosGenericos.Elemento(28, new Alumno());
		try (var p = new Profesor()) {
			System.out.println(p.generico("kk"));
			p.setId(-1);
			System.out.println(p.getEdad());
			System.out.println(p.generico(5));
			System.out.println(p.generico(true));
		} catch (DateTimeException ex) {
			System.out.println("especifica: " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Fin");
//		o = p.sinParam(Persona.class);
		o = 4; // new Integer(4)
		int i = (int) o + 4; // o.value
	}

	public static void intefaces() throws Exception {
		Grafico grafico = new Factura(666);
//		try {
//			grafico.pintate();
//		} catch (GraficosException ex) {
////			throw new Exception("No puedo pintar", ex );
//			System.out.println("Error");
//			throw ex;
//		}
//		grafico.dimeTuClase();
//		((GraficoPersistente)grafico).dimeTuClase();
		var p = new Profesor(1, "Pepito", 1000);
		p.setFechaNacimiento("2023-07-01");
		grafico = p;
		var a = ((Profesor) grafico).getApellidos();

		if (a.isPresent())
			System.out.println(a.get());
		else {
			System.out.println("No tiene apellidos");
		}
		var n = ((Profesor) grafico).getNombre();
		if (n != null) {

		}
		if (p.hasFechaNacimiento()) {
			var f = p.getFechaNacimiento();
		}

		grafico.pintate();
		grafico.dimeTuClase();
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
		Factura l = new Fact(1234), ll = new Fact(234);

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
		// p.setFechaNacimiento(LocalDate.of(2030, 6, 30));
		Persona.Asignatura asignatura = new Persona.Asignatura();
	}

	public static void enumerados() {
		DiasDeLaSemana dia = DiasDeLaSemana.LUNES;
		DiasLaborables x = DiasLaborables.LUNES;
		Factura.Estado estado = Factura.Estado.PENDIENTE;

		if (dia.toLaborable() == DiasLaborables.LUNES) {
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
