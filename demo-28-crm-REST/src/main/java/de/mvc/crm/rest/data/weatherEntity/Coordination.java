package de.mvc.crm.rest.data.weatherEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordination {

	public Coordination() {}
	
	
	
	
	public Coordination(Float lon, Float lat) {
		this.lon = lon;
		this.lat = lat;
	}




	private Float lon;
	private Float lat;
	
	public Float getLon() {return lon;}
	public Float getLat() {return lat;}
	
	public void setLon(Float lon) {this.lon = lon;}
	public void setLat(Float lat) {this.lat = lat;}
	
	@Override
	public String toString() {
		return "Coordination {lon=" + lon + ", lat=" 
				+ lat + "}";
	}
	
	
	
}
