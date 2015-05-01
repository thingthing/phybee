<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <script src="<c:url value="/resources/js/DatePicker.js"/>"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking - Choose Slot</title>
</head>
<body>
	<form method="get" action="/reservation/movie">
		<label>Movie:</label>
		<select name="movie">
			<c:forEach var="item" items="${movies}">
				<c:choose>
					<c:when test="${movie eq item}">
						<option value="${item}" selected>${item}</option>
					</c:when>
					<c:otherwise>
						<option value="${item}">${item}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<p>Date: <input name="date" type="text" id="datepicker"></p>
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
			<c:forEach var="item" items="${slot}">
				<tr>
					<td><c:out value="NaN" /></td>
					<td><c:out value="${item}"/></td>
					<td><a href="/reservation/ticket?&slot=${item}"
						class="link"><c:out value="Book Now !" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>