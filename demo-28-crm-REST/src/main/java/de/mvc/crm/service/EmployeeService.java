package de.mvc.crm.service;
import java.util.List;
import de.mvc.crm.entity.Users;

public interface EmployeeService {
	public List<Users> getEmployees();
	public void saveEmployee(Users theEmployee);
	public Users getEmployee(String theUsername);
	public void deleteEmployee(String theUsername);
}
