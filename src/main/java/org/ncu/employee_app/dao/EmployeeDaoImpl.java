package org.ncu.employee_app.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.ncu.employee_app.entity.Employee;
import org.ncu.employee_app.entity.groupEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository  //stereotype annotation
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertEmployee(Employee employee) {
		String query = "insert into employees values(?,?,?,?)";
		Object[] arr = {employee.getEmpNo(), employee.getEmpName(), employee.getEmpSalary(), employee.getEmpAddr()};
		int result = jdbcTemplate.update(query, arr);
		if (result>0) {
			System.out.println("Record inserted successfully!");
			return 1;
		}else {
			System.out.println("Error inserting !");
			return 0;
		}
		
	}

	@Override
	public Employee fetchEmployee(String empName) {		
		String query = "select * from employees where Emp_Name=?";
		Object[] arr = {empName};
		
		
		Employee obj =jdbcTemplate.queryForObject(query, new EmployeeDaoRowMapper(), arr);
		System.out.println(obj);
		return obj;
		
		
	}

	@Override
	public int updateEmployee(Employee employee) {
		
		String query1 = "update employees set Emp_Name=?, Emp_Salary=?, Emp_Address=? where Emp_No=?";
		Object[] arr = {employee.getEmpName(), employee.getEmpSalary(), employee.getEmpAddr(), employee.getEmpNo()};
		int result = jdbcTemplate.update(query1, arr);
		if (result>0) {
			System.out.println("Record updated successfully!");
			return 1;
		}else {
			System.out.println("Error updating !");
			return 0;
		}
		
	}

	@Override
	public int deleteEmployee(Employee employee) {
		System.out.println("Inside dao layer");
		
		String query1 = "delete from employees where Emp_No=?";
		Object[] arr = {employee.getEmpNo()};
		int result = jdbcTemplate.update(query1, arr);
		if (result>0) {
			System.out.println("Record deleted successfully!");
			return 1;
		}else {
			System.out.println("Error deleting !");
			return 0;
		}	
		
		
	}

	@Override
	public void deleteAllEmployees() {
		String query1 = "delete from employees";
		jdbcTemplate.update(query1);
	}
	
	
	@Override
	public List<Employee> fetchEmployees() {
		String query = "select * from employees";
		
		return jdbcTemplate.query(query, new EmployeeDaoRowMapper());
		
	}

	@Override
	public int[] saveBookEmployees(List<Employee> employees) {
		String query = "insert into employees_backup values(?,?,?,?)";
		
		int[] records = jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Employee e = employees.get(i);
				ps.setInt(   1, e.getEmpNo());
				ps.setString(2, e.getEmpName());
				ps.setDouble(3, e.getEmpSalary());
				ps.setString(4, e.getEmpAddr());
			}
			
			
			@Override
			public int getBatchSize() {
				
				return employees.size();
			}
			
		});
		return records;
	}
	
	
	@Override
	public List<groupEmp> groupEmployees() {
		
		String query = " select count(*), Emp_Address from employees group by Emp_Address";
		
		return jdbcTemplate.query(query, new ResultSetExtractor<List<groupEmp>>(){  
		     @Override  
		     public List<groupEmp> extractData(ResultSet rs) throws SQLException, DataAccessException {  
		      
		        List<groupEmp> list = new ArrayList<groupEmp>();  
		        while(rs.next()){   
		        	groupEmp e=new groupEmp();  
		        	e.setCount(rs.getInt(1));  
		        	e.setAddr(rs.getString(2));   
		        	list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
	}  
	
	          
}
