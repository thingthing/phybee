<%@page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<ul class="nav pull-right navbar-nav">
	<sec:authorize access="isAnonymous()">
		<li class="dropdown" id="menuLogin"><a class="dropdown-toggle"
			href="#" data-toggle="dropdown" id="navLogin"><spring:message
					code="field.login" /></a>
			<div class="dropdown-menu" style="padding: 17px;">
				<tiles:insertAttribute name="loginForm" />
			</div></li>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_USER')">
		<li><a href="<c:url value="/profil"/>"> <c:if
					test="${pageContext.request.userPrincipal.name != null}">
			${user.firstName} ${user.lastName}
	</c:if>
		</a></li>
	</sec:authorize>
	<li><a href="?lang=en"><img
			src="<c:url value="/resources/flag/England.png"/>" alt="EN"
			width="20" height="20"></a></li>
	<li><a href="?lang=fr"><img
			src="<c:url value="/resources/flag/France.png"/>" alt="FR" width="20"
			height="20"></a></li>
</ul>

