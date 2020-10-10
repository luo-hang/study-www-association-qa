var dynamicone = document.querySelector(".dynamic_tabtitle ul li:first-child");
var dynamictwo = document.querySelector(".dynamic_tabtitle ul li:nth-child(2)");
var dynamicthree = document.querySelector(".dynamic_tabtitle ul li:last-child");
var dynamic_tabcontents = document.querySelector(".dynamic_tabcontents");
var policy_tabcontent = document.querySelector(".policy_tabcontent");
var industry_tabcontent = document.querySelector(".industry_tabcontent");
dynamicone.style.color = "#39549D";
dynamicone.style.fontSize = "16px";
dynamic_tabcontents.style.display = "block";
dynamicone.onclick = function() {
	dynamicone.style.color = "#39549D";
	dynamictwo.style.color = "#000000";
	dynamicthree.style.color = "#000000";
	dynamicone.style.fontSize = "16px";
	dynamictwo.style.fontSize = "14px";
	dynamicthree.style.fontSize = "14px";
	dynamic_tabcontents.style.display = "block";
	policy_tabcontent.style.display = "none";
	industry_tabcontent.style.display = "none";
}
dynamictwo.onclick = function() {
	dynamicone.style.color = "#000000";
	dynamictwo.style.color = "#39549D";
	dynamicthree.style.color = "#000000";
	dynamicone.style.fontSize = "14px";
	dynamictwo.style.fontSize = "16px";
	dynamicthree.style.fontSize = "14px";
	dynamic_tabcontents.style.display = "none";
	policy_tabcontent.style.display = "block";
	industry_tabcontent.style.display = "none";
}
dynamicthree.onclick = function() {
	dynamicone.style.color = "#000000";
	dynamictwo.style.color = "#000000";
	dynamicthree.style.color = "#39549D";
	dynamicone.style.fontSize = "14px";
	dynamictwo.style.fontSize = "14px";
	dynamicthree.style.fontSize = "16px";
	dynamic_tabcontents.style.display = "none";
	policy_tabcontent.style.display = "none";
	industry_tabcontent.style.display = "block";
}
$(function() {
	$('.abroad_state div').click(function() {
		$(this).addClass('abroadActive').siblings().removeClass('abroadActive');
		const index = $(this).index();
		$('.item_content').eq(index).addClass('stateActive').siblings().removeClass('stateActive');
		initOrg($('.item_content').eq(index).find('.contentActive').children('font').html());
	})
	$('.abroad_service div').click(function() {
		$(this).addClass('contentActive').siblings().removeClass('contentActive');
		const contentActive = $(this).index();
		$('.swiper-container').eq(contentActive).addClass('container').siblings().removeClass('container');
		initOrg($(this).children('font').html());
	})
	
	selectAbility = function(type){
		var num = 0;
		if(type==1||type==2||type==3||type==4||type==5){
			num = 0;
		}else if(type==6||type==7||type==8||type==9||type==10){
			num = 1;
		}else if(type==11||type==12||type==13){
			num = 2;
		}
		$($('.abroad_state div')[num]).addClass('abroadActive').siblings().removeClass('abroadActive');
		$('.item_content').eq(num).addClass('stateActive').siblings().removeClass('stateActive');
		$($('.abroad_service div')[type-1]).addClass('contentActive').siblings().removeClass('contentActive');
		initOrg($($('.abroad_service div')[type-1]).children('font').html());
	}

	gotoOrgDetail = function(orgid){
		window.location.href = './html/org/org.html?orgid='+orgid;
	}
	
	selectCountry = function(type){
		$.myAjax({
			url:'school/getBeans?page=1&limit=4&country='+encodeURIComponent(type),
			type:"GET",
			dataType:"json",
			success:function(data){
				if(data.status){
					var html = "";
					for(var i=0;i<data.bean.length;i++){
						html = html + `<div class="university_notability">
							<a href="javascript:;">
								<div class="universityimg">
									<img src="`+data.bean[i].schoolImg+`">
									<div class="school_badge">
										<img src="`+data.bean[i].schoolLogo+`">
									</div>
								</div>
								<div class="university_intro">
									<div class="university_detail">
										<h2>`+data.bean[i].schoolNameC+`</h2>
										<ul>
											<li>属性:`+data.bean[i].schoolProperty+` </li>
											<li>学费: <span>￥`+data.bean[i].schooling+`</span></li>
											<li>招生人数: `+data.bean[i].studentsEnrollment+`</li>
											<li>精品专业: `+data.bean[i].professionNum+`</li>
										</ul>
									</div>
								</div>
							</a>
						</div>`;
					}
					$(".university").empty().append(html);
				}
			},
		});
	}
	initArticle = function(){
		$.myAjax({
			url:'article/getBeans?page=1&limit=6&type='+encodeURIComponent("最新动态;政策法规;行业报告;留学预警"),
			type:"GET",
			dataType:"json",
			success:function(data){
				if(data.status){
					var html = "<ul>";
					for(var i=0;i<data.bean["最新动态"].length;i++){
						var bean = data.bean["最新动态"][i];
						var date = new Date(bean.createDate);
						html += `
						<a href="./html/news/newsdetail.html?aid=`+bean.aid+`">
							<li>
								<div class="tabcontent_left">
									<p>`+date.getFullYear()+`</p>
									<font>`+(date.getMonth()+1)+'-'+date.getDate()+`</font>
								</div>
								<div class="tabcontent_right">
									<h3>`+bean.title+`</h3>
									<p>`+bean.content+`</p>
								</div>
							</li>
						</a>`;
					}
					html += "</ul>";
					$(".dynamic_tabcontents").empty().append(html);
					html = "<ul>";
					for(var i=0;i<data.bean["政策法规"].length;i++){
						var bean = data.bean["政策法规"][i];
						var date = new Date(bean.createDate);
						html += `
						<a href="./html/news/newsdetail.html?aid=`+bean.aid+`">
							<li>
								<div class="tabcontent_left">
									<p>`+date.getFullYear()+`</p>
									<font>`+(date.getMonth()+1)+'-'+date.getDate()+`</font>
								</div>
								<div class="tabcontent_right">
									<h3>`+bean.title+`</h3>
									<p>`+bean.content+`</p>
								</div>
							</li>
						</a>`;
					}
					html += "</ul>";
					$(".policy_tabcontent").empty().append(html);
					html = "<ul>";
					for(var i=0;i<data.bean["行业报告"].length;i++){
						var bean = data.bean["行业报告"][i];
						var date = new Date(bean.createDate);
						html += `
						<a href="./html/news/newsdetail.html?aid=`+bean.aid+`">
							<li>
								<div class="tabcontent_left">
									<p>`+date.getFullYear()+`</p>
									<font>`+(date.getMonth()+1)+'-'+date.getDate()+`</font>
								</div>
								<div class="tabcontent_right">
									<h3>`+bean.title+`</h3>
									<p>`+bean.content+`</p>
								</div>
							</li>
						</a>`;
					}
					html += "</ul>";
					$(".industry_tabcontent").empty().append(html);
					html = "<ul>";
					for(var i=0;i<data.bean["留学预警"].length;i++){
						var bean = data.bean["留学预警"][i];
						var date = new Date(bean.createDate);
						html += `
						<a href="./html/news/newsdetail.html?aid=`+bean.aid+`">
							<li style="display: flex;margin-bottom: 10px;">
								<div class="tabcontent_left" style="width: 80%;display: flex;margin-bottom: 10px;flex-wrap: wrap;justify-content: center;">
									<p style="width: 400px;overflow: hidden; white-space: nowrap;text-overflow: ellipsis;">·  `+bean.title+`</p>
								</div>
								<div class="tabcontent_right" style="width: 20%;display: flex;margin-bottom: 10px;flex-wrap: wrap;justify-content: center;">
									<p>`+date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+`</p>
								</div>
							</li>
						</a>`;
					}
					html += "</ul>";
					$(".tool").empty().append(html);
				}
			},
		});
	}
	initOrg = function(ability){
		$.myAjax({
			url:'organization/getBeansByAbility?page=1&limit=4&ability='+encodeURIComponent(ability),
			type:"GET",
			dataType:"json",
			success:function(data){
				if(data.status){
					var html = "";
					for(var i=0;i<data.beans.length;i++){
						var bean = data.beans[i];
						html += `
							<div class="swiper-slide" style="width:25%;">
								<div class="institution_intro" onclick="gotoOrgDetail(`+bean.orgid+`)">
								 `+(bean.wl?'<div class="assessment_certification"><a href="javascript:;"><img src="img/assessment_certification.png"></a></div>':'')+`
									<div class="institution_logo">
										<img src="`+bean.orgLogo+`">
									</div>
									<div class="institution_detail">
										<h3>`+bean.orgName+`</h3>
										<p>服务人数：1000+</p>
										<p>点评：1000+</p>
										<p>综合评分：
											<span>
												<font>100</font>分
											</span>
										</p>
										<p><img src="img/star.png"><img src="img/star.png"><img src="img/star.png"><img src="img/star.png"><img src="img/star.png"></p>
									</div>
								</div>
							</div>
						`;
					}
					$(".institution .swiper-wrapper").empty().append(html);
				}
			},
		});
	}
	initOrg("留学咨询及办理");
	selectCountry("全部");
	initArticle();
})
