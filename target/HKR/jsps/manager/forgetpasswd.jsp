<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>HKR  |  Password[修改密码]</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="汉科软,综合办公系统">
    <meta http-equiv="description" content="汉科软综合办公系统">
    <link rel="stylesheet" href="<c:url value='../user/css/register.css'/>"/>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/jsps/layui/css/layui.css">
    <script src="<%=request.getContextPath()%>/jsps/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/layui/layui.all.js"></script>

</head>

<div id="msform">

    <fieldset>
        <h2 class="fs-title">修改密码</h2>
        <input type="text" class="layui-input" name="email" id="email" placeholder="请输入绑定的邮箱" />
        <div>
            <input type="text" class="layui-input" style="width: 45%;float: left;" name="email" id="verify" placeholder="请输入验证码" />
            <button class="layui layui-btn layui-btn-fluid" style="width: 50%;float: right;" id="btn_send">发送验证码</button>
        </div>
        <input type="text" class="layui-input" name="email" id="new_pass" placeholder="新密码" />
        <input type="text" class="layui-input" name="email" id="confirm_newpass" placeholder="确认新密码" />

        <%--下一步按钮必须有next  css属性才能进行下一步--%>
        <a name="next" id="modify_passwd" class="layui layui-btn  layui-btn-danger layui-btn-fluid">修改密码</a>
    </fieldset>

</div>

<script type="text/javascript">
    var layer,form;
    $(function (){
       layer = layui.layer;
       form = layui.form;
    });
    var wait = 60;
</script>


<script src="<c:url value='../user/js/register/jquery.easing.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='../user/js/register/register.js'/>" type="text/javascript"></script>
<script src="<c:url value='../user/js/register/register_box.js'/>" type="text/javascript"></script>
<%@include file="/jsps/common/IE_NOT_SUPPORT.jsp" %>
<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>
<div style="text-align:center;clear:both">
</div>


</body>
</html>

