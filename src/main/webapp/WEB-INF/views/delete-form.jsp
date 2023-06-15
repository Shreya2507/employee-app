<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete form</title>
</head>
<body>
	<div align="center">
		<form:form action="delete-process" method="post" modelAttribute="employee">
			<h1>Delete an employee record</h1>
			<label for="no">Employee ID Number to delete :</label>
			<form:input type="text" path="empNo" />
			<br>
			<br>
			<br>
			<input type="submit" value="submit" />

		</form:form>
</body>
</html>