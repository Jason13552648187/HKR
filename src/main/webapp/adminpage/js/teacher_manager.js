/**
 * 修改密码
 * 
 */
function modifyPwd(tid){
	alert(tid);
	$.ajax({
		url:"TeacherServlet?method=ajaxModifyPwd&tid=" + tid,
		dataType:"json",
		type:"get",
		success:function(result){
			if (result.success) {
				$.messager.alert("提示",result.message,"info");
			}else{
				$.messager.alert("提示",result.message,"info");
			}
		}
	});
}



/*
 * 初始化面板
 */
function initPanel(){
	$("#main_panel").panel({
		width:"auto",
		height:"auto",
		title:panel_title
	});
}

/*
 * 展示老师 
 */
function show_teacher(){
	$("#show_teacher").datagrid({
		url:"TeacherServlet?method=findAllTeacher",
		toolbar:[
		         /*{id:'btn_tea_add',
		          text:"添加",
		          iconCls:"icon-add",
		          handler:function(){
		        	  $("#dia_add").dialog({
							title:"添加讲师",
							resizable:true,
							modal:true,
							buttons:[{
								 text:"添加",
								 iconCls:"icon-ok",
								 handler:function(){
									 $.messager.alert("消息","添加成功!","info",function(){
										 $("#dia_add").dialog('close');
										 $("#show_teacher").datagrid('reload');
									 });
								 }},{
									 text:"取消",
									 iconCls:"icon-cancel",
									 handler:function(){
										 $("#dia_add").dialog('close');
									 }
								 }]
						});
						$("#dia_add").show();
		          }
		         },
		         {
		        	 id:"btn_tea_delete",
		        	 text:"删除",
		        	 iconCls:"icon-remove",
		        	 handler:function(){
		        		 $.messager.alert("信息","删除失败","info");
		        	 }
		         },*/{
		        	text:"<input type='text' name='teacherName' id='sear_teaname' placeholder='教师姓名'/>"
		         },{
		        	 id:"search_user",
		        	 text:"查询",
		        	 iconCls:"icon-search",
		        	 handler:function(){
		        		 var te =  {"teacherName":$("#sear_teaname").val()};
		        		 $.ajax({
		        			 url:"TeacherServlet?method=findByUsername",
		        			 method:"post",
		        			 dataType:"json",
		        			 contentType:"application/json;charset=utf-8",
		        			 data:JSON.stringify(te),
		        			 success:function(res){
		        				 if (res == null) {
		        					 $("#show_teacher").datagrid("loadData",{});
								}else {
									 $("#show_teacher").datagrid("loadData", res);
								 }
								 return false;
							 }
		        		 });
		        	 }
		         }],
		         
		columns:[[
		          {field:'--',title:'序号',width:"50px",formatter:function(value,row,index){
		        	  index ++;
		        	  return index;
		          }},
		          {field:'loginname',title:'登录名',width:"100px"},
		          {field:'teacherName',title:'真实姓名',width:"100px"},
		          {field:'sex',title:'性别',width:"60px"},
		          {field:'age',title:'年龄',width:"60px"},
		          {field:'address',title:'地址',width:"100px"},
		          {field:'phoneNumber',title:'电话号码',width:"100px"},
		          {field:'classname',title:'授课课程',width:"150px"},
		          {field:'---',title:"操作",width:"150px",formatter:function(val,row,index){
		        	  return "<a href='javascript:void(0);' onclick='modifyPwd(" + JSON.stringify(row.tid) + ")'>重置密码</a>";
		          }}
		          ]],
		 singleSelect:true,
		 striped:true
	});
}


$(document).ready(function(){

	//初始化面板
	initPanel();

	//展示老师
	show_teacher();

});