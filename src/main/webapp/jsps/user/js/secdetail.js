
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
                console.log(res);
                layer.close(index);
                if (res.success){

                    //目前进度和所有详情
                    var da = res.data;

                    var auth = false;
                    auth = da["auth"];
                    console.log(auth)
                    //目前进度
                    var data = da["curProcess"];
                    var alldetail = da["allDetail"];
                    //提取当前项目进度时，和当前阶段名称
                    var secname = data["secname"];//进度名称
                    var process = data["process"];//进度百分比
                    var detailname = data["detailname"];//目前进度真实名称
                    var status  = data["status"];

                    //设置进度条的名称和进度比
                    $("#processbar").attr("lay-percent",secname + "(" + detailname + ")");
                    element.progress("process",process*100 + "%");
                    element.init();//重新渲染进度条



                    console.log("目前项目进度为：",secname,",",process,"名称：",detailname)



                    var alltitle = "";
                    var detailcount = 0;

                    //拼接所有项目质量评价
                    for(var everySec  in alldetail){


                        var evaluate_all = alldetail[everySec]["curProcess"];
                        var header_title = "<div><div align='center'>" + evaluate_all["secname"] + "</div>" +
                            "<div class='layui-collapse' lay-accordion id='section_detail'>";//评价开始
                        var sectitle =  "" + header_title;

                        if ($.isEmptyObject(evaluate_all["evaluate"])){
                            continue;
                        }
                        detailcount += 1;
                        console.log("everySec" + everySec+"-----"+alldetail[everySec])


                        console.log("evaluate_all:" + evaluate_all.toString())


                        var manager_title = "<div class='layui-colla-item'>" +
                            "<div class='layui-colla-content layui-show'>";
                        var managerdiv = "";
                        var every_evaluate = evaluate_all["evaluate"];
                        for(var evaluate_key  in every_evaluate){

                            var manageritem_key = every_evaluate[evaluate_key];
                            for(var i  in manageritem_key){
                                managerdiv =  manager_title + "<div>" + evaluate_key + "：" + manageritem_key[i] + "</div></div></div>";
                                sectitle = sectitle +  managerdiv;
                            }



                            console.log("evaluate_key:" + evaluate_key, + "----" +every_evaluate[evaluate_key]);

                        }

                        sectitle = sectitle  + "</div></div>";
                        alltitle = alltitle + sectitle;

                    }

                    console.log("项目评价次数：",detailcount)


                    if (detailcount == 0){
                        $("#secdetailcontent").html("<div style='color:green;'>目前还没有项目经理进行评价哦！</div>");
                    }else{
                        $("#secdetailcontent").html(alltitle);
                    }






                    //显示所有的违规情况
                    var rebel_alltitle = "";


                    //拼接所有违规评价
                    var count = 0;
                    for(var everySec  in alldetail){

                        var secrebelall = alldetail[everySec]["curProcess"]["rebel"];

                        if ($.isEmptyObject(secrebelall)){

                            continue;
                        }
                        count += 1;
                        var rebeltitle = alldetail[everySec]["curProcess"]["secname"];

                        var rebel_header_title = "<div><div align='center'>" + rebeltitle + "</div>" +
                            "<div class='layui-collapse' lay-accordion>"
                        rebel_alltitle = rebel_alltitle + rebel_header_title;



                        var manager_title = "<div class='layui-colla-item'>" +
                            "<div class='layui-colla-content layui-show'>";
                        var every_evaluate = evaluate_all["rebel"];
                        var rebel_manager_title = "";

                        for(var evaluate_key  in secrebelall){

                            rebel_manager_title = rebel_manager_title + manager_title + "<div style='color: red'>"  + secrebelall[evaluate_key] + "</div></div></div>";

                        }

                        rebel_alltitle = rebel_alltitle + rebel_manager_title + "</div></div>";

                    }
                    console.log("违规次数：",count)
                    if (count == 0){
                        $("#rebeldetailcontent").html("<div style='color:green;'>表现还不错，目前还有没有违规情况！</div>");
                    }else{
                        $("#rebeldetailcontent").html(rebel_alltitle);

                    }


                    element.init();

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
                        var adddetailbtn = "<span id=\"addsecdetailBtn\" lay-event=\"addsecdetailBtn\" class=\"layui-btn  layui-btn-primary\">\n" +
                            "                        <i class=\"layui-icon layui-icon-add-1\"></i>添加项目质量评价</span>";
                        var addrebelbtn = " <span id=\"addsecrebelBtn\" lay-event=\"addrebelBtn\" class=\"layui-btn  layui-btn-primary\">\n" +
                            "                        <i class=\"layui-icon layui-icon-add-1\"></i>添加项目违规记录</span>";
                        var btn = "<button type='button' id='subprocessbtn' class='layui-btn layui-btn-radius layui-btn-danger'>更新项目进度</button>";
                        $("#modify").html(btn);//添加更新项目进度按钮
                        $("#secdetailparent").append(adddetailbtn);  //添加项目质量评价记录按钮
                        $("#secrebelparent").append(addrebelbtn);//添加项目违规记录按钮
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
                    })

                }else{
                    layer.alert(res.msg)
                }
            }

        })

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
         *修改项目进度
         */
        function modifyprocess() {
            layer.open({
                title : "更新项目进度",
                type:2,
                area:['450px','400px'],
                maxmin:false,
                shadeClose:false,
                resize:false,
                btnAlign:'C',
                moveType:0,
                zIndex:9999999,
                content:"modifyprocess.html?uid=" + getQueryStringByName("uid"),
            })
        }

    });

});


