package com.udemy.ms.springboot.app.tests.ejercicios.herencias;

public class ClaseB extends ClaseA{

	void myMethod() {

		System.out.println("Hi ClaseB");
	}
	
	void otroMetodo() {
		System.out.println("Otro metodo de la ClaseB");
	}
	

	
	public static void main(String args[]) {
//		Error en tiempo de ejecucion
//		ClaseB objeto = (ClaseB) new ClaseA();
//		Error en tiempo de compilacion
//		ClaseB objeto = new ClaseA();
		ClaseA objeto = new ClaseB();
		objeto.myMethod();
	}
}
