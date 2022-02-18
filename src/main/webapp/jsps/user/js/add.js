/**
 * 进入后开始进行初始化数据
 */

/*毫秒时间格式化*/
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



//添加方法
function  add(){
    var index = layer.open({
        title :"添加员工",
        type:2,
        closeBtn:false,
        area:['100%','100%'],
        shade:0.8,
        id:"id-add",
        resize:true,
        btn:['关闭'],
        btnAlign:'C',

        moveType:0,
        maxmin:false,
        zIndex:9999999999999,
        content:"adduser.jsp",
        end:function (val) {  //点击关闭后执行的事件
            table.reload("add");
        },
        yes:function (index) {
            layer.close(index);

        },
        success:function (){
            layer.full(index);
        }
    })

}


/**
 * 表单数据回显方法
 * @param body
 * @param ele
 * @param value
 */
function setEleValue(body,ele,value) {
    body.find(ele.toString()).val(value);
}

var laydate ,form,laypage,layer ,table ,carousel,upload ,element,slider ;
layui.use(['form','laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function () {
        laydate = layui.laydate; //日期
        laypage = layui.laypage; //分页
        layer = layui.layer; //弹层
        table = layui.table; //表格
        carousel = layui.carousel; //轮播
        upload = layui.upload; //上传
        element = layui.element; //元素操作
        slider = layui.slider; //滑块
        form = layui.form;


    table.render({
            elem: "#add",
            // url :"/HKR/user/findAll",
            url:"/HKR/teacher/null",
            title:"用户数据",
            // page:true,
            toolbar:'#tb',
            totalRow:true,
            width:"100%",
            text:{
                none:"请搜索！"
            },
            parseData:function (res){
                return {
                    "code":0,
                    "data": {},//需求改变，默认不显示所有数据2.0的需求是只有查询后才能显示出所有数据
                    // "data":res.data, //这个需求是打开表格默认就显示所有数据
                    "msg":res.msg,
                    "count":res.count
                }
            },
            cols: [[
                {type: 'checkbox', fixed: 'left',hide:true},
                {field: 'uid' ,title:'uid',width:60,sort:true,fixed:'left',hide:true},
                {field: "username", title: '姓名', width: 90,fixed:'left'},
                {field: "registerDate", title: '报道时间',sort:true, width: 110,templet:function (d) {
                        return format(d.registerDate,"yyyy-MM-dd");
                    }},
                {field: "sex", title: '性别', width: 80},
                {field: "age", title: '年龄',sort:true, width: 80},
                // {field: "idcard", title: '身份证', width: 80},
                {field: "email", title: '邮箱', width: 80},
                // {field: "phoneNumber", title: '电话号码', width: 120},
                {field: "wechat", title: '微信号', width: 80},
                {field: "school", title: '学校', width: 80},
                {field: "professional", title: '专业', width: 80},
                {field: "gradutime", title: '毕业时间',sort:true, width: 100,templet:function (d) {
                        return format(d.gradutime,"yyyy-MM-dd")

                    }},
                {field: "edulevel", title: '学历水平', width: 80},
                {field: "educonfirm", title: '毕业证明人', width: 100},
                {field: "edutelnumber", title: '证明人联系', width: 80},
                {title : "操作",width:200,align:"center",toolbar:"#tabledata",fixed: 'right'}

            ]]
        });


    //监听工具栏事件
    table.on('toolbar(tabledata)',function (obj) {
        var checkStatus  = table.checkStatus(obj.config.uid)
/*        console.log(obj.event + "-----------" + "------------" + checkStatus.data)*/
        if (obj.event === "addBtn"){
            add();
        }
        if (obj.event === "refreshBtn"){
            //做修改的的执行程序
            var  ld = layer.load(1);

            setTimeout(function (){
                table.reload("add");
                layer.close(ld);
            })
        }
    });

    //监控的每一自定义行的事件
    table.on('tool(tabledata)',function (obj){
        var data = obj.data;

        var evt = obj.event;
        switch (evt){
            case "edit":
                index = layer.open({
                    title : "编辑员工信息",
                    type:2,
                    area:['100%','100%'],
                    maxmin:false,
                    shadeClose:true,
                    resize:false,
                    btn:['关闭'],
                    btnAlign:'C',
                    moveType:0,
                    // zIndex:9999999,

                    content:"edit.jsp",
                    success:function (layero,index) {
                        console.log("详情页面打开成功！")
                        //请求后端数据进行回显
                        $.ajax({
                            url:"/HKR/teacher/findData",
                            type:"post",
                            contentType:"application/json",
                            async:false,
                            data: JSON.stringify({uid:data.uid}),
                            success:function (res) {

                                var result = res.data[0];

                                //获取表单form的所有input和select组件
                                var body = layer.getChildFrame("body",index);
                                body.find("input").each(function () {
                                    if ($(this).attr("name") !== undefined) {
                                        if($(this).hasClass("lydate")){
                                            attrname = $(this).attr("name");
                                            s = "input[id=" + attrname + "]";
                                            //调用setEleValue方法完成赋值
                                            setEleValue(body,s,format(result[attrname],"yyyy-MM-dd"));
                                        }else{
                                            attrname = $(this).attr("name");
                                            s = "input[id=" + attrname + "]";
                                            //调用setEleValue方法完成赋值
                                            setEleValue(body,s,result[attrname]);
                                        }
                                    }
                                });
                                body.find("textarea[id='workdetail']").val(result["workdetail"]);
                                //下拉框的特殊处理
                                body.find("select").each(function () {
                                    if ($(this).attr("name") !== undefined) {

                                       var ele_id = $(this).attr("id");
                                       var ele_name = $(this).attr("name");

                                        var select_ele = 'dd[lay-value=' + result[ele_name] + ']';

                                        $(this).siblings("div.layui-form-select").find("dl").find(select_ele).click();


                                    }

                                });
                                form.render("select");





                            },
                            error:function () {
                                layer.alert("操作失败！")
                            }
                        });

                    }

                })
                layer.full(index)
            break;
            case "sectiondetail":
                console.log("项目进度详情:" +  data.uid);
                var index = layer.open({
                    title : "项目进度详情",
                    type:2,
                    area:['100%','100%'],
                    maxmin:false,
                    shadeClose:true,
                    resize:false,
                    btn:['关闭'],
                    btnAlign:'C',
                    moveType:0,
                    // zIndex:9999999,
                    content:"section/section_detail.html?uid=" + data.uid,
/*                    success:function (layero,index) {
                        console.log("详情页面打开成功！")
                        //请求后端数据进行回显
                        $.ajax({
                            url:"/HKR/teacher/findUserProcess",
                            type:"post",
                            contentType:"application/json",
                            async:false,
                            data: JSON.stringify({uid:data.uid}),
                            success:function (res) {

                                console.log(res);


                                if (res.success){
                                    var body = layer.getChildFrame("body",index);

                                    console.log(body.find("#hide").val());

                                }
                            },
                            error:function () {
                                layer.alert("操作失败！")
                            }
                        });
                    }*/
                });
                layer.full(index)

            break;
            case "detail":
                var index = layer.open({
                    title : "员工详情",
                    type:2,
                    area:['100%','100%'],
                    maxmin:false,
                    shadeClose:true,
                    resize:false,
                    // btn:['关闭'],
                    btnAlign:'C',
                    moveType:0,
                    // zIndex:9999999,
                    content:"info.html?uid=" + data.uid,
/*                    success:function (layero,index) {
                        console.log("详情页面打开成功！")
                        //请求后端数据进行回显
                        $.ajax({
                            url:"/HKR/teacher/findData",
                            type:"post",
                            contentType:"application/json",
                            async:false,
                            data: JSON.stringify({uid:data.uid}),
                            success:function (res) {

                                var result = res.data[0];

                                //获取表单form的所有input和select组件
                                var body = layer.getChildFrame("body",index);
                                body.find("input").each(function () {
                                    if ($(this).attr("name") !== undefined) {
                                        if($(this).hasClass("lydate")){
                                            attrname = $(this).attr("name");
                                            s = "input[id=" + attrname + "]";
                                            //调用setEleValue方法完成赋值
                                            setEleValue(body,s,format(result[attrname],"yyyy-MM-dd"));
                                        }else{
                                            attrname = $(this).attr("name");
                                            s = "input[id=" + attrname + "]";
                                            //调用setEleValue方法完成赋值
                                            setEleValue(body,s,result[attrname]);
                                        }

                                    }
                                });
                                body.find("textarea[id='workdetail']").val(result["workdetail"]);


                            },
                            error:function () {
                                layer.alert("操作失败！")
                            }
                        });

                    }*/

                })
                layer.full(index)
            break;
        }
    });





});




























