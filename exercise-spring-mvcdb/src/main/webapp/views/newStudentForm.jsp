<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Student</title>
</head>
<body>
	<form action="save-student" method="post">
		Regno : <input type="text" name="regno"><br>
		Student name : <input type="text" name="sname"><br>
		Subject : <input type="text" name="subject"><br>
		Marks : <input type="text" name="marks"><br>
		<input type="submit" value ="Add Student">
	</form>
</body>
</html>