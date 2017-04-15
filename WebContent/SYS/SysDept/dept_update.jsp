<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="page" uri="/WEB-INF/page-tag.tld"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", path);
	request.setAttribute("basePath", basePath);
%>
<link rel="stylesheet" href="${path}/css/default.css" type="text/css"/>
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css"/>
<link rel="stylesheet" href="${path}/css/Css.css" type="text/css"/>
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/SYS/SysDept/dept.js"></script>
<div class="container" id="tb_WarnSelect_div">
<input id="basePath" type="hidden" value="${basePath}"/>
<input type="hidden" value="${dept.deptID}" id="deptID">
<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
	<tr>
		<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">部门名称：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${dept.deptName}" id="deptName">
        </td>
       <!--  <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">上级部门：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	上级部门
        </td> -->
	</tr>
	<%-- <tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">部门负责人：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
			<input type="text" value="${dept.deptMG}" id="deptMG">
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">负责人电话：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
           	<input type="text" value="${dept.deptMGTel}" id="deptMGTel" onkeyup="value=value.replace(/\D/g,'')">
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">办公电话：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
			<input type="text" value="${dept.deptTel}" id="deptTel" onkeyup="value=value.replace(/\D/g,'')">
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">办公传真：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
           	<input type="text" value="${dept.deptFax}" id="deptFax" onkeyup="value=value.replace(/\D/g,'')">
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">办公地址：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
			<input type="text" value="${dept.deptAddr}" id="deptAddr">
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">邮编：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
           	<input type="text" value="${dept.deptPost}" id="deptPost" onkeyup="value=value.replace(/\D/g,'')">
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">部门状态：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
			<select id="deptState">
     			<option value="0" <c:if test="${dept.deptState == '0'}">selected</c:if>>有效</option>
     		   	<option value="1" <c:if test="${dept.deptState == '1'}">selected</c:if>>无效</option>
      		</select> 
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">所属网点：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
           	<select id="deptBranchID">
     			<option value="0" <c:if test="${dept.deptBranchID == '0'}">selected</c:if>>是</option>
     		   	<option value="1" <c:if test="${dept.deptBranchID == '1'}">selected</c:if>>不是</option>
      		</select>
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">分公司标志：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
			<select id="deptFlag">
     			<option value="0" <c:if test="${dept.deptFlag == '0'}">selected</c:if>>是</option>
     		   	<option value="1" <c:if test="${dept.deptFlag == '1'}">selected</c:if>>不是</option>
      		</select> 
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">是否网点：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
           	<select id="deptIsBR">
     			<option value="0" <c:if test="${dept.deptIsBR == '0'}">selected</c:if>>是</option>
     		   	<option value="1" <c:if test="${dept.deptIsBR == '1'}">selected</c:if>>不是</option>
      		</select>
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">是否信审部：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
			<select id="deptIsCR">
     			<option value="0" <c:if test="${dept.deptIsCR == '0'}">selected</c:if>>是</option>
     		   	<option value="1" <c:if test="${dept.deptIsCR == '1'}">selected</c:if>>不是</option>
      		</select> 
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">是否客服：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
           	<select id="deptIsCS">
     			<option value="0" <c:if test="${dept.deptIsCS == '0'}">selected</c:if>>是</option>
     		   	<option value="1" <c:if test="${dept.deptIsCS == '1'}">selected</c:if>>不是</option>
      		</select>
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">部门描述：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
           	<input type="text" value="${dept.deptDesc}" id="deptDesc">
        </td>
	</tr> --%>
</table>
&nbsp;
<div class="box_btn" align="center">
<input type="button" value="保&nbsp;&nbsp;存" onclick="updateDept()"/> 
<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
</div>
</div>