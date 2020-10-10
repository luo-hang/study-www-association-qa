layui.use(['table', 'form', 'admin'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,view = layui.view
    ,table = layui.table
    ,form = layui.form;

    shiant.translate();
    
    table.render({
      elem: '#LAY-table-organization'
      ,url: layui.setter.url+'/service/organization/getBeans' //模拟接口
      ,cols: [[
          {type: 'checkbox'}
          ,{field: 'orgid', width: 60, title: shiant.l('编号')}
          ,{field: 'orgName', title: shiant.l('机构名称'), width: 300}
          ,{field: 'legalPerson', title: shiant.l('联系人姓名'), width: 200}
          ,{field: 'legalPersonPhone', title: shiant.l('联系人手机号'), width: 200}
          ,{field: 'address', title: shiant.l('企业地址'), width: 400}
          ,{field: 'isDelete', title: shiant.l('账号状态'), width: 200, templet:function(d){
        	  if(d.status == 0){
        		  return shiant.l("正常");
        	  }else if(d.status == 1){
        		  return shiant.l("审核通过");
        	  }else if(d.status == -1){
        		  return shiant.l("审核失败");
        	  }
          }}
          ,{title: shiant.l('操作'), width: 250, align: 'center', fixed: 'right', toolbar: '#table-content-list'}
      ]]
      ,page: true
      ,limit: 10
      ,limits: [10, 15, 20, 25, 30]
      ,text: {
    	    none: shiant.l('暂无数据') 
      }
    });
    
    //监听工具条
    table.on('tool(LAY-table-filter-organization)', function(obj){
    	var data = obj.data;
    	if(obj.event === 'edit'){
    		location.hash = '/organization/organization-verify/id='+obj.data.orgid;
    	}else if(obj.event === 'verify'){
    		location.hash = '/white-list/white-list-verify/orgid='+obj.data.orgid;
    	}
    });
    
    //监听搜索
    form.on('submit(LAY-organization-search)', function(data){
      var field = data.field;

      //执行重载
      table.reload('LAY-table-organization', {
        where: field,
        page: {
			curr: 1
		}
      });
    });
    
    form.render('select');
});