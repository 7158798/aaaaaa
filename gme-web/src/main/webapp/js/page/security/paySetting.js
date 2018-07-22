// 全局变量
var isBankCard = $("#bankCard").val();
var name = $("#name").val();
var bank = $("#bank").val();
var branch = $("#branch").val();
var bankCardNum = $("#bankCardNum").val();

var alipay = $("#alipay").val();
var aliPayImgUrl = $("#aliPayImgUrl").val();
var aliPayNum = $("#aliPayNum").val();
var aliPayremark = $("#aliPayremark").val();

var wechat = $("#wechat").val();
var wechatImgUrl = $("#wechatImgUrl").val();
var wechatNum = $("#wechatNum").val();
var wechatremark = $("#wechatremark").val();


// 页面加载完
//绑定了银行卡
if (isBankCard == "true") {
	$("#bankCardText").text("开启");
	$("#slideOne").attr("checked","checked");
	$("#L_86_2").css("display", "block");
	$("#bindBankCardText").text(bankCardNum);
}else { // 没绑定银行卡
	$("#bankCardText").text("关闭");
	$("#slideOne").attr("checked",false);
}

//绑定了支付宝
if (alipay == "true") {
	$("#aliPayText").text("开启");
	$("#slideOne2").attr("checked","checked");
	$("#L_86_4").css("display", "block");
	$("#aliPayTextNum").text(aliPayNum);
}else { // 没绑定支付宝
	$("#aliPayText").text("关闭");
	$("#slideOne2").attr("checked",false);
}

//绑定了微信
if (wechat == "false") {
	$("#wechatText").text("开启");
	$("#slideOne3").attr("checked","checked");
	$("#L_86_6").css("display", "block");
	$("#wechatTextNum").text(wechatNum);
}else { // 没绑定微信
	$("#wechatText").text("关闭");
	$("#slideOne3").attr("checked",false);
}


//********************************************** 银行卡 *************************************
function c() {
	// 绑定了银行卡	
	if (isBankCard == "true") {
		if($("#slideOne").is(':checked')) {
			$("#bankCardText").text("开启");
			$("#L_86_2").css("display", "block");
			$("#bindBankCardText").text(bankCardNum);
		}else { // 用户取消绑定银行卡
			$.ajax({
				type: "POST",
				url: "http://192.168.136.1:8080/gme-web/api/v1/security/closePayMethod.json",
				dataType: "json",
				data: "type=3",
				success: function(data) {
					if (data.code == 200) {
						$("#bankCardText").text("关闭");
						$('#L_86_1').css('display', 'none');
						$('#L_87_1').css('display', 'none');
						$('#L_86_2').css('display', 'none');
					}else {
						alert("解除绑定银行卡:" + data.message);
					}
				}
			})
		}
	}else { // 没绑定银行卡
		if($("#slideOne").is(':checked')) {
			$("#bankCardText").text("开启");
			$('#L_86_1').css('display', 'block');
			$("#bankCardTextName").text(name);
			$("#bankCardTextName2").text(name);
			$('#L_87_1').css('display', 'none');
			$('#L_86_2').css('display', 'none');
		}else {
			$("#bankCardText").text("关闭");
			$('#L_86_1').css('display', 'none');
			$('#L_87_1').css('display', 'none');
			$('#L_86_2').css('display', 'none');
		}
	}
}


//绑定银行卡
function confirmBindBankCard(){
	var outBank = $("#outBank option:selected").val();
	var outBranchBank = $("#outBranchBank").val();
	var outBankCard = $("#outBankCard").val();
	var outBankCardPayPassword = $("#outBankCardPayPassword").val();
	if (!$("#confirmInfo").is(":checked")) {
		alert("请阅读风险提示");
		return;
	}
	if (outBank == "") {
		alert("请选择开户银行");
		return;
	}
	if (outBranchBank == "") {
		alert("请填写开户支行");
		return;
	}
	if (outBankCard == "") {
		alert("请银行卡号");
		return;
	}
	if (outBankCardPayPassword == "") {
		alert("请输入资金密码");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/security/payMethedBank.json",
		dataType: "json",
		data: "bank=" + outBank + "&branch=" + outBranchBank + "&bankCard=" + outBankCard + "&tradeAuth=" + outBankCardPayPassword,
		success: function(data){
			if (data.code == 200) {
				window.location.href=window.location.href;
			}else {
				alert("绑定银行卡:" + data.message);
			}
		}
	});
}

//编辑修改银行卡信息
function updateBankCardInfo(){
	$("#L_87_1").css("display","block");
	$("#L_86_2").css("display", "none");
	$("#bankCardTextName2").text(name);
	$("#outBank option[value='"+bank+"']").attr("selected","selected");
	$("#outBranchBank").val(branch);
	$("#outBankCard").val(bankCardNum);
}


// ************************************* 支付宝 *****************************************
function cc() {
	// 绑定了支付宝	
	if (alipay == "true") {
		if($("#slideOne2").is(':checked')) {
			$("#aliPayText").text("开启");
			$("#L_86_4").css("display", "block");
			$("#aliPayTextNum").text(aliPayNum);
		}else { // 关闭支付宝
			$.ajax({
				type: "POST",
				url: "http://192.168.136.1:8080/gme-web/api/v1/security/closePayMethod.json",
				dataType: "json",
				data: "type=1",
				success: function(data) {
					if (data.code == 200) {
						$("#aliPayText").text("关闭");
						$('#L_86_3').css('display', 'none');
						$('#L_86_4').css('display', 'none');
						$('#L_88_1').css('display', 'none');
					}else {
						alert("解除绑定支付宝:" + data.message);
					}
				}
			})
		}
	}else { // 没绑定支付宝
		if($("#slideOne2").is(':checked')) {
			$("#aliPayText").text("开启");
			$('#L_86_3').css('display', 'block');
			$("#aliPayTextName").text(name);
			$("#aliPayTextName2").text(name);
			$('#L_86_4').css('display', 'none');
			$('#L_88_1').css('display', 'none');
		}else {
			$("#aliPayText").text("关闭");
			$('#L_86_3').css('display', 'none');
			$('#L_86_4').css('display', 'none');
			$('#L_88_1').css('display', 'none');
		}
	}
	
}


//绑定支付宝
function bindAliPay(){
	var outAliPayNum = $("#outAliPayNum").val();
	var outRemark = $("#outRemark").val();
	var outAliPayPayPassword = $("#outAliPayPayPassword").val();
	if (outAliPayNum == "") {
		alert("请输入支付宝账号");
		return;
	}
	if (outAliPayPayPassword == "") {
		alert("请输入资金密码");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/security/payMethodAlipayWeChat.json",
		dataType: "json",	
		data: "qrImgId=1" + "&type=1" + "&account=" + outAliPayNum + "&remark=" + outRemark + "&tradeAuth=" + outAliPayPayPassword,
		success: function(data){
			if (data.code == 200) {
				window.location.href=window.location.href;
			}else {
				alert(data.message);
			}
		}
	});
}


//编辑修改支付宝信息
function updateAliPayInfo(){
	$("#L_86_4").css("display","none");
	$("#L_88_1").css("display", "block");
	
	$("#aliPayTextName2").text(name);
	$("#aliPayImgStyle").css("background","url("+aliPayImgUrl+") no-repeat 50% 50% scroll");
	$("#outAliPayNum").val(aliPayNum);
	$("#outRemark").val(aliPayremark);
}



// ***************************************** 微信 *****************************************
function ccc() {
	// 绑定了微信
	if (wechat == "false") {
		if($("#slideOne3").is(':checked')) {
			$("#wechatText").text("开启");
			$("#L_86_6").css("display", "block");
			$("#wechatTextNum").text(wechatNum);
		}else { // 关闭微信支付
			$.ajax({
				type: "POST",
				url: "http://192.168.136.1:8080/gme-web/api/v1/security/closePayMethod.json",
				dataType: "json",
				data: "type=2",
				success: function(data) {
					if (data.code == 200) {
						$("#wechatText").text("关闭");
						$('#L_86_5').css('display', 'none');
						$('#L_88_2').css('display', 'none');
						$('#L_86_6').css('display', 'none');
					}else {
						alert("解除绑定微信:" + data.message);
					}
				}
			})
			
		}
	}else { // 没绑定微信
		if($("#slideOne3").is(':checked')) {
			$("#wechatText").text("开启");
			$('#L_86_5').css('display', 'block');
			$("#wechatTextName").text(name);
			$("#wechatTextName2").text(name);
			$('#L_88_2').css('display', 'none');
			$('#L_86_6').css('display', 'none');
		}else {
			$("#wechatText").text("关闭");
			$('#L_86_5').css('display', 'none');
			$('#L_88_2').css('display', 'none');
			$('#L_86_6').css('display', 'none');
		}
	}
	
}


//绑定微信
function bindWechat(){
	var outWechatNum = $("#outWechatNum").val();
	var outWechatRemark = $("#outWechatRemark").val();
	var outWechatPayPassword = $("#outWechatPayPassword").val();
	if (outWechatNum == "") {
		alert("请输入微信账号");
		return;
	}
	if (outWechatPayPassword == "") {
		alert("请输入资金密码");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/security/payMethodAlipayWeChat.json",
		dataType: "json",	
		data: "qrImgId=1" + "&type=2" + "&account=" + outWechatNum + "&remark=" + outWechatRemark + "&tradeAuth=" + outWechatPayPassword,
		success: function(data){
			if (data.code == 200) {
				window.location.href=window.location.href;
			}else {
				alert("绑定微信:" + data.message);
			}
		}
	});
}



//编辑修改微信信息
function updateWechatInfo(){
	$("#L_86_6").css("display","none");
	$("#L_88_2").css("display", "block");
	
	$("#wechatTextName2").text(name);
	$("#wechatImgStyle").css("background","url("+wechatImgUrl+") no-repeat 50% 50% scroll");
	$("#outWechatNum").val(wechatNum);
	$("#outWechatRemark").val(wechatremark);
}
