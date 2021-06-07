/*邮箱格式检验*/
function check_email(ele){
    var value = $(ele).val().trim();
    // var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    var reg = /^\w+@\w+\.[a-zA-Z]{2,4}$/
    if(value.length == 0){
        layer.msg("邮箱不能为空哦!别瞎弄!");
        return false;
    }else if (!reg.test(value)){
        layer.msg("你确定你这是邮箱吗？都跟你说了别瞎弄!");
        return false;
    }
    return true;
}
/*专门检查密码*/
function check_pass(ele){
    var password = $(ele).val().trim();
    if (password.length == 0){
        layer.msg("密码不能为空!")
        return false;
    }
    return true;
}

/*校验手机号*/
function check_phone(ele){
    var value = $(ele).val().trim();
    var reg = /^1[3-9]{1}\d{9}$/
    if (value.length == 0){
        layer.msg("请输入手机号!")
        return false;
    }else if(!reg.test(value)){
        layer.msg("手机号格式不正确!");
        return false;
    }
    return true;

}

/*检验滑动验证*/
function slide_check(){
    if (!res){
        layer.alert("请先滑动滑块完成验证!",{icon:5,title:"错误"});
        return res;
    }
    return res;
}

$(function (){
    /*注册按钮*/
    $("#btn_reg").click(function (){
        if(!check_email($("#reg_email"))){
            return;
        }
        if (!check_pass($("#reg_passwd"))){
            return;
        }

        if (!check_phone($("#reg_phone"))){
            return;
        }
        if (!slide_check()) {
            return;
        }

        /*可以在ajax中调用函数然后看逻辑是否关闭加载器。*/
        /*异步访问后端服务器完成校验*/
        var index = layer.load(2,{time:100*1000});
        $.ajax({
            url:"user/register",
            method:"post",
            async:false,
            dataType:"json",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify({
                email:$("#reg_email").val(),
                phoneNumber:$("#reg_phone").val(),
                password:$("#reg_passwd").val()
            }),
            success:function (result){
                if (result.success && result.code == 760){
                    layer.close(index);
                    layer.alert("注册成功!已发送激活邮件到您的邮箱！请到您尽快激活！",{icon:6},function (){
                        window.location.reload();
                    });
                }else{
                    layer.close(index);
                    layer.msg(result.msg);
                }}
            });
    });

    /*登陆按钮*/
    $("#btn_login").click(function (){
        if (!check_email($("#login_email"))){
            return;
        }

        if (!check_pass($("#login_passwd"))){
            return ;
        }
        var index = layer.load(2,{timeout:10*1000});

        /*异步传输请求到服务器进行登陆*/
        $.ajax({
            url:"user/login",
            dataType: "json",
            method: "post",
            type:"json",
            contentType: "application/json",
            sync:false,
            data:JSON.stringify({"email":$("#login_email").val(),"password":$("#login_passwd").val()}),
            success:function (result){
                if (result.success){
                    layer.close(index);
                    layer.msg("登陆成功,客官里面请...");
                    /*转发到登陆成功页面*/
                    window.location = "jsps/user/main.jsp"
                    //
                }else{
                    layer.close(index);
                    layer.alert(result.msg,{icon:5,title:"登陆失败!"})
                }
            }
        });

    });

});












