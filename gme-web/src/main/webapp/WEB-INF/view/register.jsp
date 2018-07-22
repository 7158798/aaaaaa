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
		<div class="L_1">
			<div class="L_2">
				<div class="L_3">
					<p class="L_5">欢迎注册</p>
					<a class="L_6 action_6" id="sjzc">手机注册</a>
					<a class="L_6" id="yxzc">邮箱注册</a>
					<div id="sjzclb">
						<p class="L_7">国籍</p>
						<select class="L_8">
							<option value="中国">中国</option>
							<option value="中国香港">中国香港</option>
							<option value="中国台湾">中国台湾</option>
							<option value="中国澳门">中国澳门</option>
							<option value="日本">日本</option>
							<option value="韩国">韩国</option>
							<option value="英国">英国</option>
							<option value="德国">德国</option>
							<option value="加拿大">加拿大</option>
							<option value="澳大利亚">澳大利亚</option>
							<option value="马来西亚">马来西亚</option>
							<option value="菲律宾">菲律宾</option>
							<option value="新加坡">新加坡</option>
							<option value="泰国">泰国</option>
							<option value="柬埔寨">柬埔寨</option>
							<option value="越南">越南</option>
							<option value="老挝">老挝</option>
							<option value="缅甸">缅甸</option>
							<option value="印度尼西亚">印度尼西亚</option>
							<option value="文莱">文莱</option>
							<option value="东帝汶">东帝汶</option>
							<option value="马耳他">马耳他</option>
						</select>
						<p class="L_9">手机号码</p>
						<div class="L_10">
							<select class="L_11" id="quhao">
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
								<option value="60">+60</option>
								<option value="60">+60</option>
								<option value="60">+60</option>
							</select>
							<input id="sjhm" class="L_12" type="tel" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')" />
						</div>
						<p class="L_9">验证码</p>
						<div class="L_10" style="border: 0px;">
							<input class="L_13" id="sjyzm" type="text" maxlength="6" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
							<input class="L_14" onclick="telpanduan()" type="button" value="发送验证码" />
						</div>
					</div>
					<div id="yxzclb">
						<p class="L_9">邮箱账号</p>
						<div class="L_10">
							<input id="youxianghaoma" class="L_22" type="email" />
						</div>
					</div>
					<p class="L_9">登陆密码</p>
					<input type="password" id="denglimima" class="L_15" />
					<p class="L_9">确认密码</p>
					<input type="password" class="L_15" />
					<p class="L_9">资金密码</p>
					<input type="password" id="zijinmima" class="L_15" />
					<p class="L_9">确认资金密码</p>
					<input type="password" class="L_15" />
					<p class="L_9">图片验证码</p>
					<div class="L_16">
						<input id="validataImg" class="L_17" type="text" maxlength="6" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
						<div class="L_18">
							<span onclick=" ">看不清？换一张</span>
							<div id="tupianyanzhengma ">
								<img src="ImageValidateServlet" />
							</div>
						</div>
					</div>
					<p class="L_19"><input id="yhxy" type="checkbox" checked="checked" />我已阅读并同意
						<a href="# ">《用户使用协议》</a>
					</p>
					<input type="button" id="zczhan" value="注册" onclick="zczh()" class="L_20" />
				</div>
				<div class="L_4">
					<p class="L_21">验证邮件可能会被误判为垃圾邮件，请注意查收。</p>
					<p class="L_21">请妥善保存您的GME账号及登录密码。</p>
					<p class="L_21">请勿和其他网站使用相同的登录密码。</p>
				</div>
				
			</div>
		</div>
		<input type="hidden" value="${activeFailed}" id="activeFailed">
		<!-- footer -->
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/utils.js"></script>
		<script type="text/javascript" src="js/page/register.js"></script>
	</body>

</html>