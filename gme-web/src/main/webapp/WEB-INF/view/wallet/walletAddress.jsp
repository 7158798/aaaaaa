<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/CZ.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/style-hei.css" />
		<link rel="stylesheet" href="css/1200.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
		
		<script type="text/javascript">
			//得到所有的币种
			$.ajax({
				type: 'GET',
				url: "http://192.168.0.148:8080/gme-web/api/v1/operation/coinList.json",
				dataType: "json",
				success: function(data) {
					var currencyId = $("#hiddenId").val();
					console.debug(currencyId);
					if (data.code == 200) {
						$.each(data.data,function(index,item){
							$.each(item,function(index,item){
								if (currencyId == null || currencyId == "") {
									$("#currencyId").append("<option value='"+item.currencyId+"'>"+item.name+"</option>");
								}else {
									if (currencyId == item.currencyId) {
										$("#currencyId").append("<option value='"+item.currencyId+"' selected='selected'>"+item.name+"</option>");
									}else {
										$("#currencyId").append("<option value='"+item.currencyId+"'>"+item.name+"</option>");
									}
								}
								$("#currencyAddressId").append("<option value='"+item.currencyId+"'>"+item.name+"</option>");
							});
						});
					}
				}
			});
			
		</script>
		
		
		<script type="text/javascript">
			// 查询所有的提币地址,可以带条件
			function getAddressList(){
				var currencyId = $("#currencyAddressId").val();
				$.ajax({
					type: "POST",
					url: "http://192.168.0.148:8080/gme-web/api/v1/wallet/withdrawAddress.json",
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
		</script>
		
		<script type="text/javascript">
			$(document).ready(function(e){
				getAddressList();
			});
		</script>
		
	</head>

	<body class="">
			<div class="L_36">
				<div class="L_39" style="border-bottom: 1px solid #E6EAF0;">
					钱包管理地址
				</div>
				<div class="L_49">
					<div class="L_53">
						<div class="L_55">
							<span>币种</span>
							<span>提币地址：</span>
							<span>备注：</span>
						</div>
						<div class="L_56">
							<select id="currencyId" name="currencyId">
							</select>
							<input type="text" name="address" id="address"/>
							<input type="text" name="remark" id="remark"/><br />
							<input type="button" id="button" value="添加" />
							<input type="hidden" value="${review}" id="hiddenId"/>
						</div>
					</div>
					<div class="L_54">
						<p>地址列表</p>
						<table class="L_40" style="width: 100%;">
							<tbody>
								<tr>
									<th style="width: 8%;">
										<select id="currencyAddressId" name="currencyAddressId">
											<option value="">币种</option>
											<option value="">全部</option>
										</select>
									</th>
									<th>提币地址</th>
									<th>备注</th>
									<th>操作</th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		<script type="text/javascript" src="js/style.js"></script>
		
		
		
		<script type="text/javascript">
			// 添加地址
			$("#button").click(function(){
				var symbol = $("#currencyId option:selected").text();
				var currencyId = $("#currencyId").val();
				var address = $("#address").val();
				var remark = $("#remark").val();
				$.ajax({
					type: 'POST',
					url: "http://192.168.0.148:8080/gme-web/api/v1/wallet/withdrawAddressAdd.json",
					dataType: "json",
					data: "currencyId=" + currencyId + "&address=" + address + "&remark=" + remark + "&tradeAuth=" + "111",
					success: function(data){
						if (data.code == 200) {
							//$("tbody").append('<tr><input type="hidden" value="'+currencyId+'"/><td>'+symbol+'</td><td>'+address+'</td><td>'+remark+'</td><td><a>删除</a></td></tr>');	
							location.reload();
						}
					}
				});
				
			});
			
		</script>
		
		
		<script type="text/javascript">
			//给币种绑定change事件,根据currencyId查询所有的提币地址
			$("#currencyAddressId").change(function(){
				getAddressList();
			});
			
		</script>
		
		
		<script type="text/javascript">
			// 删除提币地址
			function delAddress(obj){
				var currencyId = $(obj).parent().parent().children().val();
				var address = $(obj).parent().parent().children().next().next().html();
				console.debug(currencyId);
				console.debug(address);
				$.ajax({
					type: 'POST',
					url: "http://192.168.0.148:8080/gme-web/api/v1/wallet/withdrawAddressDel.json",
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
		</script>
		
	</body>

</html>