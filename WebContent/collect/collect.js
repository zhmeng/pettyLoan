$(document).ready(function() {
	init();
});

/**
 * 数据初始化
 */
function init() {
	
}




function toConfCollectapplyLoan(applyID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/collect/toConfCollectapplyLoan?applyID="
					+ applyID+"&modId="+modId, "",
					"dialogWidth=650px;dialogHeight=350px;status=no;help=no;scrollbars=no");
	lod();
}

function lod() {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	var data = {modId:modId};
	$.post(basePath + "action/collect/goCollectList", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}
