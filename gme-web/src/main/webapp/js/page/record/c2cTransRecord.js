// 我的c2c成交记录
function c2cTransRecordList(data){
	var url = "http://192.168.136.1:8080/gme-web/api/v1/otc/userOrderHistory";
	var table = "c2cTransRecordTable";
	// 调用分页查询
	var dataChar = PageRecord(url,data,table);
}

// ***********************************************************分页 ***************************

//上一页下一页
function choosePage(pageType){
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();	
	var currencyId = $("#currencyId option:selected").val();
	var type = $("#type option:selected").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var dataStr = "currencyId=" + currencyId + "&type=" + type + "&startTime=" + startTime + "&endTime=" + endTime;				
	if (pageType == "next") {
		var page = parseInt(currentPage) + 1;
		dataStr = dataStr + "&pageNum=" +  page;
	}
	if (pageType == "pre") {
		var page = parseInt(currentPage) - 1;
		dataStr = dataStr + "&pageNum=" + page;
	}
	c2cTransRecordList(dataStr);
}


// 是否能下一页
	// 如果当前页加1小于总页数
$("#nextPage").click(function(){
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();	
	if ((currentPage + 1) <= totalPage) {
		choosePage("next");
	}else {
		alert("a");
	}
});

// 是否能上一页
$("#prePage").click(function(){
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();	
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();
	if ((currentPage - 1) >= 1) {
		choosePage("pre");
	}else {
		alert("ab");
	}
});




//***********************************************************分页 ***************************

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
	var type = $("#type option:selected").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	
	var data = "currencyId=" + currencyId + "&type=" + type + "&startTime=" + startTime + "&endTime=" + endTime;
	c2cTransRecordList(data);
});	



//查询我的c2c成交记录列表(全部)
c2cTransRecordList("");
queryCurrencyList();
