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
<title>统一用户权限管理系统</title>
<link rel="icon" href="<%=basePath%>resources/images/icons/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="resources/css/lib.css" type="text/css" />
<link rel="stylesheet" href="resources/css/home.css" type="text/css" />
<link rel="stylesheet" href="resources/css/style.css" type="text/css" />
<script type="text/javascript" src="sys/index/jquery-1.8.3.min.js"></script> 
<script type="text/javascript" src="sys/index/DB_tabMotionBanner.js"></script>
<style type="text/css">
.clickColor{
	color:#005BAC
}
.noClickColor{
	color:#666
}
</style>
<script type="text/javascript">
$(function(){
	initForm();
	<c:if test="${ not empty errorInfo}">
		$(".loginTip").css("display","block").html("${errorInfo}");
	</c:if>
	$("#loginButton").click(function(){
		var userNameVal = $.trim($(".loginUsr").val());
		var passVal = $.trim($(".loginPw").val());
		if(userNameVal == ""){
			$(".loginTip").css("display","block").html("系统提示：请输入用户名!");
		  }else if(passVal == ""){
			$(".loginTip").css("display","block").html("系统提示：请输入密码!");
		  }else if(userNameVal != "" && passVal != ""){
			$("#loginForm").submit();		  
		 }
	});
	$(".homeRegLink").click(function(){
		$("#loginForm")[0].reset();
	});
	$(document).keyup(function(event){
	 	if(event.keyCode ==13){
	 		$("#loginButton").trigger("click");
	  	}
	});
});
function initForm(){
	setTimeout(function(){
		$(".loginUsr").val("");
		$(".loginPw").val("");
	 },10);	
}
</script>
<style type="text/css">
.header{width:100%;height:70px;margin:30px auto 12px;}
.footer{padding:14px;height:20px;line-height:20px;text-align:center;font-size:12px;font-family:'微软雅黑';}
.loginNameArea,.loginPassArea{width:254px;height:51px;position:relative;}
.loginNameIcon{position:absolute;left:0px;top:0px;background:url("${path}/resources/images/icons/icon_all.png") no-repeat 0 -628px;width:46px;height:50px;}
.loginPassIcon{position:absolute;left:0px;top:0px;background:url("${path}/resources/images/icons/icon_all.png") no-repeat 5px -673px;width:46px;height:50px;}
.loginVcodeIcon{position:absolute;left:0px;top:0px;background:url("${path}/resources/images/icons/icon_vcode.png") no-repeat 0 8px;width:46px;height:50px;}
input:-webkit-autofill{-webkit-box-shadow:0 0 0px 1000px #1c3547 inset;-webkit-text-fill-color:#d2d2d2;}
input::-webkit-input-placeholder,input:-moz-placeholder,input:-ms-input-placeholder{color:#d2d2d2;}
</style> 
</head>
<body>
  <div class="header">
    <img src="${path }/resources/images/logo.png" style="margin-left:10%;" />
  </div>
<div class="loginWidget">
	<div class="loginBox">
		<div class="loginTip" style="display:none;"></div>
		<div class="loginMaske"></div>
		<div class="login">
			<h2>登录</h2>
			<form id="loginForm" action="login.do" method="post">
				<div class="loginFilds">
					 <div style="height: 105px;" class="loginFildsMask"></div>
					<div class="loginNameArea">					  
					  <input type="text" placeholder="用户名" class="homeImage loginField loginUsr" name="userName" />
					  <span class="loginNameIcon"></span>
					</div>
					<div class="loginPassArea">
					  <input type="password" placeholder="密码"  class="homeImage loginField loginPw" name="passWord" />
					  <span class="loginPassIcon"></span>
					</div>
				</div>
				<div style="margin: 0px 0 20px 0;" class="clr">
					<input type="button"  value="登录" class="loginPost fll" id="loginButton" ></input> <a class="homeRegLink flr" href="javascript:void(0);">重置</a>
				</div>
			</form>
		</div>
	</div>
</div>  
<!--跑马banner-->
<div class="DB_tab25">
	<ul class="DB_bgSet">
		<li style="background:#032777 url('${path }/resources/images/bg3.png') no-repeat center center;"></li>
	</ul>
	<ul class="DB_imgSet">
		 <li>
		</li>
	
	</ul>
	<div class="DB_menuWrap">
		<ul class="DB_menuSet">
			<li><img src="${path }/resources/images/btn_off.png" alt=""/></li>
		</ul>
		<div class="DB_next"><img src="${path }/resources/images/nextArrow.png" alt="NEXT"/></div>
		<div class="DB_prev"><img src="${path }/resources/images/prevArrow.png" alt="PREV"/></div>
	</div>
</div>
<script type="text/javascript">
		$('.DB_tab25').DB_tabMotionBanner({
			key:'b28551',
			autoRollingTime:4000,                            
			bgSpeed:500,
			motion:
			{
				DB_1_1:{left:30,opacity:0,speed:1000,delay:500},
				DB_1_2:{top:-30,opacity:0,speed:1000,delay:500},
				DB_2_1:{top:30,opacity:0,speed:1000,delay:1000},
				DB_2_2:{top:-30,opacity:0,speed:1000,delay:1000},
				DB_3_1:{top:30,opacity:0,speed:1000,delay:1000},
				DB_3_2:{top:-30,opacity:0,speed:1000,delay:1000},
				end:null
			}
			
		})
</script>
<!--跑马banner-->
  <div class="footer">
    Copyright © <script>document.write((new Date().getFullYear()=='2015'?'2015':('2015-'+new Date().getFullYear())));</script> BGI
  </div>
</body>
</html>