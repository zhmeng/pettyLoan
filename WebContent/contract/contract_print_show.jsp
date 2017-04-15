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
<script type="text/javascript" src="${path}/js/main.js"></script>

<script language=javascript event=NotifyCtrlReady for=WebOffice1>
	/****************************************************
	 *
	 *	在装载完Weboffice(执行<object>...</object>)
	 *	控件后执行 "WebOffice1_NotifyCtrlReady"方法
	 *
	 ****************************************************/
	WebOffice_Event_Flash("NotifyCtrlReady");
	WebOffice1_NotifyCtrlReady();
</script>

<script language=javascript event=NotifyWordEvent(eventname) for=WebOffice1>
<!--
	WebOffice_Event_Flash("NotifyWordEvent");
	WebOffice1_NotifyWordEvent(eventname);
//-->
</script>

<script language=javascript event=NotifyToolBarClick(iIndex) for=WebOffice1>
<!--
	WebOffice_Event_Flash("NotifyToolBarClick");
	WebOffice1_NotifyToolBarClick(iIndex);
//-->
</script>

<script language=javascript>
/****************************************************
 *
 *		控件初始化WebOffice方法
 *
 ****************************************************/
function WebOffice1_NotifyCtrlReady() {
	document.all.WebOffice1.SetWindowText("合同打印", 0);
	document.all.WebOffice1.OptionFlag |= 128;
	spnWebOfficeInfo.innerText = "您电脑上安装的WebOffice版本为:V" + document.all.WebOffice1.GetOcxVersion() + "\t\t\t本实例是根据版本V6044编写";
}
var flag = false;
function menuOnClick(id) {
	var id = document.getElementById(id);
	var dis = id.style.display;
	if (dis != "none") {
		id.style.display = "none";
	} else {
		id.style.display = "block";
	}
}
/****************************************************
 *
 *		接收office事件处理方法
 *
 ****************************************************/
var vNoCopy = 0;
var vNoPrint = 0;
var vNoSave = 0;
var vClose = 0;
function no_copy() {
	vNoCopy = 1;
}

function yes_copy() {
	vNoCopy = 0;
}

function no_print() {
	vNoPrint = 1;
}

function yes_print() {
	vNoPrint = 0;
}

function no_save() {
	vNoSave = 1;
}

function yes_save() {
	vNoSave = 0;
}

function EnableClose(flag) {
	vClose = flag;
}

function CloseWord() {
	document.all.WebOffice1.CloseDoc(0);
}

function WebOffice1_NotifyWordEvent(eventname) {
	if (eventname == "DocumentBeforeSave") {
		if (vNoSave) {
			document.all.WebOffice1.lContinue = 0;
			alert("此文档已经禁止保存");
		} else {
			document.all.WebOffice1.lContinue = 1;
		}
	} else if (eventname == "DocumentBeforePrint") {
		if (vNoPrint) {
			document.all.WebOffice1.lContinue = 0;
			alert("此文档已经禁止打印");
		} else {
			document.all.WebOffice1.lContinue = 1;
		}
	} else if (eventname == "WindowSelectionChange") {
		if (vNoCopy) {
			document.all.WebOffice1.lContinue = 0;
		} else {
			document.all.WebOffice1.lContinue = 1;
		}
	} else if (eventname == "DocumentBeforeClose") {
		if (vClose == 0) {
			document.all.WebOffice1.lContinue = 0;
		} else {
			document.all.WebOffice1.lContinue = 1;
		}
	}
}

var s = "";
if(navigator.userAgent.indexOf("MSIE")>0){
	s = "<OBJECT id='WebOffice1' align='middle' style='LEFT: 0px; WIDTH: 100%; TOP: 0px; HEIGHT:100%'"
		+ "classid=clsid:E77E049B-23FC-4DB8-B756-60529A35FAD5>"
		+ "</OBJECT>";
}

if(navigator.userAgent.indexOf("Chrome")>0){
	s = "<object id='WebOffice1' type='application/x-itst-activex' align='baseline' border='0'"
		+ "style='LEFT: 0px; WIDTH: 100%; TOP: 0px; HEIGHT: 100%'"
		+ "clsid='{E77E049B-23FC-4DB8-B756-60529A35FAD5}'"
		+ "event_NotifyCtrlReady='WebOffice1_NotifyCtrlReady'>"
		+ "</object>";	
}

if(navigator.userAgent.indexOf("Firefox")>0){
	s = "<object id='WebOffice1' type='application/x-itst-activex' align='baseline' border='0'"
		+ "style='LEFT: 0px; WIDTH: 100%; TOP: 0px; HEIGHT: 100%'" 
		+ "clsid='{E77E049B-23FC-4DB8-B756-60529A35FAD5}'"
		+ "event_NotifyCtrlReady='WebOffice1_NotifyCtrlReady'>"
		+ "</object>";	
}
document.write(s);

function dd() {
	document.all.WebOffice1.FullScreen = 0;
}

function ddd() {
	try {
		var WebOffice1 = $("#WebOffice1").get(0);
		WebOffice1.LoadOriginalFile("${imgInfo.imgUrl}", "doc");
		WebOffice1.SetFieldValue("custName", "${applyCustInfo.custName}", "");    // 贷款人姓名
		WebOffice1.SetFieldValue("docNo", "${applyCustInfo.docNo}", "");          // 贷款人身份证号码
		WebOffice1.SetFieldValue("address", "${applyCustInfo.address}", "");      // 贷款人地址
		WebOffice1.SetFieldValue("mobile", "${applyCustInfo.mobile}", "");        // 贷款人手机
		WebOffice1.SetFieldValue("telephone", "${applyCustInfo.telephone}", "");  // 贷款人电话 
		WebOffice1.SetFieldValue("loanTime", "${applyInfo.loanTime}", "");        // 贷款期限
		WebOffice1.SetFieldValue("amountCN", "${amountCN}", "");				  // 贷款金额（大写）
		WebOffice1.SetFieldValue("amount", "${applyInfo.amount}", "");			  // 贷款金额（小写）
		WebOffice1.SetFieldValue("applyCode", "${applyInfo.applyCode}", "");      // 合同编号
		WebOffice1.SetFieldValue("houseArea", "${applyInfo.houseArea}", "");      // 房屋面积
		WebOffice1.SetFieldValue("housePrice", "${applyInfo.housePrice}", "");    // 房屋总价
		WebOffice1.SetFieldValue("lpAddr", "${comLp.lpAddr}", "");                // 楼盘详细地址
		
		WebOffice1.SetFieldValue("companyName", "${company.companyName}", "");    // 开发商名称
		WebOffice1.SetFieldValue("companyFName", "${company.companyFName}", "");  // 开发商法人代表姓名
		WebOffice1.SetFieldValue("companyBankNameA", "${company.companyBankNameA}", "");   // 开发商银行A
		WebOffice1.SetFieldValue("companyAccoutA", "${company.companyAccoutA}", "");       // 开发商银行帐号A
		WebOffice1.SetFieldValue("companyBankNameB", "${company.companyBankNameB}", "");   // 开发商银行B
		WebOffice1.SetFieldValue("companyAccoutB", "${company.companyAccoutB}", "");       // 开发商银行帐号B
	} catch (e) {
		alert("报错啦！");
	}
}

$(function() {
	ddd();
});
</script>

<form id="myform">
	<script type="text/javascript" src="${path}/js/LoadWebOffice.js"></script>
</form>