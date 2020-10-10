$(function() {
	$("#header").load("../header.html");
	$("#footer").load("../footer.html");
	
    $('.select-item div i').click(function() {
    	$(this).addClass('active').siblings().removeClass('active');
    	var country = $("#countryBtns .active").html();
    	var property = $("#propertyBtns .active").html();
    	var degree = $("#degreeBtns .active").html();
    	if(country == '不限'){
    		country = null;
    	}
    	if(property == '不限'){
    		property = null;
    	}
    	if(degree == '不限'){
    		degree = null;
    	}
    	initData(true,1,5,country,property,degree);
    });
    $('.tabs_left').click(function() {
        $(this).addClass('active').siblings().removeClass('active');
        const left_button = $(this).index();
        $('.left_button').eq(left_button).addClass('active1').siblings().removeClass('active1');
      
        var country = $("#countryBtns .active").html();
    	var property = $("#propertyBtns .active").html();
    	var degree = $("#degreeBtns .active").html();
    	if(country == '不限'){
    		country = null;
    	}
    	if(property == '不限'){
    		property = null;
    	}
    	if(degree == '不限'){
    		degree = null;
    	}
        initData(true,1,5,country,property,degree);
    });
    layui.use(['laypage'], function(){
    	var laypage = layui.laypage;
    	
	    initData = function(_first_,page,limit,country,property,degree){
	    	var url = 'school/getBeans?page='+page+'&limit='+limit;
	    	if(country){
	    		url = url+"&country="+country;
	    	}
	    	if(property){
	    		url = url+"&schoolProperty="+property;
	    	}
	    	if(degree){
	    		url = url+"&degree="+degree;
	    	}
	    	$.myAjax({
	    		url:url,
	    		type:"GET",
	    		dataType:"json",
	    		success:function(data) {
	    			if(data.status){
	    				var school = data.bean;
	    				var organizations = $(".organizations");
	    				var str = "";
	    				for(i = 0; i < school.length; i++) {
	    					str += `
	    						<a class="organization" id="${school[i].id}" href="../../html/school/schoolDetail.html?pid=${school[i].id}">
	    						<div class="box">
	    						<img class="ori-img" src="${school[i].schoolLogo}" alt="">
	    						<div>
	    						<h3>${school[i].schoolNameC}	${school[i].schoolNameE}</h3>
	    						<p><img src="../../img/location.png" alt="">${school[i].schoolCountry}	${school[i].province}</p>
	    						<p><em>${school[i].schoolProperty}</em>学费 ￥${school[i].schooLing} /年</p>
	    						<i><span>优势专业：</span>${school[i].profession}</i>
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
	    								initData(false,obj.curr,5,country,property,degree);
	    							}
	    						}
	    					});
	    				}
	    			}
	    		},
	    	})
	    }
	    initData(true,1,5);
    })
   
})




