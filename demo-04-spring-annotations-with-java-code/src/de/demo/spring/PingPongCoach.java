package de.demo.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach {

	
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	public PingPongCoach(){} // for filed injection

	
	
	@Override
	public String getDailyWorkout() {
		return "nothing";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
