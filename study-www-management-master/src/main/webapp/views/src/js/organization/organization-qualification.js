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
					$("#bl-upload-img-1").attr("src",data.bean.businessLicense);
				}
				$("#legalPerson").append(data.bean.legalPerson);
				$("#legalPersonIdCard").append(data.bean.legalPersonIdCard);
				$("#legalPersonPhone").append(data.bean.legalPersonPhone);
				$("#orgid").val(data.bean.orgid);
			},
			error:function(data){
				layer.msg(shiant.l(data.msg));
			}
		});
	}
    
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