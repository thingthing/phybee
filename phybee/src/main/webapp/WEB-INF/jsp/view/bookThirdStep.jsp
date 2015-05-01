<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book - Summary</title>
</head>
<body>
	<br/><br/>
	<div class="progress">
        <div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 90%">90%</div>
    </div>
	<table class="table">
		<caption>Slot Information</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Date</th>
				<th>Start Time</th>
				<th>End Time</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><c:out value="${slot.getId()}"/></td>
					<td><c:out value="${slot.getTitle_movie()}"/></td>
					<td><c:out value="${slot.getDate().toString()}"/></td>
					<td><c:out value="${slot.getStart().toString()}"/></td>
					<td><c:out value="${slot.getEnd().toString()}"/></td>
				</tr>
		</tbody>
	</table>
	<table class="table">
		<caption>Ticket Information</caption>
		<thead>
			<tr>
				<th>Type</th>
				<th>Price</th>
				<th>Number</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${ticket}">
				<tr>
					<td><c:out value="${item.getType()}"/></td>
					<td><c:out value="${item.getPrice()}"/></td>
					<td><c:out value="${item.getNumber()}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table class="table">
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
		<form method="post" action="<c:url value="/reservation/redirection"/>">
		<label>Payment</label>
		<select name="payment">
			<c:forEach var="item" items="${payment}">
				<option value="${item}">${item}</option>
			</c:forEach>
		</select>
		<input type="hidden" name="slot" value="${slot.getId()}"/>
		<input type="hidden" name="ticket" value="${ticket}"/>
		<input type="hidden" name="amount" value="${amount}"/>
		<input type="submit" value="Proceed">
	</form>
</body>
</html>