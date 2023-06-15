package org.ncu.employee_app.service;

import java.util.List;

import org.ncu.employee_app.entity.Employee;
import org.ncu.employee_app.entity.groupEmp;


public interface EmployeeService {
	public int createRecord(Employee employee);
		
	public Employee readRecord(String empName);
	
	public int updateRecord(Employee employee);
	
	public int deleteRecord(Employee employee);
	
	public List<Employee> fetchRecords();
	
	public List<Employee> sortList();
	
	public void batchRecordInsert(List<Employee> employees);
	
	public void deleteAllRecords();

	List<groupEmp> groupRecords();

}
