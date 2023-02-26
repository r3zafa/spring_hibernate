package de.mvc.jackson;

import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.mvc.jackson.weatherEntity.BaseEntity;

public class WeatherDriver {

	public static void main(String[] args) {


		try {
			
			
			
			// create object mapper
			
			ObjectMapper mapper = new ObjectMapper();
	        URL jsonURL = new URL("https://api.openweathermap.org/data/2.5/weather?q=dubai&APPID=b52129553f90f9b6b07a68092d114f92");

	        BaseEntity weather = 
					mapper.readValue(jsonURL, BaseEntity.class);
			
	         
	        

			
			System.out.println("base: " + weather.getBase());
			System.out.println("name: " + weather.getName());
			System.out.println("visibility: " + weather.getVisibility());
			System.out.println("dt: " + weather.getDt());
			System.out.println("Timezone: " + weather.getTimezone());
			System.out.println("id: " + weather.getId());
			System.out.println("Cod: " + weather.getCod());
			System.out.println("Cloads: " + weather.getClouds().getAll());
			System.out.println(weather.getCoordAsString());
			System.out.println(weather.getWeatherAsString());
			System.out.println(weather.getMainAsString());
			System.out.println(weather.getWindAsString());
			System.out.println(weather.getSysAsString());
			




		} catch (Exception e) {

			e.printStackTrace();
		
		}
		
		
		
		
		
	}

}
