<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add user</title>
</head>
<body>
	<form method="post" action="save-user">
	User Id : <input type="text" name="userid">
	Username : <input type="text" name="username">
	Password : <input type="text" name="password"> 
	<input type="submit" value="Add user">
	</form>
</body>
</html>