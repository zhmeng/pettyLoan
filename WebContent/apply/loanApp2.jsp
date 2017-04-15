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
<title>贷款申请表</title>
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
.anjiu{ margin:20px 0; }
.anjiu .anniu{ margin-right:20px;}
.anniu ,.anniu1{ width:100px;background:#e94700; border-radius: 5px; cursor:pointer;color:#fff; font-size:14px; font-weight:bold; float:left;position:relative; left:39%; margin-bottom:20px;}
</style>
<script type="text/javascript">
var a = 0;

//添加一行 
function addFile() {
	++a;
	$("#fileDiv").append("<span class='tr_"+a+"' style='color:#FF0000;'><input type='file' size='40' name='image' style='height:24px;' id='file_"+a+"'>&nbsp;&nbsp;请输入中文名称:<input type='text' value='' name='imgInfo.imgChinaName' id='imgChinaName'/>&nbsp;&nbsp;&nbsp;<input type='button' value='新增' onclick='addFile();' >&nbsp;&nbsp;<input type='button' value='删除' onclick='removeFile("
		+ a + ");'><span name='divName' id='divName'></span><br class='tr_"+a+"'/><br class='tr_"+a+"'/></span>");
	window.parent.resize(window);
}

//删除一行 
function removeFile(id) {
	if (id == 1) {
		alert("第一条文件,您不能删除!");
		return;
	} else {
		$("span").remove(".tr_" + id);
	}
	window.parent.resize(window);
}

</script>
<script>

function changeNumMoneyToChinese(obj) {
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




function validateAll(){
	var re1 = new RegExp("[\u4E00-\uFA29]|[\uE7C7-\uE7F3]");
	//手机校验
	var myreg = /^\d{11}$/;
	var num = /^[0-9]+([.]{1}[0-9]{1,2})?$/;  //金额校验
	var month =/^[0-9]*[1-9][0-9]*$/;// 整数校验
	var paypercent=/^([1-9]|10)$/; //首付成数1-10校验
	var lilv =/^[0-9]+([.]{1}[0-9]+){0,1}$/;// 输入整数或者小数的利率
	
	var companyInfo = $("#companyInfo").val();
	var cityInfo = $("#cityInfo").val();
	var comlpInfo = $("#comlpInfo").val();
	var productInfo = $("#productInfo").val();
	
	if(companyInfo==0){
		alert("请选择开发商");
		return 0;
	}
	if(cityInfo==0){
		alert("请选择城市");
		return 0;
	}
	if(comlpInfo==0){
		alert("请选择楼盘");
		return 0;
	}
	if(productInfo==0){
		alert("请选择产品");
		return 0;
	}
	var leaseMoney=$("leaseMoney").val();
	if(leaseMoney!=""){
		if(!month.test(leaseMoney)){
			alert("输入错误");
			$("#leaseMoney").focus();
		}
	}
	 var bigAmount=$("#bigAmount").val();//申请额度：（人民币大写） bigAmount 格式判断 必填判断 
		if(bigAmount==""){
			alert("请输入申请额度!");
			$("#bigAmount").focus();
			return 0;
		}
		var amount=$("#amount").val(); //这个必须要去申请额度的值相等
		if(amount==""){
			alert("请输入小写人民币");
			$("#amount").focus();
			return 0;
		}
		var loanTime=$("#loanTime").val();//申请期限 loanTime 格式判断 必填判断 
		if(loanTime==""){
			alert("请输入申请期限！");
			$("#loanTime").focus();
			return 0;
		}else if(!month.test(loanTime)){
			alert("申请期限为整数，请重新输入！");
			$("#loanTime").focus();
			return 0;
		} 
		var rate = $("#rate").val();//财务顾问费利率  可以输入整数和小树
		if(rate==""){
			alert("请输入利率!");
			$("#rate").focus();
			return 0;
		}else if(!lilv.test(rate)){
			alert("请输入合法的利率");
			$("#rate").focus();
			return 0;
		} 
		
		
		
		var feeRate=$("#feeRate").val(); // 手续费利率
		if(feeRate==""){
			alert("请输入手续费利率");
			$("#feeRate").focus();
			return 0;
		}else if(!lilv.test(feeRate)){
			alert("请输入合法的手续费利率");
			$("#feeRate").focus();
			return 0;
		} 
	
	   var custName=$("#custName").val();// 姓名 格式判断 必填
	  if(custName==""){
		alert("请输入名字");
		$("#custName").focus();
		return 0;
	}
	var docNo=$("#docNo").val();// 身份证号码 docNo 格式判断 必填
	var personIDTip = isCardID(docNo);
	if(docNo==""){
		alert("请输入身份证");
		$("#docNo").focus();
		return 0;
	}
	if(personIDTip!=true){
		alert("请输入合法身份证");
		$("#docNo").focus();
		return 0;
	}
	var mobile=$("#mobile").val();//手机 mobile 格式判断 必填
	 if(mobile.length==0){
		alert("请输入手机号");
		$("#mobile").focus();
		return 0;
	}else if(!myreg.test(mobile)){
		alert("请输入有效的手机号");
		$("#mobile").focus();
		return 0;
	}  
	var address=$("#address").val();//家庭现住地址 address 必填判断 格式判断
	if(address==""){
		alert("请输入家庭现住址");
		$("#address").focus();
		return 0;
	}
	var zxInsider=$("#zxInsider").val();//①直系亲属姓名 zxInsider 长度判断
	if(zxInsider!=""&&zxInsider.length>20){
		alert("直系亲属姓名太长，请重新输入");
		$("#zxInsider").focus();
		return 0;
	}
	var zxRelation=$("#zxRelation").val();//与申请人关系 zxRelation 长度判断
	if(zxRelation!=""&&zxRelation.length>10){
		alert("与申请人关系长度太长，请重新输入!");
		$("#zxRelation").focus();
		return 0;
	}
	//地址 zxAdress长度判断
	var zxAdress=$("#zxAdress").val();
	if(zxAdress!=""&&zxAdress.length>200){
		alert("地址长度太长，请重新输入");
		$("#zxAdress").focus();
		return 0;
	}
	var zxCompany=$("#zxCompany").val();//直系亲属工作单位 zxCompany
	if(zxCompany!=""&&zxCompany.length>100){
		alert("工作单位太长，请重新输入!");
		$("#zxCompany").focus();
		return 0;
	}
	var zxMobile=$("#zxMobile").val();//手机 zxMobile 格式判断
	if(zxMobile.length!=""&&!myreg.test(zxMobile)){
		alert("请输入有效的手机号");
		$("#zxMobile").focus();
		return 0;
	}  
	var qsName=$("#qsName").val();//亲属姓名 qsName
	if(qsName!=""&&qsName.length>20){
		alert("亲属姓名太长，请重新输入！");
		$("#qsName").focus();
		return 0;
	}
	var qsCorp=$("#qsCorp").val();//工作单位 qsCorp
	if(qsCorp!=""&&qsCorp.length>100){
		alert("亲属工作单位太长，请重新输入！");
		$("#qsCorp").focus();
		return 0;
	}
	var qsMobile=$("#qsMobile").val();//手机 qsMobile 格式判断
	if(qsMobile.length!=""&&!myreg.test(qsMobile)){
		alert("请输入有效的手机号");
		$("#qsMobile").focus();
		return 0;
	}
	var qsAddr=$("#qsAddr").val();//亲属地址qsAddr
	if(qsAddr!=""&&qsCorp.qsAddr>200){
		alert("亲属现住址太长，请重新输入！");
		$("#qsAddr").focus();
		return 0;
	}
	var tsMobile=$("#tsMobile").val();//手机 tsMobile 格式判断
	if(tsMobile.length!=""&&!myreg.test(tsMobile)){
		alert("请输入有效的手机号");
		$("#tsMobile").focus();
		return 0;
	}
	var otherMobile=$("#otherMobile").val();//手机 otherMobile 格式判断
	if(otherMobile.length!=""&&!myreg.test(otherMobile)){
		alert("请输入有效的手机号");
		$("#otherMobile").focus();
		return 0;
	} 
	
	 var cusName=$("#cusName").val();//公司名称 cusName 必填判断 格式判断
	if(cusName==""){
		alert("公司名称不能为空");
		$("#cusName").focus();
		return 0;
	}else if(cusName.length>200){
		alert("公司名称太长");
		$("#cusName").focus();
		return 0;
	} 
	
	 var comBusiness=$("#comBusiness").val();//公司主营业务 comBusiness 必填判断 
	if(comBusiness==""){
		alert("请输入公司主营业务!");
		$("#comBusiness").focus();
		return 0;
	}else if(comBusiness!=""&&comBusiness.length>100){
		alert("公司主营业务太长，请重新输入!");
		$("#comBusiness").focus();
		return 0;
	}
	  var comAdress=$("#comAdress").val();//公司实际地址 comAdress  必填判断 
	if(comAdress==""){
		alert("请输入公司实际地址！")
		$("#comAdress").focus();
		return 0;
	}else if(comAdress.length>200){
		alert("公司实际地址太长，请重新输入!");
		$("#comAdress").focus();
		return 0;
	} 
	 
	 
	 
	 
	var comTel=$("#comTel").val();//公司固定电话 comTel  必填判断 
	if(comTel==""){
		alert("请输入公司固定电话");
		$("#comTel").focus();
		return 0;
	} 
	// 公司规模 格式判断
	 var comSize =$("#comSize").val();
	if(comSize!=""&&!month.test(comSize)){
		alert("请输入有效的人数");
		$("#comSize").focus();
		return 0;
	}
	var salary=$("#salary").val();//月收入 salary 格式判断 必填判断 
	if(salary==""){
		alert("请输入月收入!");
		$("#salary").focus();
		return 0;
	}else if(!num.test(salary)){
		alert("请输入有效的金额!");
		$("#salary").focus();
		return 0;
	}  
	
	 var houseAdress=$("#houseAdress").val();//购置房屋地址长度判断
	if(houseAdress==""){
		alert("请输入购置房屋地址!");
		$("#houseAdress").focus();
		return 0;
	}else if(houseAdress.length>200){
		alert("购置房屋地址太长，请重新输入!");
		$("#houseAdress").focus();
		return 0;
	} 
	 var firstPayPercent=$("#firstPayPercent").val();//首付成数
	if(firstPayPercent!=""&&!paypercent.test(firstPayPercent)){
		alert("首付成数必须为1-10整数!");
		$("#firstPayPercent").focus();
		return 0;
	}
	
		return 1;
	
	
}
	function addLoan(){
		if(validateAll()==0){
			return;
		}
		   /*   if(!validateAll()){
			return false;
		}    */ 
		$("#loanForm").submit();
		
	}
	function updateLoan(){
		if(validateAll()==0){
			return;
		}
		$("#loanForm").submit();
	}
	
	var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}
	function isCardID(sId){ 
		var iSum=0 ;
		var info="" ;
		if(!/^\d{17}(\d|x)$/i.test(sId)) return "身份证长度或格式错误"; 
		sId=sId.replace(/x$/i,"a"); 
		if(aCity[parseInt(sId.substr(0,2))]==null) return "你的身份证地区非法"; 
		sBirthday=sId.substr(6,4)+"-"+Number(sId.substr(10,2))+"-"+Number(sId.substr(12,2)); 
		var d=new Date(sBirthday.replace(/-/g,"/")) ;
		if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate()))return "身份证上的出生日期非法"; 
		for(var i = 17;i>=0;i --) iSum += (Math.pow(2,i) % 11) * parseInt(sId.charAt(17 - i),11) ;
		if(iSum%11!=1) return "你输入的身份证号非法"; 
		return true;//aCity[parseInt(sId.substr(0,2))]+","+sBirthday+","+(sId.substr(16,1)%2?"男":"女") 
	} 
	
	function CompanyChange(obj)
	{
		var cityID = obj.value;
		var strTmp="";
		$.jsonPost("${path}/loanApp/getAlllnapByCityID","cityID=" + cityID, function(data) {
			 $("#comlpInfo").html("<option value='0'>请选择</option>");
				if (data != null) {
					var strarray = [];
					var slen = data.length;
					for (var i = 0; i < slen; i++) {
						var obj = data[i];						
						strTmp += "<option value='" + obj.lpID+ "'>" + obj.lpName+ "</option>";
					}				
					$("#comlpInfo").append(strTmp);
				}
		 });
	}
	function tijiaos(){
		//alert("sasa");
		//alert(form.attr("action"));
	/*	var form=$("#loanForms");
		form.attr("action","${path}/loanApp/updateStatus");
		form.get(0).submit();*/
		var path=$("#path").val();
		var applyID=$("#applyID").val();
		var datas={
			applyID:applyID
		};
		jQuery.ajax({
			type : "post", 
			url : path + "/loanApp/updateStatus", 
			data : datas, 
			dataType : "json", 
			error : function() { 
				alert("出错了");
			},
			success : function(data) { 
				if (data.success) {
					if(data.msg=="2"){
						alert("成功！！！");
					}
					
					window.returnValue = true;
					window.close();
				}else{
					alert("出错了");
				}
			}
		});
	}
	function load(){
		var path = $("#path").val();
		
		var data={
				
		};
		$.post(path + "/loanApp/goApplyInfoList", data, function(data) {
			$("#userinfoContainer").html(data);
			}, 'html');
	}
</script>
</head>
<body>
<input type="hidden" id="path" value="${path}"/>
<c:choose>
	<c:when test="${empty acust}">
<form action="${path}/loanApp/addLoanApp" method="post" id="loanForm">
<input type="hidden" value="${modId}" name="modId" id="modId"/>
<table  width="1100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td style="border-left:none;"valign="top"><table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td style="font-size:28px; font-weight:bold; text-align:center;border-right:1px solid #000;" valign="top">贷款申请表</td>
      </tr>
    </table>



<table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td  style="background:#ccc;font-weight:bold; font-size:14px;border-right:1px solid #000;border-top:none;">贷款信息: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          </td>
      </tr>
    </table>    
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    
    <tr style="border-bottom: 1px solid #000;border-right: 1px solid #000;">
        <td width="121"><span class="bitian">*</span>开发商：
        </td><td>
          <select id="companyInfo" name="companyInfo">
   		 	<option value="0">请选择</option>
							<c:forEach var="companyList" items="${companyList }">
								<option value="${companyList.companyID }">${companyList.companyName }</option>
							</c:forEach>
						</select>
		</td>
        <td width="121"><span class="bitian">*</span>城市:
        </td><td>
          <select id="cityInfo" name="cityInfo"  onchange="CompanyChange(this)">
   		 	<option value="0">请选择</option>
							<c:forEach var="cityList" items="${cityList }">
								<option value="${cityList.ID }">${cityList.cityName }</option>
							</c:forEach>
   		 </select></td>
        <td width="121"><span class="bitian">*</span>楼盘:
        </td><td>
          <select id="comlpInfo" type="hidden" name="comlpInfo">
   		 	<option value="0">请选择</option>
							<%-- <c:forEach var="cLpList" items="${cLpList }">
								<option value="${cLpList.lpID }">${cLpList.lpName }</option>
							</c:forEach> --%>
   		 </select></td>
        <td style="border-right:1px solid #000;" width="258">&nbsp;&nbsp;<span class="bitian">*</span>产品
          <select id="productInfo" name="productInfo">
   		 	<option value="0">请选择</option>
							<c:forEach var="productList" items="${productList }">
								<option value="${productList.productID }">${productList.productName }</option>
							</c:forEach>
   		 </select></td>
      </tr>
      
   		 
      </table>        
      
      
      
      
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="121"><span class="bitian">*</span>申请额度：</td>
         <td width="240"><label>（人民币小写）
            <input style="width:30%; border-bottom:1px solid #000; height:20px;line-height:20px;" type="text" name="ainfo.amount" id="amount"  onkeyup="value=value.replace(/[^/0-9]/g,'')" onblur="changeNumMoneyToChinese(this)" />
万元整</label></td>
        <td width="236"><label>（人民币大写）
            <input style="width:30%; border-bottom:1px solid #000; height:20px; line-height:20px;" type="text" name="ainfo.bigAmount" id="bigAmount" />
        万元整</label></td>
       
        <td width="201"><label><span class="bitian">*</span>申请期限
            <input style="width:30%; border-bottom:1px solid #000; height:20px;line-height:20px;" type="text" name="ainfo.loanTime" id="loanTime" /> 
            月
</label></td>

<td width="163">
				<span class="bitian">*</span>贷款年利率<input type="text" name="ainfo.rate" id="rate"/>%  &nbsp;&nbsp;&nbsp;&nbsp;</td>
<td width="163" style="border-right: 1px solid #000;">
				<span class="bitian">*</span>手续费利率<input type="text" name="ainfo.feeRate" id="feeRate"/>% &nbsp;&nbsp;&nbsp;&nbsp; 
			</td>
</tr>

<tr>
	<td>
	逾期本金罚息利率
	</td>
	<td>
	逾期利息罚息利率
	</td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	
</tr>
    </table>
<tr>
    <td  style="background:#ccc;font-weight:bold; font-size:14px;border-right:1px solid #000; border-top:none;">个人资料</td>
  </tr>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="239"><span class="bitian">*</span>姓名: 
          <label>
          <input type="text" name="acust.custName" id="custName" value=""/>
          </label></td>
        <td width="197"><span class="bitian">*</span>性别：
          <input type="radio" name="acust.gender" id="gender1" value="1" class="pisu" checked="checked"/>男  &nbsp;&nbsp;&nbsp;&nbsp;
		  <input type="radio" name="acust.gender" id="gender2" value="2" class="pisu"/>女
		</td>
        <td width="129" align="center"><span class="bitian">*</span>身份证号码</td>
        <td style="border-right:1px solid #000;" width="454"><input type="sfz" style="width:450px" name="acust.docNo" id="docNo"/></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="265">出生日期:         
          <input type="text" name="acust.birthday" id="birthday" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})"/>
          </td>
        <td width="357"><span class="bitian">*</span>婚烟状况：
          					<input type="radio" name="acust.marry" id="marry" class="pisu" value="1" checked="checked"/>未婚  &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" class="pisu" value="2"/>已婚 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" class="pisu" value="3"/>离婚 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="acust.marry" id="marry" class="pisu" value="4"/>其他 &nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td width="122">子女数:          
          <input type="text" name="acust.sonCount" id="sonCount" size="5"/>个
          </td>
      </tr>
    </table>
    
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><span class="bitian">*</span>手机:
          <label>
            <input type="text" name="acust.mobile" id="mobile"/>
          </label></td>
        <td>住宅电话:
          <label>
            <input type="text" name="acust.telephone" id="telephone"/>
          </label></td>
        <td style="border-right:1px solid #000;">居住状况：
           <input type="radio" name="acust.liveStatus" class="pisu" id="liveStatus1" value="1"/>按揭中
		   <input type="radio" name="acust.liveStatus" class="pisu" id="liveStatus2" value="2"/>非按揭
           <input type="radio" name="acust.liveStatus" class="pisu" id="liveStatus3" value="3"/>租凭(月租:<input name="acust.leaseMoney" id="leaseMoney"/>)
           <input type="radio" name="acust.liveStatus" class="pisu" id="liveStatus4" value="4"/>其他
          </td>
          
          
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="445">其它联系方式:
          <label>
            <input type="text" name="acust.otherContact" id="otherContact"/>
          </label></td>
        <td width="83">当地工作时间</td>
        <td style="border-right:1px solid #000;" width="512"><input type="text" name="acust.wokTime" id="wokTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})"/></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="445"><span class="bitian">*</span>家庭现住址:
          <label>
            <input  style="width:80%;" type="text" name="acust.address" id="address" />
          </label></td>
        <td width="83">教育水平</td>
        <td style="border-right:1px solid #000;" width="512">
        		<select name="acust.education">
					<option value="1">初中及以下</option>
					<option value="2">高中</option>
					<option value="3">大专</option>
					<option value="4">本科</option>
					<option value="5">硕士</option>
					<option value="6">博士</option>
				</select></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="121">①直系亲属姓名 :
          <label></label></td>
        <td width="210" align="left"><input type="text" name="acust.zxInsider" id="zxInsider"/></td>
        <td width="268">与申请人关系:
          <label>
          <input type="text" name="acust.zxRelation" id="zxRelation"/>
          </label></td>
        <td width="258">固定电话:
          <input  style="width:70%;" type="text" name="acust.zxTel" id="zxTel" /></td>
        <td style="border-right:1px solid #000;" width="258">&nbsp;&nbsp;住址
          <label>
            <input  style="width:70%;" type="text" name="acust.zxAdress" id="zxAdress" />
          </label></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="121">手机 : 
         </td>
        <td width="210" align="left"><input type="text" name="acust.zxMobile" id="zxMobile" /></td>
        <td width="101">工作单位  :
          <label></label></td>
        <td width="288"><input style="width:80%;" type="text" name="acust.zxCompany" id="zxCompany" /></td>
        <td width="140">是否知晓贷款:          </td>
        <td style="border-right:1px solid #000;" width="259">
        		<select name="acust.zxKonw" id="zxKonw">
					<option value="1">是</option>
					<option value="2">否</option>
				</select></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="121">②亲属姓名 : 
          <label></label></td>
        <td width="210" align="left"><input type="text" name="acust.qsName" id="qsName"/></td>
        <td width="101">工作单位  :
          <label></label></td>
        <td width="288"><input style="width:80%;" type="text" name="acust.qsCorp" id="qsCorp" /></td>
        <td width="140">是否知晓贷款:          </td>
        <td style="border-right:1px solid #000;" width="259">
        		<select name="acust.qsKonw" id="qsKonw">
					<option value="0">请选择</option>
					<option value="1">是</option>
					<option value="2">否</option>
				</select></td>
      </tr>
      
      <tr>
        <td >手机 : 
          <label></label></td>
        <td width="172" align="left"><input type="text" name="acust.qsMobile" id="qsMobile"/></td>
        <td width="101">单位电话  :
          <label></label></td>
        <td width="387"><input style="width:80%;" type="text" name="acust.qsCorpTel" id="qsCorpTel" /></td>
        <td style="border-right:1px solid #000;" width="305">现住址:</td>
          <td colspan="2"><input  style="width:70%;" type="text" name="acust.qsAddr" id="qsAddr" /></td>
          <td></td>
      </tr>
    </table>  
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="121">③同事姓名:
          <label></label></td>
        <td width="210" align="left"><input type="text" name="acust.tsName" id="tsName"/></td>
        <td width="101">职位  :
          <label></label></td>
        <td width="288"><input style="width:80%;" type="text" name="acust.tsPosition" id="tsPosition" /></td>
        <td width="140">是否知晓贷款: </td>
        <td style="border-right:1px solid #000;" width="259">
        		<select name="acust.tsKonw" id="tsKonw">
					<option value="1">是</option>
					<option value="2">否</option>
				</select></td>
      </tr>
    </table>    
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="60">手机 :
          <label></label></td>
        <td width="172" align="left"><input type="text" name="acust.tsMobile" id="tsMobile"/></td>
        <td width="101">单位电话  :
          <label></label></td>
        <td width="387"><input style="width:80%;" type="text" name="acust.tsTel" id="tsTel" /></td>
        <td style="border-right:1px solid #000;" width="305">现住址:
          <input  style="width:70%;" type="text" name="acust.tsAddr" id="tsAddr" /></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="292">④其他联系人姓名：
          <input type="text" name="acust.otherName" id="otherName"/></td>
        <td width="277">与申请人关系  :
          <label>
          <input type="text" name="acust.otherRelation" id="otherRelation"/>
          </label></td>
        <td width="233">手机：
          <input type="text" name="acust.otherMobile" id="otherMobile"/></td>
        <td style="border-right:1px solid #000;" width="326">是否知晓贷款: 
          	<select name="acust.otherKonw" id="otherKonw">
					<option value="1">是</option>
					<option value="2">否</option>
				</select></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="60">现住址 :
          <label></label></td>
        <td width="172" align="left"><input type="text" name="acust.otherAddr" id="otherAddr"/></td>
        <td width="101">单位或住宅电话  :
          <label></label></td>
        <td width="387"><input style="width:80%;" type="text" name="acust.otherTel" id="otherTel" /></td>
        <td style="border-right:1px solid #000;" width="305">工作单位及地址:
          <input  style="width:60%;" type="text" name="acust.otherCompany" id="otherCompany" /></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td style="background:#ccc;font-weight:bold; font-size:14px;border-right:1px solid #000;">公司资料</td>
        </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="273"><span class="bitian">*</span>公司名称: 
          <label>
          <input name="company.cusName" id="cusName"/>
          </label></td>
        <td width="273"><span class="bitian">*</span>公司成立日期: 
          <label>
          <input name="company.companyCreateDate" id="companyCreateDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})"/>
          </label></td>
        <td width="214">部门：
          <label>
          <input name="company.dept" id="dept"/>
          </label></td>
        <td width="352" style="border-right:1px solid #000;">职 务:
          <label>
          <input name="company.position" id="position" type="text"/>
          </label></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="301"><label></label>          <label></label>          <label></label>          <label><span class="bitian">*</span>公司主营业务:
          <input type="text" name="company.comBusiness" id="comBusiness"/>
        </label></td>
        <td style="border-right:1px solid #000;" width="812">企业性质：
          <label>
          		<input type="radio" name="company.comAttribute" class="pisu" id="comAttribute" value="1"/>国有企业 &nbsp;&nbsp;
				<input type="radio" name="company.comAttribute" class="pisu" id="comAttribute" value="2"/>三资企业 &nbsp;&nbsp;
				<input type="radio" name="company.comAttribute" class="pisu" id="comAttribute" value="3"/>集体企业 &nbsp;&nbsp;
				<input type="radio" name="company.comAttribute" class="pisu" id="comAttribute" value="4"/>私营企业 &nbsp;&nbsp;
				<input type="radio" name="company.comAttribute" class="pisu" id="comAttribute" value="5"/>其它</label></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="301"><label></label>
            <label></label>
            <label></label>
            <label><span class="bitian">*</span>公司实际地址:
              <input type="text" name="company.comAdress" id="comAdress"/>
          </label></td>
        <td width="812" style="border-right:1px solid #000;"><span class="bitian">*</span>公司固定电话：
          <input style="width:80%;"type="text" name="company.comTel" id="comTel" />
<label></label></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="300"><label></label>
            <label></label>
            <label></label>
            <label>公司规模：
              <input type="text" name="company.comSize" id="comSize"/>人
          </label></td>
        <td width="294">行业类型：
          <input type="text" name="company.comClass" id="comClass"/>
            <label></label></td>
         <td width="306">公司场所类别
          </td> 
        <td style="border-right:1px solid #000;" width="200"><input name="company.comHouseCategory" type="radio" class="pisu" id="comHouseCategory" value="1" />
自有
  <input type="radio" name="company.comHouseCategory" class="pisu" id="comHouseCategory" value="2"/>
租赁 </td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td  style="background:#ccc;font-weight:bold; font-size:14px;border-right:1px solid #000;">财务信息概述</td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="259">年营业额：
          <label>
          <input type="text" name="fance.turnover" id="turnover"/>
          </label></td>
        <td width="271">其他收入：
          <label>
          <input type="text" name="fance.otherIncome" id="otherIncome"/>
          </label></td>
        <td width="93">净利润：          </td>
        <td width="194"><input type="text" name="fance.profits" id="profits"/></td>
        <td width="102">负债：</td>
        <td style="border-right:1px solid #000;" width="181"><input type="text" name="fance.liabilities" id="liabilities" /></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="259">发薪日:
          <label>
            <input type="text" name="fance.salaryDay" id="salaryDay" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})"/>
          </label></td>
        <td width="364"><span class="bitian">*</span>月收入:

          <label>
            <input type="text" name="fance.salary" id="salary"/>元
          </label></td>
        <td width="51">负债：</td>
        <td style="border-right:1px solid #000;" width="426"><input type="text" name="fance.personLiabilities" id="personLiabilities" /></td>
      </tr>
    </table>
    <table class="bige" width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="80">房产地址</td>
        <td><label>
          <input type="text" name="fance.houseAdress" id="houseAdress1"/>
        </label></td>
        <td>购买日期
          <input type="text" name="fance.buyDate" id="buyDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})"/></td>
        <td>购买价格
          <input type="text" name="fance.buyPrice" id="buyPrice" /></td>
        <td>购买方式</td>
        <td style="border-right:1px solid #000;"><input type="radio" name="fance.busState" id="busState" value="1" class="pisu"/>一次性 &nbsp;
				<input type="radio" name="fance.busState" id="busState" value="2" class="pisu"/>按揭 </td>
      </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="120" align="center">按揭银行</td>
        <td width="120"><input type="text" name="fance.ajBank" id="ajBank" />&nbsp;</td>
        <td width="60" align="center">贷款总额</td>
        <td width="120"><input type="text" name="fance.loanAMT" id="loanAMT" />&nbsp;</td>
        <td width="60" align="center">月供金额</td>
        <td width="120"><input type="text" name="fance.payMonth" id="payMonth" />&nbsp;</td>
        <td width="60">贷款余额</td>
        <td width="140"><input type="text" name="fance.loanRemaining" id="loanRemaining" />&nbsp;</td>
        <td width="130">其它房产总数及价值</td>
        <td style="border-right:1px solid #000;"><input type="text" name="fance.otherHouse" id="otherHouse" />&nbsp;</td>
      </tr>
    </table>    
    <table class="bige" width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="80">车牌号码</td>
        <td><label>
          <input type="text" name="fance.carNum" id="carNum" />
        </label></td>
        <td>购买日期
          <input type="text" name="fance.carBuyDate" id="carBuyDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})"/></td>
        <td>购买价格
          <input type="text" name="fance.carBuyPrice" id="carBuyPrice" /></td>
        <td>购买方式</td>
        <td style="border-right:1px solid #000;"><input type="radio" name="fance.carBusState" class="pisu" id="carBusState" value="1"/>一次性&nbsp;
				<input type="radio" name="fance.carBusState" class="pisu" id="carBusState" value="2"/>按揭 </td>
      </tr>
    </table>    
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="120" align="center">按揭银行</td>
        <td width="120"><input type="text" name="fance.carAJBank" id="carAJBank" />&nbsp;</td>
        <td width="60" align="center">贷款总额</td>
        <td width="120"><input type="text" name="fance.carLoanAMT" id="carLoanAMT" />&nbsp;</td>
        <td width="60" align="center">月供金额</td>
        <td width="120"><input type="text" name="fance.carPayMonth" id="carPayMonth" />&nbsp;</td>
        <td width="60">贷款余额</td>
        <td width="140"><input type="text" name="fance.carLoanRemaining" id="carLoanRemaining" />&nbsp;</td>
        <td width="130">其它车辆总数及价值</td>
        <td style="border-right:1px solid #000;"><input type="text" name="fance.otherCar" id="otherCar" />&nbsp;</td>
      </tr>
    </table>    
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td  style="background:#ccc;font-weight:bold; font-size:14px;border-right:1px solid #000;">申请人贷款历史: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
           </td>
      </tr>
    </table>    
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="28%" align="center">银行，私人，金融机构、其他 </td>
        <td width="12%" align="center">金额</td>
        <td width="13%" align="center">放款日期</td>
        <td width="15%" align="center">月还款额</td>
        <td width="14%" align="center">是否有逾期</td>
        <td width="5%" rowspan="4" style="font-weight:bold; text-align:center;"><p>信</p><p>用</p><p>卡</p></td>
        <td width="13%" style="border-right:1px solid #000;"><input type="checkbox" name="checkbox14" id="checkbox28" class="pisu" />
按揭 
  <input type="checkbox" name="checkbox15" id="checkbox29" class="pisu" />
按揭 </td>
      </tr>
      <tr>
        <td><label>
          <input style="width:90%;"type="text" name="loan.loanBank" id="loanBank" />
        </label></td>
        <td><input style="width:90%;"type="text" name="loan.loanAmt" id="loanAmt" /></td>
        <td><input style="width:90%;"type="text" name="loan.payDate" id="payDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})"/></td>
        <td><input style="width:90%;"type="text" name="loan.payMonth" id="payMonth" /></td>
        <td><input type="radio" name="loan.isoOverdue" id="isoOverdue" value="1" class="pisu"/>是&nbsp;&nbsp;
				<input type="radio" name="loan.isoOverdue" id="isoOverdue" value="2" class="pisu"/>否</td>
        <td style="border-right:1px solid #000;">总张数：
          <input style="width:40%;"type="text" name="" id="" /></td>
      </tr>
      <tr>
        <td><input style="width:90%;"type="text" name="loan2.loanBank" id="loanBank" /></td>
        <td><input style="width:90%;"type="text" name="loan2.loanAmt" id="loanAmt" /></td>
        <td><input style="width:90%;"type="text" name="loan2.payDate" id="payDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})"/></td>
        <td><input style="width:90%;"type="text" name="loan2.payMonth" id="payMonth" /></td>
        <td><input type="radio" name="loan2.isoOverdue" id="isoOverdue" value="1" class="pisu"/>是&nbsp;&nbsp;
				<input type="radio" name="loan2.isoOverdue" id="isoOverdue" value="2" class="pisu"/>否</td>
        <td style="border-right:1px solid #000;">总额度：
          <input style="width:40%;"type="text" name="" id="" /></td>
      </tr>
      <tr>
        <td><input style="width:90%;"type="text" name="loan3.loanBank" id="loanBank" /></td>
        <td><input style="width:90%;"type="text" name="loan3.loanAmt" id="loanAmt" /></td>
        <td><input style="width:90%;"type="text" name="loan3.payDate" id="payDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})"/></td>
        <td><input style="width:90%;"type="text" name="loan3.payMonth" id="payMonth" /></td>
        <td><input type="radio" name="loan3.isoOverdue" id="isoOverdue" value="1" class="pisu" />是&nbsp;&nbsp;
				<input type="radio" name="loan3.isoOverdue" id="isoOverdue" value="2" class="pisu"/>否</td>
        <td style="border-right:1px solid #000;">已透支：
          <input style="width:40%;"type="text" name="" id="" /></td>
      </tr>
    </table>
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td  style="background:#ccc;font-weight:bold; font-size:14px;border-right:1px solid #000;"><span class="bitian">*</span>房产购置情况及申请要求</td>
      </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="100"><span class="bitian">*</span>购置房屋地址：</td>
        <td width="342"><label>
          <input style="width:70%;" type="text" name="ainfo.houseAdress" id="houseAdress" />
        </label></td>
        <td width="98">首付成数：</td>
        <td width="98"><label>
          <input style="width:60%;" type="text" name="ainfo.firstPayPercent" id="firstPayPercent" />
        </label></td>
        <td width="76">房屋总价：</td>
        <td width="69"><label>
          <input style="width:60%;" type="text" name="ainfo.housePrice" id="housePrice" />
        </label></td>
        <td width="78">房屋面积：</td>
        <td width="85"><label>
          <input style="width:60%;" type="text" name="ainfo.houseArea" id="houseArea" />
        </label></td>
        <td width="71" >房屋单价：</td>
        <td width="83" style="border-right:1px solid #000;"><label>
          <input style="width:60%;"type="text" name="ainfo.metersPrice" id="metersPrice" />
        </label></td>
      </tr>
      <tr style="border-bottom: 1px solid #000;border-right: 1px solid #000;">
        <td width="163">所购房产是否为首套房：</td>
        <td width="154" style="border-right:1px solid #000;"><label></label>
          <span style="border-right:1px solid #000;">
          <input type="radio" name="ainfo.isFirstHouse" id="isFirstHouse" value="1" class="pisu"/>
是
<input type="radio" name="ainfo.isFirstHouse" id="isFirstHouse" value="2" class="pisu"/>
否 </span>
          <label></label></td>
          <td colspan="4">
          	<select name="ainfo.rooms" id="rooms">
					<option >1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
				</select>房
				<select name="ainfo.hall" id="hall">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
				</select>厅
				<select  name="ainfo.toilet" id="toilet">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>>6</option>
					<option>7</option>
					<option>8</option>
					<option>>9</option>
					<option>10</option>
				</select>卫
				<select  name="ainfo.balcony" id="balcony">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
				</select>阳台
          </td>
          <td>朝向:</td>
          <td><input type="text" name="ainfo.aspect" id="aspect" /></td>
          <td>房号:</td>
          <td><input type="text" name="ainfo.roomNumber" id="roomNumber" /></td>
          <td></td>
        </tr>	
    </table>

  </tr>
</table>
<p class="anjiu">
<input id="tbClear" onclick="addLoan();" type="button"  value="保存" class="anniu"/>
<input type="button" value="关闭" style="float: left;" onclick="javascript:window.close();" class="anniu1"/>

    </p>
</form>
</c:when>




<c:otherwise>
		<form action="${path}/loanApp/updateLoanApp" method="post"  id="loanForms" enctype="multipart/form-data">
		<input type="hidden" value="${modId}" name="modId" id="modId"/>
		<table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td style="font-size:28px; font-weight:bold; text-align:center;border-right:1px solid #000;" valign="top">贷款申请表</td>
      </tr>
    </table>
    
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td  style="background:#ccc;font-weight:bold; font-size:14px;border-right:1px solid #000;border-top:none;">贷款信息: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          </td>
      </tr>
    </table>    
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    
    <tr style="border-bottom: 1px solid #000;border-right: 1px solid #000;">
        <td width="121"><span class="bitian">*</span>开发商：
        </td><td>
          <select id="companyInfo" name="companyInfo">
   		 	<option value="0">请选择</option>
							<c:forEach var="companyList" items="${companyList }">
							<c:if test="${companyList.companyID ==ainfo.companyID }">
								<option value="${companyList.companyID }" selected>
									${companyList.companyName }
								</option></c:if>
								
								<c:if test="${companyList.companyID !=ainfo.companyID }">
								<option value="${companyList.companyID }" >
									${companyList.companyName }
								</option></c:if>
							</c:forEach>
						</select>
		</td>
        <td width="121"><span class="bitian">*</span>城市:
        </td><td>
          <select id="cityInfo" name="cityInfo"  onchange="CompanyChange(this)">
   		 	<option value="0">请选择</option>
							<c:forEach var="cityList" items="${cityList }">
							<c:if test="${cityList.ID ==ainfo.cityID }">
								<option value="${cityList.ID }" selected>
									${cityList.cityName }
								</option></c:if>
								
								<c:if test="${cityList.ID !=ainfo.cityID }">
								<option value="${cityList.ID }">${cityList.cityName }</option></c:if>
							</c:forEach>
   		 </select></td>
        <td width="121"><span class="bitian">*</span>楼盘:
        </td><td>
          <select id="comlpInfo"  name="comlpInfo">
   		 	<option value="0">请选择</option>
							<c:forEach var="cLpList" items="${cLpList }">
							<c:if test="${cLpList.lpID ==ainfo.lpID  }">
								<option value="${cLpList.lpID }" selected>${cLpList.lpName }</option>
								</c:if>
							</c:forEach>
   		 </select></td>
        <td style="border-right:1px solid #000;" width="258">&nbsp;&nbsp;<span class="bitian">*</span>产品
          <select id="productInfo" name="productInfo">
   		 	<option value="0">请选择</option>
							<c:forEach var="productList" items="${productList }">
							<c:if test="${productList.productID ==ainfo.productID }">
								<option value="${productList.productID }" selected>${productList.productName }</option>
							</c:if>
							
							<c:if test="${productList.productID !=ainfo.productID }">
								<option value="${productList.productID }">${productList.productName }</option>
							</c:if>
							</c:forEach>
   		 </select></td>
      </tr>
      
   		 
      </table>        
    
		<table border="1" align="center" cellspacing="0"  bordercolor="#6699FF" style=" border:0.5px;">	
		<tr>
			<td colspan="12">
			
				<span class="bitian">*</span>申请额度：（人民币大写） <input type="text" name="ainfo.bigAmount" id="bigAmount" value="${ainfo.bigAmount }"/>  万元整，（小写）：￥ 
				<input type="text" name="ainfo.amount" id="amount" value="${ainfo.amount}"  onkeyup="value=value.replace(/[^/0-9]/g,'')"/>万元整
				  <span class="bitian">*</span>申请期限：<input type="text" name="ainfo.loanTime" id="loanTime" value="${ainfo.loanTime }"/> 月       
				  
			</td>
		</tr>
		<tr>
			<td colspan="12">
				<span class="bitian">*</span>贷款年利率<input type="text" name="ainfo.rate" id="rate" value="${ainfo.rate}"/>%  &nbsp;&nbsp;&nbsp;&nbsp;
				<span class="bitian">*</span>手续费率<input type="text" name="ainfo.feeRate" id="ainfo.feeRate" value="${ainfo.feeRate}"/>% 
			</td>
		</tr>
		<tr>
			<td colspan="12" style="background:#ccc;font-weight:bold; font-size:14px;border-right:1px solid #000;border-top:none;">个人资料(编辑)</td>
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
			<td colspan="3"><span class="bitian">*</span>出生日期:<input type="text" name="acust.birthday" id="birthday" value="${acust.birthday}"/></td>
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
						<option value="1" selected>初中及以下</option>
						<option value="2">高中</option>
						<option value="3">大专</option>
						<option value="4">本科</option>
						<option value="5">硕士</option>
						<option value="6">博士</option>
					</c:if>
					<c:if test="${acust.education==2}">
						<option value="1">初中及以下</option>
						<option value="2" selected>高中</option>
						<option value="3">大专</option>
						<option value="4">本科</option>
						<option value="5">硕士</option>
						<option value="6">博士</option>
					</c:if>
					<c:if test="${acust.education==3}">
						<option value="1">初中及以下</option>
						<option value="2">高中</option>
						<option value="3" selected>大专</option>
						<option value="4">本科</option>
						<option value="5">硕士</option>
						<option value="6">博士</option>
					</c:if>
					<c:if test="${acust.education==4}">
						<option value="1">初中及以下</option>
						<option value="2">高中</option>
						<option value="3">大专</option>
						<option value="4" selected>本科</option>
						<option value="5">硕士</option>
						<option value="6">博士</option>
					</c:if>
					<c:if test="${acust.education==5}">
						<option value="1">初中及以下</option>
						<option value="2">高中</option>
						<option value="3">大专</option>
						<option value="4">本科</option>
						<option value="5" selected>硕士</option>
						<option value="6">博士</option>
					</c:if>
					<c:if test="${acust.education==5}">
						<option value="1">初中及以下</option>
						<option value="2">高中</option>
						<option value="3">大专</option>
						<option value="4">本科</option>
						<option value="5">硕士</option>
						<option value="6" selected>博士</option>
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
						<option value="1" selected>是</option>
						<option value="2">否</option>
					</c:if>
					<c:if test="${acust.zxKonw==2}">
						<option value="1">是</option>
						<option value="2" selected>否</option>
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
						<option value="1" selected>是</option>
						<option value="2">否</option>
					</c:if>
					<c:if test="${acust.qsKonw==2}">
						<option value="1">是</option>
						<option value="2" selected>否</option>
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
						<option value="1" selected>是</option>
						<option value="2">否</option>
					</c:if>
					<c:if test="${acust.tsKonw==2}">
						<option value="1">是</option>
						<option value="2" selected>否</option>
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
						<option value="1" selected>是</option>
						<option value="2">否</option>
					</c:if>
					<c:if test="${acust.otherKonw==2}">
						<option value="1">是</option>
						<option value="2" selected>否</option>
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
			<td colspan="12" style="background:#ccc;font-weight:bold; font-size:14px;border-right:1px solid #000;border-top:none;">公司资料</td>
		</tr>
		<tr>
			<td colspan="5"><span class="bitian">*</span>公司名称:<input name="company.cusName" id="cusName" value="${company.cusName}"/></td>
			<td colspan="3"><span class="bitian">*</span>公司成立日期<input name="company.companyCreateDate" id="companyCreateDate" value="${company.companyCreateDate}"/></td>
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
			<input type="radio" value="1"/>是&nbsp;&nbsp;<input type="radio" value="2"/>否</td>
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
			<td colspan="12" style="background:#ccc;font-weight:bold; font-size:14px;border-right:1px solid #000;border-top:none;">房产购置情况及申请要求</td>
		</tr>
		<tr>
			<td colspan="4">购房地址:<input type="text" name="ainfo.houseAdress" id="houseAdress" value="${ainfo.houseAdress}"/></td>
			<td colspan="2">首付成数:<input type="text" name="ainfo.firstPayPercent" id="firstPayPercent" value="${ainfo.firstPayPercent}"/></td>
			<td colspan="2">房屋总价:<input type="text" name="ainfo.housePrice" id="housePrice" value="${ainfo.housePrice}"/></td>
			<td colspan="2">房屋面积:<input type="text" name="ainfo.houseArea" id="houseArea" value="${ainfo.houseArea}"/></td>
			<td colspan="2">房屋单价:<input type="text" name="ainfo.metersPrice" id="metersPrice" value="${ainfo.metersPrice}"/></td>
		</tr>
		<tr>
		<td colspan="2" >  所购房产是否为首套房： 
				    </td>
		<td colspan="10"><c:if test="${ainfo.isFirstHouse==1}">
				   	 	<input type="radio" name="ainfo.isFirstHouse" id="isFirstHouse" value="1" />是&nbsp;
				    	<input type="radio" name="ainfo.isFirstHouse" id="isFirstHouse" value="2" checked="checked"/>否
				    </c:if>
				     <c:if test="${ainfo.isFirstHouse==2}">
				   	 	<input type="radio" name="ainfo.isFirstHouse" id="isFirstHouse" value="1" />是&nbsp;
				    	<input type="radio" name="ainfo.isFirstHouse" id="isFirstHouse" value="2" checked="checked"/>否
				    </c:if></td>
		</tr>
		<tr>
			<td colspan="6">
				<select name="ainfo.rooms" id="rooms">
					<option <c:if test="${ainfo.rooms==1}">selected</c:if>>1</option>
					<option <c:if test="${ainfo.rooms==2}">selected</c:if>>2</option>
					<option <c:if test="${ainfo.rooms==3}">selected</c:if>>3</option>
					<option <c:if test="${ainfo.rooms==4}">selected</c:if>>4</option>
					<option <c:if test="${ainfo.rooms==5}">selected</c:if>>5</option>
					<option <c:if test="${ainfo.rooms==6}">selected</c:if>>6</option>
					<option <c:if test="${ainfo.rooms==7}">selected</c:if>>7</option>
					<option <c:if test="${ainfo.rooms==8}">selected</c:if>>8</option>
					<option <c:if test="${ainfo.rooms==9}">selected</c:if>>9</option>
					<option <c:if test="${ainfo.rooms==10}">selected</c:if>>10</option>
				</select>房
				<select name="ainfo.hall" id="hall">
					<option <c:if test="${ainfo.hall==1}">selected</c:if>>1</option>
					<option <c:if test="${ainfo.hall==2}">selected</c:if>>2</option>
					<option <c:if test="${ainfo.hall==3}">selected</c:if>>3</option>
					<option <c:if test="${ainfo.hall==4}">selected</c:if>>4</option>
					<option <c:if test="${ainfo.hall==5}">selected</c:if>>5</option>
					<option <c:if test="${ainfo.hall==6}">selected</c:if>>6</option>
					<option <c:if test="${ainfo.hall==7}">selected</c:if>>7</option>
					<option <c:if test="${ainfo.hall==8}">selected</c:if>>8</option>
					<option <c:if test="${ainfo.hall==9}">selected</c:if>>9</option>
					<option <c:if test="${ainfo.hall==10}">selected</c:if>>10</option>
				</select>厅
				<select  name="ainfo.toilet" id="toilet">
					<option <c:if test="${ainfo.toilet==1}">selected</c:if>>1</option>
					<option <c:if test="${ainfo.toilet==2}">selected</c:if>>2</option>
					<option <c:if test="${ainfo.toilet==3}">selected</c:if>>3</option>
					<option <c:if test="${ainfo.toilet==4}">selected</c:if>>4</option>
					<option <c:if test="${ainfo.toilet==5}">selected</c:if>>5</option>
					<option <c:if test="${ainfo.toilet==6}">selected</c:if>>6</option>
					<option <c:if test="${ainfo.toilet==7}">selected</c:if>>7</option>
					<option <c:if test="${ainfo.toilet==8}">selected</c:if>>8</option>
					<option <c:if test="${ainfo.toilet==9}">selected</c:if>>9</option>
					<option <c:if test="${ainfo.toilet==10}">selected</c:if>>10</option>
				</select>卫
				<select  name="ainfo.balcony" id="balcony">
					<option <c:if test="${ainfo.balcony==1}">selected</c:if>>1</option>
					<option <c:if test="${ainfo.balcony==2}">selected</c:if>>2</option>
					<option <c:if test="${ainfo.balcony==3}">selected</c:if>>3</option>
					<option <c:if test="${ainfo.balcony==4}">selected</c:if>>4</option>
					<option <c:if test="${ainfo.balcony==5}">selected</c:if>>5</option>
					<option <c:if test="${ainfo.balcony==6}">selected</c:if>>6</option>
					<option <c:if test="${ainfo.balcony==7}">selected</c:if>>7</option>
					<option <c:if test="${ainfo.balcony==8}">selected</c:if>>8</option>
					<option <c:if test="${ainfo.balcony==9}">selected</c:if>>9</option>
					<option <c:if test="${ainfo.balcony==10}">selected</c:if>>10</option>
				</select>阳台
			</td>
			<td colspan="3">
				朝向:<input type="text" name="ainfo.aspect" id="aspect" value="${ainfo.aspect}"/></td>
			</td>
			<td colspan="3">
				房号:<input type="text" name="ainfo.roomNumber" id="roomNumber" value="${ainfo.roomNumber}"/></td>
			</td>
		</tr>
		<tr>
			<td colspan="12">
				<input  type="hidden" name="ainfo.applyID" id="applyID" value="${ainfo.applyID}"/>
				<input  type="hidden" name="ainfo.applyCode" id="applyCode" value="${ainfo.applyCode}"/>
				<input type="hidden" name="acust.id" id="aid" value="${acust.id}"/>
				<input type="hidden" name="company.id" id="cid" value="${company.id}"/>
				<input type="hidden" name="fance.id" id="fid" value="${fance.id}"/>
				<input type="hidden" name="loanid" id="lid" value="${loan.id}"/>
				<input type="hidden" name="loan2id" id="lid2" value="${loan2.id}"/>
				<input type="hidden" name="loan3id" id="lid3" value="${loan3.id}"/>
				 <input  id="tbClear"  type="submit" value="保存" class="anniu"/>				 
				 <input  id="tijiao" onclick="tijiaos();" type="button" value="提交" class="anniu" />
				<input type="button" value="关闭" style="float: left;" onclick="javascript:window.close();" class="anniu1"/>
			</td>
		</tr>
	</table>
	
	<table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td  style="background:#ccc;font-weight:bold; font-size:14px;border-right:1px solid #000">图片上传</td>
      </tr>
    </table>    
    <table width="1100" border="0" cellspacing="0" cellpadding="0">
      <tr>
							<br/>可上传多个附件。<br />
							<br />
							<div id="fileDiv"></div>
							<!-- 请输入中文名称:<input type="text" value="" name="imgInfo.imgChinaName" id="imgChinaName"/><br> -->
							&nbsp&nbsp&nbsp&nbsp<input type="submit" class="" value="上传" /><br>
						<script type="text/javascript">
							$(document).ready(function(){
    								addFile();
	 					});
						</script>
      </tr>
    </table>
    <c:if test="${imglist==null}">
								没有附件
							</c:if>
							<%-- <table>
							<c:forEach items="${imglist}" var="im">
									<tr>
										<td>图片名称：${im.imgChinaName}</td>
										<td><a href="${path}/master/workhuilManager/preview.action?imgIds=${im.imgId}" target="_blank">在线预览</a>     &nbsp&nbsp&nbsp&nbsp&nbsp   
									    <a href="javascript:void(0);" onclick="javascript:downs(${im.imgId});">下载</a>&nbsp&nbsp&nbsp&nbsp&nbsp
									    <a href="javascript:void(0);" onclick="javascript:deletes(${im.imgId});">删除</a></td>
										<td></td>
									</tr>
							</c:forEach></table> --%>
							
							
							
							
							
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