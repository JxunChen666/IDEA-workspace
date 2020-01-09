$(document).ready(function() {
	//开始先显示验证码
	//createCode();

			// **********************昵称******************//
			$('#luser')
				.on(
					{
						'input propertychange' : function() {
							if (!checkNamea()) {
								$("#errName").slideDown(50);
							}
						},
						blur : function() {
							if (checkNamea()) {
								$("#errName").slideUp(50);
								$("#luser").css("border", "1px solid #cccccc");
							} else {
								$("#luser").css("border", "1px solid red");
								$("#errName").slideDown(50);
							}
						},
						focus : function() {

							if (checkNamea()) {
								$("#errName").slideUp(50);
								$("#errNullName")
									.css("background",
										"url(/EasyBuy/statics/images/green.png) no-repeat left 5px");
							}

							$("#luser").css("border",
								"1px solid #cccccc");
						}
					});
			
			var flag = true;
			
			/**
			 * 验证用户名是否存在
			 */
			function checkNamea() {
				// 获取用户输入的用户名！
				var name = $("#luser").val();
				var reg = /\s/;
				if (name == "" || name == null) {
					// 用户名为空事件！
					$("#errNullName")
						.css("background",
							"url(/EasyBuy/statics/images/errorpwd.png) no-repeat left 5px");
					$("#errNullName").children().html("用户名不能为空");
					flag = false;
					return false;
				} else if (reg.test(name)) {
					// 用户名包含空格事件！
					$("#errNullName")
						.css("background",
							"url(/EasyBuy/statics/images/errorpwd.png) no-repeat left 5px");
					$("#errNullName").children().html("用户名不能包含空格");
					flag = false;
					return false;
				} else{
					$("#errNullName").children().html("");
					flag = true;
					return true;
				}
			}
			// ********************昵称end******************//

			// **********************密码******************//
			/**
			 * 验证密码
			 */
			$("#pwd").on({
				'input propertychange' : function() {
					var pwd = $("#pwd").val();
					checkLen(pwd);
					checkNull(pwd);
				},
				blur : function() {
					var pwd = $("#pwd").val();
					if (checkNull(pwd)) {
						$("#err").slideUp(50);
					}
					if (checkLen(pwd)) {
						$("#err1").slideUp(50);
					}
				},
				focus : function() {
					$("#err1").slideDown(50);
					$("#err").slideDown(50);
					$("#pwd").css("border", "1px solid #cccccc");
				}
			});
			/**
			 * 验证字符串中是否包含空格！
			 */
			function checkNull(pwd) {
				var reg = /\s/;
				if (reg.test(pwd)) { // 验证字符串中是否包含空格！
					$("#lengt")
						.css("background",
							"url(/EasyBuy/statics/images/errorpwd.png) no-repeat left 5px");
					$("#pwd").css("border", "1px solid red");
					flag = false;
					return false;
				} else {
					$("#lengt")
						.css("background",
							"url(/EasyBuy/statics/images/green.png) no-repeat left 5px");
					$("#pwd").css("border", "1px solid #cccccc");
					flag = true;
					return true;
				}
			}
			/**
			 * 验证密码长度
			 */
			function checkLen(pwd) {
				if (pwd.length < 6) { // 验证密码长度
					$("#leng")
						.css("background",
							"url(/EasyBuy/statics/images/info.png) no-repeat left 5px");
					$("#pwd").css("border", "1px solid red");
					flag = false;
					return false;
				} else {
					$("#leng")
						.css("background",
							"url(/EasyBuy/statics/images/green.png) no-repeat left 5px");
					$("#pwd").css("border", "1px solid #cccccc");
					flag = true;
					return true;
				}
			}
			/**
			 * 验证两次输入密码是否一致
			 */
			function eqPwd() {
				var pwd = $("#pwd").val();
				var passworded = $("#l_pwd").val();
				if (passworded == null || passworded == ""
					|| pwd == null || pwd == "") {
					$("#errEqPwd").children().html("请输入密码！");
					$("#errEqPwd")
						.css("background",
							"url(/EasyBuy/statics/images/info.png) no-repeat left 5px");
					flag = false;
					return false;
				}
				if (pwd == passworded) {
					$("#errEqPwd")
						.css("background",
							"url(/EasyBuy/statics/images/green.png) no-repeat left 5px");
					$("#l_pwd").css("border", "1px solid #cccccc");
					flag = true;
					return true;
				} else {
					$("#errEqPwd")
						.css("background",
							"url(/EasyBuy/statics/images/info.png) no-repeat left 5px");
					$("#errEqPwd").children().html("两次输入密码一致");
					flag = false;
					return false;
				}
			}
			$("#l_pwd").on({
				'input propertychange' : function() {
					eqPwd();
				},
				blur : function() {
					if (eqPwd()) {
						$("#errPwd").slideUp(50);
					} else {
						$("#l_pwd").css("border", "1px solid red");
					}
				},
				focus : function() {
					eqPwd();
					$("#errPwd").slideDown(50);
					$("#l_pwd").css("border", "1px solid #cccccc");
				}
			});

			// **********************密码******************//
			// **********************真实姓名******************//
			function checkNumName(name) {
				if (name == null || name == "") {
					$("#errNullNum")
						.css("background",
							"url(/EasyBuy/statics/images/info.png) no-repeat left 5px");
					$(".l_num").css("border", "1px solid red");
					flag = false;
					return false;
				} else {
					$("#errNullNum")
						.css("background",
							"url(/EasyBuy/statics/images/green.png) no-repeat left 5px");
					$(".l_num").css("border", "1px solid #cccccc");
					flag = true;
					return true;
				}
			}
			$(".l_num").blur(function() {
				var numName = $(".l_num").val();
				if (checkNumName(numName)) {
					$("#errNum").slideUp(50);
				} else {
					$("#errNum").slideDown(50);
				}
			});
			$(".l_num").focus(function() {
				$("#errNum").slideDown(50);
				$(".l_num").css("border", "1px solid #cccccc");
			});
			$(".l_num").on('input propertychange', function() {
				var numName = $(".l_num").val();
				checkNumName(numName);
			});

			// ********************真实姓名end******************//
			// ********************身份证******************//
			$(".l_mem").on({
				'input propertychange' : function() {
					var mem = $(".l_mem").val();
					checkLenMem(mem);

				},
				blur : function() {
					var mem = $(".l_mem").val();
					if (checkLenMem(mem)) {

						$("#errMem").slideUp(50);
					} else {
						$(".l_mem").css("border", "1px solid red");
					}
				},
				focus : function() {
					$("#errMem").slideDown(50);
					$(".l_mem").css("border", "1px solid #cccccc");
				}
			});

			function checkLenMem(mem) {
				if (mem.length != 18 || !checkIdentityCode(mem)) { // 验证身份证长度
					$("#errNullMem1")
						.css("background",
							"url(/EasyBuy/statics/images/errorpwd.png) no-repeat left 5px");
					flag = false;
					return false;
				} else {
					$("#errNullMem1")
						.css("background",
							"url(/EasyBuy/statics/images/green.png) no-repeat left 5px");
					$(".l_mem").css("border", "1px solid #cccccc");
					flag = true;
					return true;
				}
			}
    // ********************身份证end******************//
			// ********************邮箱******************//
			$(".l_email").on({
				'input propertychange' : function() {
					var mem = $(".l_email").val();
					checkNullEmail(mem);

				},
				blur : function() {
					var mem = $(".l_email").val();
					if (checkNullEmail(mem)) {

						$("#errEmail").slideUp(50);
					} else {
						$(".l_email").css("border", "1px solid red");
					}
				},
				focus : function() {
					$("#errEmail").slideDown(50);
					$(".l_email").css("border", "1px solid #cccccc");
				}
			});

			function checkNullEmail(mem) {
				if (mem == null || mem == "" || !checkEamil(mem)) { // 验证邮箱格式
					$("#errNullEmail")
						.css("background",
							"url(/EasyBuy/statics/images/errorpwd.png) no-repeat left 5px");
					flag = false;
					return false;
				} else {
					$("#errNullEmail")
						.css("background",
							"url(/EasyBuy/statics/images/green.png) no-repeat left 5px");
					$(".l_email").css("border", "1px solid #cccccc");
					flag = true;
					return true;
				}
			}
    // ********************邮箱end******************//
			// ********************手机******************//
			$(".l_tel").on({
				'input propertychange' : function() {
					var mem = $(".l_tel").val();
					checkNullTel(mem);

				},
				blur : function() {
					var mem = $(".l_tel").val();
					if (checkNullTel(mem)) {

						$("#errTel").slideUp(50);
					} else {
						$(".l_tel").css("border", "1px solid red");
					}
				},
				focus : function() {
					$("#errTel").slideDown(50);
					$(".l_tel").css("border", "1px solid #cccccc");
				}
			});

			function checkNullTel(mem) {
				if (mem == null || mem == "" || !checkMobile(mem)) { // 验证手机格式
					$("#errNullTel")
						.css("background",
							"url(/EasyBuy/statics/images/errorpwd.png) no-repeat left 5px");
					flag = false;
					return false;
				} else {
					$("#errNullTel")
						.css("background",
							"url(/EasyBuy/statics/images/green.png) no-repeat left 5px");
					$(".l_tel").css("border", "1px solid #cccccc");
					flag = true;
					return true;
				}
			}
    // ********************手机end******************//
			/**
			 * 回车键点击事件！
			 */
			/*$('form').on('keypress', function(event) {
				if (event.keyCode == 13) {
					regst();
				}
			});*/
			
			/**
			 * 立即注册按钮点击事件！
			 */
			$("#Reg_btn").click(function() {
				
				if(flag == true){
					regst();
				}
			});
			
			/*$(".textyanzhengma").on({
				'input propertychange' : function() {
					var mem = $(".textyanzhengma").val();
					validate(mem);

				},
				blur : function() {
					var mem = $(".textyanzhengma").val();
					if (validate(mem)) {

						$("#yanzheng").slideUp(50);
					} else {
						$(".textyanzhengma").css("border", "1px solid red");
					}
				},
				focus : function() {
					$("#yanzheng").slideDown(50);
					$(".textyanzhengma").css("border", "1px solid #cccccc");
				}
			});*/
			
			/**
			 * 校验验证码！
			 * 
			 * @returns
			 */
		/*	function validate(tyzm) {
				var inputCode = document.getElementById("textyanzhengma").value.toUpperCase(); // 取得输入的验证码并转化为大写
				var inputCod = document.getElementById("yanzhengma");
				if (inputCode.length <= 0) { // 若输入的验证码长度为0
					alert("请输入验证码！"); // 则弹出验证码输入错误
					flag = false
					return false;
				} else if (inputCode != code) { // 若输入的验证码与产生的验证码不一致时
					
					createCode(); // 刷新验证码
					document.getElementById("textyanzhengma").value = ""; // 清空文本框
					flag = false;
					return false;
				}else{
					flag = true;
					return true;
				}
			}*/
			
			function regst() {
				// 获取用户需要注册的数据！
				var name = $(".l_user").val();
				var pwd = $("#pwd").val();
				var passworded = $("#l_pwd").val();
				var numName = $(".l_num").val();
				var sex = $("input[name='ra']:checked").val();
				var mem = $(".l_mem").val();
				var email = $(".l_email").val();
				var phone = $(".l_tel").val();
				var tyzm=$("#textyanzhengma").val();
				/* 非空验证 */
				if (!checkNamea()) {
					$("#errName").slideDown(50);

				} else if (!checkNull(pwd)) {
					$("#err").slideDown(50);

				} else if (!checkLen(pwd)) {
					$("#err1").slideDown(50);

				} else if (!eqPwd()) {
					$("#errPwd").slideDown(50);
					$("#l_pwd").css("border", "1px solid red");

				} else if (!checkNumName(numName)) {
					$("#errNum").slideDown(50);

				} else if (!checkLenMem(mem)) {
					$("#errMem").slideDown(50);

				} else if (!checkNullEmail(email)) {
					$("#errEmail").slideDown(50);

				} else if (!checkNullTel(phone)) {
					$("#errTel").slideDown(50);

				}else{
					if(flag == true){
						document.getElementById("formid").submit();

					}else{

					}
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

			/**
			 * 验证手机号码正则表达式！
			 */
			function checkMobile(phone) {
				var reg = /^\d{5,11}$/;
				if (reg.test(phone)) {
					flag = true;
					return true;
				} else {
					flag = false;
					return false;
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
         //选中时触发
			$("#txt")
				.click(
					function() {
						if (this.checked) {
							$("#Reg_btn")
								.css("background",
									"url(../statics/images/btn_log.gif) repeat-x center top");
							$("#Reg_btn")
								.removeAttr("disabled");
						} else {
							$("#Reg_btn")
								.css("background",
									"url(../statics/images/s_line.gif) repeat-x center top");
							$("#Reg_btn").attr("disabled",
								"disabled");
						}
					});
			
			
		});

/**
 * 获取验证码！
 * 
 * @returns
 */	
function createCode() {
	code = "";
	var codeLength = 4; // 验证码的长度
	var checkCode = document.getElementById("yanzhengma");
	var random = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D',
		'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
		'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']; // 随机数
	for (var i = 0; i < codeLength; i++) { // 循环操作
		var index = Math.floor(Math.random() * 36); // 取得随机数的索引（0~35）
		code += random[index]; // 根据索引取得随机数加到code上
	}
	$("#yzm2").val(code);
	checkCode.value = code; // 把code值赋给验证码
}

function createmobile(){
	
	var reg = /^\d{5,11}$/;
	var mem = $("#mobile").val();
	if (mem == null || mem == ""|| !reg.test(mem)) { // 验证手机格式
		alert("请输入正确的手机号！");
		return false;
	} else {
		$.ajax({
            type: "Post",
            url: "dianjihuoqu.html",
            data: {"mobile":mem},
           
            success: function (data) {
                
            }
        });
	}
}

