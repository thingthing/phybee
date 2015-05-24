<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-datepicker.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/phybee.css"/>">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js"/>"></script>
<script src="<c:url value="/resources/js/DatePicker.js"/>"></script>
<body>
	<div class="progress">
		<div class="progress-bar progress-bar-striped" role="progressbar"
			aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
			style="width: 30%"></div>
	</div>
	<br />
	<br />
	<div class="panel panel-primary container content">
		<div class="panel-body">
			<form class="form-inline" method="get"
				action="<c:url value="/reservation/movie"/>">
				<div class="form-group">
					<select name="movie">
						<c:forEach var="item" items="${movies}">
							<c:choose>
								<c:when test="${movie eq item.getmId()}">
									<option value="${item.getmId()}" selected>${item.getmTitle()}</option>
								</c:when>
								<c:otherwise>
									<option value="${item.getmId()}">${item.getmTitle()}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<div id="datepicker" class="form-group"></div>
				<input name="date" type="hidden" id="date" value="${date}">
				<input type="submit" value="Submit" class="btn btn-primary">
			</form>
		</div>
	</div>
	<br />
	<br />
	<h2>
		<span class="label label-primary">Available Slot</span>
	</h2>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Date</th>
				<th>Choose</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${schedule}">
				<tr>
					<td><c:out value="${item.getId()}" /></td>
					<td><c:out value="${item.getStart().toString()} to ${item.getEnd().toString()}" /></td>
					<td><a href="<c:url value="/reservation/ticket?schedule=${item.id}"/>" class="link btn btn-primary"><c:out value="Book Now !" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>