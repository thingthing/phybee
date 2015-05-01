<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking - Choose Tickets</title>
</head>
<body>
	<table>
		<caption>Movie Information</caption>
		<thead>
			<tr>
				<th>Name</th>
				<th>Slot</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><c:out value="${movie}" /></td>
					<td><c:out value="${slot}" /></td>
				</tr>
		</tbody>
	</table>
	<table>
		<caption>Ticket</caption>
		<thead>
			<tr>
				<th>Type name</th>
				<th>Available</th>
				<th>Price</th>
				<th>Number</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ticket}">
				<tr>
					<td><c:out value="${item}" /></td>
					<td><c:out value="30" /></td>
					<td><c:out value="7.90e"/></td>
					<td><input type="text" name="numberTicket" size="30" placeholder="Ticket Number"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>