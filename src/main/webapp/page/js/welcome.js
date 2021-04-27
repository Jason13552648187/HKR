/**
 * show classname
 */
function showClassName(){
    var uid =  Cookies.get("uid");
    var classname = Cookies.get("classname");
    $("#classname").text(classname);
}

/**
 * show teacher
 */
function showTeacher(){
    var tname =  $("#tname");
    $.ajax({
        url:"/findAllTeacher",
        type:"post",
        // data:{status:1},
        dataType:"json",
        success:function(result){
            if (result.success){
                var content = "";
                $.each(result.data,function (i, val) {
                    content +='<option value="' + val.teacherName + '">' + val.teacherName + '</option>';
                });
                $("#tname").html(content);
            }else{
                layer.alert(result.msg,{icon:2,title:"消息"});
            }
            layui.form.render("select","tnamerender"); //重新渲染前端表单特效
        }
    });
};

