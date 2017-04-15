<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="w" uri="http://ley.Page.com/tags/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", path);
	request.setAttribute("basePath", basePath);
%> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>小额贷系统</title>
<link href="${path}/syscss/basic_layout.css" rel="stylesheet" type="text/css"/>
<link href="${path}/syscss/common_style.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="${path}/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${path}/js/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
<script  type="text/javascript">
// 确认收款
function toConfSendApplyLoan(applyID) {
	var basePath = $("#basePath").val();
	var modId = $("#modId").val();
	var sendDate= $("#sendDate").val();

	if (sendDate == "" || sendDate == null) {
		alert("请填写放款时间");
		return;
	}
	var param = {};
	param["modId"] = modId;
	param["applyID"] = applyID;
	param["sendDate"] = sendDate;

	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/send/confSendApplyLoan", // Ajax访问地址
		data : param, // 参数
		dataType :"json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert(0);
			alert("放款异常");
		},
		success : function(data) { // 返回成功时运行，主要接受结果
			if (data.success) {
				alert(data.msg);
				window.close();
			} else {
				alert('放款异常');
			}
		}
	});	
}

function searchSendLoan(){
	var sendDateStart=$("input[name='applyInfo.sendDateStart']").val();
	var sendDateEnd=$("input[name='applyInfo.sendDateEnd']").val();

	var start= new Date (sendDateStart.split("-")[0],sendDateStart.split("-")[1],sendDateStart.split("-")[2]);
	var end= new  Date(sendDateEnd.split("-")[0],sendDateEnd.split("-")[1],sendDateEnd.split("-")[2]);

	if(start>end){
		alert("查询的开始日期不能大于查询的结束日期");
		return ;
	}
	document.forms[0].submit();
}

</script>
<style>
.alt td {
	background: black !important;
}

#box_bottom {
	height: 40px;
	line-height: 40px;
	text-align: right;
}

.ui_frt {
	float: right;
}

tr:hover {
	background: #f6f6f6;
}

.ui_tb_h30 {
	margin-top: 20px;
}
</style>
</head>
<body id="body">
<div id="userinfoContainer" class="container">
<input id="basePath" type="hidden" value="${basePath}"/>
<form id="searchForm" action="${path}/action/send/goSendList" method="post">
 <input type="hidden" value="${modId}" name="modId" id="modId"/> 
<div class="place"><ul class="placeul"></ul></div>
<div id="container">
	<div class="ui_content">
		<div class="ui_text_indent">
			<div id="box_border">
				<div class="box_bottom">
					<label class="input_label">贷款申请编号：</label>
					<input id="applyInfo.applyCode" name="applyInfo.applyCode"  type="text" class="input_text" />
					<label class="input_label">贷款申请时间：</label>
					<input id="applyInfo.sendDateStart" name="applyInfo.sendDateStart" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
					<label class="input_label">-</label>
					<input id="applyInfo.sendDateEnd" name="applyInfo.sendDateEnd" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
					<input type="button" id="searchBtn" value="查&nbsp;&nbsp;询" class="ui_input_btn01" onclick="searchSendLoan()"/>
				</div>
			</div>
		</div>
	</div>
	<div class="ui_content">
		<div class="ui_tb">
			<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
				<tr class="TableHeader"> 
					<th>贷款申请编码</th>
					<th>贷款申请金额</th>
					<th>贷款利率</th>
					<th>贷款申请时间</th>
					<th>贷款放款时间</th>
					<th>操作</th>
				</tr>
				<c:choose>
				<c:when test="${empty pm.datas}">
					<tr><td colspan="4"></td></tr>
				</c:when>
					<c:otherwise>
						<c:forEach var="bean" items="${ pm.datas}">
							<tr>
								<td>${bean.applyCode}</td>
								<td>${bean.amount}(万元)</td>	
								<td>${bean.rate}%</td>	
								<td>${bean.applyDate}</td>
								<td><input id="sendDate" name="sendDate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/></td>											
								<td>
								<c:forEach var="op" items="${blist}">
								        <c:if test="${op.CValue eq 8}">
									    <a href="javascript:void(0)" onclick="toConfSendApplyLoan('${bean.applyID}')">确定放款</a>
									    </c:if> 
									  
								    </c:forEach>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
</div>
</form>
<w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/action/comLp/goCompLpList" recordCount="${pm.recordCount}" />
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</div>
</body>
</html>