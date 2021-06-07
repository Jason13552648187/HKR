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
    <link rel="stylesheet" href="jsps/user/css/reset.min.css">
    <link rel="stylesheet" href="jsps/user/css/style.css">
    <link rel="stylesheet" href="jsps/layui/css/layui.css">
    <link rel="stylesheet" href="jsps/user/css/slide.css">

    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" />

    <script src="<%=request.getContextPath()%>/jsps/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/layui/layui.js"></script>

</head>

<body>
<section class="user">
    <div class="user_options-container">
        <div class="user_options-text">
            <div class="user_options-unregistered">
                <h2 class="user_unregistered-title">没有账号？</h2>
                <p class="user_unregistered-text">点击按钮注册成为会员.</p>
                <button class="user_unregistered-signup" id="signup-button">注册</button>
            </div>

            <div class="user_options-registered">
                <h2 class="user_registered-title">已有账号?</h2>
                <p class="user_registered-text">点击按钮会员登录.</p>
                <button class="user_registered-login" id="login-button">登录</button>
            </div>
        </div>

        <div class="user_options-forms" id="user_options-forms">
            <div class="user_forms-login">
                <h2 class="forms_title">登录</h2>
<%--                <form class="forms_form" action="<c:url  value="/user/register"/>" method="post">--%>
                    <fieldset class="forms_fieldset">
                        <div class="forms_field">
                            <input type="email" id="login_email" name="email" placeholder="邮箱" class="forms_field-input" required autofocus />
                        </div>
                        <div class="forms_field">
                            <input type="password" id="login_passwd" name="password" placeholder="密码" class="forms_field-input" required />
                        </div>
                    </fieldset>
                    <div class="forms_buttons">
                        <button type="button" id="btn_forgetpass" class="forms_buttons-forgot">忘记密码?</button>
                        <input type="submit" value="登录" id="btn_login" class="forms_buttons-action">
                    </div>
<%--                </form>--%>
            </div>
            <div class="user_forms-signup">
                <h2 class="forms_title">注册</h2>
<%--                <form class="forms_form" method="post" action="user/register">--%>
                    <fieldset class="forms_fieldset">
                        <div class="forms_field">
                            <input type="email" id="reg_email" name="email" placeholder="邮箱" class="forms_field-input" required onblur="check_email(this);"/>
                        </div>
                        <div class="forms_field">
                            <input type="password" id="reg_passwd" name="password" placeholder="密码" class="forms_field-input" required onblur="check_pass(this);" />
                        </div>
                        <div class="forms_field">
                            <input type="phone" id="reg_phone" name="phoneNumber" placeholder="手机号" class="forms_field-input" required />
                        </div>
                        <div class="forms_field" id="slidebox">
                            <div class="verify-wrap" id="verify-wrap" style=""><div class="drag-progress dragProgress"></div><span class="drag-btn dragBtn"></span><span class="fix-tips fixTips">请向右滑动滑块</span><span class="verify-msg sucMsg">验证通过</span></div>
                        </div>
                    </fieldset>
                    <div class="forms_buttons" >
                        <input type="submit" value="注册" id="btn_reg" class="forms_buttons-action">
                    </div>
<%--                </form>--%>
            </div>
        </div>
    </div>
</section>



<script type="text/javascript">
    var layer = layui.layer;
    var form = layui.form;
    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
    var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1; //判断是否IE<11浏览器
    var isEdge = userAgent.indexOf("Edge") > -1 && !isIE; //判断是否IE的Edge浏览器
    var isIE11 = userAgent.indexOf("Trident") > -1 || userAgent.indexOf("rv:11.0") > -1;
    if(isIE11){
        window.location = "<c:url value='/error/browser.jsp'/>";
    }
    if(isIE) {
        var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
        reIE.test(userAgent);
        var fIEVersion = parseFloat(RegExp["$1"]);
        if(fIEVersion == 7 || fIEVersion == 8 || fIEVersion == 9 || fIEVersion == 10 || fIEVersion < 7) {
            window.location = "<%=request.getContextPath()%>/error/browser.jsp";
        }
    }
    var layer,laydate,form;
    layui.use(["layer","laydate"],function (){
       layer = layui.layer;
       form = layui.form;
       laydate = layui.laydate;
    });


    /*滑动验证*/
    var res = false
    $(function(){
        var SlideVerifyPlug = window.slideVerifyPlug;
        var slideVerify = new SlideVerifyPlug('#verify-wrap',{
            wrapWidth:'100%',//设置 容器的宽度 ,不设置的话，会设置成100%，需要自己在外层包层div,设置宽度，这是为了适应方便点；
            initText:'请向右滑动滑块',  //设置  初始的 显示文字
            sucessText:'验证通过',//设置 验证通过 显示的文字
            getSuccessState:function(res1){
                //当验证完成的时候 会 返回 res 值 true，只留了这个应该够用了
                console.log(res1);
                res  = res1;
                if(slideVerify.slideFinishState){
                    $('.value').html(slideVerify.slideFinishState)
                    $('#resetBtn').removeClass('prohibit')
                }
            }
        });
        $("#resetBtn").on('click',function(){
            $('.value').html('false')
            $('#resetBtn').addClass('prohibit')
            slideVerify.resetVerify();//可以重置 插件 回到初始状态
        })
        $('#resetBtn').addClass('prohibit')

    })


</script>

<script src="jsps/user/js/index.js" type="text/javascript"></script>
<script type="text/javascript" src="jsps/user/js/login.js"></script>
<%--引入滑动验证脚本--%>
<script type="text/javascript" src="jsps/user/js/slideVerify.js"></script>
</body>
</html>

