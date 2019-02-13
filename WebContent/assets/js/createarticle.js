/**
 * 
 */

$(function() {
	
	$("#save").click(function(){
		if (isValidDataInputArticle())
			$("#formInput").submit();
	});
	
});

