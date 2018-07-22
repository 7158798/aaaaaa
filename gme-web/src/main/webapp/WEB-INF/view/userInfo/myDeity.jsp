<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					最新挂单
				</div>
				<table id="deityTable" class="L_40">
					<tr>
						<th>日期</th>
						<th>类型</th>
						<th>交易对</th>
						<th>交易价</th>
						<th>挂单量(锁定)</th>
						<th>总计</th>
						<th>操作</th>
					</tr>
				</table>
				<div class="L_41">
					<span>1</span>
					<span style="background: #2B6FC9;color: #FFFFFF;">2</span>
					<span>...</span>
					<input type="hidden" id="currentPage"/>
					<input type="hidden" id="pageCount"/>
					<span><a id="prePage">上一页</a></span>
					<span><a id="nextPage">下一页</a></span>
				</div>
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/utils.js"></script>	
		<script type="text/javascript" src="js/page/userInfo/myDeity.js"></script>	
		
		
	</body>

</html>