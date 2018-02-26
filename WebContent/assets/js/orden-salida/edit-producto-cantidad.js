$(function () {

	$(document).on("click",".btn-modal-edit-producto-cantidad",function() {

        var tr = $(this).parents('tr');
        var data = tableJsonProductos.row(tr).data();

        setFormdata(data);
	    setTrColor(tr);
	    
	    //$('#modal-edit-producto-cantidad input').val(cantidad);
	    $('#modal-edit-producto-cantidad').modal('show');
	    

	});
   
});

        
        
        