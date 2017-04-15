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
<script type="text/javascript" src="${path}/product/product.js"></script>
<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
				<input id="basePath" type="hidden" value="${basePath}"/>
				<div class="infotitle">
					<h3>添加产品</h3>
				</div>
				<div class="infocontent">
					<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
	                    <tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>产品编号：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="productKey" name="productKey"/>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>产品名称：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="productName" name="productName"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">产品状态：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<select id="productFlag">
							 		<option value="0">无效</option>
							 		<option value="1">生效</option>
							 		<option value="2">过期</option>
							 		<option value="4">删除</option>
							 	</select>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>产品描述：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="productDesc" name="productDesc"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>有效期开始时间：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input id="productValSTime" name="productValSTime" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">有效期结束时间：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input id="productValETime" name="productValETime" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">还款方式：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<select id="productPayment">
							 		<option value="1">按期还息到期还本</option>
							 		<option value="2">等额本息</option>
							 		<option value="3">等额本金</option>
							 		<option value="4">一次性还本付息</option>
							 		<option value="5">预收利息一次性还本</option>
							 		<option value="6">按月还息按期还本</option>
							 		<option value="7">按月还息任意还本</option>
							 		<option value="8">按月还息到期还本(提前收息)</option>
							 		<option value="9">平息</option>
							 	</select>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>财务顾问费：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="productLoanRate" name="productLoanRate"
		                    		onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
		                    </td>
						</tr>
						<tr>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>手续费率：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="productFeesRate" name="productFeesRate"
		                    		onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
		                    </td>
						</tr>
					</table>
				</div>				
			</div>
		</div>&nbsp;
		<div class="box_btn" align="center">
			<input type="button" value="保&nbsp;&nbsp;存" onclick="addProduct()"/> 
			<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
		</div>
	</div>
</div>