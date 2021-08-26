package com.udemy.ms.springboot.app.tests.ejercicios.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import com.udemy.ms.springboot.app.tests.ejercicios.interfaces.OperadorBinario;
import com.udemy.ms.springboot.app.tests.ejercicios.interfaces.OperadorUnario;

public class EjemplosLambda {

	private double miDouble = 5.0;
	private String miString = "Hola";
	
	public void testScopesLambda() {
		String miStringTemporal = "Buen dia";
		double miDoubleLocal = 11.0;
		
		UnaryOperator<Double> operacion1 = d -> {
			miDouble++;
			String miString = "Hola desde dentro de lambda";
			System.out.println("El valor de this.miString dentro de lambda es: "+this.miString);
			return d + miDouble;
		}; 
		
//		UnaryOperator<Double> operacion2 = d -> {
//			miDoubleLocal++;
//			return d + miDoubleLocal;
//		};
		
		UnaryOperator<String> operacion3 = s -> miString.concat(s);
		UnaryOperator<String> operacion4 = s -> miStringTemporal.concat(s);
		System.out.println(operacion1.apply(2.0));
		miString = "Adios";
//		miStringTemporal = "Buenas Noches";
		miDoubleLocal = 2.0;
		miDouble = 8.0;
		
		System.out.println(operacion1.apply(2.0));
	}
	
	public void exampleLambda() {
		OperadorUnario operador = x -> Math.sqrt(x);
		System.out.println("La raiz cuadrada de 4 es: "+operador.aplicar(4));
		
		OperadorBinario<Double> multiplicacion = (x, y) -> x*y;
		System.out.println("El resultado de multiplicar 5 * 6 es: "+multiplicacion.aplicar(5.0,6.0));
		
		OperadorBinario<Double> minimoComunMultiplo = (x,y) -> {			
			double mcm=0;
			if(x>y) {
				mcm = x;
			}else {
				mcm = y;
			}			
			while(mcm % x !=0 || mcm % y != 0) {
				mcm++;
			}			
			return mcm;
		};		
		System.out.println("El minimo comun multiplo de 12 y 9 es: "+minimoComunMultiplo.aplicar(12.0, 9.0));
	
		OperadorBinario<String> concatenarStrings = (x,y) -> x.concat(y);
		System.out.println("El resultado de concatenar Hola Mundo es: "+concatenarStrings.aplicar("Hola ", "Mundo"));
	}
	
	public void orderingWhitLambda() {
		List<String> lista = new ArrayList<>();
		lista.add("victor");
		lista.add("yani");
		lista.add("sandy");
		lista.add("liliana");		
//ordenamos la lista con java 7
		/*lista.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}			
		});		
		lista.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);				
			}			
		});*/
//	Usando Lambdas y referencia a metodos
		lista.sort((s1,s2) -> s1.compareTo(s2));
		lista.forEach(System.out::println);	
//		lista.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
			
	}
}
