$(function() {
    updateFeaturedInfo();
    
    $("#featuredShows").on("click", ".carousel-control[data-slide]", function(ev) {
        setTimeout(function() { updateFeaturedInfo() }, 1000);
    });

    function updateFeaturedInfo() {
        $("#featuredInfo h1").html($("#featuredShows .carousel-inner .active h1").html());
        $("#featuredInfo .description").html($("#featuredShows .carousel-inner .active .description").html());
    }
});