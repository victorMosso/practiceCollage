package com.udemy.ms.springboot.app.tests.ejercicios.threads;

public class SaludarThread extends Thread{

	@Override
	public void run() {
		System.out.println("Hola desde clase que extiende de Thread _ "+getName());		
	}

}
