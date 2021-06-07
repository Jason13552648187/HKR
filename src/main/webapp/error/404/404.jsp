<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en" >
<head>
<meta charset="UTF-8">
<title>HKR  |  404</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/error/404/css/style.css">
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="狼腾测试员,教师管理,学生管理,汉科软">
  <meta http-equiv="description" content="狼腾测试员--内部管理系统">
  <%@include file="/jsps/common/common_head.jsp"%>

</head>
<body>

<div class="error">
  <span>您访问的资源没有找到！</span>
  <span>404</span>
  <span><a class="layui-btn layui-btn-normal" href="<%=request.getContextPath()%>">返回首页</a></span>
</div>

<div class="sun"></div>
<div class="clouds">
  <div></div>
  <div></div>
  <div></div>
</div>
<div class="birds"></div>
<div class="sea">
  <div class="wave w-1"></div>
  <div class="wave w-2"></div>
  <div class="fish"><span></span><span></span><span></span>
  </div>
</div>
<div class="bottom">
  <div class="grass"><span> </span><span> </span><span> </span>
  </div>
  <div class="grass"><span> </span><span> </span><span> </span>
  </div>
  <div class="grass"><span> </span><span> </span><span> </span>
  </div>
  <div class="grass"><span> </span><span> </span><span> </span>
  </div>
  <div class="circle"><span></span><span></span><span></span><span></span><span></span>
  </div>
  <div class="circle"><span></span><span></span><span></span><span></span><span></span>
  </div>
  <div class="circle"><span></span><span></span><span></span><span></span><span></span>
  </div>
  <div class="circle"><span></span><span></span><span></span><span></span><span></span>
  </div>
  <div class="grass_tw"></div>
  <div class="grass_tw"></div>
  <div class="grass_tw"></div>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>本系统只支持谷歌和火狐浏览器，请更换对应的浏览器进行使用！</p>
<p></p>
</div>
</body>
</html>