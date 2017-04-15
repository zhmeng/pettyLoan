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
<script type="text/javascript" src="${path}/fileName/fileName.js"></script>
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
<%-- <form action="${path}/action/fileNames/upload" method="post" enctype="multipart/form-data">  
						<input type="file" name="files" id="files"/> </br>
						<input type="submit" value="导入数据" />
					</form>  --%>
<form id="searchForm" action="${path}/action/fileNames/showFileNames" method="post">
 <input type="hidden" value="${modId}" name="modId" id="modId"/> 
<div class="place"><ul class="placeul"></ul></div>
<div id="container">
	<div class="ui_content">
		<div class="ui_text_indent">
			<div id="box_border">
				<div class="box_bottom">
					<label class="input_label">公司名称：</label>
					<input id="compnyName" name="fileNames.compnyName" value="${fileNames.compnyName}"  type="text" class="input_text" />
					&nbsp&nbsp<label class="input_label">所在部门：</label>
					<input id="department" name="fileNames.department" value="${fileNames.department}"   type="text" class="input_text" />
					&nbsp&nbsp<label class="input_label">联系人：</label>
					<input id="linkmn" name="fileNames.linkmn" value="${fileNames.linkmn}"  type="text" class="input_text" />
					&nbsp&nbsp<label class="input_label">公司地址：</label>
					<input id="address" name="fileNames.address" value="${fileNames.address}"  type="text" class="input_text" /></br>
					&nbsp&nbsp<label class="input_label">公司类型：</label>
					<%-- <c:forEach var="deptList" items="${deptList}">
										<c:if test="${deptList.deptID==bean.compClass}">
											${deptList.deptName}
										</c:if>
									</c:forEach> --%>
					<select name="fileNames.compClass"  id="compClass">
						<option value="">--</option>
						<c:forEach var="deptList" items="${deptList}">
							<c:choose>
								<c:when test="${deptList.deptID==fileNames.compClass}">
									<option value="${deptList.deptID}" selected="selected">${deptList.deptName}</option>
								</c:when>
								<c:otherwise>
									<option value="${deptList.deptID}">${deptList.deptName}</option>
								</c:otherwise>
							</c:choose>
							<%-- <c:if test="${deptList.deptID==fileNames.compClass}">
								<option value="${deptList.deptID}" selected="selected">${deptList.deptName}</option>
							</c:if>
							<option value="${deptList.deptID}">${deptList.deptName}</option> --%>
						</c:forEach>
					</select>
					&nbsp&nbsp<label class="input_label">员工职务：</label>
					<input name="fileNames.post" value="${fileNames.post}"  id="post" type="text" class="input_text" />
					&nbsp&nbsp<label class="input_label">手机号码：</label>
					<input name="fileNames.officePhone" value="${fileNames.officePhone}"  id="post" type="text" class="input_text" />
					&nbsp&nbsp<label class="input_label">子公司查询：</label>
					<input  name="fileNames.fbak2" value="${fileNames.fbak2}"  id="fbak2" type="text" class="input_text" /></br>
					&nbsp&nbsp<label class="input_label">是否标记：</label>
					<select name="fileNames.isdelete" id="isdelete">
						<option value="">--</option>
						<c:choose>
						<c:when test="${fileNames.isdelete==1}">
							<option value="1" selected="selected">标记</option>
							<option value="2">信息正确</option>
							<option value="3">画册退回</option>
							<option value="4">待确认</option>
							<option value="5">不是负责人</option>
							<option value="6">已离职/退休/调离</option>
							<option value="7" >撤销</option>
							<option value="8">跟进标记</option>
							<option value="9">未寄画册/默认正确</option>
						</c:when>
						<c:when test="${fileNames.isdelete==2}">
							<option value="1">标记</option>
							<option value="2" selected="selected">信息正确</option>
							<option value="3">画册退回</option>
							<option value="4">待确认</option>
							<option value="5">不是负责人</option>
							<option value="6">已离职/退休/调离</option>
							<option value="7" >撤销</option>
							<option value="8">跟进标记</option>
							<option value="9">未寄画册/默认正确</option>
						</c:when>
						<c:when test="${fileNames.isdelete==3}">
							<option value="1">标记</option>
							<option value="2">信息正确</option>
							<option value="3" selected="selected">画册退回</option>
							<option value="4">待确认</option>
							<option value="5">不是负责人</option>
							<option value="6">已离职/退休/调离</option>
							<option value="7" >撤销</option>
							<option value="8">跟进标记</option>
							<option value="9">未寄画册/默认正确</option>
						</c:when>
						<c:when test="${fileNames.isdelete==4}">
							<option value="1">标记</option>
							<option value="2">信息正确</option>
							<option value="3">画册退回</option>
							<option value="4" selected="selected">待确认</option>
							<option value="5">不是负责人</option>
							<option value="6">已离职/退休/调离</option>
							<option value="7" >撤销</option>
							<option value="8">跟进标记</option>
							<option value="9">未寄画册/默认正确</option>
						</c:when>
						<c:when test="${fileNames.isdelete==5}">
							<option value="1">标记</option>
							<option value="2">信息正确</option>
							<option value="3">画册退回</option>
							<option value="4">待确认</option>
							<option value="5" selected="selected">不是负责人</option>
							<option value="6">已离职/退休/调离</option>
							<option value="7" >撤销</option>
							<option value="8">跟进标记</option>
							<option value="9">未寄画册/默认正确</option>
						</c:when>
						<c:when test="${fileNames.isdelete==6}">
							<option value="1">标记</option>
							<option value="2">信息正确</option>
							<option value="3">画册退回</option>
							<option value="4">待确认</option>
							<option value="5">不是负责人</option>
							<option value="6"  selected="selected">已离职/退休/调离</option>
							<option value="7" >撤销</option>
							<option value="8">跟进标记</option>
							<option value="9">未寄画册/默认正确</option>
						</c:when>
						<c:when test="${fileNames.isdelete==7}">
							<option value="1">标记</option>
							<option value="2">信息正确</option>
							<option value="3">画册退回</option>
							<option value="4">待确认</option>
							<option value="5">不是负责人</option>
							<option value="6" >已离职/退休/调离</option>
							<option value="7" selected="selected">撤销</option>
							<option value="8">跟进标记</option>
							<option value="9">未寄画册/默认正确</option>
						</c:when>
						<c:when test="${fileNames.isdelete==8}">
							<option value="1">标记</option>
							<option value="2">信息正确</option>
							<option value="3">画册退回</option>
							<option value="4">待确认</option>
							<option value="5">不是负责人</option>
							<option value="6" >已离职/退休/调离</option>
							<option value="7">撤销</option>
							<option value="8" selected="selected">跟进标记</option>
							<option value="9">未寄画册/默认正确</option>
						</c:when>
						<c:when test="${fileNames.isdelete==9}">
							<option value="1">标记</option>
							<option value="2">信息正确</option>
							<option value="3">画册退回</option>
							<option value="4">待确认</option>
							<option value="5">不是负责人</option>
							<option value="6" >已离职/退休/调离</option>
							<option value="7">撤销</option>
							<option value="8">跟进标记</option>
							<option value="9" selected="selected">未寄画册/默认正确</option>
						</c:when>
						<c:otherwise>
							<option value="1">标记</option>
							<option value="2">信息正确</option>
							<option value="3">画册退回</option>
							<option value="4">待确认</option>
							<option value="5">不是负责人</option>
							<option value="6">已离职/退休/调离</option>
							<option value="7" >撤销</option>
							<option value="8">跟进标记</option>
							<option value="9">未寄画册/默认正确</option>
						</c:otherwise>
						</c:choose>
					</select>
					<label class="input_label">标记时间：</label>
					<input type="text" id="times" value="${fileNames.fbak1}" name="fileNames.fbak1" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />-
					<input type="text" id="endtimes" value="${fileNames.zipCode}" name="fileNames.zipCode" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
					&nbsp&nbsp
					<label class="input_label">排序：</label>
					<select name="fileNames.pid" id="pid">
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
					&nbsp&nbsp
					<input type="submit" id="searchBtn" value="查&nbsp;&nbsp;询" class="ui_input_btn01"/>
					<input type="button" id="modify_btn" onclick="toAddfileName()" value="添&nbsp;&nbsp;加" class="ui_input_btn01"/>
					<input type="button" value="导出excel数据" onclick="excel()"/>
					<input type="button" value="导入excel数据" onclick="upexcel()"/>
				</div>
			</div>
		</div>
	</div>
	<div class="ui_content">
		<div class="ui_tb">
			<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
				<tr class="TableHeader"> 
					<th>单位名称</th>
					<th>所在部门</th>
					<th>联系人</th>
					<th>性别</th>
					<th>职务</th>
					<th>办公室电话</th>
					<th>手机号</th>
					<!-- <th>操作人</th> -->
					<th>标记时间</th>
					<th>公司类型</th>
					<th>状态</th>
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
								<td>${bean.department}</td>
								<td>${bean.linkmn}</td>
								<td>${bean.sex}</td>
								<td>${bean.post}</td>
								<td>${bean.officePhone}</td>
								<td>${bean.phone}</td>
								<%-- <td>
									<c:forEach items="${userList}" var="userList">
										<c:if test="${userList.userID==bean.userId}">
											${userList.userName}
										</c:if>
									</c:forEach>
								</td> --%>
								<td>${fn:substring(bean.lastExcelTime, 0, 10)}<br /> <%-- ${bean.lastExcelTime} --%> </td>
								<%-- <td><fmt:formatDate value="${bean.birthday}" pattern="yyyy年MM月dd日"/></td> --%>
								<td><%-- ${bean.compClass} --%>
									<c:forEach var="deptList" items="${deptList}">
										<c:if test="${deptList.deptID==bean.compClass}">
											${deptList.deptName}
										</c:if>
									</c:forEach>
								</td>
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
								<td>
								<c:if test="${bean.fstate==1 and bean.fmonily!=2}">
									<a href="javascript:void(0)" onclick="toUpdate2('${bean.id}')">编辑</a>
								</c:if>
								<c:if test="${bean.fstate==2}">
									<a href="javascript:void(0)" onclick="toUpdate('${bean.id}')">编辑</a>   &nbsp  
									<a href="javascript:void(0)"  onclick="delFile('${bean.id}','${bean.compnyName}')">删除</a>
									<%-- <a href="javascript:void(0)"  onclick="sign('${bean.id}')">标记</a> --%>
									<a href="javascript:void(0)"  onclick="rvsign('${bean.id}')">标记</a>
								</c:if>&nbsp 
								<c:choose>
									<c:when test="${bean.remark!='' && bean.remark!=null}">
										<a href="javascript:void(0)" onclick="lookFiles('${bean.id}')"></font>查看(注)</a>
									</c:when>
									<c:otherwise>
										<a href="javascript:void(0)" onclick="lookFiles('${bean.id}')"></font>查看</a>
									</c:otherwise>
								</c:choose>
								
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
</form>
<w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/action/fileNames/showFileNames" recordCount="${pm.recordCount}" />
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</div>
</body>
</html>
<%-- <fmt:formatNumber value="${userM.testSum }" pattern="#,##0.00#" /> --%>
<%-- <fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /> --%>



