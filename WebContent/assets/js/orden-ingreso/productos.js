//$(document).ready(function() {
$(function () {

    tableJsonProductos = $('.table-json-producto').DataTable({
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
                    return '<span class="badge bg-green">' + obj.id + '</span>';
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
                    return '<button type="button" data-id="' + obj.id + '" class="btn bg-orange btn-circle btn-modal-edit-producto-cantidad waves-effect waves-circle waves-float"><i class="material-icons">mode_edit</i></button>';
                }
            },
            { 
                "data": function (obj) {
                    return '<button type="button" class="btn bg-red btn-circle btn-delete waves-effect waves-circle waves-float"><i class="material-icons">delete_forever</i></button>';
                }
            }
        ],
        "fnRowCallback": function(nRow, aData, iDisplayIndex, iDisplayIndexFull) {
            $(nRow).attr("id",aData.id);
            //$(nRow).attr("class","alert");
            return nRow;
        }  
    });

    /*** DELETE ***/
    $('#table-json-producto tbody').on('click', 'button.btn-delete', function () {

        var tr = $(this).parents('tr');
        tableJsonProductos.row(tr).remove().draw(false);

    });
    /*** DELETE ***/
    
    
    /*** EDIT ***/
    $('form[name=form_edit_producto_cantidad]').submit(function(event){
        event.preventDefault();

        //var id = $('.selected').attr("id");
        var data = getFormData($(this));
        
        tableJsonProductos.row('.selected').remove().draw(false);
        tableJsonProductos.row.add(data).draw(false);
        tableJsonProductos.order([0, 'desc']).draw(false);
        
        console.log(data);

        $('#modal-edit-producto-cantidad').modal('hide');
    });
    /*** EDIT ***/
    
    
    /*** ADD SELECCION ***/
    $('#table-json-producto tbody').on('click', 'tr', function () {

    	/*
        var data = tableJsonMaterial.rows($(this)).data();
        sumSubTotal(data);
        sumTotal();
        
        tableJsonMaterialSeleccionado
            .rows.add(data)
            .draw(false);
            */

    });
    /*** ADD SELECCION ***/

});



function setFormdata(data){

    $.each(data, function(name, val){
        var $el = $('form[name=form_edit_producto_cantidad] [name="'+name+'"]'),
            type = $el.attr('type');

        switch(type){
            case 'checkbox':
                $el.attr('checked', 'checked');
                break;
            case 'radio':
                $el.filter('[value="'+val+'"]').attr('checked', 'checked');
                break;
            default:
                $el.val(val);
        }
    });
}

function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

function setTrColor(tr){
	
	tableJsonProductos.$('tr.selected').removeClass('selected');
	
    if ( tr.hasClass('selected') ) {
        tr.removeClass('selected');
    }
    else {
        tr.addClass('selected');
    }
}




/*
function sumSubTotal(data){
	var materialPrecio = 0;
	var subTotal = getSubTotal();
	
    $.each($(data),function(key,value){
    	materialPrecio = value["precio"];
    });
    
    var sum = (parseFloat(subTotal) + parseFloat(materialPrecio)).toFixed(2);
    setSubTotal(sum);
}

function sumTotal(){
	var subTotal = getSubTotal();
    var igv = parseFloat(subTotal) * parseFloat(0.18);
	
    var total = (parseFloat(subTotal) + parseFloat(igv)).toFixed(2);
    setTotal(total);
}

function setTrColor(tr, color){
    if ( tr.hasClass('selected') ) {
        tr.removeClass('selected');
        tr.removeClass(color);
        //var data = tr.parents('tr');
        //tableJsonMaterialSeleccionado.row(data).remove().draw(false);
    }
    else {
        tableJsonMaterialSeleccionado.$('tr.selected').removeClass('selected').removeClass(color);
        tr.addClass('selected');
        tr.addClass(color);
    }
}

function onKeyUpCantidad($cantidad, $id){
    //console.log('POLLO cantidad:: ' + $cantidad);
    //console.log('POLLO id:: ' + $id);

}
*/

        
        
        