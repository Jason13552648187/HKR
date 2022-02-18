/**
 * 获取页面的传入的某一项参数
 * @param name
 * @returns {string}
 */
function getQueryStringByName(name){

    var result = location.search.match(new RegExp("[\?\&]" + name+ "=([^\&]+)","i"));
    if(result == null || result.length < 1){
        return "";
    }
    return result[1];

}

/**
 * 时间格式化参数
 * @param time
 * @param format
 * @returns {string|*}
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

$(function() {

        layui.use(["form", "layer", 'laydate', 'element'], function () {
            form = layui.form;
            layer = layui.layer;
            laydate = layui.laydate;
            element = layui.element;
            $ = layui.jquery;
            $.ajax({
                url: "/HKR/teacher/findData",
                type: "post",
                contentType: "application/json",
                async: false,
                data: JSON.stringify({uid: getQueryStringByName("uid")}),
                success: function (res) {
                    //数据回显
                    var info = res.data;
                    if (info.length == 0){
                        console.log("数据为空！")
                    }
                    info = info[0];
                    console.log("info:",info);
                    for(var i in info){

                        var value = info[i];
                        if (value  == ""){
                            value = "暂无数据"
                        }
                        if(i.toString().endsWith("time") || i.toString() == "birthday"){
                            value = format(value,"yyyy-MM-dd")
                        }
                        $("#" + i  + " > ind").html(value);


                    }


                    if (info["company"].trim() == ""){
                        $("#work_detail").html("暂无工作信息！")
                    }

                },
                error: function () {
                    layer.alert("操作失败！")
                }
            });

    })
});