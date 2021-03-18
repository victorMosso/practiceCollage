package com.udemy.ms.springboot.app.tests.ejercicios.herencias;

public class Programmer extends MyAbstractClass {

	public static void writer() {
		System.out.println(String.format("Programmer says.. %s", " I am writing code.."));
	}
	
//Forma incorrecta de ejecutar el metodo Static de la superClase
	public static void main() {
		MyAbstractClass varRef = new Programmer();
		varRef.writer();		
	}
	
//La forma correcta es acceder al metod static por medio del operador punto
	public void testMethod_writerofClassAbstract() {
		MyAbstractClass.writer();
	}
}
