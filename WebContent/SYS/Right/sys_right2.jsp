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
<script type="text/javascript" src="${path}/SYS/Right/sys_right.js"></script>
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
 $(function(){
    if($("#rights").val()==1){
    	$("#roleRight").hide();
    	$("#userRight").show();
    }if($("#rights").val()==2){
    	$("#roleRight").show();
    	$("#userRight").hide();
    }
}) 
</script>
</head>
<body id="body">
<div id="userinfoContainer" class="container" >
<input id="basePath" type="hidden" value="${basePath}"/>
<input id="rights" type="hidden"  value="<%=request.getParameter("rights") %>"/>
<form id="searchForm" action=""  method="post">
    <div class="place">
    <ul class="placeul">
    </ul>
    </div>
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
							<div class="box_bottom">
								
								<input type="button" id="modify_btn" onclick="toRight('1')" value="个人&nbsp;&nbsp;权限" class="ui_input_btn01"/>
								<input type="button" id="modify_btn" onclick="toRight('2')" value="角色&nbsp;&nbsp;权限" class="ui_input_btn01"/>
							</div>
					</div>
				</div>
			</div>
			<!-- <div class="ui_content"> -->
			<div id="roleRight">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr class="TableHeader"> 
							<th>角色编号</th>
							<th>角色名称</th>
							<th>操作</th>
						</tr>
						<c:choose>
			<c:when test="${empty spm.datas}">
				<tr>
					<td colspan="6"></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="bean" items="${spm.datas}">
					<tr>
						<td>${bean.roleId }</td>
						<td>${bean.roleName}</td>
						<td><a href="javascript:void(0)" onclick="roleRight(${bean.roleId})">权限设置</a></td>
					</tr>
				</c:forEach>
					</c:otherwise>
				</c:choose>
					</table>
			  </div>
			</div>
			<!-- </div> -->
			
			<div id="userRight">
	<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr class="TableHeader"> 
			<th>用户名</th>
			<th>员工编号</th>
			<th>操作</th>
		</tr>
		
		<c:choose>
			<c:when test="${empty pms.datas}">
				<tr>
					<td colspan="6"></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="bean" items="${pms.datas}">
					<tr>
						<td>${bean.userName }</td>
						<td>${bean.userNO}</td>
						<td><a href="javascript:void(0)" onclick="userRight(${bean.userID})">权限设置</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>  
	</div>
			
			
		</div>
	</form>
	<%-- <w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/action/role/goRoleList" recordCount="${pm.recordCount}" /> --%>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</div>
</body>
</html>