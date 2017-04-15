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
<form id="searchForm" action="${path}/action/fileNamesLog/showFileNamesLog" method="post">
 <input type="hidden" value="${modId}" name="modId" id="modId"/> 
<div class="place"><ul class="placeul"></ul></div>
<div id="container">
	<div class="ui_content">
		<div class="ui_text_indent">
			<div id="box_border">
				<div class="box_bottom">
					<label class="input_label">公司名称：</label>
					<input id="compnyName" name="fileNamesLog.compnyName" value="${fileNamesLog.compnyName}" type="text" class="input_text" />
					&nbsp&nbsp<label class="input_label">所在部门：</label>
					<input id="department" name="fileNamesLog.department" value="${fileNamesLog.department}" type="text" class="input_text" />
					&nbsp&nbsp<label class="input_label">联系人：</label>
					<input id="linkmn" name="fileNamesLog.linkmn" value="${fileNamesLog.linkmn}" type="text" class="input_text" />
					&nbsp&nbsp<label class="input_label">公司地址：</label>
					<input id="address" name="fileNamesLog.address" value="${fileNamesLog.address}" type="text" class="input_text" />
					</br>
					&nbsp&nbsp<label class="input_label">审核：</label>
					<select id="fmonily" name="fileNamesLog.fmonily">
						<c:choose>
							<c:when test="${fileNamesLog.fmonily==1}">   
								<option value="">--</option>
								<option value="1" selected="selected">新增</option>
								<option value="2">删除</option>
								<option value="3">修改</option>
							</c:when>
							<c:when test="${fileNamesLog.fmonily==2}">   
								<option value="">--</option>
								<option value="1">新增</option>
								<option value="2" selected="selected">删除</option>
								<option value="3">修改</option>
							</c:when>
							<c:when test="${fileNamesLog.fmonily==3}">   
								<option value="">--</option>
								<option value="1">新增</option>
								<option value="2">删除</option>
								<option value="3" selected="selected">修改</option>
							</c:when>
							<c:otherwise>   
    							<option value="" selected="selected">--</option>
								<option value="1">新增</option>
								<option value="2">删除</option>
								<option value="3">修改</option>
  							</c:otherwise> 
						</c:choose>
						
					</select>&nbsp&nbsp
					<label class="input_label">状态：</label>
					<select id="fstate" name="fileNamesLog.fstate">
						<c:choose>
							<c:when test="${fileNamesLog.fstate==1}">   
								<option value="">--</option>
								<option value="1" selected="selected">待审核</option>
								<option value="2">已审核</option>
								<option value="3">驳回</option>
							</c:when>
							<c:when test="${fileNamesLog.fstate==2}">   
								<option value="">--</option>
								<option value="1">待审核</option>
								<option value="2" selected="selected">已审核</option>
								<option value="3">驳回</option>
							</c:when>
							<c:when test="${fileNamesLog.fstate==3}">   
								<option value="">--</option>
								<option value="1">待审核</option>
								<option value="2">已审核</option>
								<option value="3" selected="selected">驳回</option>
							</c:when>
							<c:otherwise>   
    							<option value="" selected="selected">--</option>
								<option value="1">待审核</option>
								<option value="2">已审核</option>
								<option value="3">驳回</option>
  							</c:otherwise> 
						</c:choose>
					</select>&nbsp&nbsp
					<label class="input_label">排序：</label>
					<select name="fileNamesLog.pid" id="pid">
						<option value="">--</option>
						<c:choose>
						<c:when test="${fileNames.pid==1}">
							<option value="1" selected="selected">按时间</option>
							<option value="2">按公司</option>
						</c:when>
						<c:when test="${fileNames.pid==2}">
							<option value="1">按时间</option>
							<option value="2"  selected="selected">按公司</option>
						</c:when>
						<c:otherwise>
							<option value="1">按时间</option>
							<option value="2" >按公司</option>
						</c:otherwise>
						</c:choose>
					</select>
					&nbsp&nbsp<label class="input_label">处理时间：</label>
					<input type="text" id="changeTime" value="${fileNamesLog.fbak1}" name="fileNamesLog.fbak1" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
					&nbsp&nbsp&nbsp&nbsp
					<input type="submit" id="searchBtn" value="查&nbsp;&nbsp;询" class="ui_input_btn01"/>
					&nbsp&nbsp&nbsp&nbsp
					<input  id="pass" value="全部通过" class="ui_input_btn01" onclick="passMessages()"/>
				</div>
			</div>
		</div>
	</div>
	<div class="ui_content">
		<div class="ui_tb">
			<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
				<tr class="TableHeader"> 
					<th>单位名称</th>
					<th>地址</th>
					<th>联系人</th>
					<th>性别</th>
					<th>职务</th>
					<th>办公室电话</th>
					<th>手机号</th>
					<th>操作人</th>
					<th>状态</th>
					<th>处理日期</th>
					<th>操作</th>
				</tr>
				<c:choose>
				<c:when test="${empty pm.datas}">
					<tr><td colspan="11"></td></tr>
				</c:when>
					<c:otherwise>
						<c:forEach var="bean" items="${pm.datas}">
							<tr>
								<td>${bean.compnyName}</td>
								<td>${bean.address}</td>
								<td>${bean.linkmn}</td>
								<td>${bean.sex}</td>
								<td>${bean.post}</td>
								<td>${bean.officePhone}</td>
								<td>${bean.phone}</td>
								<td>
									<c:forEach items="${userList}" var="userList">
										<c:if test="${userList.userID==bean.userId}">
											${userList.userName}
										</c:if>
									</c:forEach>
								</td>
								<%-- <td><fmt:formatDate value="${bean.birthday}" pattern="yyyy年MM月dd日"/></td> --%>
								<td>
									<c:if test="${bean.fmonily==1}">
										新增
									</c:if>
									<c:if test="${bean.fmonily==2}">
										删除
									</c:if>
									<c:if test="${bean.fmonily==3}">
										修改
									</c:if>
									<c:if test="${bean.fstate==1}">
										待审核
									</c:if>
									<c:if test="${bean.fstate==2}">
										已审核
									</c:if>
									<c:if test="${bean.fstate==3}">
										驳回
									</c:if>
								</td>
								<td>${fn:substring(bean.changeTime, 0, 10)}</td>
								<td>
								
								<c:if test="${bean.fstate==1}">
									<a href="javascript:void(0)" onclick="exam('${bean.id}',1)">通过</a>   &nbsp
									<a href="javascript:void(0)" onclick="exam('${bean.id}',2)">驳回</a>&nbsp 
								</c:if>
								
								
								<a href="javascript:void(0)" onclick="lookFilesLog('${bean.id}')">查看</a>
								<%--  <c:forEach var="op" items="${blist}">
								      <c:if test="${op.CValue eq 8}">
									         <a href="javascript:void(0)" onclick="toUpdateCompany('${bean.companyID}')">编辑</a>
									  </c:if> 
								      <c:if test="${op.CValue eq 4}"> 
									         <a href="javascript:void(0)" onclick="delCompany('${bean.companyID}')">删除</a>
									 </c:if> 
								 </c:forEach> --%>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
</div>
<w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/action/fileNamesLog/showFileNamesLog" recordCount="${pm.recordCount}" />
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</form>
</div>
</body>
</html>