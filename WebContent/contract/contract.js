$(document).ready(function() {
	init();
});

/**
 * 数据初始化
 */
function init() {
}

function toAddContract(applyID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
		window.showModalDialog(basePath + "action/contract/toAddContract?applyID="
				+ applyID+"&modId="+modId, "",
				"dialogWidth=650px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	lod();
};

/*
 * 新增合同
 */
function addContract() {	
	var basePath = $("#basePath").val();
//	var contractName = $('#contractName').val();
	var bankName = $('#bankName').val();
	var bankAccount = $('#bankAccount').val();
	var bankMan = $('#bankMan').val();
//	var delayCostRate = $('#delayCostRate').val();
//	var delayInterestRate = $('#delayInterestRate').val();
	var applyID = $('#applyID').val();
	var remark = $('#remark').val();
	var startInterestDate = $('#startInterestDate').val();
//	if (contractName == "" || contractName == null) {
//		alert("请填写合同名称");
//		return;
//	}		
	var subCont=$("#hidSubCon").val();
	if(subCont!="yes"){
		$("#hidSubCon").val("yes");
		var param = {};
//		param["contractName"] = contractName;
		param["bankName"] = bankName;
		param["bankAccount"] = bankAccount;
		param["bankMan"] = bankMan;
//		param["delayCostRate"] = delayCostRate;
//		param["delayInterestRate"] = delayInterestRate;
		param["applyID"] = applyID;
		param["remark"] = remark;
		param["startInterestDate"] = startInterestDate;
		jQuery.ajax({
			type : "post", // 请求方式
			url : basePath + "action/contract/addContract", // Ajax访问地址
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
	}else{
		alert("亲！您点次数太多了！");
	}	
}

function lod() {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	var data = {modId:modId};
	$.post(basePath + "action/contract/goContractList", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}

function toRetrialContract(applyID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/contract/toRetrialContract?applyID="
					+ applyID+"&modId="+modId, "",
					"dialogWidth=650px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	lod();
}

function toUploadFile(applyID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/contract/toUploadFile?applyID="
					+ applyID+"&modId="+modId, "",
					"dialogWidth=650px;dialogHeight=300px;status=no;help=no;scrollbars=no");
	lod();
}




function toSignedContract(applyID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/contract/toSignedContract?applyID="
					+ applyID+"&modId="+modId, "",
					"dialogWidth=650px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	lod();
}

function signedContract() {
	var basePath = $("#basePath").val();
	var contractID = $("#contractID").val();
	var modId = $("#modId").val();
	var chksignDate = $('#chksignDate').val();

	if (chksignDate == "" || chksignDate == null) {
		alert("请填写签订日期");
		return;
	}

	var param = {
		contractID : contractID,
		chksignDate : chksignDate,
		modId : modId
	};

	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/contract/signedContract", // Ajax访问地址
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

function retrialContract() {
	var basePath = $("#basePath").val();
	var contractID = $("#contractID").val();
	var param = {
		contractID : contractID
	};
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/contract/retrialContract", // Ajax访问地址
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

function downloadFile(id) {
	var modId = $("#modId").val();
	location.href = $("#basePath").val() + "action/contract/download?imgID="+id+"&modId="+modId;
}

// contract template
function toUploadContractTemplate() {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/contract/toUploadContractTemplate?modId="+modId, "",
					"dialogWidth=650px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	queryTemplateList();
};

function deleteFile(imgID) {
	var modId = $("#modId").val();
	var basePath = $("#basePath").val();
	var param = {
			imgID : imgID,
			modId:modId
	};
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/contract/delContractTemplate", // Ajax访问地址
		data : param, // 参数
		dataType : "json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert("删除成功！");
			queryTemplateList();
		},
		success : function(data) { // 返回成功时运行，主要接受结果
			if (data.success) {
				alert(data.msg);
			} else {
				alert('删除成功！');
			}
		}
	});
}

function queryTemplateList() {
	var basePath = $("#basePath").val();
	var data = {};
	$.post(basePath + "action/contract/goContractTemplateList", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}

function toPrint(id, applyID) {
	var basePath = $("#basePath").val();
	window.open(basePath + "action/contract/toPrint?id=" + id
					+ "&applyID=" + applyID, "",
					"");
	lod();
}

function toPrintRecord(applyCode) {
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/contract/toPrintRecord?applyCode="
					+ applyCode, "",
					"dialogWidth=750px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	lod();
}