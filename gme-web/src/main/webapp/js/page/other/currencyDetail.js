// 查询所有的币种
function getCurrencyList(){
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/operation/coinList.json",
		dataType: "json",
		success: function(data){
			if (data.code == 200) {
				$("#currencyList li:not(:first)").remove();
				var dataChar = data.data;
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					$("#currencyList").append("<li><a><img src='img/L_7.png' />"+data.currencySymbol+"</a><input type='hidden' value='"+data.currencyId+"'/></li>");
				}
				// 给第一个默认选中样式
				$("#currencyList li").eq(1).css("class","action_70");
				var fistCurrencyId = $("#currencyList li").eq(1).children().eq(-1).val();
				$.ajax({
					type: "GET",
					url: "http://192.168.136.1:8080/gme-web/api/v1/operation/getCurrencyDetail.json",
					dataType: "json",
					data: "currencyId=" + fistCurrencyId,
					success: function(data){
						if (data.code == 200) {
							$("#content").html(data.data.currencyBrief);
						}
					}
				});
				
				// 给每一个币种添加点击事件
				$("#currencyList").children().each(function(){
					$(this).children().click(function(){
						var currencyId = $(this).parent().children().eq(-1).val();
						$.ajax({
							type: "GET",
							url: "http://192.168.136.1:8080/gme-web/api/v1/operation/getCurrencyDetail.json",
							dataType: "json",
							data: "currencyId=" + currencyId,
							success: function(data){
								if (data.code == 200) {
									$("#content").html(data.data.currencyBrief);
								}else {
									alert("币种币种详情:" + data.message);
								}
							}
						});
					});
				});
			}else {
				alert("查询所有的币种:" + data.message);
			}
		}
	})
}

//查询所有的币种
getCurrencyList();