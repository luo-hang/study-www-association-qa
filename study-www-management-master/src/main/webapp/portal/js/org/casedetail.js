$(function() {
	$("#header").load("../header.html");
	$("#footer").load("../footer.html");
	
	var id = location.href.split("?")[1].split("=")[1];
	$.myAjax({
		url:'case/getBean?id='+id,
		type:"GET",
		dataType:"json",
		success:function(data) {
			if(data.status){
				var date = new Date(data.bean.createDate);
				$("#title").html(data.bean.title);
				$("#createDate").html(date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate());
				$("#showTime").html('阅读 '+data.bean.showTime);
				$("#studentName").html(data.bean.studentName);
				$("#school").html(data.bean.school);
				$("#major").html('录取专业：'+data.bean.major);
				$("#grade").html('分数成绩：<span>'+data.bean.grade+'</span> ');
				$(".content").html(data.bean.content);
				
				$.myAjax({
					url:'organization/getBean?id='+data.bean.orgid,
					type:"GET",
					dataType:"json",
					success:function(data) {
						if(data.status){
							var html = `
								<img src="`+data.bean.orgLogo+`" alt="">
								<p>`+data.bean.orgName+`</p>`;
							if(data.bean.wl){
								html = html+'<span class="auth">白名单认证</span>'
							}
							$(".org-logo").empty().append(html);
						}
			        }
			    });
			    $.myAjax({
			    	url:'case/getBeansByOrgid?page=1&limit=5&orgid='+data.bean.orgid,
			    	type:"GET",
			    	dataType:"json",
			    	success:function(data){
			    		if(data.status){
			    			var html = "";
			    			for(var i=0;i<data.data.length;i++){
			    				var bean = data.data[i];
			    				html += `
			    					<a href="casedetail.html?cid=`+bean.cid+`">
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
        }
    });
	
   
    
})




