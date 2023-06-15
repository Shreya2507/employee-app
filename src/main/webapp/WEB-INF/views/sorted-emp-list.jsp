<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<h1 align="center">Employee List</h1>

	<br>
	<div align="center">
	<br>
	
		<table border=1>
			<thead>
				<tr>
					<td>Employee Number</td>
					<td>Employee Name</td>
					<td>Employee Salary</td>
					<td>Employee Address</td>
					
					<!-- <td>Operation</td> -->
				</tr>
			</thead>


			<c:forEach var="e" items="${emps}">
				<tr>
					<td>${e.empNo}</td>
					<td>${e.empName }</td>
					<td>${e.empSalary }</td>
					<td>${e.empAddr }</td>
				</tr>
			</c:forEach>

		</table>
		<br>
		<form:form action="Backup-confirm" method="POST">
		<input type="submit" value="Save"></input>
		</form:form>
	</div>
	
<br>
	<a href="/employee-app">
		<button>Go to home page</button>
	</a>
	


<br>
</body>
</html>
