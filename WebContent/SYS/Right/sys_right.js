$(document).ready(function() {
	init();
	$("#roleRight").hide();
	$("#userRight").hide();
});

/**
 * 数据初始化
 */
function init() {
}

function toRight(rights){
	var basePath = $("#basePath").val();
	window.location.href=basePath+"action/right/gosRights?rights="+rights;
}


/**
 * 跳到添加角色权限设置页面
 * 
 */
function roleRight(RoleID){
	var basePath = $("#basePath").val();
	var someValue=window.showModalDialog(basePath+"action/right/roleRight?RoleID="+RoleID+"&rpd=2","","dialogWidth=892px;dialogHeight=663px;status=no;help=no;scrollbars=no");
	
	//lod();
	//window.close();
};

/**
 * 跳到添加个人权限设置页面
 * 
 */
function userRight(UserID){
	var basePath = $("#basePath").val();
	var someValue=window.showModalDialog(basePath+"action/right/roleRight?UserID="+UserID+"&rpd=1","","dialogWidth=892px;dialogHeight=663px;status=no;help=no;scrollbars=no");
	//window.close();
	//lod();
	
};


function lod() {
	var basePath = $("#basePath").val();
	var data = {
	}
	$.post(basePath + "action/right/goRight", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}



