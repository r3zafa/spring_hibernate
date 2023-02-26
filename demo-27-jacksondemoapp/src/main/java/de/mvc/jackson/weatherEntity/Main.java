package de.mvc.jackson.weatherEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

	public Main() {
	}

	private Float temp;
	private Float feels_like;
	private Float temp_min;
	private Float temp_max;
	private int pressure;
	private int humidity;

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public Float getFeels_like() {
		return feels_like;
	}

	public void setFeels_like(Float feels_like) {
		this.feels_like = feels_like;
	}

	public Float getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(Float temp_min) {
		this.temp_min = temp_min;
	}

	public Float getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(Float temp_max) {
		this.temp_max = temp_max;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return "Main {temp=" + temp + ", feels_like=" + feels_like + ", temp_min=" + temp_min + ", temp_max=" + temp_max
				+ ", pressure=" + pressure + ", humidity=" + humidity + "}";
	}

}
