layui.use(['table', 'form', 'admin', 'layedit'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,view = layui.view
    ,table = layui.table
    ,layedit = layui.layedit
    ,form = layui.form;
    
    shiant.translate();
    
    table.render({
      elem: '#LAY-table-complaint'
      ,url: layui.setter.url+'/service/complaint/getBeans' 
      ,cols: [[
          {type: 'checkbox'}
          ,{field: 'cid', title: shiant.l('编号'), width: 60, align: 'center'}
          ,{field: 'title', title: shiant.l('投诉标题'), align: 'center', width: 400}
          ,{field: 'orgName', title: shiant.l('投诉机构'), align: 'center'}
          ,{field: 'type', title: shiant.l('投诉类型'), align: 'center'}
          ,{field: 'status', title: shiant.l('状态'), align: 'center', width: 100, templet:function(d){
        	  if(d['status'] == 0){
        		  return shiant.l("待审核");
        	  }else if(d['status'] == 1){
        		  return shiant.l("已受理");
        	  }else if(d['status'] == -1){
        		  return shiant.l("无效");
        	  }
          }}
          ,{title: shiant.l('操作'), minWidth: 100, width: 100, align: 'center', fixed: 'right', toolbar: '#table-content-list'}
      ]]
      ,page: true
      ,limit: 10
      ,limits: [10, 15, 20, 25, 30]
      ,text: {
    	    none: shiant.l('暂无数据') 
      }
    });
    
    //监听工具条
    table.on('tool(LAY-table-filter-complaint)', function(obj){
    	var data = obj.data;
    	if(obj.event === 'del'){
    		layer.confirm(shiant.l('确定删除投诉'),{title:shiant.l('提示')}, function(index){
    			$.ajax({
					url:layui.setter.url+'/service/complaint/deleteBean?ids='+data.cid,
					type:"GET",
					dataType:"json",
					success:function(data){
						layer.msg(shiant.l("删除成功"));
						obj.del();      	
					},
					error:function(data){
						layer.msg(shiant.l(data.msg));
					}
				});
    			layer.close(index);
    		});
    	} else if(obj.event === 'edit'){
    		admin.popup({
    			title: shiant.l('查看投诉')
    			,area: ['60%', '70%']
    			,id: 'LAY-popup-content-edit'
    			,success: function(layero, index){
    				view(this.id).render('complaint-org/complaint-detail', data).done(function(){
						
						$('#cover-upload-img').attr("src",data.coverFile);
    					form.render(null, 'layuiadmin-complaint-form');
    					shiant.translate('LAY-popup-content-edit');
    					
    				});
    			}
    		});
    	}
    });
    
    var active = {
    		add: function(othis){
    			admin.popup({
    				title: shiant.l('添加投诉')
    					,area: ['60%', '70%']
    					,id: 'LAY-popup-content-add'
    					,success: function(layero, index){
    						view(this.id).render('complaint-org/complaint-form').done(function(){
    							shiant.translate('LAY-popup-content-add');
    							form.render(null, 'layuiadmin-complaint-form');
    							
	    						//监听提交
	    						form.on('submit(layuiadmin-complaint-form-submit)', function(data){
	    							var field = data.field; //获取提交的字段
	    							field.type = '';
	    							$('input[name=type]:checked').each(function() {
	    								field.type = field.type + $(this).val() +";";
	    							});
	    							field.need = '';
	    							$('input[name=need]:checked').each(function() {
	    								field.need = field.need + $(this).val() +";";
	    							});
	    							$.ajax({
	    								url:layui.setter.url+'/service/complaint/addBean',
	    								data:field,
	    								type:"POST",
	    								dataType:"json",
	    								success:function(data){
	    									layer.msg(shiant.l(data.msg));
	    									layui.table.reload('LAY-table-complaint'); //重载表格
	    									layer.close(index); //执行关闭 
	    								},
	    								error:function(data){
	    									layer.msg(shiant.l(data.msg));
	    								}
	    							});
	    						});
    						});
    				}
    			});
    		},
    		batchdel: function(){
    			var checkStatus = table.checkStatus('LAY-table-complaint')
    			,checkData = checkStatus.data; //得到选中的数据
    			
    			//获取选中数量
    			var selectCount = checkStatus.data.length;
    			if(selectCount == 0){
    				layer.msg(shiant.l('批量删除至少选中一项数据'),function(){});
    				return false;
    			}
    			
    			layer.confirm(shiant.l('确定删除投诉'), {title:shiant.l('提示')}, function(index) {
    				layer.close(index);
    				index = layer.load(1, {shade: [0.1,'#fff']});
    				
    				var isStr="";
    				for(var i=0; i<selectCount; i++){
    					isStr = isStr + "," + checkStatus.data[i].cid;
    				}
    				
    				$.ajax({
    					url:layui.setter.url+'/service/complaint/deleteBean?ids='+isStr,
    					type:"GET",
    					dataType:"json",
    					success:function(data){
    						layer.msg(shiant.l("删除成功"));
    						layui.table.reload('LAY-table-complaint'); 
    						layer.close(index);             	},
    						error:function(data){
    							layer.close(index); 
    							layer.msg(shiant.l(data.msg));
    						}
    				});
    			});
    		}
    }; 

    $('.layui-btn.layuiadmin-btn-list').on('click', function(){
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });
    
    //监听搜索
    form.on('submit(LAY-complaint-search)', function(data){
      var field = data.field;

      //执行重载
      table.reload('LAY-table-complaint', {
        where: field,
        page: {
			curr: 1
		}
      });
    });
    
    form.render('select');
    
    search = function (e) {
    	var evt = window.event || e;
        if (evt.keyCode == 13) {
	    	var value = $("#selectInputType").val();
	    	initTypeData(value);
        }
    }
    
});