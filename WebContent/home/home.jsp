<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>资料管理系统</title>
    <%@include file="/comment/comment.jsp"%>
    <script type="text/javascript" src="${path}/js/Util.js"></script>
	<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${path}/js/md5.js"></script>
	<script type="text/javascript" src="${path}/home/home.js"></script>
     <link href="${path}/css/public_xe.css" rel="stylesheet" />
    <link href="${path}/css/style.css" rel="stylesheet" />
    <style>
        .bgColor {
            background-color:#258cfe;
        }
        .aColor:active {
        color:#fff;
        }
    </style>
    <script type="text/javascript" language="javascript">
        $(document).ready(function () {
        	
            $("#menustr>li>ul>li>a").click(function () {            	
                $("#menustr>li>ul>li").removeClass("bgColor");
                $(this).parent("li").addClass("bgColor");
                $(this).addClass("aColor");
            });

            $("#menustr div").click(function () {  
                var $UL=$(this).next("ul");
                $UL.show();
                var $OtherUL = $(this).parent("li").parent("ul").find("ul").not($UL);
               $OtherUL.hide();
            });
        });
        function CheckData() {
          //CheckOnline(); 
//CheckOnlineMsg();
          setTimeout("CheckData()", 1000 * 30);
        }
        var menuIsShow = 0;
        function ShowMeNu()
        {           
        	//alert("ss");
            if (menuIsShow == 0) {
                $("#divMenu").hide();
                $("#imgmiddle").attr("src", "${path}/images/up1.png");
                menuIsShow = 1;
            } else {
                $("#divMenu").show();
                $("#imgmiddle").attr("src", "${path}/images/up.png");
                menuIsShow = 0;
            }
        }
        function Quit(){
        	var msg="确认退出吗";
        	if (confirm(msg)==true){ 
        		location="${path}/sysUser/outUser";
        	}
        }
    </script>
<!--[if lte IE 6]>
<SCRIPT typte="text/javascript">
	$(document).ready(function() {	 
		 $(".sub-menu").bgiframe();
		 $(".sub-menu ul").bgiframe();
	});
	</SCRIPT>
<![endif]-->
</head>
<body>
<input id="basePath" type="hidden" value="${basePath}"/>
    <form id="form1" >
    <!--top star-->
        <div class="top">
  <div class="logo"><%-- <img src="${path}/images/in_logo1.png" alt="" /> --%></div>
  <div class="xx">
    <p class="in-top-p1"> 您好，今天是 <% new Date(); %></p>
    <ul class="in-ctrl">
        <li>
            <a href="${path}/home/main.jsp" target='MainFrame'><img style="width:25px;margin:0px auto;display:block" src="${path}/images/sy.png" alt="桌面" /></a>
        <p><a href='${path}/home/main.jsp' target='MainFrame'>桌面</a></p>
      </li>
        <li><a href='javascript:' onClick='window.parent.MainFrame.location.reload();'><img src="${path}/images/sx.png" alt="刷新" /></a>
        <p><a href='javascript:' onClick='window.parent.MainFrame.location.reload();'>刷新</a></p>
      </li>
      <li> <a href='javascript:history.go(-1);'><img src="${path}/images/fh.png" alt="返回" /></a>
        <p><a href='javascript:history.go(-1);'>返回</a></p>
      </li>
      <li><a href='javascript:history.go(1);'><img src="${path}/images/qj.png" alt="前进" /></a>
        <p><a href='javascript:history.go(1);'>前进</a></p>
      </li>
      <li style="margin-right:0;"><a href="javascript:Quit();"><img src="${path}/images/tc.png" alt="退出系统" /></a>
        <p><a href="javascript:Quit();">退出</a></p>
      </li>
      <div class="clr"></div>
    </ul>
    <div class="clr"></div>
  </div>
  <div class="clr"></div>
</div>
    <!--top end--> 
    <!--main star-->
<div class="main">
  <table width="100%">
    <tr>
      <td class="in-left-td" id="divMenu">
          <div class="in-left">
          <div class="in-user pad10 mar-b10">
              <img width="45px" src="${path}/images/photo1.png" alt="" />
            <p class="in-main-p"><em style="font-size:12px">姓名：${sysUsers.userFullName}</em></p>
            <p class="in-main-pID"><em  style="font-size:12px"><a href="javascript:void(0)" onclick="updateAdmin()">修改密码</a></em></p>
            <p class="in-main-p1"><em  style="font-size:12px"><a href="">设置邮件接收</a></em></p>
        
          <div class="clr"></div>
          </div>
          <div class="nav-list">
           <UL id="menustr">	
           <c:if test="${!empty glist}">
           	<c:forEach items="${glist}" var="gl">
				<LI class=li-bg>
					<DIV class="nav-li li-ico" ><A href="javascript:void(0);">${gl.modName}</A></DIV>
					<UL class="none nav-li-ul">
						<c:if test="${!empty clisy}">
						<c:forEach items="${clisy}" var="cl">
							<c:if test="${cl.partId==gl.modID}">
								<LI>
									<A href="${path}/${cl.modUrl}?modId=${cl.modID}" target="MainFrame" >${cl.modName}</A>
								</LI>
							</c:if>
						</c:forEach>
						</c:if>
					</UL>

				</LI>
			 </c:forEach>
			 </c:if>
			</UL>
          </div>
        </div></td>
      <td class="in-center-td"><div class="in-center"><a href="javascript:void(0);"><img src="${path}/images/up.png"  onclick="ShowMeNu()" id="imgmiddle" /></a></div></td>
      <td class="in-right-td" style="height: 100%; border: 1px solid #99CCFF; height:700px">
          <iframe src="${path}/home/main.jsp" frameborder="0"  width="100%" height="100%"  name="MainFrame" id="MainFrame"></iframe>
      </td>
    </tr>
  </table>
</div>
<!--mian end-->
<div class="footer">
  <p class="copyright">Copyright © 2012-2014<strong>　<a href="#"></a> </strong><!-- 版权所有 在线  --><strong><a href="#"><span id='cnOnline'></span></a> </strong>人</p>
  <p class="copy-logo"><%-- <img src="${path}/images/tr_logo.png" alt="" /> --%> </p>
  <p class="clr"></p>
</div>
    <input id="hidCommand"  type="hidden" />
    <input id="hidName"  type="hidden" />
    <input id="hidIsAutoRecMsg"  type="hidden" />
    <script language="javascript" type="text/javascript">CheckData();</script>
    </form>
</body>
</html>