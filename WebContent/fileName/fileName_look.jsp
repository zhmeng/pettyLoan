<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/comment/comment.jsp"%>
<link rel="stylesheet" href="${path}/css/default.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/Css.css" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/fileName/fileName.js"></script>
<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
				<input id="basePath" type="hidden" value="${basePath}"/>
				<div class="infotitle">
					<h3>查看公司信息<font color="red">(${fileNames.isdelete})</font></h3>
				</div>
				
				<div class="infocontent">
					<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
	                    <tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">邮编：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	${fileNames.zipCode}
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">地址：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	${fileNames.address}
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">公司名：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	${fileNames.compnyName}
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">所在部门：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	${fileNames.department}
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">联系人：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	${fileNames.linkmn}
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">性别：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<!-- <select id="sex" name="sex">
		                    		<option value="男">男</option>
		                    		<option value="女">女</option>
		                    	</select> -->
		                    	${fileNames.sex}
		                    	<!--<input type="text" id="sex" name="sex" onkeyup="value=value.replace(/\D/g,'')"/>  -->
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">职务：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	${fileNames.post}
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">办公室电话：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	${fileNames.officePhone}
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">手机号：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	${fileNames.phone}
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">qq：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	${fileNames.qq}
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">邮箱：</td>
		                     <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	${fileNames.email}
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">家庭电话：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	${fileNames.fimallyPhone}
		                    </td>
						</tr>
						
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">生日：</td>
		                     <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	${fileNames.birthday}
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">URL地址：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	${fileNames.url}
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">上级公司：</td>
		                     <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                     	${lastName}
		                     	<%-- <c:forEach items="${listFile}" var="listFile">
		                    			<c:if test="${listFile.id==fileNames.pid}">
		                    				${listFile.compnyName}
		                    				<option value="${listFile.id}" selected="selected">${listFile.compnyName}</option>
		                    			</c:if>
		                    	</c:forEach> --%>
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">公司类型：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<c:forEach items="${deptList}" var="deptList">
		                    			<c:if test="${deptList.deptID==fileNames.compClass}">
		                    				${deptList.deptName}
		                    				<%-- <option value="${deptList.deptID}" selected="selected">${deptList.deptName}</option> --%>
		                    			</c:if>
		                    	</c:forEach>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">操作者：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;" colspan="3">
		                    	<c:forEach items="${userList}" var="userList">
										<c:if test="${userList.userID==bean.userId}">
											${userList.userName}
										</c:if>
								</c:forEach>
		                    	
		                    </td>
						</tr>
						<tr>
							 <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">备注：</td>
		                     <td style="padding-top: 2px; padding-left: 2px;" class="style2" colspan="3">
		                    	${fileNames.remark}
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">标记时间：</td>
		                     <td style="padding-top: 2px; padding-left: 2px;" class="style2" colspan="3">
		                    	<c:forEach items="${excelList}" var="excelList">
										${excelList.downTime}&nbsp&nbsp&nbsp&nbsp<c:if test="${excelList.status==1}">标记</c:if>
										<c:if test="${excelList.status==2}">撤销</c:if></br>
								</c:forEach>
		                    </td>
		                   
						</tr>
					</table>
				</div>				
			</div>
		</div>&nbsp;
		<div class="box_btn" align="center">
			<!-- <input type="button" value="保&nbsp;&nbsp;存" onclick="addFiles()"/>  -->
			<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
		</div>
	</div>
</div>