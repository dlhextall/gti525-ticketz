$(document).ready(function() {


$('#form_btn').click(function() {
	
	ajaxForm();
	
	var body = $("html, body");
	body.animate({scrollTop:0}, '500', 'swing', function() { 
		$('#panier').html('Panier (+1)');
		ajaxForm();
	});
});



function ajaxForm(){
	$.post("/add",
			  {
			    name:"Donald Duck",
			    city:"Duckburg"
			  },
			  function(data,status){
			    alert("Data: " + data + "\nStatus: " + status);
			  });
}



});