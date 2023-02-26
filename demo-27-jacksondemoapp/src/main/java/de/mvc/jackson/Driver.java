package de.mvc.jackson;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {


		try {
			
			
			
			// create object mapper
			
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file map/convert to java POJO: 
			// data/sample-lite.json
			Student student = 
					mapper.readValue(new File("data/sample-lite.json"), Student.class);
			
			
			StudentFull studentFull = 
					mapper.readValue(new File("data/sample-full.json"), StudentFull.class);
				
			// print first name and last name 
			System.out.println("\n\nFirstname: " + student.getFirstName() + 
					", lastname: " + student.getLastName() + ", Active: " 
					+ student.isActive() + ", userId:" + student.getId());
			
			
			// print first name and last name 
			System.out.println("\n\nuserId:" + studentFull.getId());
			System.out.println("Firstname: " + studentFull.getFirstName());
			System.out.println("lastname: " + studentFull.getLastName());
			System.out.println("Active: " + studentFull.isActive());
			System.out.println(studentFull.getAddressAsString());
			System.out.println(studentFull.getLanguagesAsString());

		} catch (Exception e) {

			e.printStackTrace();
		
		}
		
		
		
		
		
	}

}
