<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
</head>
<body>
	<h3>Login Page</h3>
	<br />
	<form:form commandName="login" method="POST" name="login">
		Email:<form:input path="email" />
		<font color="red"><form:errors path="email" /></font>
		<br />
		<br /> Password:<form:password path="password" />
		<font color="red"><form:errors path="password" /></font>
		<br />
		<br />
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>
