/**
 * 异步校验用户名
*/
function ajax_uname_check(){
	var loginname = $("#loginname").val();
	
	if (loginname.trim().length == 0) {
		// layer.alert("登录名或手机不能为空!别瞎弄!",{icon:2,title:"错误!",btn:["明白了","知道了"]});
		layer.tips("登录名或手机不能为空!","#loginname",{tips:2});
		return false;
	}
}



/**
 * 校验表单
 * @returns
 */
function passwd_check(){
	
	var password = $("#password").val();
	
	if (password.trim().length == 0) {
		// layer.alert("密码不能为空!",{icon:2,title:"错误!",btn:["明白了","知道了"]});
		layer.tips("密码不能为空或者空格!","#password",{tips:2});
		/*$(msg_pwd).css({
			"color":"red"
		});*/
		return false;
	}
	return true;
	
}

/*
 * 登录表单校验 
 */
function login_check(){
	var loginname = $("#loginname").val();

	var password  = $("#password").val();
	
	if(loginname.trim().length == 0){
		// $("#msg_uname").text("登录名或手机不能为空!别瞎弄!");
		// layer.alert("登录名或手机不能为空!别瞎弄!",{icon:2,title:"错误!",btn:["明白了","知道了"]});
		layer.tips("登录名或手机不能为空!别瞎弄!","#loginname",{tips:2})
		$("#msg_uname").css("color","red");
		return false;
	}
	
	if(!passwd_check()){
		return false;
	}
		//异步访问服务进行校验
		// var keypass = CryptoJS.enc.Utf8.parse(password);
		// var keyname = CryptoJS.enc.Utf8.parse(loginname);
		// var encrypted = CryptoJS.AES.encrypt(keypass, keyname, {mode: CryptoJS.mode.ECB, padding: CryptoJS.pad.Pkcs7});
		// var encryptedPwd = encrypted.toString();
		// var key = CryptoJS.enc.Utf8.parse("jaso");
		// var decrypt = CryptoJS.AES.decrypt(encryptedPwd, key, {
		// 	mode: CryptoJS.mode.ECB,
		// 	padding: CryptoJS.pad.Pkcs7
		// });
		// var testDecryptStr = CryptoJS.enc.Utf8.stringify(decrypt).toString();

		// $.ajax({
		// 	url:"teacherLogin",
		// 	dataType:"json",
		// 	data:JSON.stringify({uname:loginname,passwd:passwrod}),
		// 	method:"post",
		// 	contentType:"application/json;charset=utf-8",
		// 	success:function(result){
		// 		layer.msg(result.msg);
		// 	}
		// });
	return true;
}


















/**
 * ajax异步交互校验电话号码
 * @param phone
 */
/*function ajax_phone_check(phone){
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
	});
}*/






