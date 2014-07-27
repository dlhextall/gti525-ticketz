<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="utf-8"%>
<!DOCTYPE html >    
<html lang="en">
	<head>
		<%@ include file="templates/baseHeaderComponents.jsp" %>
		<title>Panier</title>
	</head>
	<body>
	  <%@ include file="templates/elements/header.jsp" %>	
	  
	  <div class="container">
      <div class="row">
      	<form action="/ticketz/checkout/" class="form-horizontal" role="form">
      		<c:choose>
	          	<c:when test="${ sessionScope.billets.size() >=1 }" >
	          		<table class="table table-hover">
			          <thead>
			            <tr>
			              <th>Product</th>
			              <th>Quantity</th>
			              <th class="text-center">Price</th>
			              <th class="text-center">Total</th>
			              <th> </th>
			            </tr>
			          </thead>
			          <tbody>
		          		<c:forEach items="${ sessionScope.billets }" var="billets" varStatus="loop">
			            <tr>
			              <td class="col-sm-8 col-md-6">
			                <div class="media">
			                  <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/visualpharm/icons8-metro-style/128/Data-Ticket-icon.png" style="width: 72px; height: 72px;"> </a>
			                  <div class="media-body">
			                   <h4 class="media-heading"><a href="/ticketz/detail?id=<c:out value="${ billets.getIdSpectacle() }" />">${billets.getNomSpectacle()}</a></h4>
			                   <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
			                  </div>
			                </div>
			              </td>
			              <td class="col-sm-1 col-md-1" style="text-align: center">
			                <label  class="form-control" id="exampleInputEmail1" value="${billets.getNbBillets()}">${billets.getNbBillets()}</label>
			              </td>
			              <td class="col-sm-1 col-md-1 text-center"><strong> <c:out value="${billets.getMontantUnitaire()}"></c:out></strong></td>
			              <td class="col-sm-1 col-md-1 text-center"><strong><c:out value="${billets.getMontantTotal()}"></c:out></strong></td>
			              <td class="col-sm-1 col-md-1">
			              <a href="/ticketz/panier/delete?id=${loop.index}&idR=${billets.getIdRepresentation()}&idS=${billets.getIdSpectacle()}" type="button" class="btn btn-danger">
			                <span class="glyphicon glyphicon-remove"></span> Remove
			              </a></td>
			            </tr>
			           </c:forEach>
				            <tr>
				             <td>   </td>
				             <td>   </td>
				             <td>   </td>
				             <td><h5>Subtotal</h5></td>
				             <td class="text-right"><h5><strong>${ sessionScope.panier.sousTotal }</strong></h5></td>
				            </tr>
				            
				            <tr>
				             <td>   </td>
				             <td>   </td>
				             <td>   </td>
				             <td><h3>Total</h3></td>
				             <td class="text-right"><h3><strong>${ sessionScope.panier.prixTotal }</strong></h3></td>
				            </tr>
				            <tr>
				             <td>   </td>
				             <td>   </td>
				             <td>   </td>
				             <td>
				              <a href="/ticketz/spectacle"><button  type="button" class="btn btn-default"><span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping</button></a>
				             </td>
				             <td>
				              <button type="submit" class="btn btn-success">Checkout <span class="glyphicon glyphicon-play"></span></button>
				            </td>
			            </tr>
			               
			          </tbody>
			       	 </table>
			       	 <p align=center> Nombre limite de billets : 6</p>
	          	</c:when>
	          	
	          	<c:otherwise >
	          		<h2>Votre Panier est vide</h2>
	          	</c:otherwise>
	        </c:choose>
      	 </form>
	        
      </div>
	  </div>	       
	
		<%@ include file="templates/elements/footer.jsp" %>
		<%@ include file="templates/baseFooterComponents.jsp" %>
		<script src="<c:url value="/resources/js/panier.js" />"></script>
	        
	</body>
</html>
