<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath }${fns:getAdminPath()}/user"/>
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
		<div class="L_1" style="height: 840px;">
			<div class="L_2">
				<div class="L_3">
					<p class="L_5">欢迎登录</p>
					<p class="L_9" style="margin-top: 60px;">账号</p>
						<div class="L_10">
							<input id="dlzhanghao" class="L_22" type="text" value="13697103161"/>
						</div>
					<p class="L_9">密码</p>
					<input type="password" id="password" class="L_15" value="1"/>
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
					<input type="button" id="" onclick="dlsc()" value="登陆" class="L_20" style="margin-top: 40px;" />
					<a href="register.html" class="L_23">免费注册</a>
					<a href="resetPassword.html" class="L_23" style="float: right;">忘记密码</a>
				</div>
				<div class="L_4" style="margin-top: 160px;">
					<p class="L_21" style="margin-bottom: 6px;">还不是GME的用户？</p>
					<p class="L_21"><a href="zhucheyemian.html">立即注册</a>，在全球领先的数字资产交易平台开始交易。</p>
				</div>
			</div>
		</div>
		<input value="${sessionOver}" id="sessionOver" type="hidden">
		<!-- content -->

		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/page/firstLogin.js"></script>
	</body>

</html>