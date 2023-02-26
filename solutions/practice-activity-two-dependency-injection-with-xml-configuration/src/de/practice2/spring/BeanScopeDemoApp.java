package de.practice2.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContextSingleton.xml");
		// retrieve bean from spring container
		Coach  theCoach = context.getBean("myCoach",Coach.class);
		Coach  alphaCoach = context.getBean("myCoach",Coach.class);	
		// check if both are the same bean
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\n############ beanScope-applicationContextSingleton.xml #############\n");

		System.out.println("\nPointing to the same object:\n" + result);
		System.out.println("\nMemory location for theCoach:\n" + theCoach);
		System.out.println("\nMemory location for alphaCoach:\n" + alphaCoach + "\n");
		// close the context
		context.close();

		System.out.println("\n############ beanScope-applicationContextPrototyp.xml #############\n");
		// load the spring configuration file
		ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("beanScope-applicationContextPrototyp.xml");
		// retrieve bean from spring container
		Coach  theCoach2 = context2.getBean("myCoach",Coach.class);
		Coach  alphaCoach2 = context2.getBean("myCoach",Coach.class);	
		// check if both are the same bean
		boolean result2 = (theCoach2 == alphaCoach2);
		System.out.println("\nPointing to the same object:\n" + result2);
		System.out.println("\nMemory location for theCoach:\n" + theCoach2);
		System.out.println("\nMemory location for alphaCoach:\n" + alphaCoach2 + "\n");
		// close the context
		
		context2.close();
			
		
		//
	}

}
