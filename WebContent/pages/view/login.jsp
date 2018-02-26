<%@page import="util.UConstant"%>
<%@include file="../template-layout-top-login.jsp" %> 
	
	<%
		String mensaje = "";
		if(session.getAttribute("loginError") != null){
	 		mensaje = (String) session.getAttribute("loginError");
	%>
	  	<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
		    <div class="info-box bg-red">
		        <div class="icon">
		            <i class="material-icons">warning</i>
		        </div>
		        <div class="content">
		            <div class="text"><%=mensaje %></div>
		            <div class="text">Ops!</div>
		        </div>
		    </div>
		</div>
	<% 
		session.removeAttribute("loginError");
	 	}
	%>


    <div class="login-box">
    
        <div class="logo">
            <a href="javascript:void(0);">Almacenamiento<b>INV</b></a>
            <small><%=UConstant.proyect_name_long %></small>
        </div>
        <div class="card">
            <div class="body">
                <form id="sign_in" method="POST">
                    <div class="msg">Login para empezar su sessi&oacute;n</div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="_username" placeholder="Username" required autofocus>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="_password" placeholder="Password" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-8 p-t-5">
                            <input type="checkbox" name="rememberme" id="rememberme" class="filled-in chk-col-pink">
                            <label for="rememberme">Recuerdame, no me dejes ;(</label>
                        </div>
                        <div class="col-xs-4">
                            <button class="btn btn-block bg-pink waves-effect" type="submit">LOGIN</button>
                        </div>
                    </div>
                    <div class="row m-t-15 m-b--20">
                        <div class="col-xs-6">
                            <a href="sign-up.html">Registrate ahora!</a>
                        </div>
                        <div class="col-xs-6 align-right">
                            <a href="forgot-password.html">Olvidaste tu password?</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

<%@include file="../template-layout-bottom-login.jsp" %>








