function select_single(file) {
	if (!file.files || !file.files[0]) {
		return;
	}

	var fileSize = 0;
	var fileMaxSize = 10*1024;//10M
	var filePath = file.value;
	if(filePath){
		fileSize =file.files[0].size;
		var size = fileSize / 1024;
		if (size > fileMaxSize) {
			alert("文件大小不能大于10M！");
			file.value = "";
			return false;
		}else if (size <= 0) {
			alert("上传失败，请重新选择图片！");
			file.value = "";
			return false;
		}
	}else{
		return false;
	}

	//定以一个读取文件的对象
	var reader = new FileReader();

	reader.onload = function (evt) {
		//获取的是图片的base64代码
		var replaceSrc = evt.target.result;
		// 再将获取值赋给img标签
		$('#publish-photo').attr("src", replaceSrc);
	};
	reader.readAsDataURL(file.files[0]);
}


function select_user_img(file) {
	if (!file.files || !file.files[0]) {
		return;
	}

	var fileSize = 0;
	var fileMaxSize = 10*1024;//10M
	var filePath = file.value;
	if(filePath){
		fileSize =file.files[0].size;
		var size = fileSize / 1024;
		if (size > fileMaxSize) {
			alert("文件大小不能大于10M！");
			file.value = "";
			return false;
		}else if (size <= 0) {
			alert("上传失败，请重新选择图片！");
			file.value = "";
			return false;
		}
	}else{
		return false;
	}

	//定以一个读取文件的对象
	var reader = new FileReader();

	reader.onload = function (evt) {
		//获取的是图片的base64代码
		var replaceSrc = evt.target.result;
		// 再将获取值赋给img标签
		$('#user-img').attr("src", replaceSrc);
	};
	reader.readAsDataURL(file.files[0]);
}


function select_chat_photo(file) {
	if (!file.files || !file.files[0]) {
		return;
	}

	var fileSize = 0;
	var fileMaxSize = 10*1024;//10M
	var filePath = file.value;
	if(filePath){
		fileSize =file.files[0].size;
		var size = fileSize / 1024;
		if (size > fileMaxSize) {
			alert("文件大小不能大于10M！");
			file.value = "";
			return false;
		}else if (size <= 0) {
			alert("上传失败，请重新选择图片！");
			file.value = "";
			return false;
		}
	}else{
		return false;
	}

	//定以一个读取文件的对象
	var reader = new FileReader();

	reader.onload = function (evt) {
		//获取的是图片的base64代码
		var replaceSrc = evt.target.result;
		// 再将获取值赋给img标签
		$('#chat-info-photo').attr("src", replaceSrc);
	};
	reader.readAsDataURL(file.files[0]);
}


function start_chat_photo(file) {
	if (!file.files || !file.files[0]) {
		return;
	}

	var fileSize = 0;
	var fileMaxSize = 10*1024;//10M
	var filePath = file.value;
	if(filePath){
		fileSize =file.files[0].size;
		var size = fileSize / 1024;
		if (size > fileMaxSize) {
			alert("文件大小不能大于10M！");
			file.value = "";
			return false;
		}else if (size <= 0) {
			alert("上传失败，请重新选择图片！");
			file.value = "";
			return false;
		}
	}else{
		return false;
	}

	//定以一个读取文件的对象
	var reader = new FileReader();

	reader.onload = function (evt) {
		//获取的是图片的base64代码
		var replaceSrc = evt.target.result;
		// 再将获取值赋给img标签
		$('#start-chat-photo').attr("src", replaceSrc);
	};
	reader.readAsDataURL(file.files[0]);
}