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
			<th>用户名</th>
			<th>员工编号</th>
			<th>所在部门</th>
			<th>手机号</th>
			<th>员工住址</th>
			<th>性别</th>
			<th>身份证号</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty sysUser}">
				<tr>
					<td colspan="6"></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="bean" items="${sysUser}">
					<tr>
						<td>${bean.UserName }</td>
						<td>${bean.UserNO}</td>
						<td>${bean.UserIsDept}</td>
						<td>${bean.UserMob }</td>
						<td>${bean.UserAddr}</td>
						<td>${bean.UserSex}</td>
						<td>${bean.UserIDCard }</td>
						<td>
						<a href="javascript:void(0)" onclick="updateUser(${bean.UserID})">编辑</a>
						<a href="javascript:void(0)" onclick="delUser(${bean.UserID})">删除</a>
						<a href="javascript:void(0)" onclick="delUser(${bean.UserID})"></td>
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