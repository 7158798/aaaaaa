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
		<script type="text/javascript" src="js/echarts.js" ></script>
	</head>

	<body class="">
		<div class="header-top">
			<div class="header-xs">
				<span>BTC/CNY:¥</span><span>54123</span>
				<span>ETH/CNY:¥</span><span>54123</span>
				<span>LTC/CNY:¥</span><span>54123</span>
				<span>QTU/CNY:¥</span><span>54123</span>
			</div>
			<div class="header_zhuti" style="margin-right: 2%;">
				<ul>
					<span>主题</span>
					<li id="bai" style="margin-top: 11px;"></li>
					<li id="hei" style="margin-top: 11px;"></li>
				</ul>
			</div>
		</div>
		<div class="header">
			<div class="header_1">
				<div class="logo">
					<a>
						<img src="img/dblg.png" />
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
				<c:choose>
					<c:when test="${LOGIN_SECONDLOGIN == null}">
						<div class="header_2">
							<div class="header_denglu">
								<ul>
									<li>
										<a href="firstLogin.html" class="whate">登录</a>
									</li>
									<li>|</li>
									<li>
										<a href="register.html" class="whate">注册</a>
									</li>
									<li>
										<span class="zyw">中文版</span>
										<div class="yybb">
											<a href="#">ENGLISH</a>
											<a href="#">한국어</a>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</c:when>
					<c:otherwise>
					<div class="header_2">
						<div class="header_dengluhou">
							<ul>
								<li>
									<a href="accounts.html" class="header_dengluhou_a" class="whate">
										<c:out value="${LOGIN_SECONDLOGIN.account}"/><i></i>
									</a>
									<div class="header_dengluhou_dlzt">
										<p><span>ID:</span><span><c:out value="${LOGIN_SECONDLOGIN.accountId}"/></span>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
										<a onclick="$('#tc').css('display','block');">退出</a></p>
										<p><span>总资产：</span><b><c:out value="${LOGIN_SECONDLOGIN.balanceBTC}"/>BTC</b></p>
									</div>
								</li>
								<li><span class="zyw">中文版</span>
								<div class="yybb">
									<a href="#">ENGLISH</a> <a href="#">한국어</a>
								</div></li>
								</ul>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
		</div>
		<!--
        	作者：李德芳
        	时间：2018-06-28
        	描述：
        -->
		<div class="synr">
			<div class="dhlbt">
				<div id="wrap">
					<div class="banner">
						<div class="banner-img" id="banner-img1">
							<img src="img/L_54.png" id="lbt1" alt="轮播图1">
						</div>
					</div>

					<div class="banner">
						<div class="banner-img">
							<img src="img/L_54.png" alt="轮播图2">
						</div>
					</div>

					<div class="banner">
						<div class="banner-img">
							<img src="img/L_54.png" alt="轮播图3">
						</div>
					</div>

					<div class="tab" id="tabb">
						<span></span>
						<span></span>
						<span></span>
					</div>
					<script>
						document.getElementById("tabb").style.bottom = "-" + (document.body.offsetWidth * (498 / 1920) - 40) + "px";
						document.getElementById("wrap").style.height = document.body.offsetWidth * (498 / 1920) + "px";
						window.onresize = function() {
							if(document.body.offsetWidth > 1200) {
								document.getElementById("tabb").style.bottom = "-" + (document.body.offsetWidth * (498 / 1920) - 40) + "px";
								document.getElementById("wrap").style.height = document.body.offsetWidth * (498 / 1920) + "px";
							} else {
								document.getElementById("tabb").style.bottom = "-" + (1200 * (498 / 1920) - 40) + "px";
								document.getElementById("wrap").style.height = 1200 * (498 / 1920) + "px";
							}

						}
					</script>
				</div>
			</div>
			<div class="sysj">
				<div class="tmdzlggg" id="tmdzlggg">
					<ul id="leftBox">
						<li>
							<a href="#" title="">
								<img src="img/L_55.png" />
								Baryan Network上线：交易瓜分100万BBN&emsp;&emsp;&emsp;&emsp;更多>>
							</a>
						</li>
						<li>
							<a href="#" title="">
								<img src="img/L_55.png" />
								利比亚首都遭空袭 政府军射防空炮反击&emsp;&emsp;&emsp;&emsp;更多>>
							</a>
						</li>
						<li>
							<a href="#" title="">
								<img src="img/L_55.png" />
								私家车主明年起可使用北斗卫星定位服务&emsp;&emsp;&emsp;&emsp;更多>>
							</a>
						</li>
						<li>
							<a href="#" title="">
								<img src="img/L_55.png" />
								孟非微博盛赞白岩松 不愧是央视一哥&emsp;&emsp;&emsp;&emsp;更多>>
							</a>
						</li>
						<li>
							<a href="#" title="">
								<img src="img/L_55.png" />
								吴晓波：来自韩剧中的四十岁感悟&emsp;&emsp;&emsp;&emsp;更多>>
							</a>
						</li>
						<li>
							<a href="#" title="">
								<img src="img/L_55.png" />
								图集：独家曝光大S汪小菲婚礼现场&emsp;&emsp;&emsp;&emsp;更多>>
							</a>
						</li>
						<li>
							<a href="#" title="">
								<img src="img/L_55.png" />
								图集:日本石油紧缺 车辆高速路上排队购&emsp;&emsp;&emsp;&emsp;更多>>
							</a>
						</li>
					</ul>
					<img src="img/L_10.png" onclick="$('#tmdzlggg').css('display','none')" style="position: relative;left: 570px;top: -40px;cursor:pointer;" />
				</div>
				<div class="sybg">
					<span class="sybg_1">
						<a id="ZXQQ" onclick="xr(L_DF)">自选区</a>
						<a id="USDTQ" class="action_sybg_1" onclick="xr(L_USDT)">USDT区</a>
						<a id="ETHQ" onclick="xr(L_ETH)">ETH区</a>
						<a id="BTCQ" onclick="xr(L_BTC)">BTC区</a>
						<input type="text" placeholder="币种搜索" />
						<img src="img/L_6.png" />
					</span>
					<table class="sybg_2" id="USDT">
						<tr>
							<th>币种</th>
							<th>最新成交价</th>
							<th>折合CNY</th>
							<th>日涨跌</th>
							<th>24H最高价</th>
							<th>24H最低价</th>
							<th>24H成交量</th>
							<th>价格趋势(3日)</th>
						</tr>
					</table>
				</div>
			</div>
			<div class="syzwz">
				<div class="syzwz_1">
					<div class="syzwz_1_1">
						<p>全方位安全保护</p>
						<p></p>
						<p>全站使用https，请求加密，支持登录手机验证码二次验证；数字资产90%存储多重签名冷钱包；与业内顶尖安全团队合作，全方位保证您的账号和资金安全。</p>
					</div>
					<img src="img/L_50.png" />
				</div>
			</div>
			<div class="syywz">
				<div class="syywz_1">
					<div class="syywz_1_1">
						<p>强稳定可扩展系统</p>
						<p></p>
						<p>平台采用分布式系统架构设计，在处理高并发、高可用和高负载方面提供高性能解决方案。通过对服务熔断、隔离、降级提高了系统的高可用性；同时对QPS和系统日志的实时监控，保证了系统的稳定性。</p>
					</div>
					<img src="img/L_53.png" />
				</div>
			</div>
			<div class="syzwz">
				<div class="syzwz_1">
					<div class="syzwz_1_1">
						<p>高效交易极速到账</p>
						<p></p>
						<p>自主研发高效撮合引擎，满足每秒超10000笔交易，多节点服务器保证海量交易量并发下系统稳定可靠，充值提现快速到账给您极致高效的完美体验。</p>
					</div>
					<img src="img/L_52.png" />
				</div>
			</div>
			<div class="syywz">
				<div class="syywz_1">
					<div class="syywz_1_1">
						<p>全球24小时服务</p>
						<p></p>
						<p>全球多个运营中心，超百人的客服团队7*24小时全天候服务，及时响应用户反馈快速为用户提供专业的解答。中英文在线沟通满足不同用户需求。</p>
					</div>
					<img src="img/L_51.png" />
				</div>
			</div>
		</div>
		<div id="tc" class="tc">
			<div class="tc_1">
				<div class="tc_1_1">
					<span>信息提示</span>
					<img src="img/L_10.png" onclick="$('#tc').css('display','none');" />
				</div>
				<div class="tc_1_2">
					<p>您确定要退出系统吗？如果是请点击确定，如果不是请点击取消。</p>
					<div class="tc_1_3">
						<input onclick="confirmLogout();" type="button" value="确定" />
						<input onclick="cancleLogout();" type="button" value="取消" />
					</div>
				</div>
			</div>
		</div>
		<!-- content -->

		<div class="footer">
			<div class="aqgxfw_30">
				<div class="aqgxfw_31">
					<div class="aqgxfw_32">
						<img src="img/dblg.png" />
						<img src="img/QQ@@2x.png" style="margin:28px 6px 5px 0px;" />
						<img src="img/微信@@2x.png" style="margin:28px 0px 5px 0px; " />
						<img src="img/新浪@@2x.png" style="margin:28px 10px 5px 6px; " />
						<img src="img/1111@@2x.png" style="margin:6px 0px 5px 0px; " />
						<img src="img/2222@@2x.png" style="margin:6px 10px 5px 6px; " />
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
				<div class="aqgxfw_37">
					Copyright © 2017-GMEBTC All Rights Resrved
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/page/index.js"></script>
		<script type="text/javascript" src="js/login.js"></script>
	</body>

</html>