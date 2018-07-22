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
	</head>

	<body class="">
				<div class="L_39">
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
							<input type="button" onclick="addAddress();" value="添加" />
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
				<div id="inputPayPassword">
					<div class="tc">
						<div class="tc_1">
							<div class="tc_1_1">
								<span>填写信息</span>
								<img src="img/L_10.png" onclick="$('.tc').css('display','none');" />
							</div>
							<div class="tc_1_2">
								<p>输入资金密码：<input type="password" id="payPassword"/></p>
								<div class="tc_1_3">
									<input onclick="confirmAddAddress();" type="button" value="确定" />
									<input onclick="$('.tc').css('display','none');" type="button" value="取消" />
								</div>
							</div>
					</div>
			</div>
		</div>
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/page/wallet/walletAddressManager.js"></script>
		
	</body>

</html>