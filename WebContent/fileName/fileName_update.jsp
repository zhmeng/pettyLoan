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
					<h3>查看公司信息</h3>
				</div>
				<div class="infocontent">
					<table id="table1" style="width:100%;" cellpadding="0" cellspacing="0" class="tableList">
	                    <tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">邮编：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="hidden" id="id" value="${fileNames.id}" name="id"/>
		                    	<input type="text" id="zipCode" value="${fileNames.zipCode}" name="zipCode"/>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">地址：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<!-- 省:<select name="prov" id="prov">
		                    		<option value="广东省">广东省</option>
		                    	</select>
		                    	市：<select name="city" id="city">
		                    		<option value="深圳市">深圳市</option>
		                    	</select></br>
		                    	区：<select name="area" id="area" onchange="changeArea()">
		                    		</select>
		                    	街道:<select name="stree" id="stree">
		                    	</select></br>
		                    	其他:<input type="text" id="address" name="address"/> -->
		                    	<%-- <input type="hidden" id="haddress"   name="haddress" value="${fileNames.address}"/>  --%>
		                    	<input type="text" id="address" name="address" value="${fileNames.address}" size="35"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">公司名：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="compnyName" name="compnyName" value="${fileNames.compnyName}" /> <!-- disabled="disabled" -->
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">所在部门：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="department" name="department" value="${fileNames.department}"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">联系人：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="linkmn" name="linkmn" value="${fileNames.linkmn}"/>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">性别：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<select id="sex" name="sex">
		                    		<c:choose>
		                    			<c:when test="${fileNames.sex=='男'}">
		                    				<option value="">--</option>
		                    				<option value="男" selected="selected">男</option>
		                    				<option value="女">女</option>
		                    			</c:when>
		                    			<c:when test="${fileNames.sex=='女'}">
		                    				<option value="">--</option>
		                    				<option value="男" >男</option>
		                    				<option value="女" selected="selected">女</option>
		                    			</c:when>
		                    			<c:otherwise>
		                    				<option value="">--</option>
		                    				<option value="男" >男</option>
		                    				<option value="女">女</option>
		                    			</c:otherwise>
		                    		</c:choose>
		                    	</select> 
		                    	<%-- <input type="text" id="sex" name="sex" value="${fileNames.sex}"/> --%>
		                    	<!--<input type="text" id="sex" name="sex" onkeyup="value=value.replace(/\D/g,'')"/>  -->
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">职务：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="post" name="post" value="${fileNames.post}"/>
		                    </td>
							<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">办公室电话：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="officePhone" name="officePhone" value="${fileNames.officePhone}"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">手机号：</td>
		                    <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="phone" name="phone" value="${fileNames.phone}"/>
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">qq：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="qq" name="qq" value="${fileNames.qq}"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">邮箱：</td>
		                     <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="email" name="email" value="${fileNames.email}"/>
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">家庭电话：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="fimallyPhone" name="fimallyPhone" value="${fileNames.fimallyPhone}"/>
		                    </td>
						</tr>
						
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">生日：</td>
		                     <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<input type="text" id="birthday" name="birthday" value="${fileNames.birthday}")"/>
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">URL地址：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<input type="text" id="url" name="url" value="${fileNames.url}"/>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">上级公司：</td>
		                     <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<%-- <input type="text" id="pid" name="pid" value="${fileNames.pid}"/> --%>
		                    	<input type="text" id="pid" name="pid" value="${listFile.id}" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"/>(公司编码)</br>
		                    	${lastName}
		                    	<%-- <select id=pid name="pid">
		                    		<option value="">--</option>
		                    		<c:forEach items="${listFile}" var="listFile">
		                    			<c:if test="${listFile.id==fileNames.pid}">
		                    				<option value="${listFile.id}" selected="selected">${listFile.compnyName}</option>
		                    			</c:if>
		                    				<option value="${listFile.id}" >${listFile.compnyName}</option>
		                    		</c:forEach>
		                    	</select> --%>
		                    </td>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">公司类型：</td>
		                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
		                    	<%-- <input type="text" id="compClass" name="compClass" value="${fileNames.compClass}"/> --%>
		                    	<select id="compClass" name="compClass">
		                    		<option value="">--</option>
		                    		<c:forEach items="${deptList}" var="deptList">
		                    			<c:if test="${deptList.deptID==fileNames.compClass}">
		                    				<option value="${deptList.deptID}" selected="selected">${deptList.deptName}</option>
		                    			</c:if>
		                    			<option value="${deptList.deptID}">${deptList.deptName}</option>
		                    		</c:forEach>
		                    	</select>
		                    </td>
						</tr>
						<tr>
		                    <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">备注：</td>
		                     	<td style="padding-top: 2px; padding-left: 2px;" class="style2" colspan="3">
		                     	<textarea rows="6" cols="60" id="remark" name="remark">${fileNames.remark}</textarea>
		                    </td>
		                   <%--  <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">上级公司：</td>
		                     <td style="padding-top: 2px; padding-left: 2px;" class="style2">
		                    	<!-- <input type="text" id="pid" name="pid"/> -->
		                    	<textarea rows="4" cols="5" id="remark" name="remark">${deptList.deptName}</textarea>
		                    </td> --%>
						</tr>
					</table>
				</div>				
			</div>
		</div>&nbsp;
		<div class="box_btn" align="center">
			 <input type="button" value="保&nbsp;&nbsp;存" onclick="updateFiles()"/>  
			<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
		</div>
	</div>
</div>
<script>
	/* var adds=${fileNames.address}; */
	var strees = [["","园岭街道","南园街道","福田街道","沙头街道","梅林街道","华富街道","香蜜湖街道","莲花街道","华强北街道","福保街道"],
              ["","黄贝街道","南湖街道","桂园街道","东门街道","笋岗街道","翠竹街道","东湖街道","莲塘街道","东晓街道","清水河街道"],
              ["","沙头角街道","海山街道","盐田街道","梅沙街道","","","","","",""],
              ["","南头街道","南山街道","西丽街道","沙河街道","蛇口街道","招商街道","粤海街道","桃源街道","",""],
              ["","新安街道","福永街道","新桥街道","石岩街道","西乡街道","福海街道","松岗街道","航城街道","沙井街道","燕罗街道"],
              ["","平湖街道","布吉街道","坂田街道","南湾街道","横岗街道","龙岗街道","龙城街道","坪地街道","",""],
              ["","观湖街道","民治街道","龙华街道","大浪街道","福城街道","观澜街道","","","",""],
              ["","坪山街道","坑梓街道","龙田街道","石井街道","马峦街道","碧岭街道","","","",""],
              ["","光明街道","公明街道","新湖街道","凤凰街道","玉塘街道","马田街道","","","",""],
              ["","葵涌街道","大鹏街道","南澳街道","","","","","","",""]];
	var areas=new Array("福田区","罗湖区","盐田区","南山区","宝安区","龙岗区","龙华区","坪山区","光明新区","大鹏新区");
	/* window.onload = function() {	
	
		var haddress=$("#haddress").val();
		var ad=haddress.substring(6,8);
		var strarea="";
		var strstree="";
		var stradders="";
		var pd=0;
	
		if(ad=="光明" || ad=="大鹏"){
			strarea=haddress.substring(6,10);
			strstree=haddress.substring(10,14);
			for(var si=0;si<10;si++){
				for(var sj=0;sj<=10;sj++){
					if(strstree==strees[si][sj]){
						pd=1;
					}
				}
			}
			if(pd==0){
				strstree="";
				stradders=haddress.substring(10,haddress.leght);
			}else{
				stradders=haddress.substring(14,haddress.leght);
			}
		}else{
			strarea=haddress.substring(6,9);
			strstree=haddress.substring(9,13);
			var pd=0;
			if(strstree=="沙头角街" ||strstree=="华强北街" || strstree=="香蜜湖街" || strstree=="清水河街"){
				strstree=haddress.substring(9,14);
			}
			
			for(var si=0;si<10;si++){
				
				for(var sj=0;sj<=10;sj++){
					if(strstree==strees[si][sj]){
						pd=1;
					}
				}
			}
			if(pd==0){
				strstree="";
				if(strstree=="沙头角街道" ||strstree=="华强北街道"|| strstree=="香蜜湖街道" || strstree=="清水河街道"){
					stradders=haddress.substring(10,haddress.leght);
				}else{
					stradders=haddress.substring(9,haddress.leght);
				}
				
			}else{
				if(strstree=="沙头角街道" ||strstree=="华强北街道"|| strstree=="香蜜湖街道" || strstree=="清水河街道"){
					stradders=haddress.substring(15,haddress.leght);
				}else{
					stradders=haddress.substring(13,haddress.leght);
				}
			}
		}
	
		document.getElementById('address').value = stradders;
		var areaValue=0;
		for(var h=0;h<10;h++){
			if(areas[h]==strarea){
				areaValue=h;
			}
		}
		alert(areaValue);
		var area=document.getElementById("area");
		
		
		for(var i=0;i<10;i++){
			var objOption = document.createElement("OPTION");
			objOption.text=areas[i];
			objOption.value=i;
			area.options.add(objOption); 
		}
		area.options[areaValue].selected = true;  
		var stree=document.getElementById("stree");
		for(var j=0;j<10;j++){
			var objOption = document.createElement("OPTION");
			if(j==0){
				objOption.text="--";
				objOption.value="";
				stree.options.add(objOption); 
			}
			if(strees[areaValue][j]!=""){
				objOption.text=strees[areaValue][j];
				objOption.value=strees[areaValue][j];
				stree.options.add(objOption); 
			}
			
		}
		
		for(var f=0;f<=10;f++){
			if(strstree==strees[areaValue][f]){
				stree.options[f].selected = true; 
			}	
		}
	} */
	
	function changeArea(){
		$("#stree").empty(); 
		var areaValue=$("#area").val();
		var stree=document.getElementById("stree");
		
		for(var j=0;j<10;j++){
			var objOption = document.createElement("OPTION");
			if(j==0){
				objOption.text="--";
				objOption.value="";
				stree.options.add(objOption); 
			}
			if(strees[areaValue][j]!=""){
				objOption.text=strees[areaValue][j];
				objOption.value=strees[areaValue][j];
				stree.options.add(objOption); 
			}
		}
	}
</script>



