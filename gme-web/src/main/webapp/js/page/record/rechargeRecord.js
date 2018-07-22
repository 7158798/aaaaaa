// 查询充值记录
function rechargeRecordList(data){
	var url = "http://192.168.136.1:8080/gme-web/api/v1/wallet/getWalletRechargeRecord.json";
	var table = "rechargeRecordTable";
	// 调用分页查询
	PageRecord(url,data,table);
}

//**********************************************************分页*****************************************

// 上一页下一页
function choosePage(pageType){
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();
	var currencyId = $("#currencyId option:selected").val();
	var status = $("#status option:selected").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	
	var dataStr = "currencyId=" + currencyId + "&status=" + status + "&startTime=" + startTime + "&endTime=" + endTime;				
	if (pageType == "next") {
		var page = parseInt(currentPage) + 1;
		dataStr = dataStr + "&pageNum=" + page;
	}else if (pageType == "pre") {
		var page = parseInt(currentPage) - 1;
		dataStr = dataStr + "&pageNum=" + page;
	}
	rechargeRecordList(dataStr);
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

//**********************************************************分页*****************************************

function queryCurrencyList(){
	$.ajax({
		type: 'GET',
		url: "http://192.168.136.1:8080/gme-web/api/v1/operation/coinList.json",
		dataType: "json",
		success: function(data) {
			if (data.code == 200) {
				var dataChar = data.data;
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					$("#currencyId").append("<option value='"+data.currencyId+"'>"+data.currencyName+"</option>");
				}
			}
		}
	});
}

//给查询添加事件
$("#button").click(function(){
	var currencyId = $("#currencyId option:selected").val();
	var status = $("#status option:selected").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	
	var data = "currencyId=" + currencyId + "&status=" + status + "&startTime=" + startTime + "&endTime=" + endTime;
	rechargeRecordList(data);
});	

//查询我的充值记录(全部)
rechargeRecordList("");
queryCurrencyList();