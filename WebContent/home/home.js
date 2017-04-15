function updateAdmin(){
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "home/updateAdmin.jsp", "",
					"dialogWidth=700px;dialogHeight=400px;status=no;help=no;scrollbars=no");
}

function updatePassword(){
	var basePath = $("#basePath").val();
	var ypassword=$("#ypassword").val();
	var xpassword=$("#xpassword").val();
	var qpassword=$("#qpassword").val();
	if(xpassword!=qpassword){
		alert("密码前后不一致");
		return;
	}
	if(xpassword==""){
		alert("密码不能为空");
		return;
	}
	var param = {};
	param["ypassword"] = ypassword;
	param["xpassword"] = xpassword;
	param["qpassword"] = qpassword;
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "sysUser/updatePassword", // Ajax访问地址
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
				alert(data.msg);
			}
		}
	});
}


