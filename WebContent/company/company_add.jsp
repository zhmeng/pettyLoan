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
<script type="text/javascript" src="${path}/company/company.js"></script>
<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
				<input id="basePath" type="hidden" value="${basePath}"/>
				<div class="infotitle">
					<h3>添加开发商</h3>
				</div>
				<div class="infocontent">
					<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
	                    <tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">开发商编号：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="companyKey" name="companyKey"/>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">开发商名称：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="companyName" name="companyName"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">法人姓名：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="companyFName" name="companyFName"/>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">法人电话：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="companyFTel" name="companyFTel" onkeyup="value=value.replace(/\D/g,'')"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">银行名称A：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="companyBankNameA" name="companyBankNameA"/>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">银行帐号A：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="companyAccoutA" name="companyAccoutA" onkeyup="value=value.replace(/\D/g,'')"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">银行名称B：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="companyBankNameB" name="companyBankNameB"/>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">银行帐号B：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="companyAccoutB" name="companyAccoutB" onkeyup="value=value.replace(/\D/g,'')"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">开发商状态：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<select id="companyState">
							 		<option value="0">无效</option>
							 		<option value="1">生效</option>
							 		<option value="2">过期</option>
							 		<option value="4">删除</option>
							 	</select>
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">本金违约金：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="delayCostRate" name="delayCostRate"
		                    		onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">利息违约金：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="delayInterestRate" name="delayInterestRate"
		                    		onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
		                    </td>
						</tr>
					</table>
				</div>				
			</div>
		</div>&nbsp;
		<div class="box_btn" align="center">
			<input type="button" value="保&nbsp;&nbsp;存" onclick="addCompany()"/> 
			<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
		</div>
	</div>
</div>