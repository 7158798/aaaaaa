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
		<div class="header">
			<div class="header_1">
				<div class="logo">
					<a>
						<img src="img/dblg.png" />
					</a>
				</div>
				<div class="header_daohang">
					<ul>
						<li>
							<a href="#">首页</a>
						</li>
						<li>
							<a href="#">C2C交易</a>
						</li>
						<li>
							<a href="#">币币交易</a>
						</li>
						<li>
							<a href="#">我的财务</a>
						</li>
						<li>
							<a href="#">安全设置</a>
						</li>
						<li>
							<a href="#">公告</a>
						</li>
						<li>
							<a href="#">提交工单</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="header_2">
				<div class="header_dengluhou">
					<ul>
						<li>
							<a href="#" class="whate">19019382@qq.com<i></i></a>
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
				<ul>
					<li class="L_37">
						<img src="img/L_31.png" /> 安全设置
					</li>
					<li class="L_38">
						<a>身份认证</a>
					</li>
					<li class="L_38">
						<a>手机绑定</a>
					</li>
					<li class="L_38">
						<a>两步登录保护</a>
					</li>
					<li class="L_38 ">
						<a>API Keys</a>
					</li>
					<li class="L_38 ">
						<a>修改登录密码</a>
					</li>
					<li class="L_38">
						<a>修改资金密码</a>
					</li>
					<li class="L_38">
						<a>邮箱绑定</a>
					</li>
					<li class="L_38">
						<a>提币双重验证</a>
					</li>
					<li class="L_38 action_38">
						<a>支付设置</a>
					</li>
					<li class="L_38">
						<a>安全日志</a>
					</li>
				</ul>
			</div>
			<div class="L_36" style="height: 100%;min-height:800px;">
				<div class="L_39" style="border-bottom: 2px solid #fafbfc;">
					收款设置
				</div>
				<div class="L_85_3" style="display: block;color: #5c5c66;">
					<p>设置收款方式，必须是本人账号。(支付时必须本人实际操作，非自动扣款。)</p>
				</div>
				<div class="L_86" style="border-bottom: 1px solid #fafbfc;">
					<span style="float: left;margin-right: 30px;">绑定银行卡</span>
					<div class="slideOne" style="top: 30px;">
						<input type="checkbox" value="None" onclick="c()" id="slideOne" name="check" />
						<label for="slideOne"></label>
					</div>
					<span>开启</span>
				</div>
				<div class="L_85" id="L_86_1" style="display: none;">
					<p>姓名：<span>李天一</span></p><br />
					<p style="margin-top: 10px;">您尚未绑定银行卡，<span>绑定银行卡</span></p><br />
					<input type="button" value="立即绑定" onclick="$('#L_86_1').css('display','none');$('#L_87_1').css('display','block');" />
				</div>
				<div class="L_87" id="L_87_1">
					<p>姓&ensp;&ensp;&ensp;&ensp;名：<span>李天一</span>&ensp;&ensp;(请绑定本人持有银行卡)</p>
					<p>开户银行：
						<select>
							<option value="volvo">中国建设银行</option>
							<option value="saab">中国人民银行</option>
							<option value="opel">中国工商银行</option>
							<option value="audi">中国天地银行</option>
						</select>
					</p>
					<p>开户支行：<input type="text" placeholder="可填写所在支行，市分行，分行营业厅或部分核算中心"/></p>
					<p>银行卡号：<input type="text" placeholder="请输入您要绑定的银行卡号"/></p>
					<p>资金密码：<input type="text" placeholder="请输入您的资金密码"/></p>
					<p>风险提示：<span class="L_87_1">C2C属于场外交易，法币不经过平台，平台不会自动扣款，需要您手动自行转账给对方，对方才能收到款项。<br />
					&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;绑定银行卡等收款信息只为核对信息之用，不是扣款依据。</span></p>
					<p class="L_87_2"><input type="checkbox" checked="checked" style="margin-right: 10px;" />我已阅读并充分理解上述内容，由于款项造成的交易风险自行承担</p>
					<input type="button" value="确定绑定" onclick="$('#L_87_1').css('display','none');$('#L_86_2').css('display','block');"/>
				</div>
				<div class="L_85" style="display: none;" id="L_86_2">
					<p>已绑定银行卡：<span>62278********4656</span></p>
				</div>
				<script>
					function c() {
						if($("#slideOne").is(':checked')) {
							$('#L_86_1').css('display', 'block');
						} else {
							$('#L_86_1').css('display', 'none');
							$('#L_87_1').css('display', 'none');
							$('#L_86_2').css('display', 'none');
						}
					}
				</script>
				<div class="L_86" style="border-bottom: 1px solid #fafbfc;">
					<span style="float: left;margin-right: 30px;">绑定支付宝</span>
					<div class="slideOne" style="top: 30px;">
						<input type="checkbox" value="None" onclick="cc()" id="slideOne2" name="check" />
						<label for="slideOne2"></label>
					</div>
					<span>开启</span>
				</div>
				<div class="L_85" id="L_86_3" style="display: none;">
					<p>姓名：<span>李天一</span></p><br />
					<p style="margin-top: 10px;">您尚未绑定支付宝，<span>绑定支付宝</span></p><br />
					<input type="button" value="立即绑定" onclick="$('#L_86_3').css('display','none');$('#L_88_1').css('display','block');" />
				</div>
				<div class="L_88" id="L_88_1">
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;支付宝账号姓名：<span>李天一</span>&ensp;&ensp;(请绑定本人持有银行卡)</p>
					<p>&ensp;&ensp;&ensp;&ensp;上传支付宝收款码：<a class="L_88_3"><input type="file"/></a></p>
					<p>支付宝收款码获取方法：<span class="L_88_4">打开支付宝APP，在首页点击”收钱“，在打开的个人收钱二维码下方点击”保存图片“即可（每天最多修改三次）。</span></p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;支付宝账号：<input type="text" placeholder="请输入您要绑定的支付宝账号"/></p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;备注信息：<input type="text" placeholder="请输入显示给对方备注信息"/></p>
					<p class="L_88_1">如果希望对方快速联系，可以在备注中添加联系方式，务必防御电话诈骗。</p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;资金密码：<input type="text" placeholder="请输入您的资金密码"/></p>
					<input type="button" value="确定绑定"  onclick="$('#L_88_1').css('display','none');$('#L_86_4').css('display','block');" />
				</div>
				<div class="L_85" style="display: none;" id="L_86_4">
					<p>已绑定支付宝：<span>2484***@qq.com</span></p>
				</div>
				<script>
					function cc() {
						if($("#slideOne2").is(':checked')) {
							$('#L_86_3').css('display', 'block');
						} else {
							$('#L_86_3').css('display', 'none');
							$('#L_86_4').css('display', 'none');
							$('#L_88_1').css('display', 'none');
						}
					}
				</script>
				<div class="L_86" style="border-bottom: 1px solid #fafbfc;">
					<span style="float: left;margin-right: 30px;">绑定微信&nbsp;&nbsp;&nbsp;</span>
					<div class="slideOne" style="top: 30px;">
						<input type="checkbox" value="None" onclick="ccc()" id="slideOne3" name="check" />
						<label for="slideOne3"></label>
					</div>
					<span>开启</span>
				</div>
				<div class="L_85" id="L_86_5" style="display: none;">
					<p>姓名：<span>李天一</span></p><br />
					<p style="margin-top: 10px;">您尚未绑定微信，<span>绑定微信</span></p><br />
					<input type="button" value="立即绑定" onclick="$('#L_86_5').css('display','none');$('#L_88_2').css('display','block');" />
				</div>
				<div class="L_88" id="L_88_2">
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;微信账号姓名：<span>李天一</span>&ensp;&ensp;(请绑定本人持有银行卡)</p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;上传微信收款码：<a class="L_88_3"><input type="file"/></a></p>
					<p>&ensp;&ensp;微信收款码获取方法：<span class="L_88_4">打开微信APP，在首页点击”收钱“，在打开的个人收钱二维码下方点击”保存图片“即可（每天最多修改三次）。</span></p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;微信账号：<input type="text" placeholder="请输入您要的微信账号"/></p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;备注信息：<input type="text" placeholder="请输入显示给对方的备注信息"/></p>
					<p class="L_88_1">如果希望对方快速联系，可以在备注中添加联系方式，务必防御电话诈骗。</p>
					<p>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;资金密码：<input type="text" placeholder="请输入您的资金密码"/></p>
					<input type="button" value="确定绑定"  onclick="$('#L_88_2').css('display','none');$('#L_86_6').css('display','block');" />
				</div>
				<div class="L_85" style="display: none;" id="L_86_6">
					<p>已绑定微信：<span>2484***@qq.com</span></p>
				</div>
				<script>
					function ccc() {
						if($("#slideOne3").is(':checked')) {
							$('#L_86_5').css('display', 'block');
						} else {
							$('#L_86_5').css('display', 'none');
							$('#L_86_6').css('display', 'none');
							$('#L_88_2').css('display', 'none');
						}
					}
				</script>
				<div class="L_85_3" style="display: block;color: #5c5c66;">
					<p>注意</p>
					<p style="margin-top: 20px;margin-bottom: 14px;">1.请绑定您的本人收款信息</p>
					<p>2.支付时必须本人实际操作，非自动扣款。</p>
				</div>
			</div>
		</div>
		<!-- footer -->

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
	</body>

</html>