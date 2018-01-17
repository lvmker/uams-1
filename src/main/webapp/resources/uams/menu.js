//页面加载  
$(document).ready(function(){
	initDialog();
	closeDialog();
    loadTree();
});


//清空表单
function menuSaveReset(){
	$('#id').val('');
	$('#text').textbox('setValue', '');
	$('#iconCls').textbox('setValue', '');
	$('#url').textbox('setValue', '');
	$('#menuIndex').numberbox('setValue', '');
}

//保存菜单
function saveMenu(){
	var validateResult = $('#menuSaveForm').form('validate');
	//easyui 表单验证
	if(validateResult==false){
		return;
	}
	var url = './menu/updateUamsResourceByResourceId.do';
	$.ajax({
		async : false,
		cache:false,
		type: 'POST',
		dataType : "json",
		data:{
			'menu.id':$('#id').val(),
			'menu.text':$('#text').textbox('getValue'),
			'menu.iconCls':$('#iconCls').textbox('getValue'),
			'menu.url':$('#url').textbox('getValue'),
			'menu.menuIndex':$('#menuIndex').numberbox('getValue'),
			'menu.parentId':$('#menu_parentId').combotree('getValue'),
			'menu.parentName':$('#menu_parentId').combotree('getText'),
			'menu.systemCode':$('#menu_systemCode').combobox('getValue')
		},
		url:url,//请求的action路径
		error: function () {//请求失败处理函数
			sysErrorShow('请求失败');
		},success:function(data){
			if(data.success==false){
				sysErrorShow(data.msg);
			}else{
				window.location.reload(true);
			}
		}
	});
}

//------- 添加菜单 --------
//打开对话框
function openDialog_add(){
	window.bgidx = {treeNotLeafSelected:true};
	$('#saveMenu').dialog({
		title : '添加菜单'
	});
	$('#saveType').val('add');
	//获取ID
	$('#menu_parentId').combotree({    
	    url:'sys/menusTree.action',    
	    valueField:'id',
	    textField:'text',
	    loadFilter: function(data){   
        	return data.rows;   
    	}
	});
	//获取选中的值
	var node = $('#tt').tree('getSelected');
	//如果是datagrid则为 $('#grid').datagrid('getSelections');
	//赋默认值
	$('#menu_parentId').combotree('setValue', node.id);
	openDialog_addButton();
}

//------- 修改菜单 --------
function openDialog_edit(){
	//获取选中的值
	var node = $('#tt').tree('getSelected');
	if(node.id == 'menuRoot'){
		sysErrorShow('顶级菜单不能修改！');
	} else {
		window.bgidx = {treeNotLeafSelected:true};
		//获取ID
		$('#menu_parentId').combotree({    
		    url:'sys/menusTree.action?menu.excludeId='+node.id+'&menu.excludeMenuName='+node.text,    
		    valueField:'id',
		    width:262,
		    textField:'text',
		    loadFilter: function(data){   
	        	return data.rows;   
	    	}
		});
		loadMenuDataById(node.id,node.text);
		openDialog_addButton();
		$('#saveMenu').dialog('setTitle','编辑菜单');
	}
}
//按id加载菜单数据
function loadMenuDataById(menuId,menuText){
	//根据ID加载信息
	$.getJSON("./menu/findUamsResources.do?menu.id="+menuId+"&menu.text="+menuText,null,function msg(json){
		$('#id').val(json.object.id);
		$('#text').textbox('setValue', json.object.text);
		$('#iconCls').textbox('setValue', json.object.iconCls);
		$('#url').textbox('setValue', json.object.url);
		$('#menuIndex').textbox('setValue', json.object.menuIndex);
		$('#menu_parentId').combotree('setValue', json.object.parentId);
		$('#menu_systemCode').combobox('setValue', json.object.systemCode);
	});
}

//------- 删除菜单 --------
function deleteMenu(){
	//获取选中的记录
	var node = $('#tt').tree('getSelected');
	if(node.children.length > 0){
		sysErrorShow('不能删除父菜单！');
		return;
	}
	if(node.id){
		var menuId = node.id;
		$.messager.confirm('删除提示', '删除菜单后，角色和菜单的配置信息将丢失。你确定要删除菜单吗?', function(r){
			if (r){
				var url ='./menu/deleteUamsResourceByResourceId.action?menu.id='+menuId;
				$.ajax({
					async : false,
					cache:false,
					type: 'POST',
					dataType : "json",
					url:url,//请求的action路径
					error: function () {//请求失败处理函数
						sysErrorShow('请求失败!');
					},success:function(data){
						if(data.success==false){
							if(data.msg == '102'){
								sysErrorShow("删除失败");
							} else if(data.msg == '104'){
								sysErrorShow("该菜单下还有资源未删除，请先删除资源！");
							} else {
								sysErrorShow(data.msg);
							}
						}else{
							window.location.reload(true);
						}
					}
				});
			}
		});
	}
	else
	{
		sysMsgShow('菜单没有id记录，请刷新重试!');
	}
}

function loadTree()
{
	$('#tt').tree({
    	url: 'sys/menusTree.action',
    	animate:true,
    	loadFilter: function(data){   
        	return data.rows;   
    	},
    	/*onLoadSuccess:function(node, data){
    		 $('#tt').tree('collapseAll');
    	},*/
    	onClick: function(node){
			//alert(node.id);  // 在用户点击的时候提示
			$("#dataGridTable").datagrid({
				url:'sys/queryResource.action',
				queryParams:{'menu.id' :node.id,
							 'menu.text' :node.text},
				method:"post"
			}); 
		},
    	onContextMenu: function(e, node){
			e.preventDefault();
			// 查找节点
			$('#tt').tree('select', node.target);
			// 显示快捷菜单
			$('#rightClickmenu').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		}
	});
}


//打开添加或修改模窗
function openDialog_addButton(){ 
	$('#saveMenu').dialog({
		closed: false,
		modal:true,
      title: "新增菜单",
      buttons: [{
          text: '确定',
          iconCls: 'icon-ok',
          handler: saveMenu
      }, {
          text: '取消',
          iconCls: 'icon-cancel',
          handler: function () {
        	  closeDialog();                    
          }
      }]
  });
}

//初始化窗口
function initDialog(){
	$('#saveMenu').dialog({
		modal: true,         	//模式窗口：窗口背景不可操作
		collapsible : true,  	//可折叠，点击窗口右上角折叠图标将内容折叠起来
		resizable : true,    	//可拖动边框大小
		onClose : function(){   //继承自panel的关闭事件
			menuSaveReset();
		}
	});
}

//关闭对话框
function closeDialog(){
	$('#saveMenu').dialog('close');
	window.bgidx = {treeNotLeafSelected:false};
}

