<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<%@ include file="templates/baseHeaderComponents.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail</title>

</head>
<body>

 		<%@ include file="templates/elements/header.jsp" %>

        
        <!-- Show preview -->
        <div class="row show-preview">
            <div class="container">
                <div class="col-md-6">
                    <h2><c:out value="${ spectacle.name }" /></h2>
                    <h4>Du <joda:format value="${ spectacle.dateStart }" pattern="dd MMM" style="F-" dateTimeZone="America/Montreal"/> au <joda:format value="${ spectacle.dateEnd }" pattern="dd MMM yyyy" style="F-" dateTimeZone="America/Montreal"/></h4>
                    <h3><c:out value="${ spectacle.salle }" /></h3>
                    <h4>Montréal, Qc</h4>
                </div>
                <div class="col-md-6">
                    <img src="<c:out value="${ spectacle.imageUrl }" />" width="291px" height="350px">
                </div>
            </div>
        </div>

        <!-- Show details -->
        <div class="row show-details">
            <div class="container">
                <h2>Détails</h2>
                <div class="col-md-12">
                    <p><c:out value="${ spectacle.description }" /></p>
                </div>
            </div>
        </div>

        <!-- Ticket option -->
        <div class="row show-buying">
            <div class="container form-horizontal">
                <h2>Achat</h2>
                	<!-- <form action="/ticketz/panier/add" class="form-horizontal" role="form"> -->
	                    <div class="form-group">
	                        <label for="nbTickets" class="col-sm-4 control-label">Nombre de billets</label>
	                        <div class="col-sm-6">
	                            <select name="nbTickets" id="nbTickets" class="form-control">
	                                <option value="1">1</option>
	                                <option value="2">2</option>
	                                <option value="3">3</option>
	                                <option value="4">4</option>
	                            </select>
	                        </div>
	                    </div>
	                    <!-- <div class="form-group">
	                        <label for="showDate" class="col-sm-4 control-label">Date du spectacle</label>
	                        <div class="col-sm-6">
	                            <select name="showDate" id="showDate" class="form-control">
	                                <option value="1">January 1st</option>
	                                <option value="2">January 2nd</option>
	                            </select>
	                        </div>
	                    </div> -->
	                   
	                    <div class="form-group">
	                        <label for="totalPrice" class="col-sm-4 control-label">Total</label>
	                        <div class="col-sm-6">
	                            <input name="totalPrice" id='totalPrice' type="text" class="form-control" value="${ spectacle.getRepresentationAt(0).prix}" readonly>
	                            <input type="hidden" id='idSpectacle' name="idSpectacle" value="${ spectacle.id }">
	                            <input type="hidden" id='unityPrice' name="unityPrice" value="${ spectacle.getRepresentationAt(0).prix}">
	                            <input type="hidden" id='nomSpectacle' name="nomSpectacle" value="${ spectacle.name }">
	                        </div>
	                    </div>
	                    <div class="clearfix"></div>
	                    <div class="col-md-10 text-right">
	                        <button type="submit" id='form_btn' class="btn btn-default">Ajouter au panier</button>                       
	                    </div>
                   <!-- </form> -->
                
            </div>
        </div>


		<%@ include file="templates/elements/footer.jsp" %>
        <%@ include file="templates/baseFooterComponents.jsp" %>
        <script src="<c:url value="/resources/js/detail.js" />"></script>
</body>
</html>