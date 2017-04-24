//$(document).ready(function() {
$(function () {

	var existe_producto = false;
	
    $('#form_dni').on('keyup', function () {

    	var id = $(this).val();
    	
        $.ajax({
            url: contextPath + '/cliente.json',
            type: 'GET',
            data: {
            	id: id
            },
            dataType: 'json',
			beforeSend: function() {
				$(".item-prod").html("-");
			},
			success: function(data) {
				
				if(id != ""){
					$.each( data, function( key, value ) {
						$('#item_cliente_id').val(value.id);
						$('#item_nombre').html(value.nombre);
						$('#item_direccion').html(value.direccion);
					});
					
					existe_producto = true;
				}

				
			},
			error: function() {
			    
			}
      	});

    });
    
    
    

    $('#producto_add').on('click', function () {

    	var quantity = $('#producto_quantity').val();

    	if(!existe_producto){
    		alert("Agrega un producto");
    		return false;
    	}else if(quantity == ""){
    		alert("Agrega la cantidad");
    		return false;
    	}
    	
    	
        var data = {
        	id: $('#item_id').text(),
        	descripcion: $('#item_descripcion').text(),
        	stock: $('#item_stock').text()
        };

        var rowNode = tableJsonProductos
            .row.add(data)
            .draw(false)
            .node();
         
        $( rowNode )
            .css( 'color', 'green' )
            .animate( { color: 'black' } );

        tableJsonProductos.order([0, 'desc']).draw(false);

    });
    
    function getFormData(){
        var unindexed_array = $('form[name=form_edit]').serializeArray();
        var indexed_array = {};

        $.map(unindexed_array, function(n, i){
            indexed_array[n['name']] = n['value'];
        });

        return indexed_array;
    }
    
    
    
    
    
    
    /*** ADD ***/
    /*
    $('form[name=form_add]').submit(function(event){
        event.preventDefault();

        var data = getFormData($(this));

        var rowNode = tableJson
            .row.add(data)
            .draw(false)
            .node();
         
        $( rowNode )
            .css( 'color', 'green' )
            .animate( { color: 'black' } );

        tableJson.order([0, 'desc']).draw(false);

        $('#modal-add').modal('hide');

    });
    */
    /*** ADD ***/
    
    
    
    

});

        
        
        