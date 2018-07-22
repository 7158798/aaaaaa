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
		<div class="L_98">
			工单详情
		</div>
		<div class="L_99">
			<p>
				<span>工单ID：</span>
				<span id="workId"></span>
				<span>创建时间：</span>
				<span id="createTime"></span>
				<span>状态：</span>
				<span id="status"></span>
			</p>
			<div id="boss" class="L_100">
			</div>
			<div class="L_101">
				<textarea id="content" class="L_101_1" placeholder="请具体并准确描述您的问题，这有助于我们更高效得帮助您！" autocomplete="off"></textarea>
				<a class="L_88_3" style="width: 84px;height: 90px;margin-left: 20px;"><input type="file"></a>
				<a class="L_88_3" style="width: 84px;height: 90px;margin-left: 20px;"><input type="file"><img src="img/L_62.png" style="z-index: 9999;position: absolute;top: 0px;right: 0px;" onclick="alert(1)" /></a>
				<a class="L_88_3" style="width: 84px;height: 90px;margin-left: 20px;"><input type="file"></a>
				<input onclick="submitReply();" class="L_101_2" type="button" value="提交" />
			</div>
		</div>
		<script type="text/javascript" src="js/style.js"></script>
		<script type="text/javascript" src="js/utils.js"></script>
		<script type="text/javascript" src="js/page/userInfo/workListDetail.js"></script>
		
		

	</body>

</html>