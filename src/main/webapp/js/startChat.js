$(function () {

    var data6Vue ={
        el: '#start-page-main',
        friends: [],
        friend: {friend_id: '', alias: '', photo: ''},
        checkedFriends: [],
        chat_name: '',
        time: '',
        file: ''
    };

    var vue = new Vue({
        el: '#start-page-main',
        data: data6Vue,
        mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
            this.list();
        },
        methods: {
            list:function(){

                this.time = new Date().format("yyyy-MM-dd hh:mm");

                var url =  "listFriend";
                axios.get(url).then(function(response) {
                    vue.friends = response.data;
                });
            },

            addChat:function () {

                if (0===this.chat_name.length) {
                    alert("群聊名称不能为空!");
                    return;
                }
                if (this.checkedFriends.length < 2) {
                    alert("请选择至少两名好友加入群聊!");
                    return;
                }

                this.time = new Date().format("yyyy-MM-dd hh:mm");
                //axios.js 上传文件要用 formData 这种方式
                var formData = new FormData();
                formData.append("chat_name", this.chat_name);
                formData.append("time", this.time);
                formData.append("image", this.file);

                for (var i=0; i<this.checkedFriends.length; i++) {
                    formData.append("friends_id[]", this.checkedFriends[i]);
                }

                var url = "addChat";
                axios.post(url,formData).then(function(response){
                    var result = response.data;
                    if(result.code==0){
                        alert("创建群聊成功！")
                        location.href="home";
                    }
                    else{
                        alert(result.message);
                    }
                });
            },

            getFile: function (event) {
                this.file = event.target.files[0];
            },

        },
    });
});



//时间格式设定
Date.prototype.format = function(fmt){
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };

    if(/(y+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }

    for(var k in o){
        if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(
                RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
    return fmt;
}