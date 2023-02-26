package de.mvc.crm.rest.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.mvc.crm.rest.data.weatherEntity.BaseEntity;



@RestController
@RequestMapping("/api")
public class WeatherRestController {


	@GetMapping("/weather")
	public BaseEntity JsonWeatherResponseWithParam(@RequestParam("city") String city) throws IOException {
		


			String baseURL = "https://api.openweathermap.org/data/2.5/weather?";
			String appId = "APPID=b52129553f90f9b6b07a68092d114f92";
			String q = "q="+city;
	        URL jsonURL = new URL(baseURL+q+"&"+appId);
	        
	        HttpURLConnection huc = (HttpURLConnection) jsonURL.openConnection();
	        huc.setRequestMethod("HEAD");
	        int responseCode = huc.getResponseCode();
	        String msg = huc.getResponseMessage();
	        
//	        System.out.println(responseCode);
//	        System.out.println(msg);
	        
	        if (responseCode >= 400 || responseCode <= 199) {
	        	BaseEntity be = new BaseEntity();
	        	be.setCod(responseCode);
	        	be.setMassage(msg);
	        	return be;
				
			} else {
				
				ObjectMapper mapper = new ObjectMapper();

				BaseEntity weather = mapper.readValue(jsonURL, BaseEntity.class);

				return weather;

			}
	        
	        
	        
	        
			

	
		
	}
	
}
