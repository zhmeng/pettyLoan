<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>资料管理系统</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", path);
	request.setAttribute("basePath", basePath);
%>
<link href="${path}/css/styles.css" rel="stylesheet" type="text/css" />

<script language="JavaScript" src="${path}/js/jquery.js"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  

	 function CheckInfo() {
		 if(navigator.appName == "Microsoft Internet Explorer") {
			 if(navigator.appVersion.match(/8./i)=='4.') 
			 { 
		 		//是IE7，不跳转 
		 		alert("您浏览器是IE4，请用IE8以上版本浏览器");
		 		return;
			 } 
			 if(navigator.appVersion.match(/8./i)=='5.') 
			 { 
		 		//是IE7，不跳转 
		 		alert("您浏览器是IE5，请用IE8以上版本浏览器");
		 		return;
			 } 
			 if(navigator.appVersion.match(/8./i)=='6.') 
			 { 
		 		//是IE7，不跳转 
		 		alert("您浏览器是IE6，请用IE8以上版本浏览器");
		 		return;
			 } 
			 if(navigator.appVersion.match(/8./i)=='7.') 
			 { 
		 		//是IE7，不跳转 
		 		alert("您浏览器是IE7，请用IE8以上版本浏览器");
		 		return;
			 } 
		 	if(navigator.appVersion.match(/8./i)=='8.') 
			 { 
		 		//是IE7，不跳转 
		 		alert("您浏览器是IE8，请用IE8以上版本浏览器");
		 		return;
			 } 
		 }
		var path=$("#path").val();
		 var datas = {"codes": $("#codes").val()};
		 var s="1";
			$.ajax({
				url:path+"/mast/code/judCode",
				async:false,
				data : datas,
				success:function(result){
					
					if(result != undefined && result != "0"){
						if(result=="2"){
							s="2";
							return;
						}		
					}else{
						alert("发送失败！");
						return 0;
					}
				}
			 });
		if(s=="2"){
			alert("验证码错误");
			var verifyObj = document.getElementById("myimg");
			verifyObj.src="${path}/mast/code/getCode?timestamp="+Math.random();
			return;
		}
	    var username = "";
	    var pwd = "";
	    var code = "";
	    username = $("#userName").val();
	    pwd = $("$userPWD").val();
	   // code = $get("#txt_Code").value.trim();

	    if (username == "") {
	        alert("请输入用户名。");
	        return;
	    }

	    if (pwd == "") {
	        alert("请输入密码。");
	        return;
	    }

	    $("#frmMain").submit();
	      
	}
	 function change(){
		
		 var verifyObj = document.getElementById("myimg");
		 verifyObj.src="${path}/mast/code/getCode?timestamp="+Math.random();
		//document.getElementById("myimg").src = "${pageContext.request.contextPath}"mast/code/getCode.action?method=image&x="+Math.random());
	
	//document.getElementById("myimg").src = "${pageContext.request.contextPath}image.do?method=image&x="+Math.random());
	}
	 function submitForm(event){ 
			var event=window.event?window.event:event; 
			if(event.keyCode==13){ 
				document.getElementById("imageField").click();
			} 
	} 
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
<input type="hidden" id="path" value="${path}"/>


    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>@</span>      
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    <form id="frmMain" action="${path}/sysUser/sysLogin" method="post">
    <ul> 
    <li><input name="sysUser.userName" id="userName" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
    <li><input name="sysUser.userPWD" id="userPWD" type="password" class="loginpwd" value="" onclick="JavaScript:this.value=''"/></li>
    <li><input name="codes" type="text" class="yzm" id="codes" value="验证码" onclick="JavaScript:this.value=''"/><a href="javascript:void(0);" ><img onclick="change()" height="40px" id="myimg" src="${path}/mast/code/getCode" /></a></li>
    <li><input  name="imageField" id="imageField" type="button" class="loginbtn" value="登录"  onclick="CheckInfo()"  /><label><label><a href="#">忘记密码？</a></label></li>
    </ul>
    </form>
    
    </div>
    
    </div>
    
</body>

</html>



