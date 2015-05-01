<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 01/05/2015
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<div align="center">
  <form:form action="register" method="post" commandName="userForm">
    <table border="0">
      <tr>
        <td colspan="2" align="center"><h2>Phybee - Sign up</h2></td>
      </tr>
      <tr>
        <td>First Name:</td>
        <td><form:input path="firstName" /></td>
      </tr>
      <tr>
        <td>Last Name:</td>
        <td><form:input path="lastName" /></td>
      </tr>
      <tr>
        <td>E-mail:</td>
        <td><form:input path="email" /></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><form:password path="password" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" value="Register" /></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>
