<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/CZ.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/style-hei.css" />
		<link rel="stylesheet" href="css/1200.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
		<script src="js/echarts.js"></script>
		<script src="js/utils.js"></script>
		
	</head>

	<body class="">
		<!--
        	作者：李德芳
        	时间：2018-06-28
        	描述：
        -->
		<!--
        	右
        -->
		<div class="L_92">
			<div class="L_89">
				<div class="L_89_1">
					<p>总资产折合</p>
					<p><c:out value="${LOGIN_SECONDLOGIN.balanceBTC}"></c:out>BTC</p>
					<p>≈<span><c:out value="${LOGIN_SECONDLOGIN.balanceCNY}"></c:out></span>CNY</p>
				</div>
				<div class="L_89_2">
					<div class="L_89_11">
						<div class="L_89_12">
							<a id="ZXQQ" onclick="xr(L_DF)" class="L_89_12a">自选</a>
							<a id="USDTQ" onclick="xr(L_USDT)" class="L_89_12a action_L_89_12" >USDT</a>
							<a id="ETHQ" onclick="xr(L_ETH)" class="L_89_12a">ETH</a>
							<a id="BTCQ" onclick="xr(L_BTC)" class="L_89_12a">BTC</a>
						</div>
						<input type="text" />
						<img src="img/L_6.png" />
					</div>
					<p class="L_89_13">
						<span style="width: 40%;display: inline-block;">币种</span>
						<span style="width: 33%;display: inline-block;">最新价</span>
						<span style="width: 22%;display: inline-block;">涨跌幅</span>
					</p>
					<div class="L_89_2_2">
						<table id="pairArea" class="L_89_22">
						</table>
					</div>
					<div style="height: 20px;width: 100%;"></div>
				</div>
				<div class="L_89_3">
					<p class="L_89_31">成交记录</p>
					<p class="L_89_13">
						<span style="width: 40%;display: inline-block;">成交价(BTC)</span>
						<span style="width: 33%;display: inline-block;">成交量</span>
						<span style="width: 22%;display: inline-block;">时间</span>
					</p>
					<div class="L_89_2_2" style="max-height: 940px;">
						<table id="platformTransRecord" class="L_89_22">
						</table>
					</div>
					<div style="height: 80px;width: 100%;"></div>
				</div>
			</div>
			<!--
	        	左
	        -->
	        <input id="pairId" type="hidden" value="${pairId}"/>
			<div class="L_90">
				<div class="L_90_1">
					<img class="L_90_13" src="img/L_42.png" />
					<ul class="L_90_11">
						<li id="pairSymbol">${pairSymbol}</li>
						<li id="priceUSDT">&nbsp;</li>
						<li id="percent" class="zhang">0%</li>
						<li id="maxLimit" class="">&nbsp;</li>
						<li id="minLimit" class="">&nbsp;</li>
						<li id="transCount">&nbsp;</li>
					</ul>
					<ul class="L_90_12">
						<li id="pairSymbol">&nbsp;</li>
						<li id="priceCNY" class="zhang">&nbsp;</li>
						<li class="zhang">涨跌幅</li>
						<li>24H最高价</li>
						<li>24H最低价</li>
						<li>24H成交量</li>
					</ul>
				</div>
				<div class="L_90_2">
					<p id="klineStyle">
						<a class="action_90_2" style="color: #41b2ce;" onclick="sf(1)">1分钟</a>
						<a onclick="sf(5)">5分钟</a>
						<a onclick="sf(15)">15分钟</a>
						<a onclick="sf(30)">30分钟</a>
						<a onclick="xs(1)">1小时</a>
						<a onclick="xs(4)">4小时</a>
						<a onclick="day(1)">日线</a>
						<a onclick="week(1)">周线</a>
						<a onclick="month(1)">月线</a>
					</p>
					<div id="main" style="width: 100%;height:501px;"></div>
				</div>
				<div class="L_90_3">
					<div class="L_90_31">
						<div class="L_90_311">
							<div class="L_90_3111">
								<p><span>买入${symbol}</span><span>可用${pairSymbol.split("_")[1]}:0.0000000</span></p>
								<div class="L_90_31111">
									<input id="buyPrice" placeholder="买入价" type="text" onkeyup="return checkBuyCalcAmount(this.value)?this.value:this.value='' "/>
									<span>BTC</span>
									<span class="L_90_31112">
										<a class="L_90_31112_1"><img src="img/L_46.png" /></a>
										<a class="L_90_31112_2"><img class="L_90_31113" src="img/L_46.png" /></a>
									</span>
								</div>
								<span class="L_90_31114">&emsp;≈<span id="buyChangeCNY"></span>&nbsp;CNY</span>
								<p class="L_90_31115">
									<input id="buyCount" type="text" placeholder="请输入买入数量" onkeyup="return checkBuyCalcAmount(this.value)?this.value:this.value='' "/>
									<span>${symbol}</span>
								</p>
								<ul class="line2">
									<li >
										<span class="line2-left">0%</span>
									</li>
									<li><span class="line2-left">25%</span></li>
									<li><span class="line2-left">50%</span></li>
									<li><span class="line2-left">75%</span></li>
									<li> <span class="line2-right">100%</span></li>
									<input class="line2input1" id="buyline" type="range" value="0" min="0" max="100" step="0.01" style="background-size: 0% 100%;">
								</ul>
								<p class="L_90_31114" style="margin-top: 40px;">&emsp;总计≈<span id="buyAmountSymbol"></span>&nbsp;BTC （≈<span id="buyAmountCNY"></span>&nbsp;CNY）</p>
								<input id="buyPayPassword" class="L_90_31116" type="password" placeholder="请输入交易密码">
								<input id="buyButton" class="L_90_31117" type="button" value="买入${symbol}">
							</div>
							<div class="L_90_3112">
								<p><span>卖出${symbol}</span><span>可用${symbol}:0.0000000</span></p>
								<div class="L_90_31111">
									<input id="sellPrice" type="text" placeholder="卖出价" onkeyup="return checkSellCalcAmount(this.value)?this.value:this.value='' "/>
									<span>BTC</span>
									<span class="L_90_31112">
										<a class="L_90_31112_1"><img src="img/L_46.png" /></a>
										<a class="L_90_31112_2"><img class="L_90_31113" src="img/L_46.png" /></a>
									</span>
								</div>
								<span class="L_90_31114">&emsp;≈<span id="sellChangeCNY"></span>&nbsp;CNY</span>
								<p class="L_90_31115">
									<input id="sellCount" type="text" placeholder="请输入卖出数量" onkeyup="return checkSellCalcAmount(this.value)?this.value:this.value='' "/>
									<span>${symbol}</span>
								</p>
								<ul class="line21">
									<li>
										<span class="line21-left">0%</span>
									</li>
									<li><span class="line21-left">25%</span></li>
									<li><span class="line21-left">50%</span></li>
									<li><span class="line21-left">75%</span></li>
									<li> <span class="line21-right">100%</span></li>
									<input class="line2input2" id="sellline" type="range" value="0" min="0" max="100" step="0.01" style="background-size: 0% 100%;">
								</ul>
								<p class="L_90_31114" style="margin-top: 40px;">&emsp;总计≈<span id="sellAmountSymbol"></span>&nbsp;BTC（<span id=""></span>&nbsp;CNY）</p>
								<input id="sellPayPassword" class="L_90_31116" type="text" placeholder="请输入交易密码">
								<input id="sellButton" class="L_90_31118" style="background: #03c087;" type="button" value="卖出${symbol}">
							</div>
						</div>
						<div class="L_90_312">
							<p>深度图</p>
							<div id="container" style="height: 450px"></div>
						</div>
					</div>
					<div class="L_90_32">
						<p>
							<a><img src="img/L_43.png" title="全部" /></a>
							<a><img src="img/L_44.png" title="买" /></a>
							<a><img src="img/L_45.png" title="卖" /></a>
						</p>
						<table id="selling" class="L_90_32_1">
							<tr>
								<th>价格(BTC)</th>
								<th>数量${symbol}</th>
								<th>累计${symbol}</th>
							</tr>
						</table>
						<p class="L_90_32_2">
							<span></span>
							<span>卖盘</span>
							<span>0.00094652BTC</span>
						</p>
						<p class="L_90_32_3">
							<span></span>
							<span>买盘</span>
							<span>≈42.13145CNY</span>
						</p>
						<table id="buying" class="L_90_32_4">
							<tr>
								<th>价格(BTC)</th>
								<th>数量${symbol}</th>
								<th>累计${symbol}</th>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="L_91">
				<div id="entrusType" class="L_91_1">
					<span>我的${symbol}当前委托</span>
					<a id="allEntrus" class="L_91_2 action_91_2" onclick="entrustRecord(type='3')">全部</a>
					<a id="sellEntrus" class="L_91_2" onclick="entrustRecord(type='2')">卖出</a>
					<a id="buyEntrus" class="L_91_2" onclick="entrustRecord(type='1')">买入</a>
				</div>
				<table id="myEntrustRecordTable">
					<tr>
						<th style="width: 14%;">时间</th>
						<th>买/卖</th>
						<th>价格(BTC)</th>
						<th>数量</th>
						<th>已成交</th>
						<th>未成交</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</table>
				<div class="L_41">
					<span>1</span>
					<span style="background: #2B6FC9;color: #FFFFFF;">2</span>
					<span>...</span>
					<input type="hidden" id="currentPage"/>
					<input type="hidden" id="pageCount"/>
					<span><a id="prePage">上一页</a></span>
					<span><a id="nextPage">下一页</a></span>
				</div>
			</div>
			<div class="L_91">
				<div id="transType" class="L_91_1">
					<span>我的成交记录</span>
					<a id="allTransRecord" class="L_91_2 action_91_2">全部</a>
					<a id="sellTransRecord" class="L_91_2" onclick="currencyTransRecord(2)">卖出</a>
					<a id="buyTransRecord" class="L_91_2" onclick="currencyTransRecord(1)">买入</a>
				</div>
				<table id="myTransRecordTable">
					<tr>
						<th style="width: 14%;">时间</th>
						<th>买/卖</th>
						<th>交易对</th>
						<th>价格</th>
						<th>数量</th>
						<th>成交额</th>
						<th>手续费</th>
					</tr>
				</table>
				<div class="L_41">
					<span>1</span>
					<span style="background: #2B6FC9;color: #FFFFFF;">2</span>
					<span>...</span>
					<input type="hidden" id="currentPageTrans"/>
					<input type="hidden" id="pageCountTrans"/>
					<span><a id="prePageTrans">上一页</a></span>
					<span><a id="nextPageTrans">下一页</a></span>
				</div>
			</div>
		</div>
		
		
		
		
		
		<script src="js/bbjy.js"></script>
		<script src="js/utils.js"></script>
		<script type="text/javascript" src="js/page/transaction/bbTrans.js"></script>
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/after.js"></script>
		<script type="text/javascript" src="js/calc.js"></script>
	</body>

</html>