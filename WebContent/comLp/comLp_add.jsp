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
<script type="text/javascript" src="${path}/comLp/comLp.js"></script>
<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
				<input id="basePath" type="hidden" value="${basePath}"/>
				<div class="infotitle">
					<h3>添加楼盘</h3>
				</div>
				<div class="infocontent">
					<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
	                    <tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">楼盘编号：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="lpKey" name="lpKey"/>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">楼盘名称：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="lpName" name="lpName"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">负责人姓名：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="lpGM" name="lpGM"/>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">负责人电话：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="lpTel" name="lpTel" onkeyup="value=value.replace(/\D/g,'')"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">城市：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
							 	<select name="cityID" id="cityID">
							      	<c:forEach var="item" items="${cityList}">
							    		<option value="<c:out value="${item.ID}"/>"><c:out value="${item.cityName}"/></option>
							    	</c:forEach>						 
					        	</select>
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">开发商：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
							 	<select name="companyID" id="companyID">
							      	<c:forEach var="item" items="${companyList}">
							    		<option value="<c:out value="${item.companyID}"/>"><c:out value="${item.companyName}"/></option>
							    	</c:forEach>						 
					        	</select>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">楼盘状态：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<select id="lpState">
							 		<option value="0">无效</option>
							 		<option value="1">生效</option>
							 		<option value="2">过期</option>
							 		<option value="4">删除</option>
							 	</select>
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">楼盘地址：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="lpAddr" name="lpAddr"/>
		                    </td>
						</tr>
					</table>
				</div>				
			</div>
		</div>&nbsp;
		<div class="box_btn" align="center">
			<input type="button" value="保&nbsp;&nbsp;存" onclick="addComLp()"/> 
			<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
		</div>
	</div>
</div>