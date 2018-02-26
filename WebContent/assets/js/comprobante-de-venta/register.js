//$(document).ready(function() {
$(function () {

	var existe_producto = false;
	
	$('form[name=form_comprobante_pago]').submit(function(event){
		event.preventDefault();
		
		var formData = JSON.stringify($(this).serializeArray());
	    var listItems = tableJsonProductosSeleccionado.rows().data();
	    var count = tableJsonProductosSeleccionado.rows().data().length;
	    
	    if(count == 0){
	    	alert("Info:: agregue items");
	    	return false;
	    }
		
		
        $.ajax({
            url: contextPath + '/comprobante-de-venta',
            type: 'POST',
            dataType: 'json',
            data: {
            	values: getSelectedItems(listItems),
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
	
	function getSelectedItems($listaItems){
	    var values = [];
	    $.each($listaItems, function(key, value){
	    	item = {}
	        item ["id_item"] = value['id'];
	        item ["stock"] = value['stock']; //$("#cantidad_" + value['id']).val();
	    	values.push(item);
	    });

	    return JSON.stringify(values);
	}
	
	

});

        
        
        