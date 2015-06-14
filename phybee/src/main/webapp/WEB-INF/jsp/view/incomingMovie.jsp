<%--
  Created by IntelliJ IDEA.
  User: Elyo
  Date: 25/05/2015
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <h4>${list.mTitle}</h4>
                    <a href="<c:url value="/moviedetails?&movie=${list.mId}"/>" class="link"> <img class="img-rounded" alt="${list.mTitle}" style="max-width:110px;max-height:145px;" src="<c:url value="/resources/poster/${list.mPoster}"/>"></a>
                    <div class="schedule-movieprofil-mini">
                            <%--<p class="schedule-movielist-synopsis">Synopsis: ${list.mSynopsis}</p>--%>
                            <p><spring:message code="field.runtime" /> : ${list.mTime}</p>
                            <p><spring:message code="field.open" /> : ${list.mDate.toString()}</p>
                            <p><spring:message code="field.genre" /> :
                                <c:forEach var="genre" items="${list.mGenre}">
                                    ${genre.name}
                                </c:forEach>
                            </p>
                    </div>
                    <div class="schedule-movielist-interact">
                        <a
							href="<c:url value="/moviedetails?&movie=${list.mId}#sectionB"/>"
							class="btn btn-primary"> <spring:message code="field.trailer" />
						</a>
                        <a href="<c:url value="/reservation/movie?movie=${list.mId}"/>"
							class="btn btn-primary"> <spring:message
								code="field.getTicket" /></a>
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
            </c:forEach>
        </div>
    </c:when>
</c:choose>
