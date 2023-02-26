package de.mvc.jackson.weatherEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordination {

	public Coordination() {}
	
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
