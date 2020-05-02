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

	// document.getElementById("start-chat-page").style.display = "none";
	// document.getElementById("myNews-page").style.display = "none";
	// document.getElementById("chat-page").style.display = "none";
	// document.getElementById("news-page").style.display = "none";
	// document.getElementById("publish-news-page").style.display = "none";
	// document.getElementById("user-info-page").style.display = "none";
	// document.getElementById("account-setting-page").style.display = "none";
	// document.getElementById("add-friend-page").style.display = "none";
	// document.getElementById("friend-info-page").style.display = "none";
	// document.getElementById("chat-info-page").style.display = "none";
	// document.getElementById("chat-manage-page").style.display = "none";


	// if($("#div_id")){
	// 	$("#div_id").show();
	// }

	// $("#div_id").css("display", "block");
	document.getElementById(div_id).style.display = "block";
}
