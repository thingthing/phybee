<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<ul class="nav pull-right navbar-nav">
	<sec:authorize access="isAnonymous()">
		<li class="dropdown" id="menuLogin"><a class="dropdown-toggle"
			href="#" data-toggle="dropdown" id="navLogin">Login</a>
			<div class="dropdown-menu" style="padding: 17px;">
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>

				<form name="loginForm" action="<c:url value='/auth/login_check' />"
					method="POST" class="form">
					<h4>
						<span class="label label-primary"><spring:message code="field.email" /> :</span>
					</h4>
					<input type='text' name="email" />
					<h4>
						<span class="label label-primary"><spring:message code="field.password" /> :</span>
					</h4>
					<spring:message code="field.password" />
					<input type='password' name="password" />
					<br />
					<input type="submit" value="<spring:message code="field.login" />" class="btn" />
				</form>
				<br />
				<a href="<c:url value="/register"/>"> <spring:message code="field.register" /></a>
			</div></li>
	</sec:authorize>

	<li><sec:authorize access="hasRole('ROLE_USER')">
			<a href="<c:url value="/profil"/>"> <c:if
					test="${pageContext.request.userPrincipal.name != null}">
			${user.firstName} ${user.lastName}
	</c:if>
			</a>


		</sec:authorize></li>

	<li><a href="?lang=en"><img
			src="<c:url value="/resources/flag/England.png"/>" alt="EN" width="20" height="20"></a></li>
	<li><a href="?lang=fr"><img
			src="<c:url value="/resources/flag/France.png"/>" alt="FR" width="20" height="20"></a></li>
</ul>

