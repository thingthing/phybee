<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Login Page</title>
</head>
<body>
	<h3>Login Page</h3>
	<br />
	<span style="float: right"> <a href="?lang=en">en</a> | <a
		href="?lang=fr">fr</a>
	</span>
	<form:form commandName="login" name="login">
		<spring:message code="field.email"/>:<form:input path="email" />
		<font color="red"><form:errors path="email" /></font>
		<br />
		<br /> <spring:message code="field.password"/>:<form:password path="password" />
		<font color="red"><form:errors path="password" /></font>
		<br />
		<br />
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>
