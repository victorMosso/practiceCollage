package com.udemy.ms.springboot.app.tests.ejercicios.interfaces;

@FunctionalInterface
public interface OperadorBinario<T> {

//	Usaremos genericos para que acepte cualquier valor como parametros
	public T aplicar(T x, T y);
}
