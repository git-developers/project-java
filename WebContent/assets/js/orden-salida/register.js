//$(document).ready(function() {
$(function () {

	var existe_producto = false;
	
	$('form[name=form_orden_salida]').submit(function(event){
		event.preventDefault();
		
		var formData = JSON.stringify($(this).serializeArray());
	    var listItems = tableJsonProductos.rows().data();
	    var count = tableJsonProductos.rows().data().length;
	    
	    if(count == 0){
	    	alert("Info:: agregue items");
	    	return false;
	    }
	    
	    console.log(getSelectedItems(listItems));
		
        $.ajax({
            url: contextPath + '/mercaderia-orden-salida',
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
				//console.dir(data);
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

        
        
        