
    function isNull(ele) {
        console.log(ele)
        if (ele == "" || ele === undefined){
            // layer.tips("查询数据不能为空！",ele,{tips:3});
            return true;
        }
        return false;
    }

    //绑定查找绑定按钮事件
    $("#search_btn").click(function () {
        var username = $("#username").val();
        var wechat  = $("#wechat").val();
        var phone  = $("#phoneNumber").val();
        var school = $("#school").val();
        alert(username)
        if(isNull(username) && isNull(wechat) && isNull(phone) && isNull(school)){
            layer.alert("查询至少有一个不能为空！")
        }else{
            val = {"username":username,"wechat":wechat,"phoneNumber":phone,"school":school}
            search(val);
        }
    });

/**
 * 查询用户数据
 * @param val
 */
function search(val) {
    var index = layer.load({icon:1});

    $.ajax({
        url :"/HKR/teacher/ucommonSelect",
        type:"post",
        async:false,
        contentType:"application/json",
        data:JSON.stringify(val),
        success:function (res) {

            //动态添加字段
            var mycm = [];
            var row_data = res.data[0];
            for (col in row_data){
                mycm.push({field:col,title:col,align:'center',width:120,sort:false});
            }

            table.render({
                elem: "#add",
                toolbar:'#tb',
                totalRow:true,
                data:res.data,

                cols: [[
                    {type: 'checkbox', fixed: 'left',hide:true},
                    {field: 'uid' ,title:'uid',width:60,sort:true,fixed:'left',hide:true},
                    {field: "username", title: '姓名', width: 90,fixed:'left'},
                    {field: "registerDate", title: '入职时间',sort:true, width: 110,templet:function (d) {
                            return format(d.registerDate,"yyyy-MM-dd");
                        }},
                    {field: "", title: '预计结束时间',sort:true, width: 160,templet:function (d) {
                            return format(d.endtime,"yyyy-MM-dd");
                        }},
                    {field: "age", title: '年龄',sort:true, width: 80},
                    {field: "idcard", title: '身份证', width: 120},
                    {field: "phoneNumber", title: '电话号码', width: 120},
                    {field: "school", title: '学校', width: 100},
                    {field: "compactname", title: '财务状况', width:100},
                    {field: "graduation", title: '学籍状况', width:100},
                    {title : "操作",width:200,align:"center",toolbar:"#tabledata",fixed: 'right'}

                ]]
            });
            layer.close(index);
        }
    });
}
