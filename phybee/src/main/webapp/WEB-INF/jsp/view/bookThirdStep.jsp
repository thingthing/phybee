<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book - Summary</title>
</head>
<body>
	<table>
		<caption>Slot Information</caption>
		<thead>
			<tr>
				<th>Slot</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><c:out value="${slot}"/></td>
				</tr>
		</tbody>
	</table>
	<table>
		<caption>Ticket Information</caption>
		<thead>
			<tr>
				<th>Type</th>
				<th>Number</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ticket}">
				<tr>
					<td><c:out value="${item}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<caption>Amount</caption>
		<thead>
			<tr>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${amount}"/></td>
			</tr>
		</tbody>
	</table>
		<form method="post" action="/phybee/reservation/redirection">
		<label>Payment</label>
		<select name="payment">
			<c:forEach var="item" items="${payment}">
				<option value="${item}">${item}</option>
			</c:forEach>
		</select>
		<input type="hidden" name="slot" value="${slot}"/>
		<input type="hidden" name="ticket" value="${ticket}"/>
		<input type="submit" value="Proceed">
	</form>
</body>
</html>