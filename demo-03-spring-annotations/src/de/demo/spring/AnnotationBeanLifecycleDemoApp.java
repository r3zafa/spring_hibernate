package de.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanLifecycleDemoApp {

	public static void main(String[] args) {


		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
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
