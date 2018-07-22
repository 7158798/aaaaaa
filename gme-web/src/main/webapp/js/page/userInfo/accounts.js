
// 分页查询我的资产
function currencyList(data){
	var url = "http://192.168.136.1:8080/gme-web/api/v1/finance/balance.json";
	var table = "currencyTable";
	// 调用分页查询
	PageRecord(url,data,table);
}
// 选择开关
function slideClick(){
	// 点击页面开关选择查看有资金还是没有资金
	if($("#slideOne").is(':checked')) {
		currencyList("type=0");
	}else {
		currencyList("type=2");
	}
}

// ******************************************************** 分页 Start*************************************


// 上一页下一页
function choosePage(pageType){
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();
	var currencyId = $("#currencyId option:selected").val();
	var type;
	if($("#slideOne").is(':checked')) {
		type = "0";
	}else {
		type = "2";
	}
	
	var dataStr = "currencyId=" + currencyId + "&type=" + type;				
	if (pageType == "next") {
		var page = parseInt(currentPage) + 1;
		dataStr = dataStr + "&pageNum=" + page;
	}else if (pageType == "pre") {
		var page = parseInt(currentPage) - 1;
		dataStr = dataStr + "&pageNum=" + page;
	}
	currencyList(dataStr);
}

// 是否能下一页
	// 如果当前页加1小于总页数
$("#nextPage").click(function(){
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();
	if ((currentPage + 1) <= totalPage) {
		choosePage("next");
	}
});

// 是否能上一页
$("#prePage").click(function(){
	var currentPage = $("#currentPage").val();
	if ((currentPage - 1) >= 1) {
		choosePage("pre");
	}
});

//******************************************************** 分页 END*************************************


//查询 最近充值记录
function queryRechargeRecord(){
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/wallet/getWalletRechargeRecord.json",
		dataType: "json",
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
					
					$("#rechargeRecordTable").append("<tr><td>"+data.rechargeId+"</td><td>"+data.currencyId+"</td><td>"+time+"</td><td>"+data.amount+"</td><td>"+data.txId+"</td><td>"+data.confirmNumber+"</td><td>"+statusStr+"</td></tr>");
				}
			}else {
				alert("查询最近充值记录:" + data.message);
			}						
			
		}
	});
}


//查询 最近提现记录
function queryWithdrawRecord(){
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/wallet/getWithdrawRecordPage.json",
		dataType: "json",
		success: function(data){
			if (data.code == 200) {
				$("#withdrawRecordTable tr:not(:first)").remove();
				var dataChar = data.data.recordList;
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					// 1-申请;2-处理中;3-已处理;4-已拒绝;5-撤销;
					var status = data.status;
					var time = getFormatDateWithHours(data.updatedTime);
					var statusStr = "";
					var operation = "";
					
					if (status == 1) {
						statusStr = "已申请";
						operation = "<a>取消提现</a>";
					}
					if (status == 2) {
						statusStr = "处理中";
						operation = "--";
					}
					if (status == 3) {
						statusStr = "已处理";
						operation = "--";
					}
					if (status == 4) {
						statusStr = "已拒绝";
						operation = "--";
					}
					if (status == 5) {
						statusStr = "撤销";
						operation = "--";
					}
					$("#withdrawRecordTable").append("<tr><td>"+data.withdrawalId+"</td><td>"+data.currencySymbol+"</td><td>"+time+"</td><td>"+data.requestAmount+"</td><td>"+data.serviceCharge+"</td><td>"+data.realAmount+"</td><td>"+data.walletAddress+"</td><td>"+statusStr+"</td><td>"+operation+"</td></tr>");
				}
				
				
				// 取消提现
				$("#withdrawRecordTable tr:not(:first)").each(function(){
					if ($(this).children().eq(-1).text() == "取消提现") {
						$(this).children().eq(-1).children().click(function(){
							var orderId = $(this).parent().parent().children().eq(0).text();
							console.debug(orderId);
							$.ajax({
								type: "POST",
								url: "http://192.168.136.1:8080/gme-web/api/v1/wallet/cancelWithdraw.json",
								dataType: "json",
								data: "withdrawId=" + orderId + "&payPassword=1111",
								success: function(data){
									alert("取消提现:" + data.message);
								}
							});
						});
					}
				});
			}else {
				alert("查询 最近提现记录:" + data.message);
			}						
			
		}
	});
}


//查询我的充值记录(全部)
// 0-有资产的;1-下架的;2-所有;
currencyList("type=2");
// 查询最近充值记录
queryRechargeRecord();
// 查询最近提现记录
queryWithdrawRecord();

