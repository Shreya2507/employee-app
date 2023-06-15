package org.ncu.employee_app.dao;
import java.util.List;

import org.ncu.employee_app.entity.Employee;
import org.ncu.employee_app.entity.groupEmp;

public interface EmployeeDao {
	
	public int insertEmployee(Employee employee);
	public Employee fetchEmployee(String empName);
	public int updateEmployee(Employee employee);
	public int deleteEmployee(Employee employee);
	public List<Employee> fetchEmployees();
	public int[] saveBookEmployees(List<Employee> employees);
	public void deleteAllEmployees();
	List<groupEmp> groupEmployees();

}
