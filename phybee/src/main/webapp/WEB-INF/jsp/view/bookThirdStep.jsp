<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
			style="width: 90%"></div>
	</div>
	<br />
	<h2>
		<span class="label label-primary">Slot Information</span>
	</h2>
	<table class="table">
		<thead>
			<tr>
				<th><spring:message code="reservation.title"/></th>
				<th>Date</th>
                <th><spring:message code="reservation.start"/></th>
                <th><spring:message code="reservation.end"/></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${schedule.getTitle_movie()}" /></td>
				<td><c:out value="${schedule.getDate().toString()}" /></td>
				<td><c:out value="${schedule.getStart().toString()}" /></td>
				<td><c:out value="${schedule.getEnd().toString()}" /></td>
			</tr>
		</tbody>
	</table>
	<br />
	<h2>
		<span class="label label-primary"><spring:message code="reservation.tinfo"/></span>
	</h2>
	<table class="table">
		<thead>
			<tr>
				<th>Type</th>
                <th><spring:message code="reservation.price"/></th>
                <th><spring:message code="reservation.number"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${basket.keySet()}">
				<tr>
					<td><c:out value="${item.getType()}" /></td>
					<td><c:out value="${item.getFormatPrice()}" /></td>
					<td><c:out value="${basket.get(item)}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<table class="table">
		<thead>
			<tr>
				<th><h2>
						<span class="label label-primary">Total</span>
					</h2></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${amount}" /></td>
			</tr>
		</tbody>
	</table>
	<form method="post" action="<c:url value="/reservation/redirection"/>">
		<input type="hidden" name="schedule" value="${schedule.getId()}" />
		<input type="hidden" name="adult" value="${adult}" />
		<input type="hidden" name="child" value="${child}" />
		<input type="hidden" name="disabled" value="${disabled}" />
		<div class="row">
			<a href="<c:url value="/reservation/ticket?schedule=${schedule.getId()}"/>" class="link btn btn-primary"><c:out value="Return" /></a>
			<input type="submit" value="Proceed" class="btn btn-primary">
		</div>
	</form>
</body>
</html>