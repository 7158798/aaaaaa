// 根据公告id查询公告详情
function queryNoticeDetail(noticeId){
	$.ajax({
		type: "GET",
		url: "http://192.168.136.1:8080/gme-web/api/v1/operation/getNoticeDetail.json",
		dataType: "json",
		data: "id=" + noticeId,
		success: function(data){
			if (data.code == 200){
				$("#content").html(data.data.content);
			}else {
				alert("查询公告详情:" + data.message);
			}
		}
	})
}

//根据公告id查询公告详情
var noticeId = $("#noticeId").val();
queryNoticeDetail(noticeId);