/**
 * 进入后开始进行初始化数据
 */
var table,form,layer;
layui.use(['table','form','layer'], function () {
    table = layui.table;
    form = layui.form;
})
function selectUser(){
        table.render({
            elem: "#table",
            // url :"/HKR/jsps/user/data/data.json",
            url :"/HKR/user/findAll",
            title:"用户数据",
            page:true,
            toolbar:"default",
            totalRow:true,
            parseData:function (res){
                return {
                    "code":0,
                    "data":res.data,
                    "msg":res.msg,
                    "count":res.count
                }
            },

            cols: [[
                {checkbox: true, fixed: true},
                {field: 'username', title: '姓名', width: 80},
                {field: 'registerDate', title: '入学时间', width: 100},
                {field: 'sex', title: '性别', width: 80},
                {field: 'age', title: '年龄', width: 80},
                {field: 'idcard', title: '身份证', width: 80},
                {field: 'email', title: '邮箱', width: 80},
                {field: 'phoneNumber', title: '电话号码', width: 100},
                {field: 'wechat', title: '微信号', width: 80}


                // {type: 'checkbox', fixed: 'left'}
                // ,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left', totalRowText: '合计：'}
                // ,{field: 'username', title: '用户名', width:80}
                // ,{field: 'experience', title: '积分', width: 90, sort: true, totalRow: true}
                // ,{field: 'sex', title: '性别', width:80, sort: true}
                // ,{field: 'score', title: '评分', width: 80, sort: true, totalRow: true}
                // ,{field: 'city', title: '城市', width:150}
                // ,{field: 'sign', title: '签名', width: 200}
                // ,{field: 'classify', title: '职业', width: 100}
                // ,{field: 'wealth', title: '财富', width: 135, sort: true, totalRow: true}
                // ,{fixed: 'right', title:'操作', width: 165, align:'center', toolbar: '#barDemo'}


            ]]
        })

}


































