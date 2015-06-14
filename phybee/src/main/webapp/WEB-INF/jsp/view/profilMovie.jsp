<%--
  Created by IntelliJ IDEA.
  User: Elyo
  Date: 06/05/2015
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script src="<c:url value="/resources/js/BigTab.js"/>"></script>

<div class="bs-example">
	<ul class="nav nav-tabs" id="myTab">
		<li class="active"><a href="#sectionA" data-toggle="tab">${list.mTitle}</a></li>
		<li><a href="#sectionB" data-toggle="tab">Trailer</a></li>
		<li><a href="#sectionC" data-toggle="tab">Schedule</a></li>
	</ul>
	<div class="tab-content">
		<div id="sectionA" class="tab-pane fade in active">
			<div class="schedule-movielist">
				<div class="schedule-movieprofil-mini-block">
					<h4>${list.mTitle}</h4>
					<div class="movie-info">
						<img class="img-rounded"
							src="<c:url value="/resources/poster/${list.getmPoster()}"/>"
							alt="${list.mTitle}"
							style="max-width: 110px; max-height: 145px; margin-bottom: 20px">
						<table class="table">
							<thead>
								<tr>
									<th><spring:message code="field.runtime" /></th>
									<th><spring:message code="field.open" /></th>
									<th><spring:message code="field.producer" /></th>
									<th><spring:message code="field.genre" /></th>
									<th><spring:message code="field.synopsis" /></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><b><c:out value="${list.mTime}" /></b></td>
									<td><c:out value="${list.mDate}" /></td>
									<td><c:out value="${list.mIdProducer }" /></td>
									<td><c:forEach var="genre" items="${list.mGenre}">
                        	${genre.name}
                        </c:forEach></td>
									<td width="450"><c:out value="${list.mSynopsis}" /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="profil-movie-interact">
						<a href="<c:url value="/reservation/movie?movie=${list.mId}"/>"><button
								type="button" class="btn btn-primary">
								<spring:message code="field.getTicket" />
							</button></a>
					</div>
				</div>
			</div>
		</div>
		<div id="sectionB" class="tab-pane fade">
			<div class="embed-responsive embed-responsive-16by9">
				<iframe class="embed-responsive-item" src="${list.getmTrailer()}"></iframe>
			</div>
		</div>
		<div id="sectionC" class="tab-pane fade">
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
		</div>
	</div>
</div>

