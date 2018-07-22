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

		<!--
        	作者：李德芳
        	时间：2018-06-28
        	描述：
        -->
			<div class="L_36" style="height: 594px;">
				<div class="L_39">
					邮箱绑定
				</div>
				<div class="L_85" id="L_85">
					<p>您尚未绑定邮箱，<span>绑定邮箱</span></p><br />
					<input type="button" value="立即绑定" onclick="$('#L_85').css('display','none');$('#L_85_2').css('display','block');" />
				</div>
				<div class="L_85_2" id="L_85_2">
					<p><span>邮箱：</span><input id="email" type="tel" class="L_85_2_e" value="1914194652@qq.com" /></p>
					<p style="margin-top: 20px;margin-bottom: 20px;"><span>验证码：</span><input id="emailCode" class="L_85_2_b"  type="text"  /><input type="button" onclick="sendEmailCode();" value="获取验证码" class="L_85_2_c"/></p>
					<p><input type="button"  onclick="confirmBindEmail();" class="L_85_2_d" value="确定"  /></p>
				</div>
				<div class="L_85_3" id="L_85_3">
					<p>已绑定邮箱：<span id="emailNum"></span>。用于安全通知，登陆，安全设置时输入。</p>
				</div>
			</div>
			<div class="tc">
				<div class="tc_1">
					<div class="tc_1_1">
						<span>信息提示</span>
						<img src="img/L_10.png" onclick="$('.tc').css('display','none');" />
					</div>
					<div class="tc_1_2">
						<p class="L_9">资金密码:<input type="password" id="zijinmima"/></p>
						<div class="tc_1_3">
							<input onclick="sendRequest();" type="button" value="确定" />
							<input onclick="$('.tc').css('display','none');" type="button" value="取消" />
						</div>
					</div>
				</div>
			</div>
			<input type="hidden" value="${bindEmail}" id="bindEmailNum"/>
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/utils.js"></script>
		<script type="text/javascript" src="js/page/security/bindEmail.js"></script>
		
		
	</body>

</html>