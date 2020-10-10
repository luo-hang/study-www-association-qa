$(function() {
	$("#header").load("../header.html");
	$("#footer").load("../footer.html");
	
	$('.select-item div i').click(function() {
    	$(this).addClass('active').siblings().removeClass('active');
    	var province = $("#provinceBtns .active").html();
    	var country = $("#countryBtns .active").html();
    	var ability = $("#abilityBtns .active").html();
    	var year = $("#yearBtns .active").html();
    	if(province == '不限'){
    		province = null;
    	}
    	if(country == '不限'){
    		country = null;
    	}
    	if(ability == '不限'){
    		ability = null;
    	}
    	if(year == '不限'){
    		year = null;
    	}
    	initData(true,1,5,province,country,ability,year);
    });
    $('.tabs_left').click(function() {
        $(this).addClass('active').siblings().removeClass('active');
        const left_button = $(this).index();
        $('.left_button').eq(left_button).addClass('active1').siblings().removeClass('active1');
      
        var province = $("#provinceBtns .active").html();
    	var country = $("#countryBtns .active").html();
    	var ability = $("#abilityBtns .active").html();
    	var year = $("#yearBtns .active").html();
    	if(province == '不限'){
    		province = null;
    	}
    	if(country == '不限'){
    		country = null;
    	}
    	if(ability == '不限'){
    		ability = null;
    	}
    	if(year == '不限'){
    		year = null;
    	}
    	initData(true,1,5,province,country,ability,year);
    });
    layui.use(['laypage'], function(){
    	var laypage = layui.laypage;
    	
	    initData = function(_first_,page,limit,province,country,ability,year){
	    	var url = 'organization/getBeansByQuery?page='+page+'&limit='+limit;
	    	if(country){
	    		url = url+"&country="+country;
	    	}
	    	if(province){
	    		url = url+"&province="+province;
	    	}
	    	if(ability){
	    		url = url+"&ability="+ability;
	    	}
	    	if(year){
	    		url = url+"&year="+year;
	    	}
	    	$.myAjax({
	    		url:url,
	    		type:"GET",
	    		dataType:"json",
	    		success:function(data) {
	    			if(data.status){
	    				var bean = data.beans;
	    				var organizations = $(".organizations");
	    				var str = "";
	    				for(i = 0; i < bean.length; i++) {
	    	              	var wl = '';
	    	              	if(bean[i].wl){
	    	              		wl = '<span><img src="../../img/authentication2.png" alt=""> 白名单认证</span>';
	    	              	}
	    					str += `
	    						<a class="organization" id="${bean[i].id}" href="../../html/org/org.html?orgid=${bean[i].orgid}">
	    							<div class="box">
	    								<img class="ori-img" src="${bean[i].orgLogo}" alt="">
		    							<div>
			    	                    	<h3>${bean[i].orgName}`+wl+` </h3>
			    	                    	<p><img src="../../img/location.png" alt="">${bean[i].address}</p>
			    	                    	<p><img src="../../img/Telephone.png" alt="">${bean[i].consultationPhone}</p>
			    	                    	`+
			    	                    	((bean[i].caseVo)?'<i><span>案例：</span>'+bean[i].caseVo.title+'</i>':'<i><span>案例：</span>暂无</i>')
			    	                    	+`
			    	                  	</div>
		    	                   </div>
	    						</a>`
	    				}
	    				organizations.empty().append(str);
	    				if(_first_){
	    					laypage.render({
	    						elem: 'page'
	    						,count: data.count
	    						,limit: 5
	    						,theme: '#38549D'
	    						,prev: '<em>←</em>'
	    						,next: '<em>→</em>'
	    						,jump: function(obj, first){
	    							if(!first){
	    								initData(false,obj.curr,5,province,country,ability,year);
	    							}
	    						}
	    					});
	    				}
	    			}
	    		},
	    	})
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
	    			$(".orgs").append(html);
	    		}
	    	},
	    });
	    initData(true,1,5);
    })
})




