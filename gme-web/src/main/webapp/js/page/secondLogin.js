function onSubmit (){
var identCode = $("#identCodeId").val();
var redirectUrl = "${redirect}";
$.ajax({
	type: 'POST',
	url: "http://192.168.136.1:8080/gme-web/api/v1/security/checkIdentCode.json",
	data: "identCode=" + identCode + "&type=" + "3",
	dataType: "json",
	success: function(data) {
		if (data.code == "200") {
			if (redirectUrl == "") {
				window.location.href="http://192.168.136.1:8080/gme-web/index.html";
					return;
				}else{
					window.location.href = redirectUrl;
					return;
				}
			}else {
				alert(data.message);
				window.location.reload();
				return;
			}
			
		}
	});
}