package de.mvc.crm.validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CrmUser {

	@NotNull(message="Username is required")
	@Size(min=3, message="should at least contain 3 character")	
	private String userName;
	
	@NotNull(message="Set a password. it is required!")
	@Size(min=6, message="should at least contain 6 character")
	private String password;
	
	
	private String formRole;

	
	
	
	public CrmUser() {}
	
	public String getUserName() { return userName;}
	public void setUserName(String userName) { this.userName = userName; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getFormRole() {return formRole;}
	public void setFormRole(String formRole) {this.formRole = formRole;}
	
}
