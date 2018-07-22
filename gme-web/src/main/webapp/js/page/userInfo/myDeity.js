// 查询我的挂单
function myDeityList(data){
	var url = "http://192.168.136.1:8080/gme-web/api/v1/coin/entrustRecord.json";
	var table = "deityTable";
	// 调用分页查询
	PageRecord(url,data,table);
}

// ****************************************************分页 *****************************

// 上一页下一页
function choosePage(type){
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();
	var dataStr = "";
	if (type == "next") {
		var page = parseInt(currentPage) + 1;
		dataStr = dataStr + "&pageNum=" +  page;
	}else if (type == "pre") {
		var page = parseInt(currentPage) + 1;
		dataStr = dataStr + "&pageNum=" +  page;
	}
	myDeityList(dataStr);
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

//****************************************************分页 *****************************


//撤销挂单
function cancle(obj){
	var orderId = $(obj).parent().parent().children().eq(-1).val();
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/coin/cancelCoinOrder.json",
		dataType: "json",
		data: "orderId=" + orderId,
		success: function(data){
			if (data.code == 200) {
				// 刷新
				myDeityList("");
			}else {
				alert("撤销挂单:" + data.message);
			}
		}
	})
}

//查询挂单明细列表(全部)
myDeityList("");