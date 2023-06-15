package org.ncu.employee_app.controller;


import java.util.List;

import org.ncu.employee_app.entity.Employee;
import org.ncu.employee_app.entity.groupEmp;
import org.ncu.employee_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	
	
	//inject EmployeeService bean into EmployeeeController bean
	@Autowired
	private EmployeeService employeeService;
	
	
	@ModelAttribute(name="employee")
	public Employee getEmployee() {
		return new Employee();
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)  	
	public String getEmployeeForm() {
		return "emp-form";
		
	}

	
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String processBookForm(@ModelAttribute("employee") Employee employee) {
		
		if(employeeService.createRecord(employee) == 1 ) {
			return "confirmation";
		}else {
			return "redirect:/";
		}
	
	}
	
	
	@RequestMapping(value = "/show")
	public String showEmployees(Model model) {
		List<Employee> emps = employeeService.fetchRecords();
		model.addAttribute("emps", emps);
		return "emp-list";
		
		
	}
	
	
	@RequestMapping(value = "/show-sorted")
	public String showSortedEmps(Model model) {
		List<Employee> emps = employeeService.sortList();
		model.addAttribute("emps", emps);
		return "sorted-emp-list";
	}
	
	
	@RequestMapping(value = "/update")
	public String updateEmployee(Model model) {
		return "update-form";
	}
	
	
	@RequestMapping(value = "/update-process", method = RequestMethod.POST)
	public String updateProcess(@ModelAttribute("employee") Employee emp) {
		if(employeeService.updateRecord(emp) == 1 ) {
			return "update-confirm";
		}else {
			return "redirect:/";
		}
	
	}
	
	
	
	@RequestMapping(value = "/delete")
	public String deleteEmployee(Model model) {
		return "delete-form";
	}
	
	@RequestMapping(value = "/delete-process", method = RequestMethod.POST)
	public String deleteProcess(@ModelAttribute("employee") Employee emp) {
		if(employeeService.deleteRecord(emp) == 1 ) {
			return "delete-confirm";
		}else {
			return "redirect:/";
		}
	
	}
	
	@RequestMapping(value = "/delete-all")
	public String deleteAllEmployee() {
		employeeService.deleteAllRecords();
		return "delete-all";
	}
	
	
	@RequestMapping(value = "/search")
	public String searchEmp(Model model) {
		return "search-form";
	}
	
	@RequestMapping(value = "/search-process", method = RequestMethod.POST)
	public String searchProcess(@ModelAttribute("emp") Employee emp, Model model) {
		String name = emp.getEmpName();
		Employee emps = employeeService.readRecord(name);
		
		if(emps != null ) {
			model.addAttribute("employee", emps);			
			return "search-list";
		}else {
			return "redirect:/";
		}
	
	}
	
	
	
	@RequestMapping(value="/Backup-confirm" , method = RequestMethod.POST)
	public String batchBookForm() {
		List<Employee> emps = employeeService.fetchRecords();
			
		employeeService.batchRecordInsert(emps);
		return "Backup-confirm";
	}
	
	
	@RequestMapping(value = "/group")
	public String groupEmp(Model model) {
		employeeService.groupRecords();
		return "group-result";
	}

}



