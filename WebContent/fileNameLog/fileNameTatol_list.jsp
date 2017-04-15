<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="w" uri="http://ley.Page.com/tags/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>小额贷系统</title>
<%@include file="/comment/comment.jsp"%>
<link href="${path}/syscss/basic_layout.css" rel="stylesheet" type="text/css"/>
<link href="${path}/syscss/common_style.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="${path}/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${path}/js/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/fileNameLog/fileNameLog.js"></script>
<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
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
<form id="searchForm" action="${path}/action/fileNamesLog/fileNameTatol" method="post">
 <input type="hidden" value="${modId}" name="modId" id="modId"/> 
<div class="place"><ul class="placeul"></ul></div>
<div id="container">
	<div class="ui_content">
		<div class="ui_text_indent">
			<div id="box_border">
				<div class="box_bottom">
					<label class="input_label">操作人：</label>
					<select id="fmonily" name="fileNamesLog.userId">
						<option value="">--</option> 
						<c:forEach items="${userList}" var="userList">
							<c:if test="${userList.userID==fileNamesLog.userId}">
								<option value="${userList.userID}" selected="selected">${userList.userFullName}</option>
							</c:if>
							<option value="${userList.userID}">${userList.userFullName}</option> 
						</c:forEach>
						
					</select>&nbsp&nbsp
					
				
					&nbsp&nbsp<label class="input_label">月份：</label>
					<input type="text" id="changeTime" value="${fileNamesLog.fbak1}" name="fileNamesLog.fbak1" onClick="WdatePicker({dateFmt:'yyyy-MM'})" />
					&nbsp&nbsp&nbsp&nbsp
					<input type="submit" id="searchBtn" value="查&nbsp;&nbsp;询" class="ui_input_btn01"/>
					
				</div>
			</div>
		</div>
	</div>
	<div class="ui_content">
		<div class="ui_tb">
			<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
				<tr class="TableHeader"> 
					<th>操作人</th>
					<th>总操作数量</th>
					<th>修改通过数量</th>
					<th>新增通过数量</th>
					<th>驳回次数</th>
					<th>月份</th>
				</tr>
				<c:choose>
				<c:when test="${empty pm.datas}">
					<tr><td colspan="11"></td></tr>
				</c:when>
					<c:otherwise>
						<c:forEach var="bean" items="${pm.datas}">
							<tr>
								<td>
									<c:forEach items="${userList}" var="ul">
										<c:if test="${ul.userID==bean.userId}">
											${ul.userFullName}
										</c:if>
									</c:forEach> 
								</td>
								<td>${bean.sum}</td>
								<td>${bean.upsum}</td>
								<td>${bean.addsum}</td>
								<td>${bean.passsum}</td>
								<td>${bean.times}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
</div>
</form>
<w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/action/fileNamesLog/showFileNamesLog" recordCount="${pm.recordCount}" />
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</div>
</body>
</html>