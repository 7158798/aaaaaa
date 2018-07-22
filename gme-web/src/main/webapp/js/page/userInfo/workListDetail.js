// 用户提交工单回复
function submitReply(){
	var workId = $("#workId").text();
	var content = $("#content").val();
	$.ajax({
		type: "POST",
		url: "http://192.168.136.1:8080/gme-web/api/v1/operation/replyWorkList.json",
		dataType: "json",
		data: "subjectId=" + workId + "&content=" + content + "&replyImgId=111" + "&type=1",
		success: function(data){
			if (data.code == 200) {
				window.location.href=window.location.href;
			}else {
				alert(data.message);
			}
		}
	})
}	


//我的工单详情
function myWorkListDetail(){
	var subjectId = '${subjectId}';
	
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/operation/listWorkOrderReply.json",
		dataType: "json",
		data: "subjectId=" + subjectId,
		success: function(data){
			if (data.code == 200) {
				var dataChar = data.data;
				var workId = dataChar.workId;
				var createTime = getFormatDateWithHours(dataChar.dateTime);
				var status = dataChar.status;
				$("#workId").text(workId);
				$("#createTime").text(createTime);
				if (status == 1) {
					status = "未处理";
				}
				if (status == 2) {
					status = "处理中";
				}
				if (status == 3) {
					status = "已处理";
				}
				$("#status").text(status);
				
				for (var i = 0; i < dataChar.length; i++) {
					var data = dataChar[i];
					var time = getFormatDateWithHours(data.time);
					// 是用户
					if (data.type == 1) {
							$("#boss").append('<div class="L_100_1"><img src="img/L_59.png" /><i class="L_100_1_a"></i><div id="a'+i+'" class="L_10086"><p>'+time+'</p><p>'+data.content+'</p></div></div><span>'+data.fromWho+'</span></div></div>');
							//$("#boss").append('<div class="L_100_1"><img src="img/L_59.png" /><img src="img/L_61.png" /><div class="L_10086"><p>'+time+'</p><p>'+data.content+'</p><img src="'+data.imgs[j]+'" /></div></div><span>'+data.fromWho+'</span></div></div>');
						if (data.imgs.length > 0) {
							for (var j = 0; j < data.imgs.length; j++) {
								$("#a"+i+"").append('<img src="'+data.imgs[j]+'" />');
							}
						}
					}
					// 是客服
					if (data.type == 2) {
						$("#boss").append('<div class="L_100_2"><img src="img/L_60.png" /><i class="L_100_2_a"></i><div id="b'+i+'" class="L_10087"><p>'+time+'</p><p>'+data.content+'</p></div></div><span>客服妹妹</span></div></div>');
						//$("#boss").append('<div class="L_100_2"><img src="img/L_60.png" /><img src="img/L_61.png" /><div class="L_10087"><p>'+time+'</p><p>'+data.content+'</p><img src="'+data.imgs[j]+'" /></div></div><span>'+data.fromWho+'</span></div></div>');
						if (data.imgs.length < 1) {
							for (var j = 0; j < data.imgs.length; j++) {
								$("#b"+i+"").append('<img src="'+data.imgs[j]+'" />');
							}
						}
					}
				}
				
				
			}
		}
		
	})
}

myWorkListDetail();