$(document).ready(function() {


$('#form_btn').click(function() {
	
	ajaxForm();
	
	var body = $("html, body");
	body.animate({scrollTop:0}, '500', 'swing', function() { 
		$('#panier').html('Panier (+1)');
	});
});







});