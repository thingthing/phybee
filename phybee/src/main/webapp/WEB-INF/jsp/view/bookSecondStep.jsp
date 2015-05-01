<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking - Choose Tickets</title>
</head>
<body>
	<br/><br/>
	<div class="progress">
        <div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">60%</div>
    </div>
	<table class="table">
		<caption>Movie Information</caption>
		<thead>
			<tr>
				<th>Title</th>
				<th>Producer</th>
				<th>Synopsis</th>
				<th>Duration</th>
				<th>Start Time</th>
				<th>End Time</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><c:out value="${movie.getmTitle()}"/></td>
					<td><c:out value="${movie.getmProducer()}"/></td>
					<td><c:out value="${movie.getmSynopsis()}"/></td>
					<td><c:out value="${movie.getmTime()}"/></td>
					<td><c:out value="${slot.getStart().toString()}"/></td>
					<td><c:out value="${slot.getEnd().toString()}"/></td>
					<td><c:out value="${slot.getDate().toString()}"/></td>
				</tr>
		</tbody>
	</table>
	<form method="post" action="<c:url value="/reservation/validation"/>">
	<table class="table">
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
					<td><c:out value="${item.getType()}" /></td>
					<td><c:out value="${slot.getSeat_remain()}"/></td>
					<td><c:out value="${item.getPrice()}"/></td>
					<td><input type="number" name="${item.getType()}" size="30" min="0" max="${slot.getSeat_remain()}" step="1" value="0"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="hidden" name="slot" value="${slot}"/>
	<input type="submit" value="Pay !">
	</form>
</body>
</html>