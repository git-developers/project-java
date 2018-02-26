
<%@page import="util.UDate"%>
<%@page import="util.UFormat"%>
<%@page import="util.UConstant"%>
<%@page import="beans.Usuario"%>

<%
	
	String jspName2 = request.getRequestURI().replace(application.getContextPath() + "/pages/" , "");

	boolean ordenEntrada3 = false; 
	boolean ordenSalida3 = false; 
	boolean reporte1 = false; 
	boolean reporte2 = false; 
	boolean comprobanteVenta = false; 
	boolean cierreCaja = false; 
	boolean transferenciaProductos = false; 
	boolean consultarMercaderia = false; 
	boolean notaEntradaMercaderia = false; 
	
	
	if(jspName2.equals("view/orden-ingreso.jsp")){
		ordenEntrada3 = true;
	}else if(jspName2.equals("view/orden-salida.jsp")){
		ordenSalida3 = true;
	}else if(jspName2.equals("view/reporte-1.jsp")){
		reporte1 = true;
	}else if(jspName2.equals("view/reporte-2.jsp")){
		reporte2 = true;
	}else if(jspName2.equals("view/comprobante-de-venta.jsp")){
		comprobanteVenta = true;
	}else if(jspName2.equals("view/cierre-caja.jsp")){
		cierreCaja = true;
	}else if(jspName2.equals("view/transferencia-productos.jsp")){
		transferenciaProductos = true;
	}else if(jspName2.equals("view/consultar-mercaderia.jsp")){
		consultarMercaderia = true;
	}else if(jspName2.equals("view/nota-entrada-mercaderia.jsp")){
		notaEntradaMercaderia = true;
	}

	Usuario usuario = (Usuario)session.getAttribute("usuario");
%>


<!-- Left Sidebar -->
<aside id="leftsidebar" class="sidebar">


    <!-- User Info -->
    <div class="user-info">
        <div class="image">
            <img src="assets/images/user.png" width="48" height="48" alt="User" />
        </div>
        <div class="info-container">
            <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><%=usuario.getNombre() + ' ' + usuario.getApellido() %></div>
            <div class="email"><%=usuario.getEmail() %></div>
            <div class="btn-group user-helper-dropdown">
                <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                <ul class="dropdown-menu pull-right">
                    <li><a href="javascript:void(0);"><i class="material-icons">person</i>Perfil</a></li>
                    <li role="seperator" class="divider"></li>
					<li><a href="javascript:void(0);"><i class="material-icons">group</i>Seguidores</a></li>
                    <li><a href="javascript:void(0);"><i class="material-icons">shopping_cart</i>Ventas</a></li>
                    <li><a href="javascript:void(0);"><i class="material-icons">favorite</i>Likes</a></li>
                    <li role="seperator" class="divider"></li>
                    <li><a href="<%=application.getContextPath() %>/logout"><i class="material-icons">input</i>Logout</a></li>
                </ul>
            </div>
        </div>
    </div>
    <!-- #User Info -->
    
    
    <!-- Menu -->
    <div class="menu">
        <ul class="list">
            <li class="header">MENU</li>
            <li class="active">
                <a href="<%=application.getContextPath() %>/dashboard">
                    <i class="material-icons">home</i>
                    <span>Inicio</span>
                </a>
            </li>
            <li class="<% if(ordenEntrada3){ %> active <% } %>">
                <a href="<%=application.getContextPath() %>/mercaderia-orden-ingreso">
                    <i class="material-icons">add_shopping_cart</i>
                    <span>Orden ingreso mercaderia</span>
                </a>
            </li>
            <li class="<% if(ordenSalida3){ %> active <% } %>">
                <a href="<%=application.getContextPath() %>/mercaderia-orden-salida">
                    <i class="material-icons">shopping_cart</i>
                    <span>Orden salida mercaderia</span>
                </a>
            </li>
            <li class="<% if(comprobanteVenta){ %> active <% } %>">
                <a href="<%=application.getContextPath() %>/comprobante-de-venta">
                    <i class="material-icons">library_books</i>
                    <span>Comprobante de venta</span>
                </a>
            </li>
            <li class="<% if(cierreCaja){ %> active <% } %>">
                <a href="<%=application.getContextPath() %>/cierre-caja">
                    <i class="material-icons">keyboard_hide</i>
                    <span>Cierre de caja</span>
                </a>
            </li>
            <li class="<% if(transferenciaProductos){ %> active <% } %>">
                <a href="<%=application.getContextPath() %>/transferencia-productos">
                    <i class="material-icons">transform</i>
                    <span>Transferencia de productos</span>
                </a>
            </li>
            <li class="<% if(consultarMercaderia){ %> active <% } %>">
                <a href="<%=application.getContextPath() %>/consultar-mercaderia">
                    <i class="material-icons">sd_storage</i>
                    <span>Consultar mercaderia</span>
                </a>
            </li>
            <li class="<% if(notaEntradaMercaderia){ %> active <% } %>">
                <a href="<%=application.getContextPath() %>/nota-entrada-mercaderia">
                    <i class="material-icons">redeem</i>
                    <span>Nota entrada mercaderia</span>
                </a>
            </li>
            

            <li class="<% if(reporte1 || reporte2){ %> active <% } %>">
                <a href="javascript:void(0);" class="menu-toggle">
                    <i class="material-icons">insert_chart</i>
                    <span>Reportes</span>
                </a>
                <ul class="ml-menu">
                    <li class="<% if(reporte1){ %> active <% } %>">
                        <a href="<%=application.getContextPath() %>/reporte-1">
                        	<i class="material-icons">show_chart</i>
                    		<span>Reporte 1</span>
                        </a>
                    </li>
                    <li class="<% if(reporte2){ %> active <% } %>">
                        <a href="<%=application.getContextPath() %>/reporte-2">
                        	<i class="material-icons">pie_chart</i>
                    		<span>Reporte 2</span>
                        </a>
                    </li>
                </ul>
            </li>  
            
            
            
        </ul>
    </div>
    <!-- #Menu -->
    
    
    
    <!-- Footer -->
    <div class="legal">
        <div class="copyright">
            &copy; <%=UDate.current() %> <a href="javascript:void(0);"><%=UConstant.proyect_name_short %></a>.
        </div>
        <div class="version">
            <b>Version: </b> 1.0.3
        </div>
    </div>
    <!-- #Footer -->
    
    
</aside>
<!-- #END# Left Sidebar -->
    