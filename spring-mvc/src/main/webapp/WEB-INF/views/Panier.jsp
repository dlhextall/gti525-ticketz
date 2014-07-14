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
	          	<c:if test="${billets.size() >=1}" >
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
		          		<c:forEach items="${ billets }" var="billets" varStatus="loop">
			            <tr>
			              <td class="col-sm-8 col-md-6">
			                <div class="media">
			                  <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
			                  <div class="media-body">
			                   <h4 class="media-heading"><a href="#">${billets.getNomSpectacle()}</a></h4>
			                   <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
			                  </div>
			                </div>
			              </td>
			              <td class="col-sm-1 col-md-1" style="text-align: center">
			                <input type="number" class="form-control" id="exampleInputEmail1" value="3" readonly>
			              </td>
			              <td class="col-sm-1 col-md-1 text-center"><strong> <c:out value="${billets.getMontantTotal()}"></c:out></strong></td>
			              <td class="col-sm-1 col-md-1 text-center"><strong>$14.61</strong></td>
			              <td class="col-sm-1 col-md-1">
			              <button type="button" class="btn btn-danger">
			                <span class="glyphicon glyphicon-remove"></span> Remove
			              </button></td>
			            </tr>
			           </c:forEach>
				            <tr>
				             <td>   </td>
				             <td>   </td>
				             <td>   </td>
				             <td><h5>Subtotal</h5></td>
				             <td class="text-right"><h5><strong>$24.59</strong></h5></td>
				            </tr>
				            <tr>
				             <td>   </td>
				             <td>   </td>
				             <td>   </td>
				             <td><h5>Estimated shipping</h5></td>
				             <td class="text-right"><h5><strong>$6.94</strong></h5></td>
				            </tr>
				            <tr>
				             <td>   </td>
				             <td>   </td>
				             <td>   </td>
				             <td><h3>Total</h3></td>
				             <td class="text-right"><h3><strong>$31.53</strong></h3></td>
				            </tr>
				            <tr>
				             <td>   </td>
				             <td>   </td>
				             <td>   </td>
				             <td>
				              <button  type="button" class="btn btn-default"><span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping</button>
				             </td>
				             <td>
				              <button type="submit" class="btn btn-success">Checkout <span class="glyphicon glyphicon-play"></span></button>
				             <a href="/ticketz/show/add" id="panier">add</a>
				            </td>
			            </tr>
			               
			          </tbody>
			       	 </table>
	          		</c:if>
	          	
		          	<c:if test="${billets.size() <1}" >
		          		<h2>Votre Panier est vide</h2>
		          	</c:if>
	        
      	 </form>
	        
      </div>
	  </div>
	       
	
		<%@ include file="templates/elements/footer.jsp" %>
		<%@ include file="templates/baseFooterComponents.jsp" %>
	        
	</body>
</html>
