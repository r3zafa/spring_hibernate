package de.mvc.springdemo;

import java.util.Arrays;
import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import de.mvc.springdemo.validation.CourseCode;

public class Student {
	
	@NotNull(message="is required")
	@Size(min=2, message="min. length: 2")
	private String firstName; 
	
	@NotNull(message="is required")
	@Size(min=2, message="min. length: 2")
	private String lastName;
	
	// by using Integer instead of int we can use notNull notation for numbers
	@NotNull(message="is required")
	@Min(value = 18, message="must be greater/equal 18")
	@Max(value = 99, message = "must be less than 99")
	private Integer age;
	
	//using regular expressions
	@Pattern(regexp = "[a-z0-9]{5}", message = "only 5 Char/digits / should be lowercase")
	private String postalCode;
	
	// creating custom validation
	@NotNull(message="is required")
	//@CourseCode // to load default value and message
	@CourseCode(value="xmp", message = "must start with xmp") // custom prefix and message
	private String courseCode;
	
	private String country;
	
	private String favoriteLanguage;
	
	private String[] os;
	
	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("IR", "IRAN");
		countryOptions.put("US", "USA");
		countryOptions.put("DE", "Germany");
		countryOptions.put("FR", "France");
		
		
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[] getOs() {
		return os;
	}
	
	public String getOsString() {
		return Arrays.toString(os);
	}

	public void setOs(String[] os) {
		this.os = os;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	
	

	
}
