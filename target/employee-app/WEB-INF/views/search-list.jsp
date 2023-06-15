<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search results</title>
</head>
<body>
	<h1 align="center">Employee Search Result</h1>

	<br>
	<div align="center">

		<table border=1>
			<thead>
				<tr>
					<td>Employee Number</td>
					<td>Employee Name</td>
					<td>Employee Salary</td>
					<td>Employee Address</td>
					
				</tr>
			</thead>


				<tr>
					<td>${employee.empNo }</td>
					<td>${employee.empName }</td>
					<td>${employee.empSalary }</td>
					<td>${employee.empAddr }</td>
				</tr>
			

		</table>
	</div>

	<br>
	<a href="/employee-app">
		<button>Go to home page</button>
	</a>

	<br>

</body>
</html>