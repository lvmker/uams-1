package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      // /WEB-INF/pages/login.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("path");
      // /WEB-INF/pages/login.jsp(7,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
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
      out.write("<title>统一用户权限管理系统</title>\r\n");
      out.write("<link rel=\"icon\" href=\"");
      out.print(basePath);
      out.write("resources/images/icons/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/lib.css\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/home.css\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/style.css\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"sys/index/jquery-1.8.3.min.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"sys/index/DB_tabMotionBanner.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".clickColor{\r\n");
      out.write("\tcolor:#005BAC\r\n");
      out.write("}\r\n");
      out.write(".noClickColor{\r\n");
      out.write("\tcolor:#666\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\tinitForm();\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t$(\"#loginButton\").click(function(){\r\n");
      out.write("\t\tvar userNameVal = $.trim($(\".loginUsr\").val());\r\n");
      out.write("\t\tvar passVal = $.trim($(\".loginPw\").val());\r\n");
      out.write("\t\tif(userNameVal == \"\"){\r\n");
      out.write("\t\t\t$(\".loginTip\").css(\"display\",\"block\").html(\"系统提示：请输入用户名!\");\r\n");
      out.write("\t\t  }else if(passVal == \"\"){\r\n");
      out.write("\t\t\t$(\".loginTip\").css(\"display\",\"block\").html(\"系统提示：请输入密码!\");\r\n");
      out.write("\t\t  }else if(userNameVal != \"\" && passVal != \"\"){\r\n");
      out.write("\t\t\t$(\"#loginForm\").submit();\t\t  \r\n");
      out.write("\t\t }\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\".homeRegLink\").click(function(){\r\n");
      out.write("\t\t$(\"#loginForm\")[0].reset();\r\n");
      out.write("\t});\r\n");
      out.write("\t$(document).keyup(function(event){\r\n");
      out.write("\t \tif(event.keyCode ==13){\r\n");
      out.write("\t \t\t$(\"#loginButton\").trigger(\"click\");\r\n");
      out.write("\t  \t}\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("function initForm(){\r\n");
      out.write("\tsetTimeout(function(){\r\n");
      out.write("\t\t$(\".loginUsr\").val(\"\");\r\n");
      out.write("\t\t$(\".loginPw\").val(\"\");\r\n");
      out.write("\t },10);\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".header{width:100%;height:70px;margin:30px auto 12px;}\r\n");
      out.write(".footer{padding:14px;height:20px;line-height:20px;text-align:center;font-size:12px;font-family:'微软雅黑';}\r\n");
      out.write(".loginNameArea,.loginPassArea{width:254px;height:51px;position:relative;}\r\n");
      out.write(".loginNameIcon{position:absolute;left:0px;top:0px;background:url(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/icons/icon_all.png\") no-repeat 0 -628px;width:46px;height:50px;}\r\n");
      out.write(".loginPassIcon{position:absolute;left:0px;top:0px;background:url(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/icons/icon_all.png\") no-repeat 5px -673px;width:46px;height:50px;}\r\n");
      out.write(".loginVcodeIcon{position:absolute;left:0px;top:0px;background:url(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/icons/icon_vcode.png\") no-repeat 0 8px;width:46px;height:50px;}\r\n");
      out.write("input:-webkit-autofill{-webkit-box-shadow:0 0 0px 1000px #1c3547 inset;-webkit-text-fill-color:#d2d2d2;}\r\n");
      out.write("input::-webkit-input-placeholder,input:-moz-placeholder,input:-ms-input-placeholder{color:#d2d2d2;}\r\n");
      out.write("</style> \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("  <div class=\"header\">\r\n");
      out.write("    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/logo.png\" style=\"margin-left:10%;\" />\r\n");
      out.write("  </div>\r\n");
      out.write("<div class=\"loginWidget\">\r\n");
      out.write("\t<div class=\"loginBox\">\r\n");
      out.write("\t\t<div class=\"loginTip\" style=\"display:none;\"></div>\r\n");
      out.write("\t\t<div class=\"loginMaske\"></div>\r\n");
      out.write("\t\t<div class=\"login\">\r\n");
      out.write("\t\t\t<h2>登录</h2>\r\n");
      out.write("\t\t\t<form id=\"loginForm\" action=\"login.do\" method=\"post\">\r\n");
      out.write("\t\t\t\t<div class=\"loginFilds\">\r\n");
      out.write("\t\t\t\t\t <div style=\"height: 105px;\" class=\"loginFildsMask\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"loginNameArea\">\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t  <input type=\"text\" placeholder=\"用户名\" class=\"homeImage loginField loginUsr\" name=\"userName\" />\r\n");
      out.write("\t\t\t\t\t  <span class=\"loginNameIcon\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"loginPassArea\">\r\n");
      out.write("\t\t\t\t\t  <input type=\"password\" placeholder=\"密码\"  class=\"homeImage loginField loginPw\" name=\"passWord\" />\r\n");
      out.write("\t\t\t\t\t  <span class=\"loginPassIcon\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"margin: 0px 0 20px 0;\" class=\"clr\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\"  value=\"登录\" class=\"loginPost fll\" id=\"loginButton\" ></input> <a class=\"homeRegLink flr\" href=\"javascript:void(0);\">重置</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>  \r\n");
      out.write("<!--跑马banner-->\r\n");
      out.write("<div class=\"DB_tab25\">\r\n");
      out.write("\t<ul class=\"DB_bgSet\">\r\n");
      out.write("\t\t<li style=\"background:#032777 url('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/bg3.png') no-repeat center center;\"></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<ul class=\"DB_imgSet\">\r\n");
      out.write("\t\t <li>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<div class=\"DB_menuWrap\">\r\n");
      out.write("\t\t<ul class=\"DB_menuSet\">\r\n");
      out.write("\t\t\t<li><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/btn_off.png\" alt=\"\"/></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div class=\"DB_next\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/nextArrow.png\" alt=\"NEXT\"/></div>\r\n");
      out.write("\t\t<div class=\"DB_prev\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/prevArrow.png\" alt=\"PREV\"/></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\t$('.DB_tab25').DB_tabMotionBanner({\r\n");
      out.write("\t\t\tkey:'b28551',\r\n");
      out.write("\t\t\tautoRollingTime:4000,                            \r\n");
      out.write("\t\t\tbgSpeed:500,\r\n");
      out.write("\t\t\tmotion:\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tDB_1_1:{left:30,opacity:0,speed:1000,delay:500},\r\n");
      out.write("\t\t\t\tDB_1_2:{top:-30,opacity:0,speed:1000,delay:500},\r\n");
      out.write("\t\t\t\tDB_2_1:{top:30,opacity:0,speed:1000,delay:1000},\r\n");
      out.write("\t\t\t\tDB_2_2:{top:-30,opacity:0,speed:1000,delay:1000},\r\n");
      out.write("\t\t\t\tDB_3_1:{top:30,opacity:0,speed:1000,delay:1000},\r\n");
      out.write("\t\t\t\tDB_3_2:{top:-30,opacity:0,speed:1000,delay:1000},\r\n");
      out.write("\t\t\t\tend:null\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t})\r\n");
      out.write("</script>\r\n");
      out.write("<!--跑马banner-->\r\n");
      out.write("  <div class=\"footer\">\r\n");
      out.write("    Copyright © <script>document.write((new Date().getFullYear()=='2015'?'2015':('2015-'+new Date().getFullYear())));</script> BGI\r\n");
      out.write("  </div>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/pages/login.jsp(31,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ not empty errorInfo}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t$(\".loginTip\").css(\"display\",\"block\").html(\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorInfo}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\");\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
