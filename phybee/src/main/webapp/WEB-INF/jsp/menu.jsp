<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/home"/>">Phybee</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/home"/>">Home</a></li>
				<li><a href="<c:url value="/schedule"/>">Schedule</a></li>
				<li><a href="<c:url value="/movie"/>">Movie</a></li>
				<li><a href="<c:url value="/incoming"/>">Incoming</a></li>
				<li><a href="<c:url value="/reservation/movie"/>">Reservation</a></li>
				<li><a href="<c:url value="/infos"/>">Infos</a></li>
				<sec:authorize access="isAnonymous()">
					<li><a href="<c:url value="/register"/>">Subscrition</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_USER')">
					<!-- For login user -->
					<c:url value="/j_spring_security_logout" var="logoutUrl" />
					<form action="${logoutUrl}" method="post" id="logoutForm" style="display:none"></form>
					<script>
						function formSubmit() {
							document.getElementById("logoutForm").submit();
						}
					</script>

					<li><a href="javascript:formSubmit()"> Logout</a></li>

				</sec:authorize>
			</ul>
		</div>
	</div>
</nav>