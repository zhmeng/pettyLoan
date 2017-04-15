<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/comment/comment.jsp"%>
<link rel="stylesheet" href="${path}/css/default.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/Css.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/combo.select.css" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/fileName/fileName.js"></script>
<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${path}/js/jquery.combo.select.js"></script>
<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
				<input id="basePath" type="hidden" value="${basePath}"/>
				<div class="infotitle">
					<h3>文件导入</h3>
				</div>
				<div class="infocontent">
				<form action="${path}/action/fileNames/upload" enctype="multipart/form-data" method="post">
					<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
						<tr>
		                 
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">选择告诉类型：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<select name="compClasses"  id="compClasses">
		                    		<c:forEach var="deptList" items="${deptList}">
										<option value="${deptList.deptID}">${deptList.deptName}</option>
									</c:forEach>
		                    	</select>
		                    </td>
						</tr>
	                    <tr>
		                 
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">文件地址：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="file" name="uploadFile" id="uploadFile"/>
	        					<input type="submit" value="上传"/>
	       						<input type="reset" value="重置"/>
	       						<input type="hidden" id="pd" nme="pd" value="${pd}"/>
		                    </td>
						</tr>
						
					</table>
					</form>
				</div>				
			</div>
		</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" id="reset" onclick="window.close()" value="关&nbsp;&nbsp;闭"/></br></br>
	</div>
</div>
<script>
	window.onload = function() {	
		var pd= $("#pd").val();
		if(pd=="2"){
			alert("请选择导入文件");
		}else if(pd=="1"){
			alert("文件导入成功");
			window.close();
			load();
		}
	}
</script>




