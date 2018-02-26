<div class="modal fade" id="modal-edit-producto-cantidad" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content modal-col-orange">
            <div class="modal-header">
                <h4 class="modal-title" id="defaultModalLabel">Cantidad</h4>
            </div>
            
            <form name="form_edit_producto_cantidad">
            	<input type="hidden" name="id">
            	<input type="hidden" name="descripcion">
            	<input type="hidden" name="precio">
            	
            	
	            <div class="modal-body">
	
					<div class="row">
						<div class="col-md-12">
		                     <%-- <b>Cantidad</b> --%>
		                     <div class="input-group">
		                         <span class="input-group-addon">
		                             <i class="material-icons">offline_pin</i>
		                         </span>
		                         <div class="form-line">
		                             <input type="number" name="stock" class="form-control" placeholder=" 00">
		                         </div>
		                     </div>
		                 </div>
	                 </div>
	
	            </div>
	            <div class="modal-footer">
	                <button type="submit" class="btn btn-link waves-effect">GUARDAS CAMBIOS</button> 
	                <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">CERRAR</button>
	            </div>
            </form>
            
        </div>
    </div>
</div>