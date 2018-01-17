<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ include file="../../resources/common/page/sessionovertime.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>个人桌面</title>
	<script src="resources/echarts/echarts.js"></script>
	<script src="sys/desktop2/desktopCount.js"></script>
	<link rel="stylesheet" type="text/css" href="sys/desktop2/desktop.css"/>
	<script type="text/javascript">
	var basePath = "<%=basePath%>";
	</script>
</head>
<body style="overflow-x: hidden;">
	<div style="height:250px;OVERFLOW-Y:hidden; OVERFLOW-X:hidden;">
<!-- 		<div class="top-bar">今日样品看板</div> -->
		<div>
			<table id="count-table" style="float:left">
			</table>
			<a href="javaScript:count();" class="easyui-linkbutton" iconCls="icon-reload" style="float:right;margin-right:90px;margin-top:20px;">刷新</a>
		</div>
	</div>
	<div style="margin-top:30px;">
		<!-- 图 -->
		<div style="width:90%;margin-top:10px;margin-bottom: 10px;" id="chartList1" >
			<div id="areaDiv" class="echartsDiv" style="width: 100%;"></div>
		</div>
		<div style="width:90%;margin-top:10px;margin-bottom: 10px;" id="chartList2">
			<div id="areaDiv2" class="echartsDiv" style="width: 100%;"></div>
		</div>
    </div>
</body>
</html>