package de.mvc.crm.rest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import de.mvc.crm.entity.Customer;
import de.mvc.crm.service.CustomerService;



@RestController
@RequestMapping("/api")
public class CustomersRestController {

	@Autowired
	private CustomerService customerService;
		
	
	@GetMapping("/customer/list")
	public List<Customer> GetCustomers() throws IOException {
		List<Customer> theCustomers = customerService.getCustomers();
		return theCustomers; 
	}
	
}
