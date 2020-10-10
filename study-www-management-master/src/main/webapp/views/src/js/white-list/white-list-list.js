layui.use(['table', 'form', 'admin'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,view = layui.view
    ,table = layui.table
    ,form = layui.form;

    shiant.translate();
    
    table.render({
      elem: '#LAY-table-white-list'
      ,url: layui.setter.url+'/service/whiteList/getBeans' //模拟接口
      ,cols: [[
          {type: 'checkbox'}
          ,{field: 'wlid', width: 60, title: shiant.l('编号'), align: 'center'}
          ,{field: 'wlNo', title: shiant.l('资质号'), align: 'center'}
          ,{field: 'orgName', title: shiant.l('机构名称'), align: 'center'}
          ,{field: 'validDate', title: shiant.l('资质有效期'), align: 'center', templet: '<div>{{ layui.util.timeAgo(d.validDate) }}</div>'}
          ,{field: 'status', title: shiant.l('状态'), align: 'center', templet:function(d){
        	  if(d.status == 1){
        		  return shiant.l("审核通过");
        	  }else if(d.status == -1){
        		  return shiant.l("审核失败");
        	  }
          }}
          ,{title: shiant.l('操作'), align: 'center', fixed: 'right', toolbar: '#table-content-list'}
      ]]
      ,page: true
      ,limit: 10
      ,limits: [10, 15, 20, 25, 30]
      ,text: {
    	    none: shiant.l('暂无数据') 
      }
    });
    
    //监听工具条
    table.on('tool(LAY-table-filter-white-list)', function(obj){
    	var data = obj.data;
    	if(obj.event === 'edit'){
    		location.hash = '/white-list/white-list-verify/orgid='+obj.data.orgid;
    	}
    });
    
    //监听搜索
    form.on('submit(LAY-white-list-search)', function(data){
      var field = data.field;

      //执行重载
      table.reload('LAY-table-white-list', {
        where: field,
        page: {
			curr: 1
		}
      });
    });
    
    form.render('select');
});