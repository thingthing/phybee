<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
  <table>
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
