<%--
  Created by IntelliJ IDEA.
  User: Elyo
  Date: 01/05/2015
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:choose>
	<c:when test="${empty listmovie}">
		<p>No movies available</p>
	</c:when>
	<c:when test="${not empty listmovie}">
		<div class="movielist">
			<c:forEach var="list" items="${listmovie}">
				<div class="movieprofil-mini-block">
					<a href="<c:url value="/moviedetails?movie=${list.mId}"/>"
						class="link"> <img class="img-rounded" alt="${list.mTitle}"
						style="max-width: 110px; max-height: 145px; margin: 20px"
						src="<c:url value="/resources/poster/${list.mPoster}"/>"></a>
					<div class="movieprofil-mini-info">
						<h4>${list.mTitle}</h4>
						<p>
							<spring:message code="field.genre" />
							:
							<c:forEach var="genre" items="${list.mGenre}">
                                        ${genre.name}
                                    </c:forEach>
						</p>
						<p>
							<spring:message code="field.runtime" />
							: ${list.mTime}
						</p>
						<p>
							<spring:message code="field.open" />
							: ${list.mDate.toString()}
						</p>
					</div>
					<div class="listinput">
						<a href="<c:url value="/moviedetails?&movie=${list.mId}"/>"
							class="btn btn-primary"> <spring:message code="field.info" />
						</a> <a
							href="<c:url value="/moviedetails?&movie=${list.mId}#sectionC"/>"
							class="btn btn-primary"> <spring:message
								code="field.schedule" />
						</a> <a
							href="<c:url value="/moviedetails?&movie=${list.mId}#sectionB"/>"
							class="btn btn-primary"> <spring:message code="field.trailer" />
						</a> <a href="<c:url value="/reservation/movie?movie=${list.mId}"/>"
							class="btn btn-primary"> <spring:message
								code="field.getTicket" />
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:when>
</c:choose>