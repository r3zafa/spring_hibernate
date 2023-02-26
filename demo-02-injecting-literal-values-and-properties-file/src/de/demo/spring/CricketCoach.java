package de.demo.spring;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// create a no-arg constructior for setter method
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	// using setter injection - 
	// - right click Source generate Getters and Setters - :D 
	// - choose setter for service . finish!
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	

	// step 1 - injecting literal values 
	// - creating setter method(s) in class
	
	// adding new fields for email address and team
	private String emailAddress;
	private String team;
	
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: setter method - setTeam");
		this.team = team;
	}
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	
	@Override
	public String getDailyWorkout() {

		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	

}
