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
    <meta http-equiv="keywords" content="集团客户信息综合服务平台">
    <meta http-equiv="description" content="集团客户信息综合服务平台">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv = "X-UA-Compatible" content = "IE=7,IE=9" >
    <meta http-equiv = "X-UA-Compatible" content = "IE=7,9">
    <meta http-equiv = "X-UA-Compatible" content = "IE=Edge,chrome=1">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=7" >
    <meta http-equiv = "X-UA-Compatible" content = "IE=8" >
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge" >
    <link rel="stylesheet" href="<%=request.getContextPath()%>/jsps/layui/css/layui.css">

    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/layui/layui.min.js"></script>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/jsps/font-awesome-4.7.0/css/font-awesome.min.css">
    <%@include file="../common/common_head.jsp"%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/user/js/add.js"></script>
    <style type="text/css">
        .layui-nav-tree .layui-nav-child a{
            padding: 0 36px;
        }
        *{
            line-height: 45px;
        }
        ::-webkit-scrollbar {
            width: 6px;
            height: 6px;
        }
        .layui-layer-title{
            height: 40px;
            line-height: 40px;
        }
        ::-webkit-scrollbar-button,
        ::-webkit-scrollbar-button:vertical {
            display: none;
        }
        ::-webkit-scrollbar-track,
        ::-webkit-scrollbar-track:vertical {
            background-color: black;
        }
        ::-webkit-scrollbar-track-piece {
            background-color: #f5f5f5;
        }
        ::-webkit-scrollbar-thumb,
        ::-webkit-scrollbar-thumb:vertical {
            margin-right: 10px;
            background-color: #a6a6a6;
        }
        ::-webkit-scrollbar-thumb:hover,
        ::-webkit-scrollbar-thumb:vertical:hover {
            background-color: #aaa;
        }
        ::-webkit-scrollbar-corner,
        ::-webkit-scrollbar-corner:vertical {
            background-color: #535353;
        }


    </style>
</head>
<body class="layui-layout-body">


<div class="layui-layout layui-layout-admin">
    <div class="layui-header" style="height:45px;">
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
    <div class="layui-side  layui-bg-black" style="top: 45px;">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <%--<li class="layui-nav-item layui-this">
                    <a href="javascript:;" lay-url="/index" lay-icon="true">
                        <i class="layui-icon layui-icon-home"></i>
                        <span class="layui-nav-title">主页</span>
                    </a>
                </li>--%>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="fa fa-cog"></i>
                        <span class="layui-nav-title">员工管理</span>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a data-title="员工信息" data-url="<%=request.getContextPath()%>/jsps/user/add.jsp" class="manager" target="body">
                                <span class="layui-nav-title">员工信息</span>
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

   <div class="layui-body" id="table" style="padding-bottom: 0px;top:45px;">
        <div class="layui-tab layui-tab-brief" lay-filter="box" lay-allowclose="true" style="margin:0px;">
            <ul class="layui-tab-title">

            </ul>

            <div class="layui-tab-content" style="padding:0px;">

            </div>

        </div>
<%--       <iframe src="<%=request.getContextPath()%>/jsps/user/welcome.html" name="body" width="100%" height="100%" frameborder="0"></iframe>--%>

    </div>

  <%-- <div class="layui-footer">
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
        var layer = layui.layer;
        /*element.on("tab(box)",function(data){
            layer.tips(data.index + this.innerHTML,this,{tips:3});
        });*/
        var tabs  = {

            tabAdd:function(id,url,title){
                var index = layer.load({icon:2});
                element.tabAdd('box',{
                    title:title,
                    content:'<iframe z-index="-999" data-frameid="' + id + '" scrolling="auto" frameborder="0" src="' + url + '" style="margin:auto auto;width:100%;height:100%;"></iframe>',
                    id:id
                })
                layer.close(index);
            }

        }

        $(".manager").on("click",function(){

            var dataid =  $(this);
            console.log(dataid.attr("data-id"),dataid.attr("data-url"),dataid.attr("data-title"));

            var bootlay =  $('[lay-id="' + dataid.attr("data-id") + '"]');
            if(bootlay.length != 0){
                element.tabChange('box',dataid.attr("data-id"))
            }
            else{
                tabs.tabAdd(dataid.attr("data-id"),dataid.attr("data-url"),dataid.attr("data-title"));
                element.tabChange('box',dataid.attr("data-id"));
            }


        })
    });




</script>

    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/user/js/main.js"></script>
</body>

</html>
