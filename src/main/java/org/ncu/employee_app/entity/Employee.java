package org.ncu.employee_app.entity;

public class Employee {
	private int empNo;
	private String empName;
	private double empSalary;
	private String empAddr;
	
	public Employee() {
		
	}
	
	
	public Employee(int empNo, String empName, double empSalary, String empAddr) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAddr = empAddr;
	}



	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public double getEmpSalary() {
		return empSalary;
	}


	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}


	public String getEmpAddr() {
		return empAddr;
	}


	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}


	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empSalary=" + empSalary + ", bookAddr="
				+ empAddr + "]";
	}
	
	
	

}
