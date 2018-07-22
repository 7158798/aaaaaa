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
		<div class="L_24">
			<div class="L_25">
				<div style="width: 100%;height: 16px;"></div>
				<div class="L_26">
					<h1>最新公告</h1>
				</div>
				<div class="L_27">
					<div class="L_28">
						<ul>
							<li>
								<a href="notice.html" class="gg_action">
									<div class="L_28_1"></div>
									<span>官方公告</span>
								</a>
							</li>
							<li class="">
								<a href="currencyDetail.html">
									<div class="L_28_3"></div>
									<span>币种介绍</span>
								</a>
							</li>
						</ul>
					</div>
					<div class="L_29">
						<ul id="noticeTitleList">
						</ul>
						<div class="L_30">
							<a id="nextPage">下一页</a>
							<a id="prePage">上一页</a>
						</div>
						<input type="hidden" id="currentPage"/>
						<input type="hidden" id="pageCount"/>
					</div>
					
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/utils.js"></script>
		<script type="text/javascript" src="js/page/other/notice.js"></script>	
		
		
	</body>

</html>