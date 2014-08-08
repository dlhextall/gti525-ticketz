<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="templates/baseHeaderComponents.jsp" %>
		
		<title>Spectacles</title>
		
		<!-- Custom styles -->
		<link href="<c:url value="/resources/css/spectacle.css" />" rel="stylesheet">
	</head>
	<body>
		<%@ include file="templates/elements/header.jsp" %>
		
		<div class="container">
			<c:forEach items="${ spectacles }" var="spectacle" varStatus="loop">
				<div class="panel panel-default">
					<div class="panel-heading"><a href="/ticketz/detail/<c:out value="${ spectacle.id }" />"><c:out value="${ spectacle.name }" /></a></div>
					<div class="panel-body">
						<div class="col-md-8">
							<p><small>Du <strong><joda:format value="${ spectacle.dateStart }" pattern="dd MMM" style="F-" dateTimeZone="America/Montreal"/></strong> au <strong><joda:format value="${ spectacle.dateEnd }" pattern="dd MMM yyyy" style="F-" dateTimeZone="America/Montreal"/></strong></small></p>
							<p><c:out value="${ spectacle.description }" /></p>
						</div>
						<div class="cold-md-2">
							<a href="/ticketz/detail/<c:out value="${ spectacle.id }" />">
								<img class="img-rounded" src="<c:out value="${ spectacle.imageThumbUrl }" />" width="200px" height="133px" alt="<c:out value="${ spectacle.name }" />">
							</a>
						</div>
					</div>
				</div>
	    	</c:forEach>
		</div>
		
		<%@ include file="templates/elements/footer.jsp" %>
		<%@ include file="templates/baseFooterComponents.jsp" %>
	</body>
</html>