package com.udemy.ms.springboot.app.tests.ejercicios.interfaces;

public interface InterfaceDM_2 {
	
	default public void defaultMethod() {
		String patron = "Hola soy el metodo por default de la interfaz %s";
		System.out.println(	String.format(patron," InterfaceDM_2") );
	}

}
