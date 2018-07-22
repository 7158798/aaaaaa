
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
		url: "http://192.168.0.148:8080/gme-web/api/v1/coin/bbBuySell.json",
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
		url: "http://192.168.0.148:8080/gme-web/api/v1/coin/bbBuySell.json",
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




// 我的成交记录
function currencyTransRecord(type){
	var pairId = $("#pairId").val();
	$.ajax({
		type: "POST",
		url: "http://192.168.0.148:8080/gme-web/api/v1/coin/transRecord.json",
		dataType: "json",
		data: "pairId=" + pairId + "&type=" + type,
		success: function(data){
			if (data.code == 200) {
				$("#myTransRecordTable tr:not(:first)").remove();
				var dataChar = data.data;
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					var date = getFormatDateWithHours(data.date);
					if (data.type == 1) {
						$("#myTransRecordTable").append("<tr><td>"+date+"</td><td>买入</td><td>"+data.pairSymbol+"</td><td>"+data.price+"</td><td>"+data.amount+"</td><td>"+data.total+"</td><td>"+data.procedureFee+"</td></tr>");
					}
					if (data.type == 2) {
						$("#myTransRecordTable").append("<tr><td>"+date+"</td><td>卖出</td><td>"+data.pairSymbol+"</td><td>"+data.price+"</td><td>"+data.amount+"</td><td>"+data.total+"</td><td>"+data.procedureFee+"</td></tr>");
					}
				}
			}
		}	
	})
}



// 我的当前委托
function entrustRecord(type){
	var pairId = $("#pairId").val();
	var type = type;
	$.ajax({
		type: "POST",
		url: "http://192.168.0.148:8080/gme-web/api/v1/coin/entrustRecord.json",
		dataType: "json",
		data: "pairId=" + pairId + "&type=" + type,
		success: function(data){
			if (data.code == 200) {
				$("#myEntrustRecordTable tr:not(:first)").remove();
				var dataCharBuy = data.data.recordList[0].buyOrders;
				var dataCharSell = data.data.recordList[0].sellOrders;
				for (var i = 0; i < dataCharBuy.length; i++) {
					var data =  dataCharBuy[i];
					var date = getFormatDateWithHours(data.date);
					//订单状态；1-委托中;2-全部成交;3-部分成交;4撤销;
					
					var statusStr = "";
					if (data.status == 1) {
						statusStr = "委托中";
					}
					if (data.status == 2) {
						statusStr = "全部成交";
					}
					if (data.status == 3) {
						statusStr = "部分成交";
					}
					if (data.status == 4) {
						statusStr = "撤销";
					}
					
					$("#myEntrustRecordTable").append("<tr><td>"+date+"</td><td>买入</td><td>"+data.price+"</td><td>"+data.number+"</td><td>"+data.finished+"</td><td>"+data.finished+"</td><td>"+statusStr+"</td><td><a>撤销</a><a>详情<img src='img/L_41.png' /></a></td><input type='hidden' value='"+data.orderId+"'/></tr>");
				}
				
				for (var i = 0; i < dataCharSell.length; i++) {
					var data =  dataCharSell[i];
					var date = getFormatDateWithHours(data.date);
					//订单状态；1-委托中;2-全部成交;3-部分成交;4撤销;
					
					var statusStr = "";
					var cancleStr = ""; 
					
					if (data.status == 1) {
						statusStr = "委托中";
						cancleStr = "<a>撤销</a>";
					}
					if (data.status == 2) {
						statusStr = "全部成交";
					}
					if (data.status == 3) {
						statusStr = "部分成交";
						cancleStr = "<a>撤销</a>";
					}
					if (data.status == 4) {
						statusStr = "撤销";
					}
					
					$("#myEntrustRecordTable").append("<tr><td>"+date+"</td><td>卖出</td><td>"+data.price+"</td><td>"+data.number+"</td><td>"+data.finished+"</td><td>"+data.finished+"</td><td>"+statusStr+"</td><td>"+cancleStr+"<a>详情<img src='img/L_41.png' /></a></td><input type='hidden' value='"+data.orderId+"'/></tr>");
				}
				
				
				// 查看详情
				$("#myEntrustRecordTable tr:not(:first)").each(function(){
					if ($(this).children().eq(-2).children().eq(-1).text() == "详情") {
						$(this).children().eq(-2).children().eq(-1).click(function(){
							if ($(this).attr("testStyle") == "testStyle") {
								// 详情已经展示，用户想要隐藏
								//$(".L_91_3").css("display","none");
								$(this).attr("testStyle","");
								var len = $(".L_91_3").length;
								for (var i = 0; i < len; i++) {
									// 如果是 详情信息在删除
									if ($(this).parent().parent().next().children().children().attr("class") == "L_91_3") {
										$(this).parent().parent().next().remove();
									}
								}
							}else {
								var orderId = $(this).parent().next().val();
								$.ajax({
									type: "POST",
									url: "http://192.168.0.148:8080/gme-web/api/v1/coin/queryDetial.json",
									dataType: "json",
									data: "orderId=" + orderId,
									success: function(data){
										alert("查看详情:" + data.message);
										if (data.code == 200) {
											var dataChar = data.data;
											for (var i = 0; i < dataChar.length; i++) {
												var data = dataChar[i];
												// 成交额
												var total = toNonExponential(data.price * data.number);
												$(this).parent().parent().after("<tr><td colspan='8' style='height: 0px;'><div class='L_91_3'><ul><li>时间</li><li>价格</li><li>成交数量</li><li>成交额</li><li>手续费</li></ul></div></td></tr>");
												$(this).parent().parent().next().children().children().append("<ul><li>"+data.date+"</li><li>"+data.price+"</li><li>"+data.number+"</li><li>"+total+"</li><li>"+data.手续费+"</li></ul>");
											}
											
											$(".L_91_3").css("display","block");
											// 给a标签添加一个属性做判断
											$(this).attr("testStyle","testStyle");
										}
									}
								})
								
//								$(this).parent().parent().after("<tr><td colspan='8' style='height: 0px;'><div class='L_91_3'><ul><li>时间</li><li>价格</li><li>成交数量</li><li>成交额</li><li>手续费</li></ul><ul><li>1</li><li>1</li></ul></div></td></tr>");
//								$(this).parent().parent().after("<tr><td colspan='8' style='height: 0px;'><div class='L_91_3'><ul><li>时间</li><li>价格</li><li>成交数量</li><li>成交额</li><li>手续费</li></ul><ul><li>2</li><li>2</li></ul></div></td></tr>");
//								$(this).parent().parent().after("<tr><td colspan='8' style='height: 0px;'><div class='L_91_3'><ul><li>时间</li><li>价格</li><li>成交数量</li><li>成交额</li><li>手续费</li></ul><ul><li>3</li><li>3</li></ul></div></td></tr>");
//								$(this).attr("testStyle","testStyle");
//								$(".L_91_3").css("display","block");
							}
						});
					}
				});
				
				
				// 撤销
				$("#myEntrustRecordTable tr:not(:first)").each(function(){
					if ($(this).children().eq(-2).children().eq(0).text() == "撤销") {
						$(this).children().eq(-2).children().eq(0).click(function(){
							var orderId = $(this).parent().next().val();
							$.ajax({
								type: "POST",
								url: "http://192.168.0.148:8080/gme-web/api/v1/coin/cancelCoinOrder.json",
								dataType: "json",
								data: "orderId=" + orderId,
								success: function(data){
									alert("撤销:" + data.message);
									if (data.code == 200) {
										// 重新请求
										entrustRecord(pairId,type);
									}
								}
							})
						});
					}
				});
				
				
				
			}
		}
	})
}





// 平台实时交易记录
function realTimeTradeRecord(){
	var pairId = $("#pairId").val();
	$.ajax({
		type: "GET",
		url: "http://192.168.0.148:8080/gme-web/api/v1/coin/realTimeTradeRecord.json",
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
		url: "http://192.168.0.148:8080/gme-web/api/v1/coin/buySellOrders.json",
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
		url: "http://192.168.0.148:8080/gme-web/api/v1/kline/ticker.json",
		dataType: "json",
		data: "symbol=" + currencySymbol[0] + "/" + currencySymbol[1],
		success: function(data){
			if (data.code == 200) {
				var pairsymbol = data.data.symbol;
				if(symbol != null) 
					$("#pairSymbol").text(symbol); 
					
				if(data.data.priceForUsdt != null) 
					$("#priceUSDT").text(data.data.priceForUsdt); 
				
				if(data.data.increase != null) 
					$("#percent").text(data.data.increase); 
				
				if(data.data.highPriceToday != null) 
					$("#maxLimit").text(data.data.highPriceToday); 
				
				if(data.data.lowPriceToday != null) 
					$("#minLimit").text(data.data.lowPriceToday); 
				
				if(data.data.priceForCny != null) 
					$("#priceCNY").text(getNumberValue(data.data.priceForCny)); 
				
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
	var url = "http://192.168.0.148:8080/gme-web/api/v1/kline/indexTicker.json";
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
			$("#pairArea").append("<tr><td align='left'><img src='"+obj[i].img+"' height='20px;'>" + obj[i].pairSymbol + "</td><td class='"+ys+"'>" + obj[i].priceForUsdt + "</td><td class='"+ys+"'>"+fh + obj[i].increase * 100+ "%</td><input value='"+obj[i].pairSymbol+"' type='hidden'/><input type='hidden' value='"+obj[i].pairId+"'/></tr>"); 
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
			$("#pairArea").append("<tr><td align='left'><img src='"+obj[i].img+"' height='20px;'>&nbsp;" + obj[i].name + "</td><td class='"+ys+"'>" + obj[i].priceForUsdt + "</td><td class='"+ys+"'>" +fh + obj[i].increase * 100 + "%</td><input value='"+obj[i].pairSymbol+"' type='hidden'/><input type='hidden' value='"+obj[i].pairId+"'/></tr>"); 
		}
	}
	
	// 给每个交易对添加点击事件
	$("#pairArea tr:not(:first)").children().each(function(){
		$(this).click(function(){
			var symbol = $(this).parent().children().eq(-2).val();
			var pairId = $(this).parent().children().eq(-1).val();
			window.location.href="http://192.168.0.148:8080/gme-web/bbTrans.html?symbol="+symbol+"&pairId=" + pairId;
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