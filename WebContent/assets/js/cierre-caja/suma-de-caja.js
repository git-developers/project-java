$(function () {

	var existe_producto = false;
	

    $('.total').on('keyup', function () {
    	
    	var totalEfectivo = getValue($('#form_total_efectivo').val());
    	var montoCredito = getValue($('#form_monto_credito').val());
    	var salidaCaja = getValue($('#form_salida_caja').val());
    	var montoTotal = totalEfectivo + montoCredito + salidaCaja;
    	
    	setMontoTotal(montoTotal);
    	saldoFaltante(montoTotal);

    });

    function getValue(value){
    	
    	if(value != "" && !isNaN(value)){
    		return parseInt(value);
    	}
    	
    	return 0;
    }
    
    function getMontoTotal(){
    	return parseInt($('#form_monto_total').val() == "" ? 0 : $('#form_monto_total').val());
    }

    function setMontoTotal(value){
        $('#form_monto_total').val(value);
    }
    
	function saldoFaltante(montoTotal){
    	
    	var montoEsperado = getValue($('#form_monto_esperado').val());
    	var saldo = montoEsperado - montoTotal;
    	
    	$('#saldo-faltante .number').html(saldo);
    	
    	if(saldo > 0){
    		$('#saldo-faltante').removeClass('bg-green').addClass('bg-red');
    	}else{
    		$('#saldo-faltante').removeClass('bg-red').addClass('bg-green');
    	}

    }
    
    
    
    
});

        
        
        