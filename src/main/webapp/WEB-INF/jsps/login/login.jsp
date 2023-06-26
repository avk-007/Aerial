<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>

<body>
</body>
<h2>login here</h2>
<form action="verifyLogin" method="post">
	emailId<input type="text" name="emailId" /> 
	password<input type="text"name="password" /> 
		<input type="submit" name="login" />
</form>
${error}
</html>