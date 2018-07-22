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
		<script type="text/javascript" src="js/jquery.qrcode.js"></script>
		<script type="text/javascript" src="js/qrcode.js"></script>
		<script type="text/javascript" src="js/utf.js"></script>
		
	</head>

	<body class="">
			<div class="L_36">
				<div class="L_39">
					${symbol}充值
				</div>
				<div class="L_49">
					<div class="L_53" style="height: 350px;">
						<p style="color: #e95e5e;margin-bottom: 24px;">温馨提示：此地址仅接受BCH充值，单笔最小充值金额为0.00001，任何低于最小金额或非BCH的充值都无法到账且不可找回。</p>
						<p style="font-size: 13px;margin-bottom: 14px;">${symbol} 地址：<span id="usdtAddress"></span>
							<a onclick="copyContent();" style="color: #1a99b9;"> 复制</a>
						</p>
						<p style="margin-bottom: 10px;">或使用${symbol}钱包扫码支付</p>
						<div id="qrcode" style="width: 50px;height: 20px"></div>
						<br/><br/><br/><br/><br/><br/>
						<p style="margin-bottom: 4px;">充值说明：</p>
						<p>由于转账需要整个网络节点的确认，故到账时间由网络的拥挤程度决定，1次确认后入账，6次确认后可提现。</p>
					</div>
					<div class="L_49" style="width: 100%;">
						<div class="L_50" style="margin-top: 30px;">
							<span style="font-size: 15px;float: left;">最近充值记录</span>
							<span style="font-size: 15px;float: right;"><a href="rechargeRecord.html">更多</a></span>
						</div>
						<div class="L_51">
							<table id="rechargeRecordTable" class="L_40" style="width: 100%;">
								<tr>
									<th>时间</th>
									<th>数量</th>
									<th>TX ID</th>
									<th>状态</th>
									<th>交易ID</th>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<input type="hidden" value="${symbol}" id="symbol">
		<!-- footer -->
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/page/wallet/recharge.js"></script>
		
	</body>

</html>