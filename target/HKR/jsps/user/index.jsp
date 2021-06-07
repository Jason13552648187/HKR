<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2021/5/11
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>HKR  |  Employees</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="狼腾测试员,教师管理,学生管理,汉科软">
    <meta http-equiv="description" content="狼腾测试员--内部管理系统">
    <%@include file="../common/common_head.jsp"%>

</head>
  
  <body>

        hello,world!
  </body>
</html>
