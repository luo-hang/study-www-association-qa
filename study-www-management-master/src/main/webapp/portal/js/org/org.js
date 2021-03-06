$(function() {
	$("#header").load("../header.html");
	$("#footer").load("../footer.html");
	
	var orgid = location.href.split("?")[1].split("=")[1];
	$.myAjax({
		url:'organization/getBean?id='+orgid,
		type:"GET",
		dataType:"json",
		success:function(data) {
			if(data.status){
				$("#orgName").html(data.bean.orgName);
				if(data.bean.wl){
					$("#orgName1").html(data.bean.orgName+'<span class="auth">白名单认证</span>');
				}else{
					$("#orgName1").html(data.bean.orgName);
				}
				$("#address").html('<i>地址</i>：'+data.bean.province+data.bean.city+data.bean.county);
				$("#addressDetail").html('<i>详细地址</i>：'+data.bean.address);
				$("#website").html('<i>官网网站</i>：<a href="'+data.bean.website+'"  style="color: #666666;">'+data.bean.website+'</a>');
				$("#consultationPhone").html('咨询电话： '+data.bean.consultationPhone);
				$(".content").html(data.bean.orgIntroduction);
				$(".main-img").attr("src",data.bean.orgLogo);
			}
        }
    });
	$.myAjax({
		url:'adviser/getBeans?page=1&limit=3&orgid='+orgid,
		type:"GET",
		dataType:"json",
		success:function(data) {
			if(data.status){
				var html = "";
				for(var i=0;i<data.data.length;i++){
					html = html + `
					<div class="adviser" onclick="location.href='adviserdetail.html?aid=`+data.data[i].aid+`'">
	                	<img src="`+data.data[i].coverFile+`" alt="">
	                	<h3>`+data.data[i].name+`老师</h3>
	                	<p>`+data.data[i].content+`</p>
					</div>
					`;
				}
				$(".advisers").empty().append(html);
			}
        }
    })
    $.myAjax({
		url:'case/getBeansByOrgid?page=1&limit=5&orgid='+orgid,
		type:"GET",
		dataType:"json",
		success:function(data) {
			if(data.status){
				var html = "";
				for(var i=0;i<data.data.length;i++){
					var bean = data.data[i];
					var date = new Date(bean.createDate);
					html = html + `
					<div class="subject" onclick="location.href='casedetail.html?cid=`+data.data[i].cid+`'">
		                <div class="box">
		                  <div class="sub-left">
		                    <img class="ori-img" src="`+data.data[i].coverFile+`" alt="">
		                    <div>
		                      <h3>`+data.data[i].title+`</h3>
		                      <p><em>OFFER</em>`+data.data[i].school+`</p>
		                      <i><span>`+date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+`</span><span>阅读：`+data.data[i].showTime+`</span></i>
		                    </div>
		                  </div>
		                </div>
	                </div>`;
				}
				$(".subjects").empty().append(html);
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
    
    $('.adviserMore').click(function() {
    	window.location.href='adviserlist.html?orgid='+orgid;
    })
    $('.caseMore').click(function() {
    	window.location.href='caselist.html?orgid='+orgid;
    })
})




