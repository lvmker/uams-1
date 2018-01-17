<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
String user_name=(String)request.getAttribute("user_name");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<title>管理平台</title>
<base href="<%=path%>"/>  

<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/easyui/themes/ui-cupertino/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/uims.css" />
<script type="text/javascript" src="<%=basePath%>resources/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/easyui/locale/easyui-lang-${localLang}.js"></script>
<link rel="Shortcut Icon" href="<%=basePath%>resources/images/icons/favicon.ico" type="image/x-icon" />
<link rel="icon" href="<%=basePath%>resources/images/icons/favicon.ico" type="image/x-icon" />
<script type="text/javascript" src="<%=basePath%>resources/common/dataGridCellTip.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/common/validate.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/common/json2.js"></script>

</head>
<script type="text/javascript">
var path = "<%=path%>";
var basePath="<%=basePath%>";
function exit(){
	alert('exit');
}
function adminInfoEditConfirm(){
	var admin_edit_window_old_pwd=$("#admin_edit_window_old_pwd").val();
	var admin_edit_window_new_pwd=$("#admin_edit_window_new_pwd").val();
	$.ajax({
		url : path + '/manager/updateAdminPwd.do',
		type : 'get',
		data: {  
			"oldPwd": admin_edit_window_old_pwd,  
			"newPwd": admin_edit_window_new_pwd
		}, 
		dataType : 'json',
		contentType : 'application/json;charset=UTF-8',
		success : function(data) {
			if(data==0){
        		$.messager.alert("错误",'原始密码错误',"error",null); 
			}else{
        		$.messager.alert("提示",'密码修改成功',"info",null); 
        		$('#admin_edit_window').window('close');
			}
		}
	});
}

</script>

<script type="text/javascript" src="<%=path%>/static/js/commonComponent.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/manager.js"></script>
 <style>
        .footer {
            width: 100%;
            text-align: center;
            line-height: 35px;
        }
</style>

	<div id="admin_edit_window" class="easyui-window" title="Window Layout" data-options="iconCls:'icon-save'" modal="true" closed="true" style="width:500px;height:200px;padding:5px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'" style="padding:10px;">
			<table align="center">
			<tr style="height:40px">
			<td style="width:120px">原密码:</td><td><input class="easyui-textbox" id="admin_edit_window_old_pwd" style="width:150;height:22px"></td>
			</tr><tr>
			<tr style="height:40px"><td style="width:50;">新密码:</td>
			<td><input class="easyui-textbox" id="admin_edit_window_new_pwd" style="width:150;height:22px"></td>
			</tr><tr style="height:20px"></tr></table>
			</div>
			<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="adminInfoEditConfirm()" style="width:80px">Ok</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="$('#admin_edit_window').window('close')" style="width:80px">Cancel</a>
			</div>
		</div>
	</div>
	
<body class="easyui-layout">
	 <div region="north" border="false" split="true" style="overflow: hidden; height: 85px;">
		<div class="header_bg"> <span class="logo"></span>
		<div class="user_conten">
		     <div class="user_head">
		        <span></span>
		        <ul class="user_wa">
		           <li class="font1">Welcome</li>
		           <li class="font2"><%=user_name%></li>
		        </ul>
		     </div>
		     <div class="user_btn_warp">
		          <a href="javascript:void(0);" class="edit_user_btn" title="编辑信息" onclick="$('#admin_edit_window').window('open')"></a>
		          <a href="javascript:void(0);" class="close_system_btn" onclick="exit();" title="退出系统"></a>
		        </div>
		  </div>
		  
		</div>
		<div class="header_shadow">
		  <div class="header_left_t"></div>
		</div>
		<div style="height: 0px; background: #A9FACD; padding: 0px;">
			<span id="windowParent">
			    <div id="myWindow"></div>
				<div id="mySubWindow"></div>
			</span>
		</div>
	</div>
	
<div region="west" split="true" title="导航菜单" style="width: 200px;">
<div id="menu_tree"></div>
</div>
<div id="mainPanle" region="center" style="overflow: hidden;">
<div id="manager_tabs" class="easyui-tabs" fit="true" border="false">
<div id="tabs_index" title="首页" style="padding:10px;overflow:hidden;">
<img src="<%=path%>/static/images/manager_welcome.jpg"></img>
</div>
</div>
</div>
</body>
</html>