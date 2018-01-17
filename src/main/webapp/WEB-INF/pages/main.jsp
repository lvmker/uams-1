<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%> 
<c:set var="path" value="<%=path%>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="resources/uams/uams.ico" type="image/x-icon" />
<title>UAMS</title>
<link rel="stylesheet" type="text/css" href="${path}/resources/jquery-easyui-1.5.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${path}/resources/jquery-easyui-1.5.4/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${path}/resources/uams/index.css" />

<script type="text/javascript" src="${path}/resources/jquery-easyui-1.5.4/jquery.min.js"></script> 
<script type="text/javascript" src="${path}/resources/jquery-easyui-1.5.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${path}/resources/jquery-easyui-1.5.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${path}/resources/uams/index.js"></script>
</head>
<script type="text/javascript">
var path = "<%=path%>";
var basePath="<%=basePath%>";
var _menus = {
		"menus": [	{
			"menuid": "1",
			"icon": "icon-user",
			"menuname": "用户管理",
			"menus": [{
				"menuid": "11",
				"menuname": "用户管理",
				"icon": "icon-user",
				"url": "user.do"
			},{
				"menuid": "12",
				"menuname": "菜单管理",
				"icon": "icon-menu",
				"url": "menu.do"
			},{
				"menuid": "13",
				"menuname": "数据管理",
				"icon": "icon-content",
				"url": "data.do"
			},{
				"menuid": "14",
				"menuname": "角色管理",
				"icon": "icon-group",
				"url": "role.do"
			}]
		},{
			"menuid": "2",
			"icon": "icon-interface",
			"menuname": "接口管理",
			"menus": [{
				"menuid": "21",
				"menuname": "接口管理",
				"icon": "icon-interface",
				"url": "demo.html"
			},{
				"menuid": "22",
				"menuname": "接口日志",
				"icon": "icon-intflog",
				"url": "demo.html"
			}]
		},{
			"menuid": "3",
			"icon": "icon-setting",
			"menuname": "系统管理",
			"menus": [{
				"menuid": "31",
				"menuname": "系统管理",
				"icon": "icon-setting",
				"url": "demo.html"
			},{
				"menuid": "32",
				"menuname": "系统日志",
				"icon": "icon-syslog",
				"url": "demo.html"
			}]
		}]
	};
	
function startTime(){
    var today=new Date()
    var week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
    var year=today.getFullYear()
    var month=today.getMonth()+1
    var date=today.getDate()
    var day=today.getDay()
    var h=today.getHours()
    var m=today.getMinutes()
    var s=today.getSeconds()
    // add a zero in front of numbers<10
    h=checkTime(h)
    m=checkTime(m)
    s=checkTime(s)
    document.getElementById('time').innerHTML=" "+year+"年"+month+"月"+date+"日  "+week[day]+"  "+h+":"+m+":"+s+" "
    t=setTimeout('startTime()',500)
   };
   
   function checkTime(i){
   if (i<10)  
     {i="0" + i}
     return i
   };
</script>
<style type="text/css">
.indextab img{width:100%;height:100%;}
.header_bg{ display:block; clear:both; background: url(./resources/images/header.jpg) repeat-x; height:90px;}
.font1{ color:#a5a5a5; font-size:12px; text-shadow:#fff 1px 1px 0px}
.font2{ color:#221e1f; font-size:16px;}
</style>
<body class="easyui-layout" data-options="fit:true" onload="startTime()">
<div region="north" border="false" split="true" style="overflow: hidden; height: 85px;">

<div class="header_bg"><img src="${path }/resources/images/logo.png" style="margin : 15px 10px 15px 5px;" />

<span  style="float:right; padding-right:20px;padding-top:55px;" >  <b class="font2">Welcome ${userName} </b> &nbsp;&nbsp;<label id="time"></label>&nbsp;&nbsp;<a  href="./logout.do" id="loginOut"><b>安全退出</b></a></span>

</div>

</div>	
<div region="west" split="true" title="导航菜单" style="width: 200px;">
	<div id="nav">		
	</div>
</div>
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div class="indextab" title="首页" iconCls="icon-home" data-options="fit:true,border:false" >
				<img  src="${path}/resources/images/index.jpg"></img>
			</div>
		</div>
</div>
</body>

</html>