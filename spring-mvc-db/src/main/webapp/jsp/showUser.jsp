<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show user by ID</title>
</head>
<body>
	<form action="/show-user" method="get">
		User ID : <input type="text" name="userid"> <br/>
		<input type="submit" value="Show details">
	</form>
</body>
</html>