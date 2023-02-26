package de.demo.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import de.demo.aopdemo.dao.AccountDAO;
import de.demo.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		System.out.println("=======================  start\n");

		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
				
		// call the business method
		Account myAccount = new Account();
		myAccount.setName("reza");
		myAccount.setLevel("polaris");
		
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// call the accountdao getter/setter methods
		theAccountDAO.setName("robin");
		theAccountDAO.setServiceCode("silver");


		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		
		System.out.println("\n\n######################## After part #######################");
		
		// call method to find the accounts
		List<Account> theAccounts = null;
		System.out.println(theAccounts + " founded. finding other accounts...");
		
		theAccounts = theAccountDAO.findAccounts();
		System.out.println("√ loaded" + theAccounts);
				
		System.out.println("\n");
		
		

		
		// close the context
		context.close();
		
		System.out.println("\n=======================  END\n");

	}

}
