/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-04-21 07:40:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsps.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/jsps/common/IE_NOT_SUPPORT.jsp", Long.valueOf(1623154106080L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");

    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>集团客户信息综合服务平台[登陆/注册]</title>\r\n");
      out.write("    <meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("    <meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("    <meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("    <meta http-equiv=\"keywords\" content=\"集团客户信息综合服务平台\">\r\n");
      out.write("    <meta http-equiv=\"description\" content=\"汉科软集团客户信息综合服务平台\">\r\n");
      out.write("\r\n");
      out.write("    <meta http-equiv = \"X-UA-Compatible\" content = \"IE=7,IE=9\" >\r\n");
      out.write("    <meta http-equiv = \"X-UA-Compatible\" content = \"IE=7,9\">\r\n");
      out.write("    <meta http-equiv = \"X-UA-Compatible\" content = \"IE=Edge,chrome=1\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE7\" />\r\n");
      out.write("    <meta http-equiv = \"X-UA-Compatible\" content = \"IE=7\" >\r\n");
      out.write("    <meta http-equiv = \"X-UA-Compatible\" content = \"IE=8\" >\r\n");
      out.write("    <meta http-equiv = \"X-UA-Compatible\" content = \"IE=edge\" >\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"jsps/user/css/reset.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"jsps/user/css/style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"jsps/layui/css/layui.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"jsps/user/css/slide.css\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"jsps/user/css/index/all.min.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"");
      out.print(request.getContextPath());
      out.write("/favicon.ico\" />\r\n");
      out.write("    ");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var userAgent = navigator.userAgent; //åå¾æµè§å¨çuserAgentå­ç¬¦ä¸²\r\n");
      out.write("    var isIE = userAgent.indexOf(\"compatible\") > -1 && userAgent.indexOf(\"MSIE\") > -1; //å¤æ­æ¯å¦IE<11æµè§å¨\r\n");
      out.write("    var isEdge = userAgent.indexOf(\"Edge\") > -1 && !isIE; //å¤æ­æ¯å¦IEçEdgeæµè§å¨\r\n");
      out.write("    var isIE11 = userAgent.indexOf(\"Trident\") > -1 || userAgent.indexOf(\"rv:11.0\") > -1;\r\n");
      out.write("    if(isIE11){\r\n");
      out.write("        window.location = \"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\";\r\n");
      out.write("    }\r\n");
      out.write("    if(isIE) {\r\n");
      out.write("        var reIE = new RegExp(\"MSIE (\\\\d+\\\\.\\\\d+);\");\r\n");
      out.write("        reIE.test(userAgent);\r\n");
      out.write("        var fIEVersion = parseFloat(RegExp[\"$1\"]);\r\n");
      out.write("        if(fIEVersion == 7 || fIEVersion == 8 || fIEVersion == 9 || fIEVersion == 10 || fIEVersion < 7) {\r\n");
      out.write("            window.location = \"");
      out.print(request.getContextPath());
      out.write("/error/browser.jsp\";\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/jsps/js/jquery-3.3.1.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/jsps/layui/layui.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<section class=\"user\">\r\n");
      out.write("    <div class=\"user_options-container\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"user_options-forms\" id=\"user_options-forms\">\r\n");
      out.write("            <div class=\"user_forms-login\">\r\n");
      out.write("                <div>\r\n");
      out.write("                    <h2 class=\"forms_title\">登录</h2>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                    <fieldset class=\"forms_fieldset\">\r\n");
      out.write("                        <div class=\"forms_field\">\r\n");
      out.write("                            <input type=\"email\" id=\"login_email\" name=\"email\" placeholder=\"邮箱\" class=\"forms_field-input\" required autofocus />\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"forms_field\">\r\n");
      out.write("                            <input type=\"password\" id=\"login_passwd\" name=\"password\" placeholder=\"密码\" class=\"forms_field-input\" required />\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </fieldset>\r\n");
      out.write("                    <div class=\"forms_buttons\">\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        <input type=\"submit\" value=\"登录\" id=\"btn_login\" class=\"forms_buttons-action\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"user_forms-signup\">\r\n");
      out.write("                <h2 class=\"forms_title\">注册</h2>\r\n");
      out.write("\r\n");
      out.write("                    <fieldset class=\"forms_fieldset\">\r\n");
      out.write("                        <div class=\"forms_field\">\r\n");
      out.write("                            <input type=\"email\" id=\"reg_email\" name=\"email\" placeholder=\"邮箱\" class=\"forms_field-input\" required onblur=\"check_email(this);\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"forms_field\">\r\n");
      out.write("                            <input type=\"password\" id=\"reg_passwd\" name=\"password\" placeholder=\"密码\" class=\"forms_field-input\" required onblur=\"check_pass(this);\" />\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"forms_field\">\r\n");
      out.write("                            <input type=\"phone\" id=\"reg_phone\" name=\"phoneNumber\" placeholder=\"手机号\" class=\"forms_field-input\" required />\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"forms_field\" id=\"slidebox\">\r\n");
      out.write("                            <div class=\"verify-wrap\" id=\"verify-wrap\" style=\"\"><div class=\"drag-progress dragProgress\"></div><span class=\"drag-btn dragBtn\"></span><span class=\"fix-tips fixTips\">请向右滑动滑块</span><span class=\"verify-msg sucMsg\">验证通过</span></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </fieldset>\r\n");
      out.write("                    <div class=\"forms_buttons\" >\r\n");
      out.write("                        <input type=\"submit\" value=\"注册\" id=\"btn_reg\" class=\"forms_buttons-action\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var layer = layui.layer;\r\n");
      out.write("    var form = layui.form;\r\n");
      out.write("\r\n");
      out.write("    var layer,laydate,form;\r\n");
      out.write("    layui.use([\"layer\",\"laydate\"],function (){\r\n");
      out.write("       layer = layui.layer;\r\n");
      out.write("       form = layui.form;\r\n");
      out.write("       laydate = layui.laydate;\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    /*滑动验证*/\r\n");
      out.write("    var res = false\r\n");
      out.write("    $(function(){\r\n");
      out.write("        var SlideVerifyPlug = window.slideVerifyPlug;\r\n");
      out.write("        var slideVerify = new SlideVerifyPlug('#verify-wrap',{\r\n");
      out.write("            wrapWidth:'100%',//设置 容器的宽度 ,不设置的话，会设置成100%，需要自己在外层包层div,设置宽度，这是为了适应方便点；\r\n");
      out.write("            initText:'请向右滑动滑块',  //设置  初始的 显示文字\r\n");
      out.write("            sucessText:'验证通过',//设置 验证通过 显示的文字\r\n");
      out.write("            getSuccessState:function(res1){\r\n");
      out.write("                //当验证完成的时候 会 返回 res 值 true，只留了这个应该够用了\r\n");
      out.write("                console.log(res1);\r\n");
      out.write("                res  = res1;\r\n");
      out.write("                if(slideVerify.slideFinishState){\r\n");
      out.write("                    $('.value').html(slideVerify.slideFinishState)\r\n");
      out.write("                    $('#resetBtn').removeClass('prohibit')\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("        $(\"#resetBtn\").on('click',function(){\r\n");
      out.write("            $('.value').html('false')\r\n");
      out.write("            $('#resetBtn').addClass('prohibit')\r\n");
      out.write("            slideVerify.resetVerify();//可以重置 插件 回到初始状态\r\n");
      out.write("        })\r\n");
      out.write("        $('#resetBtn').addClass('prohibit')\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"jsps/user/js/index.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jsps/user/js/login.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"jsps/user/js/slideVerify.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /jsps/common/IE_NOT_SUPPORT.jsp(7,27) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/error/browser.jsp");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}
