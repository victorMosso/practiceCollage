package com.udemy.ms.springboot.app.tests.ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public void testHashMap() {
		Map<String, Integer> mapa = new HashMap<>();
		mapa.put("manzanas", 3);
		mapa.put("naranjas", 2);
		
		int num = mapa.get("manzanas");
		mapa.put("manzanas", num+4);
		System.out.println(mapa.get("manzanas"));
	}
	
	public void testListIndex() {
		List<Integer> myList = new ArrayList<>();
		myList.add(10);
		try {
		int valorElemento = myList.get(1);
		String patron = "El valor del indice 1 en la lista es %d";
		System.out.println(String.format(patron, valorElemento));
		}catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void testSwitch(int valor) {
		int condicion = valor;
		
		switch(condicion) {
		case 4: case 5: case 6: case 7: case 8: 
		System.out.println("Hola");	
	
		case 9: case 10: case 11:
			System.out.println("mundo");
		
		case 15: case 16:
			System.out.println("Envoltorio");
		break;
		default:
		System.out.println(String.format("el valor mandado es: %d", valor));
		break;
		}
	}
}
