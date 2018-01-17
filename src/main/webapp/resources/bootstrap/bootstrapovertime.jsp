<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" media="screen" href="<%=basePath%>resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" media="screen" href="<%=basePath%>resources/messenger/css/messenger.css" />
<link rel="stylesheet" media="screen" href="<%=basePath%>resources/messenger/css/messenger-theme-future.css" />
<link rel="stylesheet" media="screen" href="<%=basePath%>resources/select2/css/select2.min.css" />
<script type="text/javascript" src="<%=basePath%>resources/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/select2/js/select2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/messenger/js/messenger.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/messenger/js/messenger-theme-future.js"></script>
<%
 if(session.getAttribute("loginUser")==null){
%>
<script language="JavaScript" type="text/JavaScript">
     $(function () {
    	$("body").eq(0).html("");
    	Messenger.options = {
    		    extraClasses: 'messenger-fixed messenger-on-top',
    		    theme: 'future'
    		}
    	var msg = Messenger().post({
    		message: 'session超时,请重新登录!',
    		type:'info',
    		hideAfter:false,
    		actions: {
    			ok: {
    				label:'确定',
    				action: function() {
    					var location = (window.location+'').split('/');
    					var basePath = location[0]+'//'+location[2]+'/'+location[3];
    					window.parent.location.href=basePath;
    				}
    			}
    		}
    	});
    	var msg_work = msg.messenger.$el;
    	var win_height = document.body.clientHeight;
    	var msg_height = msg_work.height();
    	var top = (win_height - msg_height) / 2 + 'px';
    	msg.messenger.$el.css({'top':top});
    }); 
</script>
<%} else { %>
	<script language="JavaScript" type="text/JavaScript">
	Messenger.options = {
		    extraClasses: 'messenger-fixed messenger-on-top',
		    theme: 'future'
		}
	$.ajaxSetup({
		contentType:"application/x-www-form-urlencoded;charset=utf-8",
	    //timeout:5,
	    cache:false,
	    dataFilter:function(data,dataType){
	    	if(data=="9998") {
		    	Messenger.options = {
		    		    extraClasses: 'messenger-fixed messenger-on-top',
		    		    theme: 'future'
		    		}
		    	var msg = Messenger().post({
		    		message: 'session超时,请重新登录!',
		    		type:'info',
		    		hideAfter:false,
		    		actions: {
		    			ok: {
		    				label:'确定',
		    				action: function() {
		    					var location = (window.location+'').split('/');
		    					var basePath = location[0]+'//'+location[2]+'/'+location[3]+'/';
		    					window.parent.location.href=basePath;
		    				}
		    			}
		    		}
		    	});
		    	var msg_work = msg.messenger.$el;
		    	var win_height = document.body.clientHeight;
		    	var msg_height = msg_work.height();
		    	var top = (win_height - msg_height) / 2 + 'px';
		    	msg.messenger.$el.css({'top':top});
	    	}
	    	else if(data=="9999") {
		    	Messenger.options = {
		    		    extraClasses: 'messenger-fixed messenger-on-top',
		    		    theme: 'future'
		    		}
	    		var msg = Messenger().post({
	    			message: '请勿非法操作!',
	    			type:'info',
	    			showCloseButton: true,
	    			hideAfter:false
	    		});
		    	var msg_work = msg.messenger.$el;
		    	var win_height = document.body.clientHeight;
		    	var msg_height = msg_work.height();
		    	var top = (win_height - msg_height) / 2 + 'px';
		    	msg.messenger.$el.css({'top':top});
	    	}
	    	return data;
	    }
	});
	
	function msgShow(msgString, msgType ,hideAfter) {
		var ha = true;
		if (typeof(hideAfter) != 'undefined') {
			ha = (hideAfter?true:false);
		}
		var msg = Messenger().post({
			message: msgString,
			type:msgType,
			showCloseButton: true,
			ha
		});
    	var msg_work = msg.messenger.$el;
    	var win_height = document.body.clientHeight;
    	var msg_height = msg_work.height();
    	var top = (win_height - msg_height) / 2 + 'px';
    	msg.messenger.$el.css({'top':top});
	}
	</script>

<% } %>