$(document).ready(function() {
	init();
});

/**
 * 数据初始化
 */
function init() {
}

/**
 * 跳到添加角色页面
 * 
 */
function toaddbuscontract(){
	var modId = $("#modId").val();
	var basePath = $("#basePath").val();
	var someValue=window.showModalDialog(basePath+"action/role/toAddRole?modId="+modId,"","dialogWidth=530px;dialogHeight=590px;status=no;help=no;scrollbars=no");
	lod();
	
};
function add_contract() {
	var basePath = $("#basePath").val();
	var RoleName = $('#RoleName').val();
	var RoleState =$('#RoleState').val(); //定位id
	var RoleAddTime = $('#RoleAddTime').val();
	
	if(RoleName == ""|| RoleName==null){
		alert("请填写角色名称");
		return;
	}if(RoleName.length>20){
		alert("角色名称输入过长,请重新输入");
		return;
	}
	/* if ($("#RoleState").find("option:selected").attr("value")<="0") {
		alert("请选择网点");
		return;
	} */
	
	var param = {};
	param["RoleName"] = RoleName;
	param["RoleState"] = RoleState;
	
	// 加载渠道管理用户
	
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath+"action/role/AddRole", // Ajax访问地址
		data : param, // 参数
		dataType : "json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert("保存异常");
		},
		success : function(data) { // 返回成功时运行，主要接受结果
			if(data.success){
				alert(data.msg);
				window.close();
			}else{
				alert('保存异常2');
			}
		}
	}); 
}
/*
 * 删除楼盘
 */
function delRole(roleId) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	if (confirm("确定删除？")) {
		var data = {
			roleId : roleId,
			modId  :modId
		};

		jQuery.ajax({
			type : "post", // 请求方式
			url : basePath+"action/role/deleRole", // Ajax访问地址
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


function updateRole(roleId){
	var modId = $("#modId").val();
	var basePath = $("#basePath").val();
	var someValue=window.showModalDialog(basePath+"action/role/toUpdateRole?roleId="+roleId+"&modId="+modId,"","dialogWidth=500px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	lod();
}

function save_contract(){
	var basePath = $("#basePath").val();
	var roleId = $.trim($('#roleId').val());
	var roleName=$.trim($('#roleName').val());
	var roleState=$.trim($('#roleState').val());
	
	var data = {
			roleId:roleId,
			roleName:roleName,
			roleState:roleState
	}; 
	// 加载渠道管理用户
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath+"action/role/UpdateRoles", // Ajax访问地址
		data : data, // 参数
		dataType : "json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert("保存异常");
		}, 
		success : function(data) { // 返回成功时运行，主要接受结果
			if(data.success){
				alert(data.msg);
				parent.window.returnValue=data.msg; //父窗口就是上一个页面
				//window.location.href=basePath + "action/dept/goDept";
				 window.close();
			}else{
				alert('保存异常2');
			}
		}
	});
}
function lod() {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	var data = {
			modId:modId
	};
	$.opst(basePath + "action/role/goRoleList", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}



