<%@page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>
    <h3 style="text-align: center">${user.firstName} ${user.lastName}</h3>
    <a href="<c:url value="/changePwd"/>"><spring:message code="account.changePwd" /></a>
    <br /><br />
    <div class="profil-reservList">
<table border="1" style="width: 100%">
    <tr>
        <th colspan="9"><spring:message code="account.movieList" /></th>
    </tr>
    <tr>
        <th><spring:message code="reservation.poster" /></th>
        <th><spring:message code="reservation.title" /></th>
        <th><spring:message code="reservation.date" /></th>
        <th><spring:message code="reservation.start" /></th>
        <th><spring:message code="reservation.end" /></th>
        <th><spring:message code="reservation.duration" /></th>
        <th><spring:message code="reservation.adult" /></th>
        <th><spring:message code="reservation.child" /></th>
        <th><spring:message code="reservation.disabled" /></th>
    </tr>
        <c:choose>
        <c:when test="${empty listmovie}">
    <tr>
        <td colspan="9"><spring:message code="account.noList" /></td>
    </tr>
        </c:when>
        <c:when test="${not empty listmovie}">
        <c:forEach var="list" items="${listmovie}">
    <tr>
            <td>
            <a href="<c:url value="/moviedetails?movie=${list.schedule.movie.id}"/>" class="link"> <img class="img-rounded" alt="${list.schedule.movie.title}" style="max-width:110px;max-height:145px;" src="<c:url value="/resources/poster/${list.schedule.movie.poster}"/>"></a>
            </td>
            <td>
            <a href="<c:url value="/moviedetails?movie=${list.schedule.movie.id}"/>" class="link">${list.schedule.movie.title}</a>
            </td>
            <td>${list.schedule.scheduleDate}</td>
            <td>${list.schedule.start}</td>
            <td>${list.schedule.end}</td>
            <td>${list.schedule.movie.duration}</td>
            <td>${list.adult}</td>
            <td>${list.child}</td>
            <td>${list.disabled}</td>
    </tr>
        </c:forEach>
        </c:when>
        </c:choose>
</table>
    </div>
</body>
</html>