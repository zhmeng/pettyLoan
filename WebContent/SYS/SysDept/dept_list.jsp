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
<script type="text/javascript" src="${path}/SYS/SysDept/dept.js"></script>
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
<form id="searchForm" action="${path}/action/dept/goDeptList" method="post">
 <input type="hidden" value="${modId}" name="modId" id="modId"/> 
<div class="place"><ul class="placeul"></ul></div>
<div id="container">
	<div class="ui_content">
		<div class="ui_text_indent">
			<div id="box_border">
				<div class="box_bottom">
					<label class="input_label">部门编号：</label>
					<input id="deptID" name="dept.deptID" value="${dept.deptID}" type="text" class="input_text" />
					<label class="input_label">部门名称：</label>
					<input id="deptName" name="dept.deptName" value="${dept.deptName}" type="text" class="input_text" />
					<input type="submit" id="searchBtn" value="查&nbsp;&nbsp;询" class="ui_input_btn01"/>
					<c:forEach var="op" items="${blist}">
					   <c:if test="${op.CValue eq 2}">
					     <input type="button" id="modify_btn" onclick="toAddDept()" value="添&nbsp;&nbsp;加" class="ui_input_btn01"/>
					   </c:if>
				   </c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="ui_content">
		<div class="ui_tb">
			<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
				<tr class="TableHeader"> 
					<th>部门编号</th>
					<th>部门名称</th>
					<!-- <th>负责人</th>
					<th>是否网点</th>
					<th>信审部</th>
					<th>客服部门</th> -->
					<th>操作</th>
				</tr>
				<c:choose>
				<c:when test="${empty pm.datas}">
					<tr><td colspan="7"></td></tr>
				</c:when>
					<c:otherwise>
						<c:forEach var="bean" items="${pm.datas}">
							<tr>
								<td>${bean.deptID}</td>
								<td>${bean.deptName}</td>
								<%-- <td>${bean.deptMG}</td>
								<td>
									<c:if test="${bean.deptIsBR==0}">是</c:if>
									<c:if test="${bean.deptIsBR==1}">否</c:if>
								</td>
								<td>
									<c:if test="${bean.deptIsCR==0}">是</c:if>
									<c:if test="${bean.deptIsCR==1}">否</c:if>
								</td>
								<td>
									<c:if test="${bean.deptIsCS==0}">是</c:if>
									<c:if test="${bean.deptIsCS==1}">否</c:if>
								</td> --%>
								<td>
								    <c:forEach var="op" items="${blist}">
								        <c:if test="${op.CValue eq 8}">
									      <a href="javascript:void(0)" onclick="toUpdateDept('${bean.deptID}')">编辑</a> 
									    </c:if> 
									    <c:if test="${op.CValue eq 4}"> 
									       <a href="javascript:void(0)" onclick="delDept('${bean.deptID}')">删除</a>
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
<w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/action/dept/goDeptList" recordCount="${pm.recordCount}" />
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</div>
</body>
</html>