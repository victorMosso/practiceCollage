package com.udemy.ms.springboot.app.tests.ejercicios;

public class Division {
	
	public void divisionEntreCero() {
		System.out.println("Division");
		int numerador = 10;
		int resp;
		try {
		for(int z=2; z>=0; z--) {
			resp = numerador/z;
			System.out.println(resp);
		}
		}catch(Exception e) {			
			System.out.println("Exception e");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//No compila lo correcto seria colocarla antes de la excepcion general o en un throws
//		
//		catch(ArithmeticException ex) {
//			System.out.println("ArithmeticException ex");
//			System.out.println(ex.getMessage());
//		}
	}

}
