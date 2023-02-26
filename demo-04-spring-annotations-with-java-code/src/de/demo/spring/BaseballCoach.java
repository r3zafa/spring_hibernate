package de.demo.spring;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;

	public BaseballCoach(FortuneService practiceActivity7) {
		fortuneService = practiceActivity7;
	}

	@Override
	public String getDailyWorkout() {
		return "--";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
