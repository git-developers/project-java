<%@page import="util.UDate"%>
<%@include file="../template-layout-top.jsp" %>

<%

	Usuario usuario2 = (Usuario)session.getAttribute("usuario");
%>

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
                <i class="material-icons">shopping_cart</i> Orden salida mercaderia
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
        <form name="form_orden_salida">
        <div class="body">



    		<%--FORM --%>
             <div class="row clearfix">
             	<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                      <div class="form-group">
                          <div class="form-line">
                          		<b>Destino</b>
                          		<select name="form_destino" class="form-control show-tick" tabindex="-98">
                          			<option>Tienda 1</option>
                          			<option>Tienda 2</option>
                          			<option>Tienda 3</option>
                        		</select>
                          </div>
                      </div>
                  </div>
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                      <div class="form-group">
                          <div class="form-line">
                               	<b>Receptor</b>
                          		<select name="form_receptor" class="form-control show-tick" tabindex="-98">
                          			<option>Persona 1</option>
                          			<option>Persona 2</option>
                          			<option>Persona 3</option>
                        		</select>
                          </div>
                      </div>
                  </div>
                  
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                      <div class="form-group">
                          <div class="form-line">
                              <input type="text" name="form_descripcion" class="form-control" placeholder="Descripción" required="required">
                          </div>
                      </div>
                  </div>
                  
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                      <div class="form-group">
                          <div class="form-line">
                              <input type="date" name="form_fecha_salida" class="form-control" required="required">
                          </div>
                      </div>
                  </div>
                  
                  
                 </div>
                 <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                     <button type="submit" class="btn btn-primary waves-effect btn-lg m-l-15">
                     	<i class="material-icons">save</i> REGISTRAR
                      </button>
                      <a href="<%=application.getContextPath() %>/dashboard" class="btn bg-orange waves-effect btn-lg m-l-15">
                     	<i class="material-icons">cancel</i> CANCELAR
                      </a>
                 </div>
             </div>
             <%--FORM --%>
             
             
             
             <%--PRODUCTO SEARCH --%>
             <div class="row clearfix">
             <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                 <div class="card">
                     <div class="header bg-green">
                         <h2>
                             Agregar productos <small>busque los productos por c&oacute;digo...</small>
                         </h2>
                         <ul class="header-dropdown m-r-0">
                             <li>
                                 <a href="javascript:void(0);">
                                     <i class="material-icons">info_outline</i>
                                 </a>
                             </li>
                             <li>
                                 <a href="javascript:void(0);">
                         mercaderia-orden-ingreso            <i class="material-icons">help_outline</i>
                                 </a>
                             </li>
                         </ul>
                     </div>
                     <div class="body">
                     
                     <div class="row clearfix">
	                     <div class="col-md-6">
	                          <div class="form-group">
	                              <div class="form-line">
	                                  <input type="text" id="product_code" class="form-control" placeholder="código de producto">
	                              </div>
	                          </div>
	                          <div class="form-group">
	                              <div class="form-line">
	                                  <input type="number" id="producto_quantity" class="form-control" placeholder="cantidad">
	                              </div>
	                          </div>	                          
	                          <div class="form-group">
	                              <button type="button" id="producto_add" class="btn bg-green waves-effect">
	                              	<i class="material-icons">library_add</i> AGREGAR
	                              </button>
	                          </div>
	                      </div>
	                      
	                      <div class="col-md-6">
	                      
	                      		<span style="display:none" id="item_id">-</span>
	                      		<span style="display:none" id="item_stock">-</span>
	                      		
		                      <ul class="list-group">
                               <li class="list-group-item">Producto <span class="item-prod badge bg-pink" id="item_producto">-</span></li>
                               <li class="list-group-item">Tipo de tela <span class="item-prod badge bg-cyan" id="item_tipo_tela">-</span></li>
                               <li class="list-group-item">Color <span class="item-prod badge bg-gray" id="item_color">-</span></li>
                               <li class="list-group-item">Talla <span class="item-prod badge bg-orange" id="item_talla">-</span></li>
                               <li class="list-group-item">Descripci&oacute;n <span class="item-prod badge bg-purple" id="item_descripcion">-</span></li>
	                          </ul>
                          </div>
	                      
	                      
                      </div>
                     
                     
                     </div>
                 </div>
                </div>
                </div>
             <%--PRODUCTO SEARCH --%>
                
                
             <%--PRODUCTO AGREGADOS --%>
             <div class="row clearfix">
             	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                	
		            <table id="table-json-producto" class="table-json-producto table table-bordered table-striped table-hover js-basic-example dataTable" role="grid" aria-describedby="DataTables_Table_0_info">
		                <thead>
		                    <tr class="bg-green">
		                        <th>
		                        	<i class="material-icons">code</i>
		                       	</th>
		                        <th>
		                        	descripci&oacute;n
	                        	</th>
		                        <th>
		                        	cantidad
		                       	</th>
		                       	<th>&nbsp;</th>
		                       	<th>&nbsp;</th>
		                    </tr>
		                </thead>
		                <tbody>
		
		                </tbody>
		                <tfoot>
		                    <tr class="bg-green">
		                        <th>
		                        	<i class="material-icons">code</i>
		                       	</th>
		                        <th>
		                        	descripci&oacute;n
	                        	</th>
		                        <th>
		                        	cantidad
		                       	</th>
		                       	<th>&nbsp;</th>
		                       	<th>&nbsp;</th>
		                    </tr>
		                </tfoot>
		            </table>
	        	</div>
	        </div>
	        <%--PRODUCTO AGREGADOS --%>
                
                
            
        </div>
        </form>
        <%--BODY --%>
        
    </div>
</div>
</div>


<%@include file="../template-layout-bottom.jsp" %>

<script type="text/javascript">
	var contextPath = "<%=application.getContextPath() %>";
	var tableJsonProductos;
</script>

<script src="assets/js/orden-salida/productos.js"></script>
<script src="assets/js/orden-salida/add-producto.js"></script>
<script src="assets/js/orden-salida/edit-producto-cantidad.js"></script>
<script src="assets/js/orden-salida/register.js"></script>


<%@include file="../modal/modal-edit-producto-cantidad.jsp" %>





