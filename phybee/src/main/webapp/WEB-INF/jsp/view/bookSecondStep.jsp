<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="progress">
	<div class="progress-bar progress-bar-striped" role="progressbar"
		aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
		style="width: 60%"></div>
</div>
<br />
<c:choose>
	<c:when test="${not empty error}">
		<h4>
			<span class="label label-danger">${error}</span>
		</h4>
	</c:when>
</c:choose>
<h2>
	<span class="label label-primary"><spring:message
			code="reservation.minfo" /></span>
</h2>
<br />
<div class="movie-info">
	<img class="img-circle"
		src="<c:url value="/resources/poster/${movie.poster}"/>"
		alt="${movie.id}" width="140" height="140">
	<table class="table">
		<thead>
			<tr>
				<th><spring:message code="reservation.title" /></th>
				<th>Synopsis</th>
				<th><spring:message code="reservation.duration" /></th>
				<th><spring:message code="reservation.start" /></th>
				<th><spring:message code="reservation.end" /></th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><b><c:out value="${movie.title}" /></b></td>
				<td width="450"><c:out value="${movie.synopsis}" /></td>
				<td><c:out value="${movie.duration}" /></td>
				<td><c:out value="${schedule.start.toString()}" /></td>
				<td><c:out value="${schedule.end.toString()}" /></td>
				<td><c:out value="${schedule.scheduleDate.toString()}" /></td>
			</tr>
		</tbody>
	</table>
</div>
<form method="post" action="<c:url value="/reservation/validation"/>">
	<br />
	<h2>
		<span class="label label-primary"><spring:message
				code="reservation.tinfo" /></span>
	</h2>
	<table class="table">
		<thead>
			<tr>
				<th>Type</th>
				<th><spring:message code="reservation.seats" /></th>
				<th><spring:message code="reservation.price" /></th>
				<th><spring:message code="reservation.number" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ticket}">
				<tr>
					<td><c:out value="${item.getType()}" /></td>
					<c:choose>
						<c:when test="${item.type eq 'Disabled'}">
							<td><c:out value="${schedule.prioritySeatRemain}" /></td>
							<td><c:out value="${item.getFormatPrice()}" /></td>
							<td><input type="number" name="${item.getType()}" size="30"
								min="0" max="${schedule.prioritySeatRemain}" step="1"
								value="0"></td>
						</c:when>
						<c:otherwise>
							<td><c:out value="${schedule.seatRemain}" /></td>
							<td><c:out value="${item.getFormatPrice()}" /></td>
							<td><input type="number" name="${item.getType()}" size="30"
								min="0" max="${schedule.seatRemain}" step="1" value="0"></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="hidden" name="schedule" value="${schedule.id}" />
	<div class="row">
		<a href="<c:url value="/reservation/movie?movie=${movie.id}"/>"
			class="link btn btn-primary"><c:out value="Return" /></a> <input
			type="submit" value="Continue" class="btn btn-primary">
	</div>
</form>