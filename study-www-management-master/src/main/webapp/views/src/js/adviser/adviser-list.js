layui.use(['table', 'form', 'admin', 'layedit'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,view = layui.view
    ,table = layui.table
    ,layedit = layui.layedit
    ,form = layui.form;
    
    shiant.translate();
    
    table.render({
      elem: '#LAY-table-adviser'
      ,url: layui.setter.url+'/service/adviser/getCurBeans' 
      ,cols: [[
          {type: 'checkbox'}
          ,{field: 'aid', title: shiant.l('编号'), align: 'center'}
          ,{field: 'name', title: shiant.l('顾问姓名'), align: 'center'}
          ,{field: 'title', title: shiant.l('顾问职称'), align: 'center'}
          ,{field: 'createDate', title: shiant.l('创建时间'), align: 'center',templet: '<div>{{ layui.util.timeAgo(d.createDate) }}</div>'}
          ,{field: 'caseNum', title: shiant.l('成功案例'), align: 'center'}
          ,{title: shiant.l('操作'), minWidth: 100, align: 'center', fixed: 'right', toolbar: '#table-content-list'}
      ]]
      ,page: true
      ,limit: 10
      ,limits: [10, 15, 20, 25, 30]
      ,text: {
    	    none: shiant.l('暂无数据') 
      }
    });
    
    //监听工具条
    table.on('tool(LAY-table-filter-adviser)', function(obj){
    	var data = obj.data;
    	if(obj.event === 'del'){
    		layer.confirm(shiant.l('确定删除顾问'),{title:shiant.l('提示')}, function(index){
    			$.ajax({
					url:layui.setter.url+'/service/adviser/deleteBean?ids='+data.aid,
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
    			title: shiant.l('编辑顾问')
    			,area: ['60%', '70%']
    			,id: 'LAY-popup-content-edit'
    			,success: function(layero, index){
    				view(this.id).render('adviser/adviser-form', data).done(function(){
    					var layeditIndex = layui.layedit.build('content',{tool: [
							  'strong' //加粗
							  ,'italic' //斜体
							  ,'underline' //下划线
							  ,'del' //删除线
							  
							  ,'|' //分割线
							  
							  ,'left' //左对齐
							  ,'center' //居中对齐
							  ,'right' //右对齐
							  ,'link' //超链接
							  ,'unlink' //清除链接
							  ,'face' //表情
							]});

						form.verify({
						    content: function(value) { 
								return layedit.sync(layeditIndex);
							}
						});
						$('#cover-upload-img').attr("src",data.coverFile);
						
    					form.render(null, 'layuiadmin-adviser-form');
    					shiant.translate('LAY-popup-content-edit');
    					
    					//监听提交
    					form.on('submit(layuiadmin-adviser-form-submit)', function(data){
    						var field = data.field; //获取提交的字段
    						if(field['delete'] == 'on'){
    							field['delete'] = true;
							}else{
								field['delete'] = false;
							}
							$.ajax({
								url:layui.setter.url+'/service/adviser/updateBean',
								data:field,
								type:"POST",
								dataType:"json",
								success:function(data){
									layer.msg(shiant.l(data.msg));
									if(data.status){
										layui.table.reload('LAY-table-adviser'); //重载表格
										layer.close(index); //执行关闭 
									}
								},
								error:function(data){
									layer.msg(shiant.l(data.msg));
								}
							});
    					});
    				});
    			}
    		});
    	}else if(obj.event === 'stop'){
    		layer.confirm(shiant.l('确定下架顾问'),{title:shiant.l('提示')}, function(index){
    			$.ajax({
					url:layui.setter.url+'/service/adviser/stop?ids='+data.cid,
					type:"GET",
					dataType:"json",
					success:function(data){
						layer.msg(shiant.l(data.msg));
						layui.table.reload('LAY-table-adviser'); //重载表格
						obj.del();      	
					},
					error:function(data){
						layer.msg(shiant.l(data.msg));
					}
				});
    			layer.close(index);
    		});
    	}
    });
    
    var active = {
    		add: function(othis){
    			admin.popup({
    				title: shiant.l('添加顾问')
    					,area: ['60%', '70%']
    					,id: 'LAY-popup-content-add'
    					,success: function(layero, index){
    						view(this.id).render('adviser/adviser-form').done(function(){
    							var layeditIndex = layui.layedit.build('content',{tool: [
    								  'strong' //加粗
    								  ,'italic' //斜体
    								  ,'underline' //下划线
    								  ,'del' //删除线
    								  
    								  ,'|' //分割线
    								  
    								  ,'left' //左对齐
    								  ,'center' //居中对齐
    								  ,'right' //右对齐
    								  ,'link' //超链接
    								  ,'unlink' //清除链接
    								  ,'face' //表情
    								]});

    							form.verify({
    							    content: function(value) { 
    									return layedit.sync(layeditIndex);
    								}
    							});
    							
    							shiant.translate('LAY-popup-content-add');
    							form.render(null, 'layuiadmin-adviser-form');
    							
	    						//监听提交
	    						form.on('submit(layuiadmin-adviser-form-submit)', function(data){
	    							var field = data.field; //获取提交的字段
	    							$.ajax({
	    								url:layui.setter.url+'/service/adviser/addBean',
	    								data:field,
	    								type:"POST",
	    								dataType:"json",
	    								success:function(data){
	    									layer.msg(shiant.l(data.msg));
	    									layui.table.reload('LAY-table-adviser'); //重载表格
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
    			var checkStatus = table.checkStatus('LAY-table-adviser')
    			,checkData = checkStatus.data; //得到选中的数据
    			
    			//获取选中数量
    			var selectCount = checkStatus.data.length;
    			if(selectCount == 0){
    				layer.msg(shiant.l('批量删除至少选中一项数据'),function(){});
    				return false;
    			}
    			
    			layer.confirm(shiant.l('确定删除顾问'), {title:shiant.l('提示')}, function(index) {
    				layer.close(index);
    				index = layer.load(1, {shade: [0.1,'#fff']});
    				
    				var isStr="";
    				for(var i=0; i<selectCount; i++){
    					isStr = isStr + "," + checkStatus.data[i].aid;
    				}
    				
    				$.ajax({
    					url:layui.setter.url+'/service/adviser/deleteBean?ids='+isStr,
    					type:"GET",
    					dataType:"json",
    					success:function(data){
    						layer.msg(shiant.l("删除成功"));
    						layui.table.reload('LAY-table-adviser'); 
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
    form.on('submit(LAY-adviser-search)', function(data){
      var field = data.field;

      //执行重载
      table.reload('LAY-table-adviser', {
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