package com.udemy.ms.springboot.app.tests.ejercicios.streams;

public class Cliente {
	private String nombre;
	private String apellido;
	private String pais;
	private int edad;
	
	public Cliente(String nombre, String apellido, String pais, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.pais = pais;
	    this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		 return String.format("{Nombre:%s, Apellido:%s, Pais:%s, Edad:%d}", 
				 getNombre(), getApellido(), getPais(), getEdad());
	}	
}
