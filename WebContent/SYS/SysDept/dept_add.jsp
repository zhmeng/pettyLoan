<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", path);
	request.setAttribute("basePath", basePath);
%>
<link rel="stylesheet" href="${path}/css/default.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/Css.css" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/SYS/SysDept/dept.js"></script>
<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
				<input id="basePath" type="hidden" value="${basePath}"/>
				<div class="infotitle">
					<h3>添加部门</h3>
				</div>
				<div class="infocontent">
					<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
	                    <tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">部门名称：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="deptName" name="deptName"/>
		                    </td>
						
						
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">部门状态：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<select id="deptState">
							 		<option value="0">有效</option>
							 		<option value="1">无效</option>
							 	</select>
		                    </td>
		                   
						</tr>
						
					</table>
				</div>				
			</div>
		</div>&nbsp;
		<div class="box_btn" align="center">
			<input type="button" value="保&nbsp;&nbsp;存" onclick="addDept()"/> 
			<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
		</div>
	</div>
</div>