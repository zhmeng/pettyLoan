$(document).ready(function() {
	init();
});

/**
 * 数据初始化
 */
function init() {
}



/*function toUpdateCompany(companyID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/company/toUpdateCompany?companyID="
					+ companyID+"&modId="+modId, "",
					"dialogWidth=650px;dialogHeight=350px;status=no;help=no;scrollbars=no");
	lod();
}

*/
function passMessages(){
	if(confirm('确实批量审核吗?'))
	{ 
		var compnyName = $("#compnyName").val();
		var department = $("#department").val();
		var linkmn = $("#linkmn").val();
		var address = $("#address").val();
		var fmonily = $("#fmonily").val();
		var fstate = $("#fstate").val();
		var fbak1 = $("#fbak1").val();
		var basePath = $("#basePath").val();
		var data = {compnyName:compnyName,
				department:department,
				linkmn:linkmn,
				address:address,
				fmonily:fmonily,
				fstate:fstate,
				fbak1:fbak1
			};
		jQuery.ajax({
			type : "post", // 请求方式
			url : basePath + "action/fileNamesLog/examall", // Ajax访问地址
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
	/*var compnyName = $("#compnyName").val();
	var department = $("#department").val();
	var linkmn = $("#linkmn").val();
	var address = $("#address").val();
	var fmonily = $("#fmonily").val();
	var fstate = $("#fstate").val();
	var fbak1 = $("#fbak1").val();
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	var pf="1";
	var data = {modId:modId,
			department:department,
			linkmn:linkmn,
			address:address,
			fmonily:fmonily,
			fstate:fstate,
			fbak1:fbak1,
			compnyName:compnyName,
			pf:pf
			};
	$.post(basePath + "action/fileNamesLog/showFileNamesLog", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');*/
	document.getElementById("searchForm").submit();
}

function lookFilesLog(fid){
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/fileNamesLog/lookFilesLog?id="+fid, "",
	"dialogWidth=650px;dialogHeight=350px;status=no;help=no;scrollbars=no");
	lod();
}

function exam(fid,zt){
	var basePath = $("#basePath").val();
	var data = {id:fid,
				zt:zt
			};
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/fileNamesLog/exam", // Ajax访问地址
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


