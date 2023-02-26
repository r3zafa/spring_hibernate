package de.demo.mvc.service;

import java.util.List;

import de.demo.mvc.model.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers(int theSortField);
	
	public List<Customer> searchCustomers(String theSearchString);

	
	public Customer getCustomer(int theId);

	public void saveCustomer(Customer theCustomer);

	public void deleteCustomer(int theId);



	
}
