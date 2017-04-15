<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="w" uri="http://ley.Page.com/tags/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path",path);
request.setAttribute("basePath",basePath);
%> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>小额贷系统</title>
<link href="${path}/syscss/basic_layout.css" rel="stylesheet" type="text/css"/>
<link href="${path}/syscss/common_style.css" rel="stylesheet" type="text/css"/>
<%-- <link rel="stylesheet" href="${path}/css/default.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css" /> --%>
<link rel="stylesheet" type="text/css" href="${path}/css/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="${path}/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${path}/js/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/SYS/number/comBase.js"></script>
<style>
	.alt td{ background:black !important;}
	#box_bottom {
	height: 40px;
	line-height: 40px;
	text-align: right;
}
.ui_frt {
float: right; 
}
tr:hover{background:#f6f6f6;}
.ui_tb_h30{ margin-top:20px;}
</style>
<script type="text/javascript">

	
</script>
</head>
<body id="body">
<div id="userinfoContainer" class="container" >
<input id="basePath" type="hidden" value="${basePath}"/>
<form id="searchForm" action="${path}/action/comBase/showBase"  method="post">
<input type="hidden" value="${modId}" name="modId" id="modId"/>    
    <div class="place">
    <ul class="placeul">
    </ul>
    </div>
    <input type="hidden" value="${modId}" name="modId" id="modId"/>
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
							<div class="box_bottom">
								<label class="input_label">基础数据名称：</label>
								<input id="baseName" name="cbd.baseName" value="${cbd.baseName}" type="text" class="input_text" />
								<label class="input_label">基础数据类型:</label>
								<select name="cbd.baseDataList">
									<c:if test="${empty cbd.baseDataList}">
										<option value="" selected="selected">...</option>
										<option value="DKZT">DKZT</option>
										<option value="QXKZ">QXKZ</option>
									</c:if>
									<c:if test="${cbd.baseDataList=='DKZT'}">
										<option value="">...</option>
										<option value="DKZT" selected="selected">DKZT</option>
										<option value="QXKZ">QXKZ</option>
									</c:if>
									<c:if test="${cbd.baseDataList=='QXKZ'}">
										<option value="">...</option>
										<option value="DKZT">DKZT</option>
										<option value="QXKZ" selected="selected">QXKZ</option>
									</c:if>
								</select>
								<input type="submit" id="searchBtn" value="查&nbsp;&nbsp;询" class="ui_input_btn01"/>
								<input type="button" id="modify_btn" onclick="toaddcom()" value="添&nbsp;&nbsp;加"/>
							</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr class="TableHeader"> 
							<!-- <th>区域编号</th> -->
							<th>基础数据名称</th>
							<th>基础数据类型</th>
							<th>字符串截取字符</th>
							<th>默认值</th>
							<th>数据描述</th>
							<th>操作</th>
				</tr>
						<c:choose>
			<c:when test="${empty pm.datas}">
				<tr>
					<td colspan="6"></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="bean" items="${pm.datas}">
							<tr>
								<td>${bean.baseName}</td>
								<td>${bean.baseDataList}</td>
								<c:choose>
									<c:when test="${bean.baseSplitChar==null}">
										<td>...</td>
									</c:when>
									<c:otherwise>
										<td>${bean.baseSplitChar}</td>
									</c:otherwise>
								</c:choose>								
								<td>${bean.baseDefault}</td>
								<c:choose>
									<c:when test="${bean.baseDesc==null}">
										<td>...</td>
									</c:when>
									<c:otherwise>
										<td>${bean.baseDesc}</td>
									</c:otherwise>
								</c:choose>		
								<td>
								<%-- <a href="javascript:void(0)" onclick="setDept(${bean.deptID})">设置职位</a> --%>
								<c:forEach var="op" items="${blist}">
								        <c:if test="${op.CValue eq 8}">
								           <a href="javascript:void(0)"  class="edit" onclick="updateCity('${bean.baseId}')">编辑</a>
								           </c:if> 
									    <c:if test="${op.CValue eq 4}"> 
								           <a href="javascript:void(0)" onclick="delCity('${bean.baseId}')">删除</a>
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
	<w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/action/comBase/showBase" recordCount="${pm.recordCount}" />

</div>
</body>
</html>




