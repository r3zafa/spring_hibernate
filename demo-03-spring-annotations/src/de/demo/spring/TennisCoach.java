package de.demo.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//if u use @Component instead of @Component("id") spring would generate bean id based on class name

//@Component("thatSillyCoach") //explicit bean id
@Component
public class TennisCoach implements Coach {
	
	//filed injection
	//step 1 in F.I.: set @Autowired directly on the field
	
	// Qualifier help to be specific about resources
	// if there was 2 or more fortuneServices defined. 
	// we can filter on out with qualifier
	@Autowired
	@Qualifier("randomFortuneFromFile")
	private FortuneService fortuneService;
	
	public TennisCoach(){} // for filed injection

	
	/*
	// create a constructor to class (step 4)
	// step 5 - configure dependency injection with @Autowired annotation
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
	fortuneService = theFortuneService;
	}
	*/
	
	
	/*
	// setter injection with @Autowired
	public TennisCoach(){}
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	/*
	// setter injection with @Autowired and custom name
	public TennisCoach(){}
	@Autowired
	public void doSmeCrazyStuff(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/



	@Override
	public String getDailyWorkout() {
		return "nothing";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
