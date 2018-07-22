
function queryNoticeList(data){
	var url = "http://192.168.136.1:8080/gme-web/api/v1/operation/getNotice.json";
	var table = "noticeTitleList";
	// 调用分页查询
	PageRecord(url,data,table);
}




// ********************************************************* 分页 ******************************
// 上一页下一页
function choosePage(pageType){
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();
	
	var dataStr = "noticeType=1";				
	if (pageType == "next") {
		var page = parseInt(currentPage) + 1;
		dataStr = dataStr + "&pageNum=" + page;
	}else if (pageType == "pre") {
		var page = parseInt(currentPage) - 1;
		dataStr = dataStr + "&pageNum=" + page;
	}
	queryNoticeList(dataStr);
}

//是否能下一页
// 如果当前页加1小于总页数
$("#nextPage").click(function(){
var currentPage = $("#currentPage").val();
var totalPage = $("#pageCount").val();
if ((currentPage + 1) <= totalPage) {
	choosePage("next");
}
});

//是否能上一页
$("#prePage").click(function(){
var currentPage = $("#currentPage").val();
if ((currentPage - 1) >= 1) {
	choosePage("pre");
}
});

//********************************************************* 分页 ******************************



// 查询所有的公告
queryNoticeList("noticeType=1");

	
