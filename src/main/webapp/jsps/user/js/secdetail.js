
//根据QueryString参数名称获取值
//获取传入这个html的uid的参数
function getQueryStringByName(name){

    var result = location.search.match(new RegExp("[\?\&]" + name+ "=([^\&]+)","i"));
    if(result == null || result.length < 1){
        return "";
    }
    return result[1];

}

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

$(function(){

    layui.use(["form","layer",'laydate','element'],function(){
        form = layui.form;
        layer = layui.layer;
        laydate = layui.laydate;
        element = layui.element;

        var index = layer.load(1);
        //显示所有项目进度的评价和进度条已经违规情况
        $.ajax({
            url:"/HKR/teacher/findUserAllSec",
            contentType:"application/json",
            type:"post",
            data:JSON.stringify({uid:getQueryStringByName("uid")}),
            async:true,
            success:function (res) {
                console.log(res)
                layer.close(index);
                if (res.success){

                    //目前进度和所有详情
                    var da = res.data;

                    var auth = false;
                    auth = da["auth"];
                    console.log(auth)

                    //提取所有评价
                    var rebels = da["allRebel"];
                    var details =  da["allSection"];
                    //获取所有进度
                    var sections =  da["sections"];
                    var status  = da["status"];


                    var sectioncontent = "";
                    for(var key in sections){
                        var secitem = "<li od='" + sections[key]["od"] + "'><a>" + sections[key]["detailname"];
                        secitem =  secitem +
                            "(" + format(sections[key]["startdate"],"yyyy/MM/dd") + "--"+
                            format(sections[key]["enddate"],"yyyy/MM/dd") + ")" +
                            "<span class='caret'></span></a></li>"
                        sectioncontent = sectioncontent +  secitem;
                    }
                    $("#processmanager").html(sectioncontent);

                    $("#processmanager > li:lt(" +  status + ")").each(function () {
                        $(this).addClass("active");

                    });
                    layer.tips("点击我就可以修改哦!",'.caret',{tips:1});




                    console.log(rebels);
                    console.log(details);

                    var detailItems = "<div><div align='center'>" + "</div><div class=\"layui-collapse\" lay-accordion>";
                    for(var key in details){

                        var item_title = "<div class=\"layui-colla-item\"> <div class=\"layui-colla-content layui-show\">";

                        detailItems = detailItems + item_title
                            + details[key]["submanager"] + "/" +
                            details[key]["detailname"] +  "/" +
                            format(details[key]["createtime"] ,"yyyy-MM-dd")+
                            "<p style='color:#000000;font-size: 23px;'>" + details[key]["evaluate"] +
                            "</p></div></div></div>"

                    }

                    detailItems = detailItems + "</div></div>"


                    if (details.length  == 0){
                        $("#secdetailcontent").html("<div style='color:green;'>目前还没有项目经理进行评价哦！</div>");
                    }else{
                        $("#secdetailcontent").html(detailItems);
                    }

                    //项目违规评价
                    var rebelItems = "<div><div align='center'>" + "</div><div class=\"layui-collapse\" lay-accordion>";
                    for(var key in rebels){

                        var item_title = "<div class=\"layui-colla-item\"> <div class=\"layui-colla-content layui-show\">";

                        rebelItems = rebelItems + item_title +
                            rebels[key]["detailname"] +  "/" +
                            format(rebels[key]["createtime"] ,"yyyy-MM-dd")+
                            "<p style='color:red;font-size: 20px;'>" + rebels[key]["evaluate"] +
                            "</p></div></div></div>"

                    }

                    rebelItems = rebelItems + "</div></div>"


                    if (rebels.length  == 0){
                        $("#rebeldetailcontent").html("<div style='color:green;'>表现还不错，目前还没有违规情况！</div>");
                    }else{
                        $("#rebeldetailcontent").html(rebelItems);
                    }

                    //设置进度条的名称和进度比
                    // element.progress("process",process*100 + "%");
                  /*  if (process === 1){
                        // $("#processbar").attr("lay-percent","已完成");
                        $("#processmanager > li").each(function (){
                            $(this).addClass("active");
                        })
                    }else{
                        $("#processmanager > li:lt(" +  status + ")").each(function () {
                            $(this).addClass("active");
                        })
                    }*/

                    //初始化表头信息
                    //查询用户的入职天数等
                    $.ajax({
                        url:"/HKR/teacher/findUserEndtime",
                        contentType:"application/json",
                        type:"post",
                        data:JSON.stringify({uid:getQueryStringByName("uid")}),
                        async:true,
                        success:function (result) {
                            if (result.success){
                                var d = result.data;
                                for(var key in d){
                                    var idkey = ("#" + key).toString();
                                    if (key == "registerDate" || key == "enddate"){
                                        $(idkey).html(format(d[key],"yyyy-MM-dd"))
                                    }else {
                                        $(idkey).html(d[key])
                                    }
                                }
                            }
                        }
                    });



                    //判断是否有auth的字段权限进行修改数据
                    if (auth){
                        //添加可新增按钮
                        var adddetailbtn = "<span id=\"addsecdetailBtn\" lay-event=\"addsecdetailBtn\" class=\"layui-btn  layui-btn-primary\">\n" +
                            "                        <i class=\"layui-icon layui-icon-add-1\"></i>添加项目质量评价</span>";
                        var addrebelbtn = " <span id=\"addsecrebelBtn\" lay-event=\"addrebelBtn\" class=\"layui-btn  layui-btn-primary\">\n" +
                            "                        <i class=\"layui-icon layui-icon-add-1\"></i>添加项目违规记录</span>";

                        $("#secdetailparent").append(adddetailbtn);  //添加项目质量评价记录按钮
                        $("#secrebelparent").append(addrebelbtn);//添加项目违规记录按钮




                        //添加点击修改功能
                        $(".modify").each(function () {

                            $(this).attr("title","点击修改");
                            $(this).next().on("click",function (ele) {
                                // eval($(this).attr("id") + "()");
                                var name = $(this).attr("id");
                                eval( "modify('" + name + "')")
                            })
                        });

                        $("#processmanager > li").on("click",function (ele) {
                            var od  = $(this).attr("od");
                            var uid  = getQueryStringByName("uid");
                            modifyprocess(uid,od);
                            $.ajax({
                                url:"/HKR/teacher/updateProcess",
                                contentType:"application/json",
                                type:"post",
                                data:JSON.stringify({uid:getQueryStringByName("uid"),"od":od}),
                                async:true,
                                success:function (result) {
                                    if (result.success){
                                        $("#processmanager > li:lt(" +  od + ")").each(function () {
                                            $(this).addClass("active");
                                        });
                                        $("#processmanager > li:gt(" +  od + ")").each(function () {
                                            $(this).removeClass("active");
                                        });
                                        // layer.alert("修改进度成功！");
                                        // location.reload();


                                    }else{
                                        layer.alert(result.msg)
                                    }
                                }
                            });


                            /*layer.confirm("是否把当前学员修改成当前进度？",{"btn":['确认','取消'],
                                btn1:function (index) {
                                    layer.msg("确认！")
                                },
                                btn2:function (index) {
                                    layer.msg("取消！")
                                }

                            });*/
                        })


                    }else{
                        //非代理和招聘人员不能进行修改数据
                        $(".modify").each(function () {
                            $(this).next().css("display","none")
                        })
                    }

                    //给更新项目进度按钮绑定点击事件
                    $("#subprocessbtn").on("click",function () {
                        modifyprocess();//修改项目进度
                    });

                    $("#addsecdetailBtn").on("click",function () {
                        adddetail();
                    })
                    $("#addsecrebelBtn").on("click",function () {
                        addrebeldetail();
                    });










                }else{
                    layer.alert(res.msg)
                }
            }

        });



        //添加项目质量评价
        function adddetail() {
            layer.open({
                title : "添加项目评价",
                type:2,
                area:['450px','400px'],
                maxmin:false,
                shadeClose:false,
                resize:false,
                btnAlign:'C',
                moveType:0,
                zIndex:9999999,
                content:"addSecDetail.html?uid=" + getQueryStringByName("uid"),
            })
        }


        //添加项目质量评价
        function addrebeldetail() {
            layer.open({
                title : "新增项目违规记录",
                type:2,
                area:['450px','400px'],
                maxmin:false,
                shadeClose:false,
                resize:false,
                btnAlign:'C',
                moveType:0,
                zIndex:9999999,
                content:"addSecrebel.html?uid=" + getQueryStringByName("uid"),
            })
        }



        /**
         * 动态可打开页面修改项目进度
         */
        function modify(page) {
            layer.open({
                title : "更新项目进度",
                type:2,
                area:['450px','400px'],
                maxmin:true,
                shadeClose:false,
                resize:true,
                btnAlign:'C',
                moveType:0,
                zIndex:9999999,
                content: page + ".html?uid=" + getQueryStringByName("uid"),
            })
        };



        /**
         *修改项目进度
         */
        function modifyprocess(uid,od) {
            layer.open({
                title : "更新项目进度",
                type:2,
                area:['450px','400px'],
                maxmin:true,
                shadeClose:false,
                resize:true,
                btnAlign:'C',
                moveType:0,
                zIndex:9999999,
                content:"modifyitemprocess.html?uid=" + uid + "&od=" + od,
            })
        };

    });

});


