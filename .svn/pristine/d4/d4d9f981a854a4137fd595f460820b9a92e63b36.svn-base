$(document).ready(function(){
	setDialog();
	closeDialog();
	//初始化表格
	$('#dataGridTable').datagrid({
		title:"角色管理",
		method:"get",
		dataType: 'json',
		pageSize:20,
		pageList:[10,20,30,40],
		columns:[[ 
           {field:'roleName',title:'角色名称',width:250,align:'center'}, 
//           {field:'systemName',title:'系统名称',width:100,align:'center'},
//           {field:'systemCode',title:'系统编码',width:100,align:'center'}, 
           {field:'lastModifiedUser',title:'记录最后修改者',width:lastModifiedWidth,align:'center'},
           {field:'lastModifiedTime',title:'记录最后修改时间',width:createTimeWidth,align:'center'}
         ]],
//         loadFilter: function(data){
//        	 var rows = {
//        			    "rows": [],
//        			    "total": null
//        			};
//        	 rows.rows = data.data;
//        	 console.dir(rows);
//     		return rows;
//     	}

	});	
	$('#roleName').textbox('textbox').keydown(function (e) {
	   if (e.keyCode == 13) {
		   $('#roleName').textbox('setValue', $(this).val());
		   queryRole();
	    }
	});
//	$('#roleInfoDialog_sysNameFilt').combobox({
//	    onSelect : function(rec){
//	    	queryRole();
//	    }
//	 });
});

//保存角色
function saveRole(){
	var roleId=$("#roleInfoDialog_roleId").val();
	var roleName = $("#roleInfoDialog_roleName").textbox('getValue');
//	var systemCode=$("#roleInfoDialog_sysName").combobox('getValue');
	if(roleName==null||roleName==''){
		sysMsgShow("角色名称不能为空");
		return;
	}else{
		$.ajax({
			async : false,
			cache:false,
			type: 'POST',
			dataType : "json",
			data : {
				"role.roleId" : roleId,
//				"role.systemCode" : systemCode,
				"role.roleName" : roleName
				},
			url: './role/createUamsRole.do',//请求的action路径
			error: function () {//请求失败处理函数
				sysErrorShow('角色保存失败');
			},success:function(data){
				if(data.success==true){//未返回任何消息表示添加成功
					sysMsgShow("保存成功");
					queryRole();//
					closeDialog();
				}else{//返回异常信息
					sysErrorShow(data.msg);
				}
			}
		});
	}	
}

//删除角色
function delRole(){
	if($('#dataGridTable').datagrid('getSelected')){
		var ids = [];
		var cods = [];
		var selectedRow = $('#dataGridTable').datagrid('getSelections');
		for(var i=0;i<selectedRow.length;i++){
			ids.push(selectedRow[i].roleId);
			cods.push(selectedRow[i].roleName);
		}
		var roleId = ids.join(',');
		$.messager.confirm('删除提示', '   删除角色后，它对应的用户、菜单的关系都将删除，你确定删除下列角色吗?<br/><center>'+cods.join(',')+'</center>', function(r){
				if (r){
					var url = './role/deleteUamsRoleByRoleId.do?role.roleId='+roleId;
					$.ajax({
						async : false,
						cache:false,
						type: 'post',
						dataType : "json",
						url:url,
						error: function () {
							sysErrorShow('请求失败');
						},success:function(data){
							if(data.success==true){
								sysMsgShow("删除成功!");
							}else{
								sysErrorShow(data.msg);
							}
							reloadTable();
						}
					});
				}
		});
	}
	else
	{
		noSelectData();
	}
}

//查询
function queryRole(){
	$("#dataGridTable").datagrid('reload',{		
		'role.roleName' : $("#roleName").val(),
//		'role.systemCode' : $("#roleInfoDialog_sysNameFilt").combobox("getValue")
	}); 
}

/**--------------操作模态窗------------------**/
//初始化模态窗
function setDialog(){
	$('#roleInfoDialog').dialog({
		modal: true,
		collapsible : true,
		resizable : true,
		onClose : function(){
			resetDialog();
		}
	});
}

//打开添加模窗
function openDialog_add(){
	$('#roleInfoDialog').dialog({
		closed: false,
		modal:true,
        title: "新增角色",
        height:170,
        buttons: [{
            text: '确定',
            iconCls: 'icon-ok',
            handler: saveRole
        }, {
            text: '取消',
            iconCls: 'icon-cancel',
            handler: function () {
            	$('#roleInfoDialog').dialog('close');                 
            }
        }]
    });
}

//打开编辑模窗
function openDialog_edit(){ 
	if($('#dataGridTable').datagrid('getSelected')){
		var roleId = $('#dataGridTable').datagrid('getSelections')[0].roleId;
		$.getJSON("./role/updateUamsUserByUserId.do?role.roleId="+roleId,null,
		function msg(json){
			openDialog_add();
			$("#roleInfoDialog_roleId").val(roleId);
			$("#roleInfoDialog_roleName").textbox('setValue',json.object.roleName);
//			$("#roleInfoDialog_sysName").combobox('setValue',json.object.systemCode);
			$('#roleInfoDialog').dialog('setTitle','编辑角色'); 
		});
	}
	else
	{
		noSelectData();
	}
}

//关闭模窗
function closeDialog(){
	$('#roleInfoDialog').dialog('close');
}
//清空控件值
function resetDialog(){
//	$("#roleInfoDialog_roleId").val('');
	$("#roleInfoDialog_roleId").textbox('setValue','');
	$("#roleInfoDialog_roleName").textbox('setValue','');
//	$("#roleInfoDialog_sysName").combobox('setValue','');
}
//刷新表格
function reloadTable(){
	$('#dataGridTable').datagrid('reload');
}
//刷新
function reloadRole()
{
	$("#roleName").textbox('setValue','');
//	$("#roleInfoDialog_sysNameFilt").combobox('setValue','');
	queryRole();
}
