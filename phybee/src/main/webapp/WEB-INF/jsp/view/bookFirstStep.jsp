<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-datepicker.css"/>">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
   <script src="<c:url value="/resources/js/bootstrap-datepicker.js"/>"></script>
  <script src="<c:url value="/resources/js/DatePicker.js"/>"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking - Choose Slot</title>
</head>
<body>
	<br/><br/>
	<div class="row">
	<div class="progress">
   	    <div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style='width: 30%'>30%</div>
    </div>
    </div>
    <div class ="panel panel-primary">
	<form method="get" action="<c:url value="/reservation/movie"/>">
		<h1>Movie</h1><br/>
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
		<br/><br/>
	<h1>Date</h1><br/>
		<div id="datepicker"></div>
		<input name="date" type="hidden" id="date" value="${date}">
		<input type="submit" value="Submit">
		<br/><br/>
	</form>
	</div>
	<table class="table">
		<caption>Available Slot</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>Date</th>
				<th>Choose</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${slot}">
				<tr>
					<td><c:out value="${item.getId()}" /></td>
					<td><c:out value="${item.getStart().toString()} to ${item.getEnd().toString()}"/></td>
					<td><a href="<c:url value="/reservation/ticket?&slot=${item.id}"/>"
						class="link"><c:out value="Book Now !" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>