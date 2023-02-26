package de.demo.spring;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class RandomFortuneFromFile implements FortuneService {

	private String fileName = "../demo-3-spring-annotations/src/fortune-data.txt";
	private List<String> theFortunes;
	
	public RandomFortuneFromFile() {
		
		File theFile = new File(fileName);
		
		System.out.println("reading file from: " + fileName);
		System.out.println("File exist:" + theFile.exists());
		
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
