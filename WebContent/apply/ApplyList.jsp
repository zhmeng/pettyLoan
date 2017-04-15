<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="w" uri="http://ley.Page.com/tags/pager"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", path);
	request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="${path}/js/Util.js"></script>
	<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${path}/js/md5.js"></script>
     <link href="${path}/css/public_xe.css" rel="stylesheet" />
    <link href="${path}/css/style.css" rel="stylesheet" />
        <link href="${path}/css/style-theme-lx.css" rel="stylesheet" type="text/css" />
        <link href="${path}/css/home.css" type="text/css" rel="Stylesheet" />
        <link href="${path}/css/Css.css" type="text/css" rel="Stylesheet" />
                
<title>贷款申请列表</title>

<script>
	function AddNewApply()
	{
		//window.open("AddApply.jsp");
		
		var path=$("#path").val();
		alert(path);
		window.open(path+"/loanApp/toAddLoanApp", "newwindow", "height=800, width=1100, top=1000, left=500, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=n o, status=no") ;
	}
</script>
</head>
<body id="body">	
<input type="hidden" id="path" value="${path}"/>
<form id="searchForm" action="${path}/sysUser/showUser"  method="post"> 
<div id="hbNav">
        <div id="navLeft">
            贷款管理&raquo;贷款申请</div>
        <div id="navRight">
            <span class="hbmenu"><a href="javascript:refreshform();"><img src="${path}/images/flush.gif"
                border="0" />刷新</a></span> <span id="spanaddnew" 
                    class="hbmenu">
                    
                      
                    <a id="AButton_2" href="javascript:AddNewApply();">
                        <img src="${path}/images/add.gif" border="0"  />新增贷款</a>
            </span>
        </div>
    </div>
    
        <div id="divContent">
                <div id="search">                
        <table cellspacing="0" cellpadding="0" border="0" width="100%" style="text-align: right;">
            <tbody>
              <tr >
              <td><strong>申请号：</strong>   
              <input type="text"  class="inp-text inp-w140" />                 
                </td>
                <td><strong>借款人：</strong>
                    <input type="text"  class="inp-text inp-w140" /> 
                   </td>
               <td><strong>证件号码：</strong>
                   <input type="text"  class="inp-text inp-w140" /> 
                    </td>
              <td><strong>信贷顾问：</strong>
                                    <input type="text"  class="inp-text inp-w140" />  
                  </td>
                <td><strong>申请日期：</strong>从    <input type="text"  class="inp-text inp-w140" /> 
                至    <input type="text"  class="inp-text inp-w140" /> 
                    </td>
                 </tr>
                 <tr>
                 <td><strong>贷款状态：</strong>
                 <select class="inp-text inp-w140" >
                 	<option value="1" class="inp-text inp-w140" >贷款申请</option>
                 	<option value="2" class="inp-text inp-w140">贷款审批</option>
                 </select>
                     
                </td>
                 <td>
                </td>
                <td>
                </td>
                 <td><input id="btSearch" onclick="searchform();" type="button" value=" 查 询 " class="sele btn"/>
                    <input id="tbClear" onclick="ResetControl();" type="button" value=" 重 置 " class="sele btn"/>
                </td>
                <td>
                
                </td>
                
                </tr>

            </tbody>
          </table>
        </div>
    </div>
    </form>
    <div align="center">
	<form id="searchForm" action="${path}/master/workhuilOaManager/lookOwerOa.action"  method="post">    
	<table width="100%" class="TableList">
		<tr height="10px;" style="font-family:'Microsoft YaHei',Arial,Helvetica,sans-serif,'宋体'">
			<td></td>
		</tr>   
	</table>
  </form>
	<table class="TableList" width="100%" style="font-family:'Microsoft YaHei',Arial,Helvetica,sans-serif,'宋体'">
			<tr class="TableHeader"> 
				<th>用户名</th>
				<th>员工编号</th>
				<th>所在部门</th>
				<th>手机号</th>
				<th>员工住址</th>
				<th>性别</th>
				<th>身份证号</th>
				<th>操作</th>
			</tr> 
		 	<c:choose>
			<c:when test="${empty pm.datas}">
				<tr>
					<td colspan="6"></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="bean" items="${pm.datas}">
					<tr>
						<td>${bean.userName }</td>
						<td>${bean.userNO}</td>
						<td>${bean.userIsDept}</td>
						<td>${bean.userMob }</td>
						<td>${bean.userAddr}</td>
						<td>${bean.userSex}</td>
						<td>${bean.userIDCard }</td>
						<td>
						<a href="javascript:void(0)" onclick="updateUser(${bean.userID})">编辑</a>
						<a href="javascript:void(0)" onclick="delUser(${bean.userID})">删除</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>  
	<w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/sysUser/showUser" recordCount="${pm.recordCount}" />
</div>
</body>
</html>