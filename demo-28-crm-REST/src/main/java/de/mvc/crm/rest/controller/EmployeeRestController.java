package de.mvc.crm.rest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mvc.crm.entity.Users;
import de.mvc.crm.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;
	
//	private PasswordEncoder pwEncoder = new BCryptPasswordEncoder();
//	private Logger logger = Logger.getLogger(getClass().getName());

	enum user_roles {		
		ROLE_Customer,
		ROLE_EMPLOYEE,
		ROLE_TESTER,
		ROLE_MANAGER,
		ROLE_ADMIN,
		ROLE_OWNER
	}
	
	
	@GetMapping("/list")
	public List<Users> GetCustomers() throws IOException {
		List<Users> employees = employeeService.getEmployees();
		return employees; 
	}
	
}
