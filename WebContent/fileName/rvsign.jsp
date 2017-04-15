<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/comment/comment.jsp"%>
<link rel="stylesheet" href="${path}/css/default.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/Css.css" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/fileName/fileName.js"></script>
<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
				<input id="basePath" type="hidden" value="${basePath}"/>
				<div class="infotitle">
					<h3>标志</font></h3>
				</div>
				
				<div class="infocontent">
					<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
						<tr class="TableHeader"> 
							<td style="padding-top: 2px; padding-left: 2px;" class="style2">
								标记时间(不填默认当天):<input type="text" id="times" value="${fileNames.fbak1}" name="fileNames.fbak1" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
							</td>
							<td style="padding-top: 2px; padding-left: 2px;" class="style2">
								<input type="button" value="标记" onclick="sign('${fid}')"/>
							</td>
						</tr>
					</table>
					<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
						<tr class="TableHeader"> 
							<th>标记时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${excelList}" var="bean"> 
	                    <tr>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	${bean.downTime}
		                    </td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<c:if test="${bean.status==1}">
		                    		标记
		                    	</c:if>
		                    	<c:if test="${bean.status==2}">
		                    		信息正确
		                    	</c:if>
		                    	<c:if test="${bean.status==3}">
		                    		画册退回
		                    	</c:if>
		                    	<c:if test="${bean.status==4}">
		                    		待确认
		                    	</c:if>
		                    	<c:if test="${bean.status==5}">
		                    		不是负责人
		                    	</c:if>
		                    	<c:if test="${bean.status==6}">
		                    		已离职/退休/调离
		                    	</c:if>
		                    	<c:if test="${bean.status==7}">
		                    		撤销
		                    	</c:if>
		                    	<c:if test="${bean.status==8}">
		                    		跟进标记
		                    	</c:if>
		                    	<c:if test="${bean.status==9}">
		                    		未寄画册/默认正确
		                    	</c:if>
		                    </td>
		                     <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                     	状态:<select id="states" name="states">
		                     		<option value="2">信息正确</option>
		                     		<option value="3">画册退回</option>
		                     		<option value="4">待确认</option>
		                     		<option value="5">不是负责人</option>
		                     		<option value="6">已离职/退休/调离</option>
		                     		<option value="7">撤销</option>
		                     		<option value="9">未寄画册/默认正确</option>
		                     	</select>
		                     	<input type="button" value="状态操作" onclick="rvsignFiles('${bean.id}')"/>
		                    	<%-- <a href="javascript:void(0)"  onclick="rvsignFiles('${bean.id}')">状态操作</a> --%>
		                    </td>
						</tr>
						</c:forEach>
					</table>
				</div>				
			</div>
		</div>&nbsp;
		<div class="box_btn" align="center">
			<!-- <input type="button" value="保&nbsp;&nbsp;存" onclick="addFiles()"/>  -->
			<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
		</div>
	</div>
</div>