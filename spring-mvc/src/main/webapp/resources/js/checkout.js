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
		$('ul.setup-panel li:eq(1)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-2"]').trigger('click');
    });
    
    $("#frmCheckout input, #frmCheckout select").focusout(function(input) {
    	if ($(this)[0].checkValidity()) {
    		$(this).parent().removeClass("has-error");
    		$(this).parent().addClass("has-success");
    	} else {
    		$(this).parent().removeClass("has-success");
    		$(this).parent().addClass("has-error");
    	}
    });
    
    
    $("#frmCheckout").submit(function() {
    	return confirm("Voulez-vous procéder à l'achat?");
    });
});