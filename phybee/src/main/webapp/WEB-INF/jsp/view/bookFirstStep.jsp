<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking - Choose Slot</title>
</head>
<body>
	<form method="post" action="/EnterpriseJavaProgramming/reservation">
		<label>Movie:</label>
		<select name="movie">
			<c:forEach var="item" items="${requestScope.movies}">
				<c:choose>
					<c:when test="${requestScope.movie eq item}">
						<option value="${item}" selected>${item}</option>
					</c:when>
					<c:otherwise>
						<option value="${item}">${item}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<select name="date">
			<c:forEach var="item" items="${requestScope.dates}">
				<c:choose>
					<c:when test="${requestScope.date eq item}">
						<option value="${item}" selected>${item}</option>
					</c:when>
					<c:otherwise>
						<option value="${item}">${item}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<input type="submit" value="Submit">
	</form>
	<table>
		<caption>Available Slot</caption>
		<thead>
			<tr>
				<th>Code</th>
				<th>Date</th>
				<th>Choose</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${requestScope.slots}">
				<tr>
					<td><c:out value="NaN" /></td>
					<td><c:out value="${item}" /></td>
					<td><a href="/EnterpriseJavaProgramming/reservation?slot=1"
						class="link"><c:out value="Book Now !" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>