// 查询 最近充值记录
function queryRechargeRecord(){
	var currencyId = '${symbol}';
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/wallet/getWalletRechargeRecord.json",
		dataType: "json",
		data: "currencyId=" + currencyId,
		success: function(data){
			if (data.code == 200) {
				$("#rechargeRecordTable tr:not(:first)").remove();
				var dataChar = data.data.recordList;
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					var status = data.status;
					var time = getFormatDateWithHours(data.updatedTime);
					
					var statusStr = "";
					if (status == 1) {
						statusStr = "等待确认";
					}
					if (status == 2) {
						statusStr = "成功";
					}
					if (status == 3) {
						statusStr = "失败";
					}
					
					$("#rechargeRecordTable").append("<tr><td>"+time+"</td><td>"+data.amount+"</td><td>"+data.txId+"</td><td>"+statusStr+"</td><td>"+data.txId+"</td><td>"+data.rechargeId+"</td></tr>");
				}
			}else {
				alert("查询最近充值记录:" + data.message);
			}						
			
		}
	});
}


//查询充值地址
var currencyId = $("#symbol").val();
function queryRechageAddress(){
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/wallet/getRechargeAddress.json",
		dataType: "json",
		data: "currencyId=" + currencyId,
		success: function(data){
			if (data.code == 200) {
				$("#usdtAddress").text(data.data.withdraw.data[0].defaultAddress);
				//$("#qrcode").qrcode($("#usdtAddress").text());
				$("#qrcode").qrcode({
				    width: 100, //宽度 
				    height:100, //高度 
				    text: $("#usdtAddress").text() //任意内容 
				});
			}else {
				alert("查询充值地址:" + data.message);
			}						
			
		}
	});
}


queryRechargeRecord();
queryRechageAddress();