package de.demo.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class CartDAO {
	
	public boolean addAccount() {
		System.out.println("================Result\n" +  
						getClass() + " \n--> doing my db work: adding to CART\n"
								+ "\n");
		return true;
	}

	
}