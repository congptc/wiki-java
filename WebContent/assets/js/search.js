/**
 * 
 */

$(function() {
	
	$("#search_field").focus(function(){
		if ($("#search_field").val() === "Enter keywords....."){
			$("#search_field").val("");
		}	
	});
	
	$("#search_field").blur(function(){
		if ($("#search_field").val() === ""){
			$("#search_field").val("Enter keywords.....") ;
		}	
	});
	
	$("#search").click(function(){
		var valueSearch = $("#search_field").val().toString();
		var formSubmit = $("#search_form");
		var contextPath ="";
		if(valueSearch !== "" && valueSearch !== "Enter keywords....."){
			formSubmit.submit();
		}
	});
});

