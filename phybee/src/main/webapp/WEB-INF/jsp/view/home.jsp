<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<script src="<c:url value="/resources/js/Carousel.js"/>"></script>
<body>
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<c:forEach var="i" begin="1" end="${movies.size()}"
				varStatus="status">
				<li data-target="#carousel-example-generic" data-slide-to="i"
					${status.first ? 'class="active"' : ''}></li>
			</c:forEach>
		</ol>
		<div class="carousel-inner" role="listbox">
			<c:forEach var="item" items="${movies}" varStatus="status">
				<div ${status.first ? 'class="item-active"' : 'class="item"' }>
					<img src="<c:url value="/resources/poster/${item.getmPoster()}"/>"
						alt="${item.getmId()}" data-holder-rendered="true" width="50%"
						height="auto">
				</div>
			</c:forEach>
		</div>

		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
	<c:if test="${not empty username}">
		<h1>User : ${username}</h1>
	</c:if>

	<sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name}
			</h2>
		</c:if>

	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		You're not connected
	</sec:authorize>
</body>
</html>