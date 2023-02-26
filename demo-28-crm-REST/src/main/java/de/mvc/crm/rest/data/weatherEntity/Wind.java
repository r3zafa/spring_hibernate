package de.mvc.crm.rest.data.weatherEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

	public Wind() {
	}

	private Float speed;
	private int deg;

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public int getDeg() {
		return deg;
	}

	public void setDeg(int deg) {
		this.deg = deg;
	}

	@Override
	public String toString() {
		return "Wind {speed=" + speed + ", deg=" + deg + "}";
	}

}
