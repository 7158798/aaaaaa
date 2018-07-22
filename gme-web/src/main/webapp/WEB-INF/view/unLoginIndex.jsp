<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gate.io - The Gate of Blockchain Assets Exchange</title>
<meta name="description"
	content="网址是 Gate.io， 是一个区块链数字资产交易平台，支持比特币Bitcoin, 以太坊, Ethereum,莱特币, Litecoin，Qtum 等币种交易，其特点是快捷，安全。 ">
<meta name="keywords"
	content="比特币, bitcoin, BTC, Ethereum, 以太坊, litecoin, LTC, ETC, Qtum, 代币, ICO, 交易平台，交易网站，比特币交易，比特币兑换，比特币市场 ">
<meta name="format-detection" content="telephone=no">
<!--[if lte IE 9]><script type="text/javascript">location.href = '/update.html';</script><![endif]-->
<link href="css/style.css" rel="stylesheet" type="text/css">
<style>
.icon-48, .icon-32, .icon-16 {
	background-image: url("../yyctjys/images/coins48.png")
}
</style>
<link href="css/coins_16.css" rel="stylesheet" type="text/css">
<link href="css/coins_32.css" rel="stylesheet" type="text/css">
<link href="css/coins_48.css" rel="stylesheet" type="text/css">
<link href="css/marketlist.css" rel="stylesheet" type="text/css">
<link href="css/theme_dark.css" rel="stylesheet" type="text/css"
	id="darkStyle" disabled="disabled">

<link href="https://gateio.io/favicon.ico" rel="shortcut icon">
<link rel="apple-touch-icon" sizes="120x120"
	href="images/apple-touch-icon-120x120.png" />
<script>
	var g_lang = 'cn';
</script>
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.common.tools.js"></script>
</head>

<body class="">
	<div class="header clearfix">
		<div class="top-up">
			<div class="top-con">
				<ul class="topprice">
					<li>BTC/CNY : ￥ <span class="topnum">55362.06</span><i
						class="icon-arrow-up">&uarr;</i>
					</li>
					<li>ETH/CNY : ￥ <span class="topnum">4654.00</span><i
						class="icon-arrow-up">&uarr;</i>
					</li>
					<li>LTC/CNY : ￥ <span class="topnum">904.22</span><i
						class="icon-arrow-up">&uarr;</i>
					</li>
					<li>QTUM/CNY : ￥ <span class="topnum">108.62</span><i
						class="icon-arrow-up">&uarr;</i>
					</li>
				</ul>
				<ul class="login_lan">

					<li class="toplogin"><a href="login.html">注册&nbsp;</a>|&nbsp;
					</li>
					<li class="toplogin" id="toplogin"><a href="login.html">登录</a>
					</li>

					<li class="lang-option"><span>中文版</span><i class="caret"></i>
						<div class="more-lan">
							<a href="https://gateio.io/lang/en">English</a> <a
								href="https://gateio.io/lang/kr">한국어</a>
						</div></li>

				</ul>
				<ul id="theme">
					<span>主题:</span>
					<li id="dark" title="深色">深色</li>
					<li id="light" title="浅色">浅色</li>
				</ul>
			</div>
		</div>
		<div class="top-dn">
			<div class="logo">
				<a href="https://gate.io" target="_top"> <![if !IE]><img
					src="images/logo@@2x.png" alt="gate.io LOGO" /> <![endif]> <!--[if IE]><img src="/images/logo.png" alt="LOGO"/><![endif]-->
				</a>
			</div>

			<ul class="gateio-nav">
				<li class="nav-active"><a href="gateio_default.html">首页</a></li>
				<li class=""><a href="c2c.html" class="tooltip" title="法币交易">C2C交易</a>
				</li>

				<li class="nav-trade-item "><a href="bbjy.html">币币交易</a></li>

				<li class=""><a href="caiwubaogao.html">我的财务</a></li>

				<li class=""><a href="shenfenrenzheng.html">安全设置</a></li>
				<li class=""><a href="gonggao.html">公告</a></li>
				<li class=""><a href="wodegongdan.html">提交工单</a></li>
			</ul>

			<div id="top_last_rate" style="display: none"></div>

		</div>
	</div>
	<div class="content">

		<div id="full-screen-slider">
			<div id="bannerProgress">
				<div id="innerProg"></div>
			</div>
			<div class="l-box-con">
				<div class="login_box">
					<div class="step" id="login-reg" style="">
						<form name="login" id="loginform" method="post"
							action="https://gateio.io/login">
							<b>登录</b>
							<!-- <input type="hidden" name="iprestriction" id="iprestriction" value='1'> -->
							<div class="username">
								<input name="email" id="nick" class="intxt" placeholder="用户名"
									type="text"
									onfocus="if(placeholder=='用户名'){ $.cookie('mystyle')=='dark'?this.style.color='#fff':this.style.color='#000';placeholder=''}"
									onblur="if(placeholder==''){this.style.color='#aaa';placeholder='用户名'}">
							</div>
							<div class="password">
								<input name="password" id="pwd" class="intxt" placeholder="密码"
									type="password" autocomplete="new-password"
									onfocus="if(placeholder=='密码'){$.cookie('mystyle')=='dark'?this.style.color='#fff':this.style.color='#000';placeholder=''}"
									onblur="if(placeholder==''){this.style.color='#aaa';placeholder='密码'}"
									onkeydown="if (event.keyCode == 13) { this.form.submit(); return false; }">
							</div>
							<div class="cap-code">
								<!--<i class="icon-code"><img src="/images/loginpas.png" /></i>-->
								<input name="captcha" id="captcha" class="intxt"
									placeholder="验证码" type="text"
									onfocus="if(placeholder=='验证码'){$.cookie('mystyle')=='dark'?this.style.color='#fff':this.style.color='#000';placeholder=''}"
									onblur="if(placeholder==''){this.style.color='#aaa';placeholder='验证码'}"
									onkeydown="if (event.keyCode == 13) { this.form.submit(); return false; }"
									maxlength="8"> <img id="loginCaptcha"
									src="https://gateio.io/captcha" alt="Captcha" title="看不清？换一张"
									onclick="document.getElementById('loginCaptcha').src = '/captcha?' + Math.random(); return false">
							</div>
							<div class="btn">
								<a
									href="javascript:document.getElementById('loginform').submit()"
									class="button button-flat-action">登录</a>
							</div>
							<div class="wj">
								<a href="https://gateio.io/resetpw" target="_blank">忘记密码?</a>
								&nbsp;&nbsp;&nbsp; <a class="im-new"
									href="https://gateio.io/login" target="_blank">新用户注册</a>
							</div>
						</form>
						<div class="login_box" style="display: none;">
							<div class="user-info-box">
								<h2>欢迎使用Gate.io，zuoyehengudan</h2>
								<p>
									账号ID：<span>1581772</span>
								</p>
								<p>
									当前等级：<span>VIP-0</span>
								</p>
								<p>
									交易费折扣：<span>无</span>
								</p>
								<div class="your-total clearfix">
									<div>资金总估：</div>
									<em class="total-num cny-num">￥0.00</em><em class="hide-num"></em>
									<i class="z-hide">或</i> <em class="total-num z-hide">฿<span
										id="assetBTC">0.00000</span></em><em class="hide-num"></em> <b
										id="showHideBtn" class="view-show"></b>
								</div>
								<ul class="clearfix">
									<li><a class="r-btn" href="/myaccount">充值</a></li>
									<li><a class="r-btn" href="/myaccount">提现</a></li>
									<li><a class="r-btn" href="/myaccount">财务中心</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

			</div>
			<ul id="slides">
				<li data-id="#972697" data-txt="#e3fdfb"
					style="background: url(../yyctjys/images/banner1.png) no-repeat 50% center;">

				</li>

				<li data-id="#962536" data-txt="#ffdede">
					<div class="l-box-con">
						<div class="txt-banner txt-top-60 add-coin-banner">
							<span class="banner-thin banner-font-42"><i
								class="icon-48 icon-48-usdt"></i>比特币，以太坊大涨大跌，法币如何上车？</span>
							<div class="banner-s-font">
								<span class="banner-coininfo">gate.io
									提供快捷C2C（点对点）交易，10分钟完成法币买卖USDT，不错过任何行情！</span>
								<div class="banner-btn clearfix">
									<span class="r-btn clearfix"
										onclick="window.location.href='/c2c/usdt_cny'"><i
										class="icon-32 icon-32-usdt"></i><em>C2C交易(微信支付宝)</em></span> <span
										class="r-btn clearfix"
										onclick="window.location.href='/trade/BTC_USDT'"><i
										class="icon-32 icon-32-btc"></i><em>买卖比特币</em></span> <span
										class="r-btn clearfix"
										onclick="window.location.href='/trade/ETH_USDT'"><i
										class="icon-32 icon-32-eth"></i><em>买卖以太坊</em></span> <span
										class="r-btn clearfix"
										onclick="window.location.href='/article/16269'"><i
										class="icon-32 icon-32-usdt"></i><em>什么是USDT</em></span>
								</div>
								<div class="bg-txt">gate.io</div>
								<div class="slogan-effect">gate.io Blockchain Assets
									Trading Platform. The Gate of Blockchain Assets Exchange</div>
								<small></small>
							</div>
						</div>
					</div>
				</li>

				<li data-id="#113c5f" data-txt="#eee">
					<div class="l-box-con">
						<div class="txt-banner txt-top-60 add-coin-banner">
							<span class="banner-thin banner-font-42"><i
								class="icon-48 icon-48-gate"></i>gate.io全球加速 - 官方节点 gateio.io</span>
							<div class="banner-s-font">
								<span class="banner-coininfo">gate.io全球分布，请选择速度最快的节点使用!</span>
								<div class="banner-btn clearfix">
									<span class="r-btn clearfix"
										onclick="window.location.href='https://gateio.io'"><i
										class="icon-32 icon-32-gate"></i><em>主站</em></span> <span
										class="r-btn clearfix"
										onclick="window.location.href='https://kr.gateio.io'"><i
										class="icon-32 icon-32-korea icon-flag"></i><em>韩国节点</em></span> <span
										class="r-btn clearfix"
										onclick="window.location.href='https://us.gateio.io'"><i
										class="icon-32 icon-32-usa icon-flag"></i><em>美国节点</em></span> <span
										class="r-btn clearfix"
										onclick="window.location.href='https://gateio.io'"><i
										class="icon-32 icon-32-japan icon-flag"></i><em>日本节点</em></span>
								</div>
								<div class="bg-txt">gate.io</div>
								<div class="slogan-effect">gate.io Blockchain Assets
									Trading Platform. The Gate of Blockchain Assets Exchange</div>
								<small></small>
							</div>
						</div>
					</div>
				</li>

				<!--
		<li class="imgli" data-id="#11232d" data-txt="#ffdede">
           <a target=_blank href='/article/16378'><img src="/images/ledu.jpg"></a>
        </li>
		-->

			</ul>
			<div class="area-btn-bg"></div>
		</div>

		<div class="left_con">
			<div class="tline_btns clearfix" id="marketlist_controller">

				<button id="usdt" class="tline_btn button btn_selected">
					<span>USDT区</span>
				</button>
				<button id="btc" class="tline_btn button ">
					<span>BTC区</span>
				</button>
				<button id="eth" class="tline_btn button ">
					<span>ETH区</span>
				</button>
				<button id="custom" class="tline_btn button ">
					<span>我的自选区</span>
				</button>
				<div id="sBar">

					<div class="dataTables_wrapper">
						<div class="dataTables_filter search-p">
							<label><input type="search" id="fsBar"
								placeholder='搜索USDT'></label>
						</div>
					</div>
				</div>
			</div>
			<div id="mkCon">

				<div id="marketMain">
					<div id="mianBox" class="USDT-box">
						<table id="listTable" class="marketlist dataTable">
							<thead>
								<tr>
									<th class="sortable"><b>币种对<span class=curr-base>USDT</span></b></th>
									<th class="sortable"><b>价格<span class=curr-base>USDT</span></b></th>
									<th class="sortable"><b>交易量<span class=curr-base>USDT</span></b></th>
									<th class="sortable"><b>总市值</b></th>
									<th class="sortable day-updn"><b>日涨跌</b></th>
									<th class="sorting_disabled price-flot"><b>价格趋势(3日)</b></th>
									<th class="sorting_disabled"></th>
									<th class="sorting_disabled"><i class="fav-icon"
										title="自选"></i></th>
								</tr>
							</thead>
							<tbody id="list_tbody">
								<tr id=eos_usdt>
									<td><a class="coin-name "
										href="https://gateio.io/trade/EOS_USDT" title="EOS"><span
											class="icon-32 icon-32-eos"></span><span class="name-con"><b><span
													class="curr_a">EOS</span></b> <span class="cname">EOS</span> </span> </a>
									</td>
									<td class="rate_up">$13.98<span style='color: #999'>/￥90.87</span></td>
									<td>$12,413,778</td>
									<td>$13,980,000,000</td>
									<td class="day-updn"><span class=red>+2.73 %</span></td>
									<td>
										<div class="price-chart" id="eos_usdt_plot"></div>
									</td>
									<td><a class="go-trade-btn r-btn"
										href="https://gateio.io/trade/EOS_USDT">去交易</a></td>
									<td class="custom-option"><i class="add-fav"></i></td>
								</tr>
								<tr id=btm_usdt>
									<td><a class="coin-name "
										href="https://gateio.io/trade/BTM_USDT" title="比原链"><span
											class="icon-32 icon-32-btm"></span><span class="name-con"><b><span
													class="curr_a">BTM</span></b> <span class="cname">比原链</span> </span> </a>
									</td>
									<td class="rate_up">$0.7438<span style='color: #999'>/￥4.83</span></td>
									<td>$10,927,006</td>
									<td>$1,561,980,000</td>
									<td class="day-updn"><span class=red>+21.20 %</span></td>
									<td>
										<div class="price-chart" id="btm_usdt_plot"></div>
									</td>
									<td><a class="go-trade-btn r-btn"
										href="https://gateio.io/trade/BTM_USDT">去交易</a></td>
									<td class="custom-option"><i class="add-fav"></i></td>
								</tr>
								<tr id=eth_usdt>
									<td><a class="coin-name "
										href="https://gateio.io/trade/ETH_USDT" title="以太币"><span
											class="icon-32 icon-32-eth"></span><span class="name-con"><b><span
													class="curr_a">ETH</span></b> <span class="cname">以太币</span> </span> </a>
									</td>
									<td class="rate_up">$716.00<span style='color: #999'>/￥4654.00</span></td>
									<td>$9,664,807</td>
									<td>$67,938,734,000</td>
									<td class="day-updn"><span class=red>+1.29 %</span></td>
									<td>
										<div class="price-chart" id="eth_usdt_plot"></div>
									</td>
									<td><a class="go-trade-btn r-btn"
										href="https://gateio.io/trade/ETH_USDT">去交易</a></td>
									<td class="custom-option"><i class="add-fav"></i></td>
								</tr>
								<tr id=pst_usdt>
									<td><a class="coin-name "
										href="https://gateio.io/trade/PST_USDT" title="Primas"><span
											class="icon-32 icon-32-pst"></span><span class="name-con"><b><span
													class="curr_a">PST</span></b> <span class="cname">Primas</span>
										</span> </a></td>
									<td class="rate_up">$1.12<span style='color: #999'>/￥7.28</span></td>
									<td>$7,589,121</td>
									<td>$111,700,000</td>
									<td class="day-updn"><span class=red>+10.82 %</span></td>
									<td>
										<div class="price-chart" id="pst_usdt_plot"></div>
									</td>
									<td><a class="go-trade-btn r-btn"
										href="https://gateio.io/trade/PST_USDT">去交易</a></td>
									<td class="custom-option"><i class="add-fav"></i></td>
								</tr>
								<tr id=skm_usdt>
									<td><a class="coin-name "
										href="https://gateio.io/trade/SKM_USDT" title="Skrumble"><span
											class="icon-32 icon-32-skm"></span><span class="name-con"><b><span
													class="curr_a">SKM</span></b> <span class="cname">Skrumble</span>
										</span> </a></td>
									<td class="rate_up">$0.1000<span style='color: #999'>/￥0.65</span></td>
									<td>$6,036,275</td>
									<td>$150,000,000</td>
									<td class="day-updn"><span class=red>+11.98 %</span></td>
									<td>
										<div class="price-chart" id="skm_usdt_plot"></div>
									</td>
									<td><a class="go-trade-btn r-btn"
										href="https://gateio.io/trade/SKM_USDT">去交易</a></td>
									<td class="custom-option"><i class="add-fav"></i></td>
								</tr>
								<tr id=trx_usdt>
									<td><a class="coin-name "
										href="https://gateio.io/trade/TRX_USDT" title="波场"><span
											class="icon-32 icon-32-trx"></span><span class="name-con"><b><span
													class="curr_a">TRX</span></b> <span class="cname">波场</span> </span> </a></td>
									<td class="rate_up">$0.0807<span style='color: #999'>/￥0.52</span></td>
									<td>$5,624,926</td>
									<td>$5,294,329,108</td>
									<td class="day-updn"><span class=red>+14.57 %</span></td>
									<td>
										<div class="price-chart" id="trx_usdt_plot"></div>
									</td>
									<td><a class="go-trade-btn r-btn"
										href="https://gateio.io/trade/TRX_USDT">去交易</a></td>
									<td class="custom-option"><i class="add-fav"></i></td>
								</tr>
								<tr id=ocn_usdt>
									<td><a class="coin-name "
										href="https://gateio.io/trade/OCN_USDT" title="OCOIN"><span
											class="icon-32 icon-32-ocn"></span><span class="name-con"><b><span
													class="curr_a">OCN</span></b> <span class="cname">OCOIN</span>
										</span> </a></td>
									<td class="rate_up">$0.0187<span style='color: #999'>/￥0.12</span></td>
									<td>$4,455,720</td>
									<td>$187,000,000</td>
									<td class="day-updn"><span class=red>+10.00 %</span></td>
									<td>
										<div class="price-chart" id="ocn_usdt_plot"></div>
									</td>
									<td><a class="go-trade-btn r-btn"
										href="https://gateio.io/trade/OCN_USDT">去交易</a></td>
									<td class="custom-option"><i class="add-fav"></i></td>
								</tr>
								<tr id=lym_usdt>
									<td><a class="coin-name "
										href="https://gateio.io/trade/LYM_USDT" title="Lympo"><span
											class="icon-32 icon-32-lym"></span><span class="name-con"><b><span
													class="curr_a">LYM</span></b> <span class="cname">Lympo</span>
										</span> </a></td>
									<td class="rate_up">$0.0941<span style='color: #999'>/￥0.61</span></td>
									<td>$4,211,714</td>
									<td>$94,100,000</td>
									<td class="day-updn"><span class=red>+4.09 %</span></td>
									<td>
										<div class="price-chart" id="lym_usdt_plot"></div>
									</td>
									<td><a class="go-trade-btn r-btn"
										href="https://gateio.io/trade/LYM_USDT">去交易</a></td>
									<td class="custom-option"><i class="add-fav"></i></td>
								</tr>
								<tr id=iht_usdt>
									<td><a class="coin-name "
										href="https://gateio.io/trade/IHT_USDT" title="云产币"><span
											class="icon-32 icon-32-iht"></span><span class="name-con"><b><span
													class="curr_a">IHT</span></b> <span class="cname">云产币</span> </span> </a>
									</td>
									<td class="rate_up">$0.2220<span style='color: #999'>/￥1.44</span></td>
									<td>$3,627,125</td>
									<td>$222,000,000</td>
									<td class="day-updn"><span class=red>+7.77 %</span></td>
									<td>
										<div class="price-chart" id="iht_usdt_plot"></div>
									</td>
									<td><a class="go-trade-btn r-btn"
										href="https://gateio.io/trade/IHT_USDT">去交易</a></td>
									<td class="custom-option"><i class="add-fav"></i></td>
								</tr>
								<tr id=bot_usdt>
									<td><a class="coin-name "
										href="https://gateio.io/trade/BOT_USDT" title="菩提"><span
											class="icon-32 icon-32-bot"></span><span class="name-con"><b><span
													class="curr_a">BOT</span></b> <span class="cname">菩提</span> </span> </a></td>
									<td class="rate_down">$1.26<span style='color: #999'>/￥8.19</span></td>
									<td>$3,594,105</td>
									<td>$126,070,000</td>
									<td class="day-updn"><span class=green>-3.28 %</span></td>
									<td>
										<div class="price-chart" id="bot_usdt_plot"></div>
									</td>
									<td><a class="go-trade-btn r-btn"
										href="https://gateio.io/trade/BOT_USDT">去交易</a></td>
									<td class="custom-option"><i class="add-fav"></i></td>
								</tr>
								<tr id=btc_usdt>
									<td><a class="coin-name "
										href="https://gateio.io/trade/BTC_USDT" title="比特币"><span
											class="icon-32 icon-32-btc"></span><span class="name-con"><b><span
													class="curr_a">BTC</span></b> <span class="cname">比特币</span> </span> </a>
									</td>
									<td class="rate_up">$8517.24<span style='color: #999'>/￥55362.06</span></td>
									<td>$3,440,469</td>
									<td>$141,352,115,040</td>
									<td class="day-updn"><span class=red>+2.90 %</span></td>
									<td>
										<div class="price-chart" id="btc_usdt_plot"></div>
									</td>
									<td><a class="go-trade-btn r-btn"
										href="https://gateio.io/trade/BTC_USDT">去交易</a></td>
									<td class="custom-option"><i class="add-fav"></i></td>
								</tr>
								<tr id=ont_usdt>
									<td><a class="coin-name "
										href="https://gateio.io/trade/ONT_USDT" title="本体"><span
											class="icon-32 icon-32-ont"></span><span class="name-con"><b><span
													class="curr_a">ONT</span></b> <span class="cname">本体</span> </span> </a></td>
									<td class="rate_up">$8.19<span style='color: #999'>/￥53.24</span></td>
									<td>$3,312,557</td>
									<td>$8,185,000,000</td>
									<td class="day-updn"><span class=red>+10.61 %</span></td>
									<td>
										<div class="price-chart" id="ont_usdt_plot"></div>
									</td>
									<td><a class="go-trade-btn r-btn"
										href="https://gateio.io/trade/ONT_USDT">去交易</a></td>
									<td class="custom-option"><i class="add-fav"></i></td>
								</tr>
							</tbody>
						</table>
						<div class="load8 mload">
							<div class="loader">Loading</div>
							<span>加载中...</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="aqgxfw">
			<div class="aqgxfw_1">
				<div class="aqgxfw_2">
					<div class="aqgxfw_3">
						<div class="aqgxfw_4">
							<img src="images/icon_hsyq.png" /> <img
								src="images/icon_安全_背景@@2x.png" /> <img
								src="images/icon_安全@@2x.png" class="aqgxfw_4_1" />
						</div>
						<div class="aqgxfw_5">
							<p class="aqgxfw_6">安全</p>
							<p class="aqgxfw_7">大数据风控优化模型,防止注入,</p>
							<p class="aqgxfw_7">渗透和DDS攻击,定期财务审计</p>
							<p class="aqgxfw_7">客户资产离线储存</p>
						</div>
					</div>
				</div>
				<div class="aqgxfw_2">
					<div class="aqgxfw_3">
						<div class="aqgxfw_4">
							<img src="images/icon_hsyq.png" /> <img
								src="images/icon_稳定背景@@2x.png" /> <img
								src="images/icon_稳定@@2x.png" class="aqgxfw_4_2" />
						</div>
						<div class="aqgxfw_5">
							<p class="aqgxfw_6">稳定</p>
							<p class="aqgxfw_7">多层、多集群系统架构,多节</p>
							<p class="aqgxfw_7">点部署保障系统数据完整,运</p>
							<p class="aqgxfw_7">行稳定。</p>
						</div>
					</div>
				</div>
				<div class="aqgxfw_2">
					<div class="aqgxfw_3">
						<div class="aqgxfw_4">
							<img src="images/icon_hsyq.png" /> <img
								src="images/icon_高效背景@@2x.png" /> <img
								src="images/icon_高效@@2x.png" class="aqgxfw_4_3" />
						</div>
						<div class="aqgxfw_5">
							<p class="aqgxfw_6">高效</p>
							<p class="aqgxfw_7">高优撮合机制,充值体现快速到</p>
							<p class="aqgxfw_7">账给您极致高效的完美体验</p>
						</div>
					</div>
				</div>
				<div class="aqgxfw_2">
					<div class="aqgxfw_3">
						<div class="aqgxfw_4">
							<img src="images/icon_hsyq.png" /> <img
								src="images/icon_服务背景@@2x.png" /> <img
								src="images/icon_服务@@2x.png" class="aqgxfw_4_4" />
						</div>
						<div class="aqgxfw_5">
							<p class="aqgxfw_6">服务</p>
							<p class="aqgxfw_7">7*24小时全天候中英文在线</p>
							<p class="aqgxfw_7">客服保障您的优质使用</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="aqgxfw_8">
			<div class="aqgxfw_9">
				<div class="aqgxfw_10">
					<div class="aqgxfw_11">
						<div class="aqgxfw_12">
							<div class="aqgxfw_13">
								<div class="aqgxfw_14"></div>
							</div>
							<div class="aqgxfw_15">
								<h1 class="aqgxfw_16">官方公告</h1>
								<a href=""> <img src="images/icon_查看更多@@2x.png"
									class="aqgxfw_17" /> <span class="aqgxfw_18">查看更多</span>
								</a>
							</div>
						</div>
					</div>
					<div class="aqgxfw_19">
						<a href="">
							<div class="aqgxfw_20">
								<h1 class="aqgxfw_21">20</h1>
								<span>5月</span>
							</div>
							<div class="aqgxfw_22">
								<p class="aqgxfw_23">CRBC(文博链)5月15日-5月20日交易大赛排名名单公告</p>
								<span class="aqgxfw_24">尊敬的用户：CRBC(文博链)团队联合香港CEO交易所特此举办</span>
							</div>
						</a>
					</div>
					<div class="aqgxfw_19">
						<a href="">
							<div class="aqgxfw_20">
								<h1 class="aqgxfw_21">20</h1>
								<span>5月</span>
							</div>
							<div class="aqgxfw_22">
								<p class="aqgxfw_23">CRBC(文博链)5月15日-5月20日交易大赛排名名单公告</p>
								<span class="aqgxfw_24">尊敬的用户：CRBC(文博链)团队联合香港CEO交易所特此举办</span>
							</div>
						</a>
					</div>
					<div class="aqgxfw_19">
						<a href="">
							<div class="aqgxfw_20">
								<h1 class="aqgxfw_21">20</h1>
								<span>5月</span>
							</div>
							<div class="aqgxfw_22">
								<p class="aqgxfw_23">CRBC(文博链)5月15日-5月20日交易大赛排名名单公告</p>
								<span class="aqgxfw_24">尊敬的用户：CRBC(文博链)团队联合香港CEO交易所特此举办</span>
							</div>
						</a>
					</div>
					<div class="aqgxfw_19">
						<a href="">
							<div class="aqgxfw_20">
								<h1 class="aqgxfw_21">20</h1>
								<span>5月</span>
							</div>
							<div class="aqgxfw_22">
								<p class="aqgxfw_23">CRBC(文博链)5月15日-5月20日交易大赛排名名单公告</p>
								<span class="aqgxfw_24">尊敬的用户：CRBC(文博链)团队联合香港CEO交易所特此举办</span>
							</div>
						</a>
					</div>
					<div class="aqgxfw_19">
						<a href="">
							<div class="aqgxfw_20">
								<h1 class="aqgxfw_21">20</h1>
								<span>5月</span>
							</div>
							<div class="aqgxfw_22">
								<p class="aqgxfw_23">CRBC(文博链)5月15日-5月20日交易大赛排名名单公告</p>
								<span class="aqgxfw_24">尊敬的用户：CRBC(文博链)团队联合香港CEO交易所特此举办</span>
							</div>
						</a>
					</div>
				</div>
				<div class="aqgxfw_25">
					<div class="aqgxfw_11">
						<div class="aqgxfw_12">
							<div class="aqgxfw_13">
								<div class="aqgxfw_14"></div>
							</div>
							<div class="aqgxfw_15">
								<h1 class="aqgxfw_16">行业资讯</h1>
								<a href=""> <img src="images/icon_查看更多@@2x.png"
									class="aqgxfw_17" /> <span class="aqgxfw_18">查看更多</span>
								</a>
							</div>
						</div>
					</div>
					<div class="aqgxfw_19">
						<a href="">
							<div class="aqgxfw_20">
								<h1 class="aqgxfw_21">20</h1>
								<span>5月</span>
							</div>
							<div class="aqgxfw_22">
								<p class="aqgxfw_23">CRBC(文博链)5月15日-5月20日交易大赛排名名单公告</p>
								<span class="aqgxfw_24">尊敬的用户：CRBC(文博链)团队联合香港CEO交易所特此举办</span>
							</div>
						</a>
					</div>
					<div class="aqgxfw_19">
						<a href="">
							<div class="aqgxfw_20">
								<h1 class="aqgxfw_21">20</h1>
								<span>5月</span>
							</div>
							<div class="aqgxfw_22">
								<p class="aqgxfw_23">CRBC(文博链)5月15日-5月20日交易大赛排名名单公告</p>
								<span class="aqgxfw_24">尊敬的用户：CRBC(文博链)团队联合香港CEO交易所特此举办</span>
							</div>
						</a>
					</div>
					<div class="aqgxfw_19">
						<a href="">
							<div class="aqgxfw_20">
								<h1 class="aqgxfw_21">20</h1>
								<span>5月</span>
							</div>
							<div class="aqgxfw_22">
								<p class="aqgxfw_23">CRBC(文博链)5月15日-5月20日交易大赛排名名单公告</p>
								<span class="aqgxfw_24">尊敬的用户：CRBC(文博链)团队联合香港CEO交易所特此举办</span>
							</div>
						</a>
					</div>
					<div class="aqgxfw_19">
						<a href="">
							<div class="aqgxfw_20">
								<h1 class="aqgxfw_21">20</h1>
								<span>5月</span>
							</div>
							<div class="aqgxfw_22">
								<p class="aqgxfw_23">CRBC(文博链)5月15日-5月20日交易大赛排名名单公告</p>
								<span class="aqgxfw_24">尊敬的用户：CRBC(文博链)团队联合香港CEO交易所特此举办</span>
							</div>
						</a>
					</div>
					<div class="aqgxfw_19">
						<a href="">
							<div class="aqgxfw_20">
								<h1 class="aqgxfw_21">20</h1>
								<span>5月</span>
							</div>
							<div class="aqgxfw_22">
								<p class="aqgxfw_23">CRBC(文博链)5月15日-5月20日交易大赛排名名单公告</p>
								<span class="aqgxfw_24">尊敬的用户：CRBC(文博链)团队联合香港CEO交易所特此举办</span>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="advantage">
			<div class="aqgxfw_26"></div>
			<img src="images/icon_提示@@2x.png" />
			<p class="aqgxfw_27">比特币等密码币的交易存在风险，在全球范围内一周7天，一天24小时无休止交易，没有每日涨停跌停限制，价格受</p>
			<p class="aqgxfw_28">到新闻事件各国政策，市场需求等多种因素影响，浮动很大。我们强烈建议您事先调查了解，在自身所能承受的风险</p>
			<p class="aqgxfw_29">范围内参与交易。</p>
		</div>
	</div>
	<div class="footer" style="background-color: #152137;">
		<div class="aqgxfw_30">
			<div class="aqgxfw_31">
				<div class="aqgxfw_32">
					<img src="images/dblg.png" /> <img src="images/QQ@@2x.png"
						style="margin: 28px 6px 5px 0px;" /> <img src="images/微信@@2x.png"
						style="margin: 28px 0px 5px 0px;" /> <img src="images/新浪@@2x.png"
						style="margin: 28px 10px 5px 6px;" /> <img
						src="images/1111@@2x.png" style="margin: 6px 0px 5px 0px;" /> <img
						src="images/2222@@2x.png" style="margin: 6px 10px 5px 6px;" />
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

	<script>
		//force user to use https
		// if ('http:' != document.location.protocol) { window.location = 'http://' + window.location.hostname +":8020"+ window.location.pathname; }

		//for footer
		var tier_next_progress = '';

		$("#usdtAll").text(toThousands(106665737));
		$("#btcAll").text(toThousands(621));
		$("#ltcAll").text(toThousands(2781));
		$("#ethAll").text(toThousands(28028));
		is_login = '' != '';
	</script>

	<script>
		USDT_fiat_rate = '6.50000000';
		BTC_fiat_rate = '55362.06';
		ETH_fiat_rate = '4654';
		QTUM_fiat_rate = '108.615';
		var daysLeftArr = '{"REM":17,"TOMO":24,"HUR":25,"INSTAR":17,"TFD":24,"ELEC":24,"LST":25,"HAV":25,"SHIP":24}';
		var data_expired = '';
	</script>
	<script src="js/flot.js?0420"></script>
	<script src="js/marketlist.js?v=1525864037"></script>

	<script src="js/footer.js?v=0420"></script>

</body>

</html>

<div class="hide">t:2.058ms</div>