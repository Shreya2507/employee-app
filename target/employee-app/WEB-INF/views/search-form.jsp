<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search form</title>
</head>
<body>
	<div align="center">
		<form:form action="search-process" method="post" modelAttribute="employee">
			<h1>Search an employee by name</h1>
			<label for="name">Name of employee:</label>
			<form:input type="text" path="empName" />
			<br>
			<br>
			<br>
			<input type="submit" value="submit" />

		</form:form>
</body>
</html>