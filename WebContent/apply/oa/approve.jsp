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
<title>贷款审批</title>
<link rel="stylesheet" href="${path}/css/default.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/Css.css" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/apply/oa/oa.js"></script>
<div class="container" id="tb_WarnSelect_div">
<input id="basePath" type="hidden" value="${basePath}"/>
		<input type="hidden" value="${applyInfo.applyID}" id="applyID">
		<input type="hidden" value="${applyInfo.applyCode}" id="applyCode">
		<input type="hidden" value="${applyInfo.status}" id="status">
		<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
            <tr>
             	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款金额：</td>
             	<td style="padding-top: 2px; padding-left: 2px;" class="style2">
             		<input type="text" value="${applyInfo.amount}" id="amount" name="amount" onkeyup="value=value.replace(/[^/0-9]/g,'')" onkeyup="changeNumMoneyToChinese(this)">万元
             	</td>
             	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款金额大写：</td>
             	<td style="padding-top: 2px; padding-left: 2px;" class="style2">
             		<input type="text" value="${applyInfo.bigAmount}" id="bigAmount" name="bigAmount" disabled="disabled">万元
             	</td>
             	
			</tr>
			  <tr>
			  	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款期数：</td>
             	<td style="padding-top: 2px; padding-left: 2px;" class="style2">
             		<input type="text" value="${applyInfo.loanTime}" id="loanTime" name="loanTime">
             	</td>
             	<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">贷款利息：</td>
             	<td style="padding-top: 2px; padding-left: 2px;" class="style2">
             		<input type="text" value="${applyInfo.rate}" id="rate" name="rate">
             	</td>
			</tr>
			<tr>
				<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">评论：</td>
             	<td style="padding-top: 2px; padding-left: 2px;" class="style2" colspan="3">
             		<textarea rows="2" cols="30"  type="text"  id="pl" name="pl"></textarea>
             	</td>
			</tr>
		</table>
		<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
			<tr>
				<td>审核人ID</td>
				<td>审核人</td>
				<td>当前状态</td>
				<td>审核时间</td>
				<td>审核</td>
				<td>审核意见</td>
			</tr>
			<c:forEach items="${ntList}" var="nt">
				<tr>
					<td>${nt.userID}</td>
					<td>${nt.userName}</td>
					<td>
						<c:forEach items="${comList}" var="com">
							<c:if test="${com.baseDefault==nt.status}">
								${com.baseName}
							</c:if> 
						</c:forEach>
					</td>
					<td><fmt:formatDate value="${nt.noteTime}"  pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>
						<c:if test="${nt.examines==1}">同意</c:if>
						<c:if test="${nt.examines==2}">返回</c:if>
						<c:if test="${nt.examines==3}">拒绝</c:if>
					</td>
					<td>${nt.view}</td>
				</tr>
			</c:forEach>
		</table>
<div class="box_btn" align="center">
	<input type="button" value="通&nbsp;&nbsp;过" onclick="toExamine(1)"/> 
	<input type="button"  onclick="toExamine(2)" value="退&nbsp;&nbsp;回"/>
	<input type="button"  onclick="toExamine(3)" value="拒&nbsp;&nbsp;绝"/>
	<input type="button"  onclick="window.close()" value="关&nbsp;&nbsp;闭"/>
</div>
</div>

<script>
function changeNumMoneyToChinese(obj) {
	alert("jin ");
	var money=obj.value;
	var cnNums = new Array("零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"); //汉字的数字
	var cnIntRadice = new Array("", "拾", "佰", "仟"); //基本单位
	var cnIntUnits = new Array("", "万", "亿", "兆"); //对应整数部分扩展单位
	var cnDecUnits = new Array("角", "分", "毫", "厘"); //对应小数部分单位
	var cnInteger = ""; //整数金额时后面跟的字符
	var cnIntLast = ""; //整型完以后的单位
	var maxNum = 999999999999999.9999; //最大处理的数字
	var IntegerNum; //金额整数部分
	var DecimalNum; //金额小数部分
	var ChineseStr = ""; //输出的中文金额字符串
	var parts; //分离金额后用的数组，预定义
	if (money == "") {
		return "";
	}
	money = parseFloat(money);
	if (money >= maxNum) {
		alert('超出最大处理数字');
	   return "";
	}
    if (money == 0) {
		ChineseStr = cnNums[0] + cnIntLast + cnInteger;
		return ChineseStr;
	}
	money = money.toString(); //转换为字符串
	if (money.indexOf(".") == -1) {
		IntegerNum = money;
		DecimalNum = '';
	} else {
		parts = money.split(".");
		IntegerNum = parts[0];
		DecimalNum = parts[1].substr(0, 4);
	}
	if (parseInt(IntegerNum, 10) > 0) { //获取整型部分转换
		var zeroCount = 0;
		var IntLen = IntegerNum.length;
		for (var i = 0; i < IntLen; i++) {
			var n = IntegerNum.substr(i, 1);
			var p = IntLen - i - 1;
			var q = p / 4;
			var m = p % 4;
			if (n == "0") {
				zeroCount++;
			} else {
				if (zeroCount > 0) {
					ChineseStr += cnNums[0];
				}
			zeroCount = 0; //归零
			ChineseStr += cnNums[parseInt(n)] + cnIntRadice[m];
			}
			if (m == 0 && zeroCount < 4) {
				ChineseStr += cnIntUnits[q];
			}
		}
		ChineseStr += cnIntLast;
		//整型部分处理完毕
	}
    if (DecimalNum != '') { //小数部分
		var decLen = DecimalNum.length;
		for (var i = 0; i < decLen; i++) {
			var n = DecimalNum.substr(i, 1);
			if (n != '0') {
				ChineseStr += cnNums[Number(n)] + cnDecUnits[i];
			}
		}
	}
	if (ChineseStr == '') {
		ChineseStr += cnNums[0] + cnIntLast + cnInteger;
	} else if (DecimalNum == '') {
		ChineseStr += cnInteger;
	}
	$("#bigAmount").val(ChineseStr);
}

</script>








