<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path",path);
request.setAttribute("basePath",basePath);
%> 
<link rel="stylesheet" href="${path}/css/default.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/Css.css" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/SYS/SysRole/sys_role.js"></script>
<script type="text/javascript">

</script>

<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
			<input id="basePath" type="hidden" value="${basePath}"/>
					<div class="infocontent">
					 <table id="table1" style="width: 100%;" cellpadding="0" cellspacing="0" 
                    class="tableList">
                    <tr>
                        <td style="font-size: 14pt; font-weight: bold; background:url(../images/tit_bg.png) repeat-x; color:blue" colspan="4">
                           		 角色信息
                        </td>
                    </tr>
					<tr>
						<%-- <c:forEach var="list"  items="${sysDept}"> --%>
						<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right" >
                       		  角色名称：
                        </td>
                        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
                            <input type="text" id="RoleName" name="RoleName"/>
                        </td>
                        
                        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right" >
                       		  角色状态：
                        </td>
                        <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                           		<select id="RoleState" name="RoleState">
                           			<option value="0">正常</option>
                           			<option value="3">关闭</option>
                           		</select>
                           </td>
                           
							 <!-- <label>角色名称：</label><input name="RoleName" id="RoleName" /></br>
							 <label>角色状态：</label>
							  <select id="RoleState">
							 	<option value="0">正常</option>
							 	<option value="3">关闭</option>
							 </select> -->
							 
							 <!-- <label>增加时间：</label><input name="RoleAddTime" id="RoleAddTime" /> -->
						  <%-- </c:forEach> --%>
				</tr>	
				</table>			
			</div>
			</div>
		</div>
		<!-- <div class="box_btn">
			<input type="button" class="btn btn_green" value="保&nbsp;&nbsp;存"
				onclick="add_contract()" /> <input type="button" id="reset" onclick="dialogclose()"
				class="btn btn_gray mgl-30" value="取&nbsp;&nbsp;消" />
		</div> -->
		<table id="table2" style="width: 100%;" cellpadding="0" cellspacing="0" class="tableList">
            		<tr>
                		<td style="padding-top: 2px; padding-left: 2px; text-align: center;"colspan="2">
                			<input type="button" value=" 保存 " onclick="add_contract()" class="btn btn-2" />
                 		</td>
            		</tr>
        		</table>
	</div>
</div>
