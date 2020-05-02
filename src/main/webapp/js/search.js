

var demo = new Vue({
				    el: '#search-form',
				    data: {
				        searchString: "",
				
				        // 数据模型，实际环境你可以根据 Ajax 来获取
				
				        results: [
				            {
				                "name": "陈诗秋",
				                "url": "https://www.runoob.com/css/css-tutorial.html",
				                "image": "img/friend.png"
				            }
				        ]
				    },
				    computed: {
				        // 计算数学，匹配搜索
				        filteredresults: function () {
				            var results_array = this.results,
				                searchString = this.searchString;
				
				            if(!searchString){
				                return results_array;
				            }
				
				            searchString = searchString.trim().toLowerCase();
				
				            results_array = results_array.filter(function(item){
				                if(item.name.toLowerCase().indexOf(searchString) !== -1){
				                    return item;
				                }
				            })
				
				            // 返回过来后的数组
				            return results_array;;
				        }
				    }
				});