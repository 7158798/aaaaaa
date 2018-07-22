// 判断是否实名认证
var isAuthStatus = $("#isAuthStatus").val();
if (isAuthStatus == "2") {
	$("#authLoad").attr("display","block");
	$("#auth").attr("display","none");
}else if (isAuthStatus == "3") {
	$("#authAfter").attr("display","block");
	$("#auth").attr("display","none");
}else if (isAuthStatus == "4") {
	$("#authFail").attr("display","block");
	$("#failText").text($("#authFailMsg").val());
	$("#auth").attr("display","none");
}


//确认提交
$("#confirmButton").click(function(){
	var name = $("#name").val();
	var confirmName = $("#confirmName").val();
	var type = $("#IDCardType option:selected").val();
	var idCard = $("#IDCard").val();
	if (name == "") {
		alert("姓名不能为空");
		return;
	}
	if (confirmName == "") {
		alert("确认姓名不能为空");
		return;
	}
	if (name != confirmName) {
		alert("两次输入的姓名不一致");
		return;
	}
	if (idCard == "") {
		alert("证件号码不能为空");
		return;
	}
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/security/identifyAuth.json",
		dataType: "json",
		data: "name=" + name + "&cardType=" + type + "&cardNumber=" + idCard + "&faceImgId=1" + "&backImgId=2" + "&handImgId=3",
		success: function(data){
			if (data.code == 200) {
				
			}
		}
	});
	
});
