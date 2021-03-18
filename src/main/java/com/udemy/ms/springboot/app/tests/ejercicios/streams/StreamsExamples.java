package com.udemy.ms.springboot.app.tests.ejercicios.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamsExamples {
	Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	public void streamsIsInMutable() {
		ArrayList<Cliente> lista = getClientes();
		lista.stream()
				.filter(c -> c.getNombre().startsWith("L"))
		        .forEach(c -> log.info(c.toString()));
		log.info("Stream Original");		
		lista.stream()
		.sorted((c1,c2) -> c1.getNombre().compareTo(c2.getNombre()))
		.forEach(System.out::println);		
	}	
	
	public void twoFilters() {
		ArrayList<Cliente> lista = getClientes();
		long total = lista.stream()
			.filter(c -> c.getPais().equals("Mexico"))
			.peek(c->log.info("Clientes que son de Mexico: "+c.getNombre()))
			.filter(c -> c.getApellido().endsWith("o"))
			.peek(c -> log.info("Clientes que son de Mexico y su apellido es termina en 'o': "+c.toString()))
			.count();
		log.info("Total de clientes que son de Mexico y su apellido termina en 'o':"+total);
	}
	
	public void exampleMap() {
		 List<Cliente> listaClientes = getClientes();
		 List<String> lista = listaClientes.stream()
				 .map(c -> c.getNombre().toUpperCase())
				 .filter(s -> s.contains("A"))
				 .sorted()
				 .collect(Collectors.toList());
		 lista.stream().forEach(log::info);

		 log.info("Tamaño del la lista de clientes: "+listaClientes.size());
	}
	
	public void finalizadoresStreams() {
		List<Cliente> listaClientes = getClientes();
		LongStream lStrm = listaClientes.stream().mapToLong(c -> c.getEdad());
		
//		log.info("Total de edades: "+lStrm.count());
	    
//		log.info("Algun numero de la lista es mayor a 20? "+lStrm.anyMatch(e -> e>20));
		
//		log.info("La suma de las edades es: "+lStrm.sum());

//		OptionalLong producto = lStrm.reduce((e1,e2) -> e1*e2);
//		log.info("Resultado de la multiplicacion de las edades: "+producto.getAsLong());

		lStrm.distinct().sorted().forEach(n -> log.info("Edades sin duplicar: "+n));		
	}

	private ArrayList<Cliente> getClientes(){
		ArrayList<Cliente> listCliente= new ArrayList<Cliente>();
		listCliente.add(new Cliente("Sandra","Mosso","Mexico",18));
		listCliente.add(new Cliente("Cynthia","Mosso","Argentina",34));
		listCliente.add(new Cliente("Lilina","Rincon","Peru",36));
		listCliente.add(new Cliente("Alan","Cruz","Colombia",35));
		listCliente.add(new Cliente("Victor","Mosso","Mexico",42));
		listCliente.add(new Cliente("Angel","Mosso","Argentina",20));
		listCliente.add(new Cliente("Lilia","Cruz","Peru",65));
		listCliente.add(new Cliente("Daniel","Sanchez","Mexico",46));
		listCliente.add(new Cliente("Aldo","Gines","Brasil",20));
		return listCliente;
	}
}
