// 判断是不是从第二步登录过来的
var sessionOver = $("#sessionOver").val();
if (sessionOver != "") {
	alert(sessionOver);
}


// 回车登录
$("#validataImg").on("keypress",function(event){
	if (event.keyCode == 13) {
		dlsc();
	}
});


function dlsc() {
	var redirectUrl = "${redirect}";
	var teb = $("#dlzhanghao").val(),
		validataImg = $("#validataImg").val();
		em = $("#password").val();
		$.ajax({
			type: 'POST',
			url: "http://192.168.136.1:8080/gme-web/api/v1/user/login.json",
			data: "loginId=" + teb + "&password=" + em + "&imgCode=" + validataImg,
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
				}
				if (data.code == "205"){
					window.location.href="http://192.168.136.1:8080/gme-web/secondLogin.html?redirect=" + redirectUrl;
					return;
				}if (data.code == "444") {
					alert(data.message);
					return;
				}
				else {
					alert(data.message);
					window.location.reload();
					return;
				}
				
			}
		});
}


function changeLang(lang){
	var url = "http://192.168.136.1:8080/gme-web/changeLang.html?lang="+lang;
	$.getJSON(url, function(data) {
		location.reload();
	},'json');
}