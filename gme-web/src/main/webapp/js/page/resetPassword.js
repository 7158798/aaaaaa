// 选择邮箱
$("#yxzczh").click(function() {
	// 清空手机号
	$("#sjhm").val("");
	$("#sjczmmtc").css("display","none");
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
	$("#youxianghaoma").val("");
	$("#sjczmmtc").css("display","none");
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
	var sMobile = document.getElementById("sjhm").value;
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



// 重置密码
function czmmym() {
	var teb = $("#sjhm").val(),
		em = $("#youxianghaoma").val(),
		sjczyzm = $("#sjczyzm").val(),
		yxczyzm = $("#yxczyzm").val(),
		quhao = $("#quhao option:selected").val();
		mima = $("#denglimima").val(),
		confirmMima = $("#confirmPassword").val(),
		tuijianid = "";
	if($("#sjczmmtc").css("display") != "none") {
		if(teb == "") { // 邮箱重置登录密码
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
				url: "http://192.168.136.1:8080/gme-web/api/v1/user/resetPassword.json",
				data: "account=" + em + "&password=" + mima,
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
		} else { // 手机重置密码
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
				url: "http://192.168.136.1:8080/gme-web/api/v1/user/resetPassword.json",
				data: "account=" + teb + "&password=" + mima,
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
	} else { // 验证邮箱验证码
		if($("#yxzczh").attr("class") == "L_6 action_6") {
			if (!isEmail(em)) {
				return;
			}
			if (yxczyzm == "") {
				alert("邮箱验证码不能为空");
				return;
			}
			$.ajax({
				type: 'POST',
				url: "http://192.168.136.1:8080/gme-web/api/v1/security/checkEmailCode.json",
				data: "email=" + em + "&emailCode=" + yxczyzm + "&type=3",
				dataType: "json",
				success: function(data) {
					if (data.code == 200) {
						// 填写重置密码
						$("#sjczmmtc").css("display","block");
						$("#titleDiv").css("display","none");
						$("#yxzclbzh").css("display","none");
						return;
					}else {
						alert("验证邮箱验证码:"+data.message);
						return;
					}
				}
			});
		} else if ($("#sjzczh").attr("class") == "L_6 action_6") { // 验证手机验证码
			if (!isPhone(teb)) {
				return;
			}
			if (sjczyzm == "") {
				alert("短信验证码不能为空");
				return;
			}
			$.ajax({
				type: "POST",
				url: "http://192.168.136.1:8080/gme-web/api/v1/security/checkIdentCode.json",
				data: "phoneCode=" + teb + "&identCode=" + sjczyzm + "&type=3",
				dataType: "json",
				success: function(data) {
					if (data.code == 200) {
						// 填写重置密码
						$("#sjczmmtc").css("display","block");
						$("#titleDiv").css("display","none");
						$("#sjzclbzh").css("display","none");
						return;
					}else {
						alert("验证手机验证码:"+data.message);
						return;
					}
				}
			});
		}
	}
}