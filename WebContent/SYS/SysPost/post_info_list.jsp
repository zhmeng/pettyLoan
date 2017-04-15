<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="page" uri="/WEB-INF/page-tag.tld"%>
<script type="text/javascript">

</script>
<div class="container" id="tb_WarnSelect_div">
<table id="tb_userinfo" border="0" cellpadding="0" cellspacing="0"
	class="tabstyle resizable">
	<thead>
		<tr>
			<th>职位编号</th>
			<th>职位名称</th>
			<th>部门</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty sysPost}">
				<tr>
					<td colspan="6"></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="bean" items="${sysPost}">
					<tr>
						<td>${bean.PostID }</td>
						<td>${bean.PostName}</td>
						<td>${bean.PostIsDept}</td>
						<td>
						<a href="javascript:void(0)" onclick="updatePost(${bean.DeptID})">编辑</a>
						<a href="javascript:void(0)" onclick="delPost(${bean.DeptID})">删除</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
</div>
<%--  <input type="hidden" id="curPage" name="curPage" value="${pageUtil.pageId}" />
		  <page:createPager pageSize="${pageUtil.pageSize}" totalPage="${pageUtil.pageCount}" 
totalCount="${pageUtil.rowCount}" curPage="${pageUtil.pageId}" />   
 --%>