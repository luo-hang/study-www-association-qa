layui.use(['table', 'form', 'admin', 'layedit'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,view = layui.view
    ,table = layui.table
    ,layedit = layui.layedit
    ,form = layui.form;
    
    shiant.translate();
    
    table.render({
      elem: '#LAY-table-case'
      ,url: layui.setter.url+'/service/case/getBeans' 
      ,cols: [[
          {type: 'checkbox'}
          ,{field: 'cid', title: shiant.l('编号'), width: 60, align: 'center'}
          ,{field: 'isDelete', title: shiant.l('封面'), align: 'center', templet:function(d){
        	  return '<div><img src="'+d.coverFile+'" style="height:30px;"></div>';
          }}
          ,{field: 'title', title: shiant.l('案例标题'), align: 'center', width: 400}
          ,{field: 'createDate', title: shiant.l('创建时间'), width: 100,templet: '<div>{{ layui.util.timeAgo(d.createDate) }}</div>'}
          ,{field: 'showTime', title: shiant.l('阅读量'), align: 'center', width: 80}
          ,{field: 'isPublic', title: shiant.l('状态'), align: 'center', templet:function(d){
        	  if(d['public']){
        		  return shiant.l("已上架");
        	  }else{
        		  return shiant.l("未上架");
        	  }
          }}
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
    table.on('tool(LAY-table-filter-case)', function(obj){
    	var data = obj.data;
    	if(obj.event === 'del'){
    		layer.confirm(shiant.l('确定删除案例'),{title:shiant.l('提示')}, function(index){
    			$.ajax({
					url:layui.setter.url+'/service/case/deleteBean?ids='+data.cid,
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
    			title: shiant.l('编辑案例')
    			,area: ['60%', '70%']
    			,id: 'LAY-popup-content-edit'
    			,success: function(layero, index){
    				view(this.id).render('case/case-form', data).done(function(){
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
						
						$('input[name="public"]').attr("lay-text",shiant.l("已上架")+"|"+shiant.l("未上架"));
						if(!data['public']){
							$('input[name="public"]').removeAttr("checked");
						}
						$('#cover-upload-img').attr("src",data.coverFile);
    					form.render(null, 'layuiadmin-case-form');
    					shiant.translate('LAY-popup-content-edit');
    					
    					//监听提交
    					form.on('submit(layuiadmin-case-form-submit)', function(data){
    						var field = data.field; //获取提交的字段
    						if(field['delete'] == 'on'){
    							field['delete'] = true;
							}else{
								field['delete'] = false;
							}
							$.ajax({
								url:layui.setter.url+'/service/case/updateBean',
								data:field,
								type:"POST",
								dataType:"json",
								success:function(data){
									layer.msg(shiant.l(data.msg));
									if(data.status){
										layui.table.reload('LAY-table-case'); //重载表格
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
    		layer.confirm(shiant.l('确定下架案例'),{title:shiant.l('提示')}, function(index){
    			$.ajax({
					url:layui.setter.url+'/service/case/stop?ids='+data.cid,
					type:"GET",
					dataType:"json",
					success:function(data){
						layer.msg(shiant.l(data.msg));
						layui.table.reload('LAY-table-case'); //重载表格
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
    				title: shiant.l('添加案例')
    					,area: ['60%', '70%']
    					,id: 'LAY-popup-content-add'
    					,success: function(layero, index){
    						view(this.id).render('case/case-form').done(function(){
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
    							
    							$('input[name="public"]').attr("lay-text",shiant.l("已上架")+"|"+shiant.l("未上架"));
    							
    							shiant.translate('LAY-popup-content-add');
    							form.render(null, 'layuiadmin-case-form');
    							
	    						//监听提交
	    						form.on('submit(layuiadmin-case-form-submit)', function(data){
	    							var field = data.field; //获取提交的字段
	    							if(field['public'] == 'on'){
	    								field['public'] = true;
	    							}else{
	    								field['public'] = false;
	    							}
	    							$.ajax({
	    								url:layui.setter.url+'/service/case/addBean',
	    								data:field,
	    								type:"POST",
	    								dataType:"json",
	    								success:function(data){
	    									layer.msg(shiant.l(data.msg));
	    									layui.table.reload('LAY-table-case'); //重载表格
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
    			var checkStatus = table.checkStatus('LAY-table-case')
    			,checkData = checkStatus.data; //得到选中的数据
    			
    			//获取选中数量
    			var selectCount = checkStatus.data.length;
    			if(selectCount == 0){
    				layer.msg(shiant.l('批量删除至少选中一项数据'),function(){});
    				return false;
    			}
    			
    			layer.confirm(shiant.l('确定删除案例'), {title:shiant.l('提示')}, function(index) {
    				layer.close(index);
    				index = layer.load(1, {shade: [0.1,'#fff']});
    				
    				var isStr="";
    				for(var i=0; i<selectCount; i++){
    					isStr = isStr + "," + checkStatus.data[i].cid;
    				}
    				
    				$.ajax({
    					url:layui.setter.url+'/service/case/deleteBean?ids='+isStr,
    					type:"GET",
    					dataType:"json",
    					success:function(data){
    						layer.msg(shiant.l("删除成功"));
    						layui.table.reload('LAY-table-case'); 
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
    form.on('submit(LAY-case-search)', function(data){
      var field = data.field;

      //执行重载
      table.reload('LAY-table-case', {
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