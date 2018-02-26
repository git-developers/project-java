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
 
 
 <div class="row clearfix">
    <!-- Line Chart -->
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="card">
            <div class="header">
                <h2>REPORTE 1</h2>
                <ul class="header-dropdown m-r--5">
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <i class="material-icons">more_vert</i>
                        </a>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="javascript:void(0);" class=" waves-effect waves-block">Accion 1</a></li>
                            <li><a href="javascript:void(0);" class=" waves-effect waves-block">Accion 2</a></li>
                            <li><a href="javascript:void(0);" class=" waves-effect waves-block">Algo mas</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="body"><iframe class="chartjs-hidden-iframe" style="width: 100%; display: block; border: 0px; height: 0px; margin: 0px; position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px;"></iframe>
                <canvas id="line_chart" height="282" width="565" style="display: block; width: 565px; height: 282px;"></canvas>
            </div>
        </div>
    </div>
    <!-- #END# Line Chart -->

</div>
 

<%@include file="../template-layout-bottom.jsp" %>


<script src="assets/js/pages/charts/chartjs.js"></script>

<script type="text/javascript">
$(function () {
    new Chart(document.getElementById("line_chart").getContext("2d"), getChartJs('line'));
    //new Chart(document.getElementById("bar_chart").getContext("2d"), getChartJs('bar'));
    //new Chart(document.getElementById("radar_chart").getContext("2d"), getChartJs('radar'));
    //new Chart(document.getElementById("pie_chart").getContext("2d"), getChartJs('pie'));
});
</script>



