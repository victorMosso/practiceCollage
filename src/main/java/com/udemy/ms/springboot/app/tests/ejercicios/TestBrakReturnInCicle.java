package com.udemy.ms.springboot.app.tests.ejercicios;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.udemy.ms.springboot.app.tests.ejercicios.streams.Cliente;

public class TestBrakReturnInCicle {

	private static final Logger log = LoggerFactory.getLogger(TestBrakReturnInCicle.class);

	public void testBreakInFor(List<Cliente> clientes, String persona) {
		log.info("Recorremos la lista con testBreakInFor() y testeamos que pasa cuando encuentra a: {}", persona);

		for (Cliente cliente : clientes) {
			log.info("Persona {}", cliente);
			if (cliente.getNombre().equals(persona)) {
				log.info("Encontramos a {}", cliente.getNombre().concat(" ").concat(cliente.getApellido()));
				break;
			}
			log.info("Seguimos buscando a {}", persona);
		}
		log.info("Fin del metodo testBreakInFor");

	}

	public void testReturnInFor(List<Cliente> clientes, String persona) {
		log.info("Recorremos la lista clientes con testReturnInFor() y testeamos que pasa cuando encuentra a: {}", persona);

		for (Cliente cliente : clientes) {
			log.info("Persona {}", cliente);
			if (cliente.getNombre().equals(persona)) {
				log.info("Encontramos a {}", cliente.getNombre().concat(" ").concat(cliente.getApellido()));
				return;
			}
			log.info("Seguimos buscando a {}", persona);
		}
		log.info("Fin del metodo testReturnInFor");
	}

}
