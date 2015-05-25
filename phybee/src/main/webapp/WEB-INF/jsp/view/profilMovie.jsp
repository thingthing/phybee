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
    <link rel="stylesheet" type="text/css" href="/resources/css/phybee.css" />

    <script type="text/javascript">
        $(document).ready(function(){
            $("#myTab a").click(function(e){
                e.preventDefault();
                $(this).tab('show');
            });
        });
    </script>
    <style type="text/css">
        .bs-example{
            margin: 20px;
        }
    </style>

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
            <div class="embed-responsive embed-responsive-16by9">
                <iframe class="embed-responsive-item" src="http://www.tudou.com/v/GecMp3EZf10/&bid=05&resourceId=0_05_05_99/v.swf"></iframe>
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
</body>
</html>
