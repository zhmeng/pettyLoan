<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", path);
	request.setAttribute("basePath", basePath);
%>
<link rel="stylesheet" href="${path}/css/default.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/Css.css" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>

<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var collectLoanInterest= ($("#amount").val()*10000.00)*($("#feeRate").val()/100);
	$("#collectLoanInterest").val(collectLoanInterest);
});

//确认收款
function confCollectApplyLoan() {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	var applyID = $('#applyID').val();
	var applyCode=$('#applyCode').val();
	var loanTime = $("#loanTime").val();
	var collectLoanDate=$("#collectLoanDate").val();
	var collectLoanInterest = $('#collectLoanInterest').val();

	if (collectLoanDate == "" || collectLoanDate == null) {
		alert("请填写收款时间");
		return;
	}
	if (collectLoanInterest == "" || collectLoanInterest == null) {
		alert("请填写收款金额");
		return;
	}
	if (collectLoanInterest>=amount) {
		alert("收款利息不能大于贷款金额");
		return;
	}
	
	var param = {};
	param["modId"] = modId;
	param["applyID"] = applyID;
	param["applyCode"] = applyCode;
	param["loanTime"] = loanTime;
	param["collectLoanDate"] = collectLoanDate;
	param["collectLoanInterest"] = collectLoanInterest;

 jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/collect/confCollectApplyLoan", // Ajax访问地址
		data : param, // 参数
		dataType :"json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			
			alert("保存异常");
		},
		success : function(data) { // 返回成功时运行，主要接受结果
		
			if (data.success) {
				
				alert(data.msg);
				window.close();
			} 
		}
	});
	
}
</script>
<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
				<input id="basePath" type="hidden" value="${basePath}"/>
				<div class="infotitle" align="center">
					<h3 >确认收款</h3>
				</div>
				<div class="infocontent">
					<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
	                    <tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款申请编号：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="applyCode" name="applyCode" value="${applyInfo.applyCode}" readonly="readonly" />
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款申请金额：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="amount" name="amount"  value="${applyInfo.amount}" readonly="readonly"/>(万元)
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款手续费率：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="feeRate" name="feeRate" value="${applyInfo.feeRate}" readonly="readonly"/>%
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款申请期限：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="loanTime" name="loanTime"  value="${applyInfo.loanTime}" readonly="readonly"/>(个月)
		                    </td>
						</tr>
						<tr>
						    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><font color="red">*</font>贷款申请时间：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    <input type="text" id="applyDate" name="applyDate" value="${applyInfo.applyDate}"/>
		                    </td>
		                    
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><font color="red">*</font>确认收款时间：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="collectLoanDate" name="collectLoanDate" onClick="WdatePicker({dateFmt:'yyyy/MM/dd HH:mm'})"/>
		                    </td>
		                 </tr>
		                 <tr>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><font color="red">*</font>收款利息：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="collectLoanInterest" name="collectLoanInterest"  readonly="readonly"/>(元)
		                    </td>
		                    <td colspan="2"></td>
						</tr>
					</table>
					<input type="hidden" name="applyID" id="applyID" value="${applyInfo.applyID}">
				</div>				
			</div>
		</div>&nbsp;
		<div class="box_btn" align="center">
			<input type="button" value="保&nbsp;&nbsp;存" onclick="confCollectApplyLoan()"/> 
			<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
		</div>
	</div>
</div>