<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../resources/common/page/sessionovertime.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="path" value="<%=path%>" />
<html>
  <head>
    <base href="<%=basePath%>">
    <title>菜单管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript" src="${path}/resources/uams/menu.js"></script>
	<script type="text/javascript" src="${path}/resources/uams/resource.js"></script>
  </head>
  <body class="easyui-layout">
	<div region="west" hide="true" split="true" iconCls="icon-navigation" title="菜单列表" style="width:300px;" align="left" id="west">
   		<ul id="tt" style="padding:10px;height:auto;"></ul>
	</div>
	<div id="mainPanle" region="center" title="资源列表" iconCls="icon-views">
		<div id="toolbar" style="height:auto;">
	  		<div style="margin-left: -2px;margin-right: -2px;" class="toolbuttonbg"> 
		        <a href="javaScript:openDialog_addResource();" name="resource_add" style="float:left;" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加资源</a>
		        <div class="datagrid-btn-separator"></div>
		        <a href="javaScript:openDialog_editResource();" name="resource_editor" style="float:left;" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改资源</a>
	        	<div class="datagrid-btn-separator"></div>
		        <a href="javaScript:deleteResource();" name="resource_delete" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">删除资源</a>
		    </div>
		</div>  
		<table id="dataGridTable" > </table>
	</div>
	
	<div id="rightClickmenu" class="easyui-menu" style="width:120px;">
		<div onclick="openDialog_add()" name="menu_add" data-options="iconCls:'icon-add'">添加菜单</div>
		<div onclick="openDialog_edit()" name="menu_editor" data-options="iconCls:'icon-edit'">编辑菜单</div>
		<div onclick="deleteMenu()" name="menu_delete" data-options="iconCls:'icon-remove'">删除菜单</div>
	</div>
	
	<!-- 菜单form -->
	<div id="saveMenu" iconCls="icon-save" style="width:400px;height:280px;">
	  <div class="easyui-layout" fit="true">
	  	<div region="center" border="false" style="padding: 10px;">
	  		<form action="" id="menuSaveForm">
	  		<input type="hidden" id="id" name="menu.id"/>
	  		<input type="hidden" id="saveType" />
	    	<table class="fullTable">
	    		<tr>
	          		<td class="tr">菜单名称：</td>
	          		<td><input id="text" name="menu.text" class="easyui-textbox" required="true" style="width:262px"/></td>
	        	</tr>
	    		<tr>
	          		<td class="tr">菜单图标：</td>
	          		<td><input id="iconCls" name="menu.iconCls" class="easyui-textbox" style="width:262px"/></td>
	        	</tr>
	        	<tr>
	          		<td class="tr">菜单URL：</td>
	          		<td><input id="url" name="menu.url" class="easyui-textbox" required="true" style="width:262px"/></td>
	        	</tr>
	        	<tr>
	          		<td class="tr">菜单序号：</td>
	          		<td><input id="menuIndex" name="menu.menuIndex" class="easyui-numberbox" min="0" required="true" style="width:262px"/></td>
	        	</tr>
	        	<tr>
	          		<td class="tr">父菜单：</td>
	          		<td><input id="menu_parentId" name="menu.parentId" required="true" style="width:262px"/></td>
	        	</tr>
	        	<tr>
	          		<td class="tr">系统名称：</td>
		          		<td>
		          		<input class="easyui-combobox" name="menu.systemCode" id="menu_systemCode" required="true" style="width:262px" editable="false" data-options="
		          			panelHeight:'200',
		          			valueField:'systemCode',
		          			textField:'systemName',
		          			url:'sys/findSysSystemCombo.action',
		          			loadFilter:function(data){
		          				return data.rows;
		          			}"
		          		/>
		        		</td>
	        	</tr>	        	
	  		</table>
	  		</form>
	    </div>
	  </div>
	</div>
	
	<!-- 资源form -->
	<div id="saveResource" iconCls="icon-save" style="width:400px;height:200px;">
	  <div class="easyui-layout" fit="true">
	  	<div region="center" border="false" style="padding: 10px;">
	  		<form action="" id="resourceSaveForm">
	  		<input type="hidden" id="resourceId"/>
	  		<input type="hidden" id="resourceMenuId"/>
	  		<input type="hidden" id="resourceSaveType" />
	    	<table class="fullTable">
	    		<tr>
	          		<td class="tr">资源名称：</td>
	          		<td><input id="resourceName" class="easyui-textbox" style="width:240px;" data-options="required:true,missingMessage:'该输入项为必输项'"/></td>
	        	</tr>
	        	<tr>
	          		<td class="tr">资源URL：</td>
	          		<td><input id="resourceUrl" class="easyui-textbox" style="width:240px;" data-options="required:true,missingMessage:'该输入项为必输项'"/></td>
	        	</tr>
	    		<tr>
	          		<td class="tr">资源描述：</td>
	          		<td><input id="resourceText" class="easyui-textbox" style="width:240px;"/></td>
	        	</tr>
	  		</table>
	  		</form>
	    </div>
	  </div>
	</div>
  </body>
</html>
<%@ include file="../../../../resources/common/page/button.jsp"%>