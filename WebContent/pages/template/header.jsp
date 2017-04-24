<%@page import="util.UConstant"%>
<%

String uri = request.getScheme() + "://" +   // "http" + "://
        request.getServerName() +       // "myhost"
        ":" +                           // ":"
        request.getServerPort() +       // "8080"
        request.getRequestURI() +       // "/people"
        "?" +                           // "?"
        request.getQueryString();       // "lastname=Fox&age=30"

	//String uriB = request.getRequestURL(); // retorna toda la url
	
	String jspName = request.getRequestURI().replace(application.getContextPath() + "/pages/" , "");
	String title = "";

	if(jspName.equals("dashboard/index.jsp")){
		title = "Dashboard";
	}else if(jspName.equals("view/orden-ingreso.jsp")){
		title = "Orden de ingreso";
	}else if(jspName.equals("view/orden-salida.jsp")){
		title = "Orden de salida";
	}else if(jspName.equals("view/login.jsp")){
		title = "Login";
	}else if(jspName.equals("view/reporte-1.jsp")){
		title = "Reporte 1";
	}else if(jspName.equals("view/reporte-2.jsp")){
		title = "Reporte 2";
	}else if(jspName.equals("view/comprobante-de-venta.jsp")){
		title = "Comprobante de venta";
	}else if(jspName.equals("view/transferencia-productos.jsp")){
		title = "Transferencia de productos";
	}else{
		title = "USMP";
	}
	
	boolean ordenEntrada = false;
	boolean ordenSalida = false;
	
	if(jspName.equals("view/orden-entrada.jsp")){
		ordenEntrada = true;
	}else if(jspName.equals("view/orden-salida.jsp")){
		ordenSalida = true;
	}
	
	

%>


<title><%=title %> | <%=UConstant.proyect_name_long %></title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    
<!-- Favicon-->
<link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css" />

<!-- Bootstrap Core Css -->
<link href="assets/plugins/bootstrap/css/bootstrap.css" rel="stylesheet" />

<!-- Waves Effect Css -->
<link href="assets/plugins/node-waves/waves.css" rel="stylesheet" />

<!-- Animation Css -->
<link href="assets/plugins/animate-css/animate.css" rel="stylesheet" />

<!-- Preloader Css -->
<link href="assets/plugins/material-design-preloader/md-preloader.css" rel="stylesheet" />

<!-- Morris Chart Css-->
<link href="assets/plugins/morrisjs/morris.css" rel="stylesheet" />

<!-- Custom Css -->
<link href="assets/css/style.css" rel="stylesheet">

<!-- AdminBSB Themes. You can choose a theme from assets/css/themes instead of get all themes -->
<link href="assets/css/themes/all-themes.css" rel="stylesheet" />

<!-- JQuery DataTable Css -->
<link href="assets/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css" rel="stylesheet">

<!-- Bootstrap Select Css -->
<link href="assets/plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet" />

<!-- Multi Select Css -->
<link href="assets/plugins/multi-select/css/multi-select.css" rel="stylesheet">

    
    
    
    