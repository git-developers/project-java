<%@page import="java.math.BigDecimal"%>
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

<form name="form_cierre_caja">

<div class="row clearfix">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="card">
            <div class="header bg-light-green">
                <h2>
                    <i class="material-icons">sd_storage</i> Consultar mercaderia
			        <small><%=UDate.footer()%></small>
			        <small>Usuario:: <%=usuario2.getNombre() + " " + usuario2.getApellido() %></small>
                </h2>
                <ul class="header-dropdown m-r--5">
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <i class="material-icons">more_vert</i>
                        </a>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="javascript:void(0);" class=" waves-effect waves-block">Action</a></li>
                            <li><a href="javascript:void(0);" class=" waves-effect waves-block">Another action</a></li>
                            <li><a href="javascript:void(0);" class=" waves-effect waves-block">Something else here</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            
            <form name="form_consultar_mercaderia">
            <div class="body">
            
    		<%--FORM 1--%>
    		
             <div class="row clearfix">
             
             	<div class="col-md-9">
             
	               <div class="col-md-6">
	                   <div class="form-group">
	                   		<b>Fecha Desde</b>
	                       <div class="form-line">
	                           <input type="date" class="form-control" >
	                       </div>
	                   </div>
	               </div>
                  <div class="col-md-6">
                      <div class="form-group">
                      	  <b>Fecha hasta</b>
                          <div class="form-line">
                              <input type="date" class="form-control">
                          </div>
                      </div>
                  </div>
                 
	           <div class="col-md-12">
	               <div class="form-group">
	               		<b>Local</b>
	                   <div class="form-line">
	                        <select name="" class="form-control show-tick" tabindex="-98">
							      <option value="1">Tienda 1</option>
							      <option value="2">Tienda 2</option>
							      <option value="2">Tienda 3</option>
							  </select>
	                   </div>
	               </div>
	           </div>
                 
                 
             </div>
             
	             <div class="col-md-3">
	             	<button type="button" class="buscar btn bg-light-green waves-effect btn-lg m-l-15">
	                   <i class="material-icons">search</i> BUSCAR
	                </button>
	             </div>
             
             </div>
             
             <%--FORM 1--%>

            </div>
            </form>
            
        </div>
    </div>
</div>


<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
    <div class="card">
    
    	
        <div class="header">
            <h2>
                <i class="material-icons">sd_storage</i> Detalle de los productos
                <small>info</small>
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
        <div class="body">



             <%--PRODUCTO AGREGADOS --%>
             <div class="row clearfix">
             	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                	
		            <table id="table-json-producto" class="table table-bordered table-striped table-hover js-basic-example dataTable" role="grid" aria-describedby="DataTables_Table_0_info">
		                <thead>
		                    <tr class="bg-light-green">
		                        <th>
		                        	<i class="material-icons">code</i>
		                       	</th>
		                        <th>
		                        	c&oacute;digo
	                        	</th>
		                        <th>
		                        	descripci&oacute;n
	                        	</th>
		                        <th>
		                        	stock por local
		                       	</th>
		                       	<th>
		                        	stock total
		                       	</th>
		                        <th>
		                        	S/ precio unitario
		                       	</th>
		                    </tr>
		                </thead>
		                <tbody>
		
		                </tbody>
		                <tfoot>
		                    <tr class="bg-light-green">
		                        <th>
		                        	<i class="material-icons">code</i>
		                       	</th>
		                       	<th>
		                        	c&oacute;digo
	                        	</th>
		                        <th>
		                        	descripci&oacute;n
	                        	</th>
		                        <th>
		                        	stock por local
		                       	</th>
		                        <th>
		                        	stock total
		                       	</th>
		                       	<th>
		                        	S/ precio unitario
		                       	</th>
		                    </tr>
		                </tfoot>
		            </table>
	        	</div>
	        </div>
	        <%--PRODUCTO AGREGADOS --%>
                

             
             <%-- BOTONES --%>
             <div class="row clearfix text-center">
             	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                      <button type="submit" class="btn bg-purple waves-effect btn-lg m-l-15" onclick="window.print();">
                     	<i class="material-icons">local_printshop</i> IMPRIMIR
                      </button>
                      <a href="<%=application.getContextPath() %>/dashboard" class="btn bg-orange waves-effect btn-lg m-l-15">
                     	<i class="material-icons">cancel</i> CANCELAR
                      </a>
	              </div>
	          </div>
            <%-- BOTONES --%>
            
        </div>
        <%--BODY --%>
        
    </div>
</div>
</div>


</form>



<%@include file="../template-layout-bottom.jsp" %>

<script type="text/javascript">
	var contextPath = "<%=application.getContextPath() %>";
	var tableJsonProductos;
</script>


<script src="assets/js/consultar-mercaderia/productos.js"></script>
<script src="assets/js/consultar-mercaderia/register.js"></script>






