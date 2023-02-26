package de.demo.spring;
import java.util.Random;
import org.springframework.stereotype.Component;


@Component
public class RandomFortuneService implements FortuneService {
	//create an array of strings
    private String[] data = {"Cheese", "Pepperoni", "Black Olives"};
    
    //generate random index
    private Random myRandom = new Random();
	

	
	@Override
	public String getFortune() {
		
		// pick a random string from data[]
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
	}
}
