
// 计算买入的总价
function checkBuyCalcAmount(num) {
	if(checkReg(num)) {
		var price = $("#buyPrice").val();
		var count = $("#buyCount").val();
		if (price != "") {
			$("#buyChangeCNY").text(price * 6);
		}
		if (price != "" && count != "") {
			$("#buyAmountSymbol").text(clacPrice(price,count));
			$("#buyAmountCNY").text($("#buyAmountSymbol").text() * 6);
		}
		return true;
	}else {
		return false;
	}
}
		
		
// 计算卖出的总价
function checkSellCalcAmount(num) {
	if(checkReg(num)) {
		var price = $("#sellPrice").val();
		var count = $("#sellCount").val();
		if (price != "") {
			$("#sellChangeCNY").text(price * 6);
		}
		if (price != "" && count != "") {
			$("#sellAmountSymbol").text(clacPrice(price,count));
			$("#sellAmountCNY").text($("#sellAmountSymbol").text() * 6);
		}
		return true;
	}else {
		return false;
	}
}


// 买入(交易)
$("#buyButton").click(function(){
	var pairId = $("#pairId").val();
	var price = $("#buyPrice").val();
	var amount = $("#buyCount").val();
	var tradeAuth = $("#buyPayPassword").val();
	if (price == "") {
		alert("请输入价格");
		return;
	}
	if (amount == "") {
		alert("请输入数量");
		return;
	}
	if (tradeAuth == "") {
		alert("请输入资金密码");
		return;
	}
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/coin/bbBuySell.json",
		dataType: "json",
		data: "price=" + price + "&amount=" + amount + "&tradeAuth=" + tradeAuth + "&type=1" + "&pairId=" + pairId,
		success: function(data){
			if (data.code == 200) {
				// 刷新我的当前委托
				entrustRecord(3);
			}else {
				alert(data.message);
			}
		}
	});
});







// 卖出(交易)
$("#sellButton").click(function(){
	var pairId = $("#pairId").val();
	var price = $("#sellPrice").val();
	var amount = $("#sellCount").val();
	var tradeAuth = $("#sellPayPassword").val();
	if (price == "") {
		alert("请输入价格");
		return;
	}
	if (amount == "") {
		alert("请输入数量");
		return;
	}
	if (tradeAuth == "") {
		alert("请输入资金密码");
		return;
	}
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/coin/bbBuySell.json",
		dataType: "json",
		data: "price=" + price + "&amount=" + amount + "&tradeAuth=" + tradeAuth + "&type=2" + "&pairId=" + pairId,
		success: function(data){
			if (data.code == 200) {
				// 刷新我的当前委托
				entrustRecord(3);
			}else {
				alert(data.message);
			}
		}
	});
});




// **********************************************我的成交记录 分页 **************************
function currencyTransRecord(data){
	var pairId = $("#pairId").val();
	$("#allTransRecord").attr("class","L_91_2");
	$("#buyTransRecord").attr("class","L_91_2");
	$("#selTransRecord").attr("class","L_91_2");
	var dataStr = "pairId=" + pairId;
	if (date == "3") {
		dataStr = dataStr +  "&type=3";
		$("#allTransRecord").attr("class","L_91_2 action_91_2");
	}
	if (date == "2") {
		dataStr = dataStr +  "&type=2";
		$("#selTransRecord").attr("class","L_91_2 action_91_2");
	}
	if (date == "1") {
		dataStr = dataStr +  "&type=1";
		$("#buyTransRecord").attr("class","L_91_2 action_91_2");
	}
	
	
	var url = "http://192.168.136.1:8080/gme-web/api/v1/coin/transRecord.json";
	var table = "myTransRecordTable";
	// 调用分页查询
	currencyTransRecord(url,data,table);
}

//上一页下一页
function choosePage(pageType){
	var pairId = $("#pairId").val();
	var type = $("#transType").children("a[class='L_91_2 action_91_2']").text();
	var typeStr = "";
	if (type == "全部") {
		type = "3";
	}
	if (type == "卖出") {
		type = "2";
	}
	if (type == "买入") {
		type = "1";
	}
	var currentPage = $("#currentPageTrans").val();
	var totalPage = $("#pageCountTrans").val();	
	var dataStr = "pairId=" + pairId + "&type=" + type;				
	if (pageType == "next") {
		var page = parseInt(currentPage) + 1;
		dataStr = dataStr + "&pageNum=" +  page;
	}
	if (pageType == "pre") {
		var page = parseInt(currentPage) - 1;
		dataStr = dataStr + "&pageNum=" + page;
	}
	entrustRecord(dataStr);
}


// 是否能下一页
	// 如果当前页加1小于总页数
$("#nextPageTrans").click(function(){
	var currentPage = $("#currentPageTrans").val();
	var totalPage = $("#pageCountTrans").val();	
	if ((currentPage + 1) <= totalPage) {
		choosePage("next");
	}
});

// 是否能上一页
$("#prePageTrans").click(function(){
	var currentPage = $("#currentPageTrans").val();
	var totalPage = $("#pageCountTrans").val();	
	var currentPage = $("#currentPageTrans").val();
	var totalPage = $("#pageCountTrans").val();
	if ((currentPage - 1) >= 1) {
		choosePage("pre");
	}
});



//**********************************************我的成交记录 分页END **************************



// ********************************************** 我的委托记录分页 *****************************
function entrustRecord(data){
	var pairId = $("#pairId").val();
	$("#allEntrus").attr("class","L_91_2");
	$("#buyEntrus").attr("class","L_91_2");
	$("#sellEntrus").attr("class","L_91_2");
	var dataStr = "pairId=" + pairId;
	if (date == "3") {
		dataStr = dataStr +  "&type=3";
		$("#allEntrus").attr("class","L_91_2 action_91_2");
	}
	if (date == "2") {
		dataStr = dataStr +  "&type=2";
		$("#sellEntrus").attr("class","L_91_2 action_91_2");
	}
	if (date == "1") {
		dataStr = dataStr +  "&type=1";
		$("#buyEntrus").attr("class","L_91_2 action_91_2");
	}
	
	
	var url = "http://192.168.136.1:8080/gme-web/api/v1/coin/entrustRecord.json";
	var table = "myEntrustRecordTable";
	// 调用分页查询
	PageRecord(url,data,table);
}


//上一页下一页
function choosePage(pageType){
	var pairId = $("#pairId").val();
	var type = $("#entrusType").children("a[class='L_91_2 action_91_2']").text();
	var typeStr = "";
	if (type == "全部") {
		type = "3";
	}
	if (type == "卖出") {
		type = "2";
	}
	if (type == "买入") {
		type = "1";
	}
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();	
	var dataStr = "pairId=" + pairId + "&type=" + type;				
	if (pageType == "next") {
		var page = parseInt(currentPage) + 1;
		dataStr = dataStr + "&pageNum=" +  page;
	}
	if (pageType == "pre") {
		var page = parseInt(currentPage) - 1;
		dataStr = dataStr + "&pageNum=" + page;
	}
	entrustRecord(dataStr);
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
	var currentPage = $("#currentPage").val();
	var totalPage = $("#pageCount").val();
	if ((currentPage - 1) >= 1) {
		choosePage("pre");
	}
});


//********************************************** 我的委托分页END *****************************



// 平台实时交易记录
function realTimeTradeRecord(){
	var pairId = $("#pairId").val();
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/coin/realTimeTradeRecord.json",
		dataType: "json",
		data: "pairId=" + pairId,
		success: function(data){
			if (data.code == 200) {
				$("#platformTransRecord").children(":tr").remove();
				var dataChar = data.data;
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					$("#platformTransRecord").append("<tr><td>"+data.price+"</td><td>"+data.total+"</td><td>"+data.date+"</td></tr>");
				}
			}
		}
	})
}



// 买卖委托单
function buySellOrder(){
	var pairId = $("#pairId").val();
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/coin/buySellOrders.json",
		dataType: "json",
		data: "pairId=" + pairId,
		success: function(data){
			if (data.code == 200) {
				$("#buying tr:not(:first)").remove();
				$("#selling tr:not(:first)").remove();
				var dataCharBuy = data.data.buyOrders;
				var dataCharSell = data.data.sellOrders;
				for (var i = 0; i < dataCharBuy.length; i++) {
					var data = dataCharBuy[i];
					var amount = toNonExponential(data.price * data.number);
					$("#buying").append("<tr><td>"+data.price+"</td><td>"+data.number+"</td><td>"+amount+"</td><tr>");
				}
				for (var j = 0; j < dataCharSell.length; j++) {
					var data = dataCharSell[j];
					var amount = toNonExponential(data.price * data.number);
					$("#selling").append("<tr><td>"+data.price+"</td><td>"+data.number+"</td><td>"+amount+"</td><tr>");
				}
				
				
				
				// 给tr注册事件，填写买卖交易的文本框
				$("#buying tr:not(:first)").each(function(){
					$(this).click(function(){
						$("#buyPrice").val($(this).children().eq(0).text());
						$("#sellPrice").val($(this).children().eq(0).text());
					});
				});
				
				$("#selling tr:not(:first)").each(function(){
					$(this).click(function(){
						$("#buyPrice").val($(this).children().eq(0).text());
						$("#sellPrice").val($(this).children().eq(0).text());
					});
				});
				
			}
		}
	})
}


// 将科学计数法转换为数字	
function toNonExponential(num) {
    var m = num.toExponential().match(/\d(?:\.(\d*))?e([+-]\d+)/);
    return num.toFixed(Math.max(0, (m[1] || '').length - m[2]));
}



//币种对行情
function ticker(symbol){
	var currencySymbol = symbol.split("_");
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/kline/ticker.json",
		dataType: "json",
		data: "symbol=" + currencySymbol[0] + "/" + currencySymbol[1],
		success: function(data){
			if (data.code == 200) {
				var pairsymbol = data.data.symbol;
				if(symbol != null) 
					$("#pairSymbol").text(symbol); 
					
				if(data.data.priceForUsdt != null) 
					$("#priceUSDT").text(getNumberValue(data.data.priceForUsdt)); 
				
				if(data.data.increase != null) 
					$("#percent").text(data.data.increase); 
				
				if(data.data.highPriceToday != null) 
					$("#maxLimit").text(data.data.highPriceToday); 
				
				if(data.data.lowPriceToday != null) 
					$("#minLimit").text(data.data.lowPriceToday); 
				
				if(data.data.priceForCny != null) 
					$("#priceCNY").text(data.data.priceForCny); 
				
				if(data.data.volume24Hour+currencySymbol[0] != null) 
					$("#transCount").html(data.data.volume24Hour+"&nbsp;" +currencySymbol[0]); 
			}
		}
	})
	
}




//=================================币种交易对列表==============================
var L_USDT = [],
L_BTC = [],
L_ETH = [],
L_DF = [],
kxsj = [];


function setCookie(name, value) {
var Days = 30;
var exp = new Date();
exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
document.cookie = name + "=" + escape(value) + ";path=/;expires=" + exp.toGMTString();
}

function getCookie(name) {
var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
if(arr = document.cookie.match(reg))
	return unescape(arr[2]);
else
	return null;
}
var jsonneirong = "";





function indexx() {
	var url = "http://192.168.136.1:8080/gme-web/api/v1/kline/indexTicker.json";
	$.get(url, function(rawData) {
		if(rawData.code != 200) {
			setTimeout("indexx()", 1000);
		} else {
			setTimeout("indexx()", 10000);
			jsonneirong = rawData;
			L_USDT = rawData.data[0].data;
			L_BTC = rawData.data[1].data;
			L_ETH = rawData.data[2].data;
			for(var i = 0; i < rawData.data.length; i++) {
				for(var j = 0; j < rawData.data[i].data.length; j++) {
					for(var m = 0; m < getCookie("zixuan").split(",").length; m++) {
						if(rawData.data[i].data[j].symbol == getCookie("zixuan").split(",")[m]) {
							L_DF.push(rawData.data[i].data[j]);
						}
					}
				}
			}
			xr(L_USDT);
		}
	});
}



function xr(obj) {
	//setTimeout("qkxt(kxsj)", 1000);
	kxsj = [];
	//	alert(obj[0].increase);
	if(obj == L_USDT) {
		$("#USDTQ").removeClass().attr("class","L_89_12a action_L_89_12");
		$("#ETHQ").removeClass().attr("class","L_89_12a");
		$("#BTCQ").removeClass().attr("class","L_89_12a");
		$("#ZXQQ").removeClass().attr("class","L_89_12a");
	} else if(obj == L_ETH) {
		$("#ETHQ").removeClass().attr("class","L_89_12a action_L_89_12");
		$("#USDTQ").removeClass().attr("class","L_89_12a");
		$("#BTCQ").removeClass().attr("class","L_89_12a");
		$("#ZXQQ").removeClass().attr("class","L_89_12a");
	} else if(obj == L_BTC) {
		$("#BTCQ").removeClass().attr("class","L_89_12a action_L_89_12");
		$("#USDTQ").removeClass().attr("class","L_89_12a");
		$("#ETHQ").removeClass().attr("class","L_89_12a");
		$("#ZXQQ").removeClass().attr("class","L_89_12a");
	} else if(obj == L_DF) {
		$("#ZXQQ").removeClass().attr("class","L_89_12a action_L_89_12");
		$("#USDTQ").removeClass().attr("class","L_89_12a");
		$("#ETHQ").removeClass().attr("class","L_89_12a");
		$("#BTCQ").removeClass().attr("class","L_89_12a");
	}
	if(obj == L_DF) {
		$("#pairArea").children().remove();
		for(var i = 0; i < obj.length; i++) {
			var fh="";
			if(obj[i].increase < 0) {
				fh="-";
			} else {
				fh="+";
			}
			$("#pairArea").append("<tr class='L_89_22_a'><td align='left'><img src='"+obj[i].img+"' height='20px;'>" + obj[i].pairSymbol + "</td><td class='"+ys+"'>" + obj[i].priceForUsdt + "</td><td class='"+ys+"'>"+fh + obj[i].increase * 100+ "%</td><input value='"+obj[i].pairSymbol+"' type='hidden'/><input type='hidden' value='"+obj[i].pairId+"'/></tr>"); 
		}
	}else {
		$("#pairArea").children().remove();
		for(var i = 0; i < obj.length; i++) {
			var fh="";
			if(obj[i].increase < 0) {
				ys = "sybg_2_hong";
				fh="-";
			} else {
				ys = "sybg_2_lv";
				fh="+";
			}
			$("#pairArea").append("<tr class='L_89_22_a'><td align='left'><img src='"+obj[i].img+"' height='20px;'>&nbsp;" + obj[i].name + "</td><td class='"+ys+"'>" + obj[i].priceForUsdt + "</td><td class='"+ys+"'>" +fh + obj[i].increase * 100 + "%</td><input value='"+obj[i].pairSymbol+"' type='hidden'/><input type='hidden' value='"+obj[i].pairId+"'/></tr>"); 
		}
	}
	
	// 给每个交易对添加点击事件
	$("#pairArea tr:not(:first)").children().each(function(){
		$(this).click(function(){
			var symbol = $(this).parent().children().eq(-2).val();
			var pairId = $(this).parent().children().eq(-1).val();
			window.location.href="http://192.168.136.1:8080/gme-web/bbTrans.html?symbol="+symbol+"&pairId=" + pairId;
		});
	});
	
}
//==================================================币种交易对列表EDN==========================================






// 我的成交记录
currencyTransRecord(3);
// 我的当前委托
entrustRecord(3);
// 平台实时交易记录
realTimeTradeRecord();
// 买卖委托单
buySellOrder();
//币种对行情
ticker($("#pairSymbol").text());
//币种交易对列表初始化 使用刚指定的配置项和数据显示图表。
indexx();
//k线30分钟
sf(30);