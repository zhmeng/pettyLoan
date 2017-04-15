$(document).ready(function() {
	init();
});

/**
 * 数据初始化
 */
function init() {
}
/**
 * 条件查询信息
 */

/**
 * 跳到添加楼盘页面
 * 
 */
function toaddbuscontract(){
	var basePath = $("#basePath").val();
	var someValue=window.showModalDialog(basePath+"action/city/toAddCity","","dialogWidth=530px;dialogHeight=590px;status=no;help=no;scrollbars=no");
	lod();
	
};
function add_contract() {
	var basePath = $("#basePath").val();
	var areaName = $('#areaName').val();
	var cityID = $('#cityID').val();
	var cityState = $('#cityState').val();
	var cityName =$('#cityName').val(); //定位id
	
	if ($("#areaName").find("option:selected").attr("value")=="0") {
		alert("请选择区域");
		return;
	}
	if(cityID == ""|| cityID==null){
		alert("请填写城市ID");
		return;
	}
	if(cityName == ""|| cityName==null){
		alert("请选择城市名称");
		return;
	}
	
	var param = {};
	param["areaName"] = areaName;
	param["cityID"] = cityID;
	param["cityName"] = cityName;
	param["cityState"] = cityState;
	
	// 加载渠道管理用户
	
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath+"action/city/AddCity", // Ajax访问地址
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
 * 删除城市
 */
function delCity(cityID) {
	var basePath = $("#basePath").val();
	if (confirm("确定删除？")) {
		var data = {
				cityID : cityID
		};

		jQuery.ajax({
			type : "post", // 请求方式
			url : basePath+"action/city/deleCity", // Ajax访问地址
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


function updateCity(cityID){
	var basePath = $("#basePath").val();
	var someValue=window.showModalDialog(basePath+"action/city/toUpdateCity?cityID="+cityID,"","dialogWidth=500px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	lod();
}

function save_contract(){
	var basePath = $("#basePath").val();
	var cityName = $.trim($('#cityName').val());
	var cityID=$.trim($('#cityID').val());
	var data = {
			cityName:cityName,
			cityID:cityID,
	}; 
	// 加载渠道管理用户
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath+"action/city/UpdateCity", // Ajax访问地址
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
	var data = {
	}
	$.post(basePath + "action/city/goCityList", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}



