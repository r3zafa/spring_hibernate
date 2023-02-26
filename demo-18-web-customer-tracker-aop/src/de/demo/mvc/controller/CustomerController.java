package de.demo.mvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.demo.mvc.entity.Customer;
import de.demo.mvc.service.CustomerService;
import de.demo.mvc.util.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject Service
	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel, @RequestParam(required=false) String sort) {
		
		List<Customer> theCustomers = null;
		
		// get customers from service
		if (sort != null) {
			
			int theSortField = Integer.parseInt(sort);
			theCustomers = customerService.getCustomers(theSortField);
			
		} else {
			
			theCustomers = customerService.getCustomers(SortUtils.LAST_NAME);
			
		}
		
		// add customers to the model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customer";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("searchString") String theSearchString, Model theModel) {
		
		List<Customer> theCustomers = customerService.searchCustomers(theSearchString);
		
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customer";
	}
	
	@GetMapping("/new")
	public String newCustomerForm(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/new")
	public String saveCustomer (@ModelAttribute("customer") Customer theCustomer) {
		
		// save customer using service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/update")
	public String updateCustomerForm(@RequestParam("customerId") int theId, Model theModel) {
		
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer",theCustomer);

		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model theModel) {
		
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
