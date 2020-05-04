function showDiv(div_id) {

	if($("#start-chat-page")){
		$("#start-chat-page").hide();
	}
	if($("#myNews-page")){
		$("#myNews-page").hide();
	}
	if($("#chat-page")){
		$("#chat-page").hide();
	}
	if($("#news-page")){
		$("#news-page").hide();
	}
	if($("#publish-news-page")){
		$("#publish-news-page").hide();
	}
	if($("#user-info-page")){
		$("#user-info-page").hide();
	}
	if($("#account-setting-page")){
		$("#account-setting-page").hide();
	}
	if($("#add-friend-page")){
		$("#add-friend-page").hide();
	}
	if($("#friend-info-page")){
		$("#friend-info-page").hide();
	}
	if($("#chat-info-page")){
		$("#chat-info-page").hide();
	}
	if($("#chat-manage-page")){
		$("#chat-manage-page").hide();
	}
	if($("#notice-page")){
		$("#notice-page").hide();
	}


	var id = event.target.id;
	var menuNmae = document.getElementById(id).innerText;
	if ('chat-page' === div_id) {
		document.getElementById("chat-page-p").innerText = menuNmae;
		document.getElementById("message-enter").value = id;
	}

	document.getElementById(div_id).style.display = "block";
}
