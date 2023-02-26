package de.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// load the spring configuration
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach",CricketCoach.class);
		// call methods on bean
		System.out.println("--------Fortune-------");
		System.out.println(theCoach.getDailyFortune());
		System.out.println("--------workout-------");
		System.out.println(theCoach.getDailyWorkout());
		System.out.println("--------email---------");
		System.out.println(theCoach.getEmailAddress());
		System.out.println("--------team----------");
		System.out.println(theCoach.getTeam());
		
		// close context
		context.close();
	}

}
