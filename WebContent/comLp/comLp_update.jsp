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
<link rel="stylesheet" href="${path}/css/default.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/Css.css" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/comLp/comLp.js"></script>
<div class="container" id="tb_WarnSelect_div">
<input id="basePath" type="hidden" value="${basePath}"/>
	<c:forEach var="bean" items="${comLp}">
		<input type="hidden" value="${bean.lpID}" id="lpID">
		<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
            <tr>
             	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">楼盘编号：</td>
             	<td style="padding-top: 2px; padding-left: 2px;" class="style2">
             		<input type="text" value="${bean.lpKey}" id="lpKey">
             	</td>
             	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">开楼盘名称：</td>
             	<td style="padding-top: 2px; padding-left: 2px;" class="style2">
             		<input type="text" value="${bean.lpName}" id="lpName">
             	</td>
			</tr>
			<tr>
                <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">负责人姓名：</td>
                <td style="padding-top: 2px; padding-left: 2px;" class="style2">
                 	<input type="text" value="${bean.lpGM}" id="lpGM">
                </td>
				<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">负责人电话：</td>
                <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                 	<input type="text" value="${bean.lpTel}" id="lpTel" onkeyup="value=value.replace(/\D/g,'')">
                </td>
			</tr>
			<tr>
                <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">城市：</td>
                <td style="padding-top: 2px; padding-left: 2px;" class="style2">
	        		<select id='cityID'>
   	  					<c:forEach var='item' items='${cityList}'>
   	  						<option value='<c:out value='${item.ID}'/>'<c:if test='${item.ID==bean.cityID}'>selected</c:if>>
   	  							<c:out value='${item.cityName}'/>
   	  						</option>
   	  					</c:forEach>
   	  				</select>
                </td>
				<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">开发商：</td>
                <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                   <select id='companyID'>
   	  					<c:forEach var='item' items='${companyList}'>
   	  						<option value='<c:out value='${item.companyID}'/>'<c:if test='${item.companyID==bean.companyID}'>selected</c:if>>
   	  							<c:out value='${item.companyName}'/>
   	  						</option>
   	  					</c:forEach>
   	  				</select>
                </td>
			</tr>
			<tr>
             	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">状态：</td>
             	<td style="padding-top: 2px; padding-left: 2px;" class="style2">
					<select id="lpState">
       		   			<option value="0" <c:if test="${bean.lpState == '0'}">selected</c:if>>无效</option>
       		   			<option value="1" <c:if test="${bean.lpState == '1'}">selected</c:if>>生效</option>
       		   			<option value="2" <c:if test="${bean.lpState == '2'}">selected</c:if>>过期</option>
       		   			<option value="4" <c:if test="${bean.lpState == '4'}">selected</c:if>>删除</option>
        			</select>  
             	</td>
             	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">地址：</td>
                <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                   <input type="text" value="${bean.lpAddr}" id="lpAddr">
                </td>
			</tr>
		</table>
	</c:forEach>&nbsp;
<div class="box_btn" align="center">
<input type="button" value="保&nbsp;&nbsp;存" onclick="updateComLp()"/> 
<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
</div>
</div>