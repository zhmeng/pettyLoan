<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> --%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<%-- <%@ include file="../js/lhgdialog.js"%> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="page" uri="/WEB-INF/page-tag.tld"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path",path);
request.setAttribute("basePath",basePath);
%> 
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/SYS/SysRole/sys_role.js"></script>
<script type="text/javascript">

</script>
<div class="container" id="tb_WarnSelect_div">
<input id="basePath" type="hidden" value="${basePath}"/>
<!-- <table id="tb_userinfo" border="0" cellpadding="0" cellspacing="0"
	class="tabstyle resizable"> -->
		<c:choose>
			<c:when test="${empty sysRoles}">
				<tr>
					< colspan="6">
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="bean" items="${sysRoles}">
					<!-- <tr> -->
						<label>角色编号：</label><input type="text" value="${bean.roleId}" id="roleId">
						<label>角色名称：</label><input type="text" value="${bean.roleName}" id="roleName"></br>
						<%-- <input type="hidden" value="${bean.deptID}" id="DeptID"> --%>
						<label>角色状态：</label>
							<select id="roleState" name="roleState">
							 	<option value="0">正常</option>
							 	<option value="1">预留</option>
							 	<option value="3">关闭</option>
							 </select>
					<!-- </tr>	 -->
				</c:forEach>
			</c:otherwise>
		</c:choose>
</table>
<div class="box_btn">
			<input type="button" value="保&nbsp;&nbsp;存"
				onclick="save_contract()" /> <input type="button" id="reset" onclick="dialogclose()"
				class="btn btn_gray mgl-30" value="取&nbsp;&nbsp;消" />
		</div>
</div>
