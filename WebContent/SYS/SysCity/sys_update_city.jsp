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
<link rel="stylesheet" href="${path}/css/default.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/Css.css" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/SYS/SysCity/sys_city.js"></script>
<script type="text/javascript">

</script>
<div class="container" id="tb_WarnSelect_div">
<input id="basePath" type="hidden" value="${basePath}"/>
<!-- <table id="tb_userinfo" border="0" cellpadding="0" cellspacing="0"
	class="tabstyle resizable"> -->
		<c:choose>
			<c:when test="${empty city}">
				<tr>
					< colspan="6">
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="bean" items="${city}">
						<label>城市ID：</label><input type="text" value="${bean.cityID}" id="cityID">
						<label>城市名称：</label><input type="text" value="${bean.cityName}" id="cityName"></br>
						<input type="hidden" value="${bean.cityID}" id="cityID">
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
