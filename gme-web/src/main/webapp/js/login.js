var account = $("#LOGIN_SECONDLOGIN_ACCOUNT").val();
var accountId = $("#LOGIN_SECONDLOGIN_ACCOUNTID").val();
var balanceBTC = $("#LOGIN_SECONDLOGIN_ACCOUNTBTC").val();
if (account != "") {
	$("#isLogin").children().remove();
	$("#isLogin").attr("class","header_dengluhou");			
	$("#isLogin").append("<ul><li><a href='accounts.html' class='header_dengluhou_a' class='whate'>"+account+"<i>" +
						"</i></a><div class='header_dengluhou_dlzt'>" +
						"<p><span>ID:</span><span>"+accountId+"</span>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<a onclick='$('#tc').css('display','block');'>退出</a></p>" +
						"<p><span>总资产：</span><b>"+balanceBTC+"BTC</b></p>" +
						"</li><li><span class='zyw'>中文版</span><div class='yybb'>" +
						"<a href='#'>ENGLISH</a> <a href='#'>한국어</a></div></li></ul>");
}else {
	$("#isLogin").children().remove();
	$("#isLogin").attr("class","header_denglu");
	$("#isLogin").append("<ul><li><a href='firstLogin.html' class='whate'>登录</a></li><li>|</li>" +
						"<li><a href='register.html' class='whate'>注册</a></li><li><span class='zyw'>中文版</span>" +
						"<div class='yybb'><a href='#'>ENGLISH</a> <a href='#'>한국어</a></div></li></ul>");
}


//退出
function confirmLogout(){
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/user/logout.json",
		dataType: "json",
		success: function(data) {
			if (data.code == 200) {
				window.location.href="http://192.168.136.1:8080/gme-web/firstLogin.html";
				return;
			}else {
				alert("登出：" + data.message);
			}
		}
	})
}

// 取消登录
function cancleLogout(){
	$('#tc').css('display','none');
}
