package de.mvc.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") // parent mapping - useful to avoid typical problems by rooting
public class HelloWorldController {
	
	// need a controller method to show the initial HTML form
	
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	


	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	

	
	// now controller to read the form data and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(HttpServletRequest request, Model model) {
		// read Request Parameter from HTML form
		String firstName = request.getParameter("firstName");
		// convert data to UpperCase
		firstName = firstName.toUpperCase();
		// add message to the model
		String result = "Jo! <br> " + firstName;
		model.addAttribute("Message", result);
		return "helloworld";
	}
	
	
	
	// now controller to read the form data and add data to the model
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("firstName") String firstName, Model model) {
		// convert data to UpperCase
		firstName = firstName.toUpperCase();
		// add message to the model
		String result = "you can close this page, see you later - " + firstName;
		model.addAttribute("Message", result);
		return "helloworld";	
	}
	
	
	
	
}
