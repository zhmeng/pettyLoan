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
<script type="text/javascript" src="${path}/company/company.js"></script>
<div class="container" id="tb_WarnSelect_div">
<input id="basePath" type="hidden" value="${basePath}"/>
	<c:forEach var="bean" items="${company}">
		<input type="hidden" value="${bean.companyID}" id="companyID">
		<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
            <tr>
             	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">开发商编号：</td>
             	<td style="padding-top: 2px; padding-left: 2px;" class="style2">
             		<input type="text" value="${bean.companyKey}" id="companyKey">
             	</td>
             	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">开发商名称：</td>
             	<td style="padding-top: 2px; padding-left: 2px;" class="style2">
             		<input type="text" value="${bean.companyName}" id="companyName">
             	</td>
			</tr>
			<tr>
                <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">法人姓名：</td>
                <td style="padding-top: 2px; padding-left: 2px;" class="style2">
                 	<input type="text" value="${bean.companyFName}" id="companyFName">
                </td>
				<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">法人电话：</td>
                <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                 	<input type="text" value="${bean.companyFTel}" id="companyFTel" onkeyup="value=value.replace(/\D/g,'')">
                </td>
			</tr>
			<tr>
                <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">银行名称A：</td>
                <td style="padding-top: 2px; padding-left: 2px;" class="style2">
                 	<input type="text" value="${bean.companyBankNameA}" id="companyBankNameA">
                </td>
				<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">银行帐号A：</td>
                <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                   <input type="text" value="${bean.companyAccoutA}" id="companyAccoutA" onkeyup="value=value.replace(/\D/g,'')">
                </td>
			</tr>
			<tr>
                <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">银行名称B：</td>
                <td style="padding-top: 2px; padding-left: 2px;" class="style2">
                 	<input type="text" value="${bean.companyBankNameB}" id="companyBankNameB">
                </td>
				<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">银行帐号B：</td>
                <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                   <input type="text" value="${bean.companyAccoutB}" id="companyAccoutB" onkeyup="value=value.replace(/\D/g,'')">
                </td>
			</tr>
			<tr>
             	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">开发商状态：</td>
             	<td style="padding-top: 2px; padding-left: 2px;" class="style2">
					<select id="companyState">
       		   			<option value="0" <c:if test="${bean.companyState == '0'}">selected</c:if>>无效</option>
       		   			<option value="1" <c:if test="${bean.companyState == '1'}">selected</c:if>>生效</option>
       		   			<option value="2" <c:if test="${bean.companyState == '2'}">selected</c:if>>过期</option>
       		   			<option value="4" <c:if test="${bean.companyState == '4'}">selected</c:if>>删除</option>
        			</select>  
             	</td>
             	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">本金违约金：</td>
                <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                   <input type="text" value="${bean.delayCostRate}" id="delayCostRate"
		                    		onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
                </td>
			</tr>
			<tr>
             	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">利息违约金：</td>
                <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                   <input type="text" value="${bean.delayInterestRate}" id="delayInterestRate"
		                    		onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
                </td>
			</tr>
		</table>
	</c:forEach>&nbsp;
<div class="box_btn" align="center">
<input type="button" value="保&nbsp;&nbsp;存" onclick="updateCompany()"/> 
<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
</div>
</div>