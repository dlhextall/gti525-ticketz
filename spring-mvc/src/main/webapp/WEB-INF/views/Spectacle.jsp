<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<head>
<%@ include file="templates/baseHeaderComponents.jsp" %>
<title>Spectacles</title>


</head>
<body>

<%@ include file="templates/elements/header.jsp" %>


<div class="container">
	<c:forEach items="${ spectacles }" var="spectacle" varStatus="loop">
	<fmt:parseDate value="${spectacle.dateStart.toDate()}" var="parsedEmpDate" pattern="EEE, dd MMM yyyy HH:mm:ss Z" />
            <div class="thumbnail row">
                <div class="row show-grid">
                    <div class="col-md-6">
                    
                        <h3>                 
                        	<c:out value="${ spectacle.name }" />                            	
                        </h3>
                    </div>
                    <div class="col-md-6">
                        <h3 class="text-right">
                       		<small>Du <strong><joda:format value="${spectacle.dateStart}" style="M-" locale="fr_CA" /></strong> au <strong><joda:format value="${spectacle.dateEnd}" style="M-" locale="fr_CA" /></strong></small>
                        </h3>
                    </div>
                </div>

                <hr/>
                <div class="row show-grid">
                    <div class="col-md-4">
                        <img class="img-rounded" src="<c:out value="${ spectacle.imageUrl }" />" width="200px" height="133px" alt="<c:out value="${ spectacle.name }" />">
                    </div>

                    <div class="col-md-6">
                        <c:out value="${ spectacle.description }" />
                    </div>

                    <div class="col-md-2">
                        <a class="btn btn-default" href="/ticketz/detail?id=<c:out value="${ spectacle.id }" />" role="button">Détail</a>
                    </div>
                </div>
            </div>
            
            </c:forEach>
	</div>
</body>
</html>