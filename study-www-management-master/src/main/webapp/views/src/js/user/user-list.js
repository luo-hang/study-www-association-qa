layui.use(['table', 'form','admin'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,view = layui.view
    ,table = layui.table
    ,form = layui.form;

    shiant.translate();
    
    table.render({
      elem: '#LAY-table-user'
      ,url: layui.setter.url+'/service/user/getBeans' //模拟接口
      ,cols: [[
          {type: 'checkbox'}
          ,{field: 'userid', width: 80, title: shiant.l('编号')}
          ,{field: 'userName', title: shiant.l('账号名'), minWidth: 100}
          ,{field: 'phone', title: shiant.l('手机号'), minWidth: 100}
          ,{field: 'userRealName', title: shiant.l('用户名')}
          ,{field: 'createDate', title: shiant.l('创建时间'), templet: '<div>{{ layui.util.timeAgo(d.createDate) }}</div>'}
          ,{field: 'productNum', title: shiant.l('登陆次数')}
          ,{field: 'isDelete', title: shiant.l('状态'), templet:function(d){
        	  if(!d['delete']){
        		  return '<button class="layui-btn layui-btn-xs">'+shiant.l("正常")+'</button>';
        	  }else{
        		  return '<button class="layui-btn layui-btn-primary layui-btn-xs">'+shiant.l("停用")+'</button>';
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
    table.on('tool(LAY-table-filter-user)', function(obj){
    	var data = obj.data;
    	if(obj.event === 'del'){
    		layer.confirm(shiant.l('确定删除用户'),{title:shiant.l('提示')}, function(index){
    			$.ajax({
					url:layui.setter.url+'/service/user/deleteBean?ids='+data.userid,
					type:"GET",
					dataType:"json",
					success:function(data){
						if(data.status){
							layer.msg(shiant.l("删除成功"));
							obj.del();      	
						}else{
							layer.msg(shiant.l("删除失败"));
						}
					},
					error:function(data){
						layer.msg(shiant.l(data.msg));
					}
				});
    			layer.close(index);
    		});
    	} else if(obj.event === 'edit'){
    		admin.popup({
    			title: shiant.l('编辑用户')
    			,area: ['450px', '500px']
    			,id: 'LAY-popup-content-edit'
    			,success: function(layero, index){
    				view(this.id).render('user/user-form', data).done(function(){
    					form.render(null, 'layuiadmin-user-form');
    					shiant.translate('LAY-popup-content-edit');
    					//监听提交
    					form.on('submit(layuiadmin-user-form-submit)', function(data){
    						var field = data.field; //获取提交的字段
    						if(field['delete'] == 'on'){
								field['delete'] = false;
							}else{
								field['delete'] = true;
							}
    						var roleids = field.roleids.split(',');
							field.listOfRole = [];
							for(var i=0;i<roleids.length;i++){
								field.listOfRole.push({
									roleid:roleids[i]
								});
							}	
							$.ajax({
								url:layui.setter.url+'/service/user/updateBean',
								data:JSON.stringify(field),
								type:"POST",
								dataType:"json",
								contentType : "application/json",
								success:function(data){
									layer.msg(data.msg);
									layui.table.reload('LAY-table-user'); //重载表格
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
    	} else if(obj.event === 'reset'){
    		layer.confirm(shiant.l('确定重置密码'),{title:shiant.l('提示')}, function(index){
    			$.ajax({
					url:layui.setter.url+'/service/user/reset?id='+data.userid,
					type:"GET",
					dataType:"json",
					success:function(data){
						layer.msg(shiant.l(data.msg));
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
    		addOrg: function(othis){
    			admin.popup({
    				title: shiant.l('添加企业用户')
    				,area: ['450px', '500px']
    				,id: 'LAY-popup-content-add'
    				,success: function(layero, index){
    					view(this.id).render('user/user-form').done(function(){
    						$('input[name="orgName"]').parent().parent().show();
    						$("#org-list").parent().parent().hide();
    						$("#role-list").parent().parent().hide();
    						form.render(null, 'layuiadmin-user-form');
    						shiant.translate('LAY-popup-content-add');
    						//监听提交
    						form.on('submit(layuiadmin-user-form-submit)', function(data){
    							var field = data.field; //获取提交的字段
    							if(field['delete'] == 'on'){
    								field['delete'] = false;
    							}else{
    								field['delete'] = true;
    							}
    							field.orgid = null;
    							field.listOfRole = [];
    							field.listOfRole.push({
									roleid:2
								});
    							$.ajax({
    								url:layui.setter.url+'/service/user/addBean',
    								data:JSON.stringify(field),
    								type:"POST",
    								dataType:"json",
    								contentType : "application/json",
    								success:function(data){
    									layer.msg(shiant.l(data.msg));
    									if(data.status){
    										layui.table.reload('LAY-table-user'); //重载表格
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
    		},
    		add: function(othis){
    			admin.popup({
    				title: shiant.l('添加用户')
    					,area: ['450px', '500px']
    					,id: 'LAY-popup-content-add'
    					,success: function(layero, index){
    						view(this.id).render('user/user-form').done(function(){
    							form.render(null, 'layuiadmin-user-form');
    							shiant.translate('LAY-popup-content-add');
	    						//监听提交
	    						form.on('submit(layuiadmin-user-form-submit)', function(data){
	    							var field = data.field; //获取提交的字段
	    							if(field['delete'] == 'on'){
	    								field['delete'] = false;
	    							}else{
	    								field['delete'] = true;
	    							}
	    							var roleids = field.roleids.split(',');
	    							field.listOfRole = [];
	    							for(var i=0;i<roleids.length;i++){
	    								field.listOfRole.push({
	    									roleid:roleids[i]
	    								});
	    							}	
	    							$.ajax({
	    								url:layui.setter.url+'/service/user/addBean',
	    								data:JSON.stringify(field),
	    								type:"POST",
	    								dataType:"json",
	    								contentType : "application/json",
	    								success:function(data){
	    									layer.msg(shiant.l(data.msg));
	    									layui.table.reload('LAY-table-user'); //重载表格
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
    			var checkStatus = table.checkStatus('LAY-table-user')
    			,checkData = checkStatus.data; //得到选中的数据
    			
    			//获取选中数量
    			var selectCount = checkStatus.data.length;
    			if(selectCount == 0){
    				layer.msg(shiant.l('批量删除至少选中一项数据'),function(){});
    				return false;
    			}
    			
    			layer.confirm(shiant.l('确定删除用户'), {title:shiant.l('提示')}, function(index) {
    				layer.close(index);
    				index = layer.load(1, {shade: [0.1,'#fff']});
    				
    				var isStr="";
    				for(var i=0; i<selectCount; i++){
    					isStr = isStr + "," + checkStatus.data[i].id;
    				}
    				
    				$.ajax({
    					url:layui.setter.url+'/service/user/deleteBean?ids='+isStr,
    					type:"GET",
    					dataType:"json",
    					success:function(data){
    						if(data.status){
    							layer.msg(shiant.l("删除成功"));
    							layui.table.reload('LAY-table-user'); 
    							layer.close(index);             	
    						}else{
    							layer.msg(shiant.l("删除失败"));
    						}
    					},
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
    form.on('submit(LAY-user-search)', function(data){
      var field = data.field;

      //执行重载
      table.reload('LAY-table-user', {
        where: field
      });
    });
});