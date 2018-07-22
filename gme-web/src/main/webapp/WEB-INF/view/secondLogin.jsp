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
		<div class="L_1" style="height: 650px;">
			<div class="L_2">
				<div class="L_3" style="width: 700px;">
					<p class="L_5">登录二步验证</p>
						<p class="L_9" style="margin-top: 60px;margin-bottom: 34px;">用户登录第二步验证，是通过短信验证码进一步保证账号的安全的高级安全机制，请输入以下信息：</p>
						<p class="L_9">短信验证码</p>
						<div class="L_10" style="border: 0px;">
							<input id="identCodeId" name="identCode" class="L_13" style="width: 206px;" type="text" maxlength="6" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
							<input class="L_14_2" style="" type="button" value="获取短信验证码" />
							<input class="L_14_2" style="" type="button" value="获取电话语音验证码" />
						</div>
					<input type="button" id="zczhan" value="提交" class="L_20" style="margin-top: 40px;" onclick="onSubmit();" />
				</div>
				<div class="L_4" style="width: 500px;">

				</div>
			</div>
		</div>

		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/page/secondLogin.js"></script>
	</body>

</html>