package de.demo.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount() {
		

		System.out.println("===============Result\n" +  
				getClass() + " \n--> doing my db work: adding an account\n"
						+ "\n");
	}
	
}