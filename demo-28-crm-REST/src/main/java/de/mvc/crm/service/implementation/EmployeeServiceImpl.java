package de.mvc.crm.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mvc.crm.dao.EmployeeDAO;
import de.mvc.crm.entity.Users;
import de.mvc.crm.service.EmployeeService;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	
	@Override
	@Transactional
	public List<Users> getEmployees() {
		return employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Users theEmployee) {
		employeeDAO.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public Users getEmployee(String theUsername) {
		return employeeDAO.getEmployee(theUsername);
	}

	@Override
	@Transactional
	public void deleteEmployee(String theUsername) {
		employeeDAO.deleteEmployee(theUsername);
	}



}
