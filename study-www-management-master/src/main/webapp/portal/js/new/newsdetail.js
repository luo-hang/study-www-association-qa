$(function() {
	$("#header").load("../header.html");
	$("#footer").load("../footer.html");
	
	var aid = location.href.split("?")[1].split("=")[1];
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
	initDetail = function(){
		$.myAjax({
			url:'article/getBean?id='+aid,
			type:"GET",
			dataType:"json",
			success:function(data){
				if(data.status){
					$("#type").html(data.bean.type);
					var date = new Date(data.bean.createDate);
					var html = `
						 <h3>`+data.bean.title+`</h3>
			             <div>
			                <span>`+date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+`</span>
			                <span>阅读 `+data.bean.showTime+`</span>
			             </div>
						`;
					$(".article-top").append(html);
					html = '<p>'+data.bean.content+'</p>';
					$(".content").append(html);
				}
			},
		});
	}
	initDetail();
	initArticle();
})




