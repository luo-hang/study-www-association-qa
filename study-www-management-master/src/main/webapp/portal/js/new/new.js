$(function() {
	$("#header").load("../header.html");
	$("#footer").load("../footer.html");
	
	initArticle = function(){
		$.myAjax({
			url:'article/getBeans?page=1&limit=5&type='+encodeURIComponent("最新动态;政策法规;行业报告;留学预警;热门新闻;头条新闻"),
			type:"GET",
			dataType:"json",
			success:function(data){
				if(data.status){
					var html = "";
					for(var i=0;i<data.bean["头条新闻"].length;i++){
						var bean = data.bean["头条新闻"][i];
						var date = new Date(bean.createDate);
						html += `
							<a href="../news/newsdetail.html?aid=`+bean.aid+`">
				              <div class="`+(i==0?'main-item':'item')+`">
				                <div class="dot"></div>
				                <div class="box">
				                  <p>`+bean.title+`</p>
				                  <span>`+date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+`</span>
				                </div>
				              </div>
				            </a>
						`;
					}
					$(".topNew").empty().append(html);
					html = "";
					for(var i=0;i<data.bean["热门新闻"].length;i++){
						var bean = data.bean["热门新闻"][i];
						var date = new Date(bean.createDate);
						html += `
							<a href="../news/newsdetail.html?aid=`+bean.aid+`">
								<div class="`+(i==0?'main-item':'item')+`">
									<div class="dot"></div>
									<div class="box">
										<p>`+bean.title+`</p>
										<span>`+date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+`</span>
									</div>
								</div>
							</a>
							`;
					}
					$(".hotNew").empty().append(html);
					html = "";
					for(var i=0;i<data.bean["最新动态"].length;i++){
						var bean = data.bean["最新动态"][i];
						var date = new Date(bean.createDate);
						html += `
						<a href="../news/newsdetail.html?aid=`+bean.aid+`">
							<p>· `+bean.title+`</p>
						</a>
						`;
					}
					$(".dynamic_tabcontents").empty().append(html);
					html = "";
					for(var i=0;i<data.bean["政策法规"].length;i++){
						var bean = data.bean["政策法规"][i];
						var date = new Date(bean.createDate);
						html += `
						<a href="../news/newsdetail.html?aid=`+bean.aid+`">
							<p>· `+bean.title+`</p>
						</a>
						`;
					}
					$(".policy_tabcontent").empty().append(html);
					html = "";
					for(var i=0;i<data.bean["行业报告"].length;i++){
						var bean = data.bean["行业报告"][i];
						var date = new Date(bean.createDate);
						html += `
						<a href="../news/newsdetail.html?aid=`+bean.aid+`">
							<p>· `+bean.title+`</p>
						</a>
						`;
					}
					$(".industry_tabcontent").empty().append(html);
					html = "";
					for(var i=0;i<data.bean["留学预警"].length;i++){
						var bean = data.bean["留学预警"][i];
						var date = new Date(bean.createDate);
						html += `
						<a href="../news/newsdetail.html?aid=`+bean.aid+`">
							<p>· `+bean.title+`</p>
						</a>
						`;
					}
					$(".study").empty().append(html);
				}
			},
		});
	}
	initArticleList = function(){
		$.myAjax({
			url:'article/getBeans?page=1&limit=7',
			type:"GET",
			dataType:"json",
			success:function(data){
				if(data.status){
					var html = "";
					for(var i=0;i<data.bean.length;i++){
						var bean = data.bean[i];
						var date = new Date(bean.createDate);
						var bg="bg1";
						if(bean.type == '热门新闻'){
							bg = "bg1";
						}else if(bean.type == '留学预警'){
							bg = "bg2";
						}else if(bean.type == '协会新闻'){
							bg = "bg3";
						}else if(bean.type == '最新动态'){
							bg = "bg4";
						}
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
	$.myAjax({
    	url:'case/getBeansByHot?page=1&limit=5',
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
    			$(".case").append(html);
    		}
    	},
    });
    $.myAjax({
    	url:'organization/getBeansByHot?page=1&limit=5',
    	type:"GET",
    	dataType:"json",
    	success:function(data){
    		if(data.status){
    			var html = "";
    			for(var i=0;i<data.data.length;i++){
    				var bean = data.data[i];
    				html += `
    				<a href="org.html?orgid=`+bean.orgid+`">
    				<div class="item">
    					<img src="`+bean.orgLogo+`" alt="">
    					<div class="right">
    						<p>`+bean.orgName+`</p>
    						<span>`+bean.orgIntroduction+`</span>
    					</div>
    				</div></a>`;
    			}
    			$(".organizations").append(html);
    		}
    	},
    });
	initArticle();
	initArticleList();
})




