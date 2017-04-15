$(document).ready(function() {
	init();
});

/**
 * 数据初始化
 */
function init() {
}

// 删除部门
function delDept(deptID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	if (confirm("确定删除？")) {
		var data = {
			deptID : deptID,
			 modId : modId
		};
		jQuery.ajax({
			type : "post", // 请求方式
			url : basePath + "action/dept/delDept", // Ajax访问地址
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

function toAddDept() {
	var modId = $("#modId").val();
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/dept/toAddDept?modId="+modId,
					"dialogWidth=650px;dialogHeight=350px;status=no;help=no;scrollbars=no");
	lod();
};

// 添加部门
function addDept() {
	var basePath = $("#basePath").val();
	var deptName = $('#deptName').val();
	var deptState = $('#deptState').val();      // 上级部门ID
	
	
	if (deptName == "" || deptName == null) {
		alert("请填写部门名称");
		return;
	}

	var param = {};
	param["deptName"] = deptName;
	param["deptState"] = deptState;
	
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/dept/addDept", // Ajax访问地址
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

function toUpdateDept(deptID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/dept/toUpdateDept?deptID="
					+ deptID+"&modId="+modId, "",
					"dialogWidth=650px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	lod();
}

// 修改部门
function updateDept() {
	var basePath = $("#basePath").val();
	var deptID = $('#deptID').val();
	var deptName = $('#deptName').val();
	/*var parentDeptID = $('#deptID').val();      // 上级部门ID
	var deptMG = $('#deptMG').val();
	var deptMGTel = $('#deptMGTel').val();
	var deptTel = $('#deptTel').val();
	var deptFax = $('#deptFax').val();
	var deptAddr = $('#deptAddr').val();
	var deptPost = $('#deptPost').val();
	var deptState = $('#deptState').val();
	var deptBranchID = $('#deptBranchID').val();
	var deptFlag = $('#deptFlag').val();
	var deptIsBR = $('#deptIsBR').val();
	var deptIsCR = $('#deptIsCR').val();
	var deptIsCS = $('#deptIsCS').val();
	var deptDesc = $('#deptDesc').val();*/
	
	if (deptName == "" || deptName == null) {
		alert("请填写部门名称");
		return;
	}

	var param = {
		deptID : deptID,
		deptName : deptName
		/*parentDeptID : parentDeptID,
		deptMG : deptMG,
		deptMGTel : deptMGTel,
		deptTel : deptTel,
		deptFax : deptFax,
		deptAddr : deptAddr,
		deptPost : deptPost,
		deptState : deptState,
		deptBranchID : deptBranchID,
		deptFlag : deptFlag,
		deptIsBR : deptIsBR,
		deptIsCR : deptIsCR,
		deptIsCS : deptIsCS,
		deptDesc : deptDesc*/
	};

	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/dept/updateDept", // Ajax访问地址
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

function lod() {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	var data = {}
	$.post(basePath + "action/dept/goDeptList?modId="+modId, data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}