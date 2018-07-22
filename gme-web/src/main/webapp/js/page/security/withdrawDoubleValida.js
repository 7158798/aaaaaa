// 页面加载完
var isOpenPhone = $("#isOpenPhone").val();
var isOpenEmail = $("#isOpenEmail").val();
// 没有开启手机提币验证
if (isOpenPhone == "") {
	$("#phoneText").text("关闭");
	$("#slideOne").attr("checked",false);
}else {
	$("#phoneText").text("开启");
	$("#slideOne").attr("checked","checked");
	$("#L_86_2").css("display", "block");
	//$("#phoneNumber").text("****" + phoneCode.substring(phoneCode.length-4));
	$("#phoneNumber").text(phoneCodeNum);
}
if (isOpenEmail == "") {
	$("#emailText").text("关闭");
	$("#slideOne2").attr("checked",false);
}else {
	$("#emailText").text("开启");
	$("#slideOne2").attr("checked","checked");
	$("#L_85").css("display", "block");
	//$("#phoneNumber").text("****" + phoneCode.substring(phoneCode.length-4));
	$("#emailNumber").text(emailNum);
}


// 选择手机按钮
function c() {
	var phoneCodeNum = $("#phoneCodeNum").val();
	// 绑定了手机
	if (phoneCodeNum != "") {
		if($("#slideOne").is(':checked')) {
			$("#phoneText").text("开启");
			$("#L_86_2").css("display", "block");
			$("#phoneNumber").text(phoneCodeNum);
			return;
		}else { // 用户解除绑定手机提币验证
			$.ajax({
				type: "POST",
				url: "http://192.168.136.1:8080/gme-web/api/v1/security/closeWithdrawValidata.json",
				dataType: "json",
				data: "type=1",
				success: function(data){
					if (data.code == 200) {
						$("#phoneText").text("关闭");
						$('#L_86_1').css('display', 'none');
						$('#L_86_2').css('display', 'none');
					}else {
						$("#phoneText").text("开启");
						$("#slideOne").attr("checked","checked");
						alert(data.message);
					}
				}
			});
			return;
		}
	}else { // 没绑定手机
		if($("#slideOne").is(':checked')) {
			$("#phoneText").text("开启");
			$("#L_86_1").css("display","block");
			return;
		}else {
			$("#phoneText").text("关闭");
			$('#L_86_1').css('display', 'none');
			$('#L_86_2').css('display', 'none');
			return;
		}
	}
}



// 选择邮箱按钮
function cc(){
var emailNum = $("#emailNum").val();
// 绑定了邮箱
if (emailNum != "") {
	if($("#slideOne2").is(':checked')) {
		$("#emailText").text("开启");
		$("#L_86_4").css("display", "block");
		$("#emailNumber").text(emailNum);
		return;
	}else { // 用户解除绑定邮箱提币验证
		$.ajax({
			type: "POST",
			url: "http://192.168.136.1:8080/gme-web/api/v1/security/closeWithdrawValidata.json",
			dataType: "json",
			data: "type=2",
			success: function(data){
				if (data.code == 200) {
					$("#emailText").text("关闭");
					$('#L_86_3').css('display', 'none');
					$('#L_86_4').css('display', 'none');
				}else {
					$("#emailText").text("开启");
					$("#slideOne2").attr("checked","checked");
					alert(data.message);
				}
			}
		});
		return;
	}
}else { // 没绑定邮箱
	if($("#slideOne2").is(':checked')) {
		$("#emailText").text("开启");
		$("#L_86_3").css("display","block");
		return;
	}else {
		$("#emailText").text("关闭");
		$('#L_86_3').css('display', 'none');
		$('#L_86_4').css('display', 'none');
		return;
		}
	}
}



//跳转到绑定手机页面
function bindPhonePage(){
	window.location.href="http://192.168.136.1:8080/gme-web/bindPhone.html";
}
// 跳转到绑定手机页面
function bindEmailPage(){
	window.location.href="http://192.168.136.1:8080/gme-web/bindEmail.html";
}



