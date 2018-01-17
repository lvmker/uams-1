<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../resources/common/page/sessionovertime.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>个人桌面</title>
	<script src="resources/echarts/echarts.js"></script>
	<script src="sys/desktop/instrument.js"></script>
	<style type="text/css">
		a{text-decoration:none;}
		img{border:0px;}
	</style>
	<script type="text/javascript">
		//Ajax定时刷新数据
		var InterValObj;//定时器
		var surplusTaskBoard_desktop;//剩余任务查看器数据用于刷新
		$(document).ready(function() {
			queryDesktopFileCount();
			InterValObj = window.setInterval(queryDesktopFileCount, 10*60000);//每隔10分钟刷新一次
			instrument();
			instrument2();
			instrument3.run(surplusTaskBoard_desktop);
		});
		function queryDesktopFileCount(){
			$.ajax({
				async : false,
				cache : false,
				type : 'POST',
				dataType : "json",
				data : {},
				url : 'sys/querySampleFileFordesktop.action',
				success : function(data) {
					desktop = data.object;
					$("#fileCountNum1").html(desktop.num1);
					$("#fileCountNum2").html(desktop.num2);
					$("#fileCountNum3").html(desktop.num3);
					$("#fileCountNum4").html(desktop.num4);
					$("#fileCountNum5").html(desktop.num5);
					$("#fileCountNum6").html(desktop.num6);
					$("#fileCountNum7").html(desktop.num7);
					$("#fileCountNum8").html(desktop.num8);
					$("#fileCountNum9").html(desktop.num9);
					$("#fileCountNum10").html(desktop.num10);
					surplusTaskBoard_desktop = desktop.surplusTaskBoard;
					instrument3.refresh(surplusTaskBoard_desktop);
				}
			});
		}
		//点击打开
		function openPage(id)
		{
			
		}
	</script>
</head>
<body style="overflow-x: hidden;">
	<div style="padding:16px 0px 10px 1.5%;height:auto;overflow:hidden;">
      <a href="javascript:void(0);" onclick="openPage(1)" style="position:relative;float:left;width:18%;height:65px;background:#536ed3;margin:0px 1% 9px 0px;">
        <div style="margin:4px 0px 0px 5px;color:#fff;font-family:'microsoft yahei';">今日上传</div>
        <div id="fileCountNum1" style="text-align:right;color:#fff;height:28px;line-height:28px;font-size:28px;padding-right:5px;font-family:'microsoft yahei';">0</div>
      </a>
      <a href="javascript:void(0);" onclick="openPage(2)" style="position:relative;float:left;width:18%;height:65px;background:#4FA9A9;margin:0px 1% 9px 0px;">
        <div style="margin:4px 0px 0px 5px;color:#fff;font-family:'microsoft yahei';">未完成</div>
        <div id="fileCountNum2" style="text-align:right;color:#fff;height:28px;line-height:28px;font-size:28px;padding-right:5px;font-family:'microsoft yahei';">0</div>
      </a>
      <a href="javascript:void(0);" onclick="openPage(3)" style="position:relative;float:left;width:18%;height:65px;background:#008080;margin:0px 1% 9px 0px;">
        <div style="margin:4px 0px 0px 5px;color:#fff;font-family:'microsoft yahei';">已完成</div>
        <div id="fileCountNum3" style="text-align:right;color:#fff;height:28px;line-height:28px;font-size:28px;padding-right:5px;font-family:'microsoft yahei';">0</div>
      </a>              
 	  <a href="javascript:void(0);" onclick="openPage(4)" style="position:relative;float:left;width:18%;height:65px;background:#55acee;margin:0px 1% 9px 0px;">
        <div style="margin:4px 0px 0px 5px;color:#fff;font-family:'microsoft yahei';">今日单输录入</div> 
        <div id="fileCountNum4" style="text-align:right;color:#fff;height:28px;line-height:28px;font-size:28px;padding-right:5px;font-family:'microsoft yahei';">0</div>
      </a>
      <a href="javascript:void(0);" onclick="openPage(5)" style="position:relative;float:left;width:18%;height:65px;background:#d5a6bd;margin:0px 1% 9px 0px;">
        <div style="margin:4px 0px 0px 5px;color:#fff;font-family:'microsoft yahei';">今日双输录入</div>
        <div id="fileCountNum5" style="text-align:right;color:#fff;height:28px;line-height:28px;font-size:28px;padding-right:5px;font-family:'microsoft yahei';">0</div>
      </a>
    </div>
    
    <div style="padding:0px 0px 16px 1.5%;height:auto;overflow:hidden;">
      <a href="javascript:void(0);" onclick="openPage(6)" style="position:relative;float:left;width:18%;height:65px;background:#9BCD9B;margin:0px 1% 9px 0px;">
        <div style="margin:4px 0px 0px 5px;color:#fff;font-family:'microsoft yahei';">今日新增样例</div>
        <div id="fileCountNum6" style="text-align:right;color:#fff;height:28px;line-height:28px;font-size:28px;padding-right:5px;font-family:'microsoft yahei';">0</div>
      </a>
      <a href="javascript:void(0);" onclick="openPage(7)" style="position:relative;float:left;width:18%;height:65px;background:#8B7D6B;margin:0px 1% 9px 0px;">
        <div style="margin:4px 0px 0px 5px;color:#fff;font-family:'microsoft yahei';">草稿</div>
        <div id="fileCountNum7" style="text-align:right;color:#fff;height:28px;line-height:28px;font-size:28px;padding-right:5px;font-family:'microsoft yahei';">0</div>
      </a>
      <a href="javascript:void(0);" onclick="openPage(8)" style="position:relative;float:left;width:18%;height:65px;background:#CDC673;margin:0px 1% 9px 0px;">
        <div style="margin:4px 0px 0px 5px;color:#fff;font-family:'microsoft yahei';">存疑</div>
        <div id="fileCountNum8" style="text-align:right;color:#fff;height:28px;line-height:28px;font-size:28px;padding-right:5px;font-family:'microsoft yahei';">0</div>
      </a>              
 	  <a href="javascript:void(0);" onclick="openPage(9)" style="position:relative;float:left;width:18%;height:65px;background:#CD5C5C;margin:0px 1% 9px 0px;">
        <div style="margin:4px 0px 0px 5px;color:#fff;font-family:'microsoft yahei';">已确认</div> 
        <div id="fileCountNum9" style="text-align:right;color:#fff;height:28px;line-height:28px;font-size:28px;padding-right:5px;font-family:'microsoft yahei';">0</div>
      </a>
      <a href="javascript:void(0);" onclick="openPage(10)" style="position:relative;float:left;width:18%;height:65px;background:#CDB79E;margin:0px 1% 9px 0px;">
        <div style="margin:4px 0px 0px 5px;color:#fff;font-family:'microsoft yahei';">待审核</div>
        <div id="fileCountNum10" style="text-align:right;color:#fff;height:28px;line-height:28px;font-size:28px;padding-right:5px;font-family:'microsoft yahei';">0</div>
      </a>
    </div>
    <div style="float:left;width: 60%;height: 60%;">
    	<div id="instrumentDiv" style="width: 100%;height: 100%;"></div>
    </div>
    <div style="float:right;width: 40%;height: 60%;">
    	<div id="instrumentDiv2" style="width: 100%;height: 100%;"></div>
    </div>
    <div style="width: 100%;height:400px">
    	<div id="instrumentDiv3" style="width: 100%;height: 100%;"></div>
    </div>
</body>
</html>