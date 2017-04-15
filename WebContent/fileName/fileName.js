$(document).ready(function() {
	init();
});

/**
 * 数据初始化
 */
function init() {
}


function toAddfileName() {
	
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/fileNames/toAddfileName?modId"+modId, "",
					"dialogWidth=700px;dialogHeight=400px;status=no;help=no;scrollbars=no");
	lod();
};

// 添加开发商
function addFiles() {
	var areas=new Array("福田区","罗湖区","盐田区","南山区","宝安区","龙岗区","龙华区","坪山区","光明新区","大鹏新区");
	var basePath = $("#basePath").val();
	var zipCode = $("#zipCode").val();
	var areaValue=$("#area").val();
	var area=areas[areaValue];
    var stree=$("#stree").val();
	var address = "广东省深圳市"+area+stree+$('#address').val();
	var compnyName = $('#compnyName').val();
	var department = $('#department').val();
	var linkmn = $('#linkmn').val();
	var sex = $('#sex').val();
	var post = $('#post').val();
	var officePhone = $('#officePhone').val();
	var phone = $('#phone').val();
	var qq = $('#qq').val();
	var email = $('#email').val();
	var fimallyPhone = $('#fimallyPhone').val();
	
	var birthday = $('#birthday').val();
	var url = $('url').val();
	var pid = $('#pid').val();
	var compClass = $('#compClass').val();
	var remark = $('#remark').val();

	if (compnyName == "" || compnyName == null) {
		alert("请填写公司名称");
		return;
	}
	if (linkmn == "" || linkmn == null) {
		alert("请填写联系人");
		return;
	}
	if (officePhone == "" || officePhone == null) {
		alert("请填写办公号码");
		return;
	}
	

	var param = {};
	param["zipCode"] = zipCode;
	param["address"] = address;
	param["compnyName"] = compnyName;
	param["department"] = department;
	param["linkmn"] = linkmn;
	param["sex"] = sex;
	param["post"] = post;
	param["officePhone"] = officePhone;
	param["phone"] = phone;
	param["qq"] = qq;
	param["email"] = email;
	param["fimallyPhone"] = fimallyPhone;
	param["birthday"] = birthday;
	param["pid"] = pid;
	param["compClass"] = compClass;
	param["url"] = url;
	param["remark"] = remark;
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/fileNames/addfileName", // Ajax访问地址
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

/*function toUpdateCompany(companyID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	window.showModalDialog(basePath + "action/company/Company?companyID="
					+ companyID+"&modId="+modId, "",
					"dialogWidth=650px;dialogHeight=350px;status=no;help=no;scrollbars=no");
	lod();
}

*/

function lod() {
	document.getElementById("searchForm").submit();
}

function lookFiles(fid){
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/fileNames/lookFiles?id="+fid, "",
	"dialogWidth=700px;dialogHeight=350px;status=no;help=no;scrollbars=no");
	
}

function toUpdate(fid){
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/fileNames/toUpdate?id="+fid, "",
	"dialogWidth=750px;dialogHeight=450px;status=no;help=no;scrollbars=no");
	lod();
}
function toUpdate2(fid){
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/fileNames/toUpdate2?id="+fid, "",
	"dialogWidth=750px;dialogHeight=450px;status=no;help=no;scrollbars=no");
	lod();
}

function updateFiles(){
	/*var areas=new Array("福田区","罗湖区","盐田区","南山区","宝安区","龙岗区","龙华区","坪山区","光明新区","大鹏新区");*/
	var id = $("#id").val();
	var basePath = $("#basePath").val();
	var zipCode = $("#zipCode").val();
	/*var areaValue=$("#area").val();
	var area=areas[areaValue];
    var stree=$("#stree").val();*/
	var address = $('#address').val();
	var compnyName = $('#compnyName').val();
	var department = $('#department').val();
	var linkmn = $('#linkmn').val();
	var sex = $('#sex').val();
	var post = $('#post').val();
	var officePhone = $('#officePhone').val();
	var phone = $('#phone').val();
	var qq = $('#qq').val();
	var email = $('#email').val();
	var fimallyPhone = $('#fimallyPhone').val();
	
	var birthday = $('#birthday').val();
	var url = $('url').val();
	var pid = $('#pid').val();
	var remark = $('#remark').val();
	var compClass = $('#compClass').val();

	if (compnyName == "" || compnyName == null) {
		alert("请填写公司名称");
		return;
	}
	if (linkmn == "" || linkmn == null) {
		alert("请填写联系人");
		return;
	}
	if (officePhone == "" || officePhone == null) {
		alert("请填写办公号码");
		return;
	}
	

	var param = {};
	param["id"] = id;
	param["zipCode"] = zipCode;
	param["address"] = address;
	param["compnyName"] = compnyName;
	param["department"] = department;
	param["linkmn"] = linkmn;
	param["sex"] = sex;
	param["post"] = post;
	param["officePhone"] = officePhone;
	param["phone"] = phone;
	param["qq"] = qq;
	param["email"] = email;
	param["fimallyPhone"] = fimallyPhone;
	param["birthday"] = birthday;
	param["pid"] = pid;
	param["compClass"] = compClass;
	param["url"] = url;
	param["remark"] = remark;
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/fileNames/updateFiles", // Ajax访问地址
		data : param, // 参数
		dataType : "json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert("修改异常");
		},
		success : function(data) { // 返回成功时运行，主要接受结果
			if (data.success) {
				alert(data.msg);
				window.close();
			} else {
				alert('修改异常');
			}
		}
	});
}

function updateFiles2(){
	/*var areas=new Array("福田区","罗湖区","盐田区","南山区","宝安区","龙岗区","龙华区","坪山区","光明新区","大鹏新区");*/
	var id = $("#id").val();
	var basePath = $("#basePath").val();
	var zipCode = $("#zipCode").val();
	/*var areaValue=$("#area").val();
	var area=areas[areaValue];
    var stree=$("#stree").val();*/
	var address = $('#address').val();
	var compnyName = $('#compnyName').val();
	var department = $('#department').val();
	var linkmn = $('#linkmn').val();
	var sex = $('#sex').val();
	var post = $('#post').val();
	var officePhone = $('#officePhone').val();
	var phone = $('#phone').val();
	var qq = $('#qq').val();
	var email = $('#email').val();
	var fimallyPhone = $('#fimallyPhone').val();
	
	var birthday = $('#birthday').val();
	var url = $('url').val();
	var pid = $('#pid').val();
	var remark = $('#remark').val();
	var compClass = $('#compClass').val();

	if (compnyName == "" || compnyName == null) {
		alert("请填写公司名称");
		return;
	}
	if (linkmn == "" || linkmn == null) {
		alert("请填写联系人");
		return;
	}
	if (officePhone == "" || officePhone == null) {
		alert("请填写办公号码");
		return;
	}
	

	var param = {};
	param["id"] = id;
	param["zipCode"] = zipCode;
	param["address"] = address;
	param["compnyName"] = compnyName;
	param["department"] = department;
	param["linkmn"] = linkmn;
	param["sex"] = sex;
	param["post"] = post;
	param["officePhone"] = officePhone;
	param["phone"] = phone;
	param["qq"] = qq;
	param["email"] = email;
	param["fimallyPhone"] = fimallyPhone;
	param["birthday"] = birthday;
	param["pid"] = pid;
	param["compClass"] = compClass;
	param["url"] = url;
	param["remark"] = remark;
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/fileNames/updateFiles2", // Ajax访问地址
		data : param, // 参数
		dataType : "json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert("修改异常");
		},
		success : function(data) { // 返回成功时运行，主要接受结果
			if (data.success) {
				alert(data.msg);
				window.close();
			} else {
				alert('修改异常');
			}
		}
	});
}

function delFileMessage(){
	var basePath = $("#basePath").val();
	var id = $("#id").val();
	var remark = $("#remark").val();
	if(remark==""){
		alert("删除必须填写备注");
		return;
	}
	var param = {};
	param["id"] = id;
	param["remark"] = remark;
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/fileNames/delFile", // Ajax访问地址
		data : param, // 参数
		dataType : "json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert("删除异常");
		},
		success : function(data) { // 返回成功时运行，主要接受结果
			if (data.success) {
				alert(data.msg);
				window.close();
				lod();
			} else {
				alert('修改异常');
			}
		}
	});
}
function delFile(fid,compnyName){
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/fileNames/todel?id="+fid/*+"&compnyName="+encodeURI(compnyName)*/, "",
	"dialogWidth=750px;dialogHeight=450px;status=no;help=no;scrollbars=no");
	/*if(confirm('确实删除吗?')){
	var basePath = $("#basePath").val();
	var data = {id:fid
			};
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/fileNames/delFile", // Ajax访问地址
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
	}*/
}

/*function changeArea(){
	alert("s");
	var area=$("#area");
	var areas=new Array("福田区","罗湖区","盐田区","南山区","宝安区","龙岗区","龙华区","坪山区","光明新区","大鹏新区");
	for(var i=0;i<10;i++){
		area.options[i].value = areas[i];
		area.options[i].text = areas[i];
	}
}
*/

function excel(){
	var basePath = $("#basePath").val();
	/*var address = $('#address').val();
	var compnyName = $('#compnyName').val();
	var department = $('#department').val();
	var linkmn = $('#linkmn').val();
	var post = $('#post').val();*/
	var compClass = $('#compClass').val();
	/*var isdelete = $('#isdelete').val();
	var fbak2=$('#fbak2').val();*/
	var fbak1=$('#times').val();
	var isdelete = $('#isdelete').val();
	var zipCode=$('#endtimes').val();
	
	/*alert(fbak1);*/
	window.location.href = basePath+"action/fileNames/downExcel?compClass="+compClass+"&fbak1="+fbak1+"&isdelete="+isdelete+"&zipCode="+zipCode;
	/*window.location.href = basePath+"action/fileNames/downExcel?address="+address+"&compnyName="+compnyName
							+"&department="+department+"&linkmn="+linkmn+"&post="+post+"&compClass="+compClass
							+"&post="+post+"&fbak2="+fbak2+"&isdelete="+isdelete+"&fbak1"+fbak1;*/
}

function upexcel(){
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/fileNames/toUpExcel",
	"dialogWidth=650px;dialogHeight=350px;status=no;help=no;scrollbars=no");
	lod();
}

function sign(fid){
	var basePath = $("#basePath").val();
	var times = $("#times").val();
	var param = {};
	param["id"] = fid;
	param["times"] = times;
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/fileNames/signFiles", // Ajax访问地址
		data : param, // 参数
		dataType : "json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert("修改异常");
		},
		success : function(data) { // 返回成功时运行，主要接受结果
			if (data.success) {
				alert(data.msg);
				window.close();
				lod();
			} else {
				alert('修改异常');
			}
		}
	});
}
function rvsign(fid){
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/fileNames/rvsign?id="+fid, "",
	"dialogWidth=750px;dialogHeight=450px;status=no;help=no;scrollbars=no");
}
function rvsignFiles(fid){
	var basePath = $("#basePath").val();
	var states = $("#states").val();
	var param = {};
	param["id"] = fid;
	param["states"] = states;
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/fileNames/rvsignFiles", // Ajax访问地址
		data : param, // 参数
		dataType : "json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert("修改异常");
		},
		success : function(data) { // 返回成功时运行，主要接受结果
			if (data.success) {
				alert(data.msg);
				window.close();
				lod();
			} else {
				alert('修改异常');
			}
		}
	});
}








