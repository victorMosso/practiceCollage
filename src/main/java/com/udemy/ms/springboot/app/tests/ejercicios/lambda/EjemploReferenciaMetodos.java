package com.udemy.ms.springboot.app.tests.ejercicios.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class EjemploReferenciaMetodos {
	
	public void ejecutar() {
//		BinaryOperator<Integer> suma = (x,y)->x+y;		
//		Siempre que podamos remplazaremos las expresiones lambda por Referencia a Metodos		
		BinaryOperator<Integer> suma = Sumar::sum;
		System.out.println("La suma de 3 + 7 es: "+suma.apply(3, 7));
//		Usaremos el constructor de String para implementar la interfaz funcional UnaryOperator<T>
		UnaryOperator<String> miCadena = String::new;
		System.out.println("Mi cadena es: "+miCadena.apply("Victor"));
		System.out.println("Mi otra cadena es: "+miCadena.apply("Andres"));
//		Implementaremos la interfaz funcional Supplier<T>
		String cadena = "Este texto sera convertido a mayusculas";
		Supplier<String> mayusculas = cadena::toUpperCase; 
		System.out.println("La cadena en mayusculas es: "+mayusculas.get());
//		Implementaremos la interfaz funcional Function<T,R>
		Function<Float, String> valorCadenatoBoolean = String::valueOf;
		System.out.println("Valor cadena del foat 2.3: "+valorCadenatoBoolean.apply(2.3F));
		System.out.println("Equals");
		
	}
	
	

}
