/**
 * 
 */


function setMessageError(content){
	$("#messageFrame")
	.html("<i style='color: red'>"+content+"</i>");
	
}


function isValidDataInputTopic(){
	if ($("#name").val() === "" ) {
		setMessageError("Fields (*) cannot be left blank");
		return false;
	}else if($("#name").val().length > 50){
		setMessageError("The topic name maximum is 50 charactor");
		return false;
	}else if($("#description").val().length > 200){
		setMessageError("The topic name maximum is 200 charactor");
		return false;
	}
	return true;
}

function isValidDataInputArticle(){
	if ($("#subject").val() === "" || $("#content").val() === "" ) {
		setMessageError("Fields (*) cannot be left blank");
		return false;
	}else if($("#subject").val().length > 200){
		setMessageError("The subject maximum is 200 charactor");
		return false;
	}
	return true;
}




