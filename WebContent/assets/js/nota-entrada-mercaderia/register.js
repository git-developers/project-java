//$(document).ready(function() {
$(function () {

	
	//$('form[name=form_consultar_mercaderia]').submit(function(event){
	$(document).on("click",".buscar",function() {
		//event.preventDefault();
		
		displayMessage(getRandom(2,15));

    });
    
	
	function displayMessage(data){
		//$('#loading').hide();
		$('#submit-message .number').html('Creado con exito, con c&oacute;digo:: #000' + data);
		$('#submit-message').fadeIn('slow');
		
	    setTimeout(function() {data
	        $('#submit-message').fadeOut('slow');
	    }, 5000);
	}
	
	function getRandom(min, max){
		var random = Math.floor(Math.random() * (max - min + 1)) + min; 
		return random;
	}
	
	

});

        
        
        