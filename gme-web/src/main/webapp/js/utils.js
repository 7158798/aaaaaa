//格式化时间 yyyy-MM-dd hh:mm:ss
function getFormatDateWithHours(date) {
	var date = new Date(date);
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var strHours = date.getHours();
    var strMin = date.getMinutes();
    var strSeconds = date.getSeconds();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if (strHours >= 0 && strHours <= 9) {
    	strHours = "0" + strHours;
    }
    if (strMin >= 0 && strMin <= 9) {
    	strMin = "0" + strMin;
    }
    if (strSeconds >= 0 && strSeconds <= 9) {
    	strSeconds = "0" + strSeconds;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + strHours + seperator2 + strMin
            + seperator2 + strSeconds;
    return currentdate;
}

//格式化时间 yyyy-MM-dd
function getFormatDate(date) {
	var date = new Date(date);
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

// 倒计时30分钟
function countdown(date){
	var timestamp = Date.parse(date); 
	var countdownTime = timestamp/1000 + 30*60;
	var currentTime = new Date();
	var currentTimestamp = currentTime/1000;
	var between = countdownTime - currentTimestamp;
	var minutes = parseInt(between / 60 % 60, 10);//计算剩余的分钟 
	var seconds = parseInt(between % 60, 10);//计算剩余的秒数 
	var chr = [minutes,seconds];
	return chr;
}

function leftTimer(orderId, createTime,status){
	
	var countdowntime = countdown(createTime);
	var min = countdowntime[0];
	var sec = countdowntime[1];
	if(min <= 0)
	{
		min = 0;
		sec = 0;
	}

	min = checkTime(min);
	sec = checkTimeSec(sec); 
 
	var str = "#orderTimeSpan"+orderId;
	if (status == 1) {
		$(str).html("还剩下"+min+"分"+sec+"秒");
	}else {
		$(str).html("还剩下0分00秒");
	}
	
}

function checkTime(i){ //将0-9的数字前面加上0，例1变为01 
  if(i<10 && i>0) { 
    i = "0" + i; 
  } 
  return i; 
} 
function checkTimeSec(i){ //将0-9的数字前面加上0，例1变为01 
  if(i<10) { 
    i = "0" + i; 
  } 
  return i; 
}


function getNumberValue(value)
{
	var s = String(value); 
	var index = 0;
	for(var i=s.indexOf(".")+1;i<s.length;i++)
	{ 
		if(s.substring(i,i+1) == "0")
		{ 
			index++; 
		}
		else
		{
			break;
		}
	}  
	if(index>4)
		index = 4;
	index = index+4;    
	return Number(value).toFixed(index);
}




// 分页工具
function PageRecord(url,queryData,table){
	var dataChar;
	var dataCharBuy;
	var dataCharSell;
	$.ajax({
		type: "GET",
		url: url,
		dataType: "json",
		data: queryData,
		success: function(data){
			if (data.code == 200) {
				var strTableRemove = "#"+table+" tr:not(:first)";
				var strTable = "#"+table;
				// 公告
				if (table == "noticeTitleList") {
					$("#noticeTitleList li").remove();
				}else if (table == "gdjl") {
					// 工单
					$("#gdjl div:first").remove();
				}else if (table == "currencyTable" && queryDate == "type=2") {
					// 资产
					$("#soldCurrentTable tr:not(:first)").remove();
					$(strTableRemove).remove();
				}else {
					$(strTableRemove).remove();
				}
				
				// 分页数据
				var currentPage = data.data.currentPage;
				var numPerPage = data.data.pageCount;
				
				// 我的成交记录 币币交易
				if (table == "myTransRecordTable") {
					$("#currentPageTrans").val(currentPage);
					$("#pageCountTrans").val(numPerPage);
				}else {
					$("#currentPage").val(currentPage);
					$("#pageCount").val(numPerPage);
				}
				
				// 如果是 我的委托记录
				if (table == "myEntrustRecordTable") {
					dataCharBuy = data.data.recordList[0];
					dataCharSell = data.data.recordList[0];
					showTable();
				}else {
					dataChar = data.data.recordList;
					showTable(dataChar,table,strTable);
				}
				
				// 如果是公告  给所有的公告标题绑定onclick事件
				if (table == "noticeTitleList") {
					$("#noticeTitleList").children().each(function(){
						var id = $(this).children().eq(-1).val();
						$(this).click(function(){
							window.location.href="http://192.168.136.1:8080/gme-web/noticeDetail.html?noticeId=" + id;
						});
					});
				}
				
				// 如果是工单
				if (table == "gdjl") {
					// 查看详情注册点击事件
					$(".L_96_15 a").each(function(){
						$(this).click(function(){
							var workId = $(this).parent().parent().parent().parent().parent().children().children().eq(-1).val();
							window.location.href="http://192.168.136.1:8080/gme-web/workListDetail.html?subjectId=" + workId;
						});
					});
				}
				
			}else {
				alert("分页查询记录列表:" + data.message);
			}
		}
	});
}

// 展示数据
function showTable(dataChar,table,strTable) {
	
	// 我的委托记录
	if (table == "myEntrustRecordTable") {
		var dataCharBuy = dataChar.buyOrders;
		var dataCharSell = dataChar.sellOrders;
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
							url: "http://192.168.136.1:8080/gme-web/api/v1/coin/queryDetial.json",
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
						url: "http://192.168.136.1:8080/gme-web/api/v1/coin/cancelCoinOrder.json",
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
		
		
	}else {
		for (var i = 0; i < dataChar.length; i++) {
			var data = dataChar[i];
			// 判断是哪一个表格
			
			// 我的成交记录 币币交易
			if (table == "myTransRecordTable") {
				var date = getFormatDateWithHours(data.date);
				var typeStr = "";
				if (data.type == 1) {
					typeStr = "买入";
				}
				if (data.type == 2) {
					typeStr = "卖出";
				}
				$("#myTransRecordTable").append("<tr><td>"+date+"</td><td>"+typeStr+"</td><td>"+data.pairSymbol+"</td><td>"+data.price+"</td><td>"+data.amount+"</td><td>"+data.total+"</td><td>"+data.procedureFee+"</td></tr>");
			}
			
			// 我的c2c  商家c2c
			if (table == "c2cTransRecordTable" || table == "c2cBusTransRecordTable") {
				var statusStr = "";
				var typeStr = "";
				var stradd = "";
				var payMethod = data.payMethod;
				if (data.status == 1) {
					statusStr = "交易中";
				}else if (data.status == 3) {
					statusStr = "已完成";
				}else if (data.status == 4) {
					statusStr = "已取消";
				}else if (data.status == 7) {
					statusStr = "已申诉";
				}
				
				if (data.type == 1) {
					typeStr = "买入"
				}else if (data.type == 2){
					typeStr = "卖出"
				}
				
				// 支付方式
				var pay1 = payMethod.substring(0, 2);
				var pay2 = payMethod.substring(2, 4);
				var pay3 = payMethod.substring(4, 6);
		 
				if(pay1 == "01") {
					stradd = stradd + "<img src='img/L_22.png' />&nbsp;";
				}
				if(pay2 == "01") {
					stradd =  stradd +"<img src='img/L_16.png' />&nbsp;";
				}
				if(pay3 == "01") {
					stradd =  stradd +"<img src='img/L_20.png' />&nbsp;";
				}
				
				$(strTable).append("<tr><td>"+data.entryOrderId+"</td><td>"+data.createTime+"</td><td>"+typeStr+"</td><td>"+stradd+"</td><td>"+data.price+"</td><td>"+data.number+"</td><td>"+data.amount+"</td><td>"+statusStr+"</td><td>"+data.targetName+"</td><td>暂无</td></tr>");
			}
			// 成交记录
			if (table == "transRecordTable") {
				var typeStr = "";
				if (data.type == 1) {
					typeStr = "买入"
				}else if (data.type == 2){
					typeStr = "卖出"
				}
				$(strTable).append("<tr><td>"+data.time+"</td><td>"+typeStr+"</td><td>"+data.pairSymbol+"</td><td>"+data.price+"</td><td>"+data.amount+"</td><td>"+data.total+"</td></tr>");
			}
			
			// 挂单
			if (table == "deityTable") {
				$(strTable).append("<tr><td>"+data.time+"</td><td>"+typeStr+"</td><td>"+data.pairSymbol+"</td><td>"+data.price+"</td><td>"+data.amount+"</td><td>"+data.total+"</td><td><a onclick='cancle(this)'>撤销</a></td><input type='hidden' value='"+data.orderId+"'/></tr>");
			}
			
			// 账单
			if (table == "billTable") {
				//业务类型1-提现;2-充值;3-交易;4-C2C
				var typeStr = "";
				if (data.bizType == 1) {
					typeStr = "提现"
				}else if (data.bizType == 2){
					typeStr = "充值"
				}else if (data.bizType == 3){
					typeStr = "交易"
				}else if (data.bizType == 4){
					typeStr = "C2C"
				}
				
				$(strTable).append("<tr><td>"+(i+1)+"</td><td>"+data.bizTime+"</td><td>"+typeStr+"</td><td>"+data.bizId+"</td>" +
									"<td>"+data.amount+"</td><td>"+data.balance+"</td></tr>");
			}
			
			// 充值
			if (table == "rechargeRecordTable"){
				var statusStr = "";
				if (data.status == 1) {
					statusStr = "等待确认";
				}else if (data.status == 2) {
					statusStr = "成功";
				}else if (data.status == 3) {
					statusStr = "已取消";
				}
				
				$(strTable).append("<tr><td>"+data.rechargeId+"</td><td>"+data.currencyId+"</td><td>"+data.updatedTime+"</td>" +
									"<td>"+data.amount+"</td><td>"+data.txId+"</td><td>"+data.confirmNumber+"</td><td>"+statusStr+"</td></tr>");
			}
			
			// 提现
			if (table == "withdrawRecordTable"){
				var statusStr = "";
				var operationStr = "";
				if (data.status == 1) {
					statusStr = "申请";
					operationStr = "<a onclick='cancle(this);'>取消提现</a>";
				}else if (data.status == 2) {
					statusStr = "处理中";
				}else if (data.status == 3) {
					statusStr = "已处理";
				}else if (data.status == 4) {
					statusStr = "已拒绝";
				}else if (data.status == 5) {
					statusStr = "撤销";
				}
				
				$(strTable).append("<tr><td>"+data.withdrawalId+"</td><td>"+data.currencySymbol+"</td><td>"+data.updatedTime+"</td>" +
									"<td>"+data.requestAmount+"</td><td>"+data.serviceCharge+"</td><td>"+data.realAmount+"</td>" +
									"<td>"+data.walletAddress+"</td><td>"+statusStr+"</td><td>"+operationStr+"</td></tr>");
			}
			
			// 我的资产
			if (table == "currencyTable") {
				var calcCount = data.amount + data.frozenAmount;
				var symbol = data.symbol;
				var rechargeStr = "<a href='recharge.html?symbol="+symbol+"'>充值</a>";
				var withdrawStr = "<a href='USDTWithdraw.html?symbol="+symbol+"'>提现</a>";
				var transStr = "<a href='bbTrans.html?symbol="+symbol+"_USDT&pairId="+data.pairId+"'>交易</a>";
				// 有资产的
				if (data.status == 0 || data.status == 2) {
					$(strTable).append("<tr><td><img src='"+data.symbolIcon+"' />"+data.symbol+"</td><td>"+data.amount+"</td>" +
										"<td>"+data.frozenAmount+"</td><td>"+calcCount+"</td><td>"+data.valueCny+"</td>" +
										"<td>"+rechargeStr + withdrawStr + transStr +"</td></tr>");
				}
				// 下架的
				if (data.status == 1) {	
					$("#soldCurrentTable").append("<tr><td><img src='"+data.symbolIcon+"' />"+data.symbol+"</td>" +
										"<td>"+data.amount+"</td><td>"+data.frozenAmount+"</td><td>"+calcCount+"</td>" +
										"<td>"+data.valueCny+"</td><td>"+ withdrawStr + "</td></tr>");
				}
			}
			
			// 公告
			if (table == "noticeTitleList") {
				var time = getFormatDateWithHours(data.createTime);
				$("#noticeTitleList").append("<li><a><span>"+data.title+"</span><span>"+time+"</span></a>" +
												"<input type='hidden' value='"+data.id+"'/></li>");
			}
			
			
			// 查看我的工单
			if (table == "gdjl") {
				var time = getFormatDateWithHours(data.dateTime);
				var status = data.workStatus;
				var statusStr = "";
				if (status == 1) {
					statusStr = "<span>未处理</span>";
				}else if (status == 2) {
					statusStr = "<span>处理中</span>";
				}else if (status == 3) {
					statusStr = "<span>已处理</span>";
				}
				
				var imgs = data.imgs;
				$("#gdjl").prepend('<div class="L_96_15"><div class="L_96_121"><img src="img/L_59.png" /></div><div class="L_96_122"><p>'+data.workContent+'</p></div></div>');
				
				$("#gdjl").children().children().eq(1).prepend('<p>'+data.name+'</p>');
				
				$("#gdjl").children().children().eq(1).append('<div class="L_96_1221"><div class="L_96_1222"></div><div class="L_96_1223"><p><a>查看详情 <img src="img/L_19.png" /></a></p><p><span>'+time+'</span>&nbsp;<span>单号:'+data.workId+'</span>&nbsp;'+statusStr+'</p></div></div><input type="hidden" value="'+data.workId+'"/>');
				
				
				for (var j = 0; j < imgs.length; j++) {
					$("#gdjl").children().children().eq(1).children().eq(2).children().eq(0).append('<img src="'+imgs[j]+'" />');
				}
			}
		}
	}
	
	
	
}




//判断是否是手机号
function isPhone(phoneNum){
	if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phoneNum))) {
		alert("手机号格式不正确");
		return false;
	}else {
		return true;
	}
}
// 判断是否是邮箱
function isEmail(email){
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!myreg.test(email)) {
		alert("请输入有效的E_mail");
		return false;
	}else {
		return true;
	}
}
