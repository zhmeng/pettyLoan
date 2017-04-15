function updateUser(userId){
	var basePath = $("#basePath").val();
	var modId=$("#modId").val();
	var someValue=window.showModalDialog(basePath+"sysUser/toUpdateUser?userId="+userId+"&modId="+modId,"","dialogWidth=500px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	lod();
	
}
/*function addDep(){
	alert("as");
	$.dialog({
		title : '增加员工',
		max : false,
		min : false,
		width : '940px',
		height : '600px',
		zIndex : 99991,
		content : 'url:sysUser/user_add.jsp'	
	});
	window.showModalDialog("SYS/SysUser/user_add.jsp",json,'dialogWidth=800px;dialogHeight=500px;');
}*/
function addUser(){
	var basePath = $("#basePath").val();
	var modId=$("#modId").val();
	var someValue=window.showModalDialog(basePath+"sysUser/toAddUser?modId="+modId,"","dialogWidth=650px;dialogHeight=730px;status=no;help=no;scrollbars=no");
	
	
};
function query(userID){
	$("#searchForm").submit();
}
function chush(userID){
	var basePath = $("#basePath").val();
	if (confirm("确定初始化密码？")) {
		var data = {
			userID : userID
		};
		jQuery.ajax({
			type : "post", // 请求方式
			url : basePath+"sysUser/chushUser", // Ajax访问地址
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


function delUser(userID) {
	var basePath = $("#basePath").val();
	var modId=$("#modId").val();
	if (confirm("确定删除？")) {
		var data = {
				userID : userID,
				modId:modId
		};

		jQuery.ajax({
			type : "post", // 请求方式
			url : basePath+"sysUser/deleUser", // Ajax访问地址
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

function toaddbuscontract(){
	var basePath = $("#basePath").val();
	var modId=$("#modId").val();
	var someValue=window.showModalDialog(basePath+"sysUser/toAddUser?modId="+modId,"","dialogWidth=530px;dialogHeight=590px;status=no;help=no;scrollbars=no");
	lod();
}

function lod() {
	var basePath = $("#basePath").val();
	var modId=$("#modId").val();
	var data = {
			modId:modId
	}
	$.post(basePath + "sysUser/showUser", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}