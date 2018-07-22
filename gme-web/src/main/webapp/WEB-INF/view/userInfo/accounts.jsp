<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/CZ.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/style-hei.css" />
		<link rel="stylesheet" href="css/1200.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	</head>

	<body class="">
				<div class="L_39">
					<div class="L_47">
						<p>我的账号ID：<span style="color:red;">${LOGIN_SECONDLOGIN.accountId}</span></p>
					</div>
				
				</div>
				<div class="L_48">
					<p>总资产估值</p>
					<p>当前资金总估：<span>${LOGIN_SECONDLOGIN.balanceUSDT}USDT</span>&nbsp;或&nbsp;<span>${LOGIN_SECONDLOGIN.balanceBTC}BTC</span></p>
					<p>注：资金总估是由历史行情估算值，仅为用户提供一个参考，请以单项资金为准。</p>
				</div>
				<div class="L_49">
					<div class="L_50">
						<p>资金(我的在线钱包)</p>
						<input type="text" placeholder="请输入币种名称" />
						<img src="img/L_6.png" />
					</div>
					<div class="L_51">
						<div class="slideOne">
							<input onclick="slideClick();" type="checkbox" value="None" id="slideOne" name="check" checked />
							<label for="slideOne"></label>
						</div>
						<span style="float: left;">只显示有资金币种(隐藏0资金币种)</span>
						<table id="currencyTable" class="L_40" style="width: 100%;">
							<tr>							
								<th style="width: 12%;">币种</th>
								<th>可用余额</th>
								<th>冻结金额</th>
								<th>总计</th>
								<th>估算为人民币</th>
								<th>操作</th>
							</tr>
						</table>
					</div>
					<div class="L_41" style="width: 100%;">
						<span>1</span>
						<span style="background: #2B6FC9;color: #FFFFFF;">2</span>
						<span>...</span>
						<input type="hidden" id="currentPage"/>
						<input type="hidden" id="pageCount"/>
						<span><a id="prePage">上一页</a></span>
						<span><a id="nextPage">下一页</a></span>
						<span style="float: left;border: 0px;font-size: 13px;margin-left: 0px;padding: 0px;">当前显示第1至8币种，共10币种</span>
					</div>
				</div>
				<div class="L_49">
					<div class="L_50">
						<p>已经下架币种列表(请提现)：</p>
					</div>
					<div class="L_51">
						<table id="soldCurrentTable" class="L_40" style="width: 100%;">
							<tr>
								<th style="width: 12%;">币种</th>
								<th>可用余额</th>
								<th>冻结金额</th>
								<th>总计</th>
								<th>估算为人民币</th>
								<th>操作</th>
							</tr>
						</table>
					</div>
				</div>
				<div class="L_49">
					<div class="L_50" style="margin-top: 30px;">
						<span style="font-size: 15px;float: left;">最近充值记录</span>
						<span style="font-size: 15px;float: right;"><a href="rechargeRecord.html">更多</a></span>
					</div>
					<div class="L_51">
						<table id="rechargeRecordTable" class="L_40" style="width: 100%;">
							<tr>
								<th style="width: 7%;">订单号</th>
								<th>币种类型</th>
								<th>时间</th>
								<th>数量</th>
								<th>TX ID</th>
								<th>确认数量</th>
								<th>状态</th>
							</tr>
						</table>
					</div>
				</div>
				<div class="L_49">
					<div class="L_50" style="margin-top: 30px;">
						<span style="font-size: 15px;float: left;">最近提现记录</span>
						<span style="font-size: 15px;float: right;"><a href="withdrawRecord.html">更多</a></span>
					</div>
					<div class="L_51">
						<table id="withdrawRecordTable" class="L_40" style="width: 100%;">
							<tr>
								<th style="width: 0%;">订单号</th>
								<th>币种类型</th>
								<th>时间</th>
								<th>提币数量</th>
								<th>手续费</th>
								<th>实际到账数量</th>
								<th>提现地址</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</table>
					</div>
					</div>
		<input value="${isAuth}" id="isAuth" type="hidden">
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/utils.js"></script>
		<script type="text/javascript" src="js/page/userInfo/accounts.js"></script>
		
		
	</body>

</html>