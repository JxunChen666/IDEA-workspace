//全局变量flag用于判断是否可以注册
var flag = false;

//判断用户名
function checkNamea() {

  	// 获取 CSRF Token
  	var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
  
	
	
	// 获取用户输入的用户名！
	var name = $("#luser").val();
	var reg = /\s/;
	if (name == "" || name == null) {
		// 用户名为空事件！
		$("#luser").attr('placeholder', '用户名不能为空');
		$("#luser").css("border", "1px solid red");
		flag = false;
		return false;
	} else if (reg.test(name)) {
		// 用户名包含空格事件！
		$("#luser").val("");
		$("#luser").attr('placeholder', '用户名不能包含空格');
		$("#luser").css("border", "1px solid red");
		flag = false;
		return false;
	} else {
		$.ajax({
			url : '/userNameIsNot',
			type : 'POST',
			data : {
				"loginname" : name
			},
			error : function() {
			//	alert("异常");
			},
			  beforeSend: function(request) {
          		  request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
       		 }, 
			success : function(data) {

				if (data.isnot == true) {
					$("#luser").val("");
					$("#luser").attr('placeholder', '用户名重复');
					$("#luser").css("border", "1px solid red");
					flag = false;
					return false;
				} else {
					$("#luser").attr('placeholder', '');
					$("#luser").css("border", "1px solid #cccccc");
					flag = true;
					return true;
				}

			}
		});
	}
}
/*****************************密码1********************************/
function checkpwd(){
	//获取输入的密码
	var pwd = $("#pwd").val();
	var reg = /\s/;
	
	if(pwd == ""||pwd == null){
		$("#pwd").attr('placeholder', '请输入密码');
		$("#pwd").css("border", "1px solid red");
		flag = false;
		return false;
	}else{
		$("#pwd").css("border", "1px solid #cccccc");
		flag = true;
		return true;
	}
	
	if (reg.test(pwd)) { // 验证字符串中是否包含空格！
		$("#pwd").val("");
		$("#pwd").attr('placeholder', '密码不能包含空格');
		$("#pwd").css("border", "1px solid red");
		flag = false;
		return false;
	} else {
		$("#pwd").attr('placeholder', '6~16位字符，区分大小写');
		$("#pwd").css("border", "1px solid #cccccc");
		flag = true;
		return true;
	}
	
	if (pwd.length < 6) { // 验证密码长度
		$("#pwd").attr('placeholder', '长度不能小于6');
		$("#pwd").css("border", "1px solid red");
		flag = false;
		return false;
	} else {
		$("#pwd").attr('placeholder', '6~16位字符，区分大小写');
		$("#pwd").css("border", "1px solid #cccccc");
		flag = true;
		return true;
	}
}
/************************密码2***********************/
/**
 * 验证两次输入密码是否一致
 */
function eqPwd() {
	var pwd = $("#pwd").val();
	var passworded = $("#l_pwd").val();
	if (pwd == null || pwd == "") {
		$("#pwd").attr('placeholder', '请输入密码');
		$("#pwd").css("border", "1px solid red");
		flag = false;
		return false;
	}
	if (pwd == passworded) {
		$("#l_pwd").css("border", "1px solid #cccccc");
		flag = true;
		return true;
	} else {
		$("#l_pwd").attr('placeholder', '两次密码输入不一致');
		$("#l_pwd").css("border", "1px solid red");
		flag = false;
		return false;
	}
}

//**********************真实姓名******************//
function checkNumName() {
	var name = $("#username").val();
	if (name == null || name == "") {
		$("#username").attr('placeholder', '输入您得姓名');
		$(".l_num").css("border", "1px solid red");
		flag = false;
		return false;
	} else {
		$(".l_num").css("border", "1px solid #cccccc");
		flag = true;
		return true;
	}
}

//********************身份证******************//
function checkLenMem() {
	var mem = $("#l_mem").val();
	
	if (mem.length != 18 || !checkIdentityCode(mem)) { // 验证身份证长度
		$("#l_mem").attr('placeholder', '请输入正确的身份证');
		$(".l_mem").css("border", "1px solid red");
		flag = false;
		return false;
	} else {
		$(".l_mem").css("border", "1px solid #cccccc");
		flag = true;
		return true;
	}
}
/**
 * 验证身份证号码正则表达式！
 */
function checkIdentityCode(mem) {
	var reg = /^\w{18}$/;
	if (reg.test(mem)) {
		flag = true;
		return true;
	} else {
		flag = false;
		return false;
	}
}

//********************邮箱******************//
function checkNullEmail() {
	var mem = $("#l_email").val();
	if (mem == null || mem == "" || !checkEamil(mem)) { // 验证邮箱格式
		$("#l_email").attr('placeholder', '请输入正确的邮箱格式');
		$(".l_email").css("border", "1px solid red");
		flag = false;
		return false;
	} else {
		$("#l_email").attr('placeholder', '请输入您的常用邮箱');
		$(".l_email").css("border", "1px solid #cccccc");
		flag = true;
		return true;
	}
}
/**
 * 验证邮箱正则表达式！
 */
function checkEamil(eamil) {
	var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (reg.test(eamil)) {
		flag = true;
		return true;
	} else {
		flag = false;
		return false;
	}
}
/*********************手机*********************/


function checkNullTel() {
	var reg = /^\d{5,11}$/;
	var mem = $("#mobile").val();
	if (mem == null || mem == "" || !reg.test(mem)) { // 验证手机格式
		$("#mobile").attr('placeholder', '请输入正确的手机号');
		$(".l_tel").css("border", "1px solid red");
		flag = false;
		return false;
	} else {
		$(".l_tel").css("border", "1px solid #cccccc");
		flag = true;
		return true;
	}
}
/**********************获取验证码**********************/
function createmobile(){
	
	// 获取 CSRF Token
  	var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
  
	
	
	
	
	var reg = /^\d{5,11}$/;
	var mem = $("#mobile").val();
	if (mem == null || mem == ""|| !reg.test(mem)) { // 验证手机格式
		$("#mobile").attr('placeholder', '请输入正确的手机号');
		$(".l_tel").css("border", "1px solid red");
		
		return false;
	} else {
		
		$(".l_tel").css("border", "1px solid #cccccc");
		$.ajax({
            type: "Post",
            url: "dianjihuoqu",
            data: {"mobile":mem},
            beforeSend: function(request) {
        		  request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
     		 }, 
            success: function (data) {
            	if(data.isok == true){
            		$("#textyanzhengma").removeAttr("disabled");
            	}else{
            		$("#textyanzhengma").attr("disabled","disabled");
            	}
            	
            }
        });
		/*reSendCountdown();*/
	}
}

function panduanyzm(){
	
	// 获取 CSRF Token
  	var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
  
	
	
	
	var textyanzhengma = $("#textyanzhengma").val();
	var mem = $("#mobile").val();
	var reg = /^\d{5,11}$/;
	if(textyanzhengma==""||textyanzhengma==null){
		$("#textyanzhengma").attr('placeholder', '请输入验证码');
		$("#textyanzhengma").css("border", "1px solid red");
		flag = false;
		return false;
	}else if(mem == null || mem == ""|| !reg.test(mem)) { // 验证手机格式\
		$("#mobile").attr('placeholder', '请输入正确的手机号');
		$(".l_tel").css("border", "1px solid red");
		return false;
	}else{
		$.ajax({
			url : '/yanzmc',
			type : 'POST',
			data : {
				"yzm" : textyanzhengma
			},
			error : function() {
				alert("异常");
			},
			   beforeSend: function(request) {
           		  request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
        		 }, 
			success : function(data) {
				if (data.isok == true) {
					$("#textyanzhengma").removeAttr("disabled");
					$("#textyanzhengma").val("");
					$("#textyanzhengma").attr('placeholder', '验证码输入错误');
					$("#textyanzhengma").css("border", "1px solid red");
					flag = false;
					return false;
				} else {
					$("#textyanzhengma").attr('placeholder', '');
					$("#textyanzhengma").css("border", "1px solid #cccccc");
					flag = true;
					return true;
				}
			}
		});
	}
}





/*//60s后重新发送手机验证码
var reSendCountdown = function(){
    var count = 60;//禁用时间为60秒
    //解绑按钮的点击事件（该按钮是一个a标签）
    $("#alianjie").html(count+"秒后点击重新发送").addClass("resend").unbind("click");
    var resend = setInterval(function(){
    count--;
    if (count > 0){
    	$("#alianjie").html(count+"秒后点击重新发送");
    }else {
	clearInterval(resend);//清除计时
	//重新绑定按钮的click事件
	$("#alianjie").bind("click", sendPhoneCode).removeClass("resend").html("重新获取验证码");
	phoneTipBox.removeClass().addClass("tishi").html("如果没有收到短信，请点击重新发送！");
    }
}, 1000);
}*/
/***********************立即注册按钮点击事件！***********************/
$(function(){
	$("#Reg_btn").click(function() {
		checkNamea();//用户名
		checkpwd();//密码1
		checkNumName();//真实姓名
		checkNullTel();//手机
		panduanyzm();//验证码
		if(flag == true){
			document.getElementById("formid").submit();
		}else{

		}
	});
});


