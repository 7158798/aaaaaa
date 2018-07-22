var oBody = document.getElementsByTagName("body")[0];
var aBanner = document.getElementsByClassName("banner");
var aSpan = document.getElementsByClassName("tab")[0].getElementsByTagName("span");
var Oon = document.getElementsByClassName("on")[0];
aBanner[0].style.opacity = "1";
aSpan[0].className = "on";
var num = 0;
for(var i = 0; i < aSpan.length; i++) {
	aSpan[i].index = i;
	aSpan[i].onclick = function() {
		for(var j = 0; j < aSpan.length; j++) {
			num = this.index;
			aSpan[j].className = "";
			aBanner[j].style.opacity = "0"
		}
		aSpan[num].className = "on";
		aBanner[num].style.opacity = "1"
	}
}

function Time() {
	num++;
	if(num < 3) {
		for(var j = 0; j < aSpan.length; j++) {
			aSpan[j].className = "";
			aBanner[j].style.opacity = "0"
		}
		aSpan[num].className = "on";
		aBanner[num].style.opacity = "1"
	} else {
		num = -1
	}
}
clearInterval(timer);
var timer = setInterval("Time()", 2000);
oBody.onmouseover = function() {
	clearInterval(timer)
};
oBody.onmouseout = function() {
	clearInterval(timer);
	timer = setInterval("Time()", 2000)
};

if(getCookie("zixuan") == "" || getCookie("zixuan") == null) {
	setCookie("zixuan", "");
} else {

}

setInterval(function() {
	$('#leftBox li:last').css({
		'height': '0px',
		'opacity': '0'
	}).insertBefore('#leftBox li:first').animate({
		'height': '35px',
		'opacity': '1'
	}, 'slow', function() {
		$(this).removeAttr('style');
	});
}, 3000);
var L_USDT = [],
	L_BTC = [],
	L_ETH = [],
	L_DF = [],
	kxsj = [];

function iddjsj(obj) {
	if($(obj).css('background').indexOf('57') == '-1') {
		$(obj).css('background', 'url(img/L_57.png) no-repeat 50% 50% scroll');
		var c = "";
		for(var m = 0; m < getCookie("zixuan").split(",").length; m++) {
			if($(obj).attr("class") == getCookie("zixuan").split(",")[m]) {
				c = getCookie("zixuan").replace("," + $(obj).attr("class"), "");
				setCookie("zixuan", c);
				zxqyszsc(1, $(obj).attr("class"));
				break;
			}
		}
	} else {
		$(obj).css('background', 'url(img/L_56.png) no-repeat 50% 50% scroll');
		if(getCookie("zixuan") == "" || getCookie("zixuan") == null) {
			setCookie("zixuan", "," + $(obj).attr("class"));
		} else {
			if(getCookie("zixuan").split(",").indexOf($(obj).attr("class")) != '-1') {

			} else {
				setCookie("zixuan", (getCookie("zixuan") + "," + $(obj).attr("class")));
				zxqyszsc(0, $(obj).attr("class"));
			}
		}
	}
}
//alert(getCookie("zixuan").split(",").length);
function zxqyszsc(id, obj) {
	if(id == 0) {
		if(obj.indexOf("_usdt") != "-1") {
			for(var j = 0; j < jsonneirong.data[0].data.length; j++) {
				if(jsonneirong.data[0].data[j].pairSymbol == obj) {
					L_DF.push(jsonneirong.data[0].data[j]);
					break;
				}
			}
		} else if(obj.indexOf("_eth") != "-1") {
			for(var j = 0; j < jsonneirong.data[2].data.length; j++) {
				if(jsonneirong.data[2].data[j].pairSymbol == obj) {
					L_DF.push(jsonneirong.data[2].data[j]);
					break;
				}
			}
		} else if(obj.indexOf("_btc") != "-1") {
			for(var j = 0; j < jsonneirong.data[1].data.length; j++) {
				if(jsonneirong.data[1].data[j].pairSymbol == obj) {
					L_DF.push(jsonneirong.data[1].data[j]);
					break;
				}
			}
		}
	} else {
		for(var j = 0; j < L_DF.length; j++) {
			if(L_DF[j].pairSymbol == obj) {
				L_DF.splice(j, 1);
				break;
			}
		}
	}
}

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
			//			alert(rawData.data[0].data.length);
			//			alert(L_USDT[0].name);
		}
	});
}
// 使用刚指定的配置项和数据显示图表。
indexx();
//setTimeout("alert(L_USDT[0].name);",1000);
function qkxt(obj) {
	var eleList = document.querySelectorAll('.curve');
	for(var i = 0; i < eleList.length; i++) {
		var option = {
			xAxis: [{
				nameTextStyle: { //名称的样式
					fontSize: '12px'
				},
				nameGap: 0, //名称与X轴的距离
				boundaryGap: true, //坐标的刻度是否在中间
				axisTick: { //坐标轴刻度相关设置
					length: '1' //我把长度设置成0了
				},
				axisLabel: { //坐标轴刻度标签
					margin: 10, //刻度标签与轴线之间的距离
				},
				data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20']

			}], //X轴设置
			yAxis: [{
				show: false
			}],
			series: [ //系列列表
				{

					symbol: 'none', //取消点
					type: 'line',
					data: obj[i],
					itemStyle: { //折线拐点的样式
						normal: {
							// color:'#20aefc',  //折线拐点的颜色

						}
					},
					lineStyle: {
						color: 'red' //线的颜色设置
					},
				}
			]

		};
		var item = eleList[i];
		var mychart = echarts.init(item);
		mychart.setOption(option);
	}
}

function xr(obj) {
	setTimeout("qkxt(kxsj)", 1000);
	kxsj = [];
	//	alert(obj[0].increase);
	if(obj == L_USDT) {
		$("#USDTQ").addClass("action_sybg_1");
		$("#ETHQ").removeClass();
		$("#BTCQ").removeClass();
		$("#ZXQQ").removeClass();
	} else if(obj == L_ETH) {
		$("#ETHQ").addClass("action_sybg_1");
		$("#USDTQ").removeClass();
		$("#BTCQ").removeClass();
		$("#ZXQQ").removeClass();
	} else if(obj == L_BTC) {
		$("#BTCQ").addClass("action_sybg_1");
		$("#USDTQ").removeClass();
		$("#ETHQ").removeClass();
		$("#ZXQQ").removeClass();
	} else if(obj == L_DF) {
		$("#ZXQQ").addClass("action_sybg_1");
		$("#USDTQ").removeClass();
		$("#ETHQ").removeClass();
		$("#BTCQ").removeClass();
	}
	var nr = "";
	if(obj == L_DF) {
		for(var i = 0; i < obj.length; i++) {
			var ys = "";
			var fh="";
			var djtb = "background: url(img/L_56.png) 50% 50% no-repeat scroll;";
			if(obj[i].increase < 0) {
				ys = "sybg_2_hong";
				fh="-";
			} else {
				ys = "sybg_2_lv";
				fh="+";
			}
			var pairSymbol = obj[i].symbol;
			var symbol = pairSymbol.split("_");
			var t = "<tr><td><i onclick='iddjsj(this)' style='" + djtb + "' class=" + obj[i].symbol + "></i><img src='"+obj[i].img+"' height='20px;'>" +
					"<span>" + symbol[0] + "/" + symbol[1] + "</span></td><td class=" + ys + ">" + obj[i].priceForUsdt + "</td>" +
					"<td class=" + ys + ">¥" + obj[i].priceForCny + "</td><td class=" + ys + ">"+ fh  + obj[i].increase * 100 + "%</td>" +
					"<td class=" + ys + ">" + obj[i].highPriceToday + "</td><td>" + obj[i].lowPriceToday + "</td>" +
					"<td>" + obj[i].volume24Hour + "</td><td><div class='curve'></div></td><input value='"+obj[i].pairSymbol+"' type='hidden'/>" +
					"<input type='hidden' value='"+obj[i].pairId+"'/></tr>";
			nr += t;
			if(i == obj.length - 1) {
				$("#USDT").empty();
//				$("#USDT").append("<tr><th>币种</th><th>最新成交价</th><th>折合CNY</th><th>日涨跌</th><th>24H最新价</th><th>24H最低价</th><th>24H成交量</th><th>价格趋势(3日)</th></tr>" + nr);
				$("#USDT").append(nr);
			}
			kxsj.push(obj[i].day7KLine);
		}
	} else {
		for(var i = 0; i < obj.length; i++) {
			var ys = "";
			var djtb = "";
			var fh="";
			if(obj[i].increase < 0) {
				ys = "sybg_2_hong";
				fh="-";
			} else {
				ys = "sybg_2_lv";
				fh="+";
			}
			for(var j = 0; j < getCookie("zixuan").split(",").length; j++) {
				//			alert(getCookie("zixuan").split(",")[j]);
				//			alert(obj[i].symbol);
				if(obj[i].symbol == getCookie("zixuan").split(",")[j]) {
					djtb = "background: url(img/L_56.png) 50% 50% no-repeat scroll;"
					var t = "<tr><td><i onclick='iddjsj(this)' style='" + djtb + "' class=" + obj[i].symbol + "></i><img src='"+obj[i].img+"' height='20px;'>" +
							"<span>" + obj[i].name + "</span></td><td class=" + ys + ">" + obj[i].priceForUsdt + "</td>" +
							"<td class=" + ys + ">¥" + obj[i].priceForCny + "</td><td class=" + ys + ">"+ fh + obj[i].increase * 100 + "%</td>" +
							"<td class=" + ys + ">" + obj[i].highPriceToday + "</td><td>" + obj[i].lowPriceToday + "</td><td>" + obj[i].volume24Hour + "</td>" +
							"<td><div class='curve'></div></td><input value='"+obj[i].pairSymbol+"' type='hidden'/>" +
							"<input type='hidden' value='"+obj[i].pairId+"'/></tr>";
					//j=0;
					//										if(L_DF.indexOf(obj[i]) != "-1") {
					//					
					//										} else {
					//											L_DF.push(obj[i]);
					//										}

					break;
				} else {
					djtb = "";
					var t = "<tr><td><i onclick='iddjsj(this)' style='" + djtb + "' class=" + obj[i].symbol + "></i><img src='"+obj[i].img+"' height='20px;'>" +
							"<span>" + obj[i].name + "</span></td><td class=" + ys + ">" + obj[i].priceForUsdt + "</td>" +
							"<td class=" + ys + ">¥" + obj[i].priceForCny + "</td><td class=" + ys + ">" + fh  + obj[i].increase * 100 + "%</td>" +
							"<td class=" + ys + ">" + obj[i].highPriceToday + "</td><td>" + obj[i].lowPriceToday + "</td>" +
							"<td>" + obj[i].volume24Hour + "</td><td><div class='curve'></div></td><input value='"+obj[i].pairSymbol+"' type='hidden'/>" +
							"<input type='hidden' value='"+obj[i].pairId+"'/></tr>";
					//	j=0;
				}
			}
			//	var t = "<tr><td><i onclick='iddjsj(this)' style='"+djtb +"' class=" + obj[i].symbol + "></i><img src=" + obj[i].img + "><span>" + obj[i].name + "</span></td><td class=" + ys + ">" + obj[i].priceForUsdt + "</td><td class=" + ys + ">¥" + obj[i].priceForCny + "</td><td class=" + ys + ">" + obj[i].increase * 100 + "</td><td class=" + ys + ">" + obj[i].highPriceToday + "</td><td>" + obj[i].lowPriceToday + "</td><td>" + obj[i].volume24Hour + "</td><td><div class='bzkxt' style='width: 150px;'></div></td></tr>"
			//		alert(t);
			kxsj.push(obj[i].day7KLine);
			nr += t;
			if(i == obj.length - 1) {
				$("#USDT").empty();
				//$("#USDT").append("<tr><th>币种</th><th>最新成交价</th><th>折合CNY</th><th>日涨跌</th><th>24H最新价</th><th>24H最低价</th><th>24H成交量</th><th>价格趋势(3日)</th></tr>" + nr);
				$("#USDT").append(nr);
			}

		}
	}
	
	// 给每个交易对添加点击事件
	$("#USDT tr:not(:first)").each(function(){
		$(this).children().eq(0).click(function(){
			var symbol = $(this).parent().children().eq(-2).val();
			var pairId = $(this).parent().children().eq(-1).val();
			window.location.href="http://192.168.136.1:8080/gme-web/bbTrans.html?symbol="+symbol+"&pairId=" + pairId;
		});
	});
}