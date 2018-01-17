package org.apache.jsp.WEB_002dINF.pages.manager.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/pages/manager/user/../../../../resources/common/page/sessionovertime.jsp");
    _jspx_dependants.add("/WEB-INF/pages/manager/user/../../../../resources/common/page/button.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String lang = (String)session.getAttribute("lang");
if(lang == null) {
	lang = "";
} else {
	lang = "_"+lang;
}
System.err.println(lang);

      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("resources/easyui/themes/ui-cupertino/easyui.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("resources/easyui/themes/icon.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("resources/css/icon.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("resources/css/uims.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("resources/easyui/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("resources/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<!-- <script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("resources/easyui/locale/easyui-lang-");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${localLang}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(".js\"></script> -->\r\n");
      out.write("<link rel=\"Shortcut Icon\" href=\"");
      out.print(basePath);
      out.write("resources/images/icons/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("<link rel=\"icon\" href=\"");
      out.print(basePath);
      out.write("resources/images/icons/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("resources/common/dataGridCellTip.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("resources/common/validate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("resources/common/json2.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\t\r\n");
      out.write("var isChrome=navigator.userAgent.toUpperCase().indexOf(\"CHROME\")>=0?true:false; \r\n");
      out.write("\t//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]\r\n");
      out.write("\tfunction msgShow(title, msgString, msgType,callback) {\r\n");
      out.write("\t\tvar interval;\r\n");
      out.write("\t\tvar timeout = 10000;\r\n");
      out.write("// \t\tinterval = setInterval(fun, 1000);\r\n");
      out.write("\t\tvar h = $('#multiQueryMessage').parent().html();\r\n");
      out.write("\t\tif (h == msgString) {\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar m = null;\r\n");
      out.write("\t\tif(callback){\r\n");
      out.write("\t\t\tm = $.messager.alert(title, msgString, msgType, callback);\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tm = $.messager.alert(title, msgString, msgType);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction fun() {\r\n");
      out.write("\t\t\t/* timeout=timeout-1000;\r\n");
      out.write("\t\t\tif (timeout==0) {\r\n");
      out.write("\t\t\t\t$('.messager-body').window('close');\r\n");
      out.write("\t\t\t\tclearInterval(interval);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$(\".panel-title\").each(function(){\r\n");
      out.write("\t\t\t\tif($(this).html().indexOf('系统提示')>=0){\r\n");
      out.write("\t\t\t\t\t$(this).text(\"\");\r\n");
      out.write("\t\t\t\t\t$(this).append(title+\"（\"+(timeout/1000)+\"秒后自动关闭）\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}); */\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//加载遮罩\r\n");
      out.write("\tfunction openMask(id)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar wrap = $(\"#\"+id);\r\n");
      out.write("\t\t$(\"<div class=\\\"datagrid-mask\\\"></div>\").css({display:\"block\",width:wrap.width(),height:wrap.height()}).appendTo(wrap); \r\n");
      out.write("\t\t$(\"<div class=\\\"datagrid-mask-msg\\\"></div>\").html('正在处理，请稍待....').appendTo(wrap).css({display:\"block\",left:(wrap.width()-$(\"div.datagrid-mask-msg\",wrap).outerWidth())/2,top:(wrap.height()-$(\"div.datagrid-mask-msg\",wrap).outerHeight())/2});\r\n");
      out.write("\t}\r\n");
      out.write("\t//关闭遮罩\r\n");
      out.write("\tfunction closeMask(id)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar wrap = $(\"#\"+id);\r\n");
      out.write("\t\twrap.find(\"div.datagrid-mask-msg\").remove();\r\n");
      out.write("\t\twrap.find(\"div.datagrid-mask\").remove();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction noSelectData(){\r\n");
      out.write("\t\tmsgShow(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction sysMsgShow(msgString){\r\n");
      out.write("\t\tmsgShow('系统提示',msgString,'info');\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction sysErrorShow(msgString,fn){\r\n");
      out.write("\t\tmsgShow('系统提示',msgString,'error',fn);\r\n");
      out.write("\t}\r\n");
      out.write("\t/**设置jquery的ajax全局请求参数 */ \r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/pages/manager/user/user.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("path");
      // /WEB-INF/pages/manager/user/user.jsp(4,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(path);
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>用户管理</title>\r\n");
      out.write("\t\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t\t<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\t\t\t.loginlogTd2{border: 1px dotted #CCCCCC;}\r\n");
      out.write("\t\t\t.loginlogTd2 td{border: 1px dotted #CCCCCC;}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/uams/user.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/easyui/datagrid-cellediting.js\"></script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"width: 100%; height: 100%;\">\r\n");
      out.write("\t\t<div id=\"toolbar\">\r\n");
      out.write("\t\t\t<table style=\"line-height: 50px;\">\r\n");
      out.write("\t\t\t\t<tr align=\"left\">\r\n");
      out.write("\t\t\t\t<td  align=\"right\" width=\"80\" >用户名：</td>\r\n");
      out.write("\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t<input name=\"user.userName\" class=\"easyui-textbox\" id=\"search_userName\" data-options=\"prompt:'模糊查询'\" style=\"width: 150px\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td  align=\"right\" width=\"80\" >真实姓名：</td>\r\n");
      out.write("\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t<input name=\"user.realName\" class=\"easyui-textbox\" id=\"search_realName\" data-options=\"prompt:'模糊查询'\" style=\"width: 150px\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t        <!-- <td width=\"100\" align=\"right\">角色：</td>\r\n");
      out.write("          \t\t<td>\r\n");
      out.write("\t\t  \t\t\t<input class=\"easyui-textbox\" value=\"\" id=\"roleName\" data-options=\"prompt:'模糊查询'\" style=\"width: 150px\"/>\r\n");
      out.write("\t\t  \t\t</td> -->\r\n");
      out.write(" \t\t        <td width=\"100\" align=\"right\">用户类型：</td>\r\n");
      out.write("          \t\t<td width=\"100\" align=\"left\" colspan=\"3\">\r\n");
      out.write("          \t\t\t<select class=\"easyui-combobox\" style=\"width:135px;\" editable=\"false\" id=\"search_userType\" data-options=\"panelHeight:'auto'\">\r\n");
      out.write("          \t\t\t\t<option value=\"\" selected =\"selected\" >------</option>\r\n");
      out.write("          \t\t\t\t<option value=\"0\">UAMS管理员</option>\r\n");
      out.write("\t        \t\t\t<option value=\"1\">华大员工</option>\r\n");
      out.write("\t        \t\t\t<option value=\"2\">外包同事</option>\r\n");
      out.write("\t        \t\t\t<option value=\"3\">外部用户</option>\r\n");
      out.write("\t        \t\t</select>\r\n");
      out.write("          \t\t</td>\r\n");
      out.write("          \t\t<!-- <td  align=\"right\" width=\"80\">系统名称：</td>\r\n");
      out.write("\t\t\t\t<td width=\"100\" align=\"left\">\t\t          \t\t\r\n");
      out.write("\t\t\t  \t\t<input class=\"easyui-combobox\" id=\"userInfoDialog_sysNameFilt\" size=\"20\" editable=\"false\" data-options=\"\r\n");
      out.write("\t\t\t          \t\t\tpanelHeight:'250',\r\n");
      out.write("\t\t\t          \t\t\tvalueField:'systemCode',\r\n");
      out.write("\t\t\t          \t\t\ttextField:'systemName',\r\n");
      out.write("\t\t\t          \t\t\turl:'./resources/findUamsResources.do',\r\n");
      out.write("\t\t\t          \t\t\tloadFilter:function(data){\r\n");
      out.write("\t\t\t          \t\t\t\treturn data.rows;\r\n");
      out.write("\t\t\t          \t\t\t},\r\n");
      out.write("\t\t\t          \t\t\tprompt:'精确查询'\"\r\n");
      out.write("\t\t\t          \t\t/>\r\n");
      out.write("\t\t        </td> -->\r\n");
      out.write("          \t</tr>\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<div style=\"margin-left: -2px; margin-right: -2px;\" class=\"toolbuttonbg\">\r\n");
      out.write("\t\t\t\t<div class=\"datagrid-btn-separator\"></div>\r\n");
      out.write("\t\t\t\t<a href=\"javascript:queryUser()\" name=\"user_query\" class=\"easyui-linkbutton\" iconCls=\"icon-search\">查询</a>\r\n");
      out.write("\t\t\t\t<div class=\"datagrid-btn-separator\"></div>\r\n");
      out.write("\t\t\t\t<a href=\"javaScript:openDialog_add();\" name=\"user_add\" style=\"float:left;\" class=\"easyui-linkbutton\" iconCls=\"icon-add\">添加</a>\r\n");
      out.write("\t\t        <div class=\"datagrid-btn-separator\"></div>\r\n");
      out.write("\t\t        <a href=\"javaScript:openDialog_edit();\" name=\"user_editor\" style=\"float:left;\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\">编辑</a>\r\n");
      out.write("\t\t        <div class=\"datagrid-btn-separator\"></div>\r\n");
      out.write("\t\t        <a href=\"javaScript:delUser();\" name=\"user_delete\" style=\"float:left;\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\">删除</a>\r\n");
      out.write("\t\t        <div class=\"datagrid-btn-separator\"></div>\r\n");
      out.write("\t\t        <a href=\"javaScript:reloadUser();\" name=\"user_refresh\" style=\"float:left;\" class=\"easyui-linkbutton\" iconCls=\"icon-reload\">刷新</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 表格 -->\r\n");
      out.write("\t\t<table id=\"dataGridTable\" toolbar=\"#toolbar\" fit=\"true\" pagination=\"true\" rownumbers=\"true\" singleSelect=\"true\" fitColumns=\"false\" striped=\"true\" url=\"");
      out.print( basePath);
      out.write("user/findUamsUsers.do\">\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t    <!-- 新增/修改表单dialog -->\r\n");
      out.write("\t    <div id=\"userInfoDialog\" iconCls=\"icon-save\" style=\"padding: 5px; width: 700px; height: 250px;\">\r\n");
      out.write("\t       <div class=\"easyui-layout\" fit=\"true\">\r\n");
      out.write("\t\t  \t<div region=\"center\" border=\"false\">\r\n");
      out.write("\t\t    \t<table class=\"fullTable\">\r\n");
      out.write("\t\t    \t<tr height=\"30\">\r\n");
      out.write("\t    \t\t\t<!-- <td width=\"100\" align=\"right\">工号：</td>\r\n");
      out.write("\t          \t\t<td width=\"100\" align=\"left\"><input type=\"text\" class=\"easyui-textbox\" id=\"workNumberInfo_out\" style=\"padding: 0px; width: 200px;\" disabled=\"true\"></input></td> -->\r\n");
      out.write("\t          \t\t<td width=\"87\" align=\"right\">用户名：</td>\r\n");
      out.write("\t          \t\t<td width=\"100\" align=\"left\"><input type=\"text\" class=\"easyui-textbox\" id=\"userInfoDialog_userName\" data-options=\"required:true,missingMessage:'该输入项为必输项'\" style=\"padding: 0px; width: 200px;\"></input></td>\r\n");
      out.write("\t        \t\r\n");
      out.write("\t    \t\t\t<td width=\"100\" align=\"right\">真实姓名：</td>\r\n");
      out.write("\t          \t\t<td width=\"100\" align=\"left\"><input type=\"text\" class=\"easyui-textbox\" id=\"userInfoDialog_realName\" data-options=\"required:true,missingMessage:'该输入项为必输项'\" style=\"padding: 0px; width: 200px;\"></input></td>\r\n");
      out.write("\t          \t</tr>\r\n");
      out.write("\t    \t\t<tr height=\"30\">\t\r\n");
      out.write("\t          \t\t<td width=\"87\" align=\"right\">性别：</td>\r\n");
      out.write("\t        \t\t<td width=\"100\" align=\"left\">\r\n");
      out.write("\t        \t\t<select class=\"easyui-combobox\" style=\"width:200px;\" editable=\"false\" id=\"userInfoDialog_userSex\" data-options=\"panelHeight:'auto'\">\r\n");
      out.write("\t        \t\t<option value=\"0\">未知</option>\r\n");
      out.write("\t        \t\t<option value=\"1\">女</option>\r\n");
      out.write("\t        \t\t<option value=\"2\">男</option>\r\n");
      out.write("\t        \t\t</select>\r\n");
      out.write("\t        \t\t</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t          \t\t<td width=\"87\" align=\"right\">用户类型：</td>\r\n");
      out.write("\t        \t\t<td width=\"100\" align=\"left\">\r\n");
      out.write("\t        \t\t<select class=\"easyui-combobox\" style=\"width:200px;\" editable=\"false\" id=\"userInfoDialog_userType\" data-options=\"panelHeight:'auto'\">\r\n");
      out.write("\t        \t\t<option value=\"0\">UAMS管理员</option>\r\n");
      out.write("        \t\t\t<option value=\"1\">华大员工</option>\r\n");
      out.write("        \t\t\t<option value=\"2\">外包同事</option>\r\n");
      out.write("        \t\t\t<option value=\"3\">外部用户</option>\r\n");
      out.write("\t        \t\t</select>\r\n");
      out.write("\t        \t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t        \t<tr height=\"30\">\r\n");
      out.write("\t          \t\t<td width=\"100\" align=\"right\">手机号码：</td>\r\n");
      out.write("\t          \t\t<td width=\"100\" align=\"left\"><input type=\"text\" class=\"easyui-textbox\" id=\"userInfoDialog_userMobile\" data-options=\"required:true,missingMessage:'该输入项为必输项'\"  style=\"padding: 0px; width: 200px;\"></input></td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t        \t\t<td width=\"100\" align=\"right\">电子邮箱：</td>\r\n");
      out.write("\t          \t\t<td width=\"200\" align=\"left\"><input type=\"text\" class=\"easyui-textbox\" id=\"userInfoDialog_userEmail\"  data-options=\"required:true,validType:'email',missingMessage:'该输入项为必输项'\" style=\"padding: 0px; width: 200px;\" ></input></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t        \t<tr height=\"30\">\t\r\n");
      out.write("\t\t\t\t\t<td width=\"87\" align=\"right\">QQ：</td>\r\n");
      out.write("\t          \t\t<td width=\"200\" align=\"left\"><input type=\"text\" class=\"easyui-textbox\" id=\"userInfoDialog_userQQ\" style=\"padding: 0px; width: 200px;\"></input></td>\r\n");
      out.write("\t          \t\t\r\n");
      out.write("\t          \t\t<td width=\"87\" align=\"right\">联系地址：</td>\r\n");
      out.write("\t          \t\t<td width=\"100\" align=\"left\"><input type=\"text\" class=\"easyui-textbox\" id=\"userInfoDialog_userAddr\" style=\"padding: 0px; width: 200px;\"></input></td>\r\n");
      out.write("\t        \t</tr>\r\n");
      out.write("\t        \t\r\n");
      out.write("\t\t\t\t<!-- <tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"tr\">系统名称:</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"easyui-combobox\" id=\"userInfoDialog_sysNameFilt\" size=\"40\" editable=\"false\" data-options=\"\r\n");
      out.write("         \t\t\tpanelHeight:'250',\r\n");
      out.write("         \t\t\tvalueField:'systemCode',\r\n");
      out.write("         \t\t\ttextField:'systemName',\r\n");
      out.write("         \t\t\turl:'./resources/findUamsResources.do',\r\n");
      out.write("         \t\t\tloadFilter:function(data){\r\n");
      out.write("         \t\t\t\treturn data.rows;\r\n");
      out.write("         \t\t\t}\"\r\n");
      out.write("         \t\t/>\r\n");
      out.write("\t\t       \t\t</td>\r\n");
      out.write("\t\t       \t\t</tr> -->\r\n");
      out.write("\t\t  \t\t\t</table>\r\n");
      out.write("\t\t  \t\t</form>\r\n");
      out.write("\t\t  \t</div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//定义校验框最长字符串的提示\r\n");
      out.write("\t$.extend($.fn.validatebox.defaults.rules, {     \r\n");
      out.write("\t    maxLength: {     \r\n");
      out.write("\t        validator: function(value, param){     \r\n");
      out.write("\t            return param[0] >= value.length;     \r\n");
      out.write("\t        },     \r\n");
      out.write("\t        message: '请输入最大{0}位字符.'    \r\n");
      out.write("\t    }     \r\n");
      out.write("\t}); \r\n");
      out.write("    //自定义表格列的宽度\r\n");
      out.write("\tvar createUserWidth=90;\r\n");
      out.write("\tvar createTimeWidth=140;\r\n");
      out.write("\tvar lastModifiedWidth=120;\r\n");
      out.write("\tvar resource='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${disabledResourceName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\tresource=resource.substring(1,resource.length-1).split(\",\");\r\n");
      out.write("\t$('a').each(function(){\r\n");
      out.write("\t\t//获得name值\r\n");
      out.write("\t\tfor(var i=0;i<resource.length;i++){\r\n");
      out.write("\t\t\tif(resource[i].trim()==$(this).attr(\"name\"))\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t//设置不可用\r\n");
      out.write("\t\t\t\t$(this).hide();\r\n");
      out.write("\t\t\t\tbreak;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$('#rightClickmenu div').each(function(){\r\n");
      out.write("\t\t//获得name值\r\n");
      out.write("\t\tfor(var i=0;i<resource.length;i++){\r\n");
      out.write("\t\t\tif(resource[i].trim()==$(this).attr(\"name\"))\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t//设置不可用\r\n");
      out.write("\t\t\t\t//$(this).attr(\"disabled\",true);\r\n");
      out.write("\t\t\t\t$(this).hide();\r\n");
      out.write("\t\t\t\tbreak;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
