package de.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfigurationWithBeanAnnotation {
	
	//dependency injection in java configuration file
	
	// define a bean for fortuneService
	@Bean
	public FortuneService fileFortuneService() {
		
		return new FileFortuneService();
				
	}
	
	@Bean
	public FortuneService practiceActivity7() {
		return new PracticeActivity();
	}
	
	@Bean
	public Coach baseballCoach() {
		return new BaseballCoach(practiceActivity7());
	}
	// define bean for swimCoach and Inject dependency	
	@Bean
	public Coach swimCoach() {
		 return new SwimCoach(fileFortuneService());
	}
	
	
	
	
}
