layui.use(['form','admin','element','laydate','util'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,view = layui.view
    ,form = layui.form
    ,laydate = layui.laydate
    ,util = layui.util
    ,element = layui.element;
    
    var router = layui.router();
    
    shiant.translate();
    
    initData = function () {
		$.ajax({
			url:layui.setter.url+'/service/organization/getBean?id='+router.search.id,
			type:"GET",
			dataType:"json",
			success:function(data){
				if(data.bean.orgLogo){
					$("#logo-upload-img").attr("src",data.bean.orgLogo);
				}
				if(data.bean.wechatQrCode){
					$("#wechat-upload-img").attr("src",data.bean.wechatQrCode);
				}
				if(data.bean.wechatMpQrCode){
					$("#mp-upload-img").attr("src",data.bean.wechatMpQrCode);
				}
				if(data.bean.businessLicense){
					$("#bl-upload-img").attr("src",data.bean.businessLicense);
				}
				form.val('layuiadmin-organization-base-form', data.bean);
				 $('input[name="legalPerson"]').val(data.bean.legalPerson);
				 $('input[name="legalPersonIdCard"]').val(data.bean.legalPersonIdCard);
				 $('input[name="legalPersonPhone"]').val(data.bean.legalPersonPhone);
				 $('input[name="businessLicense"]').val(data.bean.businessLicense);
				 if(data.bean.status == 0||data.bean.status == -1){
					 $('#nopass').show();
					 $('#submit').show();
				 }
				 if(data.bean.status == -1){
					 var date = data.bean.verifyDate;
					 var html = '<div><span style="color:#FF5722;margin: 0 30px;font-size: 22px;">'+shiant.l("审核失败")+
					 	'</span><span style="font-size: 22px;">'+date+'</span></div>';
					 html = html+'<div>'+data.bean.reason+'</div>';
					 $("#note").append(html);
				 }
				 if(data.bean.status == 1){
					 var date = data.bean.verifyDate;
					 if(!date){
						 date = "";
					 }
					 var html = '<div><span style="color:#5FB878;margin: 0 30px;font-size: 22px;">'+shiant.l("审核通过")+
					 	'</span><span style="font-size: 22px;">'+date+'</span></div>';
					 $("#note").append(html);
				 }
			},
			error:function(data){
				layer.msg(shiant.l(data.msg));
			}
		});
	}
    
    laydate.render({
        elem: '#foundDate'
	});
    
    $('#nopass').on('click', function(){
    	layer.open({
			title: shiant.l('审核不通过'),
			area: ['500px', '400px'],
			content: '<div><p>'+shiant.l('机构审核不通过详细')+'</p><textarea id="remark" class="layui-textarea" style="height:200px;"></textarea></div>',
			btn:['确认','取消'],
			yes: function (index, layero) {
				var value1 = $('#remark').val();
				var bean = {};
				bean.orgid = $('input[name="orgid').val();
				bean.status = -1;
				bean.verifyDate = util.toDateString(new Date(), "yyyy-MM-dd HH:mm:ss");
				bean.reason = value1;
				saveData(bean);
				layer.close(index);
			}
		})
    });
    
    $('#submit').on('click', function(){
    	layer.confirm(shiant.l('机构审核通过详细'),{title:shiant.l('审核通过')}, function(index){
    		var value1 = $('#remark').val();
			var bean = {};
			bean.orgid = $('input[name="orgid').val();
			bean.status = 1;
			bean.verifyDate = util.toDateString(new Date(), "yyyy-MM-dd HH:mm:ss");
			saveData(bean);
			layer.close(index);
		});
    });
    
    saveData = function (data){
    	$.ajax({
    		url:layui.setter.url+'/service/organization/updateBean',
    		data:data,
    		type:"POST",
    		dataType:"json",
    		success:function(data){
    			layer.msg(shiant.l(data.msg));
    			if(data.organizationRmiVo.status == -1){
					 var date = data.organizationRmiVo.verifyDate;
					 var html = '<div><span style="color:#FF5722;margin: 0 30px;font-size: 22px;">'+shiant.l("审核失败")+
					 	'</span><span style="font-size: 22px;">'+date+'</span></div>';
					 html = html+'<div>'+data.organizationRmiVo.reason+'</div>';
					 $("#note").empty().append(html);
				 }
				 if(data.organizationRmiVo.status == 1){
					 var date = data.organizationRmiVo.verifyDate;
					 var html = '<div><span style="color:#5FB878;margin: 0 30px;font-size: 22px;">'+shiant.l("审核通过")+
					 	'</span><span style="font-size: 22px;">'+date+'</span></div>';
					 $("#note").empty().append(html);
					 $('#nopass').hide();
	    			 $('#submit').hide();
				 }
    		},
    		error:function(data){
    			layer.msg(shiant.l(data.msg));
    		}
    	});
    }
    
    initData();
});