package de.mvc.jackson;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentFull {
	
	public StudentFull() {}

	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	private Address address;
	private String[] languages; 
	
	// getters
	public int getId() {return id;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public boolean isActive() {return active;}
	public Address getAddress() {return address;}
	public String getAddressAsString() {return address.toString();}
	
	public String[] getLanguages() {return languages;}
	public String getLanguagesAsString() {return "Languages: "+ Arrays.toString(getLanguages());}

	// setters
	public void setId(int id) {this.id = id;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setActive(boolean active) {this.active = active;}
	public void setAddress(Address address) {this.address = address;}
	public void setLanguages(String[] languages) {this.languages = languages;}
}
