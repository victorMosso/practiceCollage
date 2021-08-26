package com.udemy.ms.springboot.app.tests.ejercicios.archivos;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CustomWriter implements Closeable {

	private BufferedWriter bwriter;
	private Path path;

	public CustomWriter(Path path) {
		this.path = path;		
	}

	public void init() throws IOException {
		OpenOption[] options = new OpenOption[] { StandardOpenOption.CREATE, StandardOpenOption.WRITE,
				StandardOpenOption.SYNC };

		bwriter = Files.newBufferedWriter(path.resolve("Santander_20210819_bajas.txt"), options);
	}

	public void write(String cadena) throws IOException {
		bwriter.append(cadena);
		bwriter.newLine();
	}

	@Override
	public void close() throws IOException {
		bwriter.flush();
		bwriter.close();
	}

	public BufferedWriter getBwriter() {
		return bwriter;
	}

	public void setBwriter(BufferedWriter bwriter) {
		this.bwriter = bwriter;
	}

}
