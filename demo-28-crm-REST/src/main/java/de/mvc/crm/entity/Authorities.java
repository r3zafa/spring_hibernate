package de.mvc.crm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "authorities")
public class Authorities {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "username", referencedColumnName="username", nullable = false)
	private Users username;
	
    @Column(name="authority")
    private String authority;

	public Authorities() {}
	
	public Users getUsername() {return username;}
	public String getAuthority() {return authority;}

	public void setUsername(Users username) {this.username = username;}
	public void setAuthority(String authority) {this.authority = authority;}

	@Override
	public String toString() {
		return authority;
	}
	
	
}
