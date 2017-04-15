<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="page" uri="/WEB-INF/page-tag.tld"%>

<div class="container" id="tb_WarnSelect_div">
<table class="TableList" width="100%" style="font-family:'Microsoft YaHei',Arial,Helvetica,sans-serif,'宋体'">
	<thead>
		<tr class="TableHeader"> 
			<th>机构编号</th>
			<th>部门名称</th>
			<th>负责人</th>
			<th>是否网点</th>
			<th>信审部</th>
			<th>客服部门</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty sysDept}">
				<tr>
					<td colspan="6"></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="bean" items="${sysDept}">
					<tr>
						<td>${bean.deptID }</td>
						<td>${bean.deptName}</td>
						<td>${bean.deptMG}</td>
						<td>
							<c:if test="${bean.deptIsBR==1}">
								是
							</c:if>
							<c:if test="${bean.deptIsBR==0}">
								否
							</c:if>
						</td>
						<td>
							<c:if test="${bean.deptIsCR==0}">是</c:if>
							<c:if test="${bean.deptIsCR==1}">否</c:if>
						</td>
						<td>
							<c:if test="${bean.deptIsCS==0}">是</c:if>
							<c:if test="${bean.deptIsCS==1}">否</c:if>
						</td>
						<td>
						<%-- <a href="javascript:void(0)" onclick="setDept(${bean.deptID})">设置职位</a> --%>
						<a href="javascript:void(0)" onclick="updateDept('${bean.deptID}')">编辑</a>
						<a href="javascript:void(0)" onclick="delDept('${bean.deptID}')">删除</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
</div>
