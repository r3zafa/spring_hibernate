package de.mvc.crm.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import de.mvc.crm.dao.EmployeeDAO;
import de.mvc.crm.entity.Users;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private SessionFactory sessionFactory;
	private PasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	
	@Override
	public List<Users> getEmployees() {
		Session theSession = sessionFactory.getCurrentSession();
		Query<Users> theQuery = theSession.createQuery("from Users order by username", Users.class);
		List<Users> theEmployees = theQuery.getResultList();
		return theEmployees;
	}

	@Override
	public void saveEmployee(Users theEmployee) {
		Session theSession = sessionFactory.getCurrentSession();
		Users newUser = theEmployee;
		String pwd = pwEncoder.encode(theEmployee.getPassword());
		String encodedPwd = "{bcrypt}" + pwd;
		newUser.setPassword(encodedPwd);
		
		theSession.saveOrUpdate(newUser);
	}

	@Override
	public Users getEmployee(String theUsername) {
		Session theSession = sessionFactory.getCurrentSession();
		Users theEmployee = theSession.get(Users.class, theUsername);
		return theEmployee;
	}

	@Override
	public void deleteEmployee(String theUsername) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Users theEmployee = currentSession.get(Users.class, theUsername);
		currentSession.delete(theEmployee);
	}

}
