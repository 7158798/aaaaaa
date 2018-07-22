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
        	<input id="bindPhoneNumber" type="hidden" value="${bindPhone}">
			<div class="L_36" style="height: 594px;">
				<div class="L_39">
					手机绑定
				</div>
				<div class="L_85" id="L_85">
					<p>您尚未绑定手机，<span>绑定手机</span></p><br />
					<input type="button" value="立即绑定" onclick="$('#L_85').css('display','none');$('#L_85_2').css('display','block');" />
				</div>
				<div class="L_85_2" id="L_85_2">
					<p><span>手机号码：</span>
						<select id="L_85_qh" id="countryCode">
								<option value="86">+86</option>
								<option value="852">+852</option>
								<option value="886">+886</option>
								<option value="853">+853</option>
								<option value="81">+81</option>
								<option value="82">+82</option>
								<option value="44">+44</option>
								<option value="49">+49</option>
								<option value="1">+1</option>
								<option value="61">+61</option>
								<option value="60">+60</option>
								<option value="63">+63</option>
								<option value="65">+65</option>
								<option value="66">+66</option>
								<option value="855">+855</option>
								<option value="84">+84</option>
								<option value="856">+856</option>
								<option value="95">+95</option>
								<option value="62">+62</option>
								<option value="673">+673</option>
								<option value="670">+670</option>
								<option value="356">+356</option>
						</select>
						<input id="phone" onblur="checkPhone(this.value);" class="L_85_2_a" type="tel"/></p>
						
					<p style="margin-top: 20px;margin-bottom: 20px;"><span>验证码：</span>
					<input id="identCode" class="L_85_2_b" type="text"/>
					<input id="phoneCodeButton" onclick="sendPhoneCode();" class="L_85_2_c"  type="button" value="获取验证码"  style=""/></p>
					<p><input onclick="confirmbindPhone();" class="L_85_2_d" type="button" onclick="$('#L_85_2').css('display','none');$('#L_85_3').css('display','block');" value="确定"/></p>
				</div>
				<div class="L_85_3" id="L_85_3">
					<p>您的手机短信验证功能已经启用，手机尾号为<span id="phoneNumber"></span>。登录，提现等操作时使用。</p>
					<p>注意：启用后不能再修改手机号码。</p>
				</div>
			</div>
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/utils.js"></script>
		<script type="text/javascript" src="js/page/security/bindPhone.js"></script>

	</body>

</html>