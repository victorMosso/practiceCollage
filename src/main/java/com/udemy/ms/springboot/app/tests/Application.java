package com.udemy.ms.springboot.app.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.ms.springboot.app.tests.ejercicios.Division;
import com.udemy.ms.springboot.app.tests.ejercicios.Main;
import com.udemy.ms.springboot.app.tests.ejercicios.Persona;
import com.udemy.ms.springboot.app.tests.ejercicios.TestBrakReturnInCicle;
import com.udemy.ms.springboot.app.tests.ejercicios.archivos.CreateReadWriteFileJDK7;
import com.udemy.ms.springboot.app.tests.ejercicios.archivos.ManejoArchivosJDK8;
import com.udemy.ms.springboot.app.tests.ejercicios.genericos.MiClaseGenerica;
import com.udemy.ms.springboot.app.tests.ejercicios.genericos.TestWildCards;
import com.udemy.ms.springboot.app.tests.ejercicios.herencias.Autor;
import com.udemy.ms.springboot.app.tests.ejercicios.herencias.Fulano;
import com.udemy.ms.springboot.app.tests.ejercicios.herencias.Programmer;
import com.udemy.ms.springboot.app.tests.ejercicios.herencias.TestMethodDefaultInterface;
import com.udemy.ms.springboot.app.tests.ejercicios.streams.Cliente;
import com.udemy.ms.springboot.app.tests.ejercicios.streams.SortedMapExample;
import com.udemy.ms.springboot.app.tests.ejercicios.threads.SaludarRunnable;
import com.udemy.ms.springboot.app.tests.ejercicios.threads.SaludarThread;

@SpringBootApplication
public class Application implements CommandLineRunner{

	Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public static String getDateJDK8() {
		LocalDate ld = LocalDate.now();		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		return ld.format(dtf);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		Main m = new Main();
//		m.testMap();
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
//		arrays();
//		TestWildCards wildCard = new TestWildCards();
//		wildCard.listasGenericas();
//		EjemplosLambda lambdas = new EjemplosLambda();
//		lambdas.exampleLambda();
//		lambdas.testScopesLambda();
//		lambdas.orderingWhitLambda();
//		EjemploReferenciaMetodos ejemplo = new EjemploReferenciaMetodos();
//		ejemplo.ejecutar();
//		StreamsExamples strm = new StreamsExamples();
//		strm.finalizadoresStreams();	
//		saludarThread();
//		saludarRunnable();
//		exampleInterruptThread();
//		testVariablesReferencia();
//		sortMapWithStream();
//		testFloorCeilAbsRound();
//		testJoinArrayBytes();
//		testDate(); 
//		testTimeJDK8("1978-06-23");
//		getDateJDK8();
//		testBreakInFor();
//		testBreakReturn();
//		testFechaActualMiliSec();
//      testCreatePathEmpty();
//      testCreateWriteReadFileJdk7();
//		testDeleteFileJdk7();
//		new ManejoArchivosJDK8().exampleFileSystem();
//		testCWRFilesJDK8(testCreatePathEmpty());
		testDeleteFilesJDK8(testCreatePathEmpty());
 	}
	
	private void testDeleteFilesJDK8(Path path) {
		ManejoArchivosJDK8 filesJdk8 = new ManejoArchivosJDK8();
		filesJdk8.eliminarArchivo(path);
		
	}
	
	private void testCWRFilesJDK8(Path path) {
		ManejoArchivosJDK8 filesJdk8 = new ManejoArchivosJDK8();
		filesJdk8.escribirArchivoJDK8(path);
		filesJdk8.leerArchivoJDK8();
	}
	
	private void testDeleteFileJdk7(){
		new CreateReadWriteFileJDK7().eliminarArchivo();
	}
	
	private void testCreateWriteReadFileJdk7() {
		new CreateReadWriteFileJDK7().testCreateWriteReadFile();
	}	
	
	private Path testCreatePathEmpty() {
		Path path = new CreateReadWriteFileJDK7().testCreatePathEmpty();
		System.out.println("Ejemplo de Path empty: "+path);
		return path;
	}
	private void testFechaActualMiliSec() {
		final long currentTimeJava8 = Instant.now().toEpochMilli();		
		final long currentTimeJava1 = System.currentTimeMillis();
		
		System.out.println("currentTimeJava8 : "+String.valueOf(currentTimeJava8));
		System.out.println("currentTimeJava1 : "+currentTimeJava1);
	}
	
	private void testBreakReturn() {
		TestBrakReturnInCicle tbr = new TestBrakReturnInCicle();
		tbr.testReturnInFor(getClientes(),"Alan");
		log.info("Regresamos al metodo main ahora invocaremos a : testBreakInFor()");
		tbr.testBreakInFor(getClientes(),"Alan");
		log.info("Regresamos al metodo main()");
	}
	
	private void testBreakInFor() {
		boolean response = false;
		List<Cliente> lista = getClientes();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getEdad() < 65) {
				System.out.println(lista.get(i));				
			}else {
				System.out.println("Webooooos un menor de edad");
				response = true;
				return;
			}
			
		}
		
		if(!response) {
			System.out.println("Ejecuta el if fuera del for");
		}
		System.out.println("Fin del metodo");
	}
	
	private void testTimeJDK8(String fecha) {
		LocalDateTime ldt = LocalDateTime.parse(fecha.concat("T00:00:01"));
		System.out.println(ldt);
		testRetriveLDT(ldt.minusHours(5));
		System.out.println(ldt);
		System.out.println(LocalDateTime.now());
		
	}
	
	private void testRetriveLDT(LocalDateTime ldt) {
		System.out.println(ldt);
	}
	
	private void testDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		
		String fecha = "2021-06-01:00:00:01";
		
		System.out.println(sdf.format(new Date()));
		try {
			System.out.println(sdf.format(sdf.parse(fecha)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void testJoinArrayBytes() {
		String contentType = "application/json";
		String date = new Date().toLocaleString();
		String MD5 = null;
		
		final String cannonicalName = String.join(",",contentType, (MD5==null)?"":MD5,date);
		byte[] user = "valorDelApiKey:".getBytes();
		byte[] pass = cannonicalName.getBytes();
		//Concatenamos el array de Bytes
		byte[] userPass = new byte[pass.length+user.length];
		System.arraycopy(user, 0, userPass, 0, user.length);
		System.arraycopy(pass, 0, userPass, user.length, pass.length);
//		Codificamos en Base64
		
		byte[] auth = Base64.getEncoder().encode(userPass);
		log.info("auth en base 64 ".concat(new String(auth,StandardCharsets.UTF_8)));
		log.info("auth en texto plano ".concat(new String(Base64.getDecoder().decode(auth),StandardCharsets.UTF_8)));
	}
	private void testFloorCeilAbsRound() {
		System.out.println("Math.floor(19.4): "+Math.floor(19.4));
		System.out.println("Math.ceil(19.4): "+Math.ceil(19.4));
		System.out.println("Math.round(19.4): "+Math.round(19.4));
		System.out.println("Math.abs(19.4): "+Math.abs(19.4));
		
		int i = 12312;
		long l = 1010239L;		
		float f = 12349.9F;
		double d = 79048030480340.8990D;
		boolean b = true;
		char c = 'c';
		byte by = 1;
		short s = 25531;		
	}
	
	private void sortMapWithStream() {
		SortedMapExample sMapEx = new SortedMapExample();
		sMapEx.sortedMap();
	}
	
	private void testVariablesReferencia() {
		Cliente clOriginal = new Cliente("Fulanito","deTal","Argenita", 35);
		Persona persona = new Persona(true,clOriginal);
		System.out.println("HashCode persona : "+persona.hashCode());
		System.out.println(persona.toString());
		
		persona.getCliente().setApellido("Fardero");
//		No se refleja el cambio porque el objeto persona esta protegido, se programo
//		como inmutable
		System.out.println(persona.toString());
		
		Persona persona2 = new Persona();
		System.out.println("HashCode persona2 : "+ persona2.hashCode());
		persona2 = persona;
		System.out.println("HashCode persona2 : "+ persona2.hashCode());
		
//		Modificamos el cliete original y esto no se refleja en la propiedad cliente 
//		porque el objeto Persona es inMutable
		clOriginal.setEdad(5);
		clOriginal.setNombre("Hijito Bastardo");
		System.out.println(persona.toString());
	}
	
	private void exampleInterruptThread() {
		Thread th1 = new Thread(new SaludarRunnable(2000),"Hilo_1");		
		Thread th2 = new Thread(new SaludarRunnable(2000),"Hilo_2");
		log.info(String.format("Estado %s del %s",th2.getState().name(),th2.getName()));
		log.info(String.format("Estado %s del %s",th1.getState().name(),th1.getName()));
		th2.start();
		log.info(String.format("Estado %s del %s",th2.getState().name(),th2.getName()));
		th1.start();		
		log.info(String.format("Estado %s del %s",th1.getState().name(),th1.getName()));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		th2.interrupt();
				
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info(String.format("Estado %s del %s",th2.getState().name(),th2.getName()));
		th1.interrupt();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info(String.format("Estado %s del %s",th1.getState().name(),th1.getName()));
	}
	
	private void saludarRunnable(){
		Thread th = new Thread(	
			() -> {
				log.info("Hola desde Runnable _ " + Thread.currentThread().getName());
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log.info("Adios desde la Runnable _ "+ Thread.currentThread().getName());
			}, "hilo2"
		);
		
		log.info(String.format("Estado %s del %s: ",th.getState().name(),th.getName()));
		th.start();
		try {
			log.info(String.format("Estado %s del %s: ",th.getState().name(),th.getName()));
			Thread.sleep(3000);
			log.info(String.format("Estado %s del %s: ",th.getState().name(),th.getName()));
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info(String.format("El %s ¿sigue vivo? : %s",th.getName(),th.isAlive()));
		log.info(String.format("Estado %s del %s: ",th.getState().name(),th.getName()));
		
//		Implementacion de la interfaz Runnable por medio de una clase anonima.
		Runnable thRunnable = new Runnable() {
			
			@Override
			public void run() {
				log.info("Hola Cabron... ponte las pinches pilas..");				
			}
		};
		thRunnable.run();
		
		Thread th2 = new Thread(thRunnable);
		th2.start();
	}
	
	private void saludarThread() {
		SaludarThread sT = new SaludarThread();
		log.info("State: "+sT.getState().name());
		sT.start();
	}
	
	private void arrays() {
		int[][] array = new int[3][3];
//		int array[][]= {{3,3,3},{11,11,11},{1,1,1}};
		System.out.print("Hola ");
		System.out.println("Filas del Array: "+array.length);
		System.out.println("Columnas en la fila 2: "+array[1].length);
//		3 Formas de poblar un array
		array[0][0] = 5;
		array[0][1] = 5;
		array[0][2] = 5;
		
		array[1][0] = array[1][1] = array[1][2] =11;  
		
		for(int x=0;x<array[2].length;x++) {
			array[2][x]=8;
		}
		
		for (int x=0; x < array.length; x++) {
			  for (int y=0; y < array[x].length; y++) {
			    System.out.print(array[x][y] + " ");
			  }
			  System.out.print("\n");
		}
		
		Integer myArray[] = new Integer[5];
		System.out.print(myArray[0]);
	}
	
	private void testGenericos() {
		MiClaseGenerica<Integer> miClase = new MiClaseGenerica<>();
		miClase.setAtributoT(23);
		System.out.println(miClase.getAtributoT());
//Manda error de compilacion, en caso de no haber usado genericos mandaria error en tiempo de ejecucion.
//		String valor = (String)miClase.getAtributoT();		
	}
	
	private void testDefaultMethodInterface() {
		TestMethodDefaultInterface instancia = new TestMethodDefaultInterface();
		instancia.defaultMethod();
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
	
	private ArrayList<Cliente> getClientes(){
		ArrayList<Cliente> listCliente= new ArrayList<Cliente>();
		listCliente.add(new Cliente("Sandra","Mosso","Mexico",18));
		listCliente.add(new Cliente("Cynthia","Mosso","Argentina",34));
		listCliente.add(new Cliente("Liliana","Rincon","Peru",36));
		listCliente.add(new Cliente("Alan","Cruz","Colombia",35));
		listCliente.add(new Cliente("Victor","Mosso","Mexico",42));
		listCliente.add(new Cliente("Angel","Mosso","Argentina",20));
		listCliente.add(new Cliente("Lilia","Cruz","Peru",65));
		listCliente.add(new Cliente("Daniel","Sanchez","Mexico",46));
		listCliente.add(new Cliente("Aldo","Gines","Brasil",20));
		return listCliente;
	}
}
