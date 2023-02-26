package de.demo.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import de.demo.aopdemo.dao.AccountDAO;
import de.demo.aopdemo.dao.CartDAO;
import de.demo.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {


		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from spring container
		AccountDAO theAccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO thwMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		CartDAO thwCartDAO = 
				context.getBean("cartDAO", CartDAO.class);
		
		
		System.out.println("======================= START\n");
		
		//call the business method
		// return type : void
		theAccountDAO.addAccount();
		thwMembershipDAO.addAccount();
		thwMembershipDAO.addSecondAccount();
		// return type : boolean
		thwCartDAO.addAccount();

		// different Argument input sensitivity
		thwMembershipDAO.addToCart(1,"ONE");
		thwMembershipDAO.addToEvent(12);
		thwMembershipDAO.addToEvent2("REZA");

		// close the context
		context.close();
		
		System.out.println("=======================  END\n");

	}

}
