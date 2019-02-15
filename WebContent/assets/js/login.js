/**
 * 
 */

$(function() {	
	$("#login").click(function(){
		var userName = $("#userName").val().toString();
		var password = $("#password").val().toString();
		if(userName !== "" && password !== ""){
			$("#formInput").submit();
		}else{
			setMessageError("User and Password cannot be left blank")
		}
	});
});

