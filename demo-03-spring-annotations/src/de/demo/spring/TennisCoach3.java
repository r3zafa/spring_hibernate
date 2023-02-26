package de.demo.spring;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach3 implements Coach {
	
	// +++++++++++++++++++++++++++++++++++++++++++
	// defining destroy and Initialization methods
	// +++++++++++++++++++++++++++++++++++++++++++

	
	@Autowired
	@Qualifier("randomFortuneFromFile")
	private FortuneService fortuneService;
	
	public TennisCoach3(){} // for filed injection

	
	
	// define Init method
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("\n>> TennisCoach3: inside doMyStartupStuff()");
	}
	
	// define destroy method
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach3: inside doMyPreDistroyStuff()\n");
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "nothing";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
