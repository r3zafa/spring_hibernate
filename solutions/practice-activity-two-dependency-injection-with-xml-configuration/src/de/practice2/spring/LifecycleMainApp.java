package de.practice2.spring;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LifecycleMainApp {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println("###########################");
		System.out.println(theCoach.getDailyFortune());
		System.out.println("###########################");
		System.out.println(theCoach.getDailyWorkout());
		System.out.println("###########################");

		// close context
		context.close();
	}
}
