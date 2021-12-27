<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>HKR  |  main</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="汉科软,综合办公系统">
    <meta http-equiv="description" content="汉科软综合办公系统">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv = "X-UA-Compatible" content = "IE=7,IE=9" >
    <meta http-equiv = "X-UA-Compatible" content = "IE=7,9">
    <meta http-equiv = "X-UA-Compatible" content = "IE=Edge,chrome=1">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=7" >
    <meta http-equiv = "X-UA-Compatible" content = "IE=8" >
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge" >
    <link rel="stylesheet" href="<%=request.getContextPath()%>/jsps/layui/css/layui.css">

    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/layui/layui.js"></script>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/jsps/font-awesome-4.7.0/css/font-awesome.min.css">
    <%@include file="../common/common_head.jsp"%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/user/js/add.js"></script>
</head>
<body class="layui-layout-body">
    <script type="text/javascript">
        var layer,form,element,table,dropdown;
        $(function(){
            layer=layui.layer;
            form=layui.form;
            element = layui.element;
            table =  layui.table;
            dropdown = layui.dropdown;
        })
    </script>

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            <i></i>
             <strong id="user"></strong>
        </div>

       <%-- <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item">
                <a href="">左</a>
            </li>
        </ul>--%>


        <%--导航栏--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="<%=request.getContextPath()%>/teacher/loginout">退出<i class="fa fa-1x fa-power-off"></i></a>
            </li>
        </ul>
    </div>

  <%--  左侧栏--%>
    <div class="layui-side  layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">

                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="fa fa-vcard fa-lg"></i><span>员工管理 </span>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="<%=request.getContextPath()%>/jsps/user/add.jsp" target="body">
                                <i class="fa fa-lg fa-user"></i>  <span>员工信息</span>
                            </a>
                        </dd>
<%--
                        <dd>
                            <a href="javascript:;"  id="selectUser" target="body">查询员工信息</a>
                        </dd>--%>
                    </dl>
                </li>

            </ul>
        </div>
    </div>
    <%--左侧栏结束 --%>

   <div class="layui-body" id="table">

       <iframe src="<%=request.getContextPath()%>/jsps/user/welcome.html" name="body" width="100%" height="100%" frameborder="0"></iframe>

    </div>

   <%--<div class="layui-footer">
        <!-- 底部固定区域 -->
        <center>
            Copyright © 2021 All rights reserved.版权所有汉科软（北京）科技有限公司 ICP备案号：京ICP备17063260号-1
        </center>
    </div>--%>
</div>

<script>
    var uname =  getCookie("username");
    if(uname == null || uname.length == 0 || uname === ""){
        window.location = "/HKR"
    }else{
        $("#user").text(uname);
    }
    function getCookie(name)
    {
        var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
        if(arr=document.cookie.match(reg))

            return decodeURI(arr[2]);
        else
            return null;
    }
    //JavaScript代码区域
    layui.use('element', function() {
        var element = layui.element;
    });




</script>

    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/user/js/main.js"></script>
</body>

</html>
