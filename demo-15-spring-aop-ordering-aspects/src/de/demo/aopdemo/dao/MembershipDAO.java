package de.demo.aopdemo.dao;

import org.springframework.stereotype.Component;


@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println("\n###### Result:: executing addAccount() from MembershipDAO\n");
	}

	public void addSecondAccount() {
		System.out.println("\n###### Result:: executing addSecondAccount() from MembershipDAO\n");		
	}
	
	public void addToCart(int number, String string) {
		System.out.println("\n###### Result:: executing addToCart() from MembershipDAO with arguments (STRING :: INT): " + number + 
				" :: " + string + " \n");
	}
	
	public void addToEvent(int theId) {
		System.out.println("\n###### Result:: executing addToEvent() from MembershipDAO with argument (INT): " + theId + " \n");
	}

	public void addToList(String theString) {
		System.out.println("\n###### Result:: executing addToList() from MembershipDAO with argument(STRING): " + theString + " \n");
	}
}