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
</head>
<body id="body">
<input type="hidden" value="${modId}" name="modId" id="modId"/>
<div id="userinfoContainer" class="container">
<input id="basePath" type="hidden" value="${basePath}"/>
<form id="searchForm" action="${path}/action/contract/goContractList" method="post">
<div class="place"><ul class="placeul"></ul></div>
<div id="container">
	<div class="ui_content"></div>
	<div class="ui_content">
		<div class="ui_tb">
			<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
				<tr class="TableHeader"> 
					<th>合同编号</th>
					<th>打印时间</th>
					<th>打印编号</th>
				</tr>
				<c:choose>
				<c:when test="${empty printRecordList}">
					<tr><td colspan="3"></td></tr>
				</c:when>
					<c:otherwise>
						<c:forEach var="bean" items="${printRecordList}">
							<tr>
								<td>${bean.contractNo}</td>
								<td><fmt:formatDate value="${bean.printDate}" pattern="yyyy年MM月dd日HH点"/></td>						
								<td>${bean.printNo}</td>					
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
</div>
</form>
</div>
</body>
</html>