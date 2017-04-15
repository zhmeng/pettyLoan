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
<script type="text/javascript" src="${path}/product/product.js"></script>
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
<form id="searchForm" action="${path}/action/product/goProductList" method="post">
<input type="hidden" value="${modId}" name="modId" id="modId"/> 
<div class="place"><ul class="placeul"></ul></div>
<div id="container">
	<div class="ui_content">
		<div class="ui_text_indent">
			<div id="box_border">
				<div class="box_bottom">
					<label class="input_label">业务编号：</label>
					<input id="productKey" name="product.productKey" value="${product.productKey}" type="text" class="input_text" />
					<label class="input_label">业务名称：</label>
					<input id="productName" name="product.productName" value="${product.productName}" type="text" class="input_text" />
					<input type="submit" id="searchBtn" value="查&nbsp;&nbsp;询" class="ui_input_btn01"/>
					<c:forEach var="op" items="${blist}">
					   <c:if test="${op.CValue eq 2}">
					        <input type="button" id="modify_btn" onclick="toAddProduct()" value="添&nbsp;&nbsp;加" class="ui_input_btn01"/>
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
					<th>业务编码</th>
					<th>业务名称</th>
					<th>业务状态</th>
					<th>业务描述</th>
					<th>有效期开始时间</th>
					<th>有效期结束时间</th>
					<th>还款方式</th>
					<th>利息</th>
					<th>手续费率</th>
					<th>操作</th>
				</tr>
				<c:choose>
				<c:when test="${empty pm.datas}">
					<tr><td colspan="10"></td></tr>
				</c:when>
					<c:otherwise>
						<c:forEach var="bean" items="${pm.datas}">
							<tr>
								<td>${bean.productKey}</td>
								<td>${bean.productName}</td>
								<td>
									<c:if test="${bean.productFlag==0}">无效</c:if>
									<c:if test="${bean.productFlag==1}">生效</c:if>
									<c:if test="${bean.productFlag==2}">过期</c:if>
									<c:if test="${bean.productFlag==4}">删除</c:if>
								</td>
								<td>${bean.productDesc}</td>
								<td><fmt:formatDate value="${bean.productValSTime}" pattern="yyyy年MM月dd日HH点"/></td>
								<td><fmt:formatDate value="${bean.productValETime}" pattern="yyyy年MM月dd日HH点"/></td>
								<td>
									<c:if test="${bean.productPayment==1}">按期还息到期还本</c:if>
									<c:if test="${bean.productPayment==2}">等额本息</c:if>
									<c:if test="${bean.productPayment==3}">等额本金</c:if>
									<c:if test="${bean.productPayment==4}">一次性还本付息</c:if>
									<c:if test="${bean.productPayment==5}">预收利息一次性还本</c:if>
									<c:if test="${bean.productPayment==6}">按月还息按期还本</c:if>
									<c:if test="${bean.productPayment==7}">按月还息任意还本</c:if>
									<c:if test="${bean.productPayment==8}">按月还息到期还本(提前收息)</c:if>
									<c:if test="${bean.productPayment==9}">平息</c:if>
								</td>
								<td>${bean.productLoanRate}%</td>
								<td>${bean.productFeesRate}%</td>
								<td>
								 <c:forEach var="op" items="${blist}">
								        <c:if test="${op.CValue eq 8}">
									        <a href="javascript:void(0)" onclick="toUpdateProduct('${bean.productID}')">编辑</a>
									    </c:if> 
									    <c:if test="${op.CValue eq 4}"> 
									        <a href="javascript:void(0)" onclick="delProduct('${bean.productID}')">删除</a>
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
<w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/action/product/goProductList" recordCount="${pm.recordCount}" />
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</div>
</body>
</html>