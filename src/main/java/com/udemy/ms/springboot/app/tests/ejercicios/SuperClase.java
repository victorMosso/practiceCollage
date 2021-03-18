package com.udemy.ms.springboot.app.tests.ejercicios;

public class SuperClase {

	SuperClase() {
		System.out.println("Constructror por default");
	}
	
	protected SuperClase(int num){
		System.out.println(String.format("Hola desde la super clase %s ", this.getClass().getSimpleName()));
	}
}
