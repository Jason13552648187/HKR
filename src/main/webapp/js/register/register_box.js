/**
 * 年龄校验
 */
function validateAge(){
	var value = $("#valid_age").val();
	if (value <  15 || value > 75) {
		layer.alert("年龄仅支持15 到 75岁之间!");
	}
}


/**
 * 展示所有课程名
 * @param result
 */
function showCourse(result){
	var coursename = "";
	for(var i in result){
		coursename += "<option value=" + result[i]['courseName'] + ">" + result[i]['courseName'] + "</option>";
	}
	$("#classname").html(coursename);
}


/**
 * 异步初始化课程名
 */
function InitCourseShow(){
	$.ajax({
		url:"CourseServlet?method=findAllCourse",
		method:"post",
		dataType:"json",
		contentType:"application/json;charset=utf-8",
		success:function(result){
			showCourse(result);
		}
	});
}

/**
 * 表单校验化校验
 * @returns
 */
function checkReg(){
	var f = $("#msform").form("validate");
	if(!f){
		return f;
	}else{
		return true;
	}
}

function checkLoginname(){
	var value = $("#loginname").val();
	var j = {"loginname":value};
	var result = $.ajax({
		url:"UserServlet?method=findByLoginname",
		data:JSON.stringify(j),
		dataType:"json",
		contentType:"application/json;charset=utf-8",
		method:"post",
		async:false,
		success:function(f){
			return false;
		}
		/*success:function(result){
			if(!result.status){
				$.messager.alert("失败",result.msg,"error");
				return false;
			}
			return true;
		}*/
	});
	json = JSON.parse(result.responseText);
	if(!json.status){
		$.messager.alert("失败",json.msg,"error");
		return false;
	}
	return true;
}


function checkEmail(){
	var value = $("#reg_mail").val();
	var j = {"email":value};
	var result = $.ajax({
		url:"UserServlet?method=findByEmail",
		data:JSON.stringify(j),
		dataType:"json",
		contentType:"application/json;charset=utf-8",
		method:"post",
		async:false,
		success:function(f){
			return false;
		}
		/*success:function(result){
			if(!result.status){
				$.messager.alert("失败",result.msg,"error");
				return false;
			}
			return true;
		}*/
	});
	json = JSON.parse(result.responseText);
	if(!json.status){
		$.messager.alert("失败",json.msg,"error");
		return false;
	}
	return true;
	
}
