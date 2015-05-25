<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel" data-interval="3000" >
		<ol class="carousel-indicators">
			<c:forEach var="i" begin="1" end="${movies.size()}"
				varStatus="status">
				<li data-target="#carousel-example-generic" data-slide-to="${i - 1}"
					${status.first ? 'class="active"' : ''}></li>
			</c:forEach>
		</ol>
		<div class="carousel-inner" role="listbox">
			<c:forEach var="item" items="${movies}" varStatus="status">
				<div ${status.first ? 'class="item active"' : 'class="item"' }>
					<img class="fill" src="<c:url value="/resources/poster/car_${item.getmPoster()}"/>"
						alt="${item.getmId()}" data-holder-rendered="true" width="auto"
						height="auto">
				</div>
			</c:forEach>
		</div>

		<a class="left carousel-control" href="#carousel-example-generic"
			data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> 
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>

		</a>
	</div>
	<br /><br />
	<div class="row">
		<c:forEach var="item" items="${movies}" begin="1" end="3">
        <div class="col-lg-4" align="center">
          <img class="img-circle" src="<c:url value="/resources/poster/${item.getmPoster()}"/>" alt="${item.getmId()}" width="140" height="140">
          <h2>${item.getmTitle()}</h2>
          <p>${item.getmSynopsis()}</p>
          <p><a class="btn btn-primary" href="<c:url value="/movie/movie?slot=${item.getmId()}"/>" role="button">View details &raquo;</a></p>
        </div>
		</c:forEach>
      </div>
</body>
</html>