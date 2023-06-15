<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Input Form</title>
</head>
<body>
<div align="center">

		<h2 align="center">Employee record insertion Form</h2>
		<br>
		<hr>
	    <div align="center">
		<form:form action="process" method="post" modelAttribute="employee">

			<label for="no">Employee Number :</label>
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
		<hr>

	</div>
</body>
</html>