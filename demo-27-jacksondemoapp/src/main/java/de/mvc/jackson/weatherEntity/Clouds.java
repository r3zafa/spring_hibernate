package de.mvc.jackson.weatherEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Clouds {

	public Clouds() {}
	
	private int all;

	public int getAll() {
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}
	
	
	
	
	
}
