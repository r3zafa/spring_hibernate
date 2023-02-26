package de.practice2.spring;
import java.util.Random;

public class RandomFortuneService implements FortuneService {

	// create an array of strings
	private String[] data = {
			
			"your lucky day",
			"have some hope",
			"beware of the wolf's in sheep's clothing",
			"mixed oppertonity"
			
	};
	
	//generate random number generator
	
	private Random myRandom = new Random();
	
		
	@Override
	public String getFortune() {
		//generate a Random index from 0 to data.length
		int index = myRandom.nextInt(data.length);
		// Pick Random value from array with index
		String theFortune = data[index];
		
		
		return theFortune;
		
	}

}


