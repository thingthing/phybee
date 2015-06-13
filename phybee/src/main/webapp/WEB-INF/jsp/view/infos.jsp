<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>

<div>
    <h3><img src="<c:url value="/resources/logo/Phybee.png"/>" style="height: 50px; width: auto"> Phybee</h3>
    69 Rue de la Goutte-d'Or, 75018 Paris
    <div class="bs-example">
        <ul class="nav nav-tabs" id="myTab">
            <li class="active"><a href="#sectionA">Information</a></li>
            <li><a href="#sectionB"><spring:message code="info.access" /></a></li>
            <li><a href="#sectionC"><spring:message code="info.price" /></a></li>
        </ul>
        <div class="tab-content">
            <div id="sectionA" class="tab-pane fade in active">
                <div class="schedule-movielist">
                    <div class="schedule-movieprofil-mini-block">
                        <h4>${list.mTitle}</h4>
                        <img class="img-rounded" alt="${list.mTitle}" style="max-width:110px;max-height:145px;" src="<c:url value="/resources/poster/${list.mPoster}"/>">
                            <span class="schedule-movieprofil-mini">
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
                            <a href="<c:url value="/reservation/movie?movie=${list.mId}"/>"><button type="button" class="btn btn-primary">Get Tickets</button></a>
                        </div>
                    </div>
                </div>
            </div>
            <div id="sectionB" class="tab-pane fade">
                <div>
                    <spring:message code="info.subway" /><img src="<c:url value="" />" style= "height:10px; width: auto">
                    <img src="<c:url value="" />" style= "height:10px; width: auto">La Chapelle <spring:message code="message.or" /> Barbès-Rochechouart
                    <img src="<c:url value="" />" style= "height:10px; width: auto">Barbès-Rochechouart, Château Rouge, Marcadet -Poissoniers
                    <img src="<c:url value="" />" style= "height:10px; width: auto"> Marx Dormoy, Porte de la Chapelle
                </div>
                <div>
                    Bus<img src="<c:url value="" />" style= "height:10px; width: auto">
                    <img src="<c:url value="" />" style= "height:10px; width: auto">La Chapelle <spring:message code="message.or" /> Barbès-Rochechouart
                    <img src="<c:url value="" />" style= "height:10px; width: auto">Barbès-Rochechouart, Château Rouge <spring:message code="message.or" /> Marcadet-Poissoniers
                    <img src="<c:url value="" />" style= "height:10px; width: auto"> Marx Dormoy <spring:message code="message.or" /> Porte de la Chapelle
                </div>
                <div>
                    RER<img src="<c:url value="" />" style= "height:10px; width: auto">
                    <img src="<c:url value="" />" style= "height:10px; width: auto">La Chapelle <spring:message code="message.or" /> Barbès-Rochechouart
                    <img src="<c:url value="" />" style= "height:10px; width: auto">Barbès-Rochechouart, Château Rouge <spring:message code="message.or" /> Marcadet-Poissoniers
                    <img src="<c:url value="" />" style= "height:10px; width: auto"> Marx Dormoy <spring:message code="message.or" /> Porte de la Chapelle
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
</body>
</html>
