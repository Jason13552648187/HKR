/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-02-15 01:52:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsps.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class adduser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t\t<title>新增员工信息</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/jsps/layui/css/layui.css\">\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/jsps/layui/layui.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/jsps/js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/jsps/user/js/add.js\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/jsps/common_css/scroll.css\">\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"height: 100%;\">\r\n");
      out.write("\t\t<!--表单开始-->\r\n");
      out.write("\t\t<div id=\"layform\" class=\"layui-form  layui-form-pane\"  lay-filter=\"layform\">\r\n");
      out.write("\t\t\t<fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 20px;padding:15px 30px;\">\r\n");
      out.write("\t\t\t\t<legend>员工基本信息</legend>\r\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">姓名</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"layui-input\" placeholder=\"添加后不允许修改\" name=\"username\" id=\"username\" lay-verify=\"required\" type=\"text\" autocomplete=\"off\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">身份证号</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"layui-input\" placeholder=\"添加后不允许修改\" name=\"idcard\" id=\"idcard\" lay-verify=\"required\" type=\"text\" autocomplete=\"off\" placeholder=\"\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!--下拉选项-->\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">籍贯</label>\r\n");
      out.write("\t\t\t\t\t<div  class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"layui-input\" name=\"rawaddress\" id=\"rawaddress\" lay-verify=\"required\" type=\"text\" autocomplete=\"off\" placeholder=\"居住地址\" />\r\n");
      out.write("\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t    <label class=\"layui-form-label\">民族</label>\r\n");
      out.write("\t\t\t\t    <div class=\"layui-input-inline\">\r\n");
      out.write("                        <select name=\"nationa\"  lay-filter=\"nationa\" lay-verify=\"required\" id=\"nationa\">\r\n");
      out.write("                            <option value=\"\"></option>\r\n");
      out.write("                            <option value=\"汉族\">汉族</option>\r\n");
      out.write("                            <option value=\"穿青族\">穿青族</option>\r\n");
      out.write("                            <option value=\"壮族\">壮族</option>\r\n");
      out.write("                            <option value=\"满族\">满族</option>\r\n");
      out.write("                            <option value=\"回族\">回族</option>\r\n");
      out.write("                            <option value=\"苗族\">苗族</option>\r\n");
      out.write("                            <option value=\"维吾尔族\">维吾尔族</option>\r\n");
      out.write("                            <option value=\"土家族\">土家族</option>\r\n");
      out.write("                            <option value=\"彝族\">彝族</option>\r\n");
      out.write("                            <option value=\"蒙古族\">蒙古族</option>\r\n");
      out.write("                            <option value=\"藏族\">藏族</option>\r\n");
      out.write("                            <option value=\"布依族\">布依族</option>\r\n");
      out.write("                            <option value=\"侗族\">侗族</option>\r\n");
      out.write("                            <option value=\"瑶族\">瑶族</option>\r\n");
      out.write("                            <option value=\"朝鲜族\">朝鲜族</option>\r\n");
      out.write("                            <option value=\"白族\">白族</option>\r\n");
      out.write("                            <option value=\"哈尼族\">哈尼族</option>\r\n");
      out.write("                            <option value=\"哈萨克族\">哈萨克族</option>\r\n");
      out.write("                            <option value=\"黎族\">黎族</option>\r\n");
      out.write("                            <option value=\"傣族\">傣族</option>\r\n");
      out.write("                            <option value=\"畲族\">畲族</option>\r\n");
      out.write("                            <option value=\"傈僳族\">傈僳族</option>\r\n");
      out.write("                            <option value=\"仡佬族\">仡佬族</option>\r\n");
      out.write("                            <option value=\"东乡族\">东乡族</option>\r\n");
      out.write("                            <option value=\"高山族\">高山族</option>\r\n");
      out.write("                            <option value=\"拉祜族\">拉祜族</option>\r\n");
      out.write("                            <option value=\"水族\">水族</option>\r\n");
      out.write("                            <option value=\"佤族\">佤族</option>\r\n");
      out.write("                            <option value=\"纳西族\">纳西族</option>\r\n");
      out.write("                            <option value=\"羌族\">羌族</option>\r\n");
      out.write("                            <option value=\"土族\">土族</option>\r\n");
      out.write("                            <option value=\"仫佬族\">仫佬族</option>\r\n");
      out.write("                            <option value=\"锡伯族\">锡伯族</option>\r\n");
      out.write("                            <option value=\"柯尔克孜族\">柯尔克孜族</option>\r\n");
      out.write("                            <option value=\"达斡尔族\">达斡尔族</option>\r\n");
      out.write("                            <option value=\"景颇族\">景颇族</option>\r\n");
      out.write("                            <option value=\"毛南族\">毛南族</option>\r\n");
      out.write("                            <option value=\"撒拉族\">撒拉族</option>\r\n");
      out.write("                            <option value=\"布朗族\">布朗族</option>\r\n");
      out.write("                            <option value=\"塔吉克族\">塔吉克族</option>\r\n");
      out.write("                            <option value=\"阿昌族\">阿昌族</option>\r\n");
      out.write("                            <option value=\"普米族\">普米族</option>\r\n");
      out.write("                            <option value=\"鄂温克族\">鄂温克族</option>\r\n");
      out.write("                            <option value=\"怒族\">怒族</option>\r\n");
      out.write("                            <option value=\"京族\">京族</option>\r\n");
      out.write("                            <option value=\"基诺族\">基诺族</option>\r\n");
      out.write("                            <option value=\"德昂族\">德昂族</option>\r\n");
      out.write("                            <option value=\"保安族\">保安族</option>\r\n");
      out.write("                            <option value=\"俄罗斯族\">俄罗斯族</option>\r\n");
      out.write("                            <option value=\"裕固族\">裕固族</option>\r\n");
      out.write("                            <option value=\"乌孜别克族\">乌孜别克族</option>\r\n");
      out.write("                            <option value=\"门巴族\">门巴族</option>\r\n");
      out.write("                            <option value=\"鄂伦春族\">鄂伦春族</option>\r\n");
      out.write("                            <option value=\"独龙族\">独龙族</option>\r\n");
      out.write("                            <option value=\"塔塔尔族\">塔塔尔族</option>\r\n");
      out.write("                            <option value=\"赫哲族\">赫哲族</option>\r\n");
      out.write("                            <option value=\"珞巴族\">珞巴族</option>\r\n");
      out.write("\r\n");
      out.write("                        </select>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">联系电话</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"layui-input\" name=\"phoneNumber\" id=\"phoneNumber\" lay-verify=\"required|phone\" type=\"text\" autocomplete=\"off\"  />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">邮箱</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"layui-input\" name=\"email\" id=\"email\" lay-verify=\"required|email\" type=\"text\" autocomplete=\"off\"  />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">微信号</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"layui-input\" name=\"wechat\" id=\"wechat\" type=\"text\" autocomplete=\"off\"  />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"layui-inline\">\r\n");
      out.write("                    <label class=\"layui-form-label\">来源</label>\r\n");
      out.write("                    <div class=\"layui-input-inline\">\r\n");
      out.write("\r\n");
      out.write("                        <select name=\"sourcefrom\"  lay-filter=\"sourcefrom\" lay-verify=\"required\" id=\"sourcefrom\">\r\n");
      out.write("                            <option value=\"\"></option>\r\n");
      out.write("                            <option value=\"总代理\">总代理</option>\r\n");
      out.write("                            <option value=\"宏软高科\">宏软高科</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!--基本信息结束-->\r\n");
      out.write("\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t\t <!--教育信息-->\r\n");
      out.write("\t\t\t<fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 20px;padding:15px 30px;;\">\r\n");
      out.write("  \t\t\t<legend>教育信息</legend>\r\n");
      out.write("\t\t\t <div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t \t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t \t<label class=\"layui-form-label\">毕业院校</label>\r\n");
      out.write("\t\t\t\t \t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t \t\t<input type=\"text\" name=\"school\" id=\"school\" title=\"毕业院校\" class=\"layui-input\" lay-verify=\"required\"/>\r\n");
      out.write("\t\t\t\t \t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t \t<label class=\"layui-form-label\">专业</label>\r\n");
      out.write("\t\t\t\t \t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t \t\t<input type=\"text\" name=\"professional\" id=\"professional\" title=\"所学专业\" class=\"layui-input\" lay-verify=\"required\"/>\r\n");
      out.write("\t\t\t\t \t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t \t<label class=\"layui-form-label\">毕业时间</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input  type=\"text\" readonly=\"readonly\" id=\"gradutime\" id=\"gradutime\" name=\"gradutime\" class=\"layui-input\" lay-verify=\"required\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t \t<label class=\"layui-form-label\">学历水平</label>\r\n");
      out.write("\t\t\t\t \t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t \t\t<select name=\"edulevel\" id=\"edulevel\" lay-filter=\"edulevel\" lay-verify=\"required\">\r\n");
      out.write("\t\t\t\t\t        <option value=\"\"></option>\r\n");
      out.write("\t\t\t\t\t        <option value=\"专科\">专科</option>\r\n");
      out.write("\t\t\t\t\t        <option value=\"本科\">本科</option>\r\n");
      out.write("                            <option value=\"中专\">中专</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t \t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t \t<label class=\"layui-form-label\">毕业证明人</label>\r\n");
      out.write("\t\t\t\t \t<div class=\"layui-input-inline\"  >\r\n");
      out.write("\t\t\t\t \t\t<input type=\"text\" name=\"educonfirm\" id=\"educonfirm\" class=\"layui-input\"  />\r\n");
      out.write("\t\t\t\t \t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t \t<label class=\"layui-form-label\">证明人联系方式</label>\r\n");
      out.write("\t\t\t\t \t<div class=\"layui-input-inline\"  >\r\n");
      out.write("\t\t\t\t \t\t<input type=\"text\" name=\"edutelnumber\" id=\"edutelnumber\" class=\"layui-input\"  />\r\n");
      out.write("\t\t\t\t \t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t \t\r\n");
      out.write("\t\t\t\t \t\r\n");
      out.write("\t\t\t </div>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t\t<!--历史工作信息-->\r\n");
      out.write("\t\t\t<!--公司名称、职位、工作起始日期、工作结束日期、工作任务简述-->\r\n");
      out.write("\t\t\t<fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 20px; padding:15px 30px;;\">\r\n");
      out.write("  \t\t\t<legend>以往工作信息</legend>\r\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\">公司名称</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<input  type=\"text\" class=\"layui-input\" name=\"company\" id=\"company\"  />\r\n");
      out.write("\t\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\">所在职位</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<input  type=\"text\" class=\"layui-input\" name=\"job\"  id=\"job\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\">起始日期</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<input  type=\"text\" readonly=\"readonly\" class=\"layui-input\" name=\"starttime\"  id=\"starttime\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\">结束日期</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<input  type=\"text\" readonly=\"readonly\" class=\"layui-input\" name=\"endtime\"  id=\"endtime\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-form-item layui-form-text\" style=\"width:90%\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">工作任务简述</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t<textarea name=\"workdetail\" id=\"workdetail\" class=\"layui-textarea\"></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!--以往的培训经历-->\r\n");
      out.write("            <fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 20px; padding:15px 30px;;\">\r\n");
      out.write("                <legend>以往培训记录</legend>\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <div class=\"layui-inline\">\r\n");
      out.write("                        <label class=\"layui-form-label\">公司名称</label>\r\n");
      out.write("                        <div class=\"layui-input-inline\">\r\n");
      out.write("                            <input  type=\"text\" class=\"layui-input\" name=\"tcompany\" id=\"tcompany\"  />\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"layui-inline\">\r\n");
      out.write("                        <label class=\"layui-form-label\">起始日期</label>\r\n");
      out.write("                        <div class=\"layui-input-inline\">\r\n");
      out.write("                            <input  type=\"text\" readonly=\"readonly\" class=\"layui-input\" name=\"tstarttime\"  id=\"tstarttime\" />\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"layui-inline\">\r\n");
      out.write("                        <label class=\"layui-form-label\">结束日期</label>\r\n");
      out.write("                        <div class=\"layui-input-inline\">\r\n");
      out.write("                            <input  type=\"text\" readonly=\"readonly\" class=\"layui-input\" name=\"tendtime\"  id=\"tendtime\" />\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"layui-inline\">\r\n");
      out.write("                    <label class=\"layui-form-label\">学习科目</label>\r\n");
      out.write("                    <div class=\"layui-input-inline\">\r\n");
      out.write("                        <input  type=\"text\" class=\"layui-input\" name=\"learntitle\" id=\"learntitle\"  />\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </fieldset>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!--父母联系方式-->\r\n");
      out.write("\t\t\t<fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 20px;padding:15px 30px;;\">\r\n");
      out.write("  \t\t\t<legend>父母联系方式</legend>\r\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("                <div>\r\n");
      out.write("                    <div class=\"layui-inline\">\r\n");
      out.write("                        <label class=\"layui-form-label\">联系人</label>\r\n");
      out.write("                        <div class=\"layui-input-inline\">\r\n");
      out.write("                            <input name=\"contact\"  class=\"layui-input\" lay-verify=\"required\" id=\"contact\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"layui-inline\">\r\n");
      out.write("                        <label class=\"layui-form-label\">与本人关系</label>\r\n");
      out.write("                        <div class=\"layui-input-inline\">\r\n");
      out.write("                            <select name=\"relation\" lay-filter=\"relation\" lay-verify=\"required\" id=\"relation\">\r\n");
      out.write("                                <option value=\"\"></option>\r\n");
      out.write("                                <option value=\"母亲\">母亲</option>\r\n");
      out.write("                                <option value=\"父亲\">父亲</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"layui-inline\">\r\n");
      out.write("                        <label class=\"layui-form-label\">工作单位</label>\r\n");
      out.write("                        <div class=\"layui-input-inline\">\r\n");
      out.write("                            <input name=\"unit\"  class=\"layui-input\" id=\"unit\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"layui-inline\">\r\n");
      out.write("                        <label class=\"layui-form-label\">职务</label>\r\n");
      out.write("                        <div class=\"layui-input-inline\">\r\n");
      out.write("                            <input name=\"workjob\"  class=\"layui-input\" id=\"workjob\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"layui-inline\">\r\n");
      out.write("                        <label class=\"layui-form-label\">联系电话</label>\r\n");
      out.write("                        <div class=\"layui-input-inline\">\r\n");
      out.write("                            <input name=\"telphone\"  class=\"layui-input\" lay-verify=\"required\" id=\"telphone\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t");

				if(request.getSession().getAttribute("triod").toString().equals("2")){
			
      out.write("\r\n");
      out.write("\t\t\t<fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 20px;padding:15px 30px;\">\r\n");
      out.write("\t\t\t\t<legend>员工财务状态</legend>\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\" >\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\"  style=\"width:110px;\" >目前财务状况</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"compactname\" lay-filter=\"compactname\" lay-verify=\"required\" id=\"compactname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"\"></option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"分期\">分期</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"已结清\">已结清</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"未学完\">未学完</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"违约\">违约</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t<button class=\"layui-btn\" lay-submit lay-filter=\"formDemo\">保存</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar form,layer,laydate;\r\n");
      out.write("\tfunction getNowFormatDate() {\r\n");
      out.write("\t\t\tvar date = new Date();\r\n");
      out.write("\t\t\tvar seperator1 = \"-\";\r\n");
      out.write("\t\t\tvar seperator2 = \":\";\r\n");
      out.write("\t\t\tvar month = date.getMonth() + 1;\r\n");
      out.write("\t\t\tvar strDate = date.getDate();\r\n");
      out.write("\t\t\tif (month >= 1 && month <= 9) {\r\n");
      out.write("\t\t\t\tmonth = \"0\" + month;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (strDate >= 0 && strDate <= 9) {\r\n");
      out.write("\t\t\t\tstrDate = \"0\" + strDate;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate\r\n");
      out.write("\t\t\t\t\t+ \" \" + date.getHours() + seperator2 + date.getMinutes()\r\n");
      out.write("\t\t\t\t\t+ seperator2 + date.getSeconds();\r\n");
      out.write("\t\t\treturn currentdate;\r\n");
      out.write("\t}\r\n");
      out.write("\tvar today = getNowFormatDate();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function () {\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t/*给表单注册登录事件*/\r\n");
      out.write("\t\t\tlayui.use([\"form\",\"layer\",'laydate'],function(){\r\n");
      out.write("\t\t\t\tform = layui.form;\r\n");
      out.write("\t\t\t\tlayer = layui.layer;\r\n");
      out.write("\t\t\t\tlaydate = layui.laydate;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tlaydate.render({\r\n");
      out.write("\t\t\t\t\telem:\"#gradutime\",\r\n");
      out.write("\t\t\t\t\ttype:\"date\",\r\n");
      out.write("\t\t\t\t\ttrigger:'click'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tlaydate.render({\r\n");
      out.write("\t\t\t\t\telem:\"#birthday\",\r\n");
      out.write("\t\t\t\t\ttype:\"date\",\r\n");
      out.write("\t\t\t\t\tmax:today,\r\n");
      out.write("\t\t\t\t\ttrigger:'click'\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tlaydate.render({\r\n");
      out.write("\t\t\t\t\telem:\"#starttime\",\r\n");
      out.write("\t\t\t\t\ttype:\"date\",\r\n");
      out.write("\t\t\t\t\tmax:today,\r\n");
      out.write("\t\t\t\t\ttrigger:'click'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tlaydate.render({\r\n");
      out.write("\t\t\t\t\telem:\"#endtime\",\r\n");
      out.write("\t\t\t\t\ttype:\"date\",\r\n");
      out.write("\t\t\t\t\tmax:today,\r\n");
      out.write("\t\t\t\t\ttrigger:'click'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                laydate.render({\r\n");
      out.write("                    elem:\"#tstarttime\",\r\n");
      out.write("                    type:\"date\",\r\n");
      out.write("                    max:today,\r\n");
      out.write("                    trigger:'click'\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                laydate.render({\r\n");
      out.write("                    elem:\"#tendtime\",\r\n");
      out.write("                    type:\"date\",\r\n");
      out.write("                    max:today,\r\n");
      out.write("                    trigger:'click'\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tform.on(\"submit(formDemo)\",function(data){\r\n");
      out.write("\t\t\t\t\tvar da = JSON.stringify(data.field);\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\turl:\"/HKR/teacher/addStaff\",\r\n");
      out.write("\t\t\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\t\t\tcontentType:\"application/json\",\r\n");
      out.write("\t\t\t\t\t\tasync:false,\r\n");
      out.write("\t\t\t\t\t\tdata:da,\r\n");
      out.write("\t\t\t\t\t\tsuccess:function (res) {\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(res);\r\n");
      out.write("\t\t\t\t\t\t\tif(res.success){\r\n");
      out.write("\t\t\t\t\t\t\t\tlayer.msg(\"提交成功!\")\r\n");
      out.write("\t\t\t\t\t\t\t\tvar index = parent.layer.getFrameIndex(window.name);\r\n");
      out.write("\t\t\t\t\t\t\t\tparent.layer.close(index);\r\n");
      out.write("\t\t\t\t\t\t\t\tparent.location.reload();\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\tlayer.alert(res.msg,{icon:5,title:\"错误\"});\r\n");
      out.write("\t\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\terror:function () {\r\n");
      out.write("\t\t\t\t\t\t\tlayer.alert(\"提交失败！\")\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tform.render();\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t})\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
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
}