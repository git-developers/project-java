//$(document).ready(function() {
$(function () {

	var existe_producto = false;
	
	$('form[name=form_cierre_caja]').submit(function(event){
		event.preventDefault();

		var formData = JSON.stringify($(this).serializeArray());
		
		console.dir(formData);
		
		
        $.ajax({
            url: contextPath + '/cierre-caja',
            type: 'POST',
            dataType: 'json',
            data: {
            	formData: formData
            },
			beforeSend: function() {
				//$(".item-prod").html("-");
			},
			success: function(data) {
				console.dir(data);
				displayMessage(data);
			},
			error: function() {
			    
			}
      	});

    });
    
	
	function displayMessage(data){
		//$('#loading').hide();
		$('#submit-message .number').html('Creado con exito, con c&oacute;digo:: #000' + data);
		$('#submit-message').fadeIn('slow');
		
	    setTimeout(function() {data
	        $('#submit-message').fadeOut('slow');
	    }, 5000);
	}
	
	
	

});

        
        
        