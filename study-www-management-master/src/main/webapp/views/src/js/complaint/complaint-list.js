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
          ,{field: 'creater', title: shiant.l('用户账号'), align: 'center', width: 100}
          ,{field: 'createrType', title: shiant.l('用户类型'), align: 'center', width: 100}
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
    	if(obj.event === 'download'){
    		layer.confirm(shiant.l('确定导出投诉'),{title:shiant.l('提示')}, function(index){
    		});
    	} else if(obj.event === 'edit'){
    		location.hash = '/complaint/complaint-detail/id='+obj.data.cid;
    	}
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