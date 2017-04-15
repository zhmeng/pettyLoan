$(document).ready(function() {
	init();
	search_warn();
});

/**
 * 数据初始化
 */
function init() {
}
/**
 * 条件查询信息
 */

function search_warn() {
	 goPage(0);
};

// 分页
function goPage(x) {
	var PostName = $('#PostName').val();// 机构编号
	var PostIsDept = $('#PostIsDept').val();// 部门名称
	var data = {
		curPage : x,
		PostName : PostName,
		PostIsDept : PostIsDept
	};
	$.post("action/post/PostList", data, function(data) {
		$("#tb_post_div").html(data);
		}, 'html');
};

/**
 * 跳到添加公司职位页面
 * 
 */
function toaddbuscontract(){
	$.dialog({
		title: '添加公司职位信息',
		max : false,
		min : false,
		width : '800px',
		height : '350px',
		zIndex : 99991,
	    content: 'url:action/post/toAddPost',
	});
	
};
/*
 * 删除部门信息
 */
function delPost(DeptID) {
	if (confirm("确定删除？")) {
		var data = {
			DeptID : DeptID
		};

		jQuery.ajax({
			type : "post", // 请求方式
			url : "action/post/delePost", // Ajax访问地址
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

function lod() {
	var data = {
	}
	$.post("action/post/PostList", data, function(data) {
		$('#tb_post_div').html(data);
	});
}


