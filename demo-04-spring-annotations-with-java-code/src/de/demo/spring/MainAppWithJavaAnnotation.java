package de.demo.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAppWithJavaAnnotation {

	public static void main(String[] args) {
		// load spring configuration from java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfigurationWithBeanAnnotation.class);
		
		
		// retrieve bean(s) from spring container
		SwimCoach theFirstCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//use methods on bean
		
		
		//print out the results
		System.out.println("####### mainAppWithJavaAnnotation - Start #######\n");
		System.out.println("Coach says: " + theFirstCoach.getDailyWorkout() + "\n");
		System.out.println("Swimmer Team: " + theFirstCoach.getTeam() + "\n");
		System.out.println("Swimmer Email: " + theFirstCoach.getEmail() + "\n");
		System.out.println("Your Daily Fortune: " + theFirstCoach.getDailyFortune() + "\n");
		System.out.println("####### mainAppWithJavaAnnotation - end #######\n");

		
		// close the context
		context.close();
		
	}

}
