/**
 * 初始化面板
 */
function initEvaPanel(){
	$("#history").panel({
		width:"auto",
		height:"700px",
		title:title,
	});
}

function show_evaluate(){
	$("#show_history").datagrid({
		url:'LogServlet?method=findAllLog',
		method:'post',
		singleSelect:true,
		nowrap:false,
		pagination:true,
		columns:[[
			{field:'role',title:'角色',width:'70px',align:'center'},
			{field:'username',title:'用户名',width:'50px',align:'center'},
			{field:'operation',title:'操作',width:'150px',align:'center'},
			{field:'opera_time',title:'操作时间',width:'150px',align:'center',formatter:function(value,row,index){
				return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
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
				var his_sea = $("#J-history").val();
				var jd = {"date":his_sea};
				console.info(JSON.stringify(jd));
				$.ajax({
					url:"LogServlet?method=findByDate",
					method:"post",
					dateType:"json",
					data:JSON.stringify(jd),
					contentType:"application/json;charset=utf-8",
					success:function (res) {
						var hislist = JSON.parse(res);
					    if(hislist == null  || hislist.length == 0){
                            $.messager.alert("信息","该日无评价!","error");
                        }
						//loadData方法解析的是json类型的对象，而不是json类型的字符串
						$("#show_history").datagrid("loadData",hislist);
					}
				});
			}
		},'-',{
		    text:"导出当前日志",
            iconCls:"icon-redo",
            handler:function() {
		       	/*
		       		ajax不支持文件的下载和上传，因为ajax仅支持json,string,html格式数据的处理，若传输二进制的数据，则报错
		       	 */
		       	if ($("#show_history").datagrid("getData").total == 0){
		       		/*
		       		* var data = $('#dg').datagrid('getData');
						alert('总数据量:' + data.total)//注意你的数据源一定要定义了total，要不会为undefined，datagrid分页就是靠这个total定义
						alert('当前页数据量:' + data.rows.length)
		       		* */
					$.messager.alert("消息","当前日志为空，无法下载!","warning");
					return false;
				}
		    	$("#show_history").datagrid("toExcel","evaluate.xls");
		    }
		}]
	});

	//初始化日历控件
	laydate({
		elem: '#J-history'
	});

}


$(document).ready(function(){

	initEvaPanel();

	show_evaluate();
});
