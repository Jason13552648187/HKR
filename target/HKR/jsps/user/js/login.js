/**
 * 校验表单
 * @returns
 */
function login_check(){
	
	var password = $("#password").val();
	
	var flag = ajax_uname_check();
	
	if (password.trim().length <= 0) {
		$(msg_pwd).text("密码不能为空!");
		$(msg_pwd).css({
			"color":"red"
		});
		return false;
	}
	if (flag) return flag;
	return true;
}



/*
 * 异步校验用户名
 * @returns {Boolean}
*/
function ajax_uname_check(){
	var loginname = $("#loginname").val();
	
	if (loginname.trim().length <= 0) {
		$("#msg_uname").text("登录名或手机不能为空!别瞎弄!");
		$("#msg_uname").css("color","red")
		return false;
	}
	$.ajax({
		url:"UserServlet",
		dataType:"json",
		data:{
			"method":"ajaxCheckLoginname",
			"loginname":loginname
		},
		success:function(result){
			if (result) {
				$("#msg_uname").text("√");
				$("#msg_uname").css("color","green");
				return true;
			}else{
				
				$("#msg_uname").text("× 该用户不存在或手机号码格式不对!");
				$("#msg_uname").css("color","red");
				return false;
			}
		}
	})
}


/**
 * ajax异步交互校验电话号码
 * @param phone
 */
function ajax_phone_check(phone){
	$.ajax({
		url:"UserServlet",
		dataType:"json",
		method:"post",
		data:{
			"method":"ajaxCheckPhone",
			"phone":phone
		},
		success:function(result){
			if (result) {
				return true;
			}else{
				return false;
			}
		}
	})
}