<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Group</title>
</head>
<body>
	<h1 align="center">Employee Groups</h1>

	<br>
	<div align="center">
		
		<table border=1>
			<thead>
				<tr>
					<td>Total number of employees</td>
					<td>Employee Address</td>
				</tr>
			</thead>


			<c:forEach var="e" items="${emps}">
				<tr>
					<td>${e.empNo}</td>
					<td>${e.empName }</td>
				</tr>
			</c:forEach>

		</table>
		<br>
	
<br>
	<a href="/employee-app">
		<button>Go to home page</button>
	</a>
	


<br>
</body>
</html>
