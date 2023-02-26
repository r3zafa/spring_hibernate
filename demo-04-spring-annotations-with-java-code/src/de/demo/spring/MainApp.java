package de.demo.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// load spring configuration from java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfiguration.class);
		
		
		// retrieve bean(s) from spring container
		Coach theFirstCoach = context.getBean("pingPongCoach", Coach.class);
		
		//use methods on bean
		
		
		//print out the results
		System.out.println("\n####### AnnotationBeanScopeDemoApp - Start #######");
		System.out.println("\nCoach1 says:\n" + theFirstCoach.getDailyWorkout() + " "
				+ "\n\nYour Daily Fortune:\n" + theFirstCoach.getDailyFortune() + "\n");
		System.out.println("####### AnnotationBeanScopeDemoApp - end #######\n");

		
		// close the context
		context.close();
		
	}

}
