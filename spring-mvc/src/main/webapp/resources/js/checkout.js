$(document).ready(function() {
    
    var navListItems = $('ul.setup-panel li a'),
        allWells = $('.setup-content');

    allWells.hide();

    navListItems.click(function(e)
    {
        e.preventDefault();
        var $target = $($(this).attr('href')),
            $item = $(this).closest('li');
        
        if (!$item.hasClass('disabled')) {
            navListItems.closest('li').removeClass('active');
            $item.addClass('active');
            allWells.hide();
            $target.show();
        }
    });
    
    $('ul.setup-panel li.active a').trigger('click');
    
    $('#activate-step-2').click(function(e) {
    	if ($("#step-1 #lastName").checkValidity() && $("#step-1 #firstName").checkValidity() && $("#step-1 #address").checkValidity()
    			&& $("#step-1 #city").checkValidity() && $("#step-1 #postalCode").checkValidity() && $("#step-1 #telephone").checkValidity()) {
    		$('ul.setup-panel li:eq(1)').removeClass('disabled');
            $('ul.setup-panel li a[href="#step-2"]').trigger('click');
            $(this).remove();
    	}
    })
    
    
    $("#frmCheckout").submit(function() {
    	return confirm("Voulez-vous procéder à l'achat?");
    });
});