<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file="templates/baseHeaderComponents.jsp" %>
        
        <title>Ticketz</title>

        <!-- Custom styles -->
        <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">
    </head>
    <body>
        <%@ include file="templates/elements/header.jsp" %>

        <!-- Carousel -->
        <c:if test="${ spectacles.size() > 0 }">
	        <div id="featuredShows" class="carousel slide" data-interval="false">
	            <ol class="carousel-indicators">
	              <c:forEach begin="0" end="${ spectacles.size() - 1 }" varStatus="loop">
	                <li data-target="#featuredShows" data-slide-to="${ loop.index }" class="${ loop.index == 0 ? "active" : ""}"></li>
	              </c:forEach>
	            </ol>
	            <div class="carousel-inner">
	              <c:forEach items="${ spectacles }" var="spectacle" varStatus="loop">
	                <div class="${ loop.index == 0 ? "item active" : "item" }">
	                    <img src="<c:url value="${ spectacle.imageFeaturedUrl }" />" alt="<c:out value="${ spectacle.name }" />">
	                    <div class="container">
	                        <div class="carousel-caption">
	                            <h1><c:out value="${ spectacle.name }" /></h1>
	                            <div class="description">
	                                <p><c:out value="${ spectacle.description }" /></p>
	                            </div>
	                            <div class="dates">
	                              <span class="start"><joda:format value="${ spectacle.dateStart }" pattern="dd MMM" style="F-" dateTimeZone="America/Montreal"/></span>
	                              <span class="end"><joda:format value="${ spectacle.dateEnd }" pattern="dd MMM yyyy" style="F-" dateTimeZone="America/Montreal"/></span>
	                            </div>
	                            <span class="show-id">${ spectacle.id }</span>
	                        </div>
	                    </div>
	                </div>
	              </c:forEach>
	            </div>
	            <a class="left carousel-control" href="#featuredShows" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
	            <a class="right carousel-control" href="#featuredShows" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
	        </div>
	
	        <!-- Show info -->
	        <div id="featuredInfo" class="container">
	            <div class="row">
	                <div class="col-md-8">
	                    <h1></h1>
	                </div>
	                <div class="col-md-4">
	                    <h3 class="text-right">
	                        <small>Du <strong id="date-start"> 24 Avril</strong> au <strong id="date-end">24 Juin</strong></small>
	                    </h3>
	                </div>
	            </div>
	            <div class="description"></div>
	            <p class="text-right"><a href="detail/" class="btn btn-default show-id">Détails</a></p>
	        </div>
        </c:if>

        <%@ include file="templates/elements/footer.jsp" %>

        <%@ include file="templates/baseFooterComponents.jsp" %>
        <!-- Custom javascript -->
        <script src="<c:url value="/resources/js/carousel.js" />"></script>
    </body>
</html>