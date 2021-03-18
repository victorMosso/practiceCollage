package com.udemy.ms.springboot.app.tests;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.ms.springboot.app.tests.ejercicios.genericos.MiClaseGenerica;
import com.udemy.ms.springboot.app.tests.ejercicios.herencias.Autor;
import com.udemy.ms.springboot.app.tests.ejercicios.herencias.Fulano;
import com.udemy.ms.springboot.app.tests.ejercicios.herencias.Programmer;
import com.udemy.ms.springboot.app.tests.ejercicios.herencias.TestMethodDefaultInterface;
import com.udemy.ms.springboot.app.tests.ejercicios.lambda.EjemplosLambda;
import com.udemy.ms.springboot.app.tests.ejercicios.streams.StreamsExamples;

@SpringBootApplication
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Main m = new Main();
//		m.testHashMap();
//		m.testListIndex();
//		m.testSwitch(4);
//	    testAbstractClass();   
//		testDefaultMethodInterface();
//		SubClase instancia = new SubClase();
//		Division div = new Division();
//		div.divisionEntreCero();
//		TestStringBuilder var = new TestStringBuilder();
//		var.stringBuilderIndexOd();
//		testGenericos();
//		TestWildCards wildCard = new TestWildCards();
//		wildCard.listasGenericas();
//		EjemplosLambda lambdas = new EjemplosLambda();
//		lambdas.exampleLambda();
//		lambdas.testScopesLambda();
//		lambdas.orderingWhitLambda();
//		EjemploReferenciaMetodos ejemplo = new EjemploReferenciaMetodos();
//		ejemplo.ejecutar();
		StreamsExamples strm = new StreamsExamples();
		strm.finalizadoresStreams();
//		MyThread th = new MyThread();
//		th.start();
//		System.out.println("one.");
//		th.start();
//		System.out.println("two.");
//		testMap();
 	}
	
	private void testAbstractClass(){
		Programmer.main();
		Programmer.writer();
		Autor.writer();
		Fulano.writer();	
		String mensaje = 
				"Ejecutamos un metodo static concreto de la clase abstracta a travez de una clase implementadora Programmer";
		System.out.println(mensaje);
		new Programmer().testMethod_writerofClassAbstract();
	}
	
	private void testDefaultMethodInterface() {
		TestMethodDefaultInterface instancia = new TestMethodDefaultInterface();
		instancia.defaultMethod();
	}
	
	private void testGenericos() {
		MiClaseGenerica<Integer> miClase = new MiClaseGenerica<>();
		miClase.setAtributoT(23);
		System.out.println(miClase.getAtributoT());
//Manda error de compilacion, en caso de no haber usado genericos mandaria error en tiempo de ejecucion.
//		String valor = (String)miClase.getAtributoT();		
	}
	
	private void arrays() {
		int[][] array = new int[2][3];
//		int array[][]= {{3,3,3,3},{11,11,11,11},{1,1,1,1}};
		System.out.println(array.length);
		System.out.println(array[1].length);
		array[0][0] = 5;
		array[0][1] = 5;
		array[0][2] = 5;
		array[1][0] = array[1][1] = array[1][2] =11;  
		
		for (int x=0; x < array.length; x++) {
			  for (int y=0; y < array[x].length; y++) {
			    System.out.println (array[x][y]);
			  }
		}
		
		Integer myArray[] = new Integer[5];
		System.out.println(myArray[4]);
	}
	
	private void testMap() {
		Map mapa = new HashMap();
		mapa.put(22,"valor");
		mapa.put(22, "v");
		mapa.put(1, "alan");
		System.out.println(mapa);
		System.out.println(mapa.size());
	}
	

}
