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
<script type="text/javascript" src="${path}/contract/contract.js"></script>
<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
<input type="hidden" value="${applyInfo.applyID}" id="applyID">
<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
				<input id="basePath" type="hidden" value="${basePath}"/>
				<div class="infotitle">
					<h3>添加合同</h3>
				</div>
				<div class="infocontent">
					<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
	                    <tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">合同编号：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="contractNo" name="contractNo" value="${applyInfo.applyCode}" disabled="disabled"/>
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款金额：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="amt" name="amt" value="${applyInfo.amount}" disabled="disabled"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款利率：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="rate" name="rate" value="${applyInfo.rate}" disabled="disabled"/>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款期限：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input id="loanTime" name="loanTime" type="text" value="${applyInfo.loanTime}" disabled="disabled"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">起息时间：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input id="startInterestDate" name="startInterestDate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">银行名称：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input id="bankName" name="bankName" type="text"/>
		                    </td>
						</tr>
						<tr>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">银行帐号：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input id="bankAccount" name="bankAccount" type="text"/>
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">帐号归属人：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input id="bankMan" name="bankMan" type="text"/>
		                    </td>
						</tr>
						<!-- 
						<tr>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">本金违约金：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" value="${applyInfo.delayCostRate}" id="delayCostRate" 
		                    		onkeyup="value=value.replace(/[^\-?\d.]/g,'')">
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">利息违约金：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" value="${applyInfo.delayInterestRate}" id="delayInterestRate" 
		                    		onkeyup="value=value.replace(/[^\-?\d.]/g,'')">
		                    </td>
						</tr>
						 -->
						<tr>
					   <!-- <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>合同名称：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="contractName" name="contractName"/>
		                    </td> -->
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">备注：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input id="remark" name="remark" type="text"/>
		                    </td>
						</tr>
					</table>
				</div>				
			</div>
		</div>&nbsp;
		<div class="box_btn" align="center">
			<input type="button" value="申&nbsp;&nbsp;请" onclick="addContract()"/> <input type="hidden" id="hidSubCon" value="no"/>
			<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
		</div>
	</div>
</div>