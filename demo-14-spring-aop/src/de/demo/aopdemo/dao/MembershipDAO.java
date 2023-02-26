package de.demo.aopdemo.dao;

import org.springframework.stereotype.Component;


@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println("=================Result\n" +  
						getClass() + " \n--> doing my db work: adding a membership account\n"
								+ "\n");
	}

	public void addSecondAccount() {
		System.out.println("================Result\n" +  
				getClass() + " \n--> doing my db work: adding second membership account\n"
						+ "\n");		
	}
	
	public void addToCart(int number, String string) {
		System.out.println("=================Result\n" +  
						getClass() + " \n--> 0 - many Argument\n" + number + string
								+ "\n");
	}
	
	public void addToEvent(int theId) {
		System.out.println("=================Result\n" +  
						getClass() + " \n--> one Argument many type (INT)\n" + theId
								+ "\n");
	}

	public void addToEvent2(String theString) {
		System.out.println("=================Result\n" +  
						getClass() + " \n--> one Argument many type (STRING)\n" + theString
								+ "\n");
	}
}