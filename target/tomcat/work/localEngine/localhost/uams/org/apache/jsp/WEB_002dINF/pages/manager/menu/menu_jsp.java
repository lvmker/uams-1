package org.apache.jsp.WEB_002dINF.pages.manager.menu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/pages/manager/menu/../../../../resources/common/page/sessionovertime.jsp");
    _jspx_dependants.add("/WEB-INF/pages/manager/menu/../../../../resources/common/page/button.jsp");
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
      // /WEB-INF/pages/manager/menu/menu.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("path");
      // /WEB-INF/pages/manager/menu/menu.jsp(4,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(path);
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    <title>菜单管理</title>\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/uams/menu.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/uams/resource.js\"></script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body class=\"easyui-layout\">\r\n");
      out.write("\t<div region=\"west\" hide=\"true\" split=\"true\" iconCls=\"icon-navigation\" title=\"菜单列表\" style=\"width:300px;\" align=\"left\" id=\"west\">\r\n");
      out.write("   \t\t<ul id=\"tt\" style=\"padding:10px;height:auto;\"></ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"mainPanle\" region=\"center\" title=\"资源列表\" iconCls=\"icon-views\">\r\n");
      out.write("\t\t<div id=\"toolbar\" style=\"height:auto;\">\r\n");
      out.write("\t  \t\t<div style=\"margin-left: -2px;margin-right: -2px;\" class=\"toolbuttonbg\"> \r\n");
      out.write("\t\t        <a href=\"javaScript:openDialog_addResource();\" name=\"resource_add\" style=\"float:left;\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\">添加资源</a>\r\n");
      out.write("\t\t        <div class=\"datagrid-btn-separator\"></div>\r\n");
      out.write("\t\t        <a href=\"javaScript:openDialog_editResource();\" name=\"resource_editor\" style=\"float:left;\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">修改资源</a>\r\n");
      out.write("\t        \t<div class=\"datagrid-btn-separator\"></div>\r\n");
      out.write("\t\t        <a href=\"javaScript:deleteResource();\" name=\"resource_delete\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" plain=\"true\">删除资源</a>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t</div>  \r\n");
      out.write("\t\t<table id=\"dataGridTable\" > </table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"rightClickmenu\" class=\"easyui-menu\" style=\"width:120px;\">\r\n");
      out.write("\t\t<div onclick=\"openDialog_add()\" name=\"menu_add\" data-options=\"iconCls:'icon-add'\">添加菜单</div>\r\n");
      out.write("\t\t<div onclick=\"openDialog_edit()\" name=\"menu_editor\" data-options=\"iconCls:'icon-edit'\">编辑菜单</div>\r\n");
      out.write("\t\t<div onclick=\"deleteMenu()\" name=\"menu_delete\" data-options=\"iconCls:'icon-remove'\">删除菜单</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 菜单form -->\r\n");
      out.write("\t<div id=\"saveMenu\" iconCls=\"icon-save\" style=\"width:400px;height:280px;\">\r\n");
      out.write("\t  <div class=\"easyui-layout\" fit=\"true\">\r\n");
      out.write("\t  \t<div region=\"center\" border=\"false\" style=\"padding: 10px;\">\r\n");
      out.write("\t  \t\t<form action=\"\" id=\"menuSaveForm\">\r\n");
      out.write("\t  \t\t<input type=\"hidden\" id=\"id\" name=\"menu.id\"/>\r\n");
      out.write("\t  \t\t<input type=\"hidden\" id=\"saveType\" />\r\n");
      out.write("\t    \t<table class=\"fullTable\">\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t          \t\t<td class=\"tr\">菜单名称：</td>\r\n");
      out.write("\t          \t\t<td><input id=\"text\" name=\"menu.text\" class=\"easyui-textbox\" required=\"true\" style=\"width:262px\"/></td>\r\n");
      out.write("\t        \t</tr>\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t          \t\t<td class=\"tr\">菜单图标：</td>\r\n");
      out.write("\t          \t\t<td><input id=\"iconCls\" name=\"menu.iconCls\" class=\"easyui-textbox\" style=\"width:262px\"/></td>\r\n");
      out.write("\t        \t</tr>\r\n");
      out.write("\t        \t<tr>\r\n");
      out.write("\t          \t\t<td class=\"tr\">菜单URL：</td>\r\n");
      out.write("\t          \t\t<td><input id=\"url\" name=\"menu.url\" class=\"easyui-textbox\" required=\"true\" style=\"width:262px\"/></td>\r\n");
      out.write("\t        \t</tr>\r\n");
      out.write("\t        \t<tr>\r\n");
      out.write("\t          \t\t<td class=\"tr\">菜单序号：</td>\r\n");
      out.write("\t          \t\t<td><input id=\"menuIndex\" name=\"menu.menuIndex\" class=\"easyui-numberbox\" min=\"0\" required=\"true\" style=\"width:262px\"/></td>\r\n");
      out.write("\t        \t</tr>\r\n");
      out.write("\t        \t<tr>\r\n");
      out.write("\t          \t\t<td class=\"tr\">父菜单：</td>\r\n");
      out.write("\t          \t\t<td><input id=\"menu_parentId\" name=\"menu.parentId\" required=\"true\" style=\"width:262px\"/></td>\r\n");
      out.write("\t        \t</tr>\r\n");
      out.write("\t        \t<tr>\r\n");
      out.write("\t          \t\t<td class=\"tr\">系统名称：</td>\r\n");
      out.write("\t\t          \t\t<td>\r\n");
      out.write("\t\t          \t\t<input class=\"easyui-combobox\" name=\"menu.systemCode\" id=\"menu_systemCode\" required=\"true\" style=\"width:262px\" editable=\"false\" data-options=\"\r\n");
      out.write("\t\t          \t\t\tpanelHeight:'200',\r\n");
      out.write("\t\t          \t\t\tvalueField:'systemCode',\r\n");
      out.write("\t\t          \t\t\ttextField:'systemName',\r\n");
      out.write("\t\t          \t\t\turl:'sys/findSysSystemCombo.action',\r\n");
      out.write("\t\t          \t\t\tloadFilter:function(data){\r\n");
      out.write("\t\t          \t\t\t\treturn data.rows;\r\n");
      out.write("\t\t          \t\t\t}\"\r\n");
      out.write("\t\t          \t\t/>\r\n");
      out.write("\t\t        \t\t</td>\r\n");
      out.write("\t        \t</tr>\t        \t\r\n");
      out.write("\t  \t\t</table>\r\n");
      out.write("\t  \t\t</form>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 资源form -->\r\n");
      out.write("\t<div id=\"saveResource\" iconCls=\"icon-save\" style=\"width:400px;height:200px;\">\r\n");
      out.write("\t  <div class=\"easyui-layout\" fit=\"true\">\r\n");
      out.write("\t  \t<div region=\"center\" border=\"false\" style=\"padding: 10px;\">\r\n");
      out.write("\t  \t\t<form action=\"\" id=\"resourceSaveForm\">\r\n");
      out.write("\t  \t\t<input type=\"hidden\" id=\"resourceId\"/>\r\n");
      out.write("\t  \t\t<input type=\"hidden\" id=\"resourceMenuId\"/>\r\n");
      out.write("\t  \t\t<input type=\"hidden\" id=\"resourceSaveType\" />\r\n");
      out.write("\t    \t<table class=\"fullTable\">\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t          \t\t<td class=\"tr\">资源名称：</td>\r\n");
      out.write("\t          \t\t<td><input id=\"resourceName\" class=\"easyui-textbox\" style=\"width:240px;\" data-options=\"required:true,missingMessage:'该输入项为必输项'\"/></td>\r\n");
      out.write("\t        \t</tr>\r\n");
      out.write("\t        \t<tr>\r\n");
      out.write("\t          \t\t<td class=\"tr\">资源URL：</td>\r\n");
      out.write("\t          \t\t<td><input id=\"resourceUrl\" class=\"easyui-textbox\" style=\"width:240px;\" data-options=\"required:true,missingMessage:'该输入项为必输项'\"/></td>\r\n");
      out.write("\t        \t</tr>\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t          \t\t<td class=\"tr\">资源描述：</td>\r\n");
      out.write("\t          \t\t<td><input id=\"resourceText\" class=\"easyui-textbox\" style=\"width:240px;\"/></td>\r\n");
      out.write("\t        \t</tr>\r\n");
      out.write("\t  \t\t</table>\r\n");
      out.write("\t  \t\t</form>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("  </body>\r\n");
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
