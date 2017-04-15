$(document).ready(function() {
	init();
});

/**
 * 数据初始化
 */
function init() {
}

/*
 * 删除产品
 */
function delProduct(productID) {
	var basePath = $("#basePath").val();
	if (confirm("确定删除？")) {
		var data = {
			productID : productID
		};
		jQuery.ajax({
			type : "post", // 请求方式
			url : basePath + "action/product/delProduct", // Ajax访问地址
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

function toAddProduct() {
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/product/toAddProduct", "",
					"dialogWidth=650px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	lod();
};

/*
 * 添加产品
 */
function addProduct() {
	var basePath = $("#basePath").val();
	var productKey = $('#productKey').val();
	var productName = $('#productName').val();
	var productFlag = $('#productFlag').val();
	var productDesc = $('#productDesc').val();
	var productValSTime = $('#productValSTime').val();
	var productValETime = $('#productValETime').val();
	var productPayment = $('#productPayment').val();
	var productLoanRate = $('#productLoanRate').val();
	var productFeesRate = $('#productFeesRate').val();

	if (productKey == "" || productKey == null) {
		alert("请填写产品编号");
		return;
	}
	if (productName == "" || productName == null) {
		alert("请填写产品名称");
		return;
	}
	if (productDesc == "" || productDesc == null) {
		alert("请填写产品描述");
		return;
	}
	if (productValSTime == "" || productValSTime == null) {
		alert("请填写有效期开始时间");
		return;
	}
	if (productLoanRate == "" || productLoanRate == null) {
		alert("请填写财务顾问费");
		return;
	}
	if (productFeesRate == "" || productFeesRate == null) {
		alert("请填写手续费率");
		return;
	}

	var param = {};
	param["productKey"] = productKey;
	param["productName"] = productName;
	param["productFlag"] = productFlag;
	param["productDesc"] = productDesc;
	param["productValSTime"] = productValSTime;
	param["productValETime"] = productValETime;
	param["productPayment"] = productPayment;
	param["productLoanRate"] = productLoanRate;
	param["productFeesRate"] = productFeesRate;

	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/product/addProduct", // Ajax访问地址
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

function toUpdateProduct(productID) {
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/product/toUpdateProduct?productID="
					+ productID, "",
					"dialogWidth=650px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	lod();
}

function updateProduct() {
	var productID = $("#productID").val();
	var basePath = $("#basePath").val();
	var productKey = $('#productKey').val();
	var productName = $('#productName').val();
	var productFlag = $('#productFlag').val();
	var productDesc = $('#productDesc').val();
	var productValSTime = $('#productValSTime').val();
	var productValETime = $('#productValETime').val();
	var productPayment = $('#productPayment').val();
	var productLoanRate = $('#productLoanRate').val();
	var productFeesRate = $('#productFeesRate').val();

	if (productKey == "" || productKey == null) {
		alert("请填写产品编号");
		return;
	}
	if (productName == "" || productName == null) {
		alert("请填写产品名称");
		return;
	}
	if (productDesc == "" || productDesc == null) {
		alert("请填写产品描述");
		return;
	}
	if (productValSTime == "" || productValSTime == null) {
		alert("请填写有效期开始时间");
		return;
	}
	if (productLoanRate == "" || productLoanRate == null) {
		alert("请填写财务顾问费");
		return;
	}
	if (productFeesRate == "" || productFeesRate == null) {
		alert("请填写手续费率");
		return;
	}

	var param = {
		productID : productID,
		productKey : productKey,
		productName : productName,
		productFlag : productFlag,
		productDesc : productDesc,
		productValSTime : productValSTime,
		productValETime : productValETime,
		productPayment : productPayment,
		productLoanRate : productLoanRate,
		productFeesRate : productFeesRate
	};

	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/product/updateProduct", // Ajax访问地址
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
	var data = {}
	$.post(basePath + "action/product/goProductList", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}


