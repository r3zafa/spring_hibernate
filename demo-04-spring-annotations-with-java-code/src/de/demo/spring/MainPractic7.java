package de.demo.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainPractic7 {

	public static void main(String[] args) {
		// load spring configuration from java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfigurationWithBeanAnnotation.class);
		
		
		// retrieve bean(s) from spring container
		Coach theFirstCoach = context.getBean("baseballCoach", Coach.class);
		
		//use methods on bean
		
		
		//print out the results
		System.out.println("####### MainPractice#7 - Start #######\n");
		System.out.println("Coach says: " + theFirstCoach.getDailyWorkout() + "\n");
		System.out.println("Your Daily Fortune: " + theFirstCoach.getDailyFortune() + "\n");
		System.out.println("####### MainPractice#7 - end #######\n");

		
		// close the context
		context.close();
		
	}

}
