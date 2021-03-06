$(function() {
	$("#header").load("../header.html");
	$("#footer").load("../footer.html");
	
	var orgid = location.href.split("?")[1].split("=")[1];
	$.myAjax({
		url:'adviser/getBeans?page=1&limit=100&orgid='+orgid,
		type:"GET",
		dataType:"json",
		success:function(data) {
			if(data.status){
				var html = "";
				for(var i=0;i<data.data.length;i++){
					html = html + `<div class="adviser" onclick="location.href='adviserdetail.html?aid=`+data.data[i].aid+`'">
	                <div class="top">
	                  <img src="`+data.data[i].coverFile+`" alt="">
	                  <div>
	                    <h3>`+data.data[i].name+`老师</h3>
	                    <p>`+data.data[i].orgName+`</p>
	                    <p>`+data.data[i].title+`</p>
	                  </div>
	                </div>
	                <p class="note">`+data.data[i].content+`</p>
	              </div>`;
				}
				$(".advisers").empty().append(html);
			}
        }
    })
	$.myAjax({
		url:'organization/getBean?id='+orgid,
		type:"GET",
		dataType:"json",
		success:function(data) {
			if(data.status){
				$(".city").append(data.bean.province+data.bean.city);
				$("#address").append(data.bean.address);
				$("#website").attr("href",data.bean.website);
				$("#website").append(data.bean.website);
				$("#consultationPhone").append(data.bean.consultationPhone);
			}
        }
    })
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
    
})




