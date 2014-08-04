<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <%@ include file="templates/baseHeaderComponents.jsp" %>        
	    <title>Confirmation de votre achat</title>        
	</head>
	<body>
	    <%@ include file="templates/elements/header.jsp" %>
	
       <div class="container">
	    	<h2>Votre achat a été effectué avec succès, Merci de faire affaire avec Ticketz .</h2>
	    	<p class="lead">
	    		Pour voir votre facture, cliquez <a href="${ contextPath }">ICI</a>
	    	</p>
	    </div>
      
	    
	    
	    <%@ include file="templates/elements/footer.jsp" %>

        <%@ include file="templates/baseFooterComponents.jsp" %>
        <!-- Custom javascript -->
        <script src="<c:url value="/resources/js/checkout.js" />"></script>
	</body>
</html>