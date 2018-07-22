// 选择邮箱
$("#yxzczh").click(function() {
	$("#sjczmmtc").css("display","none");
	$("#emailCodeDiv").css("display","none");
	$("#sjzczh").removeClass("action_6");
	$("#yxzczh").addClass("action_6");
	$("#sjzclbzh").slideUp(300, function() {
		$("#sjzclbzh").css("display", "none");
	});
	$("#yxzclbzh").slideDown(300, function() {
		$("#yxzclbzh").css("display", "block");
	});
});
// 选择手机
$("#sjzczh").click(function() {
	$("#sjczmmtc").css("display","none");
	$("#identCodeDiv").css("display","none");
	$("#yxzczh").removeClass("action_6");
	$("#sjzczh").addClass("action_6");
	$("#yxzclbzh").slideUp(300, function() {
		$("#yxzclbzh").css("display", "none");
	});
	$("#sjzclbzh").slideDown(300, function() {
		$("#sjzclbzh").css("display", "block");
	});
});


// 发送手机验证码
function telpanduan() {
	var sMobile = $("#sjhm").val();
	if(isPhone(sMobile)) {
		// 发送手机验证码
		var qh = $("#quhao option:selected").val();
		
		$.ajax({
			type: 'POST',
			url: "http://192.168.136.1:8080/gme-web/api/v1/security/sendPhoneCheckCode.json",
			data: "phoneCode=" + sMobile + "&type=3" + "&countryCode=" + qh,
			dataType: "json",
			success: function(data) {
				if (data.code == 200) {
					alert("短信验证码已发送，请查看");
				}else {
					alert(data.message);
					return;
				}
			}
		});
	} 
}


// 发送邮箱验证码
function emailpanduan() {
	var temp = $("#youxianghaoma").val();           
	if(isEmail(temp)) {
		// 发送邮箱验证码
		$.ajax({
			type: 'POST',
			url: "http://192.168.136.1:8080/gme-web/api/v1/security/sendEmail.json",
			data: "email=" + temp + "&type=3" ,
			dataType: "json",
			success: function(data) {
				console.debug(data.code);
				if (data.code == "200") {
					alert("邮箱验证码已发送，请查看");
					return;
				}else {
					alert(data.message);
					return;
				}
			}
		});
	}
}



// 重置资金密码
function czmmym() {
	var teb = $("#sjhm").val(),
		em = $("#youxianghaoma").val(),
		sjczyzm = $("#sjczyzm").val(),
		yxczyzm = $("#yxczyzm").val(),
		quhao = $("#quhao option:selected").val();
		mima = $("#denglimima").val(),
		confirmMima = $("#confirmPassword").val(),
		loginPasswordPhone = $("#loginPasswordPhone").val();
		loginPasswordEmail = $("#loginPasswordEmail").val();
		tuijianid = "";
		
	// 手机重置
	if ($("#sjzczh").attr("class") == "L_6 action_6") {
		if ($("#sjczmmtc").css("display") == "none") {
			if ($("#identCodeDiv").css("display") == "none") {
				// 填写登录密码
				if (!isPhone(teb)) {
					return;
				}
				if (loginPasswordPhone == "") {
					alert("bbb登录密码不能为空");
					return;
				}
				$.ajax({
					type: "POST",
					url: "http://192.168.136.1:8080/gme-web/api/v1/security/resetPayPasswordFirst.json",
					data: "account=" + teb + "&loginPassword=" + loginPasswordPhone,
					dataType: "json",
					success: function(data) {
						if (data.code == 200) {
							// 发送短信验证码
							$("#sjczmmtc").css("display","none");
							$("#titleDiv").css("display","none");
							$("#sjzclbzh").css("display","none");
							$("#identCodeDiv").css("display","block");
							return;
						}else {
							alert("验证账号密码:"+data.message);
							return;
						}
					}
				});
			}else {
				// 验证验证码
				if (sjczyzm == "") {
					alert("短信验证码不能为空");
					return;
				}
				$.ajax({
					type: "POST",
					url: "http://192.168.136.1:8080/gme-web/api/v1/security/checkIdentCode.json",
					data: "phoneCode=" + teb + "&identCode=" + sjczyzm + "&type=6",
					dataType: "json",
					success: function(data) {
						if (data.code == 200) {
							// 填写重置密码
							$("#sjczmmtc").css("display","block");
							$("#titleDiv").css("display","none");
							$("#sjzclbzh").css("display","none");
							$("#identCodeDiv").css("display","none");
							return;
						}else {
							alert("验证手机验证码:"+data.message);
							return;
						}
					}
				});
			}
		}else {
			// 修改密码
			if (mima == "") {
				alert("新密码不能为空");
				return;
			}
			if (mima != confirmMima) {
				alert("两次输入的密码不一致");
				return;
			}
			$.ajax({
				type: 'POST',
				url: "http://192.168.136.1:8080/gme-web/api/v1/security/resetPayPasswordSecond.json",
				data: "account=" + teb + "&newPassword=" + mima,
				dataType: "json",
				success: function(data) {
					if (data.code == 200) {
						window.location.href="http://192.168.136.1:8080/gme-web/firstLogin.html";
						return;
					}else {
						alert(data.message);
						return;
					}
				}
			});
		}
	}else { // 邮箱重置
		if ($("#sjczmmtc").css("display") == "none") {
			if ($("#emailCodeDiv").css("display") == "none") {
				// 填写登录密码
				if (!isEmail(em)) {
					return;
				}
				if (loginPasswordEmail == "") {
					alert("aaa登录密码不能为空");
					return;
				}
				$.ajax({
					type: "POST",
					url: "http://192.168.136.1:8080/gme-web/api/v1/security/resetPayPasswordFirst.json",
					data: "account=" + em + "&loginPassword=" + loginPasswordEmail,
					dataType: "json",
					success: function(data) {
						if (data.code == 200) {
							// 发送短信验证码
							$("#sjczmmtc").css("display","none");
							$("#titleDiv").css("display","none");
							$("#yxzclbzh").css("display","none");
							$("#emailCodeDiv").css("display","block");
							return;
						}else {
							alert("验证账号密码:"+data.message);
							return;
						}
					}
				});
			}else {
				// 验证邮箱验证码
				if (yxczyzm == "") {
					alert("邮箱验证码不能为空");
					return;
				}
				$.ajax({
					type: "POST",
					url: "http://192.168.136.1:8080/gme-web/api/v1/security/checkEmailCode.json",
					data: "email=" + em + "&emailCode=" + yxczyzm + "&type=4",
					dataType: "json",
					success: function(data) {
						if (data.code == 200) {
							// 填写重置密码
							$("#sjczmmtc").css("display","block");
							$("#titleDiv").css("display","none");
							$("#sjzclbzh").css("display","none");
							$("#identCodeDiv").css("display","none");
							return;
						}else {
							alert("验证邮箱验证码:"+data.message);
							return;
						}
					}
				});
			}
		}else {
			// 修改密码
			if (mima == "") {
				alert("新密码不能为空");
				return;
			}
			if (mima != confirmMima) {
				alert("两次输入的密码不一致");
				return;
			}
			$.ajax({
				type: 'POST',
				url: "http://192.168.136.1:8080/gme-web/api/v1/security/resetPayPasswordSecond.json",
				data: "account=" + teb + "&newPassword=" + mima,
				dataType: "json",
				success: function(data) {
					if (data.code == 200) {
						window.location.href="http://192.168.136.1:8080/gme-web/firstLogin.html";
						return;
					}else {
						alert(data.message);
						return;
					}
				}
			});
		}
	}
}