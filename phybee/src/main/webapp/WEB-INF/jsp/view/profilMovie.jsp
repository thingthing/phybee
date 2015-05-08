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
                    <h4>${title}</h4>
                    <img alt="${list.mTitle}" style="max-width:110px;max-height:145px;" src="${list.mPoster}">
                            <span class="schedule-movieprofil-mini">
                                <%--<p class="schedule-movielist-synopsis">Synopsis: ${list.mSynopsis}</p>--%>
                                <p>Runtime : </p>
                                <p>Open Nationwide : </p>
                                <p>Distributor : </p>
                                <p>Starring : </p>
                                <p>Synopsis : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque malesuada velit a arcu sodales, vel pellentesque mi laoreet. Phasellus varius metus a finibus laoreet. Vestibulum feugiat congue ligula, sit amet elementum diam. Nam venenatis eget nisi sit amet luctus. Aenean elementum quis lorem consectetur consequat. Vivamus pellentesque at velit vitae imperdiet. Maecenas efficitur congue leo, eu aliquam turpis tempor id. Nulla tincidunt tellus sit amet placerat porttitor. </p>
                            </span>
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
