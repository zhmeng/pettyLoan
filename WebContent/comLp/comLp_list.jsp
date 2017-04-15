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
<script type="text/javascript" src="${path}/comLp/comLp.js"></script>
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
<form id="searchForm" action="${path}/action/comLp/goComLpList" method="post">
 <input type="hidden" value="${modId}" name="modId" id="modId"/> 
<div class="place"><ul class="placeul"></ul></div>
<div id="container">
	<div class="ui_content">
		<div class="ui_text_indent">
			<div id="box_border">
				<div class="box_bottom">
					<label class="input_label">楼盘编号：</label>
					<input id="lpKey" name="comLp.lpKey" value="${comLp.lpKey}" type="text" class="input_text" />
					<label class="input_label">楼盘名称：</label>
					<input id="lpName" name="comLp.lpName" value="${comLp.lpName}" type="text" class="input_text" />
					<input type="submit" id="searchBtn" value="查&nbsp;&nbsp;询" class="ui_input_btn01"/>
					<c:forEach var="op" items="${blist}">
					   <c:if test="${op.CValue eq 2}">
					      <input type="button" id="modify_btn" onclick="toAddComLp()" value="添&nbsp;&nbsp;加" class="ui_input_btn01"/>
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
					<th>楼盘编码</th>
					<th>楼盘名称</th>
					<th>负责人姓名</th>
					<th>负责人电话</th>
					<th>楼盘详细地址</th>
					<th>所属开发商</th>
					<th>状态</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
				<c:choose>
				<c:when test="${empty pm.datas}">
					<tr><td colspan="9"></td></tr>
				</c:when>
					<c:otherwise>
						<c:forEach var="bean" items="${pm.datas}">
							<tr>
								<td>${bean.lpKey}</td>
								<td>${bean.lpName}</td>
								<td>${bean.lpGM}</td>
								<td>${bean.lpTel}</td>
								<td>${bean.lpAddr}</td>
								<td>${bean.companyName}</td>
								<td>
									<c:if test="${bean.lpState==0}">无效</c:if>
									<c:if test="${bean.lpState==1}">生效</c:if>
									<c:if test="${bean.lpState==2}">过期</c:if>
									<c:if test="${bean.lpState==4}">删除</c:if>
								</td>
								<td><fmt:formatDate value="${bean.createTime}" pattern="yyyy年MM月dd日HH点"/></td>
								<td>
								<c:forEach var="op" items="${blist}">
								        <c:if test="${op.CValue eq 8}">
									<a href="javascript:void(0)" onclick="toUpdateComLp('${bean.lpID}')">编辑</a>
									    </c:if> 
									    <c:if test="${op.CValue eq 4}"> 
									       <a href="javascript:void(0)" onclick="delComLp('${bean.lpID}')">删除</a>
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