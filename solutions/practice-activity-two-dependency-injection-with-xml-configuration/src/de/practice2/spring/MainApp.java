package de.practice2.spring;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("myCricketCoach", Coach.class);
		
		System.out.println("###########################");
		System.out.println(theCoach.getDailyFortune());
		System.out.println("###########################");
		System.out.println(theCoach.getDailyWorkout());
		System.out.println("###########################");

		// close context
		context.close();
	}
}
