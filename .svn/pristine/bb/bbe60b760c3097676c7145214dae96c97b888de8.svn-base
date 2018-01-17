<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../resources/common/page/sessionovertime.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="path" value="<%=path%>" />
<html>
	<head>
		<title>角色管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<style type="text/css">
			.loginlogTd2{border: 1px dotted #CCCCCC;}
			.loginlogTd2 td{border: 1px dotted #CCCCCC;}
		</style>
		<script type="text/javascript" src="${path}/resources/uams/role.js"></script>
		<script type="text/javascript" src="${path}/resources/easyui/datagrid-cellediting.js"></script>
	</head>
	<body style="width: 100%; height: 100%;">
		<div id="toolbar">
			<table style="line-height: 50px;">
				<tr align="left">
				<td  align="right" width="80" >角色名称：</td>
				<td >
					<input name="role.roleName" class="easyui-textbox" id="search_roleName" data-options="prompt:'角色名称'" style="width: 150px" />
				</td>
				<!-- <td  align="right" width="80">系统名称：</td>
				<td width="100" align="left">		          		
			  		<input class="easyui-combobox" id="roleInfoDialog_sysNameFilt" size="20" editable="false" data-options="
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
				<a href="javaScript:openDialog_add();" name="role_add" style="float:left;" class="easyui-linkbutton" iconCls="icon-add">添加</a>
		        <div class="datagrid-btn-separator"></div>
		        <a href="javaScript:openDialog_edit();" name="role_editor" style="float:left;" class="easyui-linkbutton" iconCls="icon-edit">编辑</a>
		        <div class="datagrid-btn-separator"></div>
		        <a href="javaScript:delRole();" name="role_delete" style="float:left;" class="easyui-linkbutton" iconCls="icon-cancel">删除</a>
		        <div class="datagrid-btn-separator"></div>
		        <a href="javaScript:reloadRole();" name="role_refresh" style="float:left;" class="easyui-linkbutton" iconCls="icon-reload">刷新</a>
		        <div class="datagrid-btn-separator"></div>
		        <a href="javascript:queryRole()" name="role_query" class="easyui-linkbutton" iconCls="icon-search">查询</a>
			</div>
		</div>
		<!-- 表格 -->
		<table id="dataGridTable" toolbar="#toolbar" fit="true" pagination="true" rownumbers="true" singleSelect="true" fitColumns="false" striped="true" url="<%= basePath%>role/findUamsRoles.do">
		</table>
	    <!-- 新增/修改表单dialog -->
	    <div id="roleInfoDialog" iconCls="icon-save" style="width:400px;height:200px;">
	       <div class="easyui-layout" fit="true">
		  	<div region="center" border="false" style="padding-top:15px;padding-left:20px;">
		    	<table class="fullTable">
		    			<tr>
		  					<td class="tr">角色ID:</td>
		  					<td>
		  						<input type="text" size="40" style="width: 249" class="easyui-textbox" maxlength="40" data-options="required:true,missingMessage:'该输入项为必输项'" id="roleInfoDialog_roleId" ></input>
		  						<input type="hidden" id="roleInfoDialog_roleId" value=""/>
		  					</td>
		  				</tr>
		  				<tr>
		  					<td class="tr">角色名称:</td>
		  					<td>
		  						<input type="text" size="40" style="width: 249" class="easyui-textbox" maxlength="40" data-options="required:true,missingMessage:'该输入项为必输项'" id="roleInfoDialog_roleName" ></input>
		  						<input type="hidden" id="roleInfoDialog_roleId">
		  					</td>
		  				</tr>
		  				<!-- <tr>
		  					<td class="tr">系统名称:</td>
		  					<td>
		  						<input class="easyui-combobox" id="roleInfoDialog_sysName" size="40" editable="false" data-options="
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