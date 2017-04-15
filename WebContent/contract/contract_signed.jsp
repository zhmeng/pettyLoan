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
<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
<div class="container" id="tb_WarnSelect_div">
<input id="basePath" type="hidden" value="${basePath}"/>
<input type="hidden" value="${contract.contractID}" id="contractID">
<input type="hidden" value="${modId}" id="modId">
<table id="table1" style="width:100%;" class="tableList">
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">合同编号：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" id="contractNo" name="contractNo" value="${contract.contractNo}" disabled="disabled"/>
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款金额：</td>
        <td class="style2" style="padding-top: 2px; padding-left: 2px;">
        	<input type="text" id="amt" name="amt" value="${contract.amt}" disabled="disabled"/>
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款利率：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" id="rate" name="rate" value="${contract.rate}" disabled="disabled"/>
        </td>
		<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款期限：</td>
        <td class="style2" style="padding-top: 2px; padding-left: 2px;">
            <input id="loanTime" name="loanTime" type="text" value="${contract.loanTime}" disabled="disabled"/>
        </td>
	</tr>
	<tr>
    	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>签订日期：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input id="chksignDate" name="chksignDate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
        </td>
	</tr>
</table>

&nbsp;
<div class="box_btn" align="center">
<input type="button" value="保&nbsp;&nbsp;存" onclick="signedContract()"/> 
<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
</div>
</div>