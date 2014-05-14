$(function() {
    updateFeaturedInfo();
    
    $("#featuredShows").on("click", ".carousel-control[data-slide]", function(ev) {
        setTimeout(function() { updateFeaturedInfo() }, 1000);
    });
    $("#featuredShows").on("click", ".carousel-indicators li[data-slide-to]", function(ev) {
        setTimeout(function() { updateFeaturedInfo() }, 1000);
    });

    function updateFeaturedInfo() {
        $("#featuredInfo h1").text($("#featuredShows .carousel-inner .active h1").text());
        $("#featuredInfo .description").html($("#featuredShows .carousel-inner .active div.description").html());
    }
});