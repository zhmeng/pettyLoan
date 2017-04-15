<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="page" uri="/WEB-INF/page-tag.tld"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path",path);
request.setAttribute("basePath",basePath);
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>借款申请表</title>
<link href="${path}/syscss/basic_layout.css" rel="stylesheet" type="text/css">
<link href="${path}/syscss/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/js/Util.js"></script>
<script type="text/javascript" src="${path}/js/md5.js"></script>
<script type="text/javascript" src="${path}/js/jquery.form.js"></script>
<script type="text/javascript" src="${path}/js/jquery.requestway.js"></script>
<%-- <script type="text/javascript" src="${path}/js/select2css.js"></script> --%>
<link href="${path}/css/public_xe.css" rel="stylesheet" />
<link href="${path}/css/style.css" rel="stylesheet" />
<%-- <link href="${path}/css/style-theme-lx.css" rel="stylesheet" type="text/css" /> --%>
<link href="${path}/css/home.css" type="text/css" rel="Stylesheet" />
<link href="${path}/css/Css.css" type="text/css" rel="Stylesheet" />
<style>
body{ margin:0 auto; width:1100px; font-size:12px;}
table{  text-indent:10px; height:50px; line-height:50px;border-right:none;}
table tr td{ border-left:none; border-left:1px solid #000;border-bottom:1px solid #000;}
input{ border:none; line-height:40px;height:40px;}
.pisu{ position:relative; top:13px;}

.sfz{ width:90%;}
.bitian{
	color: #f00;
}
.pisu{ position:relative; top:13px;}
.anjiu{width:100px;margin:20px auto;}
.anniu{ width:100px; background:#e94700; border-radius: 5px; cursor:pointer;color:#fff; font-size:14px; font-weight:bold;}
.anniu:hover{ background:#f54b00;}
</style>
</head>
<body>
<input type="hidden" id="path" value="${path}"/>
<c:choose>
	<c:when test="${empty acust}">
</c:when>
<c:otherwise>
		<form action="${path}/loanApp/updateLoanApp" method="post"  id="loanForms" enctype="multipart/form-data">
		<table border="1" align="center" cellspacing="0"  bordercolor="#6699FF" style=" border:0.5px;">
		<tr>
			<td colspan="12">借款申请表</td>
		</tr>
		<tr>
			<td colspan="3"></td>
			<td colspan="5"></td>
			<td colspan="4"></td>
		</tr>
		
		
		
		
		
		
		<tr style="border-bottom: 1px solid #000;border-right: 1px solid #000;">
        <td><span class="bitian">*</span>开发商：</td><td><input type="text" name="cp.companyName" id="companyName" value="${cp.companyName}"/>
		</td>
        <td ><span class="bitian">*</span>城市:</td><td><input type="text" name="city.cityName" id="cityName" value="${city.cityName}"/>
   		 </td>
        <td><span class="bitian">*</span>楼盘:</td><td><input type="text" name="comLp.lpName" id="lpName" value="${comLp.lpName}"/>
         </td>
        <td><span class="bitian">*</span>产品:</td><td>
       	 <input type="text" name="product.productName" id="productName" value="${product.productName}"/>
          </td>
      </tr>
		
		<tr>
			<td colspan="10">个人资料</td>
		</tr>
		<tr>
			<td colspan="2"><span class="bitian">*</span>姓名:<input type="text" name="acust.custName" id="custName" value="${acust.custName}"/></td>
			<td colspan="4"><span class="bitian">*</span>性别:
				<c:choose>
					<c:when test="${acust.gender==1}">
							<input type="radio" name="acust.gender" id="gender" value="1"/ checked="checked">男  &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.gender" id="gender" value="2"/>女
					</c:when>
					<c:otherwise>
							<input type="radio" name="acust.gender" id="gender" value="1"/>男  &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.gender" id="gender" value="2" checked="checked"/>女
					</c:otherwise>
				</c:choose>
			</td>
			<td colspan="8"><span class="bitian">*</span>身份证号码:<input type="text" name="acust.docNo" id="docNo" value="${acust.docNo}"/></td>
		</tr>
		<tr>
			<td colspan="3"><span class="bitian">*</span>出生日期:<input type="text" name="acust.birthday" id="birthday" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})"/></td>
			<td colspan="5"><span class="bitian">*</span>婚姻状况:
				<c:if test="${acust.marry==1}">
							<input type="radio" name="acust.marry" id="marry" value="1" checked="checked"/>未婚  &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" value="2"/>已婚 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" value="3"/>离婚 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" value="4"/>其他 &nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<c:if test="${acust.marry==2}">
							<input type="radio" name="acust.marry" id="marry" value="1" />未婚  &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" value="2" checked="checked"/>已婚 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" value="3"/>离婚 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" value="4"/>其他 &nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<c:if test="${acust.marry==3}">
							<input type="radio" name="acust.marry" id="marry" value="1" />未婚  &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" value="2"/>已婚 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" value="3" checked="checked"/>离婚 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" value="4"/>其他 &nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<c:if test="${acust.marry==4}">
							<input type="radio" name="acust.marry" id="marry" value="1" />未婚  &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" value="2"/>已婚 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" value="3"/>离婚 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" value="4" checked="checked"/>其他 &nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
							
			</td>
			<td colspan="4">子女个数:<input type="text" name="acust.sonCount" id="sonCount" size="5" value="${acust.sonCount}"/>个</td>
		</tr> 
		<tr>
			<td colspan="2"><span class="bitian">*</span>手机:<input type="text" name="acust.mobile" id="mobile" value="${acust.mobile}"/></td>
			<td colspan="4">住宅电话（当地）:<input type="text" name="acust.telephone" id="telephone" value="${acust.telephone}"/></td>
			<td colspan="6">居住状况:
						<c:if test="${acust.liveStatus==1}">
							<input type="radio" name="ziyou" id="ziyou" value="0" checked="checked"/>自有(
							<input type="radio" name="acust.liveStatus" id="liveStatus" value="1" checked="checked"/>按揭中 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.liveStatus" id="liveStatus" value="2"/>离婚 )
							<input type="radio" name="acust.liveStatus" id="liveStatus" value="3"/>租凭(月租:<input name="acust.leaseMoney" id="leaseMoney"/>)  
							&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="acust.liveStatus" id="liveStatus" value="4"/>其他 &nbsp;&nbsp;&nbsp;&nbsp;
						</c:if>
						<c:if test="${acust.liveStatus==2}">
							<input type="radio" name="ziyou" id="ziyou" value="0" checked="checked"/>自有(
							<input type="radio" name="acust.liveStatus" id="liveStatus" value="1" />按揭中 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.liveStatus" id="liveStatus" value="2" checked="checked"/>离婚 )
							<input type="radio" name="acust.liveStatus" id="liveStatus" value="3"/>租凭(月租:<input name="acust.leaseMoney" id="leaseMoney"/>)  
							&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="acust.liveStatus" id="liveStatus" value="4"/>其他 &nbsp;&nbsp;&nbsp;&nbsp;
						</c:if>
						<c:if test="${acust.liveStatus==3}">
							<input type="radio" name="ziyou" id="ziyou" value="0"/>自有(
							<input type="radio" name="acust.liveStatus" id="liveStatus" value="1"/>按揭中 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.liveStatus" id="liveStatus" value="2"/>离婚 )
							<input type="radio" name="acust.liveStatus" id="liveStatus" value="3"  checked="checked"/>租凭(月租:<input name="acust.leaseMoney" id="leaseMoney" value="${acust.leaseMoney}"/>)  
							&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="acust.liveStatus" id="liveStatus" value="4"/>其他 &nbsp;&nbsp;&nbsp;&nbsp;
						</c:if>
						<c:if test="${acust.liveStatus==1}">
							<input type="radio" name="ziyou" id="ziyou" value="0" checked="checked"/>自有(
							<input type="radio" name="acust.liveStatus" id="liveStatus" value="1" checked="checked"/>按揭中 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.liveStatus" id="liveStatus" value="2"/>离婚 )
							<input type="radio" name="acust.liveStatus" id="liveStatus" value="3"/>租凭(月租:<input name="acust.leaseMoney" id="leaseMoney"/>)  
							&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="acust.liveStatus" id="liveStatus" value="4" checked="checked"/>其他 &nbsp;&nbsp;&nbsp;&nbsp;
						</c:if>
			</td>
		</tr> 
		<tr>
			<td colspan="5">其他联系方式:<input type="text" name="acust.otherContact" id="otherContact" value="${acust.otherContact}"/></td>
			<td colspan="7">当地工作时间:<input type="text" name="acust.wokTime" id="wokTime" value="${acust.wokTime}"/></td>
		</tr>  
		<tr>
			<td colspan="8"><span class="bitian">*</span>家庭现住地址:
			<input type="text" name="acust.address" id="address" value="${acust.address}"/>
			</td>
			<td colspan="4">教育水平:
				<select name="acust.education">
					<c:if test="${acust.education==1}">
						<option value="1" selected="selected">初中及以下</option>
						<option value="2">高中</option>
						<option value="3">大专</option>
						<option value="4">本科</option>
						<option value="5">硕士</option>
						<option value="6">博士</option>
					</c:if>
					<c:if test="${acust.education==2}">
						<option value="1">初中及以下</option>
						<option value="2" selected="selected">高中</option>
						<option value="3">大专</option>
						<option value="4">本科</option>
						<option value="5">硕士</option>
						<option value="6">博士</option>
					</c:if>
					<c:if test="${acust.education==3}">
						<option value="1">初中及以下</option>
						<option value="2">高中</option>
						<option value="3" selected="selected">大专</option>
						<option value="4">本科</option>
						<option value="5">硕士</option>
						<option value="6">博士</option>
					</c:if>
					<c:if test="${acust.education==4}">
						<option value="1">初中及以下</option>
						<option value="2">高中</option>
						<option value="3">大专</option>
						<option value="4" selected="selected">本科</option>
						<option value="5">硕士</option>
						<option value="6">博士</option>
					</c:if>
					<c:if test="${acust.education==5}">
						<option value="1">初中及以下</option>
						<option value="2">高中</option>
						<option value="3">大专</option>
						<option value="4">本科</option>
						<option value="5" selected="selected">硕士</option>
						<option value="6">博士</option>
					</c:if>
					<c:if test="${acust.education==5}">
						<option value="1">初中及以下</option>
						<option value="2">高中</option>
						<option value="3">大专</option>
						<option value="4">本科</option>
						<option value="5">硕士</option>
						<option value="6" selected="selected">博士</option>
					</c:if>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">①直系亲属姓名:<input type="text" name="acust.zxInsider" id="zxInsider" value="${acust.zxInsider}"/></td>
			<td colspan="3">与申请人关系:<input type="text" name="acust.zxRelation" id="zxRelation" value="${acust.zxRelation}"/></td>
			<td colspan="3">固定电话:<input type="text" name="acust.zxTel" id="zxTel" value="${acust.zxTel}"/></td>
			<td colspan="4">地址:<input type="text" name="acust.zxAdress" id="zxAdress" value="${acust.zxAdress}"/></td>
		</tr>
		<tr>
			<td colspan="2">手机:<input type="text" name="acust.zxMobile" id="zxMobile" value="${acust.zxMobile}"/></td>
			<td colspan="6">工作单位:<input type="text" name="acust.zxCompany" id="zxCompany" value="${acust.zxCompany}"/></td>
			<td colspan="4">是否知晓贷款:
				<select name="acust.zxKonw" id="zxKonw">
					<c:if test="${acust.zxKonw==1}">
						<option value="1" selected="selected">是</option>
						<option value="2">否</option>
					</c:if>
					<c:if test="${acust.zxKonw==2}">
						<option value="1">是</option>
						<option value="2" selected="selected">否</option>
					</c:if>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">②亲属姓名:<input type="text" name="acust.qsName" id="qsName" value="${acust.qsName}"/></td>
			<td colspan="6">工作单位:<input type="text" name="acust.qsCorp" id="qsCorp" value="${acust.qsCorp}"/></td>
			<td colspan="4">是否知晓贷款:
				<select name="acust.qsKonw" id="qsKonw">
					<c:if test="${acust.qsKonw==1}">
						<option value="1" selected="selected">是</option>
						<option value="2">否</option>
					</c:if>
					<c:if test="${acust.qsKonw==2}">
						<option value="1">是</option>
						<option value="2" selected="selected">否</option>
					</c:if>
				</select>
			</td>
		<tr>
			<td colspan="2">手机:<input type="text" name="acust.qsMobile" id="qsMobile" value="${acust.qsMobile}"/></td>
			<td colspan="2">单位电话:<input type="text" name="acust.qsCorpTel" id="qsCorpTel" value="${acust.qsCorpTel}"/></td>
			<td colspan="8">地址:<input type="text" name="acust.qsAddr" id="qsAddr" value="${acust.qsAddr}"/></td>
			
		</tr>
		<tr>
			<td colspan="2">③同事姓名:<input type="text" name="acust.tsName" id="tsName" value="${acust.tsName}"/></td>
			<td colspan="4">职位:<input type="text" name="acust.tsPosition" id="tsPosition" value="${acust.tsPosition}"/></td>
			<td colspan="6">是否知晓贷款:
				<select name="acust.tsKonw" id="tsKonw">
					<c:if test="${acust.tsKonw==1}">
						<option value="1" selected="selected">是</option>
						<option value="2">否</option>
					</c:if>
					<c:if test="${acust.tsKonw==2}">
						<option value="1">是</option>
						<option value="2" selected="selected">否</option>
					</c:if>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">手机:<input type="text" name="acust.tsMobile" id="tsMobile" value="${acust.tsMobile}"/></td>
			<td colspan="4">固定电话(当地):<input type="text" name="acust.tsTel" id="tsTel" value="${acust.tsTel}"/></td>
			<td colspan="6">地址:<input type="text" name="acust.tsAddr" id="tsAddr" value="${acust.tsAddr}"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">④其他联系人姓名:<input type="text" name="acust.otherName" id="otherName" value="${acust.otherName}"/></td>
			<td colspan="3">与申请人关系:<input type="text" name="acust.otherRelation" id="otherRelation" value="${acust.otherRelation}"/></td>
			<td colspan="3">手机:<input type="text" name="acust.otherMobile" id="otherMobile" value="${acust.otherMobile}"/></td>
			<td colspan="4">是否知晓贷款:
				<select name="acust.otherKonw" id="otherKonw">
					<c:if test="${acust.otherKonw==1}">
						<option value="1" selected="selected">是</option>
						<option value="2">否</option>
					</c:if>
					<c:if test="${acust.otherKonw==2}">
						<option value="1">是</option>
						<option value="2" selected="selected">否</option>
					</c:if>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="4">地址:<input type="text" name="acust.otherAddr" id="otherAddr" value="${acust.otherAddr}"/></td>
			<td colspan="3">单位或住宅电话:<input type="text" name="acust.otherTel" id="otherTel" value="${acust.otherTel}"/></td>
			<td colspan="5">工作单位及地址:<input type="text" name="acust.otherCompany" id="otherCompany" value="${acust.otherCompany}"/></td>
		</tr>
		
		
		<tr>
			<td colspan="12">公司资料</td>
		</tr>
		<tr>
			<td colspan="5"><span class="bitian">*</span>公司名称:<input name="company.cusName" id="cusName" value="${company.cusName}"/></td>
			<td colspan="3"><span class="bitian">*</span>公司成立日期<input name="company.companyCreateDate" id="companyCreateDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})" value="${company.companyCreateDate}"/></td>
			<td colspan="2">部门:<input name="company.dept" id="dept" value="${company.dept}"/></td>
			<td colspan="2">职位:<input name="company.position" id="position" value="${company.position}"/></td>
		</tr>
		<tr>
			<td colspan="5"><span class="bitian">*</span>公司主营业务:<input type="text" name="company.comBusiness" id="comBusiness" value="${company.comBusiness}"/></td>
			<td colspan="7">企业性质:
				<c:if test="${company.comAttribute==1}">
					<input type="radio" name="company.comAttribute" id="comAttribute" value="1" checked="checked"/>国有企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="2"/>三资企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="3"/>集体企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="4"/>私营企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="5"/>其它
				</c:if>
				<c:if test="${company.comAttribute==2}">
					<input type="radio" name="company.comAttribute" id="comAttribute" value="1"/>国有企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="2" checked="checked"/>三资企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="3"/>集体企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="4"/>私营企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="5"/>其它
				</c:if>
				<c:if test="${company.comAttribute==3}">
					<input type="radio" name="company.comAttribute" id="comAttribute" value="1"/>国有企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="2"/>三资企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="3" checked="checked"/>集体企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="4"/>私营企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="5"/>其它
				</c:if>
				<c:if test="${company.comAttribute==4}">
					<input type="radio" name="company.comAttribute" id="comAttribute" value="1"/>国有企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="2"/>三资企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="3"/>集体企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="4" checked="checked"/>私营企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="5"/>其它
				</c:if>
				<c:if test="${company.comAttribute==5}">
					<input type="radio" name="company.comAttribute" id="comAttribute" value="1"/>国有企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="2"/>三资企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="3"/>集体企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="4"/>私营企业 &nbsp;&nbsp;
					<input type="radio" name="company.comAttribute" id="comAttribute" value="5" checked="checked"/>其它
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="7"><span class="bitian">*</span>公司实际地址:<input type="text" name="company.comAdress" id="comAdress" value="${company.comAdress}"/></td>
			<td colspan="5"><span class="bitian">*</span>公司固定电话:<input type="text" name="company.comTel" id="comTel" value="${company.comTel}"/></td>
		</tr>
		<tr>
			<td colspan="5">公司规模:<input type="text" name="company.comSize" id="comSize" value="${company.comSize}"/></td>
			<td colspan="7">行业类型:<input type="text" name="company.comClass" id="comClass" value="${company.comClass}"/></td>
		</tr>
		<tr>
			<td colspan="12">财务信息概述</td>
		</tr>
		<tr>
			<td colspan="2">年营业额:<input type="text" name="fance.turnover" id="turnover" value="${fance.turnover}"/></td>
			<td colspan="3">其他收入:<input type="text" name="fance.otherIncome" id="otherIncome" value="${fance.otherIncome}"/></td>
			<td colspan="3">净利润:<input type="text" name="fance.profits" id="profits" value="${fance.profits}"/></td>
			<td colspan="4">负债:<input type="text" name="fance.liabilities" id="liabilities" value="${fance.liabilities}"/></td>
		</tr>
		<tr>
			<td colspan="2">发薪日:<input type="text" name="fance.salaryDay" id="salaryDay" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})" value="${fance.salaryDay}"/></td>
			<td colspan="4"><span class="bitian">*</span>月收入:<input type="text" name="fance.salary" id="salary" value="${fance.salary}"/></td>
			<td colspan="6">负债:<input type="text" name="fance.personLiabilities" id="personLiabilities" value="${fance.personLiabilities}"/></td>
		</tr>
		<tr>
			<td>房产地址</td><td colspan="5"><input type="text" name="fance.houseAdress" id="houseAdress1" value="${fance.houseAdress}"/></td>
			<td>购买日期</td><td><input type="text" name="fance.buyDate" id="buyDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})" value="${fance.buyDate}"/></td>
			<td>购买价格</td><td><input type="text" name="fance.buyPrice" id="buyPrice" value="${fance.buyPrice}"/></td>
			<td>购买方式</td><td>
				<c:if test="${fance.busState==1}">
					<input type="radio" name="fance.busState" id="busState" value="1" checked="checked"/>一次性 &nbsp;
					<input type="radio" name="fance.busState" id="busState" value="2"/>按揭
				</c:if>
				<c:if test="${fance.busState==2}">
					<input type="radio" name="fance.busState" id="busState" value="1"/>一次性 &nbsp;
					<input type="radio" name="fance.busState" id="busState" value="2" checked="checked"/>按揭
				</c:if>
			</td>
		</tr>
		<tr>
			<td>按揭银行</td>
			<td><input type="text" name="fance.ajBank" id="ajBank" value="${fance.ajBank}"/></td>
			<td>贷款总额</td>
			<td><input type="text" name="fance.loanAMT" id="loanAMT" value="${fance.loanAMT}"/></td>
			<td>月供金额</td>
			<td><input type="text" name="fance.payMonth" id="payMonth" value="${fance.payMonth}"/></td>
			<td>贷款余额</td>
			<td><input type="text" name="fance.loanRemaining" id="loanRemaining" value="${fance.loanRemaining}"/></td>
			<td colspan="2">其它房产总数及价值</td>
			<td colspan="2"><input type="text" name="fance.otherHouse" id="otherHouse" value="${fance.otherHouse}"/></td>
		</tr>
		<tr>
			<td>车牌号码</td>
			<td colspan="5"><input type="text" name="fance.carNum" id="carNum" value="${fance.carNum}" /></td>
			<td>购买日期</td>
			<td><input type="text" name="fance.carBuyDate" id="carBuyDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})" value="${fance.carBuyDate}"/></td>
			<td>购买价格</td>
			<td><input type="text" name="fance.carBuyPrice" id="carBuyPrice" value="${fance.carBuyPrice}"/></td>
			<td>购买方式</td>
			<td>
				<c:if test="${fance.carBusState==1}">
					<input type="radio" name="fance.carBusState" id="carBusState" value="1" checked="checked"/>一次性&nbsp;
					<input type="radio" name="fance.carBusState" id="carBusState" value="2"/>按揭
				</c:if>
				<c:if test="${fance.carBusState==2}">
					<input type="radio" name="fance.carBusState" id="carBusState" value="1"/>一次性&nbsp;
					<input type="radio" name="fance.carBusState" id="carBusState" value="2" checked="checked"/>按揭
				</c:if>
			</td>
		</tr>
		<tr>
			<td>按揭银行</td>
			<td><input type="text" name="fance.carAJBank" id="carAJBank" value="${fance.carAJBank}"/></td>
			<td>贷款总额</td>
			<td><input type="text" name="fance.carLoanAMT" id="carLoanAMT" value="${fance.carLoanAMT}"/></td>
			<td>月供金额</td>
			<td><input type="text" name="fance.carPayMonth" id="carPayMonth" value="${fance.carPayMonth}"/></td>
			<td>贷款余额</td>
			<td><input type="text" name="fance.carLoanRemaining" id="carLoanRemaining" value="${fance.carLoanRemaining}"/></td>
			<td colspan="2">其它房产总数及价值</td>
			<td colspan="2"><input type="text" name="fance.otherCar" id="otherCar" value="${fance.otherCar}"/></td>
		</tr>
		<tr>
			<td colspan="12">申请贷款历史 
			<!-- <input type="radio" value="1"/>是&nbsp;&nbsp;<input type="radio" value="2"/>否</td> -->
		</tr>
		<tr>
			<td colspan="4">银行，私人，金融机构、其他 </td>
			<td colspan="2">金额</td>
			<td colspan="2">放款日期</td>
			<td colspan="2">月还款额</td>
			<td colspan="2">是否有逾期</td>
		</tr>
		<tr>
			<td colspan="4"><input type="text" name="loan.loanBank" id="loanBank" size="6" value="${loan.loanBank}"/></td>
			<td colspan="2"><input type="text" name="loan.loanAmt" id="loanAmt" size="6" value="${loan.loanAmt}"/></td>
			<td colspan="2"><input type="text" name="loan.payDate" id="payDate" size="6" value="${loan.payDate}"/></td>
			<td colspan="2"><input type="text" name="loan.payMonth" id="payMonth" size="6" value="${loan.payMonth}"/></td>
			<td colspan="2">
				<c:if test="${loan.isoOverdue==1}">
					<input type="radio" name="loan.isoOverdue" id="isoOverdue" value="1" checked="checked"/>是&nbsp;&nbsp;
					<input type="radio" name="loan.isoOverdue" id="isoOverdue" value="2"/>否
				</c:if>
				<c:if test="${loan.isoOverdue==2}">
					<input type="radio" name="loan.isoOverdue" id="isoOverdue" value="1"/>是&nbsp;&nbsp;
					<input type="radio" name="loan.isoOverdue" id="isoOverdue" value="2" checked="checked"/>否
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="4"><input type="text" name="loan2.loanBank" id="loanBank" size="6" value="${loan2.loanBank}"/></td>
			<td colspan="2"><input type="text" name="loan2.loanAmt" id="loanAmt" size="6" value="${loan2.loanAmt}"/></td>
			<td colspan="2"><input type="text" name="loan2.payDate" id="payDate" size="6" value="${loan2.payDate}"/></td>
			<td colspan="2"><input type="text" name="loan2.payMonth" id="payMonth" size="6" value="${loan2.payMonth}"/></td>
			<td colspan="2">
				<c:if test="${loan2.isoOverdue==1}">
					<input type="radio" name="loan2.isoOverdue" id="isoOverdue" value="1" checked="checked"/>是&nbsp;&nbsp;
					<input type="radio" name="loan2.isoOverdue" id="isoOverdue" value="2"/>否
				</c:if>
				<c:if test="${loan2.isoOverdue==2}">
					<input type="radio" name="loan2.isoOverdue" id="isoOverdue" value="1"/>是&nbsp;&nbsp;
					<input type="radio" name="loan2.isoOverdue" id="isoOverdue" value="2" checked="checked"/>否
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="4"><input type="text" name="loan3.loanBank" id="loanBank" size="6" value="${loan3.loanBank}"/></td>
			<td colspan="2"><input type="text" name="loan3.loanAmt" id="loanAmt" size="6" value="${loan3.loanAmt}"/></td>
			<td colspan="2"><input type="text" name="loan3.payDate" id="payDate" size="6" value="${loan3.payDate}"/></td>
			<td colspan="2"><input type="text" name="loan3.payMonth" id="payMonth" size="6" value="${loan3.payMonth}"/></td>
			<td colspan="2">
				<c:if test="${loan3.isoOverdue==1}">
					<input type="radio" name="loan3.isoOverdue" id="isoOverdue" value="1" checked="checked"/>是&nbsp;&nbsp;
					<input type="radio" name="loan3.isoOverdue" id="isoOverdue" value="2"/>否
				</c:if>
				<c:if test="${loan3.isoOverdue==2}">
					<input type="radio" name="loan3.isoOverdue" id="isoOverdue" value="1"/>是&nbsp;&nbsp;
					<input type="radio" name="loan3.isoOverdue" id="isoOverdue" value="2" checked="checked"/>否
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="12">房产购置情况及申请要求</td>
		</tr>
		<tr>
			<td colspan="4">购房地址:<input type="text" name="ainfo.houseAdress" id="houseAdress" value="${ainfo.houseAdress}"/></td>
			<td colspan="2">首付成数:<input type="text" name="ainfo.firstPayPercent" id="firstPayPercent" value="${ainfo.firstPayPercent}"/></td>
			<td colspan="2">房屋总价:<input type="text" name="ainfo.housePrice" id="housePrice" value="${ainfo.housePrice}"/></td>
			<td colspan="2">房屋面积:<input type="text" name="ainfo.houseArea" id="houseArea" value="${ainfo.housePrice}"/></td>
			<td colspan="2">房屋单价:<input type="text" name="ainfo.metersPrice" id="metersPrice" value="${ainfo.housePrice}"/></td>
		</tr>
		<tr>
			<td colspan="12">
				<span class="bitian">*</span>申请额度：（人民币大写） <input type="text" name="ainfo.bigAmount" id="bigAmount" value="${ainfo.bigAmount }"/>  万元整，（小写）：￥ 
				<input type="text" name="ainfo.amount" id="amount" value="${ainfo.amount}"/>
				  <span class="bitian">*</span>申请期限：<input type="text" name="ainfo.loanTime" id="loanTime" value="${ainfo.loanTime }"/> 月       
				    所购房产是否为首套房： 
				    <c:if test="${ainfo.isFirstHouse==1}">
				   	 	<input type="radio" name="ainfo.isFirstHouse" id="isFirstHouse" value="1" />是&nbsp;
				    	<input type="radio" name="ainfo.isFirstHouse" id="isFirstHouse" value="2" checked="checked"/>否
				    </c:if>
				     <c:if test="${ainfo.isFirstHouse==2}">
				   	 	<input type="radio" name="ainfo.isFirstHouse" id="isFirstHouse" value="1" />是&nbsp;
				    	<input type="radio" name="ainfo.isFirstHouse" id="isFirstHouse" value="2" checked="checked"/>否
				    </c:if>
			</td>
		</tr>
		<tr>
			<td colspan="12">
				<span class="bitian">*</span>贷款利率<input type="text" name="ainfo.rate" id="rate" value="${ainfo.rate}"/>%  &nbsp;&nbsp;&nbsp;&nbsp;
				<span class="bitian">*</span>手续费率<input type="text" name="ainfo.feeRate" id="ainfo.feeRate" value="${ainfo.feeRate}"/>% 
			</td>
		</tr>
		<tr>
			<td colspan="6">
				<select name="ainfo.rooms" id="rooms">
					<option>${ainfo.rooms}</option>
				</select>房
				<select name="ainfo.hall" id="hall">
					<option>${ainfo.hall}</option>
					
				</select>厅
				<select  name="ainfo.toilet" id="toilet">
					<option>${ainfo.toilet}</option>
					
				</select>卫
				<select  name="ainfo.balcony" id="balcony">
					<option>${ainfo.balcony}</option>
				</select>阳台
			</td>
			<td colspan="3">
				朝向:${ainfo.aspect}
			</td>
			<td colspan="3">
				房号:${ainfo.roomNumber}
			</td>
		</tr>
		<tr>
			<td colspan="12">
				<input type="button" value="关闭" style="float: left;" onclick="javascript:window.close();" class="anniu1"/>
			</td>
		</tr>
	</table>
	
	<table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td  style="background:#ccc;font-weight:bold; font-size:14px;border-right:1px solid #000">图片信息</td>
      </tr>
    </table>    
    <c:if test="${imglist==null}">
								没有附件
							</c:if>
							
							
							
						<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th>图片id</th>
							<th>图片中文名称</th>
						  	<th>图片创建时间</th>
							<th>图片状态</th>
							<th>图片url</th>
							<th>操作</th>
						</tr>
				<c:forEach var="bean" items="${imglist}">
							<tr>
								<td>${bean.ID }</td>
								<td>${bean.imgChinaName}</td>
								<td>${bean.time}</td>
								<td>${bean.state}</td>
								<td>${bean.imgUrl }</td>
								<td>
									<a target="_blank" href="${path}/apply/showImg.jsp?imgurl=${bean.imgUrl }" name="imgurl"><%-- <img alt="该图片暂时无法查看" src="${bean.imgUrl }"> --%>查看</a>
								</td>
							</tr>
						</c:forEach>
					</table>
			  </div>
			</div>	
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
    
    
	
	</form>
	
	</c:otherwise>
	
	</c:choose>
	
</body>
</html>