<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="w" uri="http://ley.Page.com/tags/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", path);
	request.setAttribute("basePath", basePath);
%> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>小额贷系统</title>
<link href="${basePath}/syscss/basic_layout.css" rel="stylesheet" type="text/css"/>
<link href="${basePath}/syscss/common_style.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="${path}/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${path}/js/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/apply/applyInfo.js"></script>
<style>
.alt td {
	background: black !important;
}

#box_bottom {
	height: 40px;
	line-height: 40px;
	text-align: right;
}

.ui_frt {
	float: right;
}

tr:hover {
	background: #f6f6f6;
}

.ui_tb_h30 {
	margin-top: 20px;
}
</style>
</head>
<body id="body">
<script>


/* $(function(){
	var flag;
	alert("qqqqqqqqq");
	flag=false;
	if(flag==false){
		lod();//方式一
		return flag; 
	}
	// window.location.reload();//方式二:强制刷新当前页面
});
 */





function newApplyInfo(path) {
	 var modId=$("#modId").val();
	 window.open(path + "/loanApp/toAddLoanApp?modId="+modId,"newwindow",
		"height=800, width=1100, top=1000, left=500, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no,fullscreen=yes");
	 lod();
}

function showApplyInfo(applyID) {
	var modId=$("#modId").val();
	window.open( "${path}/loanApp/toShowLoanApp?applyID="+applyID+"&pd=1&modId="+modId,"newwindow",
		"height=800, width=1100, top=1000, left=500, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no,fullscreen=yes");
}

function toUpdateApplyInfo(applyID){
	var modId=$("#modId").val();
	window.open( "${path}/loanApp/toShowLoanApp?applyID="+applyID+"&pd=2&modId="+modId,"newwindow",
	"height=800, width=1100, top=1000, left=500, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no,fullscreen=yes");
	 lod();
}

function lod() {

	 var modId=$("#modId").val();
	var data = {modId:modId};


	$.post( "${path}/action/applyInfo/goApplyInfoList", data, function(data) {
		$("#userinfoContainer").html(data);
		}, 'html');
}
</script>
<div id="userinfoContainer" class="container">
<input id="basePath" type="hidden" value="${basePath}"/>
<form id="searchForm" action="${path}/action/applyInfo/goApplyInfoList" method="post">

<div class="place"><ul class="placeul"></ul></div>
<input type="hidden" value="${modId}" name="modId" id="modId"/>
<div id="container">
	<div class="ui_content">
		<div class="ui_text_indent">
			<div id="box_border">
				<div class="box_bottom">
					<label class="input_label">申请号：</label>
					<input id="applyCode" name="applyInfo.applyCode" value="${applyInfo.applyCode}" type="text" class="input_text" />
					<label class="input_label">客户经理：</label>
					<input id="uName" name="applyInfo.uName" value="${applyInfo.uName}" type="text" class="input_text" />
					<input type="submit" id="searchBtn" value="查&nbsp;&nbsp;询" class="ui_input_btn01"/>
					<!-- <input type="button" id="modify_btn" onclick="toAddApplyInfo()" value="添&nbsp;&nbsp;加" class="ui_input_btn01"/> -->
					<c:forEach items="${blist}" var="bl">
						<c:if test="${bl.CValue==2}">
							<input type="button" id="modify_btn" onclick="newApplyInfo('${path}')" value="新增贷款" class="ui_input_btn01"/>
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
					<th>申请编号</th>
					<th>申请额度</th>
					<th>贷款期限</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:choose>
				<c:when test="${empty pm.datas}">
					<tr><td colspan="5"></td></tr>
				</c:when>
					<c:otherwise>
						<c:forEach var="bean" items="${pm.datas}">
							<tr>
								<td>${bean.applyCode}</td>
								<td>${bean.amount}</td>
								<td>${bean.loanTime}</td>
								<td>
									<c:forEach items="${comList}" var="com">
										<c:if test="${bean.status==com.baseDefault}">
											${com.baseName}
										</c:if>
									</c:forEach>
								</td>
								<td>
									<c:forEach items="${blist}" var="bl">
									
										<c:if test="${bl.CValue==8}">
											<c:if test="${bean.status==1}">
												<a href="javascript:void(0)" onclick="toUpdateApplyInfo('${bean.applyID}')">编辑</a>
											</c:if>
										</c:if>
										
											<!--<a href="javascript:void(0)" onclick="delApplyInfo('${bean.applyID}')">删除</a>  -->
									</c:forEach>
									<a href="javascript:void(0)" onclick="showApplyInfo('${bean.applyID}')">查看</a>
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
<w:pager pageSize="${pm.pageSize}" pageNo="${pm.pageNo}" url="${path}/action/apply/goApplyInfoList" recordCount="${pm.recordCount}" />
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</div>
</body>
</html>