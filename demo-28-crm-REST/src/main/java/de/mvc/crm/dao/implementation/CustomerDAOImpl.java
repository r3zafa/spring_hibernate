package de.mvc.crm.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.mvc.crm.dao.CustomerDAO;
import de.mvc.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;// need to inject the session factory

	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession(); // get the current hibernate session
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);// create a query ... sort by last name
		List<Customer> customers = theQuery.getResultList(); // execute query and get result list
		return customers;// return the results
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();// get current hibernate session
		currentSession.saveOrUpdate(theCustomer); // save/update the customer
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();// get the current hibernate session
		Customer theCustomer = currentSession.get(Customer.class, theId);// now retrieve/read from database using the primary key
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<?> theQuery = currentSession.createQuery("delete from Customer where id=:customerId"); // delete object with primary key
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}
}
