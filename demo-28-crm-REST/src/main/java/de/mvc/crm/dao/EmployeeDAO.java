package de.mvc.crm.dao;

import java.util.List;

import de.mvc.crm.entity.Users;

public interface EmployeeDAO {
	public List<Users> getEmployees();
	public void saveEmployee(Users theEmployee);
	public Users getEmployee(String theUsername);
	public void deleteEmployee(String theUsername);
}
