<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>Title</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/jsps/layui/css/layui.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/layui/layui.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsps/js/jquery-1.7.2.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/jsps/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jsps/common_css/scroll.css">
<%--    <%@include file="../common/common_head.jsp"%>--%>

</head>
<body style="width: auto;padding: 8px;background-color: #eee;">

<%
    Object trd = request.getSession().getAttribute("triod");

%>

<script type="text/html" id="tb">

        <%
            String rid = trd.toString();
            if(rid.equals("2") ||  rid.equals("1")||  rid.equals("0")){
        %>
            <span id="addBtn" lay-event="addBtn" class="layui-btn layui-btn-sm"><i class="layui-icon layui-icon-add-1"></i>添加</span>
        <%
            }
        %>

    <span id="refreshBtn" lay-event="refreshBtn" class="layui-btn layui-btn-sm"><i class="layui-icon layui-icon-refresh"></i>刷新</span>

</script>

    <blockquote class="layui-elem-quote " id="footer">
        <input id ="username" name="username" class="layui-input layui-input-inline" style="width: 200px;" placeholder="用户名">
        <input id ="wechat" name="wechat" class="layui-input layui-input-inline" style="width: 200px;" placeholder="微信号">
        <input id ="phoneNumber" name="phoneNumber" class="layui-input layui-input-inline" style="width: 200px;" placeholder="手机号">
        <input id ="school" name="school" class="layui-input layui-input-inline" style="width: 200px;" placeholder="毕业院校">
        <span id="search_btn" class="layui-btn   layui-btn-normal">查询</span>
    </blockquote>
    <table id="add" lay-even  lay-size="lg" class="layui-table"   lay-skin="nob" lay-filter="tabledata">

    </table>


    <%--编辑，删除，和查看详情按钮--%>

    <script type="text/html" id="tabledata">
        <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="sectiondetail">项目进度</a>
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
        <%
            if(rid.equals("1") || rid.equals("0")|| rid.equals("2")){ //编辑只有项目1,根管理员可见,还有修改
        %>
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <%
            }
        %>
    </script>

<script type="text/javascript" src="<%=request.getContextPath()%>/jsps/user/js/add.js"></script>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/jsps/user/js/search.js"></script>--%>

<script>

    function isNull(ele) {
        console.log(ele)
        if (ele == "" || ele ===  undefined){
            // layer.tips("查询数据不能为空！",ele,{tips:3});
            return true;
        }
        return false;
    }

    //绑定查找绑定按钮事件
    $("#search_btn").click(function () {
        var username = $("#username").val().trim();
        var wechat  = $("#wechat").val().trim();
        var phone  = $("#phoneNumber").val().trim();
        var school = $("#school").val().trim();

        if(isNull(username) && isNull(wechat) && isNull(phone) && isNull(school)){
            layer.msg("查询至少有一个不能为空！")
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
                        {field: "enddate", title: '预计结束时间',sort:true, width: 160,templet:function (d) {
                                return format(d.enddate,"yyyy-MM-dd");
                            }},
                        {field: "age", title: '年龄',sort:true, width: 80},
                        // {field: "idcard", title: '身份证', width: 120},
                        {field: "phoneNumber", title: '电话号码', width: 120},
                        {field: "school", title: '学校', width: 220},
                        <%
                            if(rid.equals("2")){ //编辑只有行政可见
                        %>
                            {field: "compactname", title: '财务状况', width:100},
                        <%
                            }
                        %>
                        {field: "graduation", title: '学籍状况', width:100},
                        {title : "操作",width:200,align:"center",toolbar:"#tabledata",fixed: 'right'}

                    ]]
                });
                layer.close(index);
            }
        });
    }


</script>
</body>
</html>
