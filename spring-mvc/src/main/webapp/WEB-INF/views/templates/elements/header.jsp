<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<!-- Header image -->
<a href="/ticketz/" >
<div class="header-image"></div>
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
                    <li><a href="/ticketz/panier">Panier</a></li>
                </ul>
                <form action="/ticketz/recherche" method="get" class="nav navbar-form navbar-right">
                    <div class="form-group">
                        <input type="text" name="criteria" class="form-control" placeholder="Search">
                    </div>
                    <button class="btn btn-default">Rechercher</button>
                </form>
            </div>
        </div>
    </div>
</div>