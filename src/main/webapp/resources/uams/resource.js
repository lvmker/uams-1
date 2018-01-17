//页面加载  
$(document).ready(function(){
	$('#dataGridTable').datagrid({
		fit:true,
		toolbar:'#toolbar',
	    singleSelect:true,
	    striped:true,
		fitColumns:false,
		rownumbers:true,
		pagination:true,
		checkOnSelect:true,
		columns:[[
		          {field:'resourceName',title:'资源名称',width:150,align:'center'},
                  {field:'resourceUrl',title:'资源URL',width:200,align:'center'},
                  {field:'resourceText',title:'资源描述',width:200,align:'center'},
                  {field:'createUser',title:'记录建立者',width:createUserWidth,align:'center'},
                  {field:'createTime',title:'记录建立时间',width:createTimeWidth,align:'center'}
//                  {field:'lastModifiedUser',title:'记录最后修改者',width:lastModifiedWidth,align:'center'},
//                  {field:'lastModifiedTime',title:'记录最后修改时间',width:createTimeWidth,align:'center'}
              ]]
	});
	initResourceDialog();
	closeResourceDialog();
});

//清空表单
function resourceMenuSaveReset(){
	$('#resourceId').val('');
	$('#resourceName').textbox('setValue', '');
	$('#resourceText').textbox('setValue', '');
	$('#resourceUrl').textbox('setValue', '');
}

//保存菜单
function saveResource(){
	var validateResult = $('#resourceSaveForm').form('validate');
	//easyui 表单验证
	if(validateResult==false){
		return;
	}d
	
	
	var url = './menu/createUamsResource.do';
	$.ajax({
		async : false,
		cache:false,
		type: 'POST',
		dataType : "json",
		data:{
			'resource.resourceId':$('#resourceId').val(),
			'resource.menuId':$('#resourceMenuId').val(),
			'resource.resourceName':$('#resourceName').textbox('getValue'),
			'resource.resourceText':$('#resourceText').textbox('getValue'),
			'resource.resourceUrl':$('#resourceUrl').textbox('getValue')
		},
		url:url,//请求的action路径
		error: function () {//请求失败处理函数
			sysErrorShow('请求失败');
		},success:function(data){
			if(data.success==false){
				sysErrorShow(data.msg);
			}else{
				closeResourceDialog();
				$('#dataGridTable').datagrid('reload');
			}
		}
	});
}

//------- 添加菜单 --------
//打开对话框
function openDialog_addResource(){
	var node = $('#tt').tree('getSelected');
	if(node != undefined){
		$('#saveResource').dialog({
			title : '添加资源'
		});
		$('#resourceSaveType').val('add');
		//获取选中的值
		$('#resourceMenuId').val(node.id);
		openResourceDialog_addButton();
	} else {
		sysMsgShow('请选择要添加的菜单!');
	}
}

//------- 修改菜单 --------
function openDialog_editResource(){
	if($('#dataGridTable').datagrid('getSelected')){
		$('#saveResource').dialog({
			title : '编辑菜单'
		});
		$('#resourceSaveType').val('edit');
		//获取选中的记录
		var resourceId = $('#dataGridTable').datagrid('getSelections')[0].resourceId;
		loadResourceDataById(resourceId);
		openResourceDialog_addButton();
		$('#saveResource').dialog('setTitle','编辑资源');
	} else {
		sysMsgShow('请选择要编辑的记录!');
	}
}
//按id加载菜单数据
function loadResourceDataById(resourceId){
	//根据ID加载信息
	$.getJSON("./menu/findUamsRoles.do?resource.resourceId="+resourceId,null,function msg(json){
		$('#resourceId').val(json.object.resourceId);
		$('#resourceName').textbox('setValue', json.object.resourceName);
		$('#resourceText').textbox('setValue', json.object.resourceText);
		$('#resourceUrl').textbox('setValue', json.object.resourceUrl);
	});
}

//------- 删除菜单 --------
function deleteResource(){
	if($('#dataGridTable').datagrid('getSelected')){
		//获取选中的记录
		var resourceId = $('#dataGridTable').datagrid('getSelections')[0].resourceId;
		$.messager.confirm('删除提示', '删除资源后，角色和资源的配置信息将丢失。你确定要删除选中的资源吗?', function(r){
			if (r){
				var url ='./menu/deleteUamsRoleByRoleId.do?resource.resourceId='+resourceId;
				$.ajax({
					async : false,
					cache:false,
					type: 'POST',
					dataType : "json",
					url:url,//请求的action路径
					error: function () {//请求失败处理函数
						sysErrorShow('请求失败');
					},success:function(data){
						if(data.success==false){
							sysErrorShow(data.msg);
						}else{
							$('#dataGridTable').datagrid('reload');
						}
					}
				});
			}
		});
	}
	else
	{
		sysMsgShow('请选择要删除的记录!');
	}
	
}

//打开添加或修改模窗
function openResourceDialog_addButton(){ 
	$('#saveResource').dialog({
		closed: false,
		modal:true,
      title: "新增菜单",
      buttons: [{
          text: '确定',
          iconCls: 'icon-ok',
          handler: saveResource
      }, {
          text: '取消',
          iconCls: 'icon-cancel',
          handler: function () {
        	  closeResourceDialog();                    
          }
      }]
  });
}

//初始化窗口
function initResourceDialog(){
	$('#saveResource').dialog({
		modal: true,         	//模式窗口：窗口背景不可操作
		collapsible : true,  	//可折叠，点击窗口右上角折叠图标将内容折叠起来
		resizable : true,    	//可拖动边框大小
		onClose : function(){   //继承自panel的关闭事件
			resourceMenuSaveReset();
		}
	});
}

//关闭对话框
function closeResourceDialog(){
	$('#saveResource').dialog('close');
}
