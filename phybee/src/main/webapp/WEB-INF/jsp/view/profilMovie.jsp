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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-theme.css"/>">
<link rel="stylesheet" type="text/css" href="/resources/css/phybee.css" />
<script src="<c:url value="/resources/js/Tab.js"/>"></script>

<title>${title}</title>
</head>
<body>

	<div class="bs-example">
		<ul class="nav nav-tabs" id="myTab">
			<li class="active"><a href="#sectionA">${list.mTitle}</a></li>
			<li><a href="#sectionB">Trailer</a></li>
			<li><a href="#sectionC">Schedule</a></li>
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
								style="max-width: 110px; max-height: 145px;">
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
					<iframe class="embed-responsive-item"
						src="${list.getmTrailer()}"></iframe>
				</div>
			</div>
			<div id="sectionC" class="tab-pane fade">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Monday</th>
							<th>Tuesday</th>
							<th>Wednesday</th>
							<th>Thursday</th>
							<th>Friday</th>
							<th>Saturday</th>
							<th>Sunday</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
						</tr>
						<tr>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
							<td>14:00</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		</div>
</body>
</html>
