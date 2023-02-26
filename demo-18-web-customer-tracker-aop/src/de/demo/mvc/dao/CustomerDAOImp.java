package de.demo.mvc.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.demo.mvc.entity.Customer;
import de.demo.mvc.util.SortUtils;


@Repository
public class CustomerDAOImp implements CustomerDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(int theSortField) {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// determine sort field
		String theFieldName = null;
		
		switch (theSortField) {
		case SortUtils.FIRST_NAME: 
			theFieldName = "firstName";
			break;
		case SortUtils.LAST_NAME: 
			theFieldName = "lastName";
			break;
		case SortUtils.EMAIL: 
			theFieldName = "email";
			break;
		default:
			theFieldName = "lastName";
		}
		
		String queryString = "from Customer order by " + theFieldName;
		
		Query<Customer> theQuery = currentSession.createQuery(queryString,Customer.class);
		// Execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		// return the result 
		return customers;
		
	}
	
	@Override
	public List<Customer> searchCustomers(String theSearchString) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = null;
		
		if (theSearchString != null && theSearchString.trim().length() > 0) {
			
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName",Customer.class);
			theQuery.setParameter("theName", "%" + theSearchString.toLowerCase() + "%");
			
		} else {

			theQuery =currentSession.createQuery("from Customer", Customer.class);
			
		}

		List<Customer> customers = theQuery.getResultList();
		return customers;
	}
	
	@Override
	public Customer getCustomer(int theId) {
		//get session
		Session currentSession = sessionFactory.getCurrentSession();
		// retrieve customer by id
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}
	
	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
	
		//save or update new customer
		currentSession.saveOrUpdate(theCustomer);
		
		}

	@Override
	public void deleteCustomer(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete with HQL
		Query<?> theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
		
		// delete customer by id
		// Customer theCustomer = currentSession.get(Customer.class, theId);
		// currentSession.delete(theCustomer);
		
	}




}
