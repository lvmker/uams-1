package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

      out.write(' ');
      out.write('\r');
      out.write('\n');
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/pages/main.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("path");
      // /WEB-INF/pages/main.jsp(7,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(path);
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"resources/uams/uams.ico\" type=\"image/x-icon\" />\r\n");
      out.write("<title>UAMS</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/jquery-easyui-1.5.4/themes/default/easyui.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/jquery-easyui-1.5.4/themes/icon.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/uams/index.css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/jquery-easyui-1.5.4/jquery.min.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/jquery-easyui-1.5.4/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/jquery-easyui-1.5.4/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/uams/index.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var path = \"");
      out.print(path);
      out.write("\";\r\n");
      out.write("var basePath=\"");
      out.print(basePath);
      out.write("\";\r\n");
      out.write("var _menus = {\r\n");
      out.write("\t\t\"menus\": [\t{\r\n");
      out.write("\t\t\t\"menuid\": \"1\",\r\n");
      out.write("\t\t\t\"icon\": \"icon-user\",\r\n");
      out.write("\t\t\t\"menuname\": \"用户管理\",\r\n");
      out.write("\t\t\t\"menus\": [{\r\n");
      out.write("\t\t\t\t\"menuid\": \"11\",\r\n");
      out.write("\t\t\t\t\"menuname\": \"用户管理\",\r\n");
      out.write("\t\t\t\t\"icon\": \"icon-user\",\r\n");
      out.write("\t\t\t\t\"url\": \"user.do\"\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\t\"menuid\": \"12\",\r\n");
      out.write("\t\t\t\t\"menuname\": \"菜单管理\",\r\n");
      out.write("\t\t\t\t\"icon\": \"icon-menu\",\r\n");
      out.write("\t\t\t\t\"url\": \"menu.do\"\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\t\"menuid\": \"13\",\r\n");
      out.write("\t\t\t\t\"menuname\": \"数据管理\",\r\n");
      out.write("\t\t\t\t\"icon\": \"icon-content\",\r\n");
      out.write("\t\t\t\t\"url\": \"data.do\"\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\t\"menuid\": \"14\",\r\n");
      out.write("\t\t\t\t\"menuname\": \"角色管理\",\r\n");
      out.write("\t\t\t\t\"icon\": \"icon-group\",\r\n");
      out.write("\t\t\t\t\"url\": \"role.do\"\r\n");
      out.write("\t\t\t}]\r\n");
      out.write("\t\t},{\r\n");
      out.write("\t\t\t\"menuid\": \"2\",\r\n");
      out.write("\t\t\t\"icon\": \"icon-interface\",\r\n");
      out.write("\t\t\t\"menuname\": \"接口管理\",\r\n");
      out.write("\t\t\t\"menus\": [{\r\n");
      out.write("\t\t\t\t\"menuid\": \"21\",\r\n");
      out.write("\t\t\t\t\"menuname\": \"接口管理\",\r\n");
      out.write("\t\t\t\t\"icon\": \"icon-interface\",\r\n");
      out.write("\t\t\t\t\"url\": \"demo.html\"\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\t\"menuid\": \"22\",\r\n");
      out.write("\t\t\t\t\"menuname\": \"接口日志\",\r\n");
      out.write("\t\t\t\t\"icon\": \"icon-intflog\",\r\n");
      out.write("\t\t\t\t\"url\": \"demo.html\"\r\n");
      out.write("\t\t\t}]\r\n");
      out.write("\t\t},{\r\n");
      out.write("\t\t\t\"menuid\": \"3\",\r\n");
      out.write("\t\t\t\"icon\": \"icon-setting\",\r\n");
      out.write("\t\t\t\"menuname\": \"系统管理\",\r\n");
      out.write("\t\t\t\"menus\": [{\r\n");
      out.write("\t\t\t\t\"menuid\": \"31\",\r\n");
      out.write("\t\t\t\t\"menuname\": \"系统管理\",\r\n");
      out.write("\t\t\t\t\"icon\": \"icon-setting\",\r\n");
      out.write("\t\t\t\t\"url\": \"demo.html\"\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\t\"menuid\": \"32\",\r\n");
      out.write("\t\t\t\t\"menuname\": \"系统日志\",\r\n");
      out.write("\t\t\t\t\"icon\": \"icon-syslog\",\r\n");
      out.write("\t\t\t\t\"url\": \"demo.html\"\r\n");
      out.write("\t\t\t}]\r\n");
      out.write("\t\t}]\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("function startTime(){\r\n");
      out.write("    var today=new Date()\r\n");
      out.write("    var week=new Array(\"星期日\",\"星期一\",\"星期二\",\"星期三\",\"星期四\",\"星期五\",\"星期六\");\r\n");
      out.write("    var year=today.getFullYear()\r\n");
      out.write("    var month=today.getMonth()+1\r\n");
      out.write("    var date=today.getDate()\r\n");
      out.write("    var day=today.getDay()\r\n");
      out.write("    var h=today.getHours()\r\n");
      out.write("    var m=today.getMinutes()\r\n");
      out.write("    var s=today.getSeconds()\r\n");
      out.write("    // add a zero in front of numbers<10\r\n");
      out.write("    h=checkTime(h)\r\n");
      out.write("    m=checkTime(m)\r\n");
      out.write("    s=checkTime(s)\r\n");
      out.write("    document.getElementById('time').innerHTML=\" \"+year+\"年\"+month+\"月\"+date+\"日  \"+week[day]+\"  \"+h+\":\"+m+\":\"+s+\" \"\r\n");
      out.write("    t=setTimeout('startTime()',500)\r\n");
      out.write("   };\r\n");
      out.write("   \r\n");
      out.write("   function checkTime(i){\r\n");
      out.write("   if (i<10)  \r\n");
      out.write("     {i=\"0\" + i}\r\n");
      out.write("     return i\r\n");
      out.write("   };\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".indextab img{width:100%;height:100%;}\r\n");
      out.write(".header_bg{ display:block; clear:both; background: url(./resources/images/header.jpg) repeat-x; height:90px;}\r\n");
      out.write(".font1{ color:#a5a5a5; font-size:12px; text-shadow:#fff 1px 1px 0px}\r\n");
      out.write(".font2{ color:#221e1f; font-size:16px;}\r\n");
      out.write("</style>\r\n");
      out.write("<body class=\"easyui-layout\" data-options=\"fit:true\" onload=\"startTime()\">\r\n");
      out.write("<div region=\"north\" border=\"false\" split=\"true\" style=\"overflow: hidden; height: 85px;\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"header_bg\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/logo.png\" style=\"margin : 15px 10px 15px 5px;\" />\r\n");
      out.write("\r\n");
      out.write("<span  style=\"float:right; padding-right:20px;padding-top:55px;\" >  <b class=\"font2\">Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" </b> &nbsp;&nbsp;<label id=\"time\"></label>&nbsp;&nbsp;<a  href=\"./logout.do\" id=\"loginOut\"><b>安全退出</b></a></span>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</div>\t\r\n");
      out.write("<div region=\"west\" split=\"true\" title=\"导航菜单\" style=\"width: 200px;\">\r\n");
      out.write("\t<div id=\"nav\">\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"mainPanle\" region=\"center\" style=\"background: #eee; overflow-y:hidden\">\r\n");
      out.write("        <div id=\"tabs\" class=\"easyui-tabs\"  fit=\"true\" border=\"false\" >\r\n");
      out.write("\t\t\t<div class=\"indextab\" title=\"首页\" iconCls=\"icon-home\" data-options=\"fit:true,border:false\" >\r\n");
      out.write("\t\t\t\t<img  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/index.jpg\"></img>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
