$(document).ready(function() {

$montant = $("#totalPrice").val();	
$montant = parseInt($montant,10);
	
$( "#nbTickets" ).change(function() {	
	$traitement = parseInt($("#nbTickets").val(),10)*$montant;		
	$("#totalPrice").val($traitement);
});
	
	
$('#form_btn').click(function() {	
	

		if($nbBillet > 6){
			alert("Selon nos informations, vous avez atteint le nombre d'achat maximale d'achat de billets");
		}else{
		
			var body = $("html, body");
			body.animate({scrollTop:0}, '500', 'swing').promise().done(function(s){
				$('#panier').html('Panier (+'+$("#nbTickets").val()+')');		
				ajaxForm();
			
		});
		}
	});	

});




function ajaxForm(){
	$nbTicket = parseInt($("#nbTickets").val());
	$nomSpectacle = $("#nomSpectacle").val();
	$unityPrice = parseInt($("#unityPrice").val(),10);
	var idSpectacle = $("#idSpectacle").val();
	
	
	
	$.get( "panier/add", { nbTickets: $nbTicket, unityPrice: $unityPrice , nomSpectacle: $nomSpectacle, idSpectacle: idSpectacle } )
	  .done(function( data ) {
		  
		  
		  
	    
	  }); 	
}


});
