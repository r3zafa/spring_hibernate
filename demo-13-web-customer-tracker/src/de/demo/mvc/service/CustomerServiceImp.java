package de.demo.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.demo.mvc.dao.CustomerDAO;
import de.demo.mvc.model.Customer;

@Service
public class CustomerServiceImp implements CustomerService {

	// inject DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getCustomers(int theSortField) {
		return customerDAO.getCustomers(theSortField);
	}

	
	
	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchString) {
		return customerDAO.searchCustomers(theSearchString);
	}
	
	
	
	
	
	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);

	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);		
	}






	
	
	
	
}
