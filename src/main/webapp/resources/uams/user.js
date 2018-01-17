$(document).ready(function(){
	setDialog();
	closeDialog();
	//初始化表格
	$('#dataGridTable').datagrid({
            title:"用户管理",
    		method:"get",
    		dataType: 'json',
    		pageSize:20,
    		pageList:[10,20,30,40],
    		columns:[[ 
    		            {field:'userName',title:'用户名',width:120,align:'center'}, 
    		            {field:'realName',title:'真实姓名',width:80,align:'center'},
//	    		           {field:'systemName',title:'系统名称',width:100,align:'center'},
//	    		           {field:'systemCode',title:'系统编码',width:100,align:'center'},
    		            {field:'userState',title:'员工状态',width:70,align:'center',formatter:formatUserState},
    		            {field:'userType',title:'用户类型',width:70,align:'center',formatter:formatUserType},
    		            {field:'mobileNum',title:'手机号码',width:100,align:'center'},
    		            {field:'userEmail',title:'电子邮箱',width:170,align:'center'},
    		            {field:'lastModifiedUser',title:'记录最后修改者',width:lastModifiedWidth,align:'center'},
    		            {field:'lastModifiedTime',title:'记录最后修改时间',width:createTimeWidth,align:'center'}
    		         ]]
	  });	
	$('#userName').textbox('textbox').keydown(function (e) {
	   if (e.keyCode == 13) {
		   $('#dataName').textbox('setValue', $(this).val());
		   queryUser();
	    }
	});
//	$('#dataInfoDialog_sysNameFilt').combobox({
//	    onSelect : function(rec){
//	    	queryUser();
//	    }
//	 });
});

//面板配置窗口关闭标志
var portalCloseFlag = false;

//保存信息
function saveData(){
	var userId=$("#userInfoDialog_userId").val();
	var userName=$("#userInfoDialog_userName").val();
	var realName=$("#userInfoDialog_realName").val();
	var userSex=$("#userInfoDialog_userSex").combobox('getValue');
	var userType=$("#userInfoDialog_userType").combobox('getValue');
	var userMobile=$("#userInfoDialog_userMobile").val();
	var userEmail=$("#userInfoDialog_userEmail").val();
	var userQQ=$("#userInfoDialog_userQQ").val();
	var userAddr=$("#userInfoDialog_userAddr").val();
//	var systemCode=$("#userInfoDialog_sysName").combobox('getValue');
	if(userName==null||userName==''){
		sysMsgShow("用户名称不允许为空!");
		return false;
	}else if(realName==null||realName==''){
		sysMsgShow("真实姓名不允许为空!");
		return false;
	}else if(userSex==null||userSex==''){
		sysMsgShow("性别不允许为空!");
		return false;
	}else if(userType==null||userType==''){
		sysMsgShow("类型不允许为空!");
		return false;
	}else if(userMobile==null||userMobile==''){
		sysMsgShow("手机号码不允许为空!");
		return false;
	}else if(!isMobileNum(userMobile)){
		sysMsgShow("手机号码不正确!");
		return false;
	}else if(userEmail==null||userEmail==''){
		sysMsgShow("邮箱不允许为空!");
		return false;
	}else if(!isEmail(userEmail)){
		sysMsgShow("邮箱不正确!");
		return false;
	}else{
		$.ajax({
			async : false,
			cache:false,
			type: 'post',
			dataType : "json",
			data : {
				"user.userId" : userId,
//				"user.systemCode" : systemCode,
				"user.userName" : userName,
				"user.realName" : realName,
				"user.userSex" : userSex,
				"user.userType" : userType,
				"user.userMobile" : userMobile,
				"user.userEmail" : userEmail,
				"user.userQQ" : userQQ,
				"user.userAddr" : userAddr
//				"user.userState" : userState
			},
			url: './user/createUamsUser.do',//请求的action路径
			error: function () {
				sysErrorShow('请求失败!');
			},success:function(data){
				var messgage = userId?"修改成功!":"添加成功!";
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
function delUser(){
	if($('#dataGridTable').datagrid('getSelected')){
		var ids = [];
		var cods = [];
		var selectedRow = $('#dataGridTable').datagrid('getSelections');
		for(var i=0;i<selectedRow.length;i++){
			ids.push(selectedRow[i].userId);
			cods.push(selectedRow[i].userName);
		}
		var userId = ids.join(',');
		$.messager.confirm('删除提示', '   删除该用户后，它对应的角色，菜单资源，数据关系都将删除，你确定删除下列数据吗?<br/><center>'+cods.join(',')+'</center>', function(r){
				if (r){
					var url = './user/deleteUamsUserByUserId.do?user.userId='+userId;
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
function queryUser(){
	$("#dataGridTable").datagrid('reload',{	
		'user.userName' : $("#search_userName").val(),
	 	'user.realName' : $("#search_realName").val(),
	 	'user.userType' : $("#search_userType").combobox("getValue")
//		'data.systemCode' : $("#userInfoDialog_sysNameFilt").combobox("getValue")
	}); 
}

/**--------------操作弹出框------------------**/
//初始化模窗
function setDialog(){
	$('#userInfoDialog').dialog({
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
	$('#userInfoDialog').dialog({
		closed: false,
		modal:true,
        title: "新增用户",
        buttons: [{
            text: '确定',
            iconCls: 'icon-ok',
            handler: saveData
        }, {
            text: '取消',
            iconCls: 'icon-cancel',
            handler: function () {
                $('#userInfoDialog').dialog('close');                    
            }
        }]
    });
}

//打开编辑模窗
function openDialog_edit(){
	if($('#dataGridTable').datagrid('getSelected')){
		var userId = $('#dataGridTable').datagrid('getSelections')[0].userId;
		$.getJSON("./user/updateUamsUserByUserId.do?user.userId="+userId,null,
		function msg(json){
			openDialog_add();
			$("#userInfoDialog_userId").val(userId);
			$("#userInfoDialog_dataName").textbox('setValue',json.object.dataName);
			$("#userInfoDialog_dataType").textbox('setValue',json.object.dataType);
			$("#userInfoDialog_userSex").combobox('setValue',json.object.userGender);
			$("#userInfoDialog_userType").combobox('setValue',json.object.userType);
			$("#userInfoDialog_userMobile").textbox('setValue',json.object.mobileNum);
			$("#userInfoDialog_userEmail").textbox('setValue',json.object.userEmail);
			$("#userInfoDialog_userQQ").textbox('setValue',json.object.qqNum);
			$("#userInfoDialog_userAddr").textbox('setValue',json.object.userAddress);
			$("#userState_out").combobox('setValue',json.object.userState);//更改
			
//			$("#userInfoDialog_systemCode").combobox('setValue',json.object.systemCode);
			$('#userInfoDialog').dialog('setTitle','编辑用户'); 
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
	$('#userInfoDialog').dialog('close');
}

//清空控件值
function resetDialog(){
	$("#userInfoDialog_userId").val('');
	$("#userInfoDialog_userName").textbox('setValue','');
	$("#userInfoDialog_realName").textbox('setValue','');
	$("#userInfoDialog_userSex").combobox('setValue','0');
	$("#userInfoDialog_userType").textbox('setValue','');
	$("#userInfoDialog_userEmail").textbox('setValue','');
	$("#userInfoDialog_userQQ").textbox('setValue','');
	$("#userInfoDialog_userAddr").textbox('setValue','');
	$("#userInfoDialog_userAddr").textbox('setValue','');
	$("#userInfoDialog_userState").combobox('setValue','0');
//	$("#userInfoDialog_systemCode").combobox('setValue','');
//	$('#OutUserPassword').textbox('setValue','');
//	$('#OutUserPasswordQR').textbox('setValue','');
}

//刷新表格
function reloadTable(){
	$('#dataGridTable').datagrid('reload');
}

//刷新
function reloadUser(){
	$("#dataName").textbox('setValue','');
	$("#dataType").textbox('setValue','');
	$("#field").textbox('setValue','');
	$("#option").textbox('setValue','');
//	$("#userInfoDialog_sysNameFilt").combobox('setValue','');
	queryUser();
}

function formatUserType(value,row){
	var userType = row.userType;
	if(userType){
		switch (userType) {
		case '0': return 'UAMS管理员';
		case '1': return '华大员工';
		case '2': return '外包同事';
		case '3': return '外部用户';
		}
	}
	return '';
}

function formatUserState(value,row){
	var userState = row.userState;
	return (userState=='0'?'离职':(userState=='1'?'在职':''));
}

//判断手机
function isMobileNum(str) {
	var re = /^(((13[0-9]{1})|(17[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	if(re.test(str)){
		return re.test(str);
	} else {
		re = /^(010|021|022|023|024|025|026|027|028|029|852)\d{8}$/;
		return re.test(str);
	}
}
//判断邮箱
function isEmail(str) {
	var re = /^([a-zA-Z0-9]+[-|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	return re.test(str);
}