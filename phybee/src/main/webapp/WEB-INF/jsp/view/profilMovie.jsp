<%--
  Created by IntelliJ IDEA.
  User: Elyo
  Date: 06/05/2015
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="/resources/css/movie.css" />
    <title>${title}</title>
</head>
<body>
<%--<c:choose>
    <c:when test="${empty listmovie}">
        <p>No movies available</p>
    </c:when>
    <c:when test="${not empty listmovie}">--%>
        <div class="schedule-movielist">
            <div class="schedule-movieprofil-mini-block">
                    <h4>${list.mTitle}</h4>
                    <img class="img-rounded" alt="${list.mTitle}" style="max-width:110px;max-height:145px;" src="<c:url value="/resources/poster/${list.mPoster}"/>">
                            <span class="schedule-movieprofil-mini">
                                <%--<p class="schedule-movielist-synopsis">Synopsis: ${list.mSynopsis}</p>--%>
                                <p>Runtime : ${list.mTime} </p>
                                <p>Open Nationwide : ${list.mDate } </p>
                                <p>Producer : </p>
                                    <p>
                                        Genre: <c:forEach var="genre" items="${list.mGenre}">
                                        ${genre.name}
                                    </c:forEach>
                                    </p>
                                <p>Synopsis : ${list.mSynopsis}</p>
                            </span>
                <div class="profil-movie-interact">
                    <a href="<c:url value="/moviedetails?&movie=${list.mId}"/>"><button type="button" class="btn btn-info">Play</button></a>
                    <a href="<c:url value="/reservation/movie?movie=${list.mId}"/>"><button type="button" class="btn btn-info">Get Tickets</button></a>
                </div>
                    <div>
                        <table>
                            <tr>
                                <td>Monday</td>
                                <td>Tuesday</td>
                                <td>Wednesday</td>
                                <td>Thursday</td>
                                <td>Friday</td>
                                <td>Saturday</td>
                                <td>Sunday</td>
                            </tr>
                        </table>
                    </div>
                        <%--<tr>
                            <td>Cellule 3</td>
                            <td>Cellule 4</td>
                        </tr>--%>
                </div>
        </div>
    <%--</c:when>
</c:choose>--%>
</body>
</html>
