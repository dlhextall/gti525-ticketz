<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <%@ include file="templates/baseHeaderComponents.jsp" %>        
	    <title>Confirmation de votre achat</title>        
		<!-- Custom styles -->
		<link href="<c:url value="/resources/css/spectacle.css" />" rel="stylesheet">
	</head>
	<body>
	    <%@ include file="templates/elements/header.jsp" %>
	
       <div class="container">
	    	<h2>Votre achat a été effectué avec succès, Merci de faire affaire avec Ticketz .</h2>
	    	<p class="lead">
	    		Voici un exemplaire de votre facture
	    	</p>
	    </div>
      
	    
	    <div class="container">
    <div class="row">
        <div class="col-xs-12">
    		<div class="invoice-title">
    			<h2>Facture</h2>
    		</div>
    		<hr>
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    				<strong>Facturé à:</strong><br>
    					${ prenom } ${ nom }<br>
    					${ adresse }<br>
    					${ ville }, ${ province } ${ codePostal }
    				</address>
    			</div>
    			
    		</div>
    		
    	</div>
    </div>
    
    <div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Détails de la commande</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
                                <tr>
        							<td><strong>Article</strong></td>
        							<td class="text-center"><strong>Prix</strong></td>
        							<td class="text-center"><strong>Quantité</strong></td>
        							<td class="text-right"><strong>Total</strong></td>
                                </tr>
    						</thead>
    						<tbody>
    							<c:forEach items="${ panier.getLstBilletPanier() }" var="items" varStatus="loop">
    							<tr>
    								<td>${items.getNomSpectacle() }</td>
    								<td class="text-center">$ ${items.getMontantUnitaire()}</td>
    								<td class="text-center">${items.getNbBillets()}</td>
    								<td class="text-right">$ ${items.getMontantTotal()}</td>
    							</tr>
    							</c:forEach>      
    							<tr>
    								<td class="thick-line"></td>
    								<td class="thick-line"></td>
    								<td class="thick-line text-center"><strong>Sous-Total</strong></td>
    								<td class="thick-line text-right">$ ${panier.getSousTotal() }</td>
    							</tr>
    							<tr>
    								<td class="no-line"></td>
    								<td class="no-line"></td>
    								<td class="no-line text-center"><strong>Total</strong></td>
    								<td class="no-line text-right">$ ${panier.getPrixTotal() }</td>
    							</tr>                       
    						</tbody>
    					</table>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
</div>
	    
	    
	    
	    
	    <%@ include file="templates/elements/footer.jsp" %>

        <%@ include file="templates/baseFooterComponents.jsp" %>
        <!-- Custom javascript -->
        <script src="<c:url value="/resources/js/checkout.js" />"></script>
	</body>
</html>