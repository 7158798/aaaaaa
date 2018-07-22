<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <div id="authAfter" class="L_36" style="display: none">
        	<div class="L_84">
				您已经实名认证！
			</div>
        </div>
        <div id="authLoad" class="L_36" style="display: none">
        	<div class="L_84" >
				实名认证审核中！
			</div>
        </div>
        <div id="authFail" class="L_36" style="display: none">
        	<div class="L_84">
				<span id="failText"></span>
			</div>
        </div>
		<div id="auth" class="L_36">
				<div class="L_84">
					您尚未实名认证！为保障您的资金安全，在完成实名认证之前，您将不能进行C2C交易，提币等操作。
					<a href="realNameAuth.html" style="display: inline-block;background: #fb9a00;color: #FFFFFF;">立即认证</a>
				</div>
				<div class="L_39">
					用户信息实名登记
				</div>
				<div class="L_84" style="margin-bottom: 30px;">
					<span class="L_84_a">您的账号ID：</span><span style="font-weight: 600;font-size: 16px;color: #ff2805;">${uid}</span>
				</div>
				<div class="L_49">
					<div class="L_83">
						<p>为了您的账户资金安全，请您登记实名认证信息。</p>
						<p>请注意，信息一经登记，无法修改，之后办理提现，账号验证等业务信息必须与登记信息相符，请务必如实填写。</p>
						<div class="L_83_1"></div>
						<p>照片要求：</p>
						<p>1.照片文件大小不能超过4M！文件格式必须为jpg或者png！</p>
						<p>2.请确保照片无水印，无污渍，身份信息清晰，头像完整，非文字反向照片！照片请勿进行PS处理！</p>
						<p>3.手持身份证照片：需要您本人一只手持<span>您的身份证</span>，另一只手持一张有您手写的<span>gme账号ID的白纸</span>。 确保身份证和白纸在您的胸前，不遮挡您的脸部，并且身份证和白纸上的信息清晰可见！
						</p>
						<p>手持白纸请手写以下内容，内容不符者不予通过：<span>“本人知晓虚拟币投资风险巨大，自愿参与，自担风险，保证身份信息不提供给他人，不使用gme账号进行非法行为，如有违反，本人愿意承担法律风险。”</span></p>
						<p class="L_83_a">以下图片仅作为示例，请提供您本人的身份材料照片。照片勿进行PS处理！</p>
						<div class="L_83_2">
							<div class="L_83_21">
								<p style="margin-bottom: 26px;">上传身份证正面：</p>
								<div class="L_83_211">
									<img src="img/L_36.png" />
								</div>
								<div class="L_83_212">
									<input type="file" accept="image/jpg,image/jpeg,image/png" />
								</div>
							</div>
							<div class="L_83_21">
								<p style="margin-bottom: 26px;">上传身份证反面：</p>
								<div class="L_83_211">
									<img src="img/L_37.png" />
								</div>
								<div class="L_83_212">
									<input type="file" accept="image/jpg,image/jpeg,image/png" />
								</div>
							</div>
							<div class="L_83_21">
								<p style="margin-bottom: 26px;">手持身份证件照片：</p>
								<div class="L_83_211">
									<img src="img/L_38.png" />
								</div>
								<div class="L_83_212">
									<input type="file" accept="image/jpg,image/jpeg,image/png" />
								</div>
							</div>
						</div>
						<p>请严格按照要求上传材料照片，否则会造成您的认证不过审核，耽误您的宝贵时间！</p>
						<input type="button" value="重新上传" class="L_83_3" />
						<p class="L_83_4"><span id="L_83_4_a">您的姓名：</span><input type="text" id="name"/></p>
						<p class="L_83_4"><span id="L_83_4_a">请再次输入您的姓名：</span><input type="text" id="confirmName"/></p>
						<p class="L_83_4"><span id="L_83_4_a">您的证件类型：</span>
							<select id="IDCardType">
								<option value="1">身份证</option>
								<option value="2">护照</option>
								<option value="3">军官证</option>
								<option value="4">台湾居民通行证</option>
								<option value="5">港澳居民通行证</option>
							</select>
						</p>
						<p class="L_83_4"><span id="L_83_4_a">您的证件号码：</span><input type="text" id="IDCard" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')"/></p>
						<p class="L_83_5"><input id="confirmButton" type="button" value="确认无误并提交" /></p>
					</div>
				</div>
			</div>
			<input id="isAuthStatus" type="hidden" value="${isAuthStatus}"/>
			<input id="authFailMsg" type="hidden" value="${authFailMsg}"/>
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/page/security/realNameAuth.js"></script>
		
	</body>

</html>