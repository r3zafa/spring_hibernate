package de.demo.aopdemo;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import de.demo.aopdemo.dao.AccountDAO;
import de.demo.aopdemo.service.TrafficFortuneService;

public class MainDemoApp {

	public static void main(String[] args) {

		System.out.println("\n[MainApp] =======================  start\n");

		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		

		// getting fortune service
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
				
		
		// loading service
		System.out.println("\n[MainApp] calling find method ## start");

		List<Account> accounts = theAccountDAO.findAccounts();
		System.out.println("\n[MainApp] [returned accounts]: " + accounts);
		
		System.out.println("\n[MainApp] calling find method ## end");

		
		
		System.out.println("\n-----------------------------------------\n");
		
		
		
		// loading service
		System.out.println("\n[MainApp] calling getFortuneService ## start");

		String data = theFortuneService.getFortune();
		System.out.println("\n[MainApp] [returned Fortune]: " + data);
		System.out.println("\n[MainApp] calling getFortuneService ## end");
		
		
		System.out.println("\n-----------------------------------------\n");
		
		
		// exception / error handling
		// loading service
		System.out.println("\n[MainApp] calling corrupted getFortuneService  ## start");
		boolean tripWire = true;
		String data2 = theFortuneService.getFortune(tripWire);
		System.out.println("\n[MainApp] [returned Fortune]: " + data2);
		System.out.println("\n[MainApp] calling corrupted getFortuneService ## end");

		
		
		
		System.out.println("\n-----------------------------------------\n");
		
		
		// rethrow error
		// loading service
		System.out.println("\n[MainApp] calling corrupted getFortuneRethrowException  ## start");
		String data3 = theFortuneService.getFortuneRethrowException(tripWire);
		System.out.println("\n[MainApp] [returned Fortune]: " + data3);
		System.out.println("\n[MainApp] calling corrupted getFortuneRethrowException ## end");

		
		System.out.println("\n[MainApp] =======================  END\n");

		// close the context
		context.close();
		

	}

}
