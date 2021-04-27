/**
 * 初始化面板
 */
function initEvaPanel(){
	$("#eva").panel({
		width:"auto",
		height:"700px",
		title:title,
	});
}

function show_evaluate(){
	$("#show_eva").datagrid({
		url:'EvaluateServlet?method=getTodayAllEvaluate',
		method:'post',
		singleSelect:true,
		nowrap:false,
		columns:[[
			{field:'username',title:'学生名',width:'70px',align:'center'},
			{field:'time',title:'学时',width:'50px',align:'center'},
			{field:'teaName',title:'教师名',width:'70px',align:'center'},
			{field:'understand',title:'理解程度',width:'70px',align:'center'},
			{field:'helpful',title:'帮助程度',width:'70px',align:'center'},
			{field:'enterpriseNeed',title:'符合企业程度',width:'100px',align:'center'},
			{field:'langClear',title:'语言流利',width:'70px',align:'center'},
			{field:'isSystem',title:'系统性',width:'70px',align:'center'},
			{field:'studyAgain',title:'在学一次',width:'70px',align:'center'},
			{field:'satis',title:'满意程度',width:'70px',align:'center'},
			{field:'purpose',title:'是否达到目的',width:'90px',align:'center'},
			{field:'suggestion',title:'建议',width:'250px',align:'center'},
			{field:'submitDate',title:'日期',width:'100px',align:'center',formatter:function(value,row,index){
				return new Date(value).Format("yyyy-MM-dd")
			}},
		]],
		striped:true,
		loadMsg:"加载中....",
		toolbar:[{
			text:searchDate,
		},{
			text:"查询",
			iconCls:'icon-search',
			handler:function(){
				var eva_sea = $("#J-xl").val();
				var jd = {"date":eva_sea};
				console.info(JSON.stringify(jd));
				$.ajax({
					url:"EvaluateServlet?method=getByDate",
					method:"post",
					dateType:"json",
					data:JSON.stringify(jd),
					contentType:"application/json;charset=utf-8",
					success:function (res) {
						var jo = JSON.parse(res);
					    if(jo == null  || jo.length == 0){
                            $.messager.alert("信息","该日无评价!","error");
                        }
						//loadData方法解析的是json类型的对象，而不是json类型的字符串
						$("#show_eva").datagrid("loadData",jo);
					}
				});
			}
		},'-',{
		    text:"导出当前评价",
            iconCls:"icon-redo",
            handler:function() {
		       	/*
		       		ajax不支持文件的下载和上传，因为ajax仅支持json,string,html格式数据的处理，若传输二进制的数据，则报错
		       	 */
		       	if ($("#show_eva").datagrid("getData").total == 0){
		       		/*
		       		* var data = $('#dg').datagrid('getData');
						alert('总数据量:' + data.total)//注意你的数据源一定要定义了total，要不会为undefined，datagrid分页就是靠这个total定义
						alert('当前页数据量:' + data.rows.length)
		       		* */
					$.messager.alert("消息","当前评价为空，无法下载!","warning");
					return false;
				}
		    	$("#show_eva").datagrid("toExcel","evaluate.xls");
		    }
		}]
	});

	//初始化日历控件
	laydate({
		elem: '#J-xl'
	});

}


$(document).ready(function(){

	initEvaPanel();

	show_evaluate();
});
