package de.practice1.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// step 2
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// step 3
		Coach newCoach = context.getBean("newTipp", Coach.class);
		
		// call method and close
		System.out.println(newCoach.getTipps());
		context.close();

	}

}
