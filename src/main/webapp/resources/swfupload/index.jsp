<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../resources/common/page/sessionovertime.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
	<title>SWFUpload Demos - Simple Demo</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">

	<link href="<%=basePath%>resources/swfupload/css/default.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>resources/swfupload/swf/swfupload.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/swfupload/js/swfupload.queue.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/swfupload/js/fileprogress.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/swfupload/js/handlers.js"></script>
	<script type="text/javascript">
		var swfu;
		var settings;
		function setParams(actionPath,params){
			settings = getSetting();
			settings.upload_url = settings.upload_url.replace('actionPath',actionPath)+'?'+toQueryString(params);
			swfu = new SWFUpload(settings);
			queueComplete("0");
		}
		function toQueryString(obj){
			  var str = [];
			  for(var p in obj)
			    if (obj.hasOwnProperty(p)) {
			      str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			    }
			  return str.join("&");
		 }
		window.onload = function() {
			settings = getSetting();
		};
		function getSetting(){
			return {
				flash_url : "<%=basePath%>resources/swfupload/swf/swfupload.swf",
				upload_url: "<%=basePath%>actionPath;jsessionid=<%=request.getSession().getId()%>",
				file_post_name:"uploadFile",
				file_size_limit : "50 MB",
				file_types : "*.*",
				file_types_description : "All Files",
				file_upload_limit : 100,
				file_queue_limit : 0,
				custom_settings : {
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel"
				},
				debug: false,

				// Button settings
				button_placeholder_id: "spanButtonPlaceHolder",
				button_image_url: "images/swfUploadButton1.png",
				button_width: "65",
				button_height: "28",
				button_text: "选择文件",
				button_text_style: "",
				button_text_left_padding:6,
				button_text_top_padding: 6,

				// The event handler functions are defined in handlers.js
				file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,
				queue_complete_handler : queueComplete	// Queue plugin event
			};
		}
	</script>
	<style>
		.l-btn-left{margin-top: 0 !important;}
	</style>
</head>
<body>
<div id="content">
	<form id="form1"  method="post" enctype="multipart/form-data">
		<%--<p>This page demonstrates a simple usage of SWFUpload.  It uses the Queue Plugin to simplify uploading or cancelling all queued files.</p>--%>
		<span class="legend">上传队列</span>
		<div class="fieldset flash" id="fsUploadProgress" style="width:380px;height:180px; overflow:auto;margin-bottom: 15px"></div>
		<div id="divStatus">0 个文件已上传</div>
		<div style="height: 30px;float:right;">
<!-- 			<span id="spanButtonPlaceHolder"></span> -->
			<a id="btnCancel" class="easyui-linkbutton" href="javascript:void(0)" onclick="swfu.cancelQueue();"  style="margin-left: 2px; font-size: 8pt; height: 29px;">取消所有</a>
		</div>
	</form>
</div>
</body>
</html>
