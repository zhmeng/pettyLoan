$(document).ready(function() {
	init();
});

/**
 * 数据初始化
 */
function init() {
	
}

function lod() {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	var data = {modId:modId};
	$.post(basePath + "action/collect/goCollectList", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}
