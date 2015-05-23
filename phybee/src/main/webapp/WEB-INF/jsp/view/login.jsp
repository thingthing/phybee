<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
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

	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>

	<form name="loginForm"
		action="<c:url value='/auth/login_check' />"
		method='POST'>
		<spring:message code="field.email" />
		:
		<input type='text' name="email" />
		<spring:message code="field.password" />
		:
		<input type='password' name="password" />
		<input type="submit" value="Login" />
	</form>
</body>
</html>
