package de.demo.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	/*
	// create a constructor to class (step 4)
	// step 5 - configure dependency injection with @Autowired annotation
	@Autowired
	public FootballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	// setter injection with @Autowired
	//we need a default constructor (step 1)
	public FootballCoach(){}
	// step 2
	/*
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	 */

	@Override
	public String getDailyWorkout() {
		return "run 2hrs daily";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
