package com.udemy.ms.springboot.app.tests.ejercicios.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.udemy.ms.springboot.app.tests.Application;

public class CreateReadWriteFileJDK7 {

	private Logger log = LoggerFactory.getLogger(CreateReadWriteFileJDK7.class);
	
	public void testCreateWriteReadFile() {
		Path pathFile = crearArchivo();
		if(Objects.nonNull(pathFile)){
			escribirArchivo(pathFile,"Me quiero cojer a: ");
			escribirArchivo(pathFile,"Alexis Texas");
			escribirArchivo(pathFile,"Bree Olson");
			escribirArchivo(pathFile,"Bryana Love");
			escribirArchivo(pathFile,"Simmone Peach");
			escribirArchivo(pathFile,"Lorena Sanchez");
			escribirArchivo(pathFile,"Mayara Shelson");
			escribirArchivo(pathFile,"Abella Danger");
			escribirArchivo(pathFile,"Annette Schwarz");
			leerArchivo(pathFile);	
		}
		
	}
	
	private Path crearArchivo() {
		Path path = null;
		try {
			path = Files.createFile(Files.createDirectories(getPath()).resolve("Santander_TAE_".concat(Application.getDateJDK8()).concat(".txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	private void escribirArchivo(Path pathFile, String mensaje) {
		try {
			FileWriter fw = new FileWriter(pathFile.toString(), true);
			PrintWriter pw = new PrintWriter(fw);
			pw.append(mensaje);
			pw.append("\n");
			pw.close();
			log.info("Se escribio el mensaje.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void leerArchivo(Path path) {
		BufferedReader br = null;
		String linea = null;
		try {
			br = new BufferedReader(new FileReader(path.toString()));
			
			try {				
				while(Objects.nonNull(linea = br.readLine())  ) {
					log.info(linea);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}		
	}
	
	public void eliminarArchivo() {
		
			log.info("Ruta del archivo a eliminar : "+getPath().toString());
			Path currentPath = Paths.get(getPath().toString()).toAbsolutePath().normalize();
			log.info("currentPath {}",currentPath);

			File file = currentPath.toFile();
			if(file.isDirectory()) {
				File[] files = file.listFiles();
				List<File> listFiles = Arrays.asList(files);
				log.info("Numero de archivos en la lista : " + listFiles.size());
				listFiles.stream().filter(f -> f.getName().toLowerCase().contains(Application.getDateJDK8()+".txt"))
				.forEach(f -> {
					 log.info("Se eliminara el archivo: {}",f.getName());
					
//					 try {
//						Files.deleteIfExists(f.toPath());
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
				});
			}
	}
	
	public Path testCreatePathEmpty() {
         String localPath = "";		
		 return Paths.get(localPath).toAbsolutePath();
	}
	
	public static Path getPath() {
		String sep = File.separator;
		
		Path path = Paths.get(sep+"springCloud"+sep+"workspace"+sep+"Udemy-Microservicios"+
				sep+"springboot.examples.test"+sep );
		return path;		
	}
}
