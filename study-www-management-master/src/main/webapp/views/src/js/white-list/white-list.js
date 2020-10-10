layui.use(['table', 'upload', 'util', 'form', 'admin'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,upload = layui.upload
    ,view = layui.view
    ,table = layui.table
    ,util = layui.util
    ,form = layui.form;
    
    shiant.translate();
    
    var whiteList = {};
    
    initData = function () {
		$.ajax({
			url:layui.setter.url+'/service/whiteList/getCurWhiteList',
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
				uploadFile("commitment");
				uploadFile("apply");
				uploadFile("information");
				uploadFile("copy");
				uploadFile("convention");
				uploadFile("verification");
				
				$("#wlNo").html(data.bean.wlNo);
				$("#validDate").html(util.toDateString(data.bean.validDate, "yyyy-MM-dd"));
				if(data.bean.status == 1){
					$("#status").show();
				}
			},
			error:function(data){
				layer.msg(shiant.l(data.msg));
			}
		});
	}
    
    showBtn = function (dom,status){
    	if(status == 0){//初始化
    		$($("#"+dom+" .title a")[0]).hide();
			$($("#"+dom+" .title a")[1]).show();
			$($("#"+dom+" .title a")[2]).show();
			$($("#"+dom+" .title")[1]).css("color","#c9c9c9");
			$($("#"+dom+" .title")[1]).html(shiant.l("请提交审核文件"));
		}
    	if(status == 1){//待审核
			$($("#"+dom+" .title a")[0]).show();
			$($("#"+dom+" .title a")[1]).hide();
			$($("#"+dom+" .title a")[2]).show();
			$($("#"+dom+" .title")[1]).css("color","#c9c9c9");
			$($("#"+dom+" .title")[1]).html(shiant.l("待审核"));
		}
    	if(status == 2){//通过
    		$($("#"+dom+" .title a")[0]).show();
    		$($("#"+dom+" .title a")[1]).hide();
    		$($("#"+dom+" .title a")[2]).hide();
    		$($("#"+dom+" .title")[1]).css("color","#5FB878");
			$($("#"+dom+" .title")[1]).html('<i class="layui-icon layui-icon-ok"></i>'+shiant.l("审核通过"));
    	}
    	if(status == -1){//失败
    		$($("#"+dom+" .title a")[0]).show();
    		$($("#"+dom+" .title a")[1]).show();
    		$($("#"+dom+" .title a")[2]).show();
    		$($("#"+dom+" .title")[1]).css("color","#FF5722");
			$($("#"+dom+" .title")[1]).html('<i class="layui-icon layui-icon-close"></i>'+shiant.l("审核失败"));
    	}
    }
    
    showFile = function (type){
    	var file = whiteList[type+"File"];
    	window.open(file);
    }
    
    uploadFile = function (type){
    	upload.render({
	      elem: '#'+type+'-upload'
	      ,url: shiant.getResHttpPrefix()+'/pdf'
	      ,accept: 'file'
	      ,acceptMime: '.pdf,.PDF' 
	      ,exts: 'pdf|PDF'
	      ,size: 1024*50 
	      ,before: function(obj){
	    	layer.msg(shiant.l("上传中"),{time:200000});
	      }
	      ,done: function(res){
	        //如果上传失败
	        if(res.code > 0){
	          return layer.msg(shiant.l('上传失败'));
	        }
	        layer.close(layer.index);
	        //上传成功
	        var bean = {};
	        bean[type+"File"] = res.url;
	        bean[type+"Status"] = 1;
	        whiteList[type+"File"] = res.url;
	        whiteList[type+"Status"] = 1;
	        saveData(type,bean);
	      }
	      ,error: function(){
	    	  layer.msg(shiant.l('上传失败'));
	      }
	    });
    }
    
    downloadFile = function (type){
    	if(type == 'commitment'){
    		
    	}
    }
    
    saveData = function(type,data) {
    	$.ajax({
			url:layui.setter.url+'/service/whiteList/updateBean',
			data:data,
			type:"POST",
			dataType:"json",
			success:function(data){
				layer.msg(data.msg);
				if(data.status){
					showBtn(type,1);
				}
			},
			error:function(data){
				layer.msg(data.msg);
			}
		});
	}
    
    initData();
});