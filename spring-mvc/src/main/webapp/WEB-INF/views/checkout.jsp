<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate value="${date}" pattern="yyyy" var="currentYear" />

<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file="templates/baseHeaderComponents.jsp" %>        
        <title>Checkout</title>        
    </head>
    <body>
        <%@ include file="templates/elements/header.jsp" %>

        <!-- Resultat de recherche -->
        <div class="container">
            <h2>Veuillez remplir les informations ci-dessous</h2>
            <hr/> 
            <form:form role="form" id="frmCheckout" modelAttribute="checkoutForm" method="POST">
            	<form:errors path="*" />
                <div class="row form-group">
                    <div class="col-xs-12">
                        <ul class="nav nav-pills nav-justified thumbnail setup-panel">
                            <li class="active"><a href="#step-1">
                                <h4 class="list-group-item-heading">ÉTAPE 1</h4>
                                <p class="list-group-item-text">Vos informations Personnelles</p>
                            </a></li>
                            <li class="disabled"><a href="#step-2">
                                <h4 class="list-group-item-heading">ÉTAPE 2</h4>
                                <p class="list-group-item-text">Carte de crédit</p>
                            </a></li>
                        </ul>
                    </div>
                </div>
                <div class="row setup-content" id="step-1">
                    <div class="col-xs-12">
                        <div class="col-md-12 well">
                            <h1 class="text-center"> ÉTAPE 1</h1>
                            <div class="form-group">
                                <label class="control-label" for="nom">Nom</label>
                                <form:input path="lastName" type="text" class="form-control" id="lastName" placeholder="Votre nom" required="true" />
                                <form:errors path="lastName" />
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="nom">Prénom</label>
                                <form:input path="firstName" type="text" class="form-control" id="firstName" placeholder="Votre prénom" required="true" />
                                <form:errors path="firstName" />
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="adresse">Adresse</label>
                                <form:input path="address" type="text" class="form-control" id="address" placeholder="# adresse" required="true" />
                                <form:errors path="address" />
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="ville">Ville</label>
                                <form:input path="city" type="text" class="form-control" id="city" placeholder="Nom de la ville" required="true" />
                                <form:errors path="city" />
                            </div>

                            <div class="form-group">
                                <label class="control-label" for="province">Province</label>
                                <form:select path="province" class="form-control">
                                    <form:option value="AB" label="Alberta" />
                                    <form:option value="BC" label="British Columbia" />
									<form:option value="MB" label="Manitoba" />
									<form:option value="NB" label="New Brunswick" />
									<form:option value="NL" label="Newfoundland and Labrador" />
									<form:option value="NS" label="Nova Scotia" />
									<form:option value="ON" label="Ontario" />
									<form:option value="PE" label="Prince Edward Island" />
									<form:option value="QC" label="Quebec" />
									<form:option value="SK" label="Saskatchewan" />
									<form:option value="NT" label="Northwest Territories" />
									<form:option value="NU" label="Nunavut" />
									<form:option value="YT" label="Yukon" />
                                </form:select> 
                                <form:errors path="province" />
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="country">Pays</label>
                                <form:select path="country" class="form-control">
                                    <form:option value="Canada" label="Canada" />
                                </form:select> 
                                <form:errors path="province" />
                            </div>

                            <div class="form-group">
                                <label class="control-label" for="postalCode">Code-Postal</label>
                                <form:input path="postalCode" type="text" class="form-control" id="postalCode" placeholder="A1A1A1" required="true" />
                                <form:errors path="postalCode" />
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="telephone">No. Téléphone</label>
                                <form:input path="telephone" type="tel" class="form-control" id="telephone" placeholder="5141234567" required="true" />
                                <form:errors path="telephone" />
                            </div>
                            <button id="activate-step-2" class="btn btn-primary btn-lg">Étape Suivante</button>
                        </div>
                    </div>
                </div>
                <div class="row setup-content" id="step-2">
                    <div class="col-xs-12">
                        <div class="col-md-12 well">
                            <h1 class="text-center"> ÉTAPE 2</h1>
                            <div class="row">
                                <div class="form-group">
                                    <label class="control-label" for="ccLastName">Nom indiqué sur la carte</label>
                                    <form:input path="ccLastName" type="text" class="form-control" placeholder="Nom" id="ccLastName" required="true" />
                                    <form:errors path="ccLastName" />
                                </div>
                                <div class="form-group">
                                    <label class="control-label" for="ccFirstName">Prénom indiqué sur la carte</label>
                                    <form:input path="ccFirstName" type="text" class="form-control" placeholder="Prénom" id="ccFirstName" required="true" />
                                    <form:errors path="ccFirstName" />
                                </div>
                                <div class="form-group">
                                    <label class="control-label" for="ccNumber">Numéro de carte</label>
                                    <form:input path="ccNumber" type="number" class="form-control" placeholder="123456789101121" id="ccNumber" required="true" />
                                    <form:errors path="ccNumber" />
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="control-label" for="ccMonth">Mois d'expiration</label>
                                            <form:input path="ccMonth" type="number" min="1" max="12" class="form-control" placeholder="1" id="ccMonth" required="true" />
                                            <form:errors path="ccMonth" />
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="control-label" for="ccYear">Année d'expiration</label>
                                            <form:input path="ccYear" type="number" min="${ currentYear }" max="${ currentYear + 10 }" class="form-control" placeholder="${ currentYear }" id="ccYear" required="true" />
                                            <form:errors path="ccYear" />
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="control-label" for="ccCVC">CVC</label>
                                            <form:input path="ccCVC" type="number" min="0" max="999" class="form-control" placeholder="123" id="ccCVC" required="true" />
                                            <form:errors path="ccCVC" />
                                        </div>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary">Payer maintenant</button>                                                           
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>

        <%@ include file="templates/elements/footer.jsp" %>

        <%@ include file="templates/baseFooterComponents.jsp" %>
        <!-- Custom javascript -->
        <script src="<c:url value="/resources/js/checkout.js" />"></script>
        
    </body>
</html>