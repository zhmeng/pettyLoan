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
<title>贷款审批</title>
<link href="${basePath}/syscss/basic_layout.css" rel="stylesheet" type="text/css"/>
<link href="${basePath}/syscss/common_style.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="${path}/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${path}/js/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/apply/oa/oa.js"></script>
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
<form id="searchForm" action="${path}/action/applyInfo/showOa" method="post">
<div class="place"><ul class="placeul"></ul></div>
<div id="container">
	<div class="ui_content">
		<div class="ui_text_indent">
			<div id="box_border">
				<div class="box_bottom">
					<label class="input_label">申请编号：</label>
					<input id="applyCode" name="applyInfo.applyCode" value="${applyInfo.applyCode}" type="text" class="input_text" />
					<label class="input_label">项目名称：</label>
					<input id="uName" name="applyInfo.projectName" value="${applyInfo.projectName}" type="text" class="input_text" />
					<label class="input_label">客户经理：</label>
					<input id="uName" name="applyInfo.uName" value="${applyInfo.uName}" type="text" class="input_text" />
					<label class="input_label">审批类别：</label>
					<select id="exClas" name="exClas">
						<c:if test="${empty exClas}">
							<option value="1">全部</option>
							<option value="2">待审批</option>
						</c:if>
						<c:if test="${exClas=='1'}">
							<option value="1" selected="selected">全部</option>
							<option value="2">待审批</option>
						</c:if>
						<c:if test="${exClas=='2'}">
							<option value="1">全部</option>
							<option value="2" selected="selected">待审批</option>
						</c:if>
					</select>
					<label class="input_label">审批状态：</label>
					<select name="statused">
						<option value="">全部</option>
						<c:forEach items="${comList}" var="com">
							<c:choose>
								<c:when test="${com.baseDefault==statused}">
									<option value="${com.baseDefault}" selected="selected">${com.baseName}</option>
								</c:when>
								<c:otherwise>
									<option value="${com.baseDefault}">${com.baseName}</option>
								</c:otherwise>
							</c:choose>
							
						</c:forEach>
					</select>
					<input type="submit" id="searchBtn" value="查&nbsp;&nbsp;询" class="ui_input_btn01"/>
				</div>
			</div>
		</div>
	</div>
		<div class="ui_content">
		<div class="ui_tb">
			<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
				<tr class="TableHeader"> 
					<th>申请编号</th>
					<th>申请额度</th>
					<th>贷款期限</th>
					<th>项目名称</th>
					<th>申请额度</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:choose>
				<c:when test="${empty pm.datas}">
					<tr><td colspan="5"></td></tr>
				</c:when>
					<c:otherwise>
						<c:forEach var="bean" items="${pm.datas}">
							<tr>
								<td>${bean.applyCode}</td>
								<td>${bean.amount}</td>
								<td>${bean.loanTime}</td>
								<td>${bean.projectName}</td>
								<td>${bean.bigAmount}</td>
								<td>
									<c:forEach items="${comList}" var="com">
										<c:if test="${com.baseDefault==bean.status}">
											${com.baseName}
										</c:if>
									</c:forEach>
								</td>
								<td>
									<a href="javascript:void(0)" onclick="toUpdateApplyInfo('${bean.applyID}')">查看详情</a>
									<c:choose>
										<c:when test="${exClas=='2'}">
											<a href="javascript:void(0)" onclick="toOa('${bean.applyID}','${bean.status}')">审批</a>
										</c:when>
										<c:otherwise>
											<c:forEach items="${appList}" var="app">
												<c:if test="${app.applyID==bean.applyID}">
													<a href="javascript:void(0)" onclick="toOa('${bean.applyID}','${bean.status}')">审批</a>
												</c:if>
											</c:forEach>
										</c:otherwise>
									</c:choose>
									
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
<w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/action/apply/showOa" recordCount="${pm.recordCount}" />
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</div>
</body>
</html>



