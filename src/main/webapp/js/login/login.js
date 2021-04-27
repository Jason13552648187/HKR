/**
 * 校验表单
 * @returns
 */
function login_check(){
	
	var password = $("#password").val();
	
	// var flag = ajax_uname_check();
	
	if (password.trim().length <= 0) {
		layer.tips("密码不能为空!","#password",{tips:2})
		return false;
	}

	return true;
}

/**
 * 用户名校验
 * @returns {boolean}
 */
function loginname_check(){
	var name = $("#loginname").val();
	if (name.trim().length == 0){
		layer.tips("用户名或手机号不能为空!","#loginname",{tips:2});
		return false;
	}
	return true;
}




