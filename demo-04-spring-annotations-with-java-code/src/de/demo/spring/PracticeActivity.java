package de.demo.spring;

public class PracticeActivity implements FortuneService {

	@Override
	public String getFortune() {
		return "you are doing a great job there!";
	}

}
