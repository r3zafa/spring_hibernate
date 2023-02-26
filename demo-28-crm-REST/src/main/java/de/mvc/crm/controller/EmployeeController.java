package de.mvc.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.mvc.crm.service.EmployeeService;
import de.mvc.crm.entity.Users;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listAllEmployees(Model theModel) {
		List<Users> theEmployees = employeeService.getEmployees();
		theModel.addAttribute("users", theEmployees);
		return "employee/employee-list";
	}
	
	@GetMapping("/add")
	public String addNewEmployee(Model theModel) {
		Users newEmployee = new Users();
		theModel.addAttribute("employee", newEmployee);		
		return "employee/employee-form";
	}
	
	@PostMapping("/save")
	public String saveNewEmployee(@ModelAttribute Users theEmployee, BindingResult result, Model theModel) {
        theModel.addAttribute("employee", theEmployee);
		System.out.println("\n\nsaving... "+theEmployee + "\n\n");
		employeeService.saveEmployee(theEmployee);
		return "redirect:/employee/list";
		
	}
	
	@GetMapping("/update")
	public String updateUser(@RequestParam("username") String theUsername, Model theModel) {
		Users theUsers = employeeService.getEmployee(theUsername);	
		theModel.addAttribute("employee", theUsers);	
		return "employee/employee-form";
	}
	
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("username") String theUsername) {
		employeeService.deleteEmployee(theUsername);
		return "redirect:/employee/list";
	}
	
	
	
}
