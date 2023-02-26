package de.demo.mvc.dao;

import java.util.List;
import de.demo.mvc.model.Customer;

public interface CustomerDAO {
	
	
	public List<Customer> getCustomers(int theSortField);

	public List<Customer> searchCustomers(String theSearchString);

	public Customer getCustomer(int theId);

	public void saveCustomer(Customer theCustomer);

	public void deleteCustomer(int theId);


}
