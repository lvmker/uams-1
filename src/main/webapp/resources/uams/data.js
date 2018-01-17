$(document).ready(function(){
	setDialog();
	closeDialog();
	//初始化表格
	$('#dataGridTable').datagrid({
            title:"数据管理",
    		method:"get",
    		dataType: 'json',
    		pageSize:20,
    		pageList:[10,20,30,40],
    		columns:[[ 
    		           {field:'dataName',title:'数据名称',width:250,align:'center'}, 
//	    		           {field:'systemName',title:'系统名称',width:100,align:'center'},
//	    		           {field:'systemCode',title:'系统编码',width:100,align:'center'},
    		           {field:'dataType',title:'数据类型',width:250,align:'center'}, 
    		           {field:'field',title:'Field',width:250,align:'center'}, 
    		           {field:'option',title:'Option',width:250,align:'center'} 
    		         ]]
    		      
	  });	
	$('#dataName').textbox('textbox').keydown(function (e) {
	   if (e.keyCode == 13) {
		   $('#dataName').textbox('setValue', $(this).val());
		   queryData();
	    }
	});
//	$('#dataInfoDialog_sysNameFilt').combobox({
//	    onSelect : function(rec){
//	    	queryData();
//	    }
//	 });
});

//面板配置窗口关闭标志
var portalCloseFlag = false;

//保存数据信息
function saveData(){
	var dataId=$("#dataInfoDialog_dataId").val();
	var dataName=$("#dataInfoDialog_dataName").val();
	var dataType=$("#dataInfoDialog_dataType").val();
	var field=$("#dataInfoDialog_field").val();
	var dataType=$("#dataInfoDialog_option").val();
//	var systemCode=$("#dataInfoDialog_sysName").combobox('getValue');
	if(dataName==null||dataName==''){
		sysMsgShow("用户名称不允许为空!");
		return false;
	}else{
		$.ajax({
			async : false,
			cache:false,
			type: 'post',
			dataType : "json",
			data : {
				"data.dataId" : dataId,
//				"data.systemCode" : systemCode,
				"data.dataName" : dataName,
				"data.dataType" : dataType,
				"data.field" : field,
				"data.option" : option,
			},
			url: './data/createUamsData.do',//请求的action路径
			error: function () {
				sysErrorShow('请求失败!');
			},success:function(data){
				var messgage = dataId?"修改成功!":"添加成功!";
				if(data.success==true){
					reloadTable();
					closeDialog();
				}else{
					messgage = data.msg;
				}
				sysMsgShow(messgage);
			}
		});
	
	}	
}

//删除数据
function delData(){
	if($('#dataGridTable').datagrid('getSelected')){
		var ids = [];
		var cods = [];
		var selectedRow = $('#dataGridTable').datagrid('getSelections');
		for(var i=0;i<selectedRow.length;i++){
			ids.push(selectedRow[i].dataId);
			cods.push(selectedRow[i].dataName);
		}
		var dataId = ids.join(',');
		$.messager.confirm('删除提示', '   删除该数据后，它对应的用户关系都将删除，你确定删除下列数据吗?<br/><center>'+cods.join(',')+'</center>', function(r){
				if (r){
					var url = './data/deleteUamsDataByDataId.do?data.dataId='+dataId;
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

//查询数据
function queryData(){
	$("#dataGridTable").datagrid('reload',{		
		'data.dataName' : $("#dataName").val(),
		'data.dataType' : $("#dataType").val(),
		'data.field' : $("#field").val(),
		'data.option' : $("#option").val()
//		'data.systemCode' : $("#dataInfoDialog_sysNameFilt").combobox("getValue")
		
	}); 
}

/**--------------操作弹出框------------------**/
//初始化模窗
function setDialog(){
	$('#dataInfoDialog').dialog({
		modal: true,
		collapsible : true,
		resizable : true,
		onClose : function(){
			resetDialog();
		}
	});
}

//打开添加或修改模窗
function openDialog_add(){ 
	$('#dataInfoDialog').dialog({
		closed: false,
		modal:true,
        title: "新增数据",
        buttons: [{
            text: '确定',
            iconCls: 'icon-ok',
            handler: saveData
        }, {
            text: '取消',
            iconCls: 'icon-cancel',
            handler: function () {
                $('#dataInfoDialog').dialog('close');                    
            }
        }]
    });
}

//打开编辑模窗
function openDialog_edit(){
	if($('#dataGridTable').datagrid('getSelected')){
		var dataId = $('#dataGridTable').datagrid('getSelections')[0].dataId;
		$.getJSON("./data/updateUamsDataByDataId.do?data.dataId="+dataId,null,
		function msg(json){
			openDialog_add();
			$("#dataInfoDialog_dataId").val(dataId);
			$("#dataInfoDialog_dataName").textbox('setValue',json.object.dataName);
			$("#dataInfoDialog_dataType").textbox('setValue',json.object.dataType);
			$("#dataInfoDialog_field").textbox('setValue',json.object.field);
			$("#dataInfoDialog_option").textbox('setValue',json.object.option);
//			$("#dataInfoDialog_systemCode").combobox('setValue',json.object.systemCode);
			$('#dataInfoDialog').dialog('setTitle','编辑数据'); 
		});
	}
	else
	{
		noSelectData();
	}
}


/**--------------操作弹出框------------------**/
//关闭模窗
function closeDialog(){
	$('#dataInfoDialog').dialog('close');
}

//清空控件值
function resetDialog(){
	$("#dataInfoDialog_dataId").val('');
	$("#dataInfoDialog_dataName").val('');
	$("#dataInfoDialog_dataType").val('');
	$("#dataInfoDialog_field").val('');
	$("#dataInfoDialog_option").val('');
//	$("#dataInfoDialog_dataName").textbox('setValue','');
//	$("#dataInfoDialog_systemCode").combobox('setValue','');
}

//刷新表格
function reloadTable(){
	$('#dataGridTable').datagrid('reload');
}

//刷新
function reloadData(){
	$("#dataName").textbox('setValue','');
	$("#dataType").textbox('setValue','');
	$("#field").textbox('setValue','');
	$("#option").textbox('setValue','');
//	$("#dataInfoDialog_sysNameFilt").combobox('setValue','');
	queryData();
}