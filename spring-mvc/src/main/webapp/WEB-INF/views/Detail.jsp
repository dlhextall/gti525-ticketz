<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                    <h4>From January 1st to January 1st</h4>
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
            <div class="container">
                <h2>Achat</h2>
                <form action="" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="nbTickets" class="col-sm-4 control-label">Nombre de billets</label>
                        <div class="col-sm-6">
                            <select name="nbTickets" id="nbTickets" class="form-control">
                                <option value="one">1</option>
                                <option value="two">2</option>
                                <option value="three">3</option>
                                <option value="four">4</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="showDate" class="col-sm-4 control-label">Date du spectacle</label>
                        <div class="col-sm-6">
                            <select name="showDate" id="showDate" class="form-control">
                                <option value="1">January 1st</option>
                                <option value="2">January 2nd</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ticketSection" class="col-sm-4 control-label">Section</label>
                        <div class="col-sm-6">
                            <select name="ticketSection" id="ticketSection" class="form-control">
                                <option value="0">Floor</option>    
                                <option value="1">100</option>
                                <option value="2">200</option>
                                <option value="3">300</option>
                                <option value="4">400</option>
                                <option value="5">500</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="totalPrice" class="col-sm-4 control-label">Total</label>
                        <div class="col-sm-6">
                            <input name="totalPrice" id="totalPrice" type="text" class="form-control" value="0.00$" readonly>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="col-md-10 text-right">
                        <button class="btn btn-default">Ajouter au panier</button>
                        <a href="/ticketz/checkout" class="btn btn-default">Checkout</a>
                    </div>
                </form>
            </div>
        </div>


		<%@ include file="templates/elements/footer.jsp" %>
        <%@ include file="templates/baseFooterComponents.jsp" %>
</body>
</html>