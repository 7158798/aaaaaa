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
		<div class="L_93">
			我的工单
		</div>
			<div id="L_84" class="L_84">
					您尚未实名认证！为保障您的资金安全，在完成实名认证之前，您将不能进行C2C交易，提币等操作。
					<a href="realNameAuth.html" style="display: inline-block;background: #fb9a00;color: #FFFFFF;">立即认证</a>
				</div>
		<div class="L_95">
			<div class="L_96">
				<div class="L_96_1">
					<p class="L_96_11">
						<span class="L_96_12"></span><span class="L_96_13" style="margin-right: 10px;"></span>历史工单记录<span class="L_96_13" style="margin-left: 10px;"></span><span class="L_96_12"></span>
					</p>
					<p class="L_96_14">
						<span>提交工单，客服会在这里给您回复，请耐心等待。</span>
						<a id="gdjlan" onclick="$('#gdjl').css('display','none');$('#cjwt').css('display','block');$('#cjwtan').removeClass('L_96_14_action');$('#gdjlan').addClass('L_96_14_action');">常见问答</a>
						<a id="cjwtan" class="L_96_14_action" style="margin-right: 34px;" onclick="$('#cjwt').css('display','none');$('#gdjl').css('display','block');$('#gdjlan').removeClass('L_96_14_action');$('#cjwtan').addClass('L_96_14_action');">工单记录</a>
					</p>
					<div id="gdjl">
						<div class="L_96_16">
							<a id="nextPage">下一页</a>
							<a id="prePage">上一页</a>
						</div>
						<input type="hidden" id="currentPage"/>
						<input type="hidden" id="pageCount"/>
					</div>
					<div id="cjwt">
						<p>1.如何修改/取消谷歌验证码？</p>
						<span>打开安全设置--谷歌验证器绑定，点击“取消或重置谷歌验证 ”通过资金密码和绑定手机的短信验证码可以重置谷歌验证；如果原谷歌验证码可以使用需要取消，根据上面的提示，输入谷歌验证码，点击取消即可。</span>
						<p>2.如何修改手机号码？</p>
						<span>如果手机已经安装安卓版APP，登录账户后在安全中心，自助解绑手机号码，重新绑定新手机号码。</span><br />
						<span>或提交工单，提供账户基本信息，本人手持身份证的照片等，我们帮您修改。</span>
						<p>3.如何修改资金密码？</p>
						<span>在安全设置中选择“修改资金密码”，根据提示输入账户绑定的邮箱和账户登录密码，查询邮件，根据提示重新设置资金密码即可。</span>
						<p>4.如何充值？</p>
						<span>在网站上方点击“我的财务”找到要充值的币种，点击“充值”查询充值地址，根据充值页面要求，转币到充值地址就可以。
如何是需要充值法币，在C2C场外交易区，先兑换成USDT再进行币币交易。</span>
						<p>5.如何提现？</p>
						<span>在网站上方点击“我的财务”找到要提币的币种，点击“提现”，直接进入提现页面，根据页面提示信息进行如实填写，填写完成后点击“提交提现申请”，完成提现操作。</span>
						<h6>注意：数字资产只能提现到该币种对应的钱包地址，务必核实清楚再进行提交，否则操作错误有可能导致资产损失。</h6>
						<p>6.充值不到账？</p>
						<span>请先查询区块记录，确认是否发送成功，充值地址是否有误。</span>
						<span>如果充值信息无误，区块已经确认发送成功没有到账，请提供账户ID，充值币种，数量，充值时间和交易ID我们进行查询。</span>
						<p>7.提现不到账？</p>
						<span>在提现记录下面有交易ID， 先查询区块记录确认是否发送成功。如果区块有记录没有到账，请复制提现记录联系接收方查询解决。</span>
						<span>对于区块没有记录的，请提交信息我们进行查询</span>
						<p>8.如何使用Gate.io充值码</p>
						<span>充值码是平台账户资金提现时选择充值码方式由特殊算法生成的代码，分为前后两段，中间以“-”隔开。可用于Gate.io平台账户之间资金互转。
操作充值码时：复制一条完整的充值码，在充值码提交链接：https://gateio.io/myaccount/deposit_gatecode 提交后立即到账。</span>
						<h6>注意：充值码分为前后两段，中间以“-”隔开，只提交前半段，可查询充值码面额，也可进一步锁定充值码，提交完整的充值码，可完成充值。
从其他人手中获取充值码时一定要验证是否有效。</h6>
					</div>
				</div>
			</div>
			<div class="L_97">
				<div class="L_96_1">
					<p class="L_96_11">
						<span class="L_96_12"></span><span class="L_96_13" style="margin-right: 10px;"></span>提交工单内容<span class="L_96_13" style="margin-left: 10px;"></span><span class="L_96_12"></span>
						
					</p>
					<p id="problemType" class="L_96_14">
						<span>请严格按照分类提交问题</span>
						<a onclick="changeStyle(this);">其他</a>
						<a onclick="changeStyle(this);">仲裁</a>
						<a onclick="changeStyle(this);">申诉</a>
						<a onclick="changeStyle(this);">提现</a>
						<a onclick="changeStyle(this);" class="L_96_14_action">充值</a>
					</p>
					<div class="L_97_1">
						<p>请提交您的截图(可选):</p>
						<div class="L_97_2">
							<a class="L_88_3"><input id="image" type="file"></a>
							<a class="L_88_3"><input type="file"></a>
							<a class="L_88_3"><input type="file"></a>
						</div>
						<span>图片要求：文件大小不能超过4M！文件格式必须为jpg或者png！请确保图像清晰，无水印，无污渍。</span>
						<input class="L_97_3" type="button" value="重新上传" />
						<p>选择币种：</p>
						<select class="L_97_7" id="L_97_7">
							<option>USDT</option>
							<option>BTC</option>
							<option>ETH</option>
							<option>LDF</option>
						</select>
						<p>交易ID(hash)：</p>
						<input class="L_97_4" id="L_97_4" type="text" placeholder="从发币方获取交易ID" />
						
						<p>您的文字资料：</p>
						<textarea class="L_97_5" id="L_97_5" placeholder="请具体并准确描述您的问题，这有助于我们更高效得帮助您！" autocomplete="off"></textarea>
						<input class="L_97_6" type="button" value="提交" onclick="submitWork();" />
						<script>
							var kd=parseInt($("#L_97_7").css("width"))-10+"px";
							$("#L_97_4").css("width",kd);
							$("#L_97_5").css("width",kd);
							window.onresize = function() {
								var kd=parseInt($("#L_97_7").css("width"))-10+"px";
								$("#L_97_4").css("width",kd);
								$("#L_97_5").css("width",kd);
							}
						</script>
					</div>
				</div>
			</div>
		</div>
		<input value="${isAuth}" id="isAuth" type="hidden">
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/auth.js"></script>
		<script type="text/javascript" src="js/utils.js"></script>
		<script type="text/javascript" src="js/page/userInfo/myWorkList.js"></script>
		
	</body>

</html> 