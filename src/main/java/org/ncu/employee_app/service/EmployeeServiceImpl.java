package org.ncu.employee_app.service;

import java.util.Collections;


import java.util.Comparator;
import java.util.List;
import org.ncu.employee_app.dao.EmployeeDao;
import org.ncu.employee_app.entity.Employee;
import org.ncu.employee_app.entity.groupEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public int createRecord(Employee employee) {
		return employeeDao.insertEmployee(employee);
		
	}

	@Override
	public Employee readRecord(String empName) {
		Employee emps = employeeDao.fetchEmployee(empName);
		
		if(emps!=null) {
			return emps;
		}else {
			return null;
		}
		
	}

	@Override
	public int updateRecord(Employee employee) {
		return employeeDao.deleteEmployee(employee);
		
	}

	@Override
	public int deleteRecord(Employee employee) {
		return employeeDao.deleteEmployee(employee);
	}
	
	@Override
	public void deleteAllRecords() {
		employeeDao.deleteAllEmployees();
	}

	@Override
	public List<Employee> fetchRecords() {
		List<Employee> emps = employeeDao.fetchEmployees();
		
		if(emps!=null) {
			return emps;
		}else {
			return null;
		}
		
	}
	
	@Override
	public List<groupEmp> groupRecords() {
		List<groupEmp> emps = employeeDao.groupEmployees();
		
		if(emps!=null) {
			return emps;
		}else {
			return null;
		}
		
	}
	
	public List<Employee> sortList() {
		List<Employee> list = employeeDao.fetchEmployees();
		
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.getEmpNo()>o2.getEmpNo())
					return 1;
				return -1;
			}
		});	
		
		//System.out.println("After" + list);
		
		if(list!=null) {
			return list;
		}else {
			return null;
		}
		
	}

	@Override
	public void batchRecordInsert(List<Employee> emps) {
		employeeDao.saveBookEmployees(emps);
		if(emps==null) {
			System.out.println("Error adding batch records");
		}else {
			System.out.println("Batch records saved successfully");
		}
		
	}
	

}
