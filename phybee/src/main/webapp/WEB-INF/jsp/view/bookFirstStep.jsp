<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
							<c:when test="${movie eq item.id}">
								<option value="${item.id}" selected>${item.title}</option>
							</c:when>
							<c:otherwise>
								<option value="${item.id}">${item.title}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div id="datepicker" class="form-group"></div>
			<input name="date" type="hidden" id="date" value="${date}"> <input
				type="submit" value="Submit" class="btn btn-primary">
		</form>
	</div>
</div>
<br />
<br />
<h2>
	<span class="label label-primary"><spring:message
			code="reservation.availableSlot" /></span>
</h2>

<div class="bs-example container">
	<div class="scroller scroller-left">
		<i class="glyphicon glyphicon-chevron-left"></i>
	</div>
	<div class="scroller scroller-right">
		<i class="glyphicon glyphicon-chevron-right"></i>
	</div>
	<div class="wrapper">
		<ul class="nav nav-tabs list" id="myTab">
			<c:forEach var="item" items="${schedule}" varStatus="status">
				<li ${status.first ? 'class="active"' : ''}><a
					data-toggle="tab" href="#section${item.getDate().toString()}">${item.getDate().toString()}</a></li>
			</c:forEach>
		</ul>
	</div>
	<div class="tab-content">
		<c:forEach var="item" items="${schedule}" varStatus="status">
			<div id="section${item.getDate().toString()}"
				${status.first ? 'class="tab-pane fade in active"' : 'class="tab-pane fade"'}>
				<table class="table">
					<thead>
						<tr>
							<th><spring:message code="field.schedule" /></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="litem" items="${item.getSchedule()}">
							<tr>
								<td><c:out
										value="${litem.getStart().toString()} to ${litem.getEnd().toString()}" /></td>
								<td><a
									href="<c:url value="/reservation/ticket?schedule=${litem.getId()}"/>"
									class="link btn btn-primary"> <spring:message
											code="reservation.book" />
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:forEach>
	</div>
</div>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js"/>"></script>
<script src="<c:url value="/resources/js/DatePicker.js"/>"></script>
<script src="<c:url value="/resources/js/BigTab.js"/>"></script>