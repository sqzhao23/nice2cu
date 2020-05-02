$(function () {
    var data3Vue ={
        el: '#user-info',
        uri: 'user',
        friend: { id: '', name: '', gender: '', location: '', signature: '', photo: ''},
        file: ''
    };

    var vue = new Vue({
        el: '#user-info',
        data: data3Vue,
        mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
            this.get();
        },
        methods: {
            get:function(){
                var url =  this.uri;
                axios.get(url).then(function(response) {
                    vue.friend = response.data;
                    if (vue.friend.gender == "男") {
                        $("#gender_man").attr("checked", "checked");
                        $("#gender_women").removeAttr("checked");
                    } else {
                        $("#gender_women").attr("checked", "checked");
                        $("#gender_man").removeAttr("checked");
                    }
                });
            },

            update: function () {
                var url = this.uri;

                if (0===this.friend.name.length) {
                    alert("昵称不能为空!");
                    return;
                }

                //axios.js 上传文件要用 formData 这种方式
                var formData = new FormData();
                formData.append("id", this.friend.id);
                formData.append("name", this.friend.name);
                formData.append("gender", this.friend.gender);
                formData.append("location", this.friend.location);
                formData.append("signature", this.friend.signature);
                formData.append("image", this.file);

                axios.put(url,formData).then(function(response){
                    alert("个人信息修改成功！确定返回首页。");
                    location.href="home";
                });
            },
            getFile: function (event) {
                this.file = event.target.files[0];
            },
        }
    });
});
