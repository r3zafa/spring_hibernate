package de.mvc.jackson.weatherEntity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEntity {

	public BaseEntity() {}
	
	private String base;
	private String name;
	private int visibility;
	private int dt;
	private int timezone;
	private int id;
	private int cod;
	
	private Coordination coord;
	private Weather[] weather;
	private Main main;
	private Wind wind;
	private Clouds clouds;
	private Sys sys;
	
	
	public String getBase() { return base; }
	public String getName() {return name;}
	public int getVisibility() {return visibility;}	
	public int getDt() {return dt;}	
	public int getTimezone() {return timezone;}
	public int getId() {return id;}
	public int getCod() {return cod;}
	
	public Coordination getCoord() {return coord;}
	public Weather[] getWeather() {return weather;}
	public Main getMain() {return main;}	
	public Wind getWind() {return wind;}
	public Clouds getClouds() {return clouds;}
	public Sys getSys() {return sys;}

	
	public String getCoordAsString() {return coord.toString();}		
	public String getWeatherAsString() {return Arrays.toString(getWeather());}
	public String getMainAsString() {return main.toString();}	
	public String getWindAsString() {return wind.toString();}
	public String getSysAsString() {return sys.toString();}

	
	public void setBase(String base) {this.base = base;}
	public void setName(String name) {this.name = name;}
	public void setVisibility(int visibility) {this.visibility = visibility;}
	public void setDt(int dt) {this.dt = dt;}
	public void setTimezone(int timezone) {this.timezone = timezone;}
	public void setId(int id) {this.id = id;}
	public void setCod(int cod) {this.cod = cod;}
	public void setCoord(Coordination coord) {this.coord = coord;}
	public void setWeather(Weather[] weather) {this.weather = weather;}
	public void setMain(Main main) {this.main = main;}
	public void setWind(Wind wind) {this.wind = wind;}
	public void setClouds(Clouds clouds) {this.clouds = clouds;}
	public void setSys(Sys sys) {this.sys = sys;}

}
