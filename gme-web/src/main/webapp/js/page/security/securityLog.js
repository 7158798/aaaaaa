// 查询安全日志
function securityLog(){
	var logChar = [];
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/security/securityLogList.json",
		dataType: "json",
		success: function(data){
			if (data.code == 200) {
				$("#logList tr:not(:first)").remove();
				var dataChar = data.data;
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					var time = getFormatDateWithHours(data.createTime);
					$("#logList").append("<tr><td>"+(i + 1)+"</td><td>"+time+"</td></td>"+data.clientType+"</td><td><a onclick='watchLoginLog(this);'>查看</a></td><td>"+data.status+"</td><td>"+data.homeAddress+"</td><input type='hidden' value='"+data.loginIp+"'/></tr>");
				}
				
			}else {
				alert("查询安全日志:" + data.message);
			}
		}
	})
}


// 给查看ip绑定事件
function watchLoginLog (obj){
	var ip = $(obj).parent().parent().children().eq(-1).val();
	alert(ip);
}



//查询安全操作历史
function securityOperationHistory(){
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/security/securityOperationHistory.json",
		dataType: "json",
		success: function(data){
			if (data.code == 200) {
				$("#historyList tr:not(:first)").remove();
				var dataChar = data.data;
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					var time = getFormatDateWithHours(data.createTime);
					$("#historyList").append("<tr><td>"+(i + 1)+"</td><td>"+time+"</td></td>"+data.bizDesc+"</td><td>"+data.bizType+"</td><td>"+data.clientIp+"</td></tr>");
				}
			}else {
				alert("查询安全设置历史:" + data.message);
			}
		}
	})
}


function watchOperationLog (obj){
	var ip = $(obj).parent().parent().children().eq(-1).val();
	alert(ip);
}


//查询安全日志
securityLog();
// 查询安全设置历史
securityOperationHistory();


