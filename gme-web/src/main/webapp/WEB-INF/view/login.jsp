<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }${fns:getAdminPath()}/user"/>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户登录/注册 - Gate.io - The Gate of Blockchain Assets Exchange</title>
		<meta name="description" content="网址是 Gate.io， 是一个区块链数字资产交易平台，支持比特币Bitcoin, 以太坊, Ethereum,莱特币, Litecoin，Qtum 等币种交易，其特点是快捷，安全。 ">
		<meta name="keywords" content="比特币, bitcoin, BTC, Ethereum, 以太坊, litecoin, LTC, ETC, Qtum, 代币, ICO, 交易平台，交易网站，比特币交易，比特币兑换，比特币市场 ">
		<meta name="format-detection" content="telephone=no">
		<!--[if lte IE 9]><script type="text/javascript">location.href = '/update.html';</script><![endif]-->
		<link href="css/style.css?v=1526375818" rel="stylesheet" type="text/css"> 	
		<style>
			.icon-48,
			.icon-32,
			.icon-16 {
				background-image: url("/images/coins48.png?v=1526551416")
			}
		</style>
		<link href="css/coins_16.css?v=1526551416" rel="stylesheet" type="text/css">
		<link href="css/coins_32.css?v=1526551416" rel="stylesheet" type="text/css">
		<link href="css/coins_48.css?v=1526551416" rel="stylesheet" type="text/css">

		<link href="css/theme_dark.css?0517" rel="stylesheet" type="text/css" id="darkStyle" disabled="disabled">

		<link href="favicon.ico" rel="shortcut icon">
		<link rel="apple-touch-icon" sizes="120x120" href="/images/apple-touch-icon-120x120.png" />
		<script>
			var g_lang = 'cn';
		</script>
		<script src="js/jquery-1.8.2.min.js"></script>
		<script src="js/jquery.common.tools.js?v=0207"></script>
	</head>

	<body class="">
	
	<div class="header clearfix">
			<div class="top-up">
				<div class="top-con">
					<ul class="topprice">
						<li> BTC/CNY : ￥ <span class="topnum">55289.30</span><i class="icon-arrow-up">&uarr;</i> </li>
						<li> ETH/CNY : ￥ <span class="topnum">4658.99</span><i class="icon-arrow-up">&uarr;</i> </li>
						<li> LTC/CNY : ￥ <span class="topnum">901.43</span><i class="icon-arrow-up">&uarr;</i> </li>
						<li> QTUM/CNY : ￥ <span class="topnum">108.86</span><i class="icon-arrow-up">&uarr;</i> </li>
					</ul>
					<div class="qqtel">
						<a class="ask_ans" href="https://twitter.com/gate_io" target="_blank">
							<p><i class="tico" title="Twitter"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="244 244 24 24"><path fill="#FFF" d="M267.998 248.95c-.882.39-1.83.653-2.825.77 1.016-.606 1.795-1.564 2.164-2.703-.952.56-2.007.966-3.127 1.186-.9-.95-2.177-1.545-3.594-1.545-2.722 0-4.926 2.19-4.926 4.888 0 .38.042.757.126 1.116-4.09-.205-7.72-2.152-10.148-5.106-.425.724-.67 1.563-.67 2.456 0 1.697.872 3.19 2.193 4.07-.806-.027-1.566-.246-2.23-.614v.064c0 2.368 1.7 4.34 3.95 4.792-.414.11-.848.17-1.297.17-.317 0-.625-.026-.925-.087.625 1.94 2.445 3.355 4.6 3.396-1.686 1.31-3.807 2.092-6.113 2.092-.398 0-.79-.025-1.175-.07 2.177 1.387 4.767 2.195 7.547 2.195 9.06 0 14.012-7.448 14.012-13.903 0-.213-.008-.423-.017-.63.96-.694 1.795-1.552 2.457-2.537h-.002z"/></svg></i></p>
						</a>
						<a class="ask_ans" href="https://t.me/gate_io" target="_blank">
							<p><i class="tico" title="Telegram"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="244 244 24 24"><path fill="#FFF" d="M266.38 246.07l-21.26 8.2c-1.45.58-1.442 1.39-.264 1.75l5.302 1.656 2.03 6.22c.246.68.124.95.84.95.55 0 .795-.25 1.103-.55l2.65-2.58 5.517 4.075c1.015.56 1.748.27 2-.94l3.62-17.062c.37-1.486-.567-2.16-1.538-1.72zm-15.39 11.226l11.95-7.54c.598-.363 1.145-.168.695.23l-10.233 9.233-.398 4.248-2.014-6.172z"/></svg></i></p>
						</a>
						<a class="ask_ans" href="javascript:ticketsRoute();">
							<p><i>?</i>提交工单</p>
						</a>
					</div>
					<ul class="login_lan">
						<li class="top-links">
							<a href="/mobileapp" target="_blank">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="244 244 24 24">
									<path fill="#010101" d="M262 244h-12c-.83 0-1.5.672-1.5 1.5v21c0 .83.67 1.5 1.5 1.5h12c.83 0 1.5-.67 1.5-1.5v-21c0-.828-.67-1.5-1.5-1.5zm-8.625 1.5h5.25c.208 0 .375.168.375.375s-.167.375-.375.375h-5.25c-.208 0-.375-.168-.375-.375s.167-.375.375-.375zM256 267.25c-.62 0-1.125-.504-1.125-1.125S255.38 265 256 265s1.125.504 1.125 1.125-.504 1.125-1.125 1.125zm6-3h-12v-16.5h12v16.5z"></path>
								</svg>
								<span>手机APP</span>
								<div class="add-dn-qr">
									<h3>扫码下载gate.io APP</h3>
									<img src="/images/app-code.png" alt="gate.io APP">
								</div>
							</a>
						</li>
						<li class="toplogin">
							<a href="/login">注册&nbsp;</a>|&nbsp; </li>
						<li class="toplogin" id="toplogin">
							<a href="/login">登录</a>
						</li>

						<li class="lang-option">
							<span>中文版</span><i class="caret"></i>
							<div class="more-lan">
								<a href="/lang/en">English</a>
								<a href="/lang/kr">한국어</a>
							</div>
						</li>
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
					<a href="https://gate.io" target="_top">
						<![if !IE]><img src="/images/logo.svg" alt="gate.io LOGO" />
						<![endif]>
						<!--[if IE]><img src="/images/logo.png" alt="LOGO"/><![endif]-->
					</a>
				</div>

				<ul class="gateio-nav">
					<li class="">
						<a href="/">首页</a>
					</li>
					<li class="">
						<a href="/c2c/usdt_cny" class="tooltip" title="法币交易">C2C交易</a>
					</li>

					<li class="nav-trade-item ">
						<a href="/trade/BTC_USDT">币币交易<i class="caret"></i></a>
						<ul class="second-nav clearfix">
							<li>
								<a href="javascript:;">对BTC交易区<i class="caret"></i></a>
								<ul class="third-nav clearfix">
									<li>
										<a href='/trade/ADA_BTC'><span class="icon-16-ada icon-16"></span><strong>艾达币 ADA</strong></a>
									</li>
									<li>
										<a href='/trade/AE_BTC'><span class="icon-16-ae icon-16"></span><strong>Aeternity AE</strong></a>
									</li>
									<li>
										<a href='/trade/BAT_BTC'><span class="icon-16-bat icon-16"></span><strong>注意力币 BAT</strong></a>
									</li>
									<li>
										<a href='/trade/BCD_BTC'><span class="icon-16-bcd icon-16"></span><strong>比特币钻石 BCD</strong></a>
									</li>
									<li>
										<a href='/trade/BCH_BTC'><span class="icon-16-bch icon-16"></span><strong>BCH(原BCC) BCH</strong></a>
									</li>
									<li>
										<a href='/trade/BCX_BTC'><span class="icon-16-bcx icon-16"></span><strong>比特无限 BCX</strong></a>
									</li>
									<li>
										<a href='/trade/BIFI_BTC'><span class="icon-16-bifi icon-16"></span><strong>BitcoinFile BIFI</strong></a>
									</li>
									<li>
										<a href='/trade/BTF_BTC'><span class="icon-16-btf icon-16"></span><strong>比特信仰 BTF</strong></a>
									</li>
									<li>
										<a href='/trade/BTG_BTC'><span class="icon-16-btg icon-16"></span><strong>BTG BTG</strong></a>
									</li>
									<li>
										<a href='/trade/BTM_BTC'><span class="icon-16-btm icon-16"></span><strong>比原链 BTM</strong></a>
									</li>
									<li>
										<a href='/trade/BTS_BTC'><span class="icon-16-bts icon-16"></span><strong>比特股 BTS</strong></a>
									</li>
									<li>
										<a href='/trade/DASH_BTC'><span class="icon-16-dash icon-16"></span><strong>达世币 DASH</strong></a>
									</li>
									<li>
										<a href='/trade/DBC_BTC'><span class="icon-16-dbc icon-16"></span><strong>深脑链 DBC</strong></a>
									</li>
									<li>
										<a href='/trade/DDD_BTC'><span class="icon-16-ddd icon-16"></span><strong>Scry無域 DDD</strong></a>
									</li>
									<li>
										<a href='/trade/DOGE_BTC'><span class="icon-16-doge icon-16"></span><strong>狗狗币 DOGE</strong></a>
									</li>
									<li>
										<a href='/trade/EOS_BTC'><span class="icon-16-eos icon-16"></span><strong>EOS EOS</strong></a>
									</li>
									<li>
										<a href='/trade/ETC_BTC'><span class="icon-16-etc icon-16"></span><strong>以太经典 ETC</strong></a>
									</li>
									<li>
										<a href='/trade/ETH_BTC'><span class="icon-16-eth icon-16"></span><strong>以太币 ETH</strong></a>
									</li>
									<li>
										<a href='/trade/GAS_BTC'><span class="icon-16-gas icon-16"></span><strong>小蚁Gas GAS</strong></a>
									</li>
									<li>
										<a href='/trade/GOD_BTC'><span class="icon-16-god icon-16"></span><strong>比特币上帝 GOD</strong></a>
									</li>
									<li>
										<a href='/trade/GTC_BTC'><span class="icon-16-gtc icon-16"></span><strong>G币 GTC</strong></a>
									</li>
									<li>
										<a href='/trade/GXS_BTC'><span class="icon-16-gxs icon-16"></span><strong>公信宝 GXS</strong></a>
									</li>
									<li>
										<a href='/trade/HSR_BTC'><span class="icon-16-hsr icon-16"></span><strong>HShare HSR</strong></a>
									</li>
									<li>
										<a href='/trade/INK_BTC'><span class="icon-16-ink icon-16"></span><strong>Ink INK</strong></a>
									</li>
									<li>
										<a href='/trade/IOTA_BTC'><span class="icon-16-iota icon-16"></span><strong>IOTA IOTA</strong></a>
									</li>
									<li>
										<a href='/trade/JNT_BTC'><span class="icon-16-jnt icon-16"></span><strong>JibrelNetwork JNT</strong></a>
									</li>
									<li>
										<a href='/trade/LEDU_BTC'><span class="icon-16-ledu icon-16"></span><strong>Education LEDU</strong></a>
									</li>
									<li>
										<a href='/trade/LRC_BTC'><span class="icon-16-lrc icon-16"></span><strong>Loopring LRC</strong></a>
									</li>
									<li>
										<a href='/trade/LSK_BTC'><span class="icon-16-lsk icon-16"></span><strong>Lisk LSK</strong></a>
									</li>
									<li>
										<a href='/trade/LTC_BTC'><span class="icon-16-ltc icon-16"></span><strong>莱特币 LTC</strong></a>
									</li>
									<li>
										<a href='/trade/LYM_BTC'><span class="icon-16-lym icon-16"></span><strong>Lympo LYM</strong></a>
									</li>
									<li>
										<a href='/trade/MDT_BTC'><span class="icon-16-mdt icon-16"></span><strong>量数币 MDT</strong></a>
									</li>
									<li>
										<a href='/trade/MOBI_BTC'><span class="icon-16-mobi icon-16"></span><strong>Mobius MOBI</strong></a>
									</li>
									<li>
										<a href='/trade/NANO_BTC'><span class="icon-16-nano icon-16"></span><strong>Nano NANO</strong></a>
									</li>
									<li>
										<a href='/trade/NAS_BTC'><span class="icon-16-nas icon-16"></span><strong>星云链 NAS</strong></a>
									</li>
									<li>
										<a href='/trade/NEO_BTC'><span class="icon-16-neo icon-16"></span><strong>小蚁Neo NEO</strong></a>
									</li>
									<li>
										<a href='/trade/OCN_BTC'><span class="icon-16-ocn icon-16"></span><strong>OCOIN OCN</strong></a>
									</li>
									<li>
										<a href='/trade/OMG_BTC'><span class="icon-16-omg icon-16"></span><strong>OmiseGo OMG</strong></a>
									</li>
									<li>
										<a href='/trade/PAY_BTC'><span class="icon-16-pay icon-16"></span><strong>TenX PAY</strong></a>
									</li>
									<li>
										<a href='/trade/POWR_BTC'><span class="icon-16-powr icon-16"></span><strong>PowerLedger POWR</strong></a>
									</li>
									<li>
										<a href='/trade/QASH_BTC'><span class="icon-16-qash icon-16"></span><strong>LIQUID QASH</strong></a>
									</li>
									<li>
										<a href='/trade/QLC_BTC'><span class="icon-16-qlc icon-16"></span><strong>QLINK QLC</strong></a>
									</li>
									<li>
										<a href='/trade/QTUM_BTC'><span class="icon-16-qtum icon-16"></span><strong>量子链 QTUM</strong></a>
									</li>
									<li>
										<a href='/trade/RUFF_BTC'><span class="icon-16-ruff icon-16"></span><strong>RuffChain RUFF</strong></a>
									</li>
									<li>
										<a href='/trade/SBTC_BTC'><span class="icon-16-sbtc icon-16"></span><strong>超级比特币 SBTC</strong></a>
									</li>
									<li>
										<a href='/trade/SNT_BTC'><span class="icon-16-snt icon-16"></span><strong>Status SNT</strong></a>
									</li>
									<li>
										<a href='/trade/STORJ_BTC'><span class="icon-16-storj icon-16"></span><strong>Storj STORJ</strong></a>
									</li>
									<li>
										<a href='/trade/TNC_BTC'><span class="icon-16-tnc icon-16"></span><strong>Trinity TNC</strong></a>
									</li>
									<li>
										<a href='/trade/WAVES_BTC'><span class="icon-16-waves icon-16"></span><strong>波币 WAVES</strong></a>
									</li>
									<li>
										<a href='/trade/XLM_BTC'><span class="icon-16-xlm icon-16"></span><strong>恒星币 XLM</strong></a>
									</li>
									<li>
										<a href='/trade/XMC_BTC'><span class="icon-16-xmc icon-16"></span><strong>门罗原链 XMC</strong></a>
									</li>
									<li>
										<a href='/trade/XMR_BTC'><span class="icon-16-xmr icon-16"></span><strong>门罗币 XMR</strong></a>
									</li>
									<li>
										<a href='/trade/XRP_BTC'><span class="icon-16-xrp icon-16"></span><strong>瑞波币 XRP</strong></a>
									</li>
									<li>
										<a href='/trade/XVG_BTC'><span class="icon-16-xvg icon-16"></span><strong>Verge XVG</strong></a>
									</li>
									<li>
										<a href='/trade/ZEC_BTC'><span class="icon-16-zec icon-16"></span><strong>ZCash ZEC</strong></a>
									</li>
									<li>
										<a href='/trade/ZPT_BTC'><span class="icon-16-zpt icon-16"></span><strong>Zeepin ZPT</strong></a>
									</li>
									<li>
										<a href='/trade/ZRX_BTC'><span class="icon-16-zrx icon-16"></span><strong>0x项目 ZRX</strong></a>
									</li>
								</ul>
							</li>
							<li>
								<a href="javascript:;">对ETH交易区<i class="caret"></i></a>
								<ul class="third-nav clearfix">
									<li>
										<a href='/trade/ABT_ETH'><span class="icon-16-abt icon-16"></span><strong>ArcBlock ABT</strong></a>
									</li>
									<li>
										<a href='/trade/AE_ETH'><span class="icon-16-ae icon-16"></span><strong>Aeternity AE</strong></a>
									</li>
									<li>
										<a href='/trade/ARN_ETH'><span class="icon-16-arn icon-16"></span><strong>Aeron ARN</strong></a>
									</li>
									<li>
										<a href='/trade/BAT_ETH'><span class="icon-16-bat icon-16"></span><strong>注意力币 BAT</strong></a>
									</li>
									<li>
										<a href='/trade/BCDN_ETH'><span class="icon-16-bcdn icon-16"></span><strong>BlockCDN BCDN</strong></a>
									</li>
									<li>
										<a href='/trade/BFT_ETH'><span class="icon-16-bft icon-16"></span><strong>BFToken BFT</strong></a>
									</li>
									<li>
										<a href='/trade/BLZ_ETH'><span class="icon-16-blz icon-16"></span><strong>Bluzelle BLZ</strong></a>
									</li>
									<li>
										<a href='/trade/BNT_ETH'><span class="icon-16-bnt icon-16"></span><strong>Bancor BNT</strong></a>
									</li>
									<li>
										<a href='/trade/BNTY_ETH'><span class="icon-16-bnty icon-16"></span><strong>Bounty0x BNTY</strong></a>
									</li>
									<li>
										<a href='/trade/BOT_ETH'><span class="icon-16-bot icon-16"></span><strong>菩提 BOT</strong></a>
									</li>
									<li>
										<a href='/trade/BTM_ETH'><span class="icon-16-btm icon-16"></span><strong>比原链 BTM</strong></a>
									</li>
									<li>
										<a href='/trade/BTO_ETH'><span class="icon-16-bto icon-16"></span><strong>铂链 BTO</strong></a>
									</li>
									<li>
										<a href='/trade/CDT_ETH'><span class="icon-16-cdt icon-16"></span><strong>CoinDash CDT</strong></a>
									</li>
									<li>
										<a href='/trade/COFI_ETH'><span class="icon-16-cofi icon-16"></span><strong>CoinFi COFI</strong></a>
									</li>
									<li>
										<a href='/trade/CS_ETH'><span class="icon-16-cs icon-16"></span><strong>Credits CS</strong></a>
									</li>
									<li>
										<a href='/trade/CTR_ETH'><span class="icon-16-ctr icon-16"></span><strong>Centra CTR</strong></a>
									</li>
									<li>
										<a href='/trade/CVC_ETH'><span class="icon-16-cvc icon-16"></span><strong>Civic CVC</strong></a>
									</li>
									<li>
										<a href='/trade/DADI_ETH'><span class="icon-16-dadi icon-16"></span><strong>DADI DADI</strong></a>
									</li>
									<li>
										<a href='/trade/DATA_ETH'><span class="icon-16-data icon-16"></span><strong>Streamr DATA</strong></a>
									</li>
									<li>
										<a href='/trade/DBC_ETH'><span class="icon-16-dbc icon-16"></span><strong>深脑链 DBC</strong></a>
									</li>
									<li>
										<a href='/trade/DDD_ETH'><span class="icon-16-ddd icon-16"></span><strong>Scry無域 DDD</strong></a>
									</li>
									<li>
										<a href='/trade/DGD_ETH'><span class="icon-16-dgd icon-16"></span><strong>DigixDAO DGD</strong></a>
									</li>
									<li>
										<a href='/trade/DNT_ETH'><span class="icon-16-dnt icon-16"></span><strong>district0x DNT</strong></a>
									</li>
									<li>
										<a href='/trade/DOCK_ETH'><span class="icon-16-dock icon-16"></span><strong>Dock DOCK</strong></a>
									</li>
									<li>
										<a href='/trade/DPY_ETH'><span class="icon-16-dpy icon-16"></span><strong>Delphy DPY</strong></a>
									</li>
									<li>
										<a href='/trade/DRGN_ETH'><span class="icon-16-drgn icon-16"></span><strong>DragonChain DRGN</strong></a>
									</li>
									<li>
										<a href='/trade/ELF_ETH'><span class="icon-16-elf icon-16"></span><strong>aelf ELF</strong></a>
									</li>
									<li>
										<a href='/trade/EOS_ETH'><span class="icon-16-eos icon-16"></span><strong>EOS EOS</strong></a>
									</li>
									<li>
										<a href='/trade/ETC_ETH'><span class="icon-16-etc icon-16"></span><strong>以太经典 ETC</strong></a>
									</li>
									<li>
										<a href='/trade/FUEL_ETH'><span class="icon-16-fuel icon-16"></span><strong>Etherparty FUEL</strong></a>
									</li>
									<li>
										<a href='/trade/FUN_ETH'><span class="icon-16-fun icon-16"></span><strong>FunFair FUN</strong></a>
									</li>
									<li>
										<a href='/trade/GEM_ETH'><span class="icon-16-gem icon-16"></span><strong>Gems GEM</strong></a>
									</li>
									<li>
										<a href='/trade/GNT_ETH'><span class="icon-16-gnt icon-16"></span><strong>Golem GNT</strong></a>
									</li>
									<li>
										<a href='/trade/GNX_ETH'><span class="icon-16-gnx icon-16"></span><strong>Genaro GNX</strong></a>
									</li>
									<li>
										<a href='/trade/GTC_ETH'><span class="icon-16-gtc icon-16"></span><strong>G币 GTC</strong></a>
									</li>
									<li>
										<a href='/trade/HSR_ETH'><span class="icon-16-hsr icon-16"></span><strong>HShare HSR</strong></a>
									</li>
									<li>
										<a href='/trade/ICX_ETH'><span class="icon-16-icx icon-16"></span><strong>ICON ICX</strong></a>
									</li>
									<li>
										<a href='/trade/IHT_ETH'><span class="icon-16-iht icon-16"></span><strong>云产币 IHT</strong></a>
									</li>
									<li>
										<a href='/trade/INK_ETH'><span class="icon-16-ink icon-16"></span><strong>Ink INK</strong></a>
									</li>
									<li>
										<a href='/trade/JNT_ETH'><span class="icon-16-jnt icon-16"></span><strong>JibrelNetwork JNT</strong></a>
									</li>
									<li>
										<a href='/trade/KICK_ETH'><span class="icon-16-kick icon-16"></span><strong>KickCoin KICK</strong></a>
									</li>
									<li>
										<a href='/trade/KNC_ETH'><span class="icon-16-knc icon-16"></span><strong>Kyber KNC</strong></a>
									</li>
									<li>
										<a href='/trade/LEDU_ETH'><span class="icon-16-ledu icon-16"></span><strong>Education LEDU</strong></a>
									</li>
									<li>
										<a href='/trade/LEND_ETH'><span class="icon-16-lend icon-16"></span><strong>ETHLend LEND</strong></a>
									</li>
									<li>
										<a href='/trade/LINK_ETH'><span class="icon-16-link icon-16"></span><strong>ChainLink LINK</strong></a>
									</li>
									<li>
										<a href='/trade/LLT_ETH'><span class="icon-16-llt icon-16"></span><strong>流量币 LLT</strong></a>
									</li>
									<li>
										<a href='/trade/LRC_ETH'><span class="icon-16-lrc icon-16"></span><strong>Loopring LRC</strong></a>
									</li>
									<li>
										<a href='/trade/LRN_ETH'><span class="icon-16-lrn icon-16"></span><strong>路印NEO LRN</strong></a>
									</li>
									<li>
										<a href='/trade/LUN_ETH'><span class="icon-16-lun icon-16"></span><strong>Lunyr LUN</strong></a>
									</li>
									<li>
										<a href='/trade/LYM_ETH'><span class="icon-16-lym icon-16"></span><strong>Lympo LYM</strong></a>
									</li>
									<li>
										<a href='/trade/MAN_ETH'><span class="icon-16-man icon-16"></span><strong>MatrixAI MAN</strong></a>
									</li>
									<li>
										<a href='/trade/MANA_ETH'><span class="icon-16-mana icon-16"></span><strong>Decentraland MANA</strong></a>
									</li>
									<li>
										<a href='/trade/MCO_ETH'><span class="icon-16-mco icon-16"></span><strong>Monaco MCO</strong></a>
									</li>
									<li>
										<a href='/trade/MDA_ETH'><span class="icon-16-mda icon-16"></span><strong>Moeda MDA</strong></a>
									</li>
									<li>
										<a href='/trade/MDS_ETH'><span class="icon-16-mds icon-16"></span><strong>MediShares MDS</strong></a>
									</li>
									<li>
										<a href='/trade/MDT_ETH'><span class="icon-16-mdt icon-16"></span><strong>量数币 MDT</strong></a>
									</li>
									<li>
										<a href='/trade/MED_ETH'><span class="icon-16-med icon-16"></span><strong>MediBloc MED</strong></a>
									</li>
									<li>
										<a href='/trade/MITH_ETH'><span class="icon-16-mith icon-16"></span><strong>秘银币 MITH</strong></a>
									</li>
									<li>
										<a href='/trade/MKR_ETH'><span class="icon-16-mkr icon-16"></span><strong>MakerDAO MKR</strong></a>
									</li>
									<li>
										<a href='/trade/MOBI_ETH'><span class="icon-16-mobi icon-16"></span><strong>Mobius MOBI</strong></a>
									</li>
									<li>
										<a href='/trade/MTN_ETH'><span class="icon-16-mtn icon-16"></span><strong>Medicalchain MTN</strong></a>
									</li>
									<li>
										<a href='/trade/NAS_ETH'><span class="icon-16-nas icon-16"></span><strong>星云链 NAS</strong></a>
									</li>
									<li>
										<a href='/trade/OAX_ETH'><span class="icon-16-oax icon-16"></span><strong>ANX OAX</strong></a>
									</li>
									<li>
										<a href='/trade/OCN_ETH'><span class="icon-16-ocn icon-16"></span><strong>OCOIN OCN</strong></a>
									</li>
									<li>
										<a href='/trade/OMG_ETH'><span class="icon-16-omg icon-16"></span><strong>OmiseGo OMG</strong></a>
									</li>
									<li>
										<a href='/trade/ONT_ETH'><span class="icon-16-ont icon-16"></span><strong>本体 ONT</strong></a>
									</li>
									<li>
										<a href='/trade/OST_ETH'><span class="icon-16-ost icon-16"></span><strong>SimpleToken OST</strong></a>
									</li>
									<li>
										<a href='/trade/PAY_ETH'><span class="icon-16-pay icon-16"></span><strong>TenX PAY</strong></a>
									</li>
									<li>
										<a href='/trade/POWR_ETH'><span class="icon-16-powr icon-16"></span><strong>PowerLedger POWR</strong></a>
									</li>
									<li>
										<a href='/trade/PST_ETH'><span class="icon-16-pst icon-16"></span><strong>Primas PST</strong></a>
									</li>
									<li>
										<a href='/trade/QASH_ETH'><span class="icon-16-qash icon-16"></span><strong>LIQUID QASH</strong></a>
									</li>
									<li>
										<a href='/trade/QBT_ETH'><span class="icon-16-qbt icon-16"></span><strong>Qbao QBT</strong></a>
									</li>
									<li>
										<a href='/trade/QLC_ETH'><span class="icon-16-qlc icon-16"></span><strong>QLINK QLC</strong></a>
									</li>
									<li>
										<a href='/trade/QSP_ETH'><span class="icon-16-qsp icon-16"></span><strong>Quantstamp QSP</strong></a>
									</li>
									<li>
										<a href='/trade/QTUM_ETH'><span class="icon-16-qtum icon-16"></span><strong>量子链 QTUM</strong></a>
									</li>
									<li>
										<a href='/trade/RCN_ETH'><span class="icon-16-rcn icon-16"></span><strong>Ripio RCN</strong></a>
									</li>
									<li>
										<a href='/trade/RDN_ETH'><span class="icon-16-rdn icon-16"></span><strong>雷电网络 RDN</strong></a>
									</li>
									<li>
										<a href='/trade/REP_ETH'><span class="icon-16-rep icon-16"></span><strong>Augur REP</strong></a>
									</li>
									<li>
										<a href='/trade/REQ_ETH'><span class="icon-16-req icon-16"></span><strong>Request REQ</strong></a>
									</li>
									<li>
										<a href='/trade/RFR_ETH'><span class="icon-16-rfr icon-16"></span><strong>Refereum RFR</strong></a>
									</li>
									<li>
										<a href='/trade/RLC_ETH'><span class="icon-16-rlc icon-16"></span><strong>iExec RLC</strong></a>
									</li>
									<li>
										<a href='/trade/RUFF_ETH'><span class="icon-16-ruff icon-16"></span><strong>RuffChain RUFF</strong></a>
									</li>
									<li>
										<a href='/trade/SALT_ETH'><span class="icon-16-salt icon-16"></span><strong>SALT  SALT</strong></a>
									</li>
									<li>
										<a href='/trade/SENC_ETH'><span class="icon-16-senc icon-16"></span><strong>Sentinel SENC</strong></a>
									</li>
									<li>
										<a href='/trade/SKM_ETH'><span class="icon-16-skm icon-16"></span><strong>Skrumble SKM</strong></a>
									</li>
									<li>
										<a href='/trade/SMT_ETH'><span class="icon-16-smt icon-16"></span><strong>SmartMesh SMT</strong></a>
									</li>
									<li>
										<a href='/trade/SNET_ETH'><span class="icon-16-snet icon-16"></span><strong>Snetwork SNET</strong></a>
									</li>
									<li>
										<a href='/trade/SNT_ETH'><span class="icon-16-snt icon-16"></span><strong>Status SNT</strong></a>
									</li>
									<li>
										<a href='/trade/STORJ_ETH'><span class="icon-16-storj icon-16"></span><strong>Storj STORJ</strong></a>
									</li>
									<li>
										<a href='/trade/STX_ETH'><span class="icon-16-stx icon-16"></span><strong>Stox STX</strong></a>
									</li>
									<li>
										<a href='/trade/SWTH_ETH'><span class="icon-16-swth icon-16"></span><strong>Switcheo SWTH</strong></a>
									</li>
									<li>
										<a href='/trade/THETA_ETH'><span class="icon-16-theta icon-16"></span><strong>Theta THETA</strong></a>
									</li>
									<li>
										<a href='/trade/TIO_ETH'><span class="icon-16-tio icon-16"></span><strong>trade.io TIO</strong></a>
									</li>
									<li>
										<a href='/trade/TIPS_ETH'><span class="icon-16-tips icon-16"></span><strong>帽子币 TIPS</strong></a>
									</li>
									<li>
										<a href='/trade/TNC_ETH'><span class="icon-16-tnc icon-16"></span><strong>Trinity TNC</strong></a>
									</li>
									<li>
										<a href='/trade/TNT_ETH'><span class="icon-16-tnt icon-16"></span><strong>Tierion  TNT</strong></a>
									</li>
									<li>
										<a href='/trade/TRX_ETH'><span class="icon-16-trx icon-16"></span><strong>波场 TRX</strong></a>
									</li>
									<li>
										<a href='/trade/VEN_ETH'><span class="icon-16-ven icon-16"></span><strong>唯链 VEN</strong></a>
									</li>
									<li>
										<a href='/trade/WINGS_ETH'><span class="icon-16-wings icon-16"></span><strong>Wings WINGS</strong></a>
									</li>
									<li>
										<a href='/trade/XLM_ETH'><span class="icon-16-xlm icon-16"></span><strong>恒星币 XLM</strong></a>
									</li>
									<li>
										<a href='/trade/ZIL_ETH'><span class="icon-16-zil icon-16"></span><strong>Zilliqa ZIL</strong></a>
									</li>
									<li>
										<a href='/trade/ZPT_ETH'><span class="icon-16-zpt icon-16"></span><strong>Zeepin ZPT</strong></a>
									</li>
									<li>
										<a href='/trade/ZRX_ETH'><span class="icon-16-zrx icon-16"></span><strong>0x项目 ZRX</strong></a>
									</li>
									<li>
										<a href='/trade/ZSC_ETH'><span class="icon-16-zsc icon-16"></span><strong>宙斯盾 ZSC</strong></a>
									</li>
								</ul>
							</li>
							<li>
								<a href="javascript:;">对USDT交易区<i class="caret"></i></a>
								<ul class="third-nav clearfix">
									<li>
										<a href='/trade/ABT_USDT'><span class="icon-16-abt icon-16"></span><strong>ArcBlock ABT</strong></a>
									</li>
									<li>
										<a href='/trade/ADA_USDT'><span class="icon-16-ada icon-16"></span><strong>艾达币 ADA</strong></a>
									</li>
									<li>
										<a href='/trade/AE_USDT'><span class="icon-16-ae icon-16"></span><strong>Aeternity AE</strong></a>
									</li>
									<li>
										<a href='/trade/BAT_USDT'><span class="icon-16-bat icon-16"></span><strong>注意力币 BAT</strong></a>
									</li>
									<li>
										<a href='/trade/BCD_USDT'><span class="icon-16-bcd icon-16"></span><strong>比特币钻石 BCD</strong></a>
									</li>
									<li>
										<a href='/trade/BCDN_USDT'><span class="icon-16-bcdn icon-16"></span><strong>BlockCDN BCDN</strong></a>
									</li>
									<li>
										<a href='/trade/BCH_USDT'><span class="icon-16-bch icon-16"></span><strong>BCH(原BCC) BCH</strong></a>
									</li>
									<li>
										<a href='/trade/BCX_USDT'><span class="icon-16-bcx icon-16"></span><strong>比特无限 BCX</strong></a>
									</li>
									<li>
										<a href='/trade/BFT_USDT'><span class="icon-16-bft icon-16"></span><strong>BFToken BFT</strong></a>
									</li>
									<li>
										<a href='/trade/BIFI_USDT'><span class="icon-16-bifi icon-16"></span><strong>BitcoinFile BIFI</strong></a>
									</li>
									<li>
										<a href='/trade/BLZ_USDT'><span class="icon-16-blz icon-16"></span><strong>Bluzelle BLZ</strong></a>
									</li>
									<li>
										<a href='/trade/BNTY_USDT'><span class="icon-16-bnty icon-16"></span><strong>Bounty0x BNTY</strong></a>
									</li>
									<li>
										<a href='/trade/BOT_USDT'><span class="icon-16-bot icon-16"></span><strong>菩提 BOT</strong></a>
									</li>
									<li>
										<a href='/trade/BTC_USDT'><span class="icon-16-btc icon-16"></span><strong>比特币 BTC</strong></a>
									</li>
									<li>
										<a href='/trade/BTF_USDT'><span class="icon-16-btf icon-16"></span><strong>比特信仰 BTF</strong></a>
									</li>
									<li>
										<a href='/trade/BTG_USDT'><span class="icon-16-btg icon-16"></span><strong>BTG BTG</strong></a>
									</li>
									<li>
										<a href='/trade/BTM_USDT'><span class="icon-16-btm icon-16"></span><strong>比原链 BTM</strong></a>
									</li>
									<li>
										<a href='/trade/BTO_USDT'><span class="icon-16-bto icon-16"></span><strong>铂链 BTO</strong></a>
									</li>
									<li>
										<a href='/trade/BTS_USDT'><span class="icon-16-bts icon-16"></span><strong>比特股 BTS</strong></a>
									</li>
									<li>
										<a href='/trade/CDT_USDT'><span class="icon-16-cdt icon-16"></span><strong>CoinDash CDT</strong></a>
									</li>
									<li>
										<a href='/trade/COFI_USDT'><span class="icon-16-cofi icon-16"></span><strong>CoinFi COFI</strong></a>
									</li>
									<li>
										<a href='/trade/CS_USDT'><span class="icon-16-cs icon-16"></span><strong>Credits CS</strong></a>
									</li>
									<li>
										<a href='/trade/CVC_USDT'><span class="icon-16-cvc icon-16"></span><strong>Civic CVC</strong></a>
									</li>
									<li>
										<a href='/trade/DADI_USDT'><span class="icon-16-dadi icon-16"></span><strong>DADI DADI</strong></a>
									</li>
									<li>
										<a href='/trade/DAI_USDT'><span class="icon-16-dai icon-16"></span><strong>Dai DAI</strong></a>
									</li>
									<li>
										<a href='/trade/DASH_USDT'><span class="icon-16-dash icon-16"></span><strong>达世币 DASH</strong></a>
									</li>
									<li>
										<a href='/trade/DATA_USDT'><span class="icon-16-data icon-16"></span><strong>Streamr DATA</strong></a>
									</li>
									<li>
										<a href='/trade/DBC_USDT'><span class="icon-16-dbc icon-16"></span><strong>深脑链 DBC</strong></a>
									</li>
									<li>
										<a href='/trade/DDD_USDT'><span class="icon-16-ddd icon-16"></span><strong>Scry無域 DDD</strong></a>
									</li>
									<li>
										<a href='/trade/DGD_USDT'><span class="icon-16-dgd icon-16"></span><strong>DigixDAO DGD</strong></a>
									</li>
									<li>
										<a href='/trade/DOCK_USDT'><span class="icon-16-dock icon-16"></span><strong>Dock DOCK</strong></a>
									</li>
									<li>
										<a href='/trade/DOGE_USDT'><span class="icon-16-doge icon-16"></span><strong>狗狗币 DOGE</strong></a>
									</li>
									<li>
										<a href='/trade/DPY_USDT'><span class="icon-16-dpy icon-16"></span><strong>Delphy DPY</strong></a>
									</li>
									<li>
										<a href='/trade/DRGN_USDT'><span class="icon-16-drgn icon-16"></span><strong>DragonChain DRGN</strong></a>
									</li>
									<li>
										<a href='/trade/ELF_USDT'><span class="icon-16-elf icon-16"></span><strong>aelf ELF</strong></a>
									</li>
									<li>
										<a href='/trade/EOS_USDT'><span class="icon-16-eos icon-16"></span><strong>EOS EOS</strong></a>
									</li>
									<li>
										<a href='/trade/ETC_USDT'><span class="icon-16-etc icon-16"></span><strong>以太经典 ETC</strong></a>
									</li>
									<li>
										<a href='/trade/ETH_USDT'><span class="icon-16-eth icon-16"></span><strong>以太币 ETH</strong></a>
									</li>
									<li>
										<a href='/trade/FIL_USDT'><span class="icon-16-fil icon-16"></span><strong>IPFS六月 FIL</strong></a>
									</li>
									<li>
										<a href='/trade/FUEL_USDT'><span class="icon-16-fuel icon-16"></span><strong>Etherparty FUEL</strong></a>
									</li>
									<li>
										<a href='/trade/FUN_USDT'><span class="icon-16-fun icon-16"></span><strong>FunFair FUN</strong></a>
									</li>
									<li>
										<a href='/trade/GAS_USDT'><span class="icon-16-gas icon-16"></span><strong>小蚁Gas GAS</strong></a>
									</li>
									<li>
										<a href='/trade/GEM_USDT'><span class="icon-16-gem icon-16"></span><strong>Gems GEM</strong></a>
									</li>
									<li>
										<a href='/trade/GNT_USDT'><span class="icon-16-gnt icon-16"></span><strong>Golem GNT</strong></a>
									</li>
									<li>
										<a href='/trade/GNX_USDT'><span class="icon-16-gnx icon-16"></span><strong>Genaro GNX</strong></a>
									</li>
									<li>
										<a href='/trade/GOD_USDT'><span class="icon-16-god icon-16"></span><strong>比特币上帝 GOD</strong></a>
									</li>
									<li>
										<a href='/trade/GTC_USDT'><span class="icon-16-gtc icon-16"></span><strong>G币 GTC</strong></a>
									</li>
									<li>
										<a href='/trade/GXS_USDT'><span class="icon-16-gxs icon-16"></span><strong>公信宝 GXS</strong></a>
									</li>
									<li>
										<a href='/trade/HSR_USDT'><span class="icon-16-hsr icon-16"></span><strong>HShare HSR</strong></a>
									</li>
									<li>
										<a href='/trade/ICX_USDT'><span class="icon-16-icx icon-16"></span><strong>ICON ICX</strong></a>
									</li>
									<li>
										<a href='/trade/IHT_USDT'><span class="icon-16-iht icon-16"></span><strong>云产币 IHT</strong></a>
									</li>
									<li>
										<a href='/trade/INK_USDT'><span class="icon-16-ink icon-16"></span><strong>Ink INK</strong></a>
									</li>
									<li>
										<a href='/trade/IOTA_USDT'><span class="icon-16-iota icon-16"></span><strong>IOTA IOTA</strong></a>
									</li>
									<li>
										<a href='/trade/JNT_USDT'><span class="icon-16-jnt icon-16"></span><strong>JibrelNetwork JNT</strong></a>
									</li>
									<li>
										<a href='/trade/KICK_USDT'><span class="icon-16-kick icon-16"></span><strong>KickCoin KICK</strong></a>
									</li>
									<li>
										<a href='/trade/KNC_USDT'><span class="icon-16-knc icon-16"></span><strong>Kyber KNC</strong></a>
									</li>
									<li>
										<a href='/trade/LEND_USDT'><span class="icon-16-lend icon-16"></span><strong>ETHLend LEND</strong></a>
									</li>
									<li>
										<a href='/trade/LINK_USDT'><span class="icon-16-link icon-16"></span><strong>ChainLink LINK</strong></a>
									</li>
									<li>
										<a href='/trade/LRC_USDT'><span class="icon-16-lrc icon-16"></span><strong>Loopring LRC</strong></a>
									</li>
									<li>
										<a href='/trade/LRN_USDT'><span class="icon-16-lrn icon-16"></span><strong>路印NEO LRN</strong></a>
									</li>
									<li>
										<a href='/trade/LSK_USDT'><span class="icon-16-lsk icon-16"></span><strong>Lisk LSK</strong></a>
									</li>
									<li>
										<a href='/trade/LTC_USDT'><span class="icon-16-ltc icon-16"></span><strong>莱特币 LTC</strong></a>
									</li>
									<li>
										<a href='/trade/LUN_USDT'><span class="icon-16-lun icon-16"></span><strong>Lunyr LUN</strong></a>
									</li>
									<li>
										<a href='/trade/LYM_USDT'><span class="icon-16-lym icon-16"></span><strong>Lympo LYM</strong></a>
									</li>
									<li>
										<a href='/trade/MAN_USDT'><span class="icon-16-man icon-16"></span><strong>MatrixAI MAN</strong></a>
									</li>
									<li>
										<a href='/trade/MANA_USDT'><span class="icon-16-mana icon-16"></span><strong>Decentraland MANA</strong></a>
									</li>
									<li>
										<a href='/trade/MCO_USDT'><span class="icon-16-mco icon-16"></span><strong>Monaco MCO</strong></a>
									</li>
									<li>
										<a href='/trade/MDA_USDT'><span class="icon-16-mda icon-16"></span><strong>Moeda MDA</strong></a>
									</li>
									<li>
										<a href='/trade/MDS_USDT'><span class="icon-16-mds icon-16"></span><strong>MediShares MDS</strong></a>
									</li>
									<li>
										<a href='/trade/MDT_USDT'><span class="icon-16-mdt icon-16"></span><strong>量数币 MDT</strong></a>
									</li>
									<li>
										<a href='/trade/MED_USDT'><span class="icon-16-med icon-16"></span><strong>MediBloc MED</strong></a>
									</li>
									<li>
										<a href='/trade/MITH_USDT'><span class="icon-16-mith icon-16"></span><strong>秘银币 MITH</strong></a>
									</li>
									<li>
										<a href='/trade/MKR_USDT'><span class="icon-16-mkr icon-16"></span><strong>MakerDAO MKR</strong></a>
									</li>
									<li>
										<a href='/trade/MOBI_USDT'><span class="icon-16-mobi icon-16"></span><strong>Mobius MOBI</strong></a>
									</li>
									<li>
										<a href='/trade/MTN_USDT'><span class="icon-16-mtn icon-16"></span><strong>Medicalchain MTN</strong></a>
									</li>
									<li>
										<a href='/trade/NANO_USDT'><span class="icon-16-nano icon-16"></span><strong>Nano NANO</strong></a>
									</li>
									<li>
										<a href='/trade/NAS_USDT'><span class="icon-16-nas icon-16"></span><strong>星云链 NAS</strong></a>
									</li>
									<li>
										<a href='/trade/NEO_USDT'><span class="icon-16-neo icon-16"></span><strong>小蚁Neo NEO</strong></a>
									</li>
									<li>
										<a href='/trade/OCN_USDT'><span class="icon-16-ocn icon-16"></span><strong>OCOIN OCN</strong></a>
									</li>
									<li>
										<a href='/trade/OMG_USDT'><span class="icon-16-omg icon-16"></span><strong>OmiseGo OMG</strong></a>
									</li>
									<li>
										<a href='/trade/ONT_USDT'><span class="icon-16-ont icon-16"></span><strong>本体 ONT</strong></a>
									</li>
									<li>
										<a href='/trade/OST_USDT'><span class="icon-16-ost icon-16"></span><strong>SimpleToken OST</strong></a>
									</li>
									<li>
										<a href='/trade/PAY_USDT'><span class="icon-16-pay icon-16"></span><strong>TenX PAY</strong></a>
									</li>
									<li>
										<a href='/trade/POWR_USDT'><span class="icon-16-powr icon-16"></span><strong>PowerLedger POWR</strong></a>
									</li>
									<li>
										<a href='/trade/PST_USDT'><span class="icon-16-pst icon-16"></span><strong>Primas PST</strong></a>
									</li>
									<li>
										<a href='/trade/QASH_USDT'><span class="icon-16-qash icon-16"></span><strong>LIQUID QASH</strong></a>
									</li>
									<li>
										<a href='/trade/QBT_USDT'><span class="icon-16-qbt icon-16"></span><strong>Qbao QBT</strong></a>
									</li>
									<li>
										<a href='/trade/QLC_USDT'><span class="icon-16-qlc icon-16"></span><strong>QLINK QLC</strong></a>
									</li>
									<li>
										<a href='/trade/QSP_USDT'><span class="icon-16-qsp icon-16"></span><strong>Quantstamp QSP</strong></a>
									</li>
									<li>
										<a href='/trade/QTUM_USDT'><span class="icon-16-qtum icon-16"></span><strong>量子链 QTUM</strong></a>
									</li>
									<li>
										<a href='/trade/RCN_USDT'><span class="icon-16-rcn icon-16"></span><strong>Ripio RCN</strong></a>
									</li>
									<li>
										<a href='/trade/RDN_USDT'><span class="icon-16-rdn icon-16"></span><strong>雷电网络 RDN</strong></a>
									</li>
									<li>
										<a href='/trade/REQ_USDT'><span class="icon-16-req icon-16"></span><strong>Request REQ</strong></a>
									</li>
									<li>
										<a href='/trade/RFR_USDT'><span class="icon-16-rfr icon-16"></span><strong>Refereum RFR</strong></a>
									</li>
									<li>
										<a href='/trade/RLC_USDT'><span class="icon-16-rlc icon-16"></span><strong>iExec RLC</strong></a>
									</li>
									<li>
										<a href='/trade/RUFF_USDT'><span class="icon-16-ruff icon-16"></span><strong>RuffChain RUFF</strong></a>
									</li>
									<li>
										<a href='/trade/SALT_USDT'><span class="icon-16-salt icon-16"></span><strong>SALT  SALT</strong></a>
									</li>
									<li>
										<a href='/trade/SBTC_USDT'><span class="icon-16-sbtc icon-16"></span><strong>超级比特币 SBTC</strong></a>
									</li>
									<li>
										<a href='/trade/SENC_USDT'><span class="icon-16-senc icon-16"></span><strong>Sentinel SENC</strong></a>
									</li>
									<li>
										<a href='/trade/SKM_USDT'><span class="icon-16-skm icon-16"></span><strong>Skrumble SKM</strong></a>
									</li>
									<li>
										<a href='/trade/SMT_USDT'><span class="icon-16-smt icon-16"></span><strong>SmartMesh SMT</strong></a>
									</li>
									<li>
										<a href='/trade/SNET_USDT'><span class="icon-16-snet icon-16"></span><strong>Snetwork SNET</strong></a>
									</li>
									<li>
										<a href='/trade/SNT_USDT'><span class="icon-16-snt icon-16"></span><strong>Status SNT</strong></a>
									</li>
									<li>
										<a href='/trade/STORJ_USDT'><span class="icon-16-storj icon-16"></span><strong>Storj STORJ</strong></a>
									</li>
									<li>
										<a href='/trade/STX_USDT'><span class="icon-16-stx icon-16"></span><strong>Stox STX</strong></a>
									</li>
									<li>
										<a href='/trade/SWTH_USDT'><span class="icon-16-swth icon-16"></span><strong>Switcheo SWTH</strong></a>
									</li>
									<li>
										<a href='/trade/THETA_USDT'><span class="icon-16-theta icon-16"></span><strong>Theta THETA</strong></a>
									</li>
									<li>
										<a href='/trade/TIO_USDT'><span class="icon-16-tio icon-16"></span><strong>trade.io TIO</strong></a>
									</li>
									<li>
										<a href='/trade/TNC_USDT'><span class="icon-16-tnc icon-16"></span><strong>Trinity TNC</strong></a>
									</li>
									<li>
										<a href='/trade/TNT_USDT'><span class="icon-16-tnt icon-16"></span><strong>Tierion  TNT</strong></a>
									</li>
									<li>
										<a href='/trade/TRX_USDT'><span class="icon-16-trx icon-16"></span><strong>波场 TRX</strong></a>
									</li>
									<li>
										<a href='/trade/TSL_USDT'><span class="icon-16-tsl icon-16"></span><strong>Energo TSL</strong></a>
									</li>
									<li>
										<a href='/trade/VEN_USDT'><span class="icon-16-ven icon-16"></span><strong>唯链 VEN</strong></a>
									</li>
									<li>
										<a href='/trade/WAVES_USDT'><span class="icon-16-waves icon-16"></span><strong>波币 WAVES</strong></a>
									</li>
									<li>
										<a href='/trade/XLM_USDT'><span class="icon-16-xlm icon-16"></span><strong>恒星币 XLM</strong></a>
									</li>
									<li>
										<a href='/trade/XMC_USDT'><span class="icon-16-xmc icon-16"></span><strong>门罗原链 XMC</strong></a>
									</li>
									<li>
										<a href='/trade/XMR_USDT'><span class="icon-16-xmr icon-16"></span><strong>门罗币 XMR</strong></a>
									</li>
									<li>
										<a href='/trade/XRP_USDT'><span class="icon-16-xrp icon-16"></span><strong>瑞波币 XRP</strong></a>
									</li>
									<li>
										<a href='/trade/XTZ_USDT'><span class="icon-16-xtz icon-16"></span><strong>Tezos期 XTZ</strong></a>
									</li>
									<li>
										<a href='/trade/XVG_USDT'><span class="icon-16-xvg icon-16"></span><strong>Verge XVG</strong></a>
									</li>
									<li>
										<a href='/trade/ZEC_USDT'><span class="icon-16-zec icon-16"></span><strong>ZCash ZEC</strong></a>
									</li>
									<li>
										<a href='/trade/ZIL_USDT'><span class="icon-16-zil icon-16"></span><strong>Zilliqa ZIL</strong></a>
									</li>
									<li>
										<a href='/trade/ZPT_USDT'><span class="icon-16-zpt icon-16"></span><strong>Zeepin ZPT</strong></a>
									</li>
									<li>
										<a href='/trade/ZRX_USDT'><span class="icon-16-zrx icon-16"></span><strong>0x项目 ZRX</strong></a>
									</li>
									<li>
										<a href='/trade/ZSC_USDT'><span class="icon-16-zsc icon-16"></span><strong>宙斯盾 ZSC</strong></a>
									</li>
								</ul>
							</li>
							<li>
								<a href="javascript:;">对QTUM交易区<i class="caret"></i></a>
								<ul class="third-nav clearfix">
									<li>
										<a href='/trade/BOT_QTUM'><span class="icon-16-bot icon-16"></span><strong>菩提 BOT</strong></a>
									</li>
									<li>
										<a href='/trade/INK_QTUM'><span class="icon-16-ink icon-16"></span><strong>Ink INK</strong></a>
									</li>
									<li>
										<a href='/trade/LLT_SNET'><span class="icon-16-llt icon-16"></span><strong>流量币 LLT</strong></a>
									</li>
									<li>
										<a href='/trade/MED_QTUM'><span class="icon-16-med icon-16"></span><strong>MediBloc MED</strong></a>
									</li>
									<li>
										<a href='/trade/QBT_QTUM'><span class="icon-16-qbt icon-16"></span><strong>Qbao QBT</strong></a>
									</li>
									<li>
										<a href='/trade/TSL_QTUM'><span class="icon-16-tsl icon-16"></span><strong>Energo TSL</strong></a>
									</li>
								</ul>
							</li>
							<li>
								<a href="javascript:;">限时交易区<i class="caret"></i></a>
								<ul class="third-nav clearfix">
									<li>
										<a href='/trade/ELEC_ETH'><span class="icon-16-elec icon-16"></span><strong>ElectrifyAsia ELEC</strong></a>
									</li>
									<li>
										<a href='/trade/HAV_ETH'><span class="icon-16-hav icon-16"></span><strong>Havven HAV</strong></a>
									</li>
									<li>
										<a href='/trade/HUR_ETH'><span class="icon-16-hur icon-16"></span><strong>Hurify HUR</strong></a>
									</li>
									<li>
										<a href='/trade/INSTAR_ETH'><span class="icon-16-instar icon-16"></span><strong>InsightsNetwork INSTAR</strong></a>
									</li>
									<li>
										<a href='/trade/LST_ETH'><span class="icon-16-lst icon-16"></span><strong>Lendroid LST</strong></a>
									</li>
									<li>
										<a href='/trade/REM_ETH'><span class="icon-16-rem icon-16"></span><strong>Remme REM</strong></a>
									</li>
									<li>
										<a href='/trade/SHIP_ETH'><span class="icon-16-ship icon-16"></span><strong>ShipChain SHIP</strong></a>
									</li>
									<li>
										<a href='/trade/TFD_ETH'><span class="icon-16-tfd icon-16"></span><strong>TE-Food TFD</strong></a>
									</li>
									<li>
										<a href='/trade/TOMO_ETH'><span class="icon-16-tomo icon-16"></span><strong>TomoChain TOMO</strong></a>
									</li>
								</ul>
							</li>
						</ul>
					</li>

					<li class="">
						<a href="/myaccount">我的财务</a>

					</li>

					<li class="">
						<a href="/myaccount/totp">安全设置</a>

					</li>
					<li class="">
						<a href="/articlelist/ann">公告</a>

					</li>
					<li class="">
						<a href="/listing">上币申请</a>

					</li>
					<li class="">
						<a href="javascript:;">帮助<i class="caret"></i></a>
						<ul class="second-nav clearfix">
							<li>
								<a href="/help">问题中心</a>
							</li>
							<li>
								<a href="javascript:ticketsRoute();">提交工单</a>
							</li>
							<li>
								<a href="/coins">资料下载<i class="caret"></i></a>
								<ul class="third-nav nav-help clearfix">
									<li>
										<a href="/mobileapp">手机APP</a>
									</li>
									<li>
										<a href="https://github.com/gateio/windows_app/releases/download/v1.0.3/Gateio_Setup.7z?v=101" target="_blank">Windows APP</a>
									</li>
									<li>
										<a href="https://github.com/gateio/mac_app/releases/download/v1.0.2/Gate.io.dmg?v=101" target="_blank">Mac APP</a>
									</li>
									<li>
										<a href="/coins">币种资料</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
				</ul>

				<div id="top_last_rate" style="display: none"></div>

			</div>
		</div>
		
		

		<!--<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">-->
		<style>
			html,
			body {
				height: 100%
			}
			
			*:before,
			*:after,
			.form-control {
				-webkit-box-sizing: border-box;
				-moz-box-sizing: border-box;
				box-sizing: border-box;
			}
			
			.glyphicon-ok:before {
				content: "\221A";
			}
			
			.leftregi form,
			.rightlogin form {
				width: 100%;
				text-align: left
			}
			
			.rightlogin {
				display: flex;
				align-items: center;
			}
			
			label {
				float: left;
				width: 30%;
				font-weight: bold;
				text-align: right;
				padding: 15px 15px 0 0;
				-webkit-box-sizing: border-box;
				-moz-box-sizing: border-box;
				box-sizing: border-box;
			}
			
			.btn-block.sub-btn {
				width: 40%;
				margin: 10px auto
			}
			
			.btn-block.sub-btn:focus {
				background: #f60 !important;
			}
			
			p.red {
				margin: 20px 0;
				text-align: center
			}
			
			.form-group .red,
			p.red {
				font-size: 13px
			}
			
			.r-tip {
				font-size: 13px;
				font-weight: normal;
				vertical-align: middle;
				height: 48px;
				display: table-cell;
				padding-left: 5px;
			}
			
			.code-box {
				position: relative;
				width: 70%;
				float: left;
			}
			
			.code-box .help-block {
				margin-left: 0;
				padding-top: 5px;
			}
			
			#code,
			#codeReg {
				position: absolute;
				left: 160px;
				top: -5px;
			}
			
			.checkbox {
				clear: both;
				margin-left: 30%;
			}
			
			.checkbox a {
				margin-bottom: 15px
			}
			
			#agrCheckLabel {
				width: auto;
				user-select: none;
				padding-top: 0
			}
			
			.m_title h4 {
				text-align: center;
				font-weight: normal;
				font-size: 24px
			}
			/*auto email*/
			
			.auto-tip {
				background: #fff;
				color: #2c3e50;
				border: 2px solid #dce4ec;
				border-top: none;
				border-radius: 4px;
				z-index: 10000;
				text-align: left
			}
			
			.auto-tip li {
				width: 100%;
				height: 28px;
				line-height: 28px;
				padding: 0 15px;
				font-size: 14px;
			}
			
			.auto-tip li.hoverBg {
				background: #ecf0f1;
				cursor: pointer;
			}
			
			.auto-tip em {
				font-style: normal
			}
			
			#signupForm .auto-tip {
				top: 71px !important
			}
			
			.completer-container,
			.pla {
				position: absolute;
				-webkit-box-sizing: border-box;
				-moz-box-sizing: border-box;
				box-sizing: border-box;
				padding: 0;
				margin: 0;
				font-family: inherit;
				font-size: 14px;
				line-height: normal;
				list-style: none;
				background-color: #fff;
				border: 1px solid #eee;
				border-radius: 3px;
			}
			
			.completer-container li,
			.pla li {
				padding: .5em .8em;
				margin: 0;
				overflow: hidden;
				text-overflow: ellipsis;
				white-space: nowrap;
				cursor: pointer;
				background-color: #fff;
				border-bottom: 1px solid #eee;
			}
			
			.completer-container .completer-selected,
			.completer-container li:hover,
			.pla .completer-selected {
				margin-left: -1px;
				background-color: #eee;
				border-left: 1px solid #ff5e23;
			}
			/*bootstrap*/
			
			.has-feedback {
				position: relative;
				clear: both
			}
			
			.has-feedback .form-control {
				float: left;
				width: 40%;
				padding-right: 42.5px;
				font-size: 15px;
				margin-bottom: 0;
			}
			
			.form-control-feedback {
				position: absolute;
				top: 0;
				right: 30%;
				z-index: 2;
				display: block;
				width: 34px;
				height: 34px;
				line-height: 34px;
				text-align: center;
				pointer-events: none
			}
			
			.has-success .help-block,
			.has-success .control-label,
			.has-success .radio,
			.has-success .checkbox,
			.has-success .radio-inline,
			.has-success .checkbox-inline,
			.has-success.radio label,
			.has-success.checkbox label,
			.has-success.radio-inline label,
			.has-success.checkbox-inline label {
				color: #3c763d
			}
			
			.has-success .form-control {
				border-color: #3c763d !important;
			}
			
			.has-success .form-control:focus {
				border-color: #2b542c;
			}
			
			.has-success .input-group-addon {
				color: #3c763d;
				border-color: #3c763d;
				background-color: #dff0d8
			}
			
			.has-success .form-control-feedback {
				color: #0da77d;
				font-size: 18px;
				font-weight: bold;
			}
			
			.has-error .help-block,
			.has-error .control-label,
			.has-error .radio,
			.has-error .checkbox,
			.has-error .radio-inline,
			.has-error .checkbox-inline,
			.has-error.radio label,
			.has-error.checkbox label,
			.has-error.radio-inline label,
			.has-error.checkbox-inline label {
				color: #a94442
			}
			
			.has-error .form-control {
				border-color: #a94442 !important;
			}
			
			.has-error .form-control:focus {
				border-color: #843534;
			}
			
			.has-error .input-group-addon {
				color: #a94442;
				border-color: #a94442;
				background-color: #f2dede
			}
			
			.has-error .form-control-feedback {
				color: #a94442
			}
			
			.has-feedback label~.form-control-feedback {
				top: 8px
			}
			
			.has-feedback label.sr-only~.form-control-feedback {
				top: 0
			}
			
			.help-block {
				display: block;
				clear: both;
				width: 40%;
				margin-left: 30%;
				margin-top: 5px;
				margin-bottom: 10px;
				color: #737373
			}
			
			.has-feedback .form-control.code-input {
				width: 152px
			}
			
			#codeGroup .form-control-feedback {
				left: 114px;
				top: 8px
			}
			/*loading*/
			
			.spinner {
				display: none;
				margin: 0 auto;
				width: 50px;
				text-align: center;
			}
			
			.spinner>div {
				width: 10px;
				height: 10px;
				background-color: #ffad69;
				border-radius: 100%;
				display: inline-block;
				-webkit-animation: bouncedelay 1.4s infinite ease-in-out;
				animation: bouncedelay 1.4s infinite ease-in-out;
				-webkit-animation-fill-mode: both;
				animation-fill-mode: both;
			}
			
			.spinner .bounce1 {
				-webkit-animation-delay: -0.32s;
				animation-delay: -0.32s;
			}
			
			.spinner .bounce2 {
				-webkit-animation-delay: -0.16s;
				animation-delay: -0.16s;
			}
			
			@-webkit-keyframes bouncedelay {
				0%,
				80%,
				100% {
					-webkit-transform: scale(0.0)
				}
				40% {
					-webkit-transform: scale(1.0)
				}
			}
			
			@keyframes bouncedelay {
				0%,
				80%,
				100% {
					transform: scale(0.0);
					-webkit-transform: scale(0.0);
				}
				40% {
					transform: scale(1.0);
					-webkit-transform: scale(1.0);
				}
			}
			
			.form-control-feedback {
				margin-right: 0;
				display: none
			}
			
			.has-success .form-control-feedback {
				display: block
			}
			
			.has-feedback #captcha_code {
				padding-right: 40px;
			}
			
			#loginSub:focus {
				background-color: #18bc9c;
				border-color: #18bc9c;
			}
			
			legend {
				text-align: center;
				color: #fff
			}
			/*注册*/
			
			.password-level {
				clear: both;
				width: 40%;
				margin: 0 auto;
			}
			
			.password-level .col-md-11 {
				padding-left: 0
			}
			
			.password-level .col-md-4 {
				width: 33.33%;
				float: left;
			}
			
			.password-level span {
				display: block;
				width: 100%;
				height: 3px;
				text-align: center;
				line-height: 0;
				font-size: 14px;
				font-weight: bold
			}
			
			#signPswLevel.password-level span,
			#fundPswLevel.password-level span {
				height: 16px;
				line-height: 16px;
				font-size: 12px;
				font-weight: bold
			}
			
			.discount {
				color: #ff5e23;
				margin: 10px 0 18px;
				font-weight: bold;
			}
			
			#signupSub {
				margin: 0 auto
			}
			
			.input-item-info {
				width: 30%;
				float: left
			}
			
			.code-box .form-control-feedback {
				right: auto;
				left: 114px;
				top: 8px;
			}
		</style>
		<script src="js/autoemail.js"></script>

		<div class="left_con_login">
			<div class="login_incontent login-con">

				<div class="right_mcontent clearfix">
					<div class="maichu">
						<div class="m_title">
							<h4>登录</h4></div>
						<div class="m_con rightlogin">
							<form role="form" id="loginForm" name="login" method="post" action="https://gateio.io/login">

								<div class="form-group parentCls has-feedback" id="emailGroup">
									<label for="email">用户名/邮箱</label>
									<div class="automail-list"></div>
									<input type="text" class="form-control inputElem" name="email" id="email" value="">
									<span class="glyphicon glyphicon-ok form-control-feedback"></span>
									<span class="help-block"></span>
								</div>

								<div class="form-group has-feedback" id="pswGroup">
									<label for="password">登录密码</label>
									<input type="password" class="form-control" name="password" id="password" autocomplete="new-password">
									<div class="input-item-info">
										<a href="/resetpw" style="line-height: 48px;margin-left: 5px;">忘记密码？</a>
									</div>
									<span class="help-block"></span>
								</div>
								<div class="form-group has-feedback clearfix" id="codeGroup">
									<label for="captcha_code">图片验证码</label>
									<div class="clearfix code-box">
										<input type="text" class="form-control code-input" name="captcha" id="captcha_code" maxlength="8" autocomplete="off">
										<div id="code"><img class="cap-img" id="loginCaptcha" src="${pageContext.request.contextPath}/ImageValidateServlet" alt="Captcha" title="看不清？换一张" onclick="document.getElementById('loginCaptcha').src = '${pageContext.request.contextPath}/ImageValidateServlet?' + Math.random(); return false" /></div>
										<span class="help-block"></span>
									</div>
								</div>

								<div class="form-group" id="ipGroup">
									<label for="iprestriction" style="user-select: none;">安全选项</label>
									<div class="pull-left" style="margin-top: 0px">
										<label class="haschecked pull-left" style="width: auto;user-select: none;">
							<input  class="form-control" type="checkbox" name="iprestriction" id="iprestriction" value='1' checked> 绑定到IP地址 <span class=red>（为保证账号安全如非动态IP切勿去选！）</span>
						</label>
									</div>
									<span class="help-block"></span>
								</div>

								<button type="button" class="btn btn-error btn-block sub-btn" id="loginSub"><span>登录</span>
						<div class="spinner">
							<div class="bounce1"></div>
							<div class="bounce2"></div>
							<div class="bounce3"></div>
						</div>
					</button>
								<p class="red"><i id="dpIcon">!</i>提醒：谨防骗子，切勿泄露密码给任何人，官方从不会向用户询问密码。</p>
								<span class="errmsg" id='errmsg'></span>
							</form>
						</div>
						<!-- login -->
					</div>

					<div class="mairu">
						<div class="m_title">
							<h4>注册</h4></div>
						<div class="m_con_buy leftregi">
							<form role="form" id="signupForm" name="signup" method="post" action="https://gateio.io/signup">
								<input type="hidden" name="ref_uid" id="ref_uid" value="" />
								<input type="hidden" name="language" id="language" value="cn" />
								<div>
									<div class="form-group parentCls has-feedback" id="signup_userNameGroup">
										<label for="sig_email">用户名</label>
										<input type="text" class="form-control" name="nickname" id="sig_userName" value="" autocomplete="off">
										<div class="input-item-info"><span class="r-tip">(字母或字母与数字组合)</span></div>
										</span><span class="glyphicon glyphicon-ok form-control-feedback"></span> <span class="help-block"></span>
									</div>
								</div>
								<div>
									<div class="form-group has-feedback" id="signup_pswGroup">
										<label for="sig_password">登录密码</label>
										<input type="password" name="password" class="form-control" id="sig_password" autocomplete="new-password">
										<div class="input-item-info"><span class="r-tip">(至少6位字符，非纯数字)</span></div><span class="glyphicon glyphicon-ok form-control-feedback"></span>
										<div class="password-level hide clearfix" id="signPswLevel">
											<div class="col-md-4"><span id="loWeak">弱</span></div>
											<div class="col-md-4"><span id="loNormal">中</span></div>
											<div class="col-md-4"><span id="loStrong">强</span></div>
										</div>
										<span class="help-block"></span>
									</div>
								</div>
								<div>
									<div class="form-group has-feedback" id="signup_repswGroup">
										<label for="sig_password">确认登录密码</label>
										<input type="password" name="repassword" class="form-control" id="sig_repassword" autocomplete="new-password">
										<span class="glyphicon glyphicon-ok form-control-feedback"></span>
										<span class="help-block"></span>
									</div>
								</div>
								<div>
									<div class="form-group parentCls has-feedback" id="signup_emailGroup">
										<label for="sig_email">邮箱</label>
										<input type="eamil" class="form-control" name="email" id="sig_email" value="" autocomplete="off">
										<div class="input-item-info"><span class="r-tip">(邮箱用于验证，请填写您的常用邮箱)</span></div>
										</span><span class="glyphicon glyphicon-ok form-control-feedback"></span> <span class="help-block"></span>
									</div>
								</div>
								<div>
									<div class="form-group has-feedback" id="fund_pswGroup">
										<label for="fund_password">资金密码</label>
										<input type="password" name="fundpass" class="form-control" id="fund_password" autocomplete="new-password">
										<div class="input-item-info"><span class="r-tip">(用于提现，请牢记。不可与登录密码相同)</span></div><span class="glyphicon glyphicon-ok form-control-feedback"></span>
										<span class="help-block"></span>
									</div>
								</div>
								<div>
									<div class="form-group has-feedback" id="fund_repswGroup">
										<label for="fund_password">确认资金密码</label>
										<input type="password" name="refundpass" class="form-control" id="fund_repassword" autocomplete="new-password">
										<span class="glyphicon glyphicon-ok form-control-feedback"></span>
										<span class="help-block"></span>
									</div>
								</div>
								<div class="form-group has-feedback" id="signup_codeGroup">
									<label for="captcha_code">图片验证码</label>
									<div class="clearfix code-box">
										<input type="text" class="form-control code-input" name="captcha" id="captcha_reg" maxlength="8" autocomplete="off">
										<div id="codeReg"><img class="cap-img" id="regCaptcha" src="${pageContext.request.contextPath}/ImageValidateServlet" alt="Captcha" title="看不清？换一张" onclick="resetCode();document.getElementById('regCaptcha').src = '${pageContext.request.contextPath}/ImageValidateServlet?' + Math.random(); return false" /></div>
										<div class="input-item-info"></div>
										<span class="help-block"></span>
									</div>
								</div>
								<div class="checkbox clearfix">
									<label id="agrCheckLabel" class="haschecked pull-left">
							<input  class="form-control pull-left" type="checkbox" name="agreeCheck" id="agreeCheck" value='1' checked>
							<span id="agrTxt" class="pull-left">我已阅读并同意</span>
						</label>
									<a class="pull-left" target=_blank href='/docs/agreement.pdf'>《用户使用协议》</a>
								</div>
								<button type="button" class="btn btn-error btn-block sub-btn" id="signupSub"><span>立即注册</span>
						<div class="spinner">
							<div class="bounce1"></div>
							<div class="bounce2"></div>
							<div class="bounce3"></div>
						</div>
					</button>
								<div class="login-tip">
									<p></p>
								</div>
							</form>
							<div style="clear:both"></div>
						</div>
						<!-- signup -->
					</div>

				</div>
			</div>

		</div>

		<script>
			function boxLayout() {
				var leftH = $(".leftregi").height();
				$(".rightlogin").css("height", leftH);
			}
			boxLayout();
			$(window).resize(function() {
				boxLayout()
			});

			//重置图片验证码
			function resetCode() {
				$("#captcha_code").val("");
				$("#codeGroup").removeClass("has-error").removeClass("has-success");
				$("#codeGroup").find(".help-block").text("");
			}

			function loadshow(targetDom) {
				targetDom.find("span").hide();
				targetDom.find(".spinner").show();
			}

			function loadhide(targetDom) {
				targetDom.find("span").show();
				targetDom.find(".spinner").hide();
			}
			//重置表单
			function resetForm(formID) {
				document.getElementById(formID).reset();
			}

			//自动邮箱
			var mailAddr = ["", "@qq.com", "@163.com", "@126.com", "@sina.com", "@gmail.com", "@hotmail.com", "@aliyun.com", "@sohu.com"],
				mailAddr1 = ["@qq.com", "@163.com", "@126.com", "@sina.com", "@gmail.com", "@hotmail.com", "@aliyun.com", "@sohu.com"];
			var mailTarget;

			function mailinput(mailTarget, mAddr) {
				mailTarget.on('input propertychange', function() {
					mailTarget.completer({
						separator: '',
						source: mAddr,
						zIndex: 1051
					}); //渲染启动自动邮箱
				});
				mailTarget.on("keyup", function(e) { //email input回车填第一个数据
					var theEvent = e || window.event;
					var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
					if(code == 13) {
						setTimeout(function() {
							mailTarget.parent().removeClass("has-error").addClass("has-success");
							mailTarget.parent().find(".help-block").text('');
						}, 100);
						mailTarget.parent().parent().next().find("input").focus()
					}
				});

				mailTarget.on("keydown", function(e) { //email input tab键
					var theEvent = e || window.event;
					var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
					if(code == 9) {
						$(".completer-container").hide();
					}
				});
			}

			function addErr(target) { //添加错误样式
				$(target).addClass("has-error").removeClass("has-success");
			}

			function addSucc(target) { //添加成功样式
				$(target).removeClass("has-error").addClass("has-success");
			}

			function printTip(target, tipText) { //输出表单提示
				$(target).find(".help-block").text(tipText);
				boxLayout();
			}

			$(function() {

				var mailVal = $("#sig_email").val(),
					mail_test = /^([a-zA-Z0-9\._-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
				if(!mail_test.test(mailVal)) {
					$("#sig_email").val("")
				}

				//login form focus
				$('#loginForm,#signupForm').find("input").focus(function() {
					$(this).next(".input-icon").addClass("focus-ico");
					$("#errmsg").text("");
					loadhide($("#loginSub"))
				}).blur(function() {
					$(this).next(".input-icon").removeClass("focus-ico");
				});

				//登录验证
				function emailcheck() {
					var eVal = $("#email").val();
					if(eVal == '') {
						addErr("#emailGroup");
						printTip("#emailGroup", "请输入您的用户名或邮箱！");
						loadhide($("#loginSub"))
					} else {
						addSucc("#emailGroup");
						printTip("#emailGroup", "");
						loadhide($("#loginSub"));
						return true;
					}
				}

				function pswcheck() {
					//return true;
					var eVal = $("#password").val(),
						eVlength = eVal.length;

					if(eVlength == 0) { //密码为空
						addErr("#pswGroup");
						printTip("#pswGroup", "请输入您的登录密码！");
						loadhide($("#loginSub"));
						$("#loginPswLevel").addClass("hide");
					} else {
						if(eVlength > 0 && eVlength < 6) { //大于0小于6位
							addErr("#pswGroup");
							printTip("#pswGroup", "登录密码不正确，请重新输入！");
						} else { //大于6位
							addSucc("#pswGroup");
							printTip("#pswGroup", "");
							return true;
						}
					}

				}

				function codecheck() {
					var eVal = $("#captcha_code").val(),
						vNum = eVal.length;
					if(eVal == '') {
						var codeShow = $("#codeGroup").is(":visible");
						if(codeShow) {
							addErr("#codeGroup");
							printTip("#codeGroup", "请输入图片验证码！");
						} else {
							$("#captcha_code").val("deflt")
						}
						loadhide($("#loginSub"))
					} else {
						if(vNum == 5) {
							addSucc("#codeGroup");
							printTip("#codeGroup", "");
							return true;
						} else {
							addErr("#codeGroup");
							printTip("#codeGroup", "图片验证码不正确，请重新输入！");
							loadhide($("#loginSub"))
						}

					}
				}

				$("#email").blur(emailcheck).focus(function() {
					//var mailTarget=$(this),mAddr=mailAddr;
					if(!(navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE8.0")) {
						//mailinput(mailTarget,mAddr);
					}
				});

				$("#password").blur(pswcheck).focus(function() {
					var mailVal = $("#email").val();
					if(mailVal != '') {
						emailcheck()
					}
				});

				$("#captcha_code").blur(codecheck);

				//登录
				$("#loginSub").click(function() { //点击提交按钮开始
					$(this).blur();
					loadshow($(this));
					if(emailcheck()) { //只填邮箱
						pswcheck();
						codecheck()
					}
					if(pswcheck()) { //只填密码
						emailcheck();
						codecheck()
					}
					if(codecheck()) { //只填验证码
						emailcheck();
						pswcheck()
					}
					if(pswcheck() && codecheck()) { //未填邮箱
						emailcheck()
					}
					if(emailcheck() && codecheck()) { //未填密码
						pswcheck()
					}
					if(emailcheck() && pswcheck()) { //未填验证码
						codecheck()
					}
					if(emailcheck() && pswcheck() && codecheck()) { //表单验证成功

						$("#loginForm").submit()
					} else { //表单验证失败
						emailcheck();
						pswcheck();
						codecheck();
					}
				}); //点击提交按钮结束

				$("#password,#captcha_code").on('focus', function() { //激活enter键
					eDom = $(this), tDom = $("#loginSub");
					pressEnter(eDom, tDom);
				});
				$("#checkRem").on('click', function() { //激活enter键
					eDom = $(this), tDom = $("#loginSub");
					pressEnter(eDom, tDom);
				});

			});

			function pressEnter(eDom, tDom) { //监听回车
				eDom.on('keyup', function(e) {
					var theEvent = e || window.event;
					var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
					if(code == 13) {
						tDom.click();
					}
				});
			}

			function passwordLevel(password) {
				var Modes = 0;
				for(i = 0; i < password.length; i++) {
					Modes |= CharMode(password.charCodeAt(i));
				}
				return bitTotal(Modes);
				//CharMode函数
				function CharMode(iN) {
					if(iN >= 48 && iN <= 57) //数字
					{
						return 1;
					}
					if(iN >= 65 && iN <= 90) //大写字母
					{
						return 2;
					}
					if((iN >= 97 && iN <= 122) || (iN >= 65 && iN <= 90)) //大小写
					{
						return 4;
					} else {
						return 8;
					} //特殊字符
				}

				//bitTotal函数
				function bitTotal(num) {
					modes = 0;
					for(i = 0; i < 4; i++) {
						if(num & 1) modes++;
						num >>>= 1;
					}
					return modes;
				}
			}

			$("#sig_password").focus(function() {
				$("#signPswLevel").removeClass("hide")
			});
			$("#fund_password").focus(function() {
				$("#fundPswLevel").removeClass("hide")
			});

			//注册表单验证
			function signUserNameCheck() { //用户名验证
				//return true;
				var nameVal = $("#sig_userName").val();
				if(nameVal == '') {
					addErr("#signup_userNameGroup");
					printTip("#signup_userNameGroup", "请创建一个用户名！");
					loadhide($("#signupSub"));
				} else if(nameVal.length < 3) {
					addErr("#signup_userNameGroup");
					printTip("#signup_userNameGroup", "用户名太短！");
					loadhide($("#loginSub"))
				} else if(nameVal.length > 24) {
					addErr("#signup_userNameGroup");
					printTip("#signup_userNameGroup", "用户名太长，请勿超过24字符！");
					loadhide($("#loginSub"))
				} else {
					if(isNaN(nameVal)) {
						addSucc("#signup_userNameGroup");
						printTip("#signup_userNameGroup", "");
						loadhide($("#loginSub"));
						return true;
					} else {
						addErr("#signup_userNameGroup");
						printTip("#signup_userNameGroup", "用户名不能使用纯数字！");
						loadhide($("#loginSub"))
					}

				}
			}

			function signEmailCheck() { //账邮箱验证
				//return true;
				var eVal = $("#sig_email").val();
				if(eVal == '') {
					addErr("#signup_emailGroup");
					printTip("#signup_emailGroup", "请输入您的常用邮箱！");
					loadhide($("#signupSub"));
				} else {
					var reg_mail = /^([a-zA-Z0-9\._-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
					if(reg_mail.test(eVal)) {
						addSucc("#signup_emailGroup");
						printTip("#signup_emailGroup", "");
						return true;
					} else {
						addErr("#signup_emailGroup");
						printTip("#signup_emailGroup", "邮箱格式不正确，请检查后重新输入！");
						loadhide($("#signupSub"))
					}
				}
			}
			//重置注册图片验证码
			function resetCode() {
				$("#captcha_reg").val("");
				$("#signup_codeGroup").removeClass("has-error").removeClass("has-success");
				printTip("#signup_codeGroup", "");
			}

			function signPswCheck() { //登录密码验证
				//return true;
				var sVal = $("#sig_password").val(),
					sVlength = sVal.length,
					signLvl = passwordLevel(sVal);

				if(sVlength == 0) { //登录密码为空
					addErr("#signup_pswGroup");
					printTip("#signup_pswGroup", "请输入一个登录密码！");
					loadhide($("#signupSub"));
					$("#signPswLevel").addClass("hide");
				} else {
					var tipWords = $("#signup_pswGroup").find(".help-block").text().length,
						checkOk = $("#signup_pswGroup").hasClass("has-success");
					if(sVlength > 0 && sVlength < 6) { //大于0小于6位
						printTip("#signup_pswGroup", "登录密码太简单！");
						addErr("#signup_pswGroup");
						if(tipWords == 26 || checkOk) {
							printTip("#signup_pswGroup", "登录密码需至少6位！");
						}
						$("#signPswLevel").removeClass("hide");
						$("#loWeak").css("background-color", "#ff4c50");
						$("#loNormal,#loStrong").css("background", "none");
					} else { //大于6位
						if(signLvl == 2) { //中
							addSucc("#signup_pswGroup");
							printTip("#signup_pswGroup", "");
							$("#loWeak,#loNormal").css("background-color", "#f90");
							$("#loStrong").css("background", "none");
							return true
						} else if(signLvl >= 3) {
							if(sVlength > 8) { //强
								addSucc("#signup_pswGroup");
								printTip("#signup_pswGroup", "");
								$("#loWeak,#loNormal,#loStrong").css("background-color", "#00c100");
								return true
							} else { //中
								addSucc("#signup_pswGroup");
								printTip("#signup_pswGroup", "");
								$("#loWeak,#loNormal").css("background-color", "#f90");
								$("#loStrong").css("background", "none");
								return true
							}
						} else {
							if(tipWords > 1 || checkOk) {
								addErr("#signup_pswGroup");
								printTip("#signup_pswGroup", "至少6位，且为数字、字母、符号的任意2种或以上组合！");
							}
							$("#loWeak").css("background-color", "#ff4c50");
							$("#loNormal,#loStrong").css("background", "none");
						}
					}
				}
			}

			function signRePswCheck() {
				if($("#sig_repassword").val() != $("#sig_password").val()) {
					addErr("#signup_repswGroup");
					printTip("#signup_repswGroup", "输入密码不一致！");
					return false;
				}
				addSucc("#signup_repswGroup");
				printTip("#signup_repswGroup", "");
				return true;
			}
			$("#sig_repassword").blur(function() {
				signRePswCheck();
			});

			function fundPswCheck() { //资金密码验证
				//return true;
				var sVal = $("#fund_password").val(),
					sVlength = sVal.length;
				if(sVlength == 0) { //密码为空
					addErr("#fund_pswGroup");
					printTip("#fund_pswGroup", "请输入一个资金密码！");
					loadhide($("#signupSub"));
				} else {
					//var tipWords=$("#fund_pswGroup").find(".help-block").text().length,
					var checkOk = $("#fund_pswGroup").hasClass("has-success");
					if(sVlength > 0 && sVlength < 6) { //大于0小于6位
						//if (tipWords==26 || checkOk){
						addErr("#fund_pswGroup");
						printTip("#fund_pswGroup", "资金密码需至少6位！");
						//}
					} else { //大于6位
						addSucc("#fund_pswGroup");
						printTip("#fund_pswGroup", "");
						return true
					}
				}
			}

			function fundRePswCheck() {
				if($("#fund_repassword").val() != $("#fund_password").val()) {
					addErr("#fund_repswGroup");
					printTip("#fund_repswGroup", "输入密码不一致！");
					return false;
				}
				addSucc("#fund_repswGroup");
				printTip("#fund_repswGroup", "");
				return true;
			}
			$("#fund_repassword").blur(function() {
				fundRePswCheck();
			});

			function signCodeCheck() { //图片验证码验证
				var eVal = $("#captcha_reg").val(),
					vNum = eVal.length;
				if(eVal == '') {
					addErr("#signup_codeGroup");
					printTip("#signup_codeGroup", "请输入图片验证码！");
					loadhide($("#signupSub"));
				} else {
					if(vNum == 5) {
						addSucc("#signup_codeGroup");
						printTip("#signup_codeGroup", "");
						return true;
					} else {
						addErr("#signup_codeGroup");
						printTip("#signup_codeGroup", "图片验证码错误！");
						loadhide($("#signupSub"));
					}

				}
			}

			function clearPsw(elm) {
				var psws = $(elm),
					sigPswLen = psws.val().length;
				if(sigPswLen == 32) {
					psws.val('');
					psws.parents("div").removeClass("has-success")
				}
			}
			$("#sig_email").blur(signEmailCheck).focus(function() {
				var mailTarget = $(this),
					mAddr = mailAddr1;
				if(!(navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE8.0")) {
					mailinput(mailTarget, mAddr);
				}
			});
			$("#sig_userName").blur(signUserNameCheck);

			$("#sig_password").blur(function() {
				signPswCheck();
			}).on('input propertychange', function() {
				signPswCheck()
			}).focus(function() {
				clearPsw("#sig_password")
			});
			$("#fund_password").blur(function() {
				fundPswCheck();
			}).on('input propertychange', function() {
				fundPswCheck()
			}).focus(function() {
				clearPsw("#fund_password")
			});
			$("#captcha_reg").blur(signCodeCheck);

			var agr = $("#agrCheckLabel"),
				signSub = $("#signupSub");
			agr.click(function() { //同意用户协议按钮
				if($("#agreeCheck").prop("checked")) {
					signSub.attr("disabled", false);
				} else {
					signSub.attr("disabled", true);
				}
			});

			$("#signupSub").click(function() {
				loadshow($(this));
				if(signUserNameCheck() && signPswCheck() && signRePswCheck() && signEmailCheck() &&
					fundPswCheck() && fundRePswCheck() && signCodeCheck()) { //验证成功提交
					$('#signupForm').submit();
				} else { //表单验证失败
					loadhide($(this));
				}
			});
		</script>

		<script>
			//force user to use https
			// if ('https:' != document.location.protocol) { window.location = 'https://' + window.location.hostname + window.location.pathname; }

			//for footer
			var tier_next_progress = '';

			$("#usdtAll").text(toThousands(0));
			$("#btcAll").text(toThousands(0));
			$("#ltcAll").text(toThousands(0));
			$("#ethAll").text(toThousands(0));
			is_login = '' != '';
		</script>
		<script src="js/footer.js?v=0420"></script>

	</body>

</html>