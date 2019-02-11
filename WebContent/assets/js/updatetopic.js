/**
 * 
 */

$(function() {
	$("#update").click(function(){
		if ($("#name").val() === "") {
			$("#messageFrame")
					.html("<i style='color: red'>Fields (*) cannot be left blank</i>");
		} else {
			$("#formInput").submit();
		}
	});
	
});

