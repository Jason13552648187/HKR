/*邮箱格式检验*/
function check_email(ele){
    var value = $(ele).val().trim();
    // var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    var reg = /^\w+@\w+\.[a-zA-Z]{2,4}$/
    if(value.length == 0){
        layer.tips("邮箱不能为空!","#email");
        return false;
    }else if (!reg.test(value)){
        layer.tips("邮箱格式不正确!","#email");
        return false;
    }
    return true;
}

/*
* 发送验证码等待时间
* */
function time(object) {
    if(wait === 0){
        $(object).removeClass("layui-btn-disabled").removeAttr("disabled").text("发送验证码");
        wait = 60;
    }else{
        // $(object).setAttribute("disabled",true);
        $(object).addClass("layui-btn-disabled").attr("disabled","true");
        wait--;

        $(object).text(wait + "秒后重新发送");
        setTimeout(function(){time(object)},1000);
    }
}



//发送邮件
function sendVerifyCode(ele){
    var val = $(ele).val();
    $.ajax({
        url:"../../user/sendMail",
        method: "post",
        dataType: "json",
        contentType: "application/json",
        data:JSON.stringify({"email":val}),
        success:function (result){
            if (result.success){
                layer.msg("验证码已成功发送到邮箱!验证有效时间5分钟!");
            }else{
                layer.msg(result.msg);
            }
        }
    });
}


/*发送验证码*/
function send_verify(ele){

        if (!check_email($("#email"))){
            layer.alert("请输入注册时的邮箱账号!",{icon:5,title:"错误"});
            return;
        }else{
            /*ajax异步请求服务器看是否存在该邮箱*/
            var index = layer.load(2);  /*启动加载界面，让用户等待*/
            $.ajax({
                url:"../../user/commonSelect",
                dataType:"json",
                method:"post",
                contentType:"application/json",
                data:JSON.stringify({"email":$("#email").val()}),
                success:function (result){
                    layer.close(index);  /*关闭加载界面*/
                    if (!result.success){
                        layer.msg(result.msg);
                    }else if(result.total != 0){
                        //正常发送邮件
                        sendVerifyCode($("#email"));
                        time($("#btn_send"));
                    }else{
                        layer.msg("该邮箱账户不存在!别瞎弄!");
                    }
                }
            });
        }

}


$(function (){
    $("#first").click(function (){
        if (check_email($("#email"))){}
    })

    $("#btn_send").click(function (){
        if (send_verify()){}
    })

    //点击了修改密码按钮
    $("#modify_passwd").click(function () {

        //邮箱输入框id:email，  验证码输入框:verify  新密码:new_pass   确认新密码：confirm_newpass
        //首先校验邮箱里是否为空
        var mail = val = $("#email").val();
        var verify_code = $("#verify").val();
        var newpass = $("#new_pass").val();
        var confirm_newpass = $("#confirm_newpass").val();

        //校验验证码是否输入

        if (verify_code.trim().length == 0){
            layer.msg("请输入您的验证码!")
            return;
        }

        if (!check_email($("#email"))){
            return;
        }

        //校验新密码与确认新密码是否一样
        if (!newpass==confirm_newpass){
            layer.msg("新密码与确认新密码不一样!");
            return;
        }

        //正常ajax进行修改密码
        $.ajax({
            url:"../../user/modifyPasswd?vcode=" + verify_code,
            method:"post",
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify({"email":mail,"password":newpass}),
            success:function (result){
                if (!result.success){
                    layer.msg(result.msg);
                }else{
                    layer.msg("修改成功！请重新登录！",function () {
                        window.location.href = "/HKR";
                    });

                }
            }
        });

    });

})