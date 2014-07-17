<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <%@ include file="templates/baseHeaderComponents.jsp" %>        
	    <title>Not found</title>        
	</head>
	<body>
	    <%@ include file="templates/elements/header.jsp" %>
	    
	    <div class="container">
	    	<h2>You seem lost.</h2>
	    	<p class="lead">
	    		Go back to the <a href="${ contextPath }">homepage</a>?
	    	</p>
	    </div>
	    
	    <%@ include file="templates/elements/footer.jsp" %>

        <%@ include file="templates/baseFooterComponents.jsp" %>
        <!-- Custom javascript -->
        <script src="<c:url value="/resources/js/checkout.js" />"></script>
	</body>
</html>