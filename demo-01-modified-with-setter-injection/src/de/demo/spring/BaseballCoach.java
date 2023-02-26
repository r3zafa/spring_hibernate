package de.demo.spring;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//  BaseballCoach - Constructor
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "spend more time on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}








