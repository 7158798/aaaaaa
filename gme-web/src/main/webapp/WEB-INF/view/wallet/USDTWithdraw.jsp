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
			<div class="L_36">
				<div class="L_39">
					${symbol}提现
				</div>
				<div class="L_49">
					<div class="L_57">
						<p style="margin-bottom: 14px;margin-top: 10px;font-size: 15px;color: #152137;">提现到钱包地址</p>
						<p style="margin-bottom: 8px;font-size: 15px;color: #152137;">提币地址：</p>
						<div class="L_58">
							<input id="inputAddress" type="text" placeholder="请输入地址" onchange="$('#L_63').css('display', 'none');" oninput="$('#L_63').css('display', 'block');" />
							<input id="existingAddress" type="button" value="现有地址" onclick="if($('#L_62').css('display')=='block'){$('#L_62').css('display', 'none');}else{ $('#L_62').css('display', 'block');}" /><i></i>
							<div class="L_63" id="L_63" onclick="addAddress();">
								<a  style="position: relative;top: 0px;"><img src="img/L_9.png" />添加新地址</a>
							</div>
							<div class="L_62" id="L_62">
								<table class="L_64">
									<tbody id="alreadyAddress">
									</tbody>
								</table>
								<p>
									<a  style="color: #347ddd;font-size: 15px;"><img src="img/L_9.png" />添加新地址</a>
								</p>
							</div>
						</div>
						<p style="margin-bottom: 12px;">提币数量：</p>
						<div class="L_58">
							<input onkeyup="return clacCount(this.value)?this.value:this.value='';" id="withdrawCount" type="text" />
							<span style="float: right;display: inline-block;margin-right: 10px;">${symbol}</span>
						</div>
						<div class="L_59">
							<div class="L_60">
								<p>手续费：</p>
								<input id="withdrawCharge" readonly="readonly" type="text" maxlength="20" />
								<span style="position: relative;top: -40px;left: 390px;	">${symbol}</span>
								<p>资金密码：</p>
								<input id="payPassword" type="text" maxlength="30" placeholder="请输入资金密码"  />
							</div>
							<div class="L_61">
								<p>到账数量：</p>
								<input readonly="readonly" id="realCount" type="text" style="width: 425px;" />
								<span style="position: relative;top: -40px;left: 386px;	">${symbol}</span>
								<input style="margin-top: 36px;background: #347ddd;color: #FFFFFF;font-size: 15px;" type="button" value="提币" onclick="withdraw();"  />
							</div>
						</div>
						<p style="margin-bottom: 20px;margin-top: 34px;">温馨提示</p>
						<p style="font-size: 14px;">最小提币数量为200 ${symbol}</p>
						<p style="font-size: 14px;">为保障资金安全，当您账户安全策略变更，密码修改，使用新地址提币，我们会对提币进行人工审核，请耐心等待。</p>
					</div>
					<div class="L_49" style="width: 100%;">
						<div class="L_50" style="margin-top: 30px;">
							<span style="font-size: 15px;float: left;">最近提现记录</span>
							<span style="font-size: 15px;float: right;"><a href="withdrawRecord.html">更多</a></span>
						</div>
						<div class="L_51">
							<table id="withdrawRecordTable" class="L_40" style="width: 100%;">
								<tr>
									<th>时间</th>
									<th>数量</th>
									<th>状态</th>
									<th>交易ID</th>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		<!--
        	弹窗
        -->
		<div class="L_65" id="L_65">
			<div class="L_66">
				<div class="L_67">
					提币验证
					<img src="img/L_10.png" style="position: relative;top: -22px;right: -300px;cursor:pointer;" onclick="$('#L_65').css('display','none')" />
				</div>
				<div class="L_68">
					<span style="margin-top: 50px;display: inline-block;">短信验证码：</span>
					<input id="outIdentCode" type="text" class="L_68_a" />
					<input id="getIdentCode" onclick="sendCheckCode(1);" type="button" value="获取短信验证" class="L_68_b"/>
					<br  />
					<span style="margin-top: 50px;display: inline-block;">邮箱验证码：</span>
					<input id="outEmailCode" type="text"  class="L_68_a"/>
					<input id="getEmailCode" onclick="sendCheckCode(2);" type="button" value="获取邮箱验证"  class="L_68_b" />
					<br />
					<input id="confirmWithdraw" onclick="confirmWithdraw();" type="button" value="确认" style="position: relative;right: -42px;border: 0px;border-radius: 3px;color: #FFFFFF;font-size: 15px;margin-top: 26px;width: 460px;height: 50px;line-height: 50px;background: #347ddd;" />
				</div>
			</div>
		</div>
		<input type="hidden" value="${symbol}" id="symbol">
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/calc.js"></script>
		<script type="text/javascript" src="js/utils.js"></script>
		<script type="text/javascript" src="js/page/wallet/USDTWithdraw.js"></script>
		
		
	</body>

</html>