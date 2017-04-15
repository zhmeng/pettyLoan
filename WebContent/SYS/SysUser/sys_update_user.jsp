<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="page" uri="/WEB-INF/page-tag.tld"%>
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
<script type="text/javascript" src="${path}/SYS/SysUser/sys_user.js"></script>
<script type="text/javascript">
	function save_contract(){
		var UserID=$("#UserID").val();
		var UserName=$("#UserName").val();
		//var UserPWD=$("#UserPWD").val();
		var UserFullName=$("#UserFullName").val();
		var UserisRole=$("#UserisRole").val();
		var UserMob=$("#UserMob").val();
		var UserAddr=$("#UserAddr").val();
		var UserQQ=$("#UserQQ").val();
		var UserSex=$("#UserSex").val();
		var UserIDCard=$("#UserIDCard").val();
		var UserState=$("#UserState").val();
		var UserRights=$("#UserRights").val();
		var UserWork=$("#UserWork").val();
		var param = {};
		param["UserID"] = UserID;
		param["UserName"] = UserName;
		/* param["UserPWD"] = UserPWD; */
		param["UserFullName"] = UserFullName;
		param["UserisRole"] = UserisRole;
		param["UserMob"] = UserMob;
		param["UserAddr"] = UserAddr;
		param["UserQQ"] = UserQQ;
		param["UserSex"] = UserSex;
		param["UserIDCard"] = UserIDCard;
		
		param["UserState"] = UserState;
		param["UserRights"] = UserRights;
		param["UserWork"] = UserWork;
		// 加载渠道管理用户
		
		jQuery.ajax({
			type : "post", // 请求方式
			url : "${path}/sysUser/updateUser", // Ajax访问地址
			data : param, // 参数
			dataType : "json", // 指定返回数据类型
			error : function() { // 出现错误时运行
				alert("保存异常");
			},
			success : function(data) { // 返回成功时运行，主要接受结果
				if(data.success){
					alert(data.msg);
					parent.window.returnValue=data.msg; //父窗口就是上一个页面
					 window.close();
				}else{
					alert('保存异常2');
				}
			}
		});  
		
	}
</script>
<div class="container" id="tb_WarnSelect_div">
<table id="tb_userinfo" border="0" cellpadding="0" cellspacing="0"
	class="tabstyle resizable">
					 <!-- <tr> -->
					<input type="hidden" value="${sysUsers.userID}" id="UserID">
						<label>用户名：</label><input type="text" value="${sysUsers.userName}" id="UserName">
						<%-- <label>登陆密码：</label><input type="text" value="${sysUsers.userPWD}" id="UserPWD"></br>重置 --%>
						<label>用户英文名：</label><input type="text" value="${sysUsers.userFullName}" id="UserFullName">
						<%--<label>所在部门：</label>
							 <input type="text" value="${sysUsers.userIsDept}" id="UserIsDept">
							<select>
								<option value="${sysUsers.userIsDept}"></option>
							</select>
							--%>
							</br> 
						<label>用户角色：</label><input type="text" value="${sysUsers.userisRole}" id="UserisRole">
						<label>手机号：</label><input type="text" value="${sysUsers.userMob}" id="UserMob"></br>
						<label>住址：</label><input type="text" value="${sysUsers.userAddr}" id="UserAddr">
						<label>QQ：</label><input type="text" value="${sysUsers.userQQ}" id="UserQQ"></br>
						<label>性别：</label>
							<select id="UserSex" name="UserSex">
							 	<option value="0">男</option>
							 	<option value="1">女</option>
							 </select></br>
						<label>身份证号：</label><input type="text" value="${sysUsers.userIDCard}" id="UserIDCard">
						<label>用户状态：</label>
						<select id="UserState" name="UserState">
							<option value="1">显示</option>
							<option value="0">隐藏</option>
						</select></br>
						
						<label>用户权限：</label>
						<select id="UserRights" name="UserRights">
							<option value="1">按用户本人权限</option>
							<option value="2">按用户所在角色</option>
							<option value="3">角色用户并集取权限</option>
						</select>


						<label>用户在职状态：</label><!-- 1在职，3兼职，2离职，4非公司员工 -->
						<select id="UserWork" name="UserWork">
							<option value="1">在职</option>
							<option value="2">在职离职</option>
							<option value="3">兼职</option>
							<option value="4">非公司员工</option>
						</select>
					<!-- </tr>  -->
</table>
<div class="box_btn">
			<input type="button" class="btn btn_green" value="保&nbsp;&nbsp;存"
				onclick="save_contract()" /> <input type="button" id="reset" onclick="dialogclose()"
				class="btn btn_gray mgl-30" value="取&nbsp;&nbsp;消" />
		</div>
</div>
