package com.udemy.ms.springboot.app.tests.ejercicios;

public class TestStringBuilder {
	
	public void stringBuilderIndexOd() {
		StringBuilder sb = new StringBuilder();
		sb.append("Java");
		System.out.println(String.format("length(): %d", sb.length()));
		System.out.println(String.format("capacity: %d", sb.capacity()));
		String var = "Love";
		sb.append(var);
		System.out.println(String.format("Valor de la cadena: %s", sb.toString()));
		sb.substring(4);
		System.out.println(String.format("Valor despues del subString(4): %s", sb.toString()));
		int indice = sb.indexOf(var);		
		System.out.println(String.format("Valor despues de indexOf(\"Love\"): %d",indice));
		sb. insert(4, indice);
		System.out.println(String.format("Valor de la cadena despues del insert(4,indice): %s", sb.toString()));
	}

}
