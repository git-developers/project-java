<%@page import="java.math.BigDecimal"%>
<%@page import="util.UDate"%>
<%@include file="../template-layout-top.jsp" %>

<%

	Usuario usuario2 = (Usuario)session.getAttribute("usuario");
	String totalBoleta = (String)request.getAttribute("total_boleta");
	String totalFactura = (String)request.getAttribute("total_factura");
	
	BigDecimal total = UFormat.bigDecimal(totalBoleta).add(UFormat.bigDecimal(totalFactura));
	
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

<form name="form_cierre_caja">

<div class="row clearfix">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="card">
            <div class="header bg-amber">
                <h2>
                    <i class="material-icons">keyboard_hide</i> Cierre de caja
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
                <div class="row clearfix">
                    <div class="col-md-3">
                        <b>Monto</b>
                        <div class="input-group ">
                            <div class="form-line">
                                <input type="text" name="form_apertura_caja" class="form-control" placeholder="100.00">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <b>Turno</b>
                        <div class="input-group">
                            <div class="form-line">
                                <select name="form_turno" class="form-control show-tick" tabindex="-98">
								      <option value="1">Turno 1</option>
								      <option value="2">Turno 2</option>
								  </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <b>Hora</b>
                        <div class="input-group ">
                            <div class="form-line">
                                <input type="time" name="form_hora" class="form-control" placeholder="100.00">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
             			<b>Sucursal</b>
                        <div class="input-group ">
                            <div class="form-line">
                                <select name="form_sucursal" class="form-control show-tick" tabindex="-98">
								      <option value="1">Sucursal 1</option>
								      <option value="2">Sucursal 2</option>
								  </select>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		                <div class="form-group">
		                    <div class="form-line">
		                        <input type="text" name="form_descripcion" class="form-control" placeholder="Descripción">
		                    </div>
		                </div>
		           	</div>
                    
                    
                </div>
            </div>
        </div>
    </div>
</div>


<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
    <div class="card">
        <div class="header bg-purple">
            <h2>
                <i class="material-icons">face</i> <%=usuario2.getNombre() + " " + usuario2.getApellido() %>, Cierre su turno con lo siguiente
                <small><%=UDate.footer()%></small>
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



    		<%--FORM 1--%>
             <div class="row clearfix">
             
             	<div class="col-md-6">
	               <div class="col-md-12">
	                   <div class="form-group">
	                   		<b>Total factura S/</b>
	                       <div class="form-line">
	                           <input type="number" class="form-control" placeholder="000.00" value="<%=totalFactura %>" readonly="readonly">
	                       </div>
	                   </div>
	               </div>
                  <div class="col-md-12">
                      <div class="form-group">
                      	  <b>Total boleta S/</b>
                          <div class="form-line">
                              <input type="number" class="form-control" placeholder="000.00" value="<%=totalBoleta %>" readonly="readonly">
                          </div>
                      </div>
                  </div>
                 </div>
                 
             	<div class="col-md-6">
	               <div class="col-md-12">
	                   <div class="form-group">
	                   		<b>Total efectivo S/</b>
	                       <div class="form-line">
	                           <input type="number" id="form_total_efectivo" class="total form-control" placeholder="000.00" required="required" min="0">
	                       </div>
	                   </div>
	               </div>
                  <div class="col-md-12">
                      <div class="form-group">
                      	  <b>Monto credito S/</b>
                          <div class="form-line">
                              <input type="number" id="form_monto_credito" class="total form-control" placeholder="000.00" required="required" min="0">
                          </div>
                      </div>
                  </div>
                  <div class="col-md-12">
                      <div class="form-group">
                      	  <b>Salida de caja S/</b>
                          <div class="form-line">
                              <input type="number" id="form_salida_caja" class="total form-control" placeholder="000.00" required="required" min="0">
                          </div>
                      </div>
                  </div>
                 </div>
                 
                 
             </div>
             <%--FORM 1--%>
             
             
             
             
             <%--FORM 2--%>
             <div class="row clearfix">
             
             	<div class="col-md-6">
	               <div class="col-md-12">
	                   <div class="form-group">
	                   		<b>Monto esperado S/</b>
	                       <div class="form-line focused ">
	                           <input type="number" id="form_monto_esperado" name="form_monto_esperado" class="form-control" placeholder="000.00" value="<%=total%>" readonly="readonly">
	                       </div>
	                   </div>
	               </div>
                 </div>
                 
             	<div class="col-md-6">
	               <div class="col-md-12">
	                   <div class="form-group">
	                   		<b>Monto total S/</b>
	                       <div class="form-line focused success">
	                           <input type="number" id="form_monto_total" name="form_monto_total" class="form-control" placeholder="000.00" required="required" readonly="readonly" min="0">
	                       </div>
	                   </div>
	               </div>

                 </div>
                 
                 
                 
				<div class="col-md-12">
                    <div id="saldo-faltante" class="info-box hover-zoom-effect">
                        <div class="icon">
                            <i class="material-icons">local_activity</i>
                        </div>
                        <div class="content">
                            <div class="text">Saldo faltante S/</div>
                            <div class="number">0</div>
                        </div>
                    </div>
                </div>
                  
                 
                 
                 
             </div>
             <%--FORM 2--%>
              
             
             
             <%-- BOTONES --%>
             <div class="row clearfix text-center">
             	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                     <button type="submit" class="btn btn-primary waves-effect btn-lg m-l-15">
                     	<i class="material-icons">save</i> REGISTRAR
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
</script>

<script src="assets/js/cierre-caja/suma-de-caja.js"></script>
<script src="assets/js/cierre-caja/register.js"></script>






