var bindEmail = $("#bindEmailNum").val();
if (bindEmail != "") {
	// 绑定了邮箱
	$('#L_85').css('display','none');
	$('#L_85_2').css('display','none');
	$('#L_85_3').css('display','block');
	$("#email").text(bindEmail);
} 


//发送验证码
function sendEmailCode(){
	var email = $("#email").val();
	if (isEmail(email)){
		$.ajax({
			type: "POST",
			url: "http://192.168.136.1:8080/gme-web/api/v1/security/sendEmail.json",
			dataType: "json",
			data: "email=" + email + "&type=6",
			success: function (data){
				if (data.code == 200) {
					alert("邮箱验证码已经发送");
				}
			}
		});
	}
};

// 输入资金密码后确认
function sendRequest() {
	var email = $("#email").val();
	var emailCode = $("#emailCode").val();
	var payPassword = $("#zijinmima").val();
	if (payPassword == "") {
		alert("请输入资金密码");
		return;
	}else {
		$.ajax({
			type: "POST",
			url: "http://192.168.136.1:8080/gme-web/api/v1/security/bindEmail.json",
			dataType: "json",
			data: "email=" + email + "&emailCode=" + emailCode + "&tradeAuth=" + payPassword,
			success: function (data){
				if (data.code == 200) {
					var emailNum = data.data;
					$('#L_85').css('display','none');
					$('#L_85_2').css('display','none');
					$('#L_85_3').css('display','block');
					$("#emailNum").text(emailNum);
				}else {
					alert(data.message);
				}
			}
		});
	}
}


//绑定邮箱
function confirmBindEmail(){
	var email = $("#email").val();
	var emailCode = $("#emailCode").val();
	var payPassword;
	if (emailCode == "") {
		alert("邮箱验证码不能为空");
		return;
	}
	if (isEmail(email)){
		$(".tc").css("display","block");
	}
}