package de.demo.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String name = "Netto"; 
	private String ceo = "Mark Zackerberg"; 
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCeo() {
		return ceo;
	}



	public void setCeo(String ceo) {
		this.ceo = ceo;
	}



	public void addAccount() {
		
		System.out.println("\n###### Result:: executing addAccount() from AcountDAO \n");
	}
	
}