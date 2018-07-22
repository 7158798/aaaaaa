<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<html>
<head>
<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
</head>
<body>

	<div class="header">
		<div class="header_1">
			<div class="logo">
				<a> <img src="img/dblg.png" />
				</a>
			</div>
			<div class="header_daohang">
				<ul>
					<li><a href="index.html">首页</a></li>
					<li><a href="c2cTrans.html">C2C交易</a></li>
					<li><a href="bbTrans.html">币币交易</a></li>
					<li><a href="accounts.html">我的财务</a></li>
					<li><a href="securityLog.html">安全设置</a></li>
					<li><a href="notice.html">公告</a></li>
					<li><a href="myWorkList.html">提交工单</a></li>
				</ul>
			</div>
		</div>
		<div class="header_2">
			<div id="isLogin" class="header_dengluhou">
			</div>
			<input id="LOGIN_SECONDLOGIN_ACCOUNT" type="hidden" value="${LOGIN_SECONDLOGIN.account}">
			<input id="LOGIN_SECONDLOGIN_ACCOUNTID" type="hidden" value="${LOGIN_SECONDLOGIN.accountId}">
			<input id="LOGIN_SECONDLOGIN_ACCOUNTBTC" type="hidden" value="${LOGIN_SECONDLOGIN.balanceBTC}">
			<div class="header_zhuti">
				<ul>
					<span>主题</span>
					<li id="bai"></li>
					<li id="hei"></li>
				</ul>
			</div>
		</div>
	</div>

	<!--
        	作者：李德芳
        	时间：2018-06-28
        	描述：
        -->
        <div class="L_34">
			<div class="L_35">
				<ul id="titleColor">
					<li class="L_37">
						<i class="L_37_1_1"></i>
						安全设置
					</li>
					<li class="L_38">
						<a id="realNameAuth" href="realNameAuth.html">身份认证</a>
					</li>
					<li class="L_38">
						<a id="bindPhone" href="bindPhone.html">手机绑定</a>
					</li>
					<li class="L_38">
						<a id="secondLoginProtect" href="secondLoginProtect.html">两步登录保护</a>
					</li>
					<li class="L_38 ">
						<a id="resetPassword" href="resetPassword.html">修改登录密码(自动登出)</a>
					</li>
					<li class="L_38 ">
						<a id="resetPayPassword" href="resetPayPassword.html">修改资金密码(自动登出)</a>
					</li>
					<li class="L_38">
						<a id="bindEmail" href="bindEmail.html">邮箱绑定</a>
					</li>
					<li class="L_38">
						<a id="withdrawDoubleValida" href="withdrawDoubleValida.html">提币双重验证</a>
					</li>
					<li class="L_38">
						<a id="paySetting" href="paySetting.html">支付设置</a>
					</li>
					<li class="L_38">
						<a id="securityLog" href="securityLog.html">安全日志</a>
					</li>
				</ul>
			</div>
			
			
			<sitemesh:write property='body' />
			
		</div>
		<div class="tc">
			<div class="tc_1">
				<div class="tc_1_1">
					<span>信息提示</span>
					<img src="img/L_10.png" onclick="$('#tc').css('display','none');" />
				</div>
				<div class="tc_1_2">
					<p>您确定要退出系统吗？如果是请点击确定，如果不是请点击取消。</p>
					<div class="tc_1_3">
						<input type="button" onclick="confirmLogout();" value="确定" />
						<input type="button" onclick="cancleLogout();" value="取消" />
					</div>
					</div>
				</div>
			</div>
			
		<div class="footer">
			<div class="aqgxfw_30">
				<div class="aqgxfw_31">
					<div class="aqgxfw_32">
						<img src="img/dblg.png" /> <img src="img/QQ@@2x.png"
							style="margin: 28px 6px 5px 0px;" /> <img src="img/微信@@2x.png"
							style="margin: 28px 0px 5px 0px;" /> <img src="img/新浪@@2x.png"
							style="margin: 28px 10px 5px 6px;" /> <img
							src="img/1111@@2x.png" style="margin: 6px 0px 5px 0px;" /> <img
							src="img/2222@@2x.png" style="margin: 6px 10px 5px 6px;" />
					</div>
					<div class="aqgxfw_33">
						<p class="aqgxfw_34">关于我们</p>
						<p class="aqgxfw_36">上币申请</p>
						<p class="aqgxfw_36">平台简介</p>
						<p class="aqgxfw_36">公共API</p>
					</div>
					<div class="aqgxfw_35">
						<p class="aqgxfw_34">充币提币</p>
						<p class="aqgxfw_36">充币地址为何相同</p>
						<p class="aqgxfw_36">充币说明</p>
						<p class="aqgxfw_36">提币说明</p>
						<p class="aqgxfw_36">限币限额和手续费</p>
					</div>
					<div class="aqgxfw_33">
						<p class="aqgxfw_34">常见问题</p>
						<p class="aqgxfw_36">法币交易</p>
						<p class="aqgxfw_36">实名认证</p>
						<p class="aqgxfw_36">账户访问</p>
						<p class="aqgxfw_36">账户注册</p>
					</div>
					<div class="aqgxfw_33">
						<p class="aqgxfw_34">币币交易</p>
						<p class="aqgxfw_36">法币交易</p>
						<p class="aqgxfw_36">拉新返</p>
						<p class="aqgxfw_36">绑定银行卡</p>
					</div>
				</div>
				<div class="aqgxfw_37">Copyright © 2017-GMEBTC All Rights
					Resrved</div>
			</div>
		</div>
		<script type="text/javascript" src="js/login.js"></script>
		<script type="text/javascript">
			var flag = '${pageFlag}';
			$(flag).parent().attr("class","L_38 action_38");
		</script>
</body>
</html>
