$(function () {

	$(document).on("click",".btn-modal-edit-producto-cantidad",function() {
	    
        var tr = $(this).parents('tr');
        var data = tableJsonProductosSeleccionado.row(tr).data();

        console.log("DATA:: " + data);
        
        setFormdata(data);
	    setTrColor(tr);
	    
	    //$('#modal-edit-producto-cantidad input').val(cantidad);
	    $('#modal-edit-producto-cantidad').modal('show');

	});
   
});

        
        
        