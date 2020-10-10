$(function() {
	$("#header").load("../header.html");
	$("#footer").load("../footer.html");
	
	var pid = location.href.split("?")[1].split("=")[1];
	$.myAjax({
		url:'school/getBean?id='+pid,
		type:"GET",
		dataType:"json",
		success:function(data) {
			if(data.status){
				$("#schoolName").html(data.bean.schoolNameC);
				$("#about").html(data.bean.schoolAbout);
				$("#address").html('国家地区：'+data.bean.schoolCountry+"	"+data.bean.province+","+data.bean.city);
				$("#property").html('院校性质：'+data.bean.schoolProperty);
				$("#schooling").html('留学费用：'+data.bean.schooLing);
				var main = $('.school');
				var str1 = "";
				str1 = `<div class="main-top" style="background-image:${data.bean.schoolImg}">
							<img src="${data.bean.schoolLogo}" alt="">
							<div>
								<p>${data.bean.schoolNameC}</p>
								<p>${data.bean.schoolNameE}</p>
							</div>
						</div>`;
				main.append(str1);
				
				var subjects = $('.subjects');
				var html = "";
				for(var i=0;i<data.bean.professions.length;i++){
					var p = data.bean.professions[i];
					html += `
					 <div class="subject">
		                <div class="box">
		                  <div class="sub-left">
		                    <img class="ori-img" src="../../img/11.png" alt="">
		                    <div>
		                      <h3>${p.name}</h3>
		                      <p><img src="../../img/subject.png" alt="">${p.college}</p>
		                      <p><em>${p.degree}</em></p>
		                      <p>学期：${p.semester}月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 学费：$ ${p.fee}</span></p>
		                    </div>
		                  </div>
		                  `
		                  if(p.advantage){
		                	  html += ` <div class="sub-right">
			                    <img src="../../img/yszy.png" alt="">
			                  </div>`;
		                  }
					html += `
		                </div>
		              </div>
					`;
				}
				subjects.append(html);
			}
        }
    })
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
    			$(".orgs").append(html);
    		}
    	},
    });
})




