
	<%@include file="template/footer.jsp" %>
	
	<script type="text/javascript">
		var colors = ['#3F51B5', '#F44336', '#FFEB3B', '#FF9800', '#CDDC39', '#00BCD4', '#FF5722'];
		var active = 0;
		setInterval(function(){
		    document.querySelector('body').style.background = colors[active];
		    active++;
		    if (active == colors.length) active = 0;
		}, 2000);
	</script>
	
	<style>
		.body{
	    -webkit-box-shadow: 7px 7px 18px 0px rgba(50, 50, 50, 0.75);
	    -moz-box-shadow:    7px 7px 18px 0px rgba(50, 50, 50, 0.75);
	    box-shadow:         7px 7px 18px 0px rgba(50, 50, 50, 0.75);
	}
	</style>
	
</body>

</html>
        	