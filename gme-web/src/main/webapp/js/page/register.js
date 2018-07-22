// 如果是激活邮件失败跳转到注册页面，需要弹框提示
var flag = $("#activeFailed").val();
if (flag != "") {
	alert(flag);
}


// 邮箱注册
$("#yxzc").click(function() {
$("#sjzc").removeClass("action_6");
$("#yxzc").addClass("action_6");
$("#sjzclb").slideUp(0, function() {
	$("#sjzclb").css("display", "none");
});
$("#yxzclb").slideDown(0, function() {
	$("#yxzclb").css("display", "block");
	});
});

// 手机号注册
$("#sjzc").click(function() {
$("#yxzc").removeClass("action_6");
$("#sjzc").addClass("action_6");
$("#yxzclb").slideUp(0, function() {
	$("#yxzclb").css("display", "none");
});
$("#sjzclb").slideDown(0, function() {
	$("#sjzclb").css("display", "block");
	});
});

// 发送短信验证码
function telpanduan() {
	var sMobile = $("#sjhm").val();
	var quhao = $("#quhao option:selected").val();
	if(isPhone(sMobile)) {
		$.ajax({
			type: 'POST',
			url: "http://192.168.136.1:8080/gme-web/api/v1/security/sendPhoneCheckCode.json",
			data: "phoneCode=" + sMobile + "&type=1" + "&countryCode=" + quhao,
			dataType: "json",
			success: function(data) {
				if (data.code == 200) {
					alert("短信验证码已发送，请查看");
				}else {
					alert(data.message);
					return;
				}
			}
		})
	}
}


$(document).click(function() {
	if($("#yhxy").is(":checked") != true) {
		$("#zczhan").attr("disabled", true);
	} else {
		$("#zczhan").removeAttr("disabled");
	}
})



function zczh() {
var teb = $("#sjhm").val(),
	em = $("#youxianghaoma").val(),
	quhao = $("#quhao").change(function() {}),
	quhaoxuanz = $("#quhao").find("option:selected").text(),
	tebyzm = $("#sjyzm").val(),
	mima = $("#denglimima").val(),
	zijinmima = $("#zijinmima").val(),
	validataImg = $("#validataImg").val();
	tuijianid = "";
if($("#sjzclb").css("display") != "none") { // 手机注册
	$.ajax({
		type: 'POST',
		url: "http://192.168.136.1:8080/gme-web/api/v1/user/phoneRegister.json",
		data: "phoneCode=" + teb + "&countryCode=" + quhaoxuanz + "&identCode=" + tebyzm + "&password=" + mima + "&tradeAuth=" + zijinmima + "&refereeId=" + tuijianid + "&imgCode=" + validataImg,	
		dataType: "json",
		success: function(data) {
			if (data.code == 200) {
				alert("注册成功");
				window.location.href="http://192.168.136.1:8080/gme-web/firstLogin.html";			
				return;
			}else {
				alert(data.message);
				window.location.reload();
				return;
			}
		}
	});
} else {
	$.ajax({
		type: 'POST',
		url: "http://192.168.136.1:8080/gme-web/api/v1/user/emailRegister.json",
		data: "email=" + em + "&password=" + mima + "&tradeAuth=" + zijinmima + "&refereeId=" + tuijianid,
		dataType: "json",
		success: function(data) {
			if (data.code == 200) {
				// 如果注册成功，提醒用户去邮箱激活
					alert(data.message);
					return;
				}else {
					alert(data.message);
					window.location.reload();
					return;
				}
			}
		});
	}
}