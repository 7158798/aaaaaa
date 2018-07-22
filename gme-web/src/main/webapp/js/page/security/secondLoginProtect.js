// 判断当前状态
var status = $("#twoStep").val();
if (status != "") {
	$("#currentStatus").text("开启");
	$("#button").val("关闭两步登陆保护");
} else {
	$("#currentStatus").text("关闭");
	$("#button").val("开启两步登陆保护");
}



//发送验证码
function getIdentCode(type) {
	var data = "";
	//1短信
	if (type == 1) {
		data = "type=8";
	}
	// 2语音
	if (type == 2) {
		data = "type=8" + "&sendByVoice=2";
	}
	
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/security/sendPhoneCheckCode.json",
		dataType: "json",
		data: data,
		success: function(data){
			if (data.code == 200) {
				alert("验证码已经发送至你绑定的手机");
			}else {
				alert(data.message);
			}
		}
	})
}



//关闭开启二步登录保护
function openCloseTwoStep() {
	var status = $("#currentStatus").text();
	var checkCode = $("#identCode").val();
	var type;
	if (checkCode == "") {
		alert("请输入验证码");
		return;
	}
	if (status == "开启") {
		type = 2;
	}
	if (status == "关闭") {
		type = 1;
	}
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/security/openCloseTwoStep.json",
		dataType: "json",
		data: "type=" + type + "&checkCode=" + checkCode,
		success: function(data){
			if (data.code == 200) {
				
			}else {
				alert(data.message);
			}
		}	
	});
}