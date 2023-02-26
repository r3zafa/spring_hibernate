package de.mvc.crm.rest.data.weatherEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sys {

	public Sys() {
	}

	private int type;
	private int id;
	private String country;
	private int sunrise;
	private int sunset;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getSunrise() {
		return sunrise;
	}

	public void setSunrise(int sunrise) {
		this.sunrise = sunrise;
	}

	public int getSunset() {
		return sunset;
	}

	public void setSunset(int sunset) {
		this.sunset = sunset;
	}

	@Override
	public String toString() {
		return "Sys {type=" + type + ", id=" + id + ", "
				+ "country=" + country + ", sunrise=" 
				+ sunrise + ", sunset="
				+ sunset + "}";
	}

}
