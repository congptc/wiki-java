/**
 * 
 */

$(function() {
	$("#save").click(function(){
		if (isValidDataInputTopic())
			$("#formInput").submit();
	});
	
});

