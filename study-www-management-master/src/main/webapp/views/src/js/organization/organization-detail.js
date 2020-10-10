layui.use(['table','form','admin','element','laydate','upload'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,view = layui.view
    ,table = layui.table
    ,form = layui.form
    ,laydate = layui.laydate
    ,upload = layui.upload
    ,element = layui.element;
    
    shiant.translate();
    
    laydate.render({
        elem: '#_foundDate_'
	});
    
    
    $('.update').on('click', function(){
    	var name = $(this).data("name");
    	$(this).hide();
    	$(this).prev().prev().hide();
    	$(this).prev().show();
    	$(this).prev().val($("#"+name).html());
    	$(this).next().show();
	});
    $('.complete').on('click', function(){
    	var name = $(this).data("name");
    	$(this).hide();
    	$(this).prev().show();
    	$(this).prev().prev().hide();
    	$(this).prev().prev().prev().show();
    	$(this).prev().prev().prev().html($(this).prev().prev().val());
    	
    	var field = {
    		orgid:$("#orgid").val(),
    	}
    	field[name] = $(this).prev().prev().val();
    	submitData(field);
    });
    $('.updateImg').on('click', function(){
    	$(this).hide();
    	$(this).prev().prev().hide();
    	$(this).prev().show();
    	$(this).next().show();
    });
    $('.completeImg').on('click', function(){
    	var name = $(this).data("name");
    	$(this).hide();
    	$(this).prev().show();
    	$(this).prev().prev().hide();
    	$(this).prev().prev().prev().show();
    	$(this).prev().prev().prev().attr("src",$('input[name="'+name+'"]').val());
    	var field = {
    			orgid:$("#orgid").val(),
    	}
    	field[name] = $('input[name="'+name+'"]').val();
    	submitData(field);
    });
    
    submitData = function (field){
    	$.ajax({
    		url:layui.setter.url+'/service/organization/updateBean',
    		data:field,
    		type:"POST",
    		dataType:"json",
    		success:function(data){
    			layer.msg(shiant.l(data.msg));
    		},
    		error:function(data){
    			layer.msg(shiant.l(data.msg));
    		}
    	});
    }
    
    initData = function () {
		$.ajax({
			url:layui.setter.url+'/service/organization/curOrganization',
			type:"GET",
			dataType:"json",
			success:function(data){
				if(data.bean.orgLogo){
					$("#logo-upload-img-1").attr("src",data.bean.orgLogo);
				}
				if(data.bean.wechatQrCode){
					$("#wechat-upload-img-1").attr("src",data.bean.wechatQrCode);
				}
				if(data.bean.wechatMpQrCode){
					$("#mp-upload-img-1").attr("src",data.bean.wechatMpQrCode);
				}
				$("#address").append(data.bean.address);
				$("#foundDate").append(data.bean.foundDate);
				$("#orgIntroduction").append(data.bean.orgIntroduction);
				$("#orgName").append(data.bean.orgName);
				$("#website").append(data.bean.website);
				$("#wechat").append(data.bean.wechat);
				$("#wechatMp").append(data.bean.wechatMp);
				$("#weibo").append(data.bean.weibo);
				$("#qq").append(data.bean.qq);
				$("#consultationPhone").append(data.bean.consultationPhone);
				$("#orgid").val(data.bean.orgid);
			},
			error:function(data){
				layer.msg(shiant.l(data.msg));
			}
		});
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
    
    initData();
});