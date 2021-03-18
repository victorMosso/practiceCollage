package com.udemy.ms.springboot.app.tests.ejercicios.herencias;

import com.udemy.ms.springboot.app.tests.ejercicios.interfaces.InterfaceDM_1;
import com.udemy.ms.springboot.app.tests.ejercicios.interfaces.InterfaceDM_2;

public class TestMethodDefaultInterface implements InterfaceDM_1,InterfaceDM_2{

	@Override
	public void defaultMethod() {
		InterfaceDM_1.super.defaultMethod();
	}
	
}
	


