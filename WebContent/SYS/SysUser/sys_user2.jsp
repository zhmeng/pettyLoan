<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="w" uri="http://ley.Page.com/tags/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path",path);
request.setAttribute("basePath",basePath);
%> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>小额贷系统</title>
<link href="${path}/syscss/basic_layout.css" rel="stylesheet" type="text/css"/>
<link href="${path}/syscss/common_style.css" rel="stylesheet" type="text/css"/>
<%-- <link rel="stylesheet" href="${path}/css/default.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css" /> --%>
<link rel="stylesheet" type="text/css" href="${path}/css/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="${path}/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${path}/js/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/SYS/SysUser/sys_user.js"></script>
<style>
	.alt td{ background:black !important;}
	#box_bottom {
	height: 40px;
	line-height: 40px;
	text-align: right;
}
.ui_frt {
float: right; 
}
tr:hover{background:#f6f6f6;}
.ui_tb_h30{ margin-top:20px;}
</style>
<script type="text/javascript">

	
</script>
</head>
<body id="body">
<div id="userinfoContainer" class="container" >
<input id="basePath" type="hidden" value="${basePath}"/>
<form id="searchForm" action="${path}/sysUser/showUser"  method="post">  
	 <input type="hidden" value="${modId}" name="modId" id="modId"/> 
    <div class="place">
    <ul class="placeul">
    </ul>
    </div>
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
							<div class="box_bottom">
								<label class="input_label">员工编号：</label><input id="userNO" name="users.userNO" type="text" class="input_text" value="${users.userNO}"/>
								<label class="input_label">登录名:</label> <input id="userName" name="users.userName" type="text" class="input_text" value="${users.userName}"/>
								
								<label class="input_label">手机号:</label><input id="userMob" name="users.userMob" type="text" class="input_text" value="${users.userMob}"/>
								
								<input type="submit" id="searchBtn" value="查&nbsp;&nbsp;询" class="ui_input_btn01"/>
								<c:forEach var="op" items="${blist}">
									<c:if test="${op.CValue==2}">
										 <input type="button" id="modify_btn" onclick="toaddbuscontract()" value="添&nbsp;&nbsp;加" class="ui_input_btn01"/> 
									</c:if>
								</c:forEach>
							</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr class="TableHeader"> 
							<th>登录名</th>
							<th>真实姓名</th>
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
								<td>${bean.userName }&nbsp;</td>
						<td>${bean.userFullName}&nbsp;</td>
						<td>${bean.userIsDept}&nbsp;</td>
						<td>${bean.userMob }&nbsp;</td>
						<td>${bean.userAddr}&nbsp;</td>
						<td>${bean.userSex}&nbsp;</td>
						<td>${bean.userIDCard }&nbsp;</td>
						<td>
	       		  			<c:forEach var="op" items="${blist}">
					  			<c:if test="${op.CValue==8}">
									<%-- <a href="javascript:void(0)" class="edit" onclick="updateUser(${bean.userID})">编辑</a> --%>
								 </c:if>
								 <c:if test="${op.CValue==4}">
									<a href="javascript:void(0)" onclick="delUser(${bean.userID})">删除</a>
								</c:if>
							</c:forEach>
							<a href="javascript:void(0)" onclick="chush(${bean.userID})">初始化密码</a>
						</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
					</table>
			  </div>
			</div>
		</div>
	</form>
	<w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/sysUser/showUser" recordCount="${pm.recordCount}" />
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</div>
</body>
</html>