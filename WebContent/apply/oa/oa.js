function toOa(applyID,status){
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/applyInfo/toOa?applyID="+applyID+"&status="+status, "",
					"dialogWidth=700px;dialogHeight=400px;status=no;help=no;scrollbars=no");
	load();
}
function toExamine(examines){
	var basePath = $("#basePath").val();
	var applyID = $("#applyID").val();
	var status=$("#status").val();
	var pl=$("#pl").val();
	var bigAmount=$("#bigAmount").val();
	var amount=$("#amount").val();
	var loanTime=$("#loanTime").val();
	var rate=$("#rate").val();
	var datas={
			examines : examines,
			applyID :applyID,
			status:status,
			pl:pl,
			bigAmount:bigAmount,
			loanTime:loanTime,
			rate:rate,
			amount:amount
	};
	jQuery.ajax({
		type : "post", 
		url : basePath + "action/applyInfo/examineOa", 
		data : datas, 
		dataType : "json", 
		error : function() { 
			alert("出错了");
		},
		success : function(data) { 
			if (data.success) {
				if(data.msg=="1"){
					alert("审批成功");
				}
				if(data.msg=="2"){
					alert("该贷款申请已经被别人审批");
				}
				parent.window.returnValue = data.msg;
				window.close();
			}else{
				alert("出错了");
			}
		}
	});
	
}
function toUpdateApplyInfo(){
	window.open( "${path}/loanApp/toShowLoanApp?applyID="+applyID+"&pd=1","newwindow",
		"height=800, width=1100, top=1000, left=500, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no,fullscreen=yes");
}
function load(){
	var basePath = $("#basePath").val();
	
	var data={
			
	};
	$.post(basePath + "action/applyInfo/showOa", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}





