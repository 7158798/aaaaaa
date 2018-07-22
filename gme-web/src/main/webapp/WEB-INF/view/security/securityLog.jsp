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
			<div class="L_36" style="height: 100%;min-height: 800px;">
				<div id="L_84" class="L_84">
					您尚未实名认证！为保障您的资金安全，在完成实名认证之前，您将不能进行C2C交易，提币等操作。
					<a href="realNameAuth.html" style="display: inline-block;background: #fb9a00;color: #FFFFFF;">立即认证</a>
				</div>
				<div class="L_39">
					安全日志
				</div>
				<div class="L_49">
					<div class="L_51" style="max-height: 500px;overflow-y: auto;">
						<table id="logList" class="L_40" style="width: 100%;">
							<tr>
								<th style="width: 0%;">序号</th>
								<th>时间</th>
								<th>登录方式</th>
								<th>IP</th>
								<th>状态</th>
								<th>语言</th>
							</tr>
						</table>
					</div>
					<div class="L_49" style="width: 100%;">
						<div class="L_50" style="margin-top: 30px;">
							<span style="font-size: 15px;color: #152137;float: left;">安全设置历史</span>
						</div>
						<div class="L_51">
							<table id="historyList" class="L_40" style="width: 100%;">
								<tr>
									<th style="width: 0%;">序号</th>
									<th>时间</th>
									<th>操作</th>
									<th>IP</th>
								</tr>
							</table>
						</div>
					</div>
				</div>	
			</div>
			<input type="hidden" value="${isAuth}" id="auth">
			
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/utils.js"></script>
		<script type="text/javascript" src="js/auth.js"></script>
		<script type="text/javascript" src="js/page/security/securityLog.js"></script>
		
		
	</body>

</html>