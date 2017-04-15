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
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/SYS/Right/sys_right.js"></script>
<script type="text/javascript">
window.onload=function(){
	var pds=$("#pds").val();
	//alert(pds);
	if(pds==1){
		alert("编辑成功");
		window.close();
	}
}
</script>
<div class="container" id="tb_WarnSelect_div">
<input id="basePath" type="hidden" value="${basePath}"/>
<input id="pds" type="pds" value="${pds}"/>
<form action="${basePath}action/right/AddRights">
<table  width="85%" border="1" align="center" cellspacing="0"  bordercolor="#6699FF" style=" border:0.5px;">

			<c:if test="${empty modules}">
				<tr>
					<td colspan="4"></td>
				</tr>
			</c:if>
			<tr>
					<td colspan="3"><label>菜单权限：</label>
					<input id="id" type="hidden" name="id" value="${id}"/>
						<input id="pd" type="hidden" name="rpd" value="${rpd}"/>
					</td>
			</tr>
						<c:forEach var="bean" items="${modules }">
						<tr>
							<td><td>${bean.modName}</td>
							
								<c:forEach var="op" items="${oplist}">							
										 <c:if test="${op.mid==bean.modID}">
										 	<c:if test="${op.look==1}">
										 	<td width="300px">
										 	<c:forEach items="${op.checkboxList}" var="checkboxList">
										 		 <c:choose >
										 		 <c:when test="${checkboxList.isCheck==1}">
										 		 	<input type="checkbox" value="${checkboxList.CValue}" checked="true" name="${bean.modID}s" />
										 		 </c:when>
										 		 <c:otherwise>
										 			<input type="checkbox" value="${checkboxList.CValue}"  name="${bean.modID}s" />
										 		</c:otherwise>
										 		</c:choose>
										 		${checkboxList.CName}
										 	</c:forEach>
										 	</td>
										 	<td>
										 	<c:forEach	items="${op.radiosList}" var="radio">
										 		 <c:choose >
										 		 <c:when test="${radio.isCheck==1}">
										 		 	<input type="radio" value="${radio.CValue}" checked="true" name="${bean.modID}r" />
										 		 </c:when>
										 		 <c:otherwise>
										 			<input type="radio" value="${radio.CValue}"  name="${bean.modID}r" />
										 		</c:otherwise>
										 		</c:choose>
										 		${radio.cName}
										 	</c:forEach>
										 	</td>
										 	<%-- <c:forEach items="${rightlist}" var="rl"> --%>
										 		<td>
										 		<%--<c:choose >
										 		 <c:when test="${checkboxList.isradio==1}">
										 		 	<input type="radio" value="1" checked="true" name="${bean.modID}s" />
										 		 	个人权限:<input type="radio" name="${bean.modID}s" value="1">&nbsp;
										 			团队权限:<input type="radio" name="${bean.modID}s" value="10">&nbsp;
										 			所有权限:<input type="radio" name="${bean.modID}s" value="100">
										 		 </c:when>
										 		 <c:otherwise>
										 			<input type="radio" value="1"  name="${bean.modID}s" />
										 		</c:otherwise>
										 		</c:choose> --%>
										 		
										 		<%-- 个人权限:<input type="radio" name="${bean.modID}s" value="1">&nbsp;
										 		团队权限:<input type="radio" name="${bean.modID}s" value="10">&nbsp;
										 		所有权限:<input type="radio" name="${bean.modID}s" value="100"> --%>
										 		</td>
										 	<%-- </c:forEach> --%>
										 	
											</c:if>
										</c:if>
										</c:forEach>
							</td>
							
						</tr>
						</c:forEach>
						<tr>
							<td colspan="3"><input type="submit" value="保&nbsp;&nbsp;存"/></td>
						</tr>
									<%-- <c:forEach var="bean" items="${modules }">
										<tr><td>${bean.modName}</td></tr>
										<tr><td>
											<c:forEach var="op" items="${oplist}">							
										 <c:if test="${op.mid==bean.modID}">
										 	<c:if test="${op.look==1}">
										 	<c:forEach items="${op.checkboxList}" var="checkboxList">
										 		${checkboxList.ID}${checkboxList.CName}
										 		 <c:choose >
										 		 <c:when test="${checkboxList.isCheck==1}">
										 		 	${checkboxList.CValue}
										 		 	<input type="checkbox" value="${checkboxList.CValue}" checked="true" name="${bean.modID}s" />
										 		 </c:when>
										 		 <c:otherwise>
										 		 	${checkboxList.CValue}
										 			<input type="checkbox" value="${checkboxList.CValue}"  name="${bean.modID}s" />
										 		</c:otherwise>
										 		</c:choose>
										 	
										 	</c:forEach>
										 	
											</c:if>
										</c:if>
										</c:forEach>&nbsp;&nbsp;
										</td></tr>
										<tr><td>
										个人权限:<input type="radio" name="RightsModData" value="1">&nbsp;部门权限:<input type="radio" name="RightsModData" value="10">&nbsp;公司权限:<input type="radio" name="RightsModData" value="100">
										</td></tr>	</br>  
									</c:forEach> --%>
								
							
		<!-- <input type="submit" value="保&nbsp;&nbsp;存"/> -->
		</table>
</form>
<div class="box_btn">
			<!-- <input type="button" value="保&nbsp;&nbsp;存"
				onclick="save_rolerights()" /> <input type="button" id="reset" onclick="dialogclose()"
				class="btn btn_gray mgl-30" value="取&nbsp;&nbsp;消" /> -->
		</div>
</div>
