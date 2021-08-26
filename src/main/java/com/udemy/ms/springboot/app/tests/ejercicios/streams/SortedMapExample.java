package com.udemy.ms.springboot.app.tests.ejercicios.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class SortedMapExample {

	public void sortedMap() {
		Map<String, Integer> mapa = new HashMap<>();
		mapa.put("Tres", 3);
		mapa.put("Siete", 7);
		mapa.put("Ocho", 8);
		mapa.put("Seis", 6);
		mapa.put("Dos", 2);
		
		/*List<Entry<String, Integer>> listaEntry = new ArrayList<>(mapa.entrySet());
		
	    Collections.sort(listaEntry, (o1, o2) -> o1.getKey().compareTo(o2.getKey()) );
		
	    for(Entry<String, Integer> entry : listaEntry)
	    	System.out.println(entry.getKey()+" "+entry.getValue());*/
	    
//	    Ordenaremos el mapa con Streams
	    mapa.entrySet().stream()
//	    .sorted((e1,e2) -> e2.getKey().compareTo(e1.getKey())).forEach(System.out::println);
	    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
	    .forEach(System.out::println);
	    
	    System.out.println("***************************************");
	    mapa.entrySet().stream()
	    .sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
	    
	    Map<Cliente,Integer> map = new HashMap<>();
	    map.put(new Cliente("Alex", "Pereira", "Venezuela", 30), 30000);
	    map.put(new Cliente("Fabian", "Tapia", "Mexico", 34), 34000);
	    map.put(new Cliente("Edgardo", "Rivera", "Mexico", 24), 24000);
	    map.put(new Cliente("Jorge", "Espinosa", "Colombia", 50), 50000);
	    map.put(new Cliente("Sara", "Aguilar", "Peru", 40), 40000);
	    map.put(new Cliente("Rogelio", "Morales", "Chile", 55), 55000);
	    
	    System.out.println("***************************************");
	    map.entrySet().stream()
//	    .sorted(Map.Entry.comparingByKey((c1,c2) -> c1.getNombre().compareTo(c2.getNombre())))
	    .sorted(Map.Entry.comparingByKey(Comparator.comparing(Cliente::getNombre).reversed()))
//	    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	    .forEach(System.out::println);
	    
	}
}
