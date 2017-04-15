$(document).ready(function() {
	init();
});

/**
 * 数据初始化
 */
function init() {
}

// 删除开发商
function delCompany(companyID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	if (confirm("确定删除？")) {
		var data = {
			companyID : companyID,
			modId:modId
			
		};
		jQuery.ajax({
			type : "post", // 请求方式
			url : basePath + "action/company/delCompany", // Ajax访问地址
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

function toAddCompany() {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/company/toAddCompany?modId="+modId, "",
					"dialogWidth=650px;dialogHeight=350px;status=no;help=no;scrollbars=no");
	lod();
};

// 添加开发商
function addCompany() {
	var basePath = $("#basePath").val();
	var companyKey = $('#companyKey').val();
	var companyName = $('#companyName').val();
	var companyState = $('#companyState').val();
	var companyFName = $('#companyFName').val();
	var companyFTel = $('#companyFTel').val();
	var companyBankNameA = $('#companyBankNameA').val();
	var companyAccoutA = $('#companyAccoutA').val();
	var companyBankNameB = $('#companyBankNameB').val();
	var companyAccoutB = $('#companyAccoutB').val();
	var delayCostRate = $('#delayCostRate').val();
	var delayInterestRate = $('#delayInterestRate').val();

	if (companyKey == "" || companyKey == null) {
		alert("请填写开发商编号");
		return;
	}
	if (companyName == "" || companyName == null) {
		alert("请填写开发商名称");
		return;
	}
	if (companyFName == "" || companyFName == null) {
		alert("请填写法人姓名");
		return;
	}
	if (companyFTel == "" || companyFTel == null) {
		alert("请填写法人电话");
		return;
	}
	if (companyBankNameA == "" || companyBankNameA == null) {
		alert("请填写银行名称A");
		return;
	}
	if (companyAccoutA == "" || companyAccoutA == null) {
		alert("请填写银行帐号A");
		return;
	}

	var param = {};
	param["companyKey"] = companyKey;
	param["companyName"] = companyName;
	param["companyState"] = companyState;
	param["companyFName"] = companyFName;
	param["companyFTel"] = companyFTel;
	param["companyBankNameA"] = companyBankNameA;
	param["companyAccoutA"] = companyAccoutA;
	param["companyBankNameB"] = companyBankNameB;
	param["companyAccoutB"] = companyAccoutB;
	param["delayCostRate"] = delayCostRate;
	param["delayInterestRate"] = delayInterestRate;

	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/company/addCompany", // Ajax访问地址
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

function toUpdateCompany(companyID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/company/toUpdateCompany?companyID="
					+ companyID+"&modId="+modId, "",
					"dialogWidth=650px;dialogHeight=350px;status=no;help=no;scrollbars=no");
	lod();
}

function updateCompany() {
	var companyID = $("#companyID").val();
	var basePath = $("#basePath").val();
	var companyKey = $('#companyKey').val();
	var companyName = $('#companyName').val();
	var companyState = $('#companyState').val();
	var companyFName = $('#companyFName').val();
	var companyFTel = $('#companyFTel').val();
	var companyBankNameA = $('#companyBankNameA').val();
	var companyAccoutA = $('#companyAccoutA').val();
	var companyBankNameB = $('#companyBankNameB').val();
	var companyAccoutB = $('#companyAccoutB').val();
	var delayCostRate = $('#delayCostRate').val();
	var delayInterestRate = $('#delayInterestRate').val();

	if (companyKey == "" || companyKey == null) {
		alert("请填写开发商编号");
		return;
	}
	if (companyName == "" || companyName == null) {
		alert("请填写开发商名称");
		return;
	}
	if (companyFName == "" || companyFName == null) {
		alert("请填写法人姓名");
		return;
	}
	if (companyFTel == "" || companyFTel == null) {
		alert("请填写法人电话");
		return;
	}
	if (companyBankNameA == "" || companyBankNameA == null) {
		alert("请填写银行名称A");
		return;
	}
	if (companyAccoutA == "" || companyAccoutA == null) {
		alert("请填写银行帐号A");
		return;
	}

	var param = {
		companyID : companyID,
		companyKey : companyKey,
		companyName : companyName,
		companyState : companyState,
		companyFName : companyFName,
		companyFTel : companyFTel,
		companyBankNameA : companyBankNameA,
		companyAccoutA : companyAccoutA,
		companyBankNameB : companyBankNameB,
		companyAccoutB : companyAccoutB,
		delayCostRate : delayCostRate,
		delayInterestRate : delayInterestRate
	};

	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/company/updateCompany", // Ajax访问地址
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
	$.post(basePath + "action/company/goCompanyList", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}
