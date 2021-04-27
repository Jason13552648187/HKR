


/*
 * 初始化面板
 */
function initPanel(){
	$("#course_title").panel({
		width:"auto",
		height:"auto",
		title:course_title,

	});
}

/*
 * 展示课程
 */
function show_course(){
	$("#show_course").datagrid({
		url:"CourseServlet?method=findAllCourse",
		singleSelect:true,
		striped:true,
		nowrap:false,
		columns:[[
		          {field:'--',title:'序号',width:"50px",formatter:function(value,row,index){
		        	  index ++;
		        	  return index;
		          }},
		          {field:'courseName',title:'课程名',width:"200px"},
		          {field:'descri',title:'课程描述',width:"200px"}
		          /*{field:'---',title:'设置',width:"100px",formatter:function(value,row,index){
		        	 return "设置";
		          }},*/
		]],
		toolbar:[{
			text:"添加课程",
			iconCls:"icon-add",
			handler:function(){
				$("#course_add").dialog({
					title:"添加课程",
					resizable:true,
					modal:true,
					buttons:[{
						text:"添加",
						iconCls:"icon-ok",
						handler:function(){

							var jsonData = $("#course_form_add").serializeJSON();
							
							if(jsonData['courseName'].trim().length == 0){
								$.messager.alert("消息","课程名不能为空!,别瞎弄!","error");
								return;
							}else{
								$.ajax({
									url:"TeacherServlet?method=addCourse",
									method:"post",
									data:JSON.stringify(jsonData),
									dataType:"json",
									contentType:"application/json;charset=utf-8",
									success:function(result){
										if (result){
											$.messager.alert("消息","添加成功!","info",function(){
												$("#course_add").dialog('close');
												$("#show_course").datagrid('reload');
											});
										}else{
											$.messager.alert("消息","添加失败！该课程可能已经存在，请稍后再试!","error");
										}
									}
								});
							}
						}
					},{
						text:"取消",
						iconCls:"icon-cancel",
						handler:function(){
							$("#course_add").dialog('close');
						}
					}]

				});
			}
		}]
	});
}




$(document).ready(function(){
	
	//初始化面板
	initPanel();

	//展示课程
	show_course();


});