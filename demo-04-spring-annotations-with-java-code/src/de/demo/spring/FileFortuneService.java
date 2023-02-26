package de.demo.spring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;


@Component
public class FileFortuneService implements FortuneService {

	private String fileName = "../demo-3-spring-annotations/src/fortune-data.txt";
	private List<String> theFortunes;
	
	public FileFortuneService() {
		System.out.println("\ninside FileFortuneService constructor\n");
	}
	
	@PostConstruct
	private void loadTheFortuneFile() {
		System.out.println("############# loadTheFortuneFile - start ###############\n");

		File theFile = new File(fileName);
		
		System.out.println("reading file from: " + fileName);
		System.out.println("\nFile exist:" + theFile.exists() + "\n");
		
		// initialize array list
		theFortunes = new ArrayList<String>();
		
		// read fortunes from data
		try (BufferedReader br = new BufferedReader(new FileReader(theFile))){
			
			String tempLine;
			
			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}
			
		} catch(IOException e) {
			e.printStackTrace();			
		}
		System.out.println("############## loadTheFortuneFile - end ##############\n");

	}
	
	// create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(theFortunes.size());
		String tempFortune = theFortunes.get(index);
		return tempFortune;
	}

}
