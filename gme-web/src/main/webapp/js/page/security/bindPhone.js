// 判断是否已经绑定了手机号
var bindPhoneNumber = $("#bindPhoneNumber").val();
if (bindPhoneNumber != "") {
	// 绑定了手机
	$('#L_85').css('display','none');
	$('#L_85_2').css('display','none');
	$('#L_85_3').css('display','block');
	$("#phoneNumber").text(bindPhoneNumber);
}


//发送验证码
function sendPhoneCode(){
	var phoneNumber = $("#phone").val();
	var countryCode = $("#countryCode option:selected");
	// 如果手机号码格式正确
	if (isPhone(phoneNumber)) {
		$.ajax({
			type: "POST",
			url: "http://192.168.136.1:8080/gme-web/api/v1/security/sendPhoneCheckCode.json",
			dataType: "json",
			data: "phoneCode=" + phoneNumber + "&type=7" + "&countryCode=" + countryCode,
			success: function (data){
				if (data.code == 200) {
					alert("验证码已经发送尾号为"+phoneNumber.substring(phoneNumber.length-2,phoneNumber.length)+"手机");
				}else {
					alert(data.message);
				}
					
			}
		});
	}
}



//绑定手机号
function confirmbindPhone(){
	var phoneCode = $("#phone").val();
	var identCode = $("#identCode").val();
	if (identCode == "") {
		alert("验证码不能为空");
		return;
	}
	var countryCode = $("#countryCode option:selected");
	if (isPhone(phoneCode)) {
		$.ajax({
			type: "POST",
			url: "http://192.168.136.1:8080/gme-web/api/v1/security/bindPhone.json",
			dataType: "json",
			data: "phoneCode=" + phoneCode + "&countryCode=" + countryCode + "&identCode=" + identCode + "&tradeAuth=1" ,
			success: function (data){
				if (data.code == 200) {
					var phoneNum = data.data;
					$('#L_85').css('display','none');
					$('#L_85_2').css('display','none');
					$('#L_85_3').css('display','block');
					$("#phoneNumber").text(phoneNum);
				}else {
					alert(data.message);
				}
			}
		});
	}
}