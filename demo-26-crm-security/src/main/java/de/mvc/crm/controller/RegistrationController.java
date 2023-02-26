package de.mvc.crm.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.mvc.crm.validator.CrmUser;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	private PasswordEncoder pwEncoder = new BCryptPasswordEncoder();

	private Logger logger = Logger.getLogger(getClass().getName());
	
	private Map<String, String> roles;

	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	
	
	@PostConstruct
	protected void loadRoles() {
		
		// using hashmap, could also read this info from a database
		
		roles = new LinkedHashMap<String, String>();
		
		// key=the role, value=display to user 
		roles.put("ROLE_EMPLOYEE", "Employee");
		roles.put("ROLE_MANAGER", "Manager");
		roles.put("ROLE_ADMIN", "Admin");		
	}
	
	
	
	@GetMapping("/register")
	public String showMyLoginPage(Model theModel) {
		theModel.addAttribute("crmUser", new CrmUser());
		theModel.addAttribute("roles",roles);
		return "registration-form";
	}
	
	

	@PostMapping("/processRegistration")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser theCrmUser, 
			BindingResult theBindingResult, Model theModel) {				
		
		String userName = theCrmUser.getUserName();
		boolean userExists = doesUserExist(userName);
		logger.info("Processing registration form for: " + userName);
		// form validation
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("roles", roles);
			theModel.addAttribute("registrationError", "User name/password can not be empty.");
			logger.warning("User name/password can not be empty.");
			return "registration-form";	
		}
		
		if (userExists) {
			theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("registrationError", "User name already exists.");
			logger.warning("User name already exists.");
			return "registration-form";			
		}
		
        String encodedPassword = pwEncoder.encode(theCrmUser.getPassword());// encrypt the password
        encodedPassword = "{bcrypt}" + encodedPassword;// prepend the encoding algorithm id   
		
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();// give user default role of "employee"
        authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));

        String formRole = theCrmUser.getFormRole();

        if (!formRole.equals("ROLE_EMPLOYEE")) {
        		authorities.add(new SimpleGrantedAuthority(formRole));
        }
        
        
        User tempUser = new User(userName, encodedPassword, authorities);// create user object (from Spring Security framework)
        userDetailsManager.createUser(tempUser); // save user in the database	
        logger.info("Successfully created user: " + userName);
      
        return "redirect:/?registered";		
	}
	
	
	
	private boolean doesUserExist(String userName) {
		
		logger.info("Checking if user exists: " + userName);
		
		// check the database if the user already exists
		boolean exists = userDetailsManager.userExists(userName);
		
		logger.info("User: " + userName + ", exists: " + exists);
		
		return exists;
	}

}
