package de.demo.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import de.demo.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		System.out.println("=======================  start\n");

		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		
		List<Account> theAccounts = null;

		
		
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exc) {
			System.out.println("\n\n[Main Program]: caught exception: " + exc);
		}
		
		
		// display the accounts
		System.out.println("\n\n[Main Program]: AfterThrowing error ....................\n\n");
				
		System.out.println("returned accounts: " + theAccounts);
				
				
		// close the context
				
		context.close();
		
		System.out.println("\n=======================  END\n");

	}

}
