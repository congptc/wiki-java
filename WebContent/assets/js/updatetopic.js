/**
 * 
 */

$(function() {
	$("#update").click(function(){
		if (isValidDataInputTopic())
			$("#formInput").submit();
	});
	
});
