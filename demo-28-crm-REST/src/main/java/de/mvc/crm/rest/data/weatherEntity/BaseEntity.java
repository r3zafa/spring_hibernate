package de.mvc.crm.rest.data.weatherEntity;

//import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEntity {

	public BaseEntity() {}
	

	private String base;
	private String name;
	private Integer visibility;
	private Integer dt;
	private Integer timezone;
	private Integer id;
	private Integer cod;
	private String massage;
	//########################
	private Coordination coord;
	private Weather[] weather;
	private Main main;
	private Wind wind;
	private Clouds clouds;
	private Sys sys;
	
	//############ getters ##################################
	public String getBase() { return base; }
	public String getName() {return name;}
	public Integer getVisibility() {return visibility;}	
	public Integer getDt() {return dt;}	
	public Integer getTimezone() {return timezone;}
	public Integer getId() {return id;}
	public Integer getCod() {return cod;}
	public String getMassage() {return massage;}
	// #####################################################	
	public Coordination getCoord() {return coord;}
	public Weather[] getWeather() {return weather;}
	public Main getMain() {return main;}	
	public Wind getWind() {return wind;}
	public Clouds getClouds() {return clouds;}
	public Sys getSys() {return sys;}
	//######################################################
	/*
	public String getWeatherAsString() {
		if (getWeather()!=null) {return Arrays.toString(getWeather());} 
		else { return null;}
	}
	public String getCoordAsString() {
		if(coord != null) {return coord.toString();} 
		else {return null;}
		}		
	public String getMainAsString() {
		if(main != null) {return main.toString();} 
		else {return null;}
		}	
	public String getWindAsString() {
		if (wind!=null) {return wind.toString();} 
		else {return null;}
	}
	public String getSysAsString() {
		if (sys!=null) {return sys.toString();} 
		else {return null;}
	}
	*/
	
	//######################## setters #########################
	public void setBase(String base) {this.base = base;}
	public void setName(String name) {this.name = name;}
	public void setVisibility(Integer visibility) {this.visibility = visibility;}
	public void setDt(Integer dt) {this.dt = dt;}
	public void setTimezone(Integer timezone) {this.timezone = timezone;}
	public void setId(Integer id) {this.id = id;}
	public void setCod(Integer cod) {this.cod = cod;}
	public void setCoord(Coordination coord) {this.coord = coord;}
	public void setWeather(Weather[] weather) {this.weather = weather;}
	public void setMain(Main main) {this.main = main;}
	public void setWind(Wind wind) {this.wind = wind;}
	public void setClouds(Clouds clouds) {this.clouds = clouds;}
	public void setSys(Sys sys) {this.sys = sys;}
	public void setMassage(String massage) {this.massage = massage;}
	

	
	

	
	
	
}

	
	
	
	
	
