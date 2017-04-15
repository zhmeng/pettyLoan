<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path",path);
%> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>小额贷系统</title>
<script type="text/javascript" src="${path}/SysDept/sys_Post.js"></script>
<title>机构设置</title>
</head>
<body id="body">
	<div id="userinfoContainer" class="container" >
		<div class="mainbox">
			<div class="box90 bkCenter">
				<div class="infobox">
					<div class="infotitle">
						<h3>.....</h3>
					</div>
					<div class="infocontent">
						<fieldset>
							<legend>选择查询条件</legend>
							<div class="fl mgt-10">
								<label class="input_label">职位名称：</label><input
									id="PostName" name="PostName" type="text" class="input_text" />
								<label class="input_label">所属部门</label><input
									id="PostIsDept" name="PostIsDept" type="text" class="input_text" />
								<br />
								<a id="searchBtn" onclick="search_warn()" class="btn btn_green mgl-48">查&nbsp;&nbsp;询</a>
							</div>
						</fieldset>
						<div class="clearfix mgt-20">
							<div class="fr">
								<a class="btn btn_gray" id="modify_btn" onclick="toaddbuscontract()">添加</a>
							</div>
						</div>
						<div id="tb_post_div">
						
						</div>
					
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>