<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>

<head>
<title>小额贷款业务管理系统</title>
<%@include file="/comment/comment.jsp"%>
<link href=""rel="stylesheet" type="text/css" />


    <link href="${path}/css/public_xe.css" rel="stylesheet" type="text/css"/>
    <link href="${path}/css/log_style.css" rel="stylesheet"type="text/css" />
    <link href="${path}/css/login.css" rel="stylesheet" type="text/css"/> 
    <link href="${path}/css/1.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript">
    function CheckInfo() {
        var username = "";
        var pwd = "";
        var code = "";
        username = $get("userName").value.trim();
        pwd = $get("userPWD").value.trim();
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

    

</script>

</head>
<body>
<noscript>
</noscript>
    <div class="log-wrapper">
  <div class="login">
    <div class="login-con">
<form id="frmMain" action="${path}/sysUser/sysLogin" method="post">

     <p class="log-p">
         <span>用户名：</span> 
         <span>
                <input type="text" name="sysUser.userName" value="" id="userName" class="user" onkeydown="return BindEnter()" />
        </span> 

     </p>
    <p class="log-p"><span>密　码：</span> <span>
        <input id="userPWD"  name="sysUser.userPWD" value="" type="password" class="password" onkeydown="return BindEnter()" />
        </span> </p>
       <p class="log-p"><span class="log-img" >验证码：</span>       
                   <input type="text" class="yzm" id="txt_Code" maxlength="4" onkeydown="if (event.keyCode == 13) {CheckInfo();}" /> 

       <!-- <span class="log-img"><img width="93px" height="32px" id="getcode" alt="看不清楚,请点击更换新的验证码" src="./home/ValidateCode.aspx" onclick="this.src=this.src+'?'" title="看不清楚,请点击更换新的验证码" style="vertical-align:top;cursor:pointer;"/></span> </p>  -->
      
      <p class="login-btn">
        <input id="btn" type="submit"  value=" 登 录 " class="log-in log-btn-pub"  />
      </p>

</form>
        </div>
      </div>
        </div>
</body>
</html>
