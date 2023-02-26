package de.mvc.crm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "users" )
public class Users {
	
	public Users() {}
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Id
	@Column(name = "username")
	private String username;

	
	@Column(name = "password")
	private String password;
	
	
	@Column(name = "enabled")
	private boolean enabled;
	
	
	@Column(name="first_name")
	private String firstname;
	
	
	@Column(name="last_name")
	private String lastname;

	@Column(name="email")
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "username",
			cascade = {CascadeType.ALL})
	private List<Authorities> authorities;
		
	public void add(Authorities tempAuthorities) {if (authorities == null) { authorities = new ArrayList<>();}
		authorities.add(tempAuthorities);
		tempAuthorities.setUsername(this);
	}
	
	public int getId() {return id;}
	public String getUsername() {return username;}
	public String getPassword() {return password;}
	public boolean isEnabled() {return enabled;}
	public String getFirstname() {return firstname;}
	public String getLastname() {return lastname;}
	public String getEmail() {return email;}
	
	public void setId(int id) {this.id = id;}
	public void setUsername(String username) {this.username = username;}
	public void setPassword(String password) {this.password = password;}
	public void setEnabled(boolean enabled) {this.enabled = enabled;}
	public void setFirstname(String firstname) {this.firstname = firstname;}
	public void setLastname(String lastname) {this.lastname = lastname;}
	public void setEmail(String email) {this.email = email;}

	
	
	public List<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", authorities="
				+ authorities + "]";
	}




	
	
	
}
