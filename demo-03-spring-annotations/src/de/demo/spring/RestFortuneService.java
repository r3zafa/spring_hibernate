package de.demo.spring;
import org.springframework.stereotype.Component;

@Component
public class RestFortuneService implements FortuneService {
	
	
	@Override
	public String getFortune() {
		return "goooo3ooood";
	}
}
