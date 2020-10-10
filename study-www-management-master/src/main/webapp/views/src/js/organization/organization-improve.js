layui.use(['form','admin','element','laydate','upload'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,view = layui.view
    ,form = layui.form
    ,upload = layui.upload
    ,laydate = layui.laydate
    ,element = layui.element;
    
    shiant.translate();
    
    var curTab;
    
    initData = function () {
		$.ajax({
			url:layui.setter.url+'/service/organization/curOrganization',
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
			},
			error:function(data){
				layer.msg(shiant.l(data.msg));
			}
		});
	}
    
    laydate.render({
        elem: '#foundDate'
	});
    
    $('#nextStepBtn').on('click', function(){
    	 var field = form.val('layuiadmin-organization-base-form');
    	 $.ajax({
				url:layui.setter.url+'/service/organization/updateBean',
				data:field,
				type:"POST",
				dataType:"json",
				success:function(data){
					layer.msg(shiant.l(data.msg));
					if(data.status){
						element.tabChange('organization-tab-brief-filter', 2);
					}
				},
				error:function(data){
					layer.msg(shiant.l(data.msg));
				}
    	 });
	});
    $('#nextBackBtn').on('click', function(){
    	element.tabChange('organization-tab-brief-filter', 1);
    });
    
    form.on('submit(submit)', function(data){
    	var field = data.field;
    	field.orgid = $("input[name='orgid']").val();
    	field.status = 1;
    	$.ajax({
    		url:layui.setter.url+'/service/organization/updateBean',
    		data:field,
    		type:"POST",
    		dataType:"json",
    		success:function(data){
    			layer.msg(shiant.l(data.msg));
    			if(data.status){
    				gotoHome();
    			}
    		},
    		error:function(data){
    			layer.msg(shiant.l(data.msg));
    		}
    	});
        return false;
      });
    
    gotoHome = function() {
    	var timer = window.setInterval(function(){
    		window.clearInterval(timer);
			window.location.hash = "/";
		},2000);
	}
    
    var uploadLogoInst = upload.render({
	      elem: '#logo-upload'
	      ,url: shiant.getResHttpPrefix()+'/image?path=/center/management/organization/logo'
	      ,accept: 'images'
	      ,acceptMime: 'image/*' 
	      ,size: 1024*3 
	      ,before: function(obj){
	    	layer.msg(shiant.l("上传中"),{time:20000});
	        obj.preview(function(index, file, result){
	          $('#logo-upload-img').attr('src', result); 
	        });
	      }
	      ,done: function(res){
	        if(res.code > 0){
	          return layer.msg(shiant.l('上传失败'));
	        }
	        layer.close(layer.index);
	        $('input[name="orgLogo"]').val(res.url);
	      }
	      ,error: function(){
	        var demoText = $('#logo-upload-text');
	        demoText.html('<span style="color: #FF5722;">'+shiant.l("上传失败")+'</span> <a class="layui-btn layui-btn-mini demo-reload">'+shiant.l("重试")+'</a>');
	        demoText.find('.demo-reload').on('click', function(){
	          uploadLogoInst.upload();
	        });
	      }
	    });
    var uploadWeChatInst = upload.render({
	      elem: '#wechat-upload'
	      ,url: shiant.getResHttpPrefix()+'/image?path=/center/management/organization/wechat'
	      ,accept: 'images'
	      ,acceptMime: 'image/*' 
	      ,size: 1024*3 
	      ,before: function(obj){
	    	layer.msg(shiant.l("上传中"),{time:20000});
	        obj.preview(function(index, file, result){
	          $('#wechat-upload-img').attr('src', result); 
	        });
	      }
	      ,done: function(res){
	        if(res.code > 0){
	          return layer.msg(shiant.l('上传失败'));
	        }
	        layer.close(layer.index);
	        $('input[name="wechatQrCode"]').val(res.url);
	      }
	      ,error: function(){
	        var demoText = $('#wechat-upload-text');
	        demoText.html('<span style="color: #FF5722;">'+shiant.l("上传失败")+'</span> <a class="layui-btn layui-btn-mini wechat-reload">'+shiant.l("重试")+'</a>');
	        demoText.find('.wechat-reload').on('click', function(){
	          uploadWeChatInst.upload();
	        });
	      }
	    });
    var uploadMpInst = upload.render({
	      elem: '#mp-upload'
	      ,url: shiant.getResHttpPrefix()+'/image?path=/center/management/organization/wechat'
	      ,accept: 'images'
	      ,acceptMime: 'image/*' 
	      ,size: 1024*3 
	      ,before: function(obj){
	    	layer.msg(shiant.l("上传中"),{time:20000});
	        obj.preview(function(index, file, result){
	          $('#mp-upload-img').attr('src', result); 
	        });
	      }
	      ,done: function(res){
	        if(res.code > 0){
	          return layer.msg(shiant.l('上传失败'));
	        }
	        layer.close(layer.index);
	        $('input[name="wechatMpQrCode"]').val(res.url);
	      }
	      ,error: function(){
	        var demoText = $('#mp-upload-text');
	        demoText.html('<span style="color: #FF5722;">'+shiant.l("上传失败")+'</span> <a class="layui-btn layui-btn-mini mp-reload">'+shiant.l("重试")+'</a>');
	        demoText.find('.mp-reload').on('click', function(){
	          uploadMpInst.upload();
	        });
	      }
	    });
    var uploadBlInst = upload.render({
    	elem: '#bl-upload'
    	,url: shiant.getResHttpPrefix()+'/image?path=/center/management/organization/business license'
    	,accept: 'images'
    	,acceptMime: 'image/*' 
    	,size: 1024*3 
    	,before: function(obj){
    		layer.msg(shiant.l("上传中"),{time:20000});
    		obj.preview(function(index, file, result){
    			$('#bl-upload-img').attr('src', result); 
    		});
    	}
	    ,done: function(res){
	    	if(res.code > 0){
	    		return layer.msg(shiant.l('上传失败'));
	    	}
	    	layer.close(layer.index);
	    	$('input[name="businessLicense"]').val(res.url);
	    }
	    ,error: function(){
	    	var demoText = $('#bl-upload-text');
	    	demoText.html('<span style="color: #FF5722;">'+shiant.l("上传失败")+'</span> <a class="layui-btn layui-btn-mini bl-reload">'+shiant.l("重试")+'</a>');
	    	demoText.find('.bl-reload').on('click', function(){
	    		uploadBlInst.upload();
	    	});
	    }
    });
    
    initData();
});