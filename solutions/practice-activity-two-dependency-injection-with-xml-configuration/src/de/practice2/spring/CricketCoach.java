package de.practice2.spring;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public CricketCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}




	@Override
	public String getDailyWorkout() {

		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	

	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	// add a destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("TrackCoach: inside method doMyCleanupStuffYoYo");		
	}
}
