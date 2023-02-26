package de.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMainApp {

	public static void main(String[] args) {


		// step 1 - read spring configuration
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// step 2 - get the beans from spring container
		Coach coach1 = context.getBean("tennisCoach", Coach.class);
		
		Coach coach2 = context.getBean("footballCoach", Coach.class);
		
		// step 3 - call methods 		
		// step 6 (@Autowired)- call method to get daily fortune
		System.out.println("\nCoach1 says:\n" + coach1.getDailyWorkout() + " "
				+ "\n\nYour Daily Fortune:\n" + coach1.getDailyFortune() + "\n");
		System.out.println("Coach2 says:\n" + coach2.getDailyWorkout() 
				+ " \n\nYour Daily Fortune:\n" + coach2.getDailyFortune() + "\n");
		

		// step 4 - close the context
		context.close();
		}

}
