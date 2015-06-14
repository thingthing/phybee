<%--
  Created by IntelliJ IDEA.
  User: Elyo
  Date: 05/05/2015
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="/resources/css/phybee.css" />
</head>
<body>
<c:choose>
    <c:when test="${empty listmovie}">
        <p>No movies available next week !</p><br>
    </c:when>
    <c:when test="${not empty listmovie}">
        <div class="schedule-movielist">
            <c:forEach var="list" items="${listmovie}">
                <div class="schedule-movieprofil-mini-block">
                    <h3>${list.mTitle}</h3>
                    <div class="movie-info">
					<a href="<c:url value="/moviedetails?&movie=${list.mId}"/>">
							<img class="img-rounded"
								src="<c:url value="/resources/poster/${list.getmPoster()}"/>"
								alt="${list.mTitle}"
								style="max-width: 110px; max-height: 145px; margin-right: 50px; margin-bottom: 20px" >
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
										<td width="400"><c:forEach var="genre" items="${list.mGenre}">${genre.name} </c:forEach></td>
										<td>
                        <a href="<c:url value="/moviedetails?&movie=${list.mId}#sectionB"/>"><button type="button" class="btn btn-primary">Play</button></a>
                        <a href="<c:url value="/reservation/movie?movie=${list.mId}"/>"><button type="button" class="btn btn-primary">Get Tickets</button></a>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
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
                <br/>
            </c:forEach>
        </div>
    </c:when>
</c:choose>
</body>
</html>
