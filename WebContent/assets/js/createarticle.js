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

function validateInput(formSubmit) {
	if ($("#subject").val() === "" || $("#content").val() === "") {
		$("#messageFrame")
				.html(
						"<i style='color: red'>[Subject] and [Content] not be blank</i>");
	} else {
		$("#" + formSubmit).submit();
	}

}