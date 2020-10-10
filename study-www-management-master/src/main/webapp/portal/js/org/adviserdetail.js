$(function() {
	$("#header").load("../header.html");
	$("#footer").load("../footer.html");
	
	var aid = location.href.split("?")[1].split("=")[1];
	$.myAjax({
		url:'case/getBeansByAdviser?page=1&limit=5&aid='+aid,
		type:"GET",
		dataType:"json",
		success:function(data) {
			if(data.status){
				var html = "";
    			for(var i=0;i<data.beans.length;i++){
    				var bean = data.beans[i];
    				var date = new Date(bean.createDate);
    				html+=`
    				  <div class="case">
		                <h3>`+bean.title+`</h3>
		                <span><i>OFFER</i>`+bean.school+`</span>
		                <p>`+bean.content+`</p>
		                <p>`+date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+`</p>
		              </div>
    				`;
    			}
    			$(".case-list").empty().append(html);
			}
        }
    });
	$.myAjax({
		url:'adviser/getBean?id='+aid,
		type:"GET",
		dataType:"json",
		success:function(data) {
			if(data.status){
				var html = `
					<img src="`+data.bean.coverFile+`" alt="">
					<h3>`+data.bean.name+`</h3>
					<p class="company">`+data.bean.name+`  <span>`+data.bean.title+`</span></p>
					<p>`+data.bean.content+`</p>
					<div class="appraise">查看评价</div>`
				$(".adviser").empty().append(html);
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




