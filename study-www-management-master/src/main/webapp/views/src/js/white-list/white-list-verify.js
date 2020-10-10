layui.use(['table', 'form', 'admin', 'util', 'laydate'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,view = layui.view
    ,table = layui.table
    ,util = layui.util
    ,laydate = layui.laydate
    ,form = layui.form;
    var router = layui.router();
    
    shiant.translate();
    
    var whiteList = {};
    
    initData = function () {
		$.ajax({
			url:layui.setter.url+'/service/whiteList/getBeanByOrgid?orgid='+router.search.orgid,
			type:"GET",
			dataType:"json",
			success:function(data){
				if(!data.status){
					layer.msg(shiant.l(data.msg));
				}
				whiteList = data.bean;
				showBtn("commitment",data.bean.commitmentStatus);
				showBtn("apply",data.bean.applyStatus);
				showBtn("information",data.bean.informationStatus);
				showBtn("copy",data.bean.copyStatus);
				showBtn("convention",data.bean.conventionStatus);
				showBtn("verification",data.bean.verificationStatus);

				if(data.bean.wlNo==null||data.bean.wlNo == ""){
					$("#wlNo").html(" : /");
				}else{
					$("#wlNo").html(" : "+data.bean.wlNo);
				}
				if(data.bean.validDate==null||data.bean.validDate == ""){
					$("#validDate").html(" : /");
				}else{
					$("#validDate").html(" : "+util.toDateString(data.bean.validDate, "yyyy-MM-dd"));
				}
				
				if(data.bean.status == 1){
					$("#allRevokeBtn").show();
					$("#allPassBtn").hide();
					$("#allPassBtn").removeClass("layui-btn-disabled");
					$("#allPassBtn").removeAttr("disabled");
				}else{
					if(data.bean.commitmentStatus == 2&&data.bean.applyStatus == 2&&data.bean.informationStatus == 2&&
							data.bean.copyStatus == 2&&data.bean.conventionStatus == 2&&data.bean.verificationStatus == 2){
						$("#allPassBtn").removeClass("layui-btn-disabled");
						$("#allPassBtn").removeAttr("disabled");
					}
				}
				$("#status").show();
			},
			error:function(data){
				layer.msg(shiant.l(data.msg));
			}
		});
	}
    
    showBtn = function (dom,status){
    	if(status == 0){//初始化
    		$($("#"+dom+" .title a")[0]).hide();
			$($("#"+dom+" .title a")[1]).hide();
			$($("#"+dom+" .title a")[2]).hide();
			$($("#"+dom+" .title a")[3]).hide();
			$($("#"+dom+" .title")[1]).css("color","#c9c9c9");
			$($("#"+dom+" .title")[1]).html(shiant.l("未提交审核文件"));
		}
    	if(status == 1){//待审核
			$($("#"+dom+" .title a")[0]).show();
			$($("#"+dom+" .title a")[1]).show();
			$($("#"+dom+" .title a")[2]).show();
			$($("#"+dom+" .title a")[3]).hide();
			$($("#"+dom+" .title")[1]).css("color","#c9c9c9");
			$($("#"+dom+" .title")[1]).html(shiant.l("待审核"));
		}
    	if(status == 2){//通过
    		$($("#"+dom+" .title a")[0]).show();
    		$($("#"+dom+" .title a")[1]).hide();
    		$($("#"+dom+" .title a")[2]).hide();
    		$($("#"+dom+" .title a")[3]).show();
    		$($("#"+dom+" .title")[1]).css("color","#5FB878");
			$($("#"+dom+" .title")[1]).html('<i class="layui-icon layui-icon-ok"></i>'+shiant.l("审核通过"));
    	}
    	if(status == -1){//失败
    		$($("#"+dom+" .title a")[0]).show();
    		$($("#"+dom+" .title a")[1]).hide();
    		$($("#"+dom+" .title a")[2]).hide();
    		$($("#"+dom+" .title a")[3]).show();
    		$($("#"+dom+" .title")[1]).css("color","#FF5722");
			$($("#"+dom+" .title")[1]).html('<i class="layui-icon layui-icon-close"></i>'+shiant.l("审核失败"));
    	}
    }
    
    showFile = function (type){
    	var file = whiteList[type+"File"];
    	window.open(file);
    }
    
    revoke = function (type){
    	if(whiteList.status == 1){
    		layer.msg(shiant.l("请先撤销白名单"));
    		return;
    	}
    	layer.confirm(shiant.l('审核撤销详细'),{title:shiant.l('审核撤销')}, function(index){
    		var bean = {};
        	bean[type+"File"] = whiteList[type+"File"];
        	bean[type+"Status"] = 1;
        	whiteList[type+"Status"] = 1;
        	saveData(type,bean,1);
			layer.close(index);
		});
    }

    pass = function (type){
    	layer.confirm(shiant.l('审核通过详细'),{title:shiant.l('审核通过')}, function(index){
    		var bean = {};
        	bean[type+"File"] = whiteList[type+"File"];
        	bean[type+"Status"] = 2;
        	whiteList[type+"Status"] = 2;
        	saveData(type,bean,2);
			layer.close(index);
		});
    }

    notPass = function (type){
    	layer.confirm(shiant.l('审核不通过详细'),{title:shiant.l('审核不通过')}, function(index){
    		var bean = {};
        	bean[type+"File"] = whiteList[type+"File"];
    		bean[type+"Status"] = -1;
    	 	whiteList[type+"Status"] = -1;
    		saveData(type,bean,-1);
			layer.close(index);
		});
    }
    
    allPass = function (type){
    	layer.open({
			title: shiant.l('审核通过'),
			area: ['500px', '400px'],
			content: `<div class="">
				<p>`+shiant.l('白名单认证通过详细')+`</p>
				<div style="width:100%;"><label class="layui-form-label">`+shiant.l('资质号')+`<span class="red-star">*</span></label>
				<div class="layui-input-inline">
					<input type="text" name="wlNo" lay-verify="required" autocomplete="off" class="layui-input">
				</div></div>
				<div style="width:100%;"><label class="layui-form-label">`+shiant.l('资质有效期')+`<span class="red-star">*</span></label>
				<div class="layui-input-inline">
				<input type="text" name="validDate" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
				</div></div>
			</div>`,
			btn:['确认','取消'],
			yes: function (index, layero) {
				var wlNo = $('input[name="wlNo').val();
				var validDate = $('input[name="validDate').val();
				if(wlNo!=''&&validDate!=''){
					var bean = {};
					bean.wlNo = wlNo;
					bean.validDate = validDate;
					bean.status = 1;
					whiteList.wlNo = wlNo;
					whiteList.validDate = validDate;
					whiteList.status = 1;
					saveData(type,bean,2);
					$("#wlNo").html(wlNo);
					$("#validDate").html(validDate);
					layer.close(index);
				}else{
					layer.msg(shiant.l("请输入完整信息"));
				}
			}
		})
		laydate.render({
		    elem: '#date'
		});
    }
    
    allRevoke = function (){
    	layer.confirm(shiant.l('撤销白名单认证'),{title:shiant.l('撤销白名单')}, function(index){
    		var bean = {};
    		bean["wlNo"] = whiteList["wlNo"];
    		bean["validDate"] = whiteList["validDate"];
    		bean["status"] = -1;
    		whiteList["status"] = -1;
    		saveData(-2,bean,-1);
    		layer.close(index);
    	});
    }
    
    saveData = function(type,data,status) {
    	$.ajax({
			url:layui.setter.url+'/service/whiteList/updateBean',
			data:data,
			type:"POST",
			dataType:"json",
			success:function(data){
				layer.msg(data.msg);
				if(data.status){
					showBtn(type,status);
					if(data.whiteListVo.status == 1){
						$("#allRevokeBtn").show();
						$("#allPassBtn").hide();
						$("#passBtn").removeClass("layui-btn-disabled");
						$("#passBtn").removeAttr("disabled");
					}else{
						$("#allRevokeBtn").hide();
						$("#allPassBtn").show();
						if(whiteList.commitmentStatus == 2&&whiteList.applyStatus == 2&&whiteList.informationStatus == 2&&
								whiteList.copyStatus == 2&&whiteList.conventionStatus == 2&&whiteList.verificationStatus == 2){
							$("#allPassBtn").removeClass("layui-btn-disabled");
							$("#allPassBtn").removeAttr("disabled");
						}else{
							$("#allPassBtn").addClass("layui-btn-disabled");
							$("#allPassBtn").attr("disabled","disabled");
						}
					}
					
				}
			},
			error:function(data){
				layer.msg(data.msg);
			}
		});
	}
    
    initData();
});