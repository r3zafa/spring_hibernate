package de.demo.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach2 implements Coach {
	

	@Autowired
	@Qualifier("randomFortuneFromFile")
	private FortuneService fortuneService;
	
	public TennisCoach2(){} // for filed injection

	


	@Override
	public String getDailyWorkout() {
		return "nothing";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
