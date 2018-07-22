// 查询我的交易记录
function transRecordList(data){
	var url = "http://192.168.136.1:8080/gme-web/api/v1/coin/transRecord.json";
	var table = "transRecordTable";
	// 调用分页查询
	PageRecord(url,data,table);
}

//**********************************************分页*****************************************


// 上一页下一页
function choosePage(type){
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();
	var currencySymbol = $("#currencySymbol option:selected").val();
	var currencyId = $("#currencyId option:selected").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	
	var dataStr = "currencySymbol=" + currencySymbol + "&currencyId=" + currencyId + "&startTime=" + startTime + "&endTime=" + endTime;				
	if (type == "next") {
		var page = parseInt(currentPage) + 1;
		dataStr = dataStr + "&pageNum=" +  page;
	}else if (type == "pre") {
		var page = parseInt(currentPage) - 1;
		dataStr = dataStr + "&pageNum=" + page;
	}
	transRecordList(dataStr);
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
	var totalPage = $("#pageCount").val();
	if ((currentPage - 1) >= 1) {
		choosePage("pre");
	}
});

//**********************************************分页*****************************************

// 查询我的所有币种
function queryCurrencyList(){
	$.ajax({
		type: 'GET',
		url: "http://192.168.136.1:8080/gme-web/api/v1/operation/coinList.json",
		data: "isToken=1",
		dataType: "json",
		success: function(data) {
			if (data.code == 200) {
				var dataChar = data.data;
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					if (data.isToken == 1) {
						$("#currencySymbol").append("<option value='"+data.currencyId+"'>"+data.currencyName+"</option>");
					}
				}
				$("#currencySymbol").change(function(){
					// 清空 currencyId下拉列表
					$("#currencyId option").not(":first").remove(); 
					$.ajax({
						type: "GET",
						url: "http://192.168.136.1:8080/gme-web/api/v1/operation/coinTradePairList.json",
						data: "currencyId="+$(this).val(),
						dataType: "json",
						success: function(data){
							if (data.code == 200) {
								var dataChar = data.data;
								for (var i = 0; i < dataChar.length; i++) {
									var data = dataChar[i];
									$("#currencyId").append("<option value='"+data.currencyId+"'>"+data.currencySymbol+"</option>");
								}
							}
						}
					});
				});
			}
		}
	});
}





//给查询添加事件
$("#button").click(function(){
	var currencySymbol = $("#currencySymbol option:selected").val();
	var currencyId = $("#currencyId option:selected").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	
	var data = "currencySymbol=" + currencySymbol + "&currencyId=" + currencyId + "&startTime=" + startTime + "&endTime=" + endTime;
	transRecordList(data);
});	


//查询我的成交记录列表(全部)
transRecordList("");
//查询我的所有币种
queryCurrencyList();
