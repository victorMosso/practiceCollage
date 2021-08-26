package com.udemy.ms.springboot.app.tests.ejercicios;

public class ExampleError {
	
	public static void stringReplace(String param) {
		param = param.replace('j', 'k');
		System.out.println(param);
	}
	
	public static void bufferReplace(StringBuffer sb) {
		sb = sb.append("K");
		sb.insert(1, "-");
		System.out.println("Substring "+sb.substring(1, 3));
	}
	
	public static void main(String[] args) {
		String cadena = "java";
		StringBuffer buffer = new StringBuffer("java");
		stringReplace(cadena);
		bufferReplace(buffer);
		System.out.println(cadena+buffer);
	}
	
	
}
