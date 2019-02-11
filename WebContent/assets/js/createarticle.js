/**
 * 
 */

$(function() {
	
	$("#save").click(function(){
		if ($("#subject").val() === "" || $("#content").val() === "") {
			$("#messageFrame")
					.html(
							"<i style='color: red'>Fields (*) cannot be left blank</i>");
		} else {
			$("#formInput").submit();
		}
	});
	
});

