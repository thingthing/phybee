<%--
  Created by IntelliJ IDEA.
  User: Elyo
  Date: 01/05/2015
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="/resources/css/movie.css" />
    <title>Now Playing Movie</title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
    <p>Now Playing Movie Week n*[]</p>
    <c:choose>
        <c:when test="${empty listmovie}">
            <p>No movies available</p>
        </c:when>
        <c:when test="${not empty listmovie}">
            <div class="movielist">
            <c:forEach var="list" items="${listmovie}">
                        <div class="movieprofil-mini-block">
                           <a href="<c:url value="/movie/movie?slot=${list.mId}"/>" class="link"> <img alt="${list.mTitle}" style="max-width:110px;max-height:145px;" src="${list.mPoster}"></a>
                            <span class="movieprofil-mini-info">
                                <h4>${list.mTitle}</h4>
                                <p>genre:
                                    <c:forEach var="genre" items="${list.mGenre}">
                                        ${genre.name}
                                    </c:forEach>
                                </p>
                                <p>duration: ${list.mTime}</p>
                                <p>available since: ${list.mDate.toString()}</p>
                            </span>
                            <span class="listinput">

                                <a href="<c:url value="/movie/movie?&slot=${list.mId}"/>"><button type="button" class="btn btn-info">infos</button></a>
                                <a href="<c:url value="/movie/movie?&slot=${list.mId}"/>"><button type="button" class="btn btn-info">Schedule</button></a>
                                <a href="<c:url value="/movie/movie?&slot=${list.mId}"/>"><button type="button" class="btn btn-info">Video</button></a>
                                <a href="<c:url value="/reservation/movie?movie=${list.mId}"/>"><button type="button" class="btn btn-info">get tickets</button></a>
                            </span>
                        </div>
            </c:forEach>
            </div>
        </c:when>
    </c:choose>
</body>
</html>