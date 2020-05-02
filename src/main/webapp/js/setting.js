
let re2 = /^[0-9a-zA-Z_]{6,16}$/;
$(function () {
    var data4Vue ={
        el: '#password-change',
        uri: 'password',
        password: '',
        repassword: ''
    };

    var vue = new Vue({
        el: '#password-change',
        data: data4Vue,
        methods: {
            changePassword: function () {
                var url = this.uri;
                if (0==this.password.length){
                    $("#password-change-p").html("请输入修改后的密码")
                    $("#password-change-p").css("visibility","visible");
                    return;
                }
                if(!re2.test(this.password)){
                    $("#password-change-p").html("密码格式错误 (6-16位,数字字母下划线)");
                    $("#password-change-p").css("visibility","visible");
                    return;
                }
                if (0==this.repassword.length){
                    $("#password-change-p").html("请输入修改后的重复密码")
                    $("#password-change-p").css("visibility","visible");
                    return;
                }
                if (this.password !== this.repassword){
                    $("#password-change-p").html("两次输入不一致")
                    $("#password-change-p").css("visibility","visible");
                    return;
                }

                let params = new URLSearchParams();
                params.append("password", this.password);
                axios.put(url,params).then(function(response){
                    alert("修改密码成功,请重新登录。");
                    location.href="logout";
                });
            },
        }
    });
});
