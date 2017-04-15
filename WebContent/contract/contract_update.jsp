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
<script type="text/javascript" src="${path}/contract/contract.js"></script>
<div class="container" id="tb_WarnSelect_div">
<input id="basePath" type="hidden" value="${basePath}"/>
<input type="hidden" value="${contract.contractID}" id="contractID">
<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
	<tr>
		<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>合同编号：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${contract.contractNo}" id="contractNo">
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>合同名称：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${contract.contractName}" id="contractName">
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">合同状态：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
			<select id="status">
     		   	<option value="1" <c:if test="${contract.status == '1'}">selected</c:if>>待申请</option>
     		   	<option value="2" <c:if test="${contract.status == '2'}">selected</c:if>>待签订</option>
     		   	<option value="3" <c:if test="${contract.status == '3'}">selected</c:if>>待复核</option>
     		   	<option value="4" <c:if test="${contract.status == '4'}">selected</c:if>>待放款</option>
     		   	<option value="9" <c:if test="${contract.status == '9'}">selected</c:if>>作废</option>
      		</select>  
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>贷款金额：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
           	<input type="text" value="${contract.amt}" id="amt" onkeyup="value=value.replace(/\D/g,'')">
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款期限：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${contract.loanTime}" id="loanTime" onkeyup="value=value.replace(/\D/g,'')">
    	</td>
    	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">银行名称：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${contract.bankName}" id="bankName">
    	</td>
	</tr>
		<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">银行帐号：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${contract.bankAccount}" id="bankAccount" onkeyup="value=value.replace(/\D/g,'')">
    	</td>
    	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">帐号归属人：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${contract.bankMan}" id="bankMan">
    	</td>
	</tr>
</table>
&nbsp;
<div class="box_btn" align="center">
<input type="button" value="保&nbsp;&nbsp;存" onclick="updateContract()"/> 
<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
</div>
</div>