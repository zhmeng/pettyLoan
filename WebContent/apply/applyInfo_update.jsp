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
<script type="text/javascript" src="${path}/product/product.js"></script>
<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
<div class="container" id="tb_WarnSelect_div">
<input id="basePath" type="hidden" value="${basePath}"/>
<input type="hidden" value="${product.productID}" id="productID">
<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
	<tr>
		<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>产品编号：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${product.productKey}" id="productKey">
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>产品名称：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${product.productName}" id="productName">
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">产品状态：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
			<select id="productFlag">
     			<option value="0" <c:if test="${product.productFlag == '0'}">selected</c:if>>无效</option>
     		   	<option value="1" <c:if test="${product.productFlag == '1'}">selected</c:if>>生效</option>
     		   	<option value="2" <c:if test="${product.productFlag == '2'}">selected</c:if>>过期</option>
     		   	<option value="4" <c:if test="${product.productFlag == '4'}">selected</c:if>>删除</option>
      		</select>  
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>产品描述：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
           	<input type="text" value="${product.productDesc}" id="productDesc">
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>有效期开始时间：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
			<input id="productValSTime" type="text" value="${product.productValSTime}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">有效期结束时间：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input id="productValETime" type="text" value="${product.productValETime}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
        </td>
	</tr>
	<tr>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">还款方式：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
			<select id="productPayment">
 		   		<option value="1" <c:if test="${product.productPayment == '1'}">selected</c:if>>按期还息到期还本</option>
 		   		<option value="2" <c:if test="${product.productPayment == '2'}">selected</c:if>>等额本息</option>
 		   		<option value="3" <c:if test="${product.productPayment == '3'}">selected</c:if>>等额本金</option>
 		   		<option value="4" <c:if test="${product.productPayment == '4'}">selected</c:if>>一次性还本付息</option>
 		   		<option value="5" <c:if test="${product.productPayment == '5'}">selected</c:if>>预收利息一次性还本</option>
 		   		<option value="6" <c:if test="${product.productPayment == '6'}">selected</c:if>>按月还息按期还本</option>
 		   		<option value="7" <c:if test="${product.productPayment == '7'}">selected</c:if>>按月还息任意还本</option>
 		   		<option value="8" <c:if test="${product.productPayment == '8'}">selected</c:if>>按月还息到期还本(提前收息)</option>
 		   		<option value="9" <c:if test="${product.productPayment == '9'}">selected</c:if>>平息</option>
      		</select>
        </td>
        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>财务顾问费：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
        	<input type="text" value="${product.productLoanRate}" id="productLoanRate"
        		onkeyup="value=value.replace(/[^\-?\d.]/g,'')">
    	</td>
	</tr>
	<tr>
    	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right"><span style="color:red">*</span>手续费率：</td>
        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
			<input type="text" value="${product.productFeesRate}" id="productFeesRate"
				onkeyup="value=value.replace(/[^\-?\d.]/g,'')">
        </td>
	</tr>
</table>
&nbsp;
<div class="box_btn" align="center">
<input type="button" value="保&nbsp;&nbsp;存" onclick="updateProduct()"/> 
<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
</div>
</div>