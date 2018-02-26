//$(document).ready(function() {
$(function () {

    tableJsonProductos = $('#table-json-producto').DataTable({
        "lengthMenu": [[10, 20, 30, -1], [10, 20, 30, "Todos"]],
        "lengthChange": false,
        "pageLength": 10,
        "dom": '<"top"iflp><"clear">rt<"bottom">',
        "order": [[ 0, "desc" ]],
        "ordering": true,
        "paging": true,
        "info": true,
        "autoWidth": true,
        "filter": true,
        "searching": true,
        "ajax": {
            "url": contextPath + "/producto.json",
            "type": "GET",
            "dataSrc": ""
          },
        //"data": [],
        "columns": [
            { 
                "data": function (obj) {
                    return '<span class="badge bg-light-green">' + obj.id + '</span>';
                }
            },
            { 
                "data": function (obj) {
                    return obj.codigo;
                }
            },
            { 
                "data": function (obj) {
                    return obj.descripcion;
                }
            },
            { 
                "data": function (obj) {
                    return '<span id="cantidad_' + obj.id + '">' + obj.stock + '</span>';
                }
            },
            { 
                "data": function (obj) {
                    return parseInt(obj.stock) + parseInt(getRandom(5, 25));
                }
            },
            { 
                "data": function (obj) {
                    return obj.precio;
                }
            }
        ],
        "fnRowCallback": function(nRow, aData, iDisplayIndex, iDisplayIndexFull) {
            $(nRow).attr("id",aData.id);
            //$(nRow).attr("class","alert");
            return nRow;
        }  
    });

    
    /*** ADD SELECCION ***/
    $('#table-json-producto tbody').on('click', 'tr', function () {

    	var tr = $(this).parents('tr');
    	setTrColor(tr);

    });
    /*** ADD SELECCION ***/

});


function setTrColor(tr){
	
	tableJsonProductos.$('tr.selected').removeClass('selected');
	
    if ( tr.hasClass('selected') ) {
        tr.removeClass('selected');
    }
    else {
        tr.addClass('selected');
    }
}
  
function getRandom(min, max){
	var random = Math.floor(Math.random() * (max - min + 1)) + min; 
	return random;
}
        