<!-- CPU Usage -->
<div class="row clearfix">
    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
        <div class="card">
            <div class="header">
                <h2>REGISTRO DE VENTAS (%)</h2>
                <div class="pull-right">
                    <div class="switch panel-switch-btn">
                        <span class="m-r-10 font-12">TIEMPO REAL</span>
                        <label>OFF<input type="checkbox" id="realtime" checked><span class="lever switch-col-cyan"></span>ON</label>
                    </div>
                </div>
                <ul class="header-dropdown m-r--5">
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <i class="material-icons">more_vert</i>
                        </a>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="javascript:void(0);">Accion</a></li>
                            <li><a href="javascript:void(0);">Otra accion</a></li>
                            <li><a href="javascript:void(0);">Algo mas aqui</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="body">
                <div id="real_time_chart" class="dashboard-flot-chart"></div>
            </div>
        </div>
    </div>
</div>
<!-- #END# CPU Usage -->