<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String lang = (String)session.getAttribute("lang");
if(lang == null) {
	lang = "";
} else {
	lang = "_"+lang;
}
System.err.println(lang);
%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/easyui/themes/ui-cupertino/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/uims.css" />
<script type="text/javascript" src="<%=basePath%>resources/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/easyui/jquery.easyui.min.js"></script>
<!-- <script type="text/javascript" src="<%=basePath%>resources/easyui/locale/easyui-lang-${localLang}.js"></script> -->
<link rel="Shortcut Icon" href="<%=basePath%>resources/images/icons/favicon.ico" type="image/x-icon" />
<link rel="icon" href="<%=basePath%>resources/images/icons/favicon.ico" type="image/x-icon" />
<script type="text/javascript" src="<%=basePath%>resources/common/dataGridCellTip.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/common/validate.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/common/json2.js"></script>

<script type="text/javascript">	
var isChrome=navigator.userAgent.toUpperCase().indexOf("CHROME")>=0?true:false; 
	//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
	function msgShow(title, msgString, msgType,callback) {
		var interval;
		var timeout = 10000;
// 		interval = setInterval(fun, 1000);
		var h = $('#multiQueryMessage').parent().html();
		if (h == msgString) {
			return false
		}
		var m = null;
		if(callback){
			m = $.messager.alert(title, msgString, msgType, callback);
		}else{
			m = $.messager.alert(title, msgString, msgType);
		}
		function fun() {
			/* timeout=timeout-1000;
			if (timeout==0) {
				$('.messager-body').window('close');
				clearInterval(interval);
			}
			$(".panel-title").each(function(){
				if($(this).html().indexOf('系统提示')>=0){
					$(this).text("");
					$(this).append(title+"（"+(timeout/1000)+"秒后自动关闭）");
				}
			}); */
		}
	}
	//加载遮罩
	function openMask(id)
	{
		var wrap = $("#"+id);
		$("<div class=\"datagrid-mask\"></div>").css({display:"block",width:wrap.width(),height:wrap.height()}).appendTo(wrap); 
		$("<div class=\"datagrid-mask-msg\"></div>").html('正在处理，请稍待....').appendTo(wrap).css({display:"block",left:(wrap.width()-$("div.datagrid-mask-msg",wrap).outerWidth())/2,top:(wrap.height()-$("div.datagrid-mask-msg",wrap).outerHeight())/2});
	}
	//关闭遮罩
	function closeMask(id)
	{
		var wrap = $("#"+id);
		wrap.find("div.datagrid-mask-msg").remove();
		wrap.find("div.datagrid-mask").remove();
	}
	function noSelectData(){
		msgShow("");
	}
	function sysMsgShow(msgString){
		msgShow('系统提示',msgString,'info');
	}
	function sysErrorShow(msgString,fn){
		msgShow('系统提示',msgString,'error',fn);
	}
	/**设置jquery的ajax全局请求参数 */ 
</script>
