<%@page import="util.UDate"%>
<%@include file="../template-layout-top.jsp" %>

<%

	Usuario usuario2 = (Usuario)session.getAttribute("usuario");
%>

<style>
.bootstrap-select.btn-group.show-tick .dropdown-menu li.selected a span.check-mark {
  margin-top: 9px; }
</style>

<!-- 
<div class="block-header">
    <h2>DASHBOARD 333</h2>
</div>
 -->


<div class="row"  >
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="submit-message" style="display: none">
	    <div class="info-box bg-light-green hover-expand-effect">
	        <div class="icon">
	            <i class="material-icons">thumb_up</i>
	        </div>
	        <div class="content">
	            <div class="text">INFO</div>
	            <div class="number">-</div>
	        </div>
	    </div>
	</div>
</div>




<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
    <div class="card">
        <div class="header">
            <h2>
                <i class="material-icons">library_books</i> Comprobante de venta
                <small><%=UDate.footer()%></small>
                <small>Usuario:: <%=usuario2.getNombre() + " " + usuario2.getApellido() %></small>
            </h2>
            <ul class="header-dropdown m-r--5">
                <li class="dropdown">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <i class="material-icons">more_vert</i>
                    </a>
                    <ul class="dropdown-menu pull-right">
                        <li><a href="javascript:void(0);" class=" waves-effect waves-block">Accion 1</a></li>
                        <li><a href="javascript:void(0);" class=" waves-effect waves-block">Accion 2</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        
        <%--BODY --%>
        <form name="form_comprobante_pago">
        <div class="body">
        
        
        
        
    		<%--FORM --%>
             <div class="row clearfix">
				<div class="col-md-offset-2 col-md-4">
					<p>
					    <b>Tipo comprobante</b>
					</p>
					<div class="form-group">
						<select name="form_tipo_comprobante" class="form-control show-tick" tabindex="-98">
					        <option value="BOLETA">Boleta</option>
					        <option value="FACTURA">Factura</option>
					    </select>
					</div>
			    </div>
			    
			    <%-- 
				<div class="col-md-offset-2 col-md-4">
					<button class="btn bg-green btn-lg btn-block waves-effect" type="button">NUMERO <span class="badge">00003</span></button>
			    </div>
			    --%>
			    
             </div>
             <%--FORM --%>
             
        

             
             <%--CLIENTE SEARCH --%>
             <input type="hidden" name="form_cliente_id" id="item_cliente_id" >
             <div class="row clearfix">
             <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                 <div class="card">
                     <div class="header bg-indigo">
                         <h2>
                             Cliente <small>busque los cliente por c&oacute;digo...</small>
                         </h2>
                         <ul class="header-dropdown m-r-0">
                             <li>
                                 <a href="javascript:void(0);">
                                     <i class="material-icons">info_outline</i>
                                 </a>
                             </li>
                             <li>
                                 <a href="javascript:void(0);">
                                     <i class="material-icons">help_outline</i>
                                 </a>
                             </li>
                         </ul>
                     </div>
                     <div class="body">
                     
                     <div class="row clearfix">
	                     <div class="col-md-6">
	                          <div class="form-group">
	                              <div class="form-line">
	                                  <input type="text" id="form_dni" class="form-control" placeholder="dni">
	                              </div>
	                          </div>
	                      </div>
	                      
	                      <div class="col-md-6">	                      		
		                      <ul class="list-group">
                               <li class="list-group-item">Se&ntilde;or/empresa <span class="item-prod badge bg-pink" id="item_nombre">-</span></li>
                               <li class="list-group-item">Direcci&oacute;n <span class="item-prod badge bg-cyan" id="item_direccion">-</span></li>
	                          </ul>
                          </div>

                      </div>
                     
                     </div>
                 </div>
                </div>
                </div>
                <%--CLIENTE SEARCH --%>
                
                
                
                
             <%--PRODUCTO AGREGADOS --%>
             <div class="row clearfix">
             	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                	
		            <table id="table-json-producto-seleccionado" class="table-json-producto-seleccionado table table-bordered table-striped table-hover js-basic-example dataTable" role="grid" aria-describedby="DataTables_Table_0_info">
		                <thead>
		                    <tr class="bg-indigo">
		                        <th>
		                        	<i class="material-icons">code</i>
		                       	</th>
		                        <th>
		                        	descripci&oacute;n
	                        	</th>
		                        <th>
		                        	cantidad
		                       	</th>
		                        <th>
		                        	S/ precio
		                       	</th>
		                       	<th>&nbsp;</th>
		                       	<th>&nbsp;</th>
		                    </tr>
		                </thead>
		                <tbody>
		
		                </tbody>
		                <tfoot>
		                    <tr class="bg-indigo">
		                        <th>
		                        	<i class="material-icons">code</i>
		                       	</th>
		                        <th>
		                        	descripci&oacute;n
	                        	</th>
		                        <th>
		                        	cantidad
		                       	</th>
		                       	<th>
		                        	S/ precio
		                       	</th>
		                       	<th>&nbsp;</th>
		                       	<th>&nbsp;</th>
		                    </tr>
		                </tfoot>
		            </table>
	        	</div>
	        </div>
	        <%--PRODUCTO AGREGADOS --%>
                
                
                
                
            <%-- SUB TOTAL INPUT --%>
            <div class="row clearfix">
	              <div class="col-md-4">
	                  <b>Sub total S/</b>
	                  <div class="input-group">
	                      <span class="input-group-addon">
	                          <i class="material-icons">monetization_on</i>
	                      </span>
	                      <div class="form-line">
	                          <input type="text" name="form_sub_total" id="form_sub_total" class="form-control" placeholder="0.00" readonly="readonly">
	                      </div>
	                  </div>
	              </div>
  	              <div class="col-md-4">
	                  <b>Descuentos S/</b>
	                  <div class="input-group">
	                      <span class="input-group-addon">
	                          <i class="material-icons">monetization_on</i>
	                      </span>
	                      <div class="form-line">
	                          <input type="text" name="form_descuentos" id="form_descuentos" class="form-control" placeholder="0.00" readonly="readonly">
	                      </div>
	                  </div>
	              </div>
	              <div class="col-md-4">
	                  <b>Total S/ (+0.18%)</b>
	                  <div class="input-group">
	                      <span class="input-group-addon">
	                          <i class="material-icons">monetization_on</i>
	                      </span>
	                      <div class="form-line">
	                          <input type="text" name="form_total" id="form_total" class="form-control" placeholder="0.00" readonly="readonly">
	                      </div>
	                  </div>
	              </div>
	          </div>
            <%-- SUB TOTAL INPUT --%>
            
                
                
                
             <%-- BOTONES --%>
             <div class="row clearfix text-center">
             	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                     <button type="submit" class="btn btn-primary waves-effect btn-lg m-l-15">
                     	<i class="material-icons">save</i> REGISTRAR
                      </button>
                      <button type="submit" class="btn bg-purple waves-effect btn-lg m-l-15" onclick="window.print();">
                     	<i class="material-icons">local_printshop</i> IMPRIMIR
                      </button>
                      <button id="btn-modal-add-producto" type="button" class="btn bg-green waves-effect btn-lg m-l-15">
                     	<i class="material-icons">view_module</i> LISTA PRODUCTO
                      </button>
                      <a href="<%=application.getContextPath() %>/dashboard" class="btn bg-orange waves-effect btn-lg m-l-15">
                     	<i class="material-icons">cancel</i> CANCELAR
                      </a>
	              </div>
	          </div>
            <%-- BOTONES --%>
                
                
                
                
                
                
            
        </div>
        </form>
        <%--BODY --%>
        
    </div>
</div>
</div>


<%@include file="../template-layout-bottom.jsp" %>

<script type="text/javascript">
$(function () {
    $('#btn-modal-add-producto').on('click', function () {
        //var color = $(this).data('color');
        //$('#mdModal .modal-content').removeAttr('class').addClass('modal-content modal-col-' + color);
        $('#modal-add-producto').modal('show');
    });
    
});
</script>

<script type="text/javascript">
	var contextPath = "<%=application.getContextPath() %>";
	var tableJsonProductos;
	var tableJsonProductosSeleccionado;
</script>

<script src="assets/js/comprobante-de-venta/productos.js"></script>
<script src="assets/js/comprobante-de-venta/add-cliente.js"></script>
<script src="assets/js/comprobante-de-venta/edit-producto-cantidad.js"></script>
<script src="assets/js/comprobante-de-venta/register.js"></script>

<%@include file="../modal/modal-add-producto.jsp" %>
<%@include file="../modal/modal-edit-producto-cantidad.jsp" %>







