package de.mvc.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

import javax.validation.Valid;
@Controller
@RequestMapping("/student")
public class StudentController {
	
	
    @Value("#{countryOptions}") 
    private Map<String, String> countryOptions;
	
    
    // avoid whitespace input by validation -> whitespace Trimming to null with true option
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
    	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    
    
    
    
    
    
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student",theStudent);
		theModel.addAttribute("theCountryOptions",countryOptions);
		return "student-form";
	}
	
	// now controller to read the form data and add data to the model
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student theStudent,
			BindingResult theBindingResult, Model theModel) {
		
		System.out.println( "\n\nBindingResult\n\n" + theBindingResult + " \n\nBindingResult\n\n" );
		
		
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("theCountryOptions",countryOptions);
			return "student-form" ;
		} 
		else 
		{
			System.out.println("\nthe Student: " + "\n" + 
			theStudent.getFirstName() + "\n" +
			theStudent.getLastName() + "\n" + 
			theStudent.getFavoriteLanguage() + "\n" +
			theStudent.getOsString() + "\n" +
			theStudent.getCountry() + "\n");
			return "student-confirmation";	
		}
		
		
		

	}

}
