/**
 *
 * 请求学生毕业状态
 * @param uid
 * @param status
 */
function setStatus(uid,status){

	$.ajax({
		url:"TeacherServlet?method=setGranduationStatus",
		data:JSON.stringify({"uid":uid,"graduation":status}),
		method:"post",
		dataType:"json",
		contentType:"application/json;charset=utf-8",
		success:function(result){
			if(result){
				$.messager.alert("成功","修改成功!","info");
			}else{
				$.messager.alert("失败","修改失败，请稍后重试!","info");
			}
			$("#show_student").datagrid("reload");
		}

	});
}

function  setGraduation(uid){
	setStatus(uid,false);
}

function setNotGraduation(uid){
	setStatus(uid,true);
}




/*
 * 初始化面板
 */
function initPanel(){
	$("#stu_panel").panel({
		width:"auto",
		height:"auto",
		title:panel_title,
		/*tools:[{
			text:"添加学生",
			iconCls:"icon-add",
			handler:function(){
				$("#dia_stu_add").dialog({
					title:"添加学生",
					resizable:true,
					modal:true,
					buttons:[{	
				        	 text:"添加",
				        	 iconCls:"icon-ok",
				        	 handler:function(){
				        		 $.messager.alert("消息","添加成功!","info",function(){
				        			 $("#dia_stu_add").dialog('close');
				        			 $("#show_teacher").datagrid('reload');
				        		 });
				        	 }
					         },{
					        	 text:"取消",
					        	 iconCls:"icon-cancel",
					        	 handler:function(){
					        		 $("#dia_stu_add").dialog('close');
					        	 }
					         }]
				});
				$("#dia_add").show();
			}
		}],*/
	});
}

/*
 * 展示老师 
 */
function show_student(){
	$("#show_student").datagrid({
		url:"UserServlet?method=findAllStudent",
		columns:[[
		          {field:'--',title:'序号',width:"50px",formatter:function(value,row,index){
		        	  index ++;
		        	  return index;
		          }},
		          {field:'loginname',title:'登录名',width:"100px"},
		          {field:'username',title:'真实姓名',width:"100px"},
		          {field:'password',title:'密码',width:"250px"},
		          {field:'sex',title:'性别',width:"60px"},
		          {field:'age',title:'年龄',width:"60px"},
		          {field:'address',title:'地址',width:"100px"},
		          {field:'phoneNumber',title:'电话号码',width:"100px"},
		          {field:'classname',title:'课程',width:"120px"},
		          {field:'--------',title:'毕业状态',width:"120px",formatter:function(value,row,index){
		        	  return row.graduation  == false  ? "已完成学业" : "在校";
		          }},
		          {field:'---',title:'设置',width:"100px",formatter:function(value,row,index){
		        	  var uid = row.uid;
		        	  var content = "<a href='";

		        	  var ok = "<a href='javascript:setGraduation(\"" + uid + "\")'>设置为毕业</a>";
		        	  var notok = "<a href='javascript:setNotGraduation(\"" + uid + "\")'>设置为未毕业</a>";

		        	  if(row.graduation){
		        	      return ok;
		        	  }else{
		        		  return notok;
		        	  }
		        	 return content;
		          }},
		]],
		singleSelect:true,
		toolbar:[{
			text:searchNameDate
		},{
			text:searchPhoneDate
		},"-",{
			text:"查询",
			iconCls:"icon-search",
			handler:function(){
				var stuname = $("#J-stu").val();
				var stuphone = $("#J-phone").val();
				$.ajax({
					url:"UserServlet?method=findByUsernameAndPhone",
					method:"post",
					dataType:"json",
					data:JSON.stringify({"username":stuname,"phoneNumber":stuphone}),
					contentType:"application/json;charset=utf-8",
					success:function(result){
						$("#show_student").datagrid("loadData",result);
					}
				});
			}
		}]
	});
}


$(document).ready(function(){
	
	//初始化面板
	initPanel();
	
	
	//展示老师
	show_student();


});