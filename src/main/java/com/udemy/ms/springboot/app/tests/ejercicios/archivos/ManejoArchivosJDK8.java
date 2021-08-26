package com.udemy.ms.springboot.app.tests.ejercicios.archivos;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManejoArchivosJDK8 {

	private Logger log = LoggerFactory.getLogger(ManejoArchivosJDK8.class);
	
	public void leerArchivoJDK8() {
		try {
			String contenido = new String(Files.readAllBytes(CreateReadWriteFileJDK7.getPath().resolve("Santander_20210819_bajas.txt")) );
			log.info("El contenido del archivo es: {}",contenido);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void escribirArchivoJDK8(Path path) {
		CustomWriter customWriter = new CustomWriter(path);
		
		try {
			customWriter.init();
			customWriter.write("WEBOOOS");
			customWriter.write("don VERGAS");
			customWriter.write("cara de chile");
			if( customWriter instanceof Closeable) {
				close((Closeable)customWriter);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void close(Closeable closeable) {
		try {
			closeable.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void eliminarArchivo(Path path) {
		log.info("Inicia busqueda de archivos a eliminar..");
		List<File> archivos = Arrays.asList(path.toFile().listFiles());
		
		List<File> filesToDelete = new ArrayList<>();
		filesToDelete = archivos.stream()
		.filter(f -> (f.getName().contains("bajas") && f.getName().toLowerCase().endsWith(".txt")) )
		.collect(Collectors.toList());
		
		filesToDelete.forEach(f -> log.info("Se eliminara el archivo: {}",f.getName()));
	}
	
	public void exampleFileSystem() {
		FileSystem fs = FileSystems.getDefault();
		Path path = fs.getPath(CreateReadWriteFileJDK7.getPath().toString());
		System.out.println(path);
		System.out.println(path.getParent());
		Iterator<Path> iter = path.iterator();
		while(iter.hasNext()) {
			path = iter.next().toAbsolutePath();
			
			if(path.toFile().isDirectory()) {
				log.info("Es un directorio {}",path.toString());
				Arrays.asList(path.toFile().listFiles()).stream()
				.forEach(f -> System.out.println(f.getName()));
			}else {
				log.info("No es un directorio valido {}",path.toString());
			}
		}
	}
	
	
}
