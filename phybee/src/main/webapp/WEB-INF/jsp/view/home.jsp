<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="carousel-example-generic" class="carousel slide"
	data-ride="carousel" data-interval="3000">
	<ol class="carousel-indicators">
		<c:forEach var="i" begin="1" end="${movies.size()}" varStatus="status">
			<li data-target="#carousel-example-generic" data-slide-to="${i - 1}"
				${status.first ? 'class="active"' : ''}></li>
		</c:forEach>
	</ol>
	<div class="carousel-inner" role="listbox">
		<c:forEach var="item" items="${movies}" varStatus="status">
			<div ${status.first ? 'class="item active"' : 'class="item"' }>
				<a href="<c:url value="/moviedetails?movie=${item.id}"/>">
					<img class="fill"
					src="<c:url value="/resources/poster/car_${item.poster}"/>"
					alt="${item.id}" data-holder-rendered="true" width="auto"
					height="auto">
				</a>
			</div>
		</c:forEach>
	</div>

	<a class="left carousel-control" href="#carousel-example-generic"
		data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
		aria-hidden="true"></span>
	</a> <a class="right carousel-control" href="#carousel-example-generic"
		data-slide="next"> <span class="glyphicon glyphicon-chevron-right"
		aria-hidden="true"></span>

	</a>
</div>
<br />
<br />
<div class="row">
	<c:forEach var="item" items="${movies}">
		<div class="col-lg-4" align="center">
			<img class="img-circle"
				src="<c:url value="/resources/poster/${item.poster}"/>"
				alt="${item.id}" width="140" height="140">
			<h2>${item.title}</h2>
			<p>${item.synopsis}</p>
			<p>
				<a class="btn btn-primary"
					href="<c:url value="/moviedetails?movie=${item.id}"/>"
					role="button">View details &raquo;</a>
			</p>
		</div>
	</c:forEach>
</div>