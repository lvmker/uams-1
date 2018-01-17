<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../resources/common/page/sessionovertime.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="path" value="<%=path%>" />
<html>
	<head>
		<title>用户主数据管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<style type="text/css">
			.loginlogTd2{border: 1px dotted #CCCCCC;}
			.loginlogTd2 td{border: 1px dotted #CCCCCC;}
		</style>
		<script type="text/javascript" src="${path}/resources/uams/data.js"></script>
		<script type="text/javascript" src="${path}/resources/easyui/datagrid-cellediting.js"></script>
	</head>
	<body style="width: 100%; height: 100%;">
		<div id="toolbar">
			<table style="line-height: 50px;">
				<tr align="left">
				<td  align="right" width="80" >数据名称：</td>
				<td >
					<input name="data.dataName" class="easyui-textbox" id="search_dataName" data-options="prompt:'数据名称'" style="width: 150px" />
				</td>
				<td  align="right" width="80" >数据类型：</td>
				<td >
					<input name="data.dataType" class="easyui-textbox" id="search_dataType" data-options="prompt:'数据类型'" style="width: 150px" />
				</td>
				<td  align="right" width="80" >Field：</td>
				<td >
					<input name="data.field" class="easyui-textbox" id="search_field" data-options="prompt:'Filed字段'" style="width: 150px" />
				</td>
				<td  align="right" width="80" >Option：</td>
				<td >
					<input name="data.option" class="easyui-textbox" id="search_option" data-options="prompt:'Option字段'" style="width: 150px" />
				</td>
				<!-- <td  align="right" width="80">系统名称：</td>
				<td width="100" align="left">		          		
			  		<input class="easyui-combobox" id="dataInfoDialog_sysNameFilt" size="20" editable="false" data-options="
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
				<a href="javascript:queryData()" name="data_query" class="easyui-linkbutton" iconCls="icon-search">查询</a>
				<div class="datagrid-btn-separator"></div>
				<a href="javaScript:openDialog_add();" name="data_add" style="float:left;" class="easyui-linkbutton" iconCls="icon-add">添加</a>
		        <div class="datagrid-btn-separator"></div>
		        <a href="javaScript:openDialog_edit();" name="data_editor" style="float:left;" class="easyui-linkbutton" iconCls="icon-edit">编辑</a>
		        <div class="datagrid-btn-separator"></div>
		        <a href="javaScript:delData();" name="data_delete" style="float:left;" class="easyui-linkbutton" iconCls="icon-cancel">删除</a>
		        <div class="datagrid-btn-separator"></div>
		        <a href="javaScript:reloadData();" name="data_refresh" style="float:left;" class="easyui-linkbutton" iconCls="icon-reload">刷新</a>
			</div>
		</div>
		<!-- 表格 -->
		<table id="dataGridTable" toolbar="#toolbar" fit="true" pagination="true" rownumbers="true" singleSelect="true" fitColumns="false" striped="true" url="<%= basePath%>data/findUamsDatas.do">
		</table>
	    <!-- 新增/修改表单dialog -->
	    <div id="dataInfoDialog" iconCls="icon-save" style="width:400px;height:200px;">
	       <div class="easyui-layout" fit="true">
		  	<div region="center" border="false" style="padding-top:15px;padding-left:20px;">
		    	<table class="fullTable">
		  				<tr>
		  					<td class="tr">数据名称:</td>
		  					<td>
		  						<input type="text" size="40" style="width: 249" class="easyui-textbox" maxlength="40" data-options="required:true,missingMessage:'该输入项为必输项'" id="dataInfoDialog_dataName" ></input>
		  						<input type="hidden" id="roleInfoDialog_roleId" value=""/>
		  					</td>
		  				</tr>
		  				<tr>
		  					<td class="tr">数据类型：</td>
			          		<td>
			          			<input type="text" size="40" class="easyui-textbox" id="dataInfoDialog_dataType" maxlength="40" data-options="required:true,missingMessage:'该输入项为必输项'" id="dataInfoDialog_dataType">
		  					</td>
		  				</tr>
		  				<tr>
		  					<td class="tr">Field：</td>
			          		<td>
			          			<input type="text" size="40" class="easyui-textbox" id="dataInfoDialog_field" maxlength="40" data-options="required:true,missingMessage:'该输入项为必输项'" id="dataInfoDialog_field">
		  					</td>
		  				</tr>
		  				<tr>
		  					<td class="tr">Option：</td>
			          		<td>
			          			<input type="text" size="40" class="easyui-textbox" id="dataInfoDialog_option" maxlength="40" data-options="required:true,missingMessage:'该输入项为必输项'" id="dataInfoDialog_option">
		  					</td>
		  				</tr>
		  				<!-- <tr>
		  					<td class="tr">系统名称:</td>
		  					<td>
		  						<input class="easyui-combobox" id="dataInfoDialog_sysNameFilt" size="40" editable="false" data-options="
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