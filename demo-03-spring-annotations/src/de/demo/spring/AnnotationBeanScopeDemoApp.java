package de.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {


		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// retrieve bean(s) from spring container
		Coach theFirstCoach = context.getBean("tennisCoach2", Coach.class);
		Coach theSecondCoach = context.getBean("tennisCoach2", Coach.class);
		
		//use methods on bean
		// check if they are the same bean
		boolean result = (theFirstCoach == theSecondCoach);
		
		//print out the results
		System.out.println("\n####### AnnotationBeanScopeDemoApp - Start #######");
		System.out.println("\nPointing to the same object? : " + result + "\n");
		System.out.println("Memory location for theFirstCoach is: \n" + theFirstCoach + "\n");
		System.out.println("Memory location for theSecondCoach is: \n" + theSecondCoach + "\n");
		System.out.println("####### AnnotationBeanScopeDemoApp - end #######\n");

		
		// close the context
		context.close();
		
		
		
		
		
	}

}
