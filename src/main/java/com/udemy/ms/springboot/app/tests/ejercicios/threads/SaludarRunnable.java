package com.udemy.ms.springboot.app.tests.ejercicios.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaludarRunnable implements Runnable {

	Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	private int timePause;
	
	public SaludarRunnable(int time) {
		this.timePause = time;
	}
	@Override
	public void run() {
		while(!Thread.interrupted()) {
			log.info("Ejecutando "+Thread.currentThread().getName());
			try {
				Thread.sleep(timePause);
			} catch (InterruptedException e) {
				log.error(Thread.currentThread().getName() +" - "+e.getMessage());
				Thread.currentThread().interrupt();
				log.error(Thread.currentThread().getName() +" - "+Thread.currentThread().getState().name());
			}
		}

	}

}
