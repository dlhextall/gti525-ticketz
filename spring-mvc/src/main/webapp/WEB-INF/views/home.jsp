<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file="templates/baseHeaderComponents.jsp" %>
        
        <title>Ticketz</title>

        <!-- Custom styles -->
        <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">
    </head>
    <body>
        <%@ include file="templates/elements/header.jsp" %>

        <!-- Carousel -->
        <div id="featuredShows" class="carousel slide" data-interval="false">
            <ol class="carousel-indicators">
                <li data-target="#featuredShows" data-slide-to="0" class="active"></li>
                <li data-target="#featuredShows" data-slide-to="1"></li>
                <li data-target="#featuredShows" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img src="<c:url value="/resources/images/carousel/img1.jpg" />" alt="First image">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Premier spectacle ${Titre}</h1>
                            <div class="description">
                                <p>Description du premier spectacle.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="<c:url value="/resources/images/carousel/img2.jpg" />" alt="Second image">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Second spectacle</h1>
                            <div class="description">
                                <p>Description du second spectacle.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="<c:url value="/resources/images/carousel/img3.jpg" />" alt="Third image">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Troisième spectacle</h1>
                            <div class="description">
                                <p>Description du troisième spectacle.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#featuredShows" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
            <a class="right carousel-control" href="#featuredShows" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
        </div>

        <!-- Show info -->
        <div id="featuredInfo" class="container">
            <div class="row">
                <div class="col-md-8">
                    <h1></h1>
                </div>
                <div class="col-md-4">
                    <h3 class="text-right">
                        <small>Du <strong> 24 Avril</strong> au <strong>24 Juin</strong></small>
                    </h3>
                </div>
            </div>
            <div class="description"></div>
            <p class="text-right"><a href="detail.html" class="btn btn-default">Détails</a></p>
        </div>

        <%@ include file="templates/elements/footer.jsp" %>

        <%@ include file="templates/baseFooterComponents.jsp" %>
        <!-- Custom javascript -->
        <script src="<c:url value="/resources/js/carousel.js" />"></script>
    </body>
</html>