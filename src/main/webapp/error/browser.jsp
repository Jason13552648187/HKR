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
    
    <title>HKR | 不支持</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
	<center>
		对不起，本系统不支持IE浏览器。请更换其他浏览器以访问!<br/>
		点击<a href="ftp://192.168.1.248//%E4%AF%C0%C0%C6%F7/%B9%C8%B8%E8/">谷歌</a>
		或者<a href="ftp://192.168.1.248/%E4%AF%C0%C0%C6%F7/%BB%F0%BA%FC/">火狐</a>以下载该浏览器。
	</center>


  </body>
</html>
