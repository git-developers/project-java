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





<div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header bg-orange">
                            <h2>
                                TRANSFERECIA DE PRODUCTOS
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
                        
                        <div class="body">
				                        
				    		<%--FORM --%>
				             <div class="row clearfix">
								<div class="col-md-offset-3 col-md-6">
									<p>
									    <b>Sucursal</b>
									</p>
									<div class="form-group">
										<select name="form_sucursal" class="form-control show-tick" tabindex="-98">
									        <option value="1">Sucursal 1</option>
									        <option value="2">Sucursal 2</option>
									    </select>
									</div>
							    </div>
							    
				             </div>
				             <%--FORM --%>
				             
                        
                        
                        
                            <select id="optgroup" class="ms" multiple="multiple" style="position: absolute; left: -9999px;">
                                <optgroup label="Almacen 1">
                                    <option value="1">Producto 1</option>
                                    <option value="2">Producto 2</option>
                                </optgroup>
                                <optgroup label="Almacen 2">
                                    <option value="3">Producto 1</option>
                                    <option value="4">Producto 2</option>
                                    <option value="5">Producto 3</option>
                                    <option value="6">Producto 4</option>
                                </optgroup>
                                <optgroup label="Almacen 3">
                                    <option value="7">Producto 1</option>
                                    <option value="8">Producto 2</option>
                                </optgroup>
                            </select>
                            
                        <p>&nbsp;</p>
                        
                        
			             <%-- BOTONES --%>
			             <div class="row clearfix text-center">
			             	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			                     <button type="button" class="btn btn-primary waves-effect btn-lg m-l-15">
			                     	<i class="material-icons">save</i> REGISTRAR
			                      </button>
			                      <a href="<%=application.getContextPath() %>/dashboard" class="btn bg-orange waves-effect btn-lg m-l-15">
			                     	<i class="material-icons">cancel</i> CANCELAR
			                      </a>
				              </div>
				          </div>
			            <%-- BOTONES --%>
                        
                        </div>
                    </div>
                </div>
            </div>







<%@include file="../template-layout-bottom.jsp" %>

<script type="text/javascript">
	var contextPath = "<%=application.getContextPath() %>";
	
	//Multi-select
    $('#optgroup').multiSelect({ selectableOptgroup: true });
	
	
</script>






