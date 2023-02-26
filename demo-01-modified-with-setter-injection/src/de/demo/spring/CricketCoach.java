package de.demo.spring;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// create a no-arg constructior for setter method
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	// using setter injection - right click Source generate Getters and Setters - :D choose setter for service . finish!
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	
	

	@Override
	public String getDailyWorkout() {

		return "◉----- Practice fast bowling for 15 minutes -----◎";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	

}
