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
		<div class="L_1" style="height: 880px;">
			<div class="L_2">
				<div class="L_3">
						<p class="L_5">重置资金密码</p>
						<div id="titleDiv">
						<a class="L_6 action_6" id="sjzczh">手机重置</a>
						<a class="L_6" id="yxzczh">邮箱重置</a>
					</div>
					<div id="sjzclbzh">
						<p class="L_9">手机号码</p>
						<div class="L_10">
							<select id="quhao" class="L_11">
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
							<input id="sjhm" value="13697103161" class="L_12" type="tel" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')" />
						</div>
						<p class="L_9">登录密码</p>
						<div class="L_10" style="border: 0px;">
							<input  id="loginPasswordPhone" class="L_13" />
						</div>
						<div id="identCodeDiv" style="display: none;">
							<p class="L_9">验证码</p>
							<div class="L_10" style="border: 0px;">
								<input class="L_13" id="sjczyzm" type="text" maxlength="6" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
								<input class="L_14" onclick="telpanduan()" type="button" value="发送验证码" />
							</div>
						</div>
					</div>
					<div id="yxzclbzh" style="display: none;">
						<p class="L_9">邮箱号码</p>
						<div class="L_10">
							<input value="1914194652@qq.com" id="youxianghaoma" class="L_22" type="email" />
						</div>
						<p class="L_9">登录密码</p>
						<div class="L_10" style="border: 0px;">
							<input id="loginPasswordEmail" class="L_13" />
						</div>
						<div id="emailCodeDiv" style="display: none;">
							<p class="L_9">验证码</p>
							<div class="L_10" style="border: 0px;">
								<input class="L_13" id="yxczyzm" type="text" maxlength="6" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
								<input class="L_14" onclick="emailpanduan()" type="button" value="发送验证码" />
							</div>
						</div>
					</div>
					<div id="sjczmmtc" style="display: none;">
						<p class="L_9">新资金密码</p>
						<input type="password"  id="denglimima" class="L_15" />
						<p class="L_9">确认资金密码</p>
						<input id="confirmPassword" type="password" class="L_15" />
					</div>
					<input type="button" id="zczhan" value="确认" onclick="czmmym()" class="L_20" style="margin-top: 40px;" />
				</div>
				<div class="L_4">
				</div>
			</div>
		</div>

		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/utils.js"></script>
		<script type="text/javascript" src="js/page/security/resetPayPassword.js"></script>
	</body>

</html>