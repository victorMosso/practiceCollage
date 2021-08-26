package com.udemy.ms.springboot.app.tests.ejercicios;

import com.udemy.ms.springboot.app.tests.ejercicios.streams.Cliente;

public class Persona{
	private boolean isAlive;
	private Cliente cliente;
	
	public Persona() {}

	public Persona(boolean isAlive, Cliente cliente) {
		this.isAlive = isAlive;
		this.cliente = new Cliente(cliente.getNombre(), cliente.getApellido(),
				cliente.getPais(), cliente.getEdad());
	}

	public boolean isAlive() {
		return isAlive;
	}

	public Cliente getCliente() {
		return new Cliente(this.cliente.getNombre(),this.cliente.getApellido(),
				this.cliente.getPais(),this.cliente.getEdad());
	}

	@Override
	public String toString() {
		return this.cliente.toString() + "IsAlive : "+ this.isAlive;
	}

}
