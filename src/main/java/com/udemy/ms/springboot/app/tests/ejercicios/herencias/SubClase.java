package com.udemy.ms.springboot.app.tests.ejercicios.herencias;

import com.udemy.ms.springboot.app.tests.ejercicios.SuperClase;

public class SubClase extends SuperClase {

	public SubClase(){
		super(10);
		System.out.println(this.getClass().getSimpleName());
	}
	
}
