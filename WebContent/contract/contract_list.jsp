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
<script type="text/javascript" src="${path}/contract/contract.js"></script>
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
<script>
function toPrintContract(applyID) {
	var modId = $("#modId").val();
	var basePath = $("#basePath").val();
	window.showModalDialog(basePath + "action/contract/toPrintContract?applyID="
					+ applyID+"&modId="+modId, "",
					"dialogWidth=650px;dialogHeight=500px;status=no;help=no;scrollbars=no");
	lod();
}
</script>
</head>
<body id="body">
<div id="userinfoContainer" class="container">
<input id="basePath" type="hidden" value="${basePath}"/>
<form id="searchForm" action="${path}/action/contract/goContractList" method="post">
<input type="hidden" value="${modId}" name="modId" id="modId"/>
<div class="place"><ul class="placeul"></ul></div>
<div id="container">
	<div class="ui_content">
		<div class="ui_text_indent">
			<div id="box_border">
				<div class="box_bottom">
					<label class="input_label">合同编号：</label>
					<input id="contractNo" name="contract.contractNo" value="" type="text" class="input_text" />
					<label class="input_label">合同名称：</label>
					<input id="contractName" name="contract.contractName" value="" type="text" class="input_text" />
					<input type="submit" id="searchBtn" value="查&nbsp;&nbsp;询" class="ui_input_btn01"/>
					<!-- <input type="button" id="modify_btn" onclick="toAddContract()" value="添&nbsp;&nbsp;加" class="ui_input_btn01"/> -->
				</div>
			</div>
		</div>
	</div>
	<div class="ui_content">
		<div class="ui_tb">
			<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
				<tr class="TableHeader"> 
					<th>合同编号</th>
					<th>合同名称</th>
					<th>合同状态</th>
					<th>贷款金额</th>
					<th>贷款期限</th>
					<th>操作</th>
				</tr>
				<c:choose>
				<c:when test="${empty pm.datas}">
					<tr><td colspan="6"></td></tr>
				</c:when>
					<c:otherwise>
						<c:forEach var="bean" items="${pm.datas}">
							<tr>
								<td>${bean.applyCode}</td>
								<td>${bean.contractName}</td>
								<td>
									<c:if test="${empty bean.contractStatus}">待申请</c:if>
									<c:if test="${bean.contractStatus==1}">待申请</c:if>
									<c:if test="${bean.contractStatus==2}">待签订</c:if>
									<c:if test="${bean.contractStatus==3}">待复核</c:if>
									<c:if test="${bean.contractStatus==4}">待放款</c:if>
									<c:if test="${bean.contractStatus==9}">作废</c:if>
								</td>
								<td>${bean.amount}</td>
								<td>${bean.loanTime}</td>
								<td>
									<c:forEach var="item" items="${blist}">
										<c:if test="${item.CValue==16}">
											<c:if test="${bean.status==3 && empty bean.contractStatus}">
												<a href="javascript:void(0)" onclick="toAddContract('${bean.applyID}')">申请合同</a>
											</c:if>
										</c:if>
										
										<c:if test="${item.CValue==32}">
											<c:if test="${bean.status==3 && bean.contractStatus==2}">
												<a href="javascript:void(0)" onclick="toSignedContract('${bean.applyID}')">签订</a>
												<a href="javascript:void(0)" onclick="toPrintContract('${bean.applyID}')">打印</a>
												<a href="javascript:void(0)" onclick="toPrintRecord('${bean.applyCode}')">打印记录</a>
											</c:if>
										</c:if>
										
										<c:if test="${item.CValue==128}">
											<c:if test="${bean.status==3 && bean.contractStatus==3}">
												<a href="javascript:void(0)" onclick="toRetrialContract('${bean.applyID}')">复核</a>
												<a href="javascript:void(0)" onclick="toUploadFile('${bean.applyID}')">上传文件</a>
											</c:if>
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
<w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/action/contract/goContractList" recordCount="${pm.recordCount}" />
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</div>
</body>
</html>