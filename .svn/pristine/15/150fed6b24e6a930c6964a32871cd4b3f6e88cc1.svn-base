//页面加载  
$(document).ready(function(){
	setMenuAuthorization();
	closeAuthorization();
});

//菜单配置窗口关闭标志
var closeFlag = false;

//初始化菜单授权窗口
function setMenuAuthorization(){
	$('#menuAuthorizationDiv').dialog({
		title : '菜单授权',
		modal: true,         	//模式窗口：窗口背景不可操作
		collapsible : true,  	//可折叠，点击窗口右上角折叠图标将内容折叠起来
		resizable : true,    	//可拖动边框大小
		onClose : function(){   //继承自panel的关闭事件
			$('#dataGridTableMenu').datagrid('loadData', { total: 0, rows: [] });//清空DateGrid
			closeFlag = false;
		}
	});
}

//关闭菜单授权窗口
function closeAuthorization(){
	$('#menuAuthorizationDiv').dialog('close');
}

//打开授权窗口
function openMenuAuthorization(){
	if($('#dataGridTable').datagrid('getSelected')){
		//首先如果选择了数据，则获取选择的数据集合
		var rolesId = $('#dataGridTable').datagrid('getSelections')[0].rolesId;
		//根据ID加载信息
		$('#authorizationMenuTree').tree({
	    	url: 'sys/menusRoleTree.action?role.rolesId='+rolesId,
	    	checkbox:true,
	    	animate:true,
	    	lines:true,
	    	loadFilter: function(data){   
	        	return data.rows;   
	    	},
	    	/*onLoadSuccess:function(node, data){
	    		 $('#authorizationMenuTree').tree('collapseAll');
	    	},*/
	    	onClick: function(node){
				// 在用户点击的时候调用
				$("#dataGridTableMenu").datagrid({
					url: 'sys/findRoleResource.action',
					queryParams: {
						'menu.id':node.id,
						'menu.rolesId':rolesId
					},
					onLoadSuccess:function(data){
						if(data){
							$.each(data.rows, function(index, item){
								if(item.checked){
									$('#dataGridTableMenu').datagrid('checkRow', index);
								}
							});
						}
					}
				});
			}
		});
		openMenuAuthorizationDialog();
	}
	else
	{
		noSelectData();
	}
}

//保存角色授权菜单
function saveAuthorizationMenu(){
	//获取选中的菜单
	var rolesId = $('#dataGridTable').datagrid('getSelections')[0].rolesId;
	var nodes1 = $('#authorizationMenuTree').tree('getChecked', ['checked','indeterminate']);//选中的节点
	var ids = [];
	for(var i=0;i<nodes1.length;i++){
		ids.push(nodes1[i].id);
	}
	var menusId = ids.join(',');
	//后台交互
	$.ajax({
		async : false,
		cache:false,
		type: 'POST',
		dataType : "json",
		url:'sys/saveAuthorizationMenu.action',//请求的action路径
		data:{'menu.id':menusId,
			  'menu.rolesId':rolesId},
		error: function () {//请求失败处理函数
			sysErrorShow('请求失败');
		},success:function(data){
			if(data.success==false)
			{
				sysErrorShow(data.msg);
			}
			else
			{
				sysMsgShow('操作成功!');
				$('#authorizationMenuTree').tree("reload");
				$('#dataGridTableMenu').datagrid('loadData', { total: 0, rows: [] });//清空DateGrid
			}
		}
	});
}

//保存资源授权
function saveAuthResource(){
	//授权的数据
	var resId='';
	var rolesId = $('#dataGridTable').datagrid('getSelections')[0].rolesId;
	var menuSelectedNode = $('#authorizationMenuTree').tree('getSelected');//选中的节点
	if($('#dataGridTableMenu').datagrid('getChecked')){
		var res = [];
		var selectedRow = $('#dataGridTableMenu').datagrid('getChecked');
		for(var i=0;i<selectedRow.length;i++){
			res.push(selectedRow[i].resourceId);
		}
		resId = res.join(',');
	}
	if(menuSelectedNode != undefined) {
		if(menuSelectedNode.checkedStr == 'true'){
			$.ajax({
				async : false,
				cache:false,
				type: 'POST',
				dataType : "json",
				url:'sys/saveAuthorizationResource.action',//请求的action路径
				data:{	'resource.resourceId':resId,
						'resource.rolesId':rolesId,
						'resource.menuId':menuSelectedNode.id},
				error: function () {//请求失败处理函数
					sysErrorShow('请求失败');
				},success:function(data){
					if(data.success==false)
					{
						sysErrorShow(data.msg);
					}
					else
					{
						sysMsgShow('操作成功!');
					}
				}
			});
		} else {
			sysMsgShow('请先保存所选菜单授权配置!');
		}
	}
	else {
		sysMsgShow('请先选择需要修改资源的所属的菜单！');
	}
}

//打开菜单授权窗口，添加关闭前事件
function openMenuAuthorizationDialog(){
	$('#menuAuthorizationDiv').dialog({
		title : '菜单授权',
		modal: true,         	//模式窗口：窗口背景不可操作
		collapsible : true,  	//可折叠，点击窗口右上角折叠图标将内容折叠起来
		resizable : true,    	//可拖动边框大小
		onBeforeClose: function(){  //继承自panel的关闭事件
			if(!closeFlag){
				var menuflag = false;
				var resourceflag = false;
				var nodesChecked = $('#authorizationMenuTree').tree('getChecked');//选中的节点
				for(var i=0;i<nodesChecked.length;i++){
					if(nodesChecked[i].checkedStr != "true"){
						menuflag = true;
					}
				}
				var nodesUnChecked = $('#authorizationMenuTree').tree('getChecked','unchecked');//选中的节点
				for(var i=0;i<nodesUnChecked.length;i++){
					if(nodesUnChecked[i].checkedStr == "true"){
						menuflag = true;
					}
				}
				var resuorceCheckedRow = $('#dataGridTableMenu').datagrid('getChecked');
				for(var i=0;i<resuorceCheckedRow.length;i++){
					if(resuorceCheckedRow[i].checkedStr != "1"){
						resourceflag = true;
					}
				}
				var resuorceRow = $('#dataGridTableMenu').datagrid('getRows');
				for(var i=0;i<resuorceRow.length;i++){
					if(resuorceRow[i].checkedStr == "1"){
						var unCheckedFlag = true;
						if(resuorceCheckedRow != undefined){
							for (var k=0 ;k < resuorceCheckedRow.length;k++){
								if(resuorceCheckedRow[k].resourceId == resuorceRow[i].resourceId){
									unCheckedFlag = false;
									break;
								}
							}	
						} 
						if(unCheckedFlag){
							resourceflag = true;
							break;
						}
					}
				}
				var showMsg = "";
				if(menuflag){
					showMsg = "菜单有更改  ";
				}
				if(resourceflag){
					showMsg += "资源有更改  ";
				}
				if(showMsg != ""){
					var loseFlag = false;
					whileFlag = true;
					showMsg += "，是否关闭？"
					$.messager.confirm('关闭提示', showMsg, function(r){
						if(r){
							closeFlag = true;
							$('#menuAuthorizationDiv').dialog("close");
						} 
					});
				} else {
					return true;
				}
				return false;
			} else {
				return true;
			}
		}
	});
}
