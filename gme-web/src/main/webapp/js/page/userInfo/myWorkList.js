// 查询我的工单列表
function myWorkList(data){
	var url = "http://192.168.136.1:8080/gme-web/api/v1/operation/workListInfo.json";
	var table = "gdjl";
	// 调用分页查询
	PageRecord(url,data,table);
}


//********************************************************* 分页 ******************************
//上一页下一页
function choosePage(pageType){
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();
	
	var dataStr = "";				
	if (pageType == "next") {
		var page = parseInt(currentPage) + 1;
		dataStr = dataStr + "&pageNum=" + page;
	}else if (pageType == "pre") {
		var page = parseInt(currentPage) - 1;
		dataStr = dataStr + "&pageNum=" + page;
	}
	myWorkList(dataStr);
}

//是否能下一页
//如果当前页加1小于总页数
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


//提交工单 选中问题类型样式更改
function changeStyle(obj){
	$(obj).parent().children("a[class='L_96_14_action']").removeClass("L_96_14_action");
	$(obj).attr("class","L_96_14_action");
}



//查询所有的币种
function getCurrencyList(){
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/operation/coinList.json",
		dataType: "json",
		success: function(data){
			if (data.code == 200) {
				$("#L_97_7").children().remove();
				var dataChar = data.data.data;
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					$("#L_97_7").append('<option value="'+data.currencyId+'">'+data.currencySymbol+'</option>');
				}
			}else {
				alert(data.message);
			}
		}
	})
}


//提交工单
function submitWork(){
	var type = $("#problemType").children("a[class='L_96_14_action']").text();
	if (type == "充值") {
		type = 1;
	}
	if (type == "提现") {
		type = 2;
	}
	if (type == "申诉") {
		type = 3;
	}
	if (type == "仲裁") {
		type = 4;
	}
	if (type == "其他") {
		type = 5;
	}
	var imgOne = "aaa";
	var imgTwo = "bbb";
	var imgThree = "ccc";
	var currencyId = $("#L_97_7 option:selected").val();
	var tradeId = $("#L_97_4").val();
	var content = $("#L_97_5").val();
	
	if (tradeId == "") {
		alert("无效的交易对id");
		return;
	}
	if (content == "" || content.length <= 10) {
		alert("文字资料太少");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/operation/sendWorkList.json",
		dataType: "json",
		data: "workType=" + type + "&currencyId=" + currencyId + "&bizId=" + tradeId + "&workContent=" + content + "&imgOne=" + imgOne + "&imgTwo=" + imgTwo + "&imgThree" + imgThree,
		success: function(data){
			if (data.code == 200) {
				window.location.href=window.location.href;
			}else {
				alert(data.message);
			}
		}
	})
}
