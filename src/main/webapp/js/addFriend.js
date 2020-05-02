$(function () {

    var data5Vue ={
        el: '#addFriend',
        friend: {id: '', name: '', gender: '', location: '', signature: '', photo: ''},
        picked: '',
        searchInfo: ''
    };

    var vue = new Vue({
        el: '#addFriend',
        data: data5Vue,
        methods: {
            searchFriend: function () {
                var url = "searchFriend";

                $("#add-friend-p").css("visibility","hidden");

                if (0==this.searchInfo.length){
                    $("#add-result-success").html("请输入有效的数据")
                    $("#add-result-success").css("visibility","visible");
                    $("#add-result-success").css("color","red");
                    return;
                }

                let params = new URLSearchParams();
                params.append("type", this.picked);
                params.append("info", this.searchInfo);
                axios.post(url,params).then(function(response) {
                    var result = response.data;

                    vue.friend = result.data;
                    if(result.code==0){
                        $("#add-result-success").html("搜索到的用户:")
                        $("#add-result-success").css("visibility","visible");
                        $("#add-result-success").css("color","#333333");
                        $("#add-result-info").css("visibility","visible");
                    } else {
                        $("#add-result-success").html(result.message)
                        $("#add-result-success").css("visibility","visible");
                        $("#add-result-success").css("color","red");
                        $("#add-result-info").css("visibility","hidden");
                    }
                });
            },

            addAction: function () {
                var url = "addFriend";

                $("#add-friend-p").css("visibility","visible");
                let params = new URLSearchParams();
                params.append("friend_id", vue.bean.id);
                params.append("friend_name", vue.bean.name);
                axios.post(url,params).then(function(response){

                });
            }
        }
    });
});
