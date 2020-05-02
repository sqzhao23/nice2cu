$(function () {
    var data7Vue ={
        el: '#myNews-page',
        newses: [],
        news: { id:'',ownerId:'',name:'',userPhoto:'',contentText:'',photo:'',time:'',love:'',hate:'',view:''}
    };

    var vue = new Vue({
        el: '#myNews-page',
        data: data7Vue,
        mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
            this.get();
        },
        methods: {
            get:function(){
                var url =  "getMyNews";
                axios.get(url).then(function(response) {
                    vue.newses = response.data;
                    if (0===vue.newses.length) {
                        $("#news-p").css("display", "block");
                    } else {
                        $("#news-p").css("display", "none");
                    }

                });
            },

            deleteNews:function () {
                var url = "deleteNews";
                var newsId = event.target.id;

                var r=confirm("删除这条动态？");
                if (r==true)
                {
                    document.getElementById(newsId + 'p').remove();
                    axios.delete(url, {
                        params: {
                            id: newsId
                        }
                    })
                }
            else
                {
                    return;
                }

            }
        }
    });
});


$(function () {
    var data9Vue ={
        el: '#news-page',
        newses: [],
        news: { id:'',ownerId:'',name:'',userPhoto:'',contentText:'',photo:'',time:'',love:'',hate:'',view:''}
    };

    var vue = new Vue({
        el: '#news-page',
        data: data9Vue,
        mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
            this.getAllNews();
        },
        methods: {
            getAllNews:function(){
                var url =  "getAllNews";
                axios.get(url).then(function(response) {
                    vue.newses = response.data;
                });
            },
        }
    });
});


$(function () {
    var data8Vue ={
        el: '#publish-right',
        news: { id:'', ownerId:'',name:'',userPhoto:'',contentText:'',photo:'',time:'',love:'',hate:'',view:''},
        file: ''
    };

    var vue = new Vue({
        el: '#publish-right',
        data: data8Vue,
        mounted:function(){ //mounted　表示这个 Vue 对象加载成功了
            this.list();
        },
        methods: {
            list:function(){
                this.news.time = new Date().format("yyyy-MM-dd hh:mm");
            },

            addNews: function() {
                var url = "addNews";
                this.news.time = new Date().format("yyyy-MM-dd hh:mm");

                //axios.js 上传文件要用 formData 这种方式
                var formData = new FormData();
                formData.append("contentText", this.news.contentText);
                formData.append("time", this.news.time);
                formData.append("image", this.file);

                axios.post(url,formData).then(function(response){
                    alert("动态发布成功！确定返回首页。");
                    location.href="home";
                });
            },

            getFile: function (event) {
                this.file = event.target.files[0];
            },
        }
    });
});

