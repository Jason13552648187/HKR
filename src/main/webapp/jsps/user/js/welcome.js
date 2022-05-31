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

$(function () {
    var title;
    var xdata = [];
    var ydata = [];
    $.ajax({
        url:"/HKR/data/getNeiSixMonthUser",
        type:"post",
        contentType:"application/json",
        async:false,
        data: JSON.stringify({}),
        success:function (result) {

            if (result.success){
                title = result.title;
                var data = result.data;

                xdata=data["xdata"];
                ydata=data["ydata"];
                console.log(xdata);
                console.log(ydata);

            }else{
                alert(result.msg)
            }
        },
        error:function (result) {
            alert(result.msg)
        }
    });
    $("#numtitle").html(title);

    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};

    var option;

    option = {
        title: {
            text: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {},
        toolbox: {
            show: true,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: {
                    readOnly: false
                },
                magicType: {
                    type: ['line', 'bar']
                },
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: xdata
        },
        yAxis: {
            type: 'value',
            axisLabel: {
                formatter: '{value} 人'
            }
        },
        series: [
            {
                name: '入职人数',
                type: 'line',
                data: ydata,
                markPoint: {
                    data: [{
                        type: 'max',
                        name: '最大值'
                    },
                        {
                            type: 'min',
                            name: '最小值'
                        }
                    ]
                },
                markLine: {
                    data: [{
                        type: 'average',
                        name: 'Avg'
                    }]
                }
            },
/*            {
                name: '最低温度',
                type: 'line',
                data: [1, 3, 2, 5, 3, 2, 0],
                markPoint: {
                    data: [{
                        name: '周最低',
                        value: -2,
                        xAxis: 1,
                        yAxis: -1.5
                    }]
                },
                markLine: {
                    data: [{
                        type: 'average',
                        name: 'Avg'
                    },
                        [{
                            symbol: 'none',
                            x: '90%',
                            yAxis: 'max'
                        },
                            {
                                symbol: 'circle',
                                label: {
                                    position: 'start',
                                    formatter: 'Max'
                                },
                                type: 'max',
                                name: '最高点'
                            }
                        ]
                    ]
                }
            },
            {
                name: '中间温度',
                type: 'line',
                data: [7, 12, 23, 19, 14, 12, 29],
                markPoint: {
                    data: [{
                        type: 'max',
                        name: '最大值'
                    },
                        {
                            type: 'min',
                            name: '最小值'
                        }
                    ]
                },
                markLine: {
                    data: [{
                        type: 'average',
                        name: 'Avg'
                    }]
                }
            }*/
        ]
    };

    if(option && typeof option === 'object') {
        myChart.setOption(option);
    }


    /**
     * 渲染旁边的近7天的入职人数
     */
    $.ajax({
        url:"/HKR/data/getUserNeiSevenDay",
        type:"post",
        contentType:"application/json",
        async:false,
        data: JSON.stringify({}),
        success:function (result) {

            if (result.success){
                cnt = "";
                var data = result.data;
                if (data.length === 0){
                    $("#useritems").html("暂无入职新员工！");
                }else {
                    for (var item in data) {
                        cnt = cnt + "<div>"
                            + data[item]["username"]
                            + "  |  " + data[item]["age"]
                            + "  |  " + data[item]["sex"]
                            + "  |  " + data[item]["school"]
                            + "  |  " + data[item]["edulevel"]
                            + "  |  " + format(data[item]["registerDate"], "yyyy-MM-dd")
                            + "</div>"
                    }
                    $("#useritems").html(cnt);
                }

            }else{
                alert(result.msg)
            }
        },
        error:function (result) {
            alert(result.msg)
        }
    });


    /*渲染各个薪资范围段的人数*/
    var bingdata ;
    $.ajax({
        url:"/HKR/teacher/countSalaryDetail",
        type:"post",
        contentType:"application/json",
        async:false,
        data: JSON.stringify({}),
        success:function (res) {
            if (res.success) {
                bingdata = res.data;
            }else{
                alert(res.msg);
            }
        }
    })



    var bingoption;
    bingoption =  {
        tooltip: {
            trigger: 'item'
        },
        legend: {
            top: '5%',
            left: 'center'
        },
        series: [
            {
                name: '人数',
                type: 'pie',
                radius: ['40%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    label: {
                        show: true,
                        fontSize: '40',
                        fontWeight: 'bold'
                    }
                },
                labelLine: {
                    show: false
                },
                data: bingdata
            }
        ]
    };

    var bingdom = document.getElementById("salaryDetail");

    var bingchart = echarts.init(bingdom);

    if(bingoption && typeof bingoption === 'object') {
        bingchart.setOption(bingoption);
    }


})