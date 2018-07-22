
//得到所有的币种
function queryCurrencyList(){
	$.ajax({
		type: 'GET',
		url: "http://192.168.136.1:8080/gme-web/api/v1/operation/coinList.json",
		dataType: "json",
		success: function(data) {
			if (data.code == 200) {
				var dataChar = data.data;
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					$("#currencyId").append("<option value='"+data.currencyId+"'>"+data.currencyName+"</option>");
				}
			}
		}
	});
}

// 查询所有的提币地址,可以带条件
function getAddressList(){
	var currencyId = $("#currencyAddressId").val();
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/wallet/withdrawAddress.json",
		dataType: "json",
		data: "currencyId=" + currencyId,
		success: function(data){
			if (data.code == 200) {
				$("tbody tr:not(:first)").remove();
				var dataChar = data.data.withdraw.data;
				// 遍历返回的data对象
				for (var i = dataChar.length-1;i >= 0;i--) {
					var data = dataChar[i];
					// 如果地址为空，不显示
					if (data.addressArray.length > 0) {
						for (var j = 0; j < data.addressArray.length; j++) {
							var id = data.currencyId;
							$("tbody").append("<tr><input type='hidden' value='"+data.currencyId+"'/><td>"+data.currency+"</td><td>"+data.addressArray[j]+"</td><td>"+data.remark+"</td><td><a onclick='delAddress(this)'>删除</a></td></tr>");
						}
					}
				}
			}
		}
	});
}


// 添加地址
function addAddress(){
	var currencyId = $("#currencyId").val();
	var address = $("#address").val();
	var remark = $("#remark").val();
	if (address == "") {
		alert("提币地址不能为空");
		return;
	}
	if (remark == "") {
		alert("备注不能为空");
		return;
	}
	
	$("#inputPayPassword").children().css("display","block");
	
}

// 确认添加提币地址
function confirmAddAddress(){
	var currencyId = $("#currencyId").val();
	var address = $("#address").val();
	var remark = $("#remark").val();
	var payPassword = $("#payPassword").val();
	if (payPassword == "") {
		alert("请输入资金密码");
		return;
	}
	
	$.ajax({
		type: 'POST',
		url: "http://192.168.136.1:8080/gme-web/api/v1/wallet/withdrawAddressAdd.json",
		data: "currencyId=" + currencyId + "&address=" + address + "&remark=" + remark + "&tradeAuth=" + payPassword,
		dataType: "json",
		success: function(data){
			if (data.code == 200) {
				// 刷新地址列表
				getAddressList();
			}else {
				alert("添加提币地址:" + data.message);
			}
		}
	});
	
}


//删除提币地址
function delAddress(obj){
	var currencyId = $(obj).parent().parent().children().val();
	var address = $(obj).parent().parent().children().next().next().html();
	$.ajax({
		type: 'POST',
		url: "http://192.168.136.1:8080/gme-web/api/v1/wallet/withdrawAddressDel.json",
		dataType: "json",
		data: "currencyId=" + currencyId + "&address=" + address + "&tradeAuth=" + "111",
		success: function(data){
			if (data.code == 200) {
				location.reload();
			}else {
				alert(data.message);
			}
		}
	});
}


//给币种绑定change事件,根据currencyId查询所有的提币地址
$("#currencyAddressId").change(function(){
	getAddressList();
});

//查询所有的提币地址,可以带条件
getAddressList();
//得到所有的币种
queryCurrencyList();