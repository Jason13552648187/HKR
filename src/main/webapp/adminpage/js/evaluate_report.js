function test(data){
		
	
        $('#show').highcharts({
        chart: {
                type: 'pie',
                options3d: {
                        enabled: true,
                        alpha: 50,
                        beta: 0
                }
        },
        title: {
                text: '满意分布图'
        },
        tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
                pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        depth: 35,
                        dataLabels: {
                            enabled: true,
                            format: '{point.name}'
                        }
                }
        },
        series: [{
                type: 'pie',
                name: '评价满意程度',
                data: data
        }]
	});
};


function show(){
	/*$.ajax({
		url:"EvaluateServlet?method=reportAll",
		dataType:"json",
		type:"post",
		success:function(result){
			show(result);
		}
	});*/
	$("#evagrid").datagrid({
		url:"EvaluateServlet?method=reportAll",
		singleSelect:true,
		columns:[[
		          {field:"satis",title:"满意程度",width:"150"}, 
		          {field:"num",title:"数量",width:"100"}, 
		]],
		onLoadSuccess:function(data){
			data = data.rows;
			var d = [];
			for (var i = 0; i < data.length; i++) {
				d.push([data[i].satis,data[i].num]);
			}
			test(d);
		}
	});
	
}


$(document).ready(function(){
	show();
});
