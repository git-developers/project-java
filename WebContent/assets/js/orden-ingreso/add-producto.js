//$(document).ready(function() {
$(function () {

	var existe_producto = false;
	
    $('#product_code').on('keyup', function () {

    	var id = $(this).val();

        $.ajax({
            url: contextPath + '/producto.json',
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
						  $('#item_id').html(value.id);
						  $('#item_stock').html(value.stock);
						  $('#item_color').html(value.color);
						  $('#item_producto').html(value.descripcion);
						  $('#item_tipo_tela').html(value.tipoTela);
						  $('#item_talla').html(value.talla);
						  $('#item_descripcion').html(value.descripcion);
						  $('#item_producto').html(value.categoria.nombre);
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
        	stock: $('#producto_quantity').val(),
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

        
        
        