<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 01/05/2015
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Sign up successful</title>
</head>
<body>
<div align="center">
  <table border="0">
    <tr>
      <td colspan="2" align="center"><h2>Signing up Succeeded!</h2></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <h3>Thank you for signing up! Here's the review of your details:</h3>
      </td>
    </tr>
    <tr>
      <td>Fist Name:</td>
      <td>${userForm.firstName}</td>
    </tr>
    <tr>
      <td>Last Name:</td>
      <td>${userForm.lastName}</td>
    </tr>
    <tr>
      <td>E-mail:</td>
      <td>${userForm.email}</td>
    </tr>
  </table>
  <a href="<c:url value="/login"/>">Login</a>
</div>
</body>
</html>
