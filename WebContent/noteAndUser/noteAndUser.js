$(document).ready(function() {
	init();
});

/**
 * 数据初始化
 */
function init() {
}


function toAdd() {
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/noteAndUser/toAdd", "",
					"dialogWidth=650px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	lod();
};

function del(id) {
	var basePath = $("#basePath").val();
	if (confirm("确定删除？")) {
		var data = {
			id : id,
		};
		jQuery.ajax({
			type : "post", // 请求方式
			url : basePath + "action/noteAndUser/delete", // Ajax访问地址
			data : data, // 参数
			dataType : "json", // 指定返回数据类型
			error : function() { // 出现错误时运行
				alert("出错了");
			},
			success : function(data) { // 返回成功时运行，主要接受结果
				if (data.success) {
					alert(data.msg);
					lod();
					return;
				}
				alert("出错了");
			}
		});
	}
}

function lod() {
	var basePath = $("#basePath").val();
	var data = {};
	$.post(basePath + "action/noteAndUser/goNoteAndUserList", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}