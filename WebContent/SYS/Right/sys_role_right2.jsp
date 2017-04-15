<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> --%>
<%@page import="bsh.This"%>
<%@page import="org.apache.struts2.components.Bean"%>
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
<link href="${path}/syscss/basic_layout.css" rel="stylesheet" type="text/css">
<link href="${path}/syscss/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/SYS/Right/sys_right.js"></script>
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
<body id="body">
<div id="userinfoContainer" class="container" >
<div class="container" id="tb_WarnSelect_div">
<input id="basePath" type="hidden" value="${basePath}"/>
<form action="${basePath}action/right/AddRights">
<div class="place">
    <ul class="placeul">
    </ul>
    </div>
    
    
    
    
   <div id="container">
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
					<input id="id" type="hidden" name="id" value="${id}"/>
						<input id="pd" type="hidden" name="rpd" value="${rpd}"/>
						<tr class="TableHeader"> 
							<th>菜单权限</th>
							<th>按钮权限</th>
							<th>数据权限</th>
				</tr>
				
					<c:forEach var="bean" items="${modules }">
					<tr>
							<td>${bean.modName}</td>
					<c:forEach var="op" items="${oplist}">
							<c:if test="${op.mid==bean.modID}">
								<c:if test="${op.look==1}">
								<td>
									<c:forEach items="${op.checkboxList}" var="checkboxList">
										<c:choose>
											<c:when test="${checkboxList.isCheck==1}">
												<input type="checkbox" value="${checkboxList.CValue}"
													checked="true" name="${bean.modID}s" />
											</c:when>
											<c:otherwise>
												<input type="checkbox" value="${checkboxList.CValue}"
													name="${bean.modID}s" />
											</c:otherwise>
										</c:choose>
										 		${checkboxList.CName}
										 	</c:forEach>
										 	</td>
										 	<td>
									<c:forEach items="${op.radiosList}" var="radio">
										<c:choose>
											<c:when test="${radio.isCheck==1}">
												<input type="radio" value="${radio.CValue}" checked="true"
													name="${bean.modID}r" />
											</c:when>
											<c:otherwise>
												<input type="radio" value="${radio.CValue}"
													name="${bean.modID}r" />
											</c:otherwise>
										</c:choose>
										 		${radio.cName}
										 	</c:forEach>
										 	</td>
									

								</c:if>
							</c:if>
						</c:forEach>
						</tr>
				</c:forEach>
				
					</table>
			  </div>
			</div>
		</div> 
    <input type="submit" value="保&nbsp;&nbsp;存"/>
</form>
</div>
<!-- <div class="box_btn">
			 <input type="button" value="保&nbsp;&nbsp;存"
				onclick="save_rolerights()" /> <input type="button" id="reset" onclick="dialogclose()"
				class="btn btn_gray mgl-30" value="取&nbsp;&nbsp;消" />
		</div> -->
</div>
