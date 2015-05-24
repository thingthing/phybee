<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-theme.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/phybee.css"/>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body class="content">
	<br />
	<br />
	<div class="progress">
		<div class="progress-bar progress-bar-striped" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 60%"></div>
	</div>
	<br />
	<h2>
		<span class="label label-primary">Movie Information</span>
	</h2>
	<table class="table">
		<thead>
			<tr>
				<th></th>
				<th>Title</th>
				<th>Synopsis</th>
				<th>Duration</th>
				<th>Start Time</th>
				<th>End Time</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><img alt="${movie.getmTitle()}" style="max-width:110px;max-height:145px;" src="${movie.getmPoster()}"></td>
				<td><c:out value="${movie.getmTitle()}" /></td>
				<td width="450"><c:out value="${movie.getmSynopsis()}" /></td>
				<td><c:out value="${movie.getmTime()}" /></td>
				<td><c:out value="${schedule.getStart().toString()}" /></td>
				<td><c:out value="${schedule.getEnd().toString()}" /></td>
				<td><c:out value="${schedule.getDate().toString()}" /></td>
			</tr>
		</tbody>
	</table>
	<form method="post" action="<c:url value="/reservation/validation"/>">
		<br />
		<h2>
			<span class="label label-primary">Ticket</span>
		</h2>
		<table class="table">
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
						<c:choose>
							<c:when test="${item.type eq 'Disabled'}">
								<td><c:out value="${schedule.getPriority_seat_remain()}" /></td>
								<td><c:out value="${item.getFormatPrice()}" /></td>
								<td><input type="number" name="${item.getType()}" size="30"
									min="0" max="${schedule.getPriority_seat_remain()}" step="1" value="0"></td>
							</c:when>
							<c:otherwise>
								<td><c:out value="${schedule.getSeat_remain()}" /></td>
								<td><c:out value="${item.getFormatPrice()}" /></td>
								<td><input type="number" name="${item.getType()}" size="30"
									min="0" max="${schedule.getSeat_remain()}" step="1" value="0"></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="hidden" name="schedule" value="${schedule.id}" />
		<div class="row">
			<a href="<c:url value="/reservation/movie?movie=${movie.getmId()}"/>" class="link btn btn-primary"><c:out value="Return" /></a>
			<input type="submit" value="Continue" class="btn btn-primary">
		</div>
	</form>
</body>
</html>