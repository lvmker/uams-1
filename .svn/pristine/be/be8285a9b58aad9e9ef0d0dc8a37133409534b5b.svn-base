<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../resources/common/page/sessionovertime.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="path" value="<%=path%>" />
<html>
	<head>
		<title>用户管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<style type="text/css">
			.loginlogTd2{border: 1px dotted #CCCCCC;}
			.loginlogTd2 td{border: 1px dotted #CCCCCC;}
		</style>
		<script type="text/javascript" src="${path}/resources/uams/user.js"></script>
		<script type="text/javascript" src="${path}/resources/easyui/datagrid-cellediting.js"></script>
	</head>
	<body style="width: 100%; height: 100%;">
		<div id="toolbar">
			<table style="line-height: 50px;">
				<tr align="left">
				<td  align="right" width="80" >用户名：</td>
				<td >
					<input name="user.userName" class="easyui-textbox" id="search_userName" data-options="prompt:'模糊查询'" style="width: 150px" />
				</td>
				<td  align="right" width="80" >真实姓名：</td>
				<td >
					<input name="user.realName" class="easyui-textbox" id="search_realName" data-options="prompt:'模糊查询'" style="width: 150px" />
				</td>
		        <!-- <td width="100" align="right">角色：</td>
          		<td>
		  			<input class="easyui-textbox" value="" id="roleName" data-options="prompt:'模糊查询'" style="width: 150px"/>
		  		</td> -->
 		        <td width="100" align="right">用户类型：</td>
          		<td width="100" align="left" colspan="3">
          			<select class="easyui-combobox" style="width:135px;" editable="false" id="search_userType" data-options="panelHeight:'auto'">
          				<option value="" selected ="selected" >------</option>
          				<option value="0">UAMS管理员</option>
	        			<option value="1">华大员工</option>
	        			<option value="2">外包同事</option>
	        			<option value="3">外部用户</option>
	        		</select>
          		</td>
          		<!-- <td  align="right" width="80">系统名称：</td>
				<td width="100" align="left">		          		
			  		<input class="easyui-combobox" id="userInfoDialog_sysNameFilt" size="20" editable="false" data-options="
			          			panelHeight:'250',
			          			valueField:'systemCode',
			          			textField:'systemName',
			          			url:'./resources/findUamsResources.do',
			          			loadFilter:function(data){
			          				return data.rows;
			          			},
			          			prompt:'精确查询'"
			          		/>
		        </td> -->
          	</tr>	
			</table>
			<div style="margin-left: -2px; margin-right: -2px;" class="toolbuttonbg">
				<div class="datagrid-btn-separator"></div>
				<a href="javascript:queryUser()" name="user_query" class="easyui-linkbutton" iconCls="icon-search">查询</a>
				<div class="datagrid-btn-separator"></div>
				<a href="javaScript:openDialog_add();" name="user_add" style="float:left;" class="easyui-linkbutton" iconCls="icon-add">添加</a>
		        <div class="datagrid-btn-separator"></div>
		        <a href="javaScript:openDialog_edit();" name="user_editor" style="float:left;" class="easyui-linkbutton" iconCls="icon-edit">编辑</a>
		        <div class="datagrid-btn-separator"></div>
		        <a href="javaScript:delUser();" name="user_delete" style="float:left;" class="easyui-linkbutton" iconCls="icon-cancel">删除</a>
		        <div class="datagrid-btn-separator"></div>
		        <a href="javaScript:reloadUser();" name="user_refresh" style="float:left;" class="easyui-linkbutton" iconCls="icon-reload">刷新</a>
			</div>
		</div>
		<!-- 表格 -->
		<table id="dataGridTable" toolbar="#toolbar" fit="true" pagination="true" rownumbers="true" singleSelect="true" fitColumns="false" striped="true" url="<%= basePath%>user/findUamsUsers.do">
		</table>
	    <!-- 新增/修改表单dialog -->
	    <div id="userInfoDialog" iconCls="icon-save" style="padding: 5px; width: 700px; height: 250px;">
	       <div class="easyui-layout" fit="true">
		  	<div region="center" border="false">
		    	<table class="fullTable">
		    	<tr height="30">
	    			<!-- <td width="100" align="right">工号：</td>
	          		<td width="100" align="left"><input type="text" class="easyui-textbox" id="workNumberInfo_out" style="padding: 0px; width: 200px;" disabled="true"></input></td> -->
	          		<td width="87" align="right">用户名：</td>
	          		<td width="100" align="left"><input type="text" class="easyui-textbox" id="userInfoDialog_userName" data-options="required:true,missingMessage:'该输入项为必输项'" style="padding: 0px; width: 200px;"></input></td>
	        	
	    			<td width="100" align="right">真实姓名：</td>
	          		<td width="100" align="left"><input type="text" class="easyui-textbox" id="userInfoDialog_realName" data-options="required:true,missingMessage:'该输入项为必输项'" style="padding: 0px; width: 200px;"></input></td>
	          	</tr>
	    		<tr height="30">	
	          		<td width="87" align="right">性别：</td>
	        		<td width="100" align="left">
	        		<select class="easyui-combobox" style="width:200px;" editable="false" id="userInfoDialog_userSex" data-options="panelHeight:'auto'">
	        		<option value="0">未知</option>
	        		<option value="1">女</option>
	        		<option value="2">男</option>
	        		</select>
	        		</td>
				
	          		<td width="87" align="right">用户类型：</td>
	        		<td width="100" align="left">
	        		<select class="easyui-combobox" style="width:200px;" editable="false" id="userInfoDialog_userType" data-options="panelHeight:'auto'">
	        		<option value="0">UAMS管理员</option>
        			<option value="1">华大员工</option>
        			<option value="2">外包同事</option>
        			<option value="3">外部用户</option>
	        		</select>
	        		</td>
				</tr>
	        	<tr height="30">
	          		<td width="100" align="right">手机号码：</td>
	          		<td width="100" align="left"><input type="text" class="easyui-textbox" id="userInfoDialog_userMobile" data-options="required:true,missingMessage:'该输入项为必输项'"  style="padding: 0px; width: 200px;"></input></td>
				
	        		<td width="100" align="right">电子邮箱：</td>
	          		<td width="200" align="left"><input type="text" class="easyui-textbox" id="userInfoDialog_userEmail"  data-options="required:true,validType:'email',missingMessage:'该输入项为必输项'" style="padding: 0px; width: 200px;" ></input></td>
				</tr>
	        	<tr height="30">	
					<td width="87" align="right">QQ：</td>
	          		<td width="200" align="left"><input type="text" class="easyui-textbox" id="userInfoDialog_userQQ" style="padding: 0px; width: 200px;"></input></td>
	          		
	          		<td width="87" align="right">联系地址：</td>
	          		<td width="100" align="left"><input type="text" class="easyui-textbox" id="userInfoDialog_userAddr" style="padding: 0px; width: 200px;"></input></td>
	        	</tr>
	        	
				<!-- <tr>
					<td class="tr">系统名称:</td>
					<td>
						<input class="easyui-combobox" id="userInfoDialog_sysNameFilt" size="40" editable="false" data-options="
         			panelHeight:'250',
         			valueField:'systemCode',
         			textField:'systemName',
         			url:'./resources/findUamsResources.do',
         			loadFilter:function(data){
         				return data.rows;
         			}"
         		/>
		       		</td>
		       		</tr> -->
		  			</table>
		  		</form>
		  	</div>
		  </div>
	    </div>
	</body>
</html>
<%@ include file="../../../../resources/common/page/button.jsp"%>