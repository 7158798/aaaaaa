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
			<div class="L_36" style="height: 672px;">
				<div class="L_39">
					双重验证
				</div>
				<div class="L_86 L_86_a">
					<span style="float: left;margin-right: 30px;">提币手机验证</span>
					<div class="slideOne" style="top: 30px;">
						<input type="checkbox" value="None" onclick="c()" id="slideOne" name="check" />
						<label for="slideOne"></label>
					</div>
					<span id="phoneText"></span>
				</div>
				<div class="L_85" id="L_86_1" style="display: none;">
					<p>您尚未绑定手机，<span>绑定手机</span></p><br />
					<input type="button" value="立即绑定" onclick="bindPhonePage();" />
				</div>
				<div class="L_85" style="display: none;" id="L_86_2">
					<p>已绑定手机：<span id="phoneNumber"></span></p>
				</div>
				
				
				<div class="L_86">
					<span style="float: left;margin-right: 30px;">提币邮箱验证</span>
					<div class="slideOne" style="top: 30px;">
						<input type="checkbox" value="None" onclick="cc()" id="slideOne2" name="check"/>
						<label for="slideOne2"></label>
					</div>
					<span id="emailText">开启</span>
				</div>
				<div class="L_85" id="L_86_3" style="display: none;">
					<p>您尚未绑定邮箱，<span>绑定邮箱</span></p><br />
					<input type="button" value="立即绑定" onclick="bindEmailPage();" />
				</div>
				<div class="L_85" style="display: none;" id="L_86_4">
					<p>已绑定邮箱：<span id="emailNumber"></span></p>
				</div>
			</div>
			<input type="hidden" value="${phoneCode}" id="phoneCodeNum">
			<input type="hidden" value="${email}" id="emailNum">
			<input type="hidden" value="${isOpenPhone}" id="isOpenPhone">
			<input type="hidden" value="${isOpenEmail}" id="isOpenEmail">
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/page/security/withdrawDoubleValida.js"></script>
	</body>

</html>