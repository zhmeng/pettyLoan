$(document).ready(function() {
	init();
});

/**
 * 数据初始化
 */
function init() {
}

// 删除楼盘
function delComLp(lpID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	if (confirm("确定删除？")) {
		var data = {
			lpID : lpID,
			modId:modId
		};
		jQuery.ajax({
			type : "post", // 请求方式
			url : basePath + "action/comLp/delComLp", // Ajax访问地址
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

function toAddComLp() {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/comLp/toAddComLp?modId"+modId, "",
					"dialogWidth=650px;dialogHeight=350px;status=no;help=no;scrollbars=no");
	lod();
};

// 添加楼盘
function addComLp() {
	var basePath = $("#basePath").val();
	var lpKey = $('#lpKey').val();
	var lpName = $('#lpName').val();
	var lpGM = $('#lpGM').val();
	var lpTel = $('#lpTel').val();
	var lpState = $('#lpState').val();
	var lpAddr = $('#lpAddr').val();
	var cityID = $('#cityID').val();
	var companyID = $('#companyID').val();

	if (lpKey == "" || lpKey == null) {
		alert("请填写楼盘编号");
		return;
	}
	if (lpName == "" || lpName == null) {
		alert("请填写楼盘名称");
		return;
	}
	if (lpGM == "" || lpGM == null) {
		alert("请填写负责人姓名");
		return;
	}
	if (lpTel == "" || lpTel == null) {
		alert("请填写负责人电话");
		return;
	}
	if (lpAddr == "" || lpAddr == null) {
		alert("请填写楼盘地址");
		return;
	}

	var param = {};
	param["lpKey"] = lpKey;
	param["lpName"] = lpName;
	param["lpGM"] = lpGM;
	param["lpTel"] = lpTel;
	param["lpAddr"] = lpAddr;
	param["lpState"] = lpState;
	param["cityID"] = cityID;
	param["companyID"] = companyID;

	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/comLp/addComLp", // Ajax访问地址
		data : param, // 参数
		dataType : "json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert("保存异常");
		},
		success : function(data) { // 返回成功时运行，主要接受结果
			if (data.success) {
				alert(data.msg);
				window.close();
			} else {
				alert('保存异常');
			}
		}
	});
}

function toUpdateComLp(lpID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/comLp/toUpdateComLp?lpID="
					+ lpID+"&modId="+modId, "",
					"dialogWidth=650px;dialogHeight=350px;status=no;help=no;scrollbars=no");
	lod();
}

function updateComLp() {
	var lpID = $("#lpID").val();
	var basePath = $("#basePath").val();
	var lpKey = $('#lpKey').val();
	var lpName = $('#lpName').val();
	var lpState = $('#lpState').val();
	var lpGM = $('#lpGM').val();
	var lpTel = $('#lpTel').val();
	var lpAddr = $('#lpAddr').val();
	var cityID = $('#cityID').val();
	var companyID = $('#companyID').val();
	
	if (lpKey == "" || lpKey == null) {
		alert("请填写楼盘编号");
		return;
	}
	if (lpName == "" || lpName == null) {
		alert("请填写楼盘名称");
		return;
	}
	if (lpGM == "" || lpGM == null) {
		alert("请填写负责人姓名");
		return;
	}
	if (lpTel == "" || lpTel == null) {
		alert("请填写负责人电话");
		return;
	}
	if (lpAddr == "" || lpAddr == null) {
		alert("请填写楼盘地址");
		return;
	}

	var param = {
		lpID : lpID,
		lpKey : lpKey,
		lpName : lpName,
		lpState : lpState,
		lpGM : lpGM,
		lpTel : lpTel,
		lpAddr : lpAddr,
		cityID : cityID,
		companyID : companyID
	};

	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/comLp/updateComLp", // Ajax访问地址
		data : param, // 参数
		dataType : "json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert("保存异常");
		},
		success : function(data) { // 返回成功时运行，主要接受结果
			if (data.success) {
				alert(data.msg);
				parent.window.returnValue = data.msg; // 父窗口就是上一个页面
				window.close();
			} else {
				alert('保存异常');
			}
		}
	});
}

function lod() {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	var data = {modId:modId};
	$.post(basePath + "action/comLp/goComLpList", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}
