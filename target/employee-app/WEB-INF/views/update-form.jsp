<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Form</title>
</head>
<body>
<div align="center">
	<form:form action="update-process" method="post" modelAttribute="employee">
		<h1>Enter employee record to update</h1>
		<label for="no">Number of employee to update :</label>
		<form:input type="text" path="empNo" />
		<br>
		<br>
		<br>
		<h4>Enter other details of employee to update:</h4>

		<label for="no">Employee ID Number :</label>
			<form:input type="text" path="empNo" />
			<br>
			<br>

			<label for="name">Employee name :</label>
			<form:input type="text" path="empName" />
			<br>
			<br>
			
			
			<label for="salary">Employee salary :</label>
			<form:input type="text" path="empSalary" />
			<br>
			<br>
			
			<label for="addr">Employee Address :</label>
			<form:input type="text" path="empAddr" />
			<br>
			<br>


		<input type="submit" value="submit" />

	</form:form>
</body>
</html>