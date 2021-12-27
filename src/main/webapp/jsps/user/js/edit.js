/**
 * 时间格式化
 */
var format = function(time, format){
    if(time === undefined){
        return "";
    }
    var t = new Date(time);
    var tf = function(i){return (i < 10 ? '0' : '') + i};
    return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
        switch(a){
            case 'yyyy':
                return tf(t.getFullYear());
                break;
            case 'MM':
                return tf(t.getMonth() + 1);
                break;
            case 'mm':
                return tf(t.getMinutes());
                break;
            case 'dd':
                return tf(t.getDate());
                break;
            case 'HH':
                return tf(t.getHours());
                break;
            case 'ss':
                return tf(t.getSeconds());
                break;
        }
    })
}


function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}
var form,layer,laydate;
/*给表单注册登录事件*/
layui.use(["form","layer",'laydate'],function(){
    form = layui.form;
    layer = layui.layer;
    laydate = layui.laydate;

    laydate.render({
        elem:"#gradutime",
        type:"date",
        trigger:'click'

    });
    laydate.render({
        elem:"#birthday",
        type:"date",
        max:getNowFormatDate(),
        trigger:'click'
    });
    laydate.render({
        elem:"#starttime",
        type:"date",
        max:getNowFormatDate(),
        trigger:'click'
    });
    laydate.render({
        elem:"#endtime",
        type:"date",
        max:getNowFormatDate(),
        trigger:'click'
    });


    form.on("submit(formDemo)",function(data){
        var da = JSON.stringify(data.field);
        $.ajax({
            url:"/HKR/teacher/updateStaff",
            type:"post",
            contentType:"application/json",
            async:false,
            data:da,
            success:function (res) {
                if(res.success){

                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    parent.location.reload();
                    layer.msg("修改成功!");
                }else{
                    layer.alert(res.msg,{icon:5,title:"错误"});
                    return false;
                }
            },
            error:function () {
                layer.alert("提交失败！")
            }
        });
        return false;
    });
});
