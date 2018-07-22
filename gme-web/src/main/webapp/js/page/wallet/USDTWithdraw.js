var addressArr = [];	
// 查询提币地址
function getAddressList(){
	var currencyId = '${symbol}';
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/wallet/withdrawAddress.json",
		dataType: "json",
		data: "currencyId=" + currencyId,
		success: function(data){
			if (data.code == 200) {
				$("#alreadyAddress tr:not(:first)").remove();
				var dataChar = data.data.withdraw.data;
				// 遍历返回的data对象
				for (var i = dataChar.length-1;i >= 0;i--) {
					var data = dataChar[i];
					// 如果地址为空，不显示
					if (data.addressArray.length > 0) {
						for (var j = 0; j < data.addressArray.length; j++) {
							$("#alreadyAddress").append("<tr><td>"+data.addressArray[j]+"</td><td>"+data.remark+"</td></tr>");
							addressArr.push(data.addressArray[j]);
						}
					}
				}
			}else {
				alert("查询提币地址:" + data.message);
			}
		}
	});
}


//查询手续费
function queryServiceCharge() {
	var currencyId = $("#symbol").val();
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/wallet/getWithdrawCharge.json",
		dataType: "json",
		data: "currencyId=" + currencyId,
		success: function(data){
			if (data.code == 200) {
				$("#withdrawCharge").val(data.data.serviceChargeRatio);
			}else {
				alert("查询手续费:" + data.message);
			}
		}
	})
}


//计算到账数量
function clacCount(num){
	if (checkReg(num)) {
		var withdrawCount = $("#withdrawCount").val();
		// 提币数量必须大于多少才可以提币
		if (withdrawCount >= 200) {
			var withdrawCharge = $("#withdrawCharge").val();
			if (withdrawCharge != "") {
				$("#realCount").val(withdrawCount - withdrawCharge);
			}
		}
		return true;
	}else {
		return false;
	}
}


//发送验证码
function sendCheckCode(type){
	var url;
	// 手机
	if (type == 1) {
		$('#getEmailCode').attr('disabled','disabled');
		$("#outEmailCode").attr("disabled","disabled");
		url = "http://192.168.136.1:8080/gme-web/api/v1/security/sendPhoneCheckCode.json";
	}
	// 邮箱
	if (type == 2) {
		$('#getIdentCode').attr('disabled','disabled');
		$("#outIdentCode").attr("disabled","disabled");
		url = "http://192.168.136.1:8080/gme-web/api/v1/security/sendEmail.json";
	}
	$.ajax({
		type: "POST",
		url: url,
		dataType: "json",
		data: "type=5",
		success: function(data){
			if (data.code == 200) {
				alert("验证码已发送,请输入验证码");
			}else {
				alert("发送验证码:" + data.message);
			}
		}
		
	})
}


//提币
function withdraw(){
	var inputAddress = $("#inputAddress").val();
	var withdrawCount = $("#withdrawCount").val();
	var payPassword = $("#payPassword").val();
	if (inputAddress == "") {
		alert("请输入提币地址");
		return;
	}
	if (withdrawCount < 200) {
		alert("提币数量不能小于200");
		return;
	}
	if (payPassword == "") {
		alert("请输入资金密码");
		return;
	}
	
	$('#L_65').css('display','block');
	
}

// 确认提币
function confirmWithdraw(){
	var currencyId = '${symbol}';
	var inputAddress = $("#inputAddress").val();
	var withdrawCount = $("#withdrawCount").val();
	var outIdentCode = $("#outIdentCode").val();
	var outEmailCode = $("#outEmailCode").val();
	if (outIdentCode == "" && outEmailCode == "") {
		alert("请输入验证码");
		return;
	}
	
	var checkCode;
	if (outIdentCode != "") {
		checkCode = outIdentCode;
	}
	if (outEmailCode != "") {
		checkCode = outEmailCode;
	}
	
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/wallet/withdrawAddressAdd.json",
		dataType: "json",
		data: "currencyId=" + currencyId + "&amount=" + withdrawCount + "&address=" + inputAddress + "&tradeAuth=111",
		success: function(data){
			if (data.code == 200) {
				alert("提币成功");
			}else {
				alert("提币:" + data.message);
			}
		}
	})
	
}



//查询最近提现记录
function queryWithdrawRecord(){
	var currencyId = '${symbol}';
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/wallet/getWithdrawRecordPage.json",
		dataType: "json",
		data: "currencyId=" + currencyId,
		success: function(data){
			if (data.code == 200) {
				console.debug(data.data);
				$("#withdrawRecordTable tr:not(:first)").remove();
				var dataChar = data.data.recordList;
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					var status = data.status;
					var time = getFormatDateWithHours(data.updatedTime);
					
					var statusStr = "";
					if (status == 1) {
						statusStr = "已申请";
					}
					if (status == 2) {
						statusStr = "处理中";
					}
					if (status == 3) {
						statusStr = "已处理";
					}
					if (status == 4) {
						statusStr = "已拒绝";
					}
					if (status == 5) {
						statusStr = "撤销";
					}
					
					$("#withdrawRecordTable").append("<tr><td>"+time+"</td><td>"+data.realAmount+"</td><td>"+statusStr+"</td><td>"+data.id+"</td></tr>");
				}
			}else {
				alert("查询最近提现记录:" + data.message);
			}						
			
		}
	});
}


//给现有地址绑定点击事件 查询最近提现地址
$("#existingAddress").bind("click",getAddressList);
// 查询手续费
queryServiceCharge();
// 查询最近提现记录
queryWithdrawRecord();
