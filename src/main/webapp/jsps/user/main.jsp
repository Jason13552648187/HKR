<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>HKR  |  Employees[员工]</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="狼腾测试员,教师管理,学生管理,汉科软">
    <meta http-equiv="description" content="狼腾测试员--内部管理系统">
    <link rel="stylesheet" href="jsps/layui/css/layui.css">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" />
    <script src="<%=request.getContextPath()%>/jsps/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/layui/layui.js"></script>
</head>
<body>
    这是一个登陆成功页面！
</body>
</html>
