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
			<div class="L_36" style="height: 100%;min-height:800px;">
				<div class="L_39">
					收款设置
				</div>
				<div class="L_85_3" style="display: block;">
					<p>设置收款方式，必须是本人账号。(支付时必须本人实际操作，非自动扣款。)</p>
				</div>
				<div class="L_86 L_86_a">
					<span style="float: left;margin-right: 30px;">绑定银行卡</span>
					<div class="slideOne" style="top: 30px;">
						<input type="checkbox" value="None" onclick="c()" id="slideOne" name="check" />
						<label for="slideOne"></label>
					</div>
					<span id="bankCardText"></span>
				</div>
				<div class="L_85" id="L_86_1" style="display: none;">
					<p>姓名：<span id="bankCardTextName"></span></p><br />
					<p style="margin-top: 10px;">您尚未绑定银行卡，<span>绑定银行卡</span></p><br />
					<input type="button" value="立即绑定" onclick="$('#L_86_1').css('display','none');$('#L_87_1').css('display','block');" />
				</div>
				<div class="L_87" id="L_87_1">
					<p>姓&ensp;&ensp;&ensp;&ensp;名：<span id="bankCardTextName2"></span>&ensp;&ensp;(请绑定本人持有银行卡)</p>
					<p>开户银行：
						<select id="outBank">
							<option value="" label="">请选择开户银行</option>
							<option value="工商银行">工商银行</option>
							<option value="中国银行">中国银行</option>
							<option value="农业银行">农业银行</option>
							<option value="建设银行">建设银行</option>
							<option value="招商银行">招商银行</option>
							<option value="交通银行">交通银行</option>
							<option value="中国邮政储蓄银行">中国邮政储蓄银行</option>
							<option value="民生银行">民生银行</option>
							<option value="兴业银行">兴业银行</option>
							<option value="中信银行">中信银行</option>
							<option value="光大银行">光大银行</option>
							<option value="华夏银行">华夏银行</option>
							<option value="广发银行">广发银行</option>
							<option value="平安银行">平安银行</option>
							<option value="徽商银行">徽商银行</option>
							<option value="广州银行">广州银行</option>
							<option value="渤海银行">渤海银行</option>
							<option value="上海浦东发展银行">上海浦东发展银行</option>	
							<option value="深圳发展银行">深圳发展银行</option>
							<option value="浙商银行">浙商银行</option>
							<option value="恒丰银行">恒丰银行</option>
							<option value="天津银行">天津银行</option>
							<option value="北京银行">北京银行</option>
							<option value="上海银行">上海银行</option>
							<option value="江苏银行">江苏银行</option>
							<option value="南京银行">南京银行</option>
							<option value="北京农商银行">北京农商银行</option>
							<option value="上海农商银行">上海农商银行</option>
							<option value="重庆银行">重庆银行</option>
							<option value="宁波银行">宁波银行</option>
							<option value="齐鲁银行">齐鲁银行</option>
					</select>
					</p>
					<p>开户支行：<input id="outBranchBank" type="text" placeholder="可填写所在支行，市分行，分行营业厅或部分核算中心"/></p>
					<p>银行卡号：<input id="outBankCard" type="text" placeholder="请输入您要绑定的银行卡号" onkeyup="value=value.replace(/[^\d]/g,'')"/></p>
					<p>资金密码：<input id="outBankCardPayPassword" type="text" placeholder="请输入您的资金密码"/></p>
					<p>风险提示：<span class="L_87_1">C2C属于场外交易，法币不经过平台，平台不会自动扣款，需要您手动自行转账给对方，对方才能收到款项。<br />
					&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;绑定银行卡等收款信息只为核对信息之用，不是扣款依据。</span></p>
					<p class="L_87_2"><input id="confirmInfo" type="checkbox" style="margin-right: 10px;" />我已阅读并充分理解上述内容，由于款项造成的交易风险自行承担</p>
					<input type="button" value="确定绑定" onclick="confirmBindBankCard();"/>
				</div>
				<div class="L_85" style="display: none;" id="L_86_2">
					<p>已绑定银行卡：<span id="bindBankCardText"></span></p><br/>
					<input type="button" value="修改" onclick="updateBankCardInfo();"/>
				</div>
				<input type="hidden" value="${bankCard}" id="bankCard">
				<input type="hidden" value="${name}" id="name">
				<input type="hidden" value="${bank}" id="bank">
				<input type="hidden" value="${branch}" id="branch">
				<input type="hidden" value="${bankCardNum}" id="bankCardNum">
				<input type="hidden" value="${alipay}" id="alipay">
				<input type="hidden" value="${aliPayImgUrl}" id="aliPayImgUrl">
				<input type="hidden" value="${aliPayNum}" id="aliPayNum">
				<input type="hidden" value="${aliPayremark}" id="aliPayremark">
				<input type="hidden" value="${wechat}" id="wechat">
				<input type="hidden" value="${wechatImgUrl}" id="wechatImgUrl">
				<input type="hidden" value="${wechatNum}" id="wechatNum">
				<input type="hidden" value="${wechatremark}" id="wechatremark">
				
				<div class="L_86 L_86_a">
					<span style="float: left;margin-right: 30px;">绑定支付宝</span>
					<div class="slideOne" style="top: 30px;">
						<input type="checkbox" value="None" onclick="cc()" id="slideOne2" name="check" />
						<label for="slideOne2"></label>
					</div>
					<span id=aliPayText></span>
				</div>
				<div class="L_85" id="L_86_3" style="display: none;">
					<p>姓名：<span id="aliPayTextName"></span></p><br />
					<p style="margin-top: 10px;">您尚未绑定支付宝，<span>绑定支付宝</span></p><br />
					<input type="button" value="立即绑定" onclick="$('#L_86_3').css('display','none');$('#L_88_1').css('display','block');" />
				</div>
				<div class="L_88" id="L_88_1">
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;支付宝账号姓名：<span id="aliPayTextName2"></span>&ensp;&ensp;(请绑定本人持有银行卡)</p>
					<p>&ensp;&ensp;&ensp;&ensp;上传支付宝收款码：<a id="aliPayImgStyle" class="L_88_3"><input id="aliPayImg" type="file" /></a></p>
					<p>支付宝收款码获取方法：<span class="L_88_4">打开支付宝APP，在首页点击”收钱“，在打开的个人收钱二维码下方点击”保存图片“即可（每天最多修改三次）。</span></p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;支付宝账号：<input id="outAliPayNum" type="text" placeholder="请输入您要绑定的支付宝账号"/></p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;备注信息：<input id="outRemark" type="text" placeholder="请输入显示给对方备注信息"/></p>
					<p class="L_88_1">如果希望对方快速联系，可以在备注中添加联系方式，务必防御电话诈骗。</p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;资金密码：<input id="outAliPayPayPassword" type="text" placeholder="请输入您的资金密码"/></p>
					<input type="button" value="确定绑定"  onclick="bindAliPay();"/>
				</div>
				<div class="L_85" style="display: none;" id="L_86_4">
					<p>已绑定支付宝：<span id="aliPayTextNum"></span></p><br/>
					<input type="button" value="修改" onclick="updateAliPayInfo();"/>
				</div>
				
				<div class="L_86 L_86_a">
					<span style="float: left;margin-right: 30px;">绑定微信&nbsp;&nbsp;&nbsp;</span>
					<div class="slideOne" style="top: 30px;">
						<input type="checkbox" value="None" onclick="ccc()" id="slideOne3" name="check" />
						<label for="slideOne3"></label>
					</div>
					<span id="wechatText"></span>
				</div>
				<div class="L_85" id="L_86_5" style="display: none;">
					<p>姓名：<span id="wechatTextName"></span></p><br />
					<p style="margin-top: 10px;">您尚未绑定微信，<span>绑定微信</span></p><br />
					<input type="button" value="立即绑定" onclick="$('#L_86_5').css('display','none');$('#L_88_2').css('display','block');" />
				</div>
				<div class="L_88" id="L_88_2">
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;微信账号姓名：<span id="wechatTextName2"></span>&ensp;&ensp;(请绑定本人持有银行卡)</p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;上传微信收款码：<a id="wechatImgStyle" class="L_88_3"><input type="file"/></a></p>
					<p>&ensp;&ensp;微信收款码获取方法：<span class="L_88_4">打开微信APP，在首页点击”收钱“，在打开的个人收钱二维码下方点击”保存图片“即可（每天最多修改三次）。</span></p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;微信账号：<input id="outWechatNum" type="text" placeholder="请输入您要的微信账号"/></p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;备注信息：<input id="outWechatRemark" type="text" placeholder="请输入显示给对方的备注信息"/></p>
					<p class="L_88_1">如果希望对方快速联系，可以在备注中添加联系方式，务必防御电话诈骗。</p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;资金密码：<input id="outWechatPayPassword" type="text" placeholder="请输入您的资金密码"/></p>
					<input type="button" value="确定绑定"  onclick="bindWechat();" />
				</div>
				<div class="L_85" style="display: none;" id="L_86_6">
					<p>已绑定微信：<span id="wechatTextNum"></span></p><br/>
					<input type="button" onclick="updateWechatInfo();" value="修改" />
				</div>
				
				<div class="L_85_3" style="display: block;">
					<p>注意</p>
					<p style="margin-top: 20px;margin-bottom: 14px;">1.请绑定您的本人收款信息</p>
					<p>2.支付时必须本人实际操作，非自动扣款。</p>
				</div>
			</div>
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/page/security/paySetting.js"></script>
	</body>

</html>