$(function() {
	$("#header").load("../header.html");
	$("#footer").load("../footer.html");
	
	initArticle = function(){
		$.myAjax({
			url:'article/getBeans?page=1&limit=5&type='+encodeURIComponent("热门新闻"),
			type:"GET",
			dataType:"json",
			success:function(data){
				if(data.status){
					var html = "";
					for(var i=0;i<data.bean["热门新闻"].length;i++){
						var bean = data.bean["热门新闻"][i];
						var date = new Date(bean.createDate);
						html += `
							<a href="../news/newsdetail.html?aid=`+bean.aid+`">
								<div class="hot-case">
					                <p>`+bean.title+`</p>
					                <div class="lines">
					                  <div class="line"></div>
					                  <span>阅读：`+bean.showTime+`</span>
					                </div>
					        	</div>
							</a>
							`;
					}
					$(".rect").append(html);
				}
			},
		});
	}
	initArticleList = function(){
		$.myAjax({
			url:'article/getBeans?page=1&limit=7&type='+encodeURIComponent("政策法规"),
			type:"GET",
			dataType:"json",
			success:function(data){
				if(data.status){
					var html = "";
					for(var i=0;i<data.bean['政策法规'].length;i++){
						var bean = data.bean['政策法规'][i];
						var date = new Date(bean.createDate);
						var bg="bg1";
						html += `
							<a href="../news/newsdetail.html?aid=`+bean.aid+`">
								<div class="article">
								 	<img src="`+bean.coverFile+`" alt="">
								 	<div class="arc-right">
								 		<p>`+bean.title+`</p>
								 		<div class="tags">
						                  <div class="tag `+bg+`">`+bean.type+`</div>
						                  <span>`+date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+`</span>
						                  <span>阅读: `+bean.showTime+`</span>
						                </div>
						                <span class="content">`+bean.content+`</span>
									</div>
								</div>
							</a>
						`;
					}
					$(".articles").empty().append(html);
				}
			},
		});
	}
	initArticleList();
	initArticle();
})




