package com.udemy.ms.springboot.app.tests.ejercicios.genericos;

import java.util.ArrayList;
import java.util.function.Consumer;

public class TestWildCards {

	public void listasGenericas() {
		Object miObjeto = new Object();
		Integer miInteger = 23;
		miObjeto = miInteger;
		Number miNumber = miInteger;
		
		ArrayList<Number> myListofNumbers = new ArrayList<>();
		myListofNumbers.add(miNumber);
		myListofNumbers.add(miInteger);
		myListofNumbers.add(10.0);
		
		ArrayList<Integer> myListofIntegers = new ArrayList<>();
		myListofIntegers.add(miInteger);
//		myListofIntegers.add(miNumber);
		
		iterarMiLista(myListofIntegers);
		iterarMiLista2(myListofNumbers);
	}
	
//	Acepta una lista de Number o una lista de cualquier subclase de Number (Integer,Float,Double, etc)
	private void iterarMiLista(ArrayList<? extends Number>  lista ) {
		System.out.println("iterarMiLista");
		lista.forEach(System.out::println);
	}
	
//	Acepta una lista de Integer o cualquier lista de superclases de Integer(Number,Object)
	private void iterarMiLista2(ArrayList<? super Integer> listaGenerica) {
		System.out.println("iterarMiLista2");
		listaGenerica.stream().forEach(i -> System.out.println(i));
	}
}
