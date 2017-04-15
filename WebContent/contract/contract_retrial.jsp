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
<table id="table1" style="width:100%;" class="tableList">
	<tr>
		<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">合同编号：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${contract.contractNo}" id="contractNo" disabled="disabled">
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">合同名称：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${contract.contractName}" id="contractName" disabled="disabled">
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">合同状态：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
			<select id="status" disabled="disabled">
     		   	<option value="1" <c:if test="${contract.status == '1'}">selected</c:if>>待申请</option>
     		   	<option value="2" <c:if test="${contract.status == '2'}">selected</c:if>>待签订</option>
     		   	<option value="3" <c:if test="${contract.status == '3'}">selected</c:if>>待复核</option>
     		   	<option value="4" <c:if test="${contract.status == '4'}">selected</c:if>>待放款</option>
     		   	<option value="9" <c:if test="${contract.status == '9'}">selected</c:if>>作废</option>
      		</select>  
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款金额：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
           	<input type="text" value="${contract.amt}" id="amt" onkeyup="value=value.replace(/\D/g,'')" disabled="disabled">
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款期限：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${contract.loanTime}" id="loanTime" onkeyup="value=value.replace(/\D/g,'')" disabled="disabled">
    	</td>
	</tr>
</table>


<table id="table1" style="width:100%;" class="tableList">
	<tr>
		<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">审核人姓名：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${notes.userName}" disabled="disabled">
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">当前状态：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<select disabled="disabled">
     			<option value="201" <c:if test="${notes.status == '201'}">selected</c:if>>专员审批</option>
     		   	<option value="202" <c:if test="${notes.status == '202'}">selected</c:if>>主管审批</option>
     		   	<option value="203" <c:if test="${notes.status == '203'}">selected</c:if>>经理审批</option>
      		</select>  
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">处理意见：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${notes.view}" disabled="disabled">
    	</td>
    	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">审核结果：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<select disabled="disabled">
     			<option value="1" <c:if test="${notes.noteClass == '1'}">selected</c:if>>同意</option>
     		   	<option value="2" <c:if test="${notes.noteClass == '2'}">selected</c:if>>退回</option>
     		   	<option value="3" <c:if test="${notes.noteClass == '3'}">selected</c:if>>拒绝</option>
      		</select>  
    	</td>
	</tr>
</table>

<table style="width:100%;" class="tableList">
	<c:forEach var="item" items="${imgList}">
		<tr> 
			<td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">文件名：</td>
			<td><a href="javascript:void(0)" onclick="downloadFile('${item.ID}')">${item.imgChinaName}</a></td>
		</tr>
	</c:forEach>
</table>

&nbsp;
<div class="box_btn" align="center">
<input type="button" value="复&nbsp;核" onclick="retrialContract()"/> 
<input type="button" id="reset" onclick="window.close()" value="取&nbsp;消"/>
</div>
</div>