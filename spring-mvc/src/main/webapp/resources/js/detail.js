$(document).ready(function() {

$montant = $("#totalPrice").val();	
	
$( "#nbTickets" ).change(function() {
	
	$traitement = parseInt($("#nbTickets").val(), 10)*$montant;
		
		$("#totalPrice").val($traitement);
	});
	
	
$('#form_btn').click(function() {
	
	
	
	var body = $("html, body");
	body.animate({scrollTop:0}, '500', 'swing', function() { 
		$('#panier').html('Panier (+1)');		
		ajaxForm();
	});
});


function ajaxForm(){
	$nbTicket = parseInt($("#nbTickets").val());
	$nomSpectacle = $("#nomSpectacle").val();
	$unityPrice = $("#unityPrice").val();
	var idSpectacle = $("#idSpectacle").val();
	
	$.get( "panier/add", { nbTickets: $nbTicket, unityPrice: $unityPrice , nomSpectacle: $nomSpectacle, idSpectacle: idSpectacle } )
	  .done(function( data ) {
	    
	  });
	  
	
}




});
