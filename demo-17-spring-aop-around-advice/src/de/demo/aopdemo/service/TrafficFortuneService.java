package de.demo.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	
	public String getFortune() {
		
		// simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		return "you will be delayed - expect heavy traffic this morning";
		
	}

	public String getFortune(boolean tripWire) {


		if (tripWire) {
			throw new RuntimeException("an arror has happened!");
		}
		
		
		
		
		
		return getFortune();
	}
	
	public String getFortuneRethrowException(boolean tripWire) {


		if (tripWire) {
			throw new RuntimeException("an arror has happened!");
		}
		
		
		

		
		return getFortune();
	}
	
}
