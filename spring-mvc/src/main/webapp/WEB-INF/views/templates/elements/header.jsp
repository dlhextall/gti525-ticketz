<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>

<!-- Header image -->
<a href="/ticketz/" >
<div class="header-image container"></div>
</a>
<!-- Navbar -->
<div class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-b"></span>
                    <span class="icon-b"></span>
                    <span class="icon-b"></span>
                </button>
                <a href="/ticketz/" class="navbar-brand">Ticketz</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/ticketz/spectacle">Spectacles</a></li>
                    <li id='popOver' data-html="true" data-content="<c:choose><c:when test="${ sessionScope.billets.size() == 0 }">Votre panier est vide</c:when><c:otherwise> <c:forEach items="${ sessionScope.billets }" var="billets" varStatus="loop">${billets.nbBillets} : ${ billets.nomSpectacle} </br> </c:forEach></c:otherwise></c:choose>" rel="popover" data-placement="top" data-original-title="Contenu de votre Panier"><a href="/ticketz/panier">Panier <span  id="panier" class="badge">${ sessionScope.billets.size() }</span></a></li>
                </ul>
                <form action="/ticketz/recherche" method="get" class="nav navbar-form navbar-right">
                    <div id="the-basics" class="form-group">
                        <input type="text" id="searching" name="criteria"  class="form-control typeahead" placeholder="Search" data-provide="typeahead" autocomplete="off">
                    </div>
                    <button class="btn btn-default">Rechercher</button>
                </form>
            </div>
        </div>
    </div>
</div>