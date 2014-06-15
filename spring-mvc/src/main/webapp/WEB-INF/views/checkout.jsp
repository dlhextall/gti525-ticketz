<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="utf-8"%>
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
            <form role="form">
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
                            <!--<li class="disabled"><a href="#step-3">
                                <h4 class="list-group-item-heading">Step 3</h4>
                                <p class="list-group-item-text">Third step description</p>
                            </a></li>-->
                        </ul>
                    </div>
                </div>
                <div class="row setup-content" id="step-1">
                    <div class="col-xs-12">
                        <div class="col-md-12 well">
                            <h1 class="text-center"> ÉTAPE 1</h1>
                            <div class="form-group">
                                <label for="nom">Nom Complet</label>
                                <input type="text" class="form-control" id="nom" placeholder="Votre nom">
                                </div>
                                <div class="form-group">
                                    <label for="adresse">Adresse</label>
                                    <input type="text" class="form-control" id="adresse" placeholder="# adresse">
                                </div>
                                <div class="form-group">
                                    <label for="ville">Ville</label>
                                    <input type="text" class="form-control" id="ville" placeholder="Nom de la ville">
                                </div>

                                <div class="form-group">
                                    <label for="Province">Province</label>
                                    <select class="form-control">
                                        <option>Alberta</option>
                                        <option>British Columbia</option>
                                        <option>Manitoba</option>
                                        <option>New Brunswick</option>
                                        <option>Newfoundland and Labrador</option>
                                        <option>Nova Scotia</option>
                                        <option>Ontario</option>
                                        <option>Prince Edward Island</option>
                                        <option>Quebec</option>
                                        <option>Saskatchewan</option>
                                        <option>Northwest Territories</option>
                                        <option>Nunavut</option>
                                        <option>Yukon</option>
                                    </select> 
                                </div>

                                <div class="form-group">
                                    <label for="codePostale">Code-Postal</label>
                                    <input type="text" class="form-control" id="codePostale" placeholder="ex: a1a-1a1">
                                </div>
                                <div class="form-group">
                                    <label for="noTel">No. Téléphone</label>
                                    <input type="text" class="form-control" id="noTel" placeholder="514-xxx-xxx">
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
                                    <label>Nom indiquer sur la carte</label>
                                    <input type="text" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Numéro de carte</label>
                                    <input type="text" class="form-control">
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label>Exp Month</label>
                                            <input type="text" class="form-control" placeholder="MM">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label>Exp Year</label>
                                            <input type="text" class="form-control" placeholder="YYYY">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label>CVC</label>
                                            <input type="text" class="form-control" placeholder="Ex. 331">
                                        </div>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary">Payer maintenant</button>                                                           
                            </div>
                        </div>
                    </div>
                </div>
                <!--<div class="row setup-content" id="step-3">
                    <div class="col-xs-12">
                        <div class="col-md-12 well">
                            <h1 class="text-center"> STEP 3</h1>
                        </div>
                    </div>
                </div>-->                                                     
            </form>
        </div>

        <%@ include file="templates/elements/footer.jsp" %>

        <%@ include file="templates/baseFooterComponents.jsp" %>
        <!-- Custom javascript -->
        <script src="<c:url value="/resources/js/checkout.js" />"></script>
        
    </body>
</html>