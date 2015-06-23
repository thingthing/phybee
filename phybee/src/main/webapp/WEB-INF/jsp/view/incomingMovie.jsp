<%--
  Created by IntelliJ IDEA.
  User: Elyo
  Date: 25/05/2015
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:choose>
	<c:when test="${empty listmovie}">
		<p>No movies available this week !</p>
	</c:when>
	<c:when test="${not empty listmovie}">
		<div class="schedule-movielist">
			<c:forEach var="list" items="${listmovie}">
				<div class="schedule-movieprofil-mini-block">
					<h3>${list.mTitle}</h3>
					<div class="movie-info">
						<a href="<c:url value="/moviedetails?&movie=${list.mId}"/>"> <img
							class="img-rounded"
							src="<c:url value="/resources/poster/${list.getmPoster()}"/>"
							alt="${list.mTitle}"
							style="max-width: 110px; max-height: 145px; margin-right: 50px; margin-bottom: 20px">
						</a>
						<table class="table">
							<thead>
								<tr>
									<th><spring:message code="field.runtime" /></th>
									<th><spring:message code="field.open" /></th>
									<th><spring:message code="field.genre" /></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><b><c:out value="${list.mTime}" /></b></td>
									<td><c:out value="${list.mDate}" /></td>
									<td width="400"><c:forEach var="genre"
											items="${list.mGenre}">${genre.name} </c:forEach></td>
									<td><a
										href="<c:url value="/moviedetails?&movie=${list.mId}#sectionB"/>"
										class="btn btn-primary"> <spring:message
												code="field.trailer" />
									</a> <a
										href="<c:url value="/reservation/movie?movie=${list.mId}"/>"
										class="btn btn-primary"> <spring:message
												code="field.getTicket" />
									</a></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="bs-example container">
						<div class="scroller scroller-left">
							<i class="glyphicon glyphicon-chevron-left"></i>
						</div>
						<div class="scroller scroller-right">
							<i class="glyphicon glyphicon-chevron-right"></i>
						</div>
						<div class="wrapper">
							<ul class="nav nav-tabs list" id="myTab">
								<c:forEach var="item" items="${list.getmDateSchedule()}"
									varStatus="status">
									<li ${status.first ? 'class="active"' : ''}><a
										data-toggle="tab"
										href="#section${list.getmId()}${item.getDate().toString()}">${item.getDate().toString()}</a></li>
								</c:forEach>
							</ul>
						</div>
						<div class="tab-content">
							<c:forEach var="item" items="${list.getmDateSchedule()}"
								varStatus="status">
								<div id="section${list.getmId()}${item.getDate().toString()}"
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
			</c:forEach>
		</div>
	</c:when>
</c:choose>