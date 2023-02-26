package de.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	
	@GetMapping("/profile")
	public String showProfile() {
		return "profile";
		
	}
	
	@GetMapping("/system")
	public String showSystem() {
		return "system";
		
	}
	
	@GetMapping("/management")
	public String showManagement() {
		return "management";
		
	}
	
}
