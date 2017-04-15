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
<script type="text/javascript" src="${path}/js/jquery.form.js"></script>
<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	/* function isEmpty(){
		var list =${userNo};
		var userNO=$("#userNO").val();
		alert(userNO);
	} */
	function Save() {
		/*alert("sss");
		var UserName = $('#userName').val();
		var UserPWD =$('#userPWD').val(); //定位id
		var UserNO = $('#userNO').val();
		var UserFullName = $('#userFullName').val();
		var UserState = $('#userState').val();
		var UserMob = $('#userMob').val();
		var UserAddr = $('#useraddr').val();
		
		var UserQQ = $('#userQQ').val();
		//var UserPost = $('#UserPost').val();
		
		var UserMail = $('#userMail').val();
		var UserTel = $('#userTel').val();
		//var UserHomeTel = $('#userHomeTel').val();
		//var UserMSN = $('#UserMSN').val();
		//var UserDesc = $('#UserDesc').val();
		${path}
		/* var UserAODate = $('#UserAODate').val(); */
		//var UserSex = $('#UserSex').val();
		//var UserIDCard = $('#UserIDCard').val();
		/* var UserAddTime = $('#UserAddTime').val(); */
		
		/*if(UserName == ""|| UserName==null){
			alert("请填写用户名");
			return;
		}
		if(UserPWD == ""|| UserPWD==null){
			alert("请填写密码");
			return;
		}
		if(UserNO == ""|| UserNO==null){
			alert("请填写员工编号");
			return;
		}
		if ($("#UserState").find("option:selected").attr("value")=="0") {
			alert("请选择员工状态");
			return;
		}
		if(UserMob == ""|| UserMob==null){
			alert("请填写手机号");
			return;
		}
		if(UserAddr == ""|| UserAddr==null){
			alert("请填写员工住址");
			return;
		}
		if(UserIDCard == ""|| UserIDCard==null){
			alert("请填写身份证号");
			return;
		}
		if ($("#UserSex").find("UserSex").attr("value")=="0") {
			alert("请选择性别");
			return;
		}*/
		//$("#actionForm").submit();		
		var options = {
				type : 'post',
				dataType : 'json',
				traditional : false,
				clearForm : false,
				delegation : true,
				url : '${path}/sysUser/addUser',
				success : function(data) {
					if(data.msg=="1"){
						alert('增加成功');
					}else{
						alert('该用户名已经存在');
					}
				},
				error : function(XmlHttpRequest, textStatus, errorThrown) {
					alert("请求数据出现错误");
				}
			};
			$('#actionForm').ajaxSubmit(options);
			return false;
	}


	function dialogclose() {
		W.$.post("dept/goUser", function(data) {
			dictIndex(data);
		}, 'html');
		api.close();
	};

	function dictIndex(data) {
		var result = pageSystemVerify(data);
		if (result) {
			W.$("#tb_user_div").html(data);
		}
	};
</script>

<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
					<div class="infotitle">
						<h3>添加员工</h3>
					</div>
					<div class="infocontent">
					
					<form id=actionForm action="${path}/sysUser/addUser" method="post">
					 <table id="table1" style="width: 100%;" cellpadding="0" cellspacing="0"  class="tableList">
					 
                    <tr>
                        <td style="font-size: 14pt; font-weight: bold; background:url(../images/tit_bg.png) repeat-x; color:#ffffff" colspan="4">
                           		 用户信息
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right" >
                       		     用户编号：
                        </td>
                        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
                            <input id="txtUserID"  type="text" class="textBoxOnlyRead" readonly="readonly"
                                style="width: 150px;" value="自动生成" />
                        </td>
                        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right" >
                            	员工编号：
                        </td>
                        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
                            <input type="text" id="userNO" name="sysUser.userNO" onclick="isEmpty()"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right" >
                         		   登录帐号：
                        </td>
                        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
                             <input type="text" id="userName" name="sysUser.userName"/>
                        </td>
                         <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right">
                            	登录密码：
                         </td>
                        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
                             <input ID="userPWD"  name="sysUser.userPWD" class="textBox" maxlength="50" style="width: 150px;" type="password" value="123456"/>
                        </td>                    
                     </tr>                    
                    <tr>
                         <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                              <span style="color:red">*</span>姓名：
                         </td>
                          <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                                <input type="text" id="userFullName" name="sysUser.userFullName"/>           
                          </td>
                          <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                                                                                                      性别：
                           </td>
                           <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                           		<select id="userSex" name="sysUser.userSex">
                           			<option value="男">男</option>
                           			<option value="女">女</option>
                           		</select>
                           </td>
                    <tr>
                        <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                            	身份证号：
                        </td>
                        <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                            <input type="text" id="userIDCard" name="sysUser.userIDCard"/>   
                        </td>
                        <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                           		 所属部门： 
                        </td>
                        <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                            <select id="userIsDept" name="sysUser.userIsDept">
                            	<c:forEach items="${dlist}" var="dl">
                            		<option value="${dl.deptID}">${dl.deptName}</option>
                            	</c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                            		权限标志：
                        </td>
                        <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                        	  <select id="userRights" name="sysUser.userRights">
                        			<option value="1">本人</option>
                        			<option value="2">角色</option>
                        			<option value="3">本人和角色</option>
                        	  </select>
                        </td> 
                        <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                           		 所属角色： 
                        </td>
                        <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                            <select id="userisRole" name="sysUser.userisRole">
                            	<c:forEach items="${rlist}" var="rl">
                            		<option value="${rl.roleId}">${rl.roleName}</option>
                            	</c:forEach>
                            </select>
                        </td>
                      </tr>
                      <tr>
                            <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                     	在职状态：
                             </td>
                             <td class="style2" colspan="3" style="padding-top: 2px; padding-left: 2px;">
                             	<select id="userWork" name="sysUser.userWork">
                        			<option value="1">在职</option>
                        			<option value="2">兼职</option>
                        			<option value="3">离职</option>
                        			<option value="4">非公司员工</option>
                        	 	</select>
                             </td>
                           </tr>  
                          
                           <tr>
                                 <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                             	   所任职位： 
                                 </td>
                                 <td class="style2" colspan="3" style="padding-top: 2px; padding-left: 2px;">
                                        <select id="userIsPost" name="sysUser.userIsPost">
                                        	<c:forEach items="${plist}" var="pl">
                            					<option value="${pl.postID}">${pl.postName}</option>
                            				</c:forEach>
                            			</select>         
                                 </td>
                             </tr>
                           
                             
                            <tr>
                                    <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                                <span style="color:red">*</span>入职日期：</td>
                                     <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                                            <input type="text" id="userAODate" name="sysUser.userAODate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})"/>
                                     </td>
                                     <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                                	离职日期：
                                     </td>
                                     <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                                              <input type="text" id="userLODate" name="sysUser.userLODate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer'})"/>   
                                    </td>
                             </tr>
                             <tr>
                                    <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                              	联系手机：
                                    </td>
                                     <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                                          <input type="text" id="userMob" name="sysUser.userMob"/> 
                                    </td>
                                    <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                                	家庭电话：
                                    </td>
                                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                                              <input type="text" id="userTel" name="sysUser.userTel"/>   
                                    </td>
                             </tr>
                             <tr>
                                    <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                                	办公电话：
                                    </td>
                                   <td class="style2" style="padding-top: 2px; padding-left: 2px;">
										<input type="text" id="userTel" name="sysUser.userTel"/> 
                                    </td>
                                    <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                                                                                                               邮件地址：</td>
                                    <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                                   		<input type="text" id="userMail" name="sysUser.userMail"/> 
                                    </td>
                              </tr>
                              <tr>
                                     <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                              		  员工住址：</td>
                                     <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                                            <input type="text" id="userAddr" name="sysUser.userAddr"/> 
                                     </td>
                                      <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                      	邮编：</td>
                                      <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                                            <input type="text" id="userPost" name="sysUser.userPost"/>  
                                      </td>
                              </tr>
                              <tr>
                                      <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                      QQ：</td>
                                      <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                                            <input type="text" id="userQQ" name="sysUser.userQQ"/>      
                                      </td>
                                      <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                         MSN：</td>
                                       <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                                             <input type="text" id="userMSN" name="sysUser.userMSN"/>   
                                       </td>
                                </tr>
                                <tr>
                                       <td align="right" class="style1" style="font-weight: bold; border-right: #ccc 1px solid;">
                                              	  用户备注： 
                                       </td>
                                       <td class="style1"  style="padding-top: 2px; padding-left: 2px;">
                                                <input type="text" id="userDesc" name="sysUser.userDesc"/>
                                       </td>
                                       <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                                	兼职部门：<br /> 按Ctrl多选
                                       </td>
                                       <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                                               
                                       </td>
                                 </tr>    
                                 <tr>
                                        <td align="right" style="font-weight: bold; border-right: #ccc 1px solid;">
                                              		  用户状态： 
                                        </td>
                                        <td class="style2" colspan="3" style="padding-top: 2px; padding-left: 2px;">
                                               <select id="userState" name="sysUser.userState">
                                               		<option value="1">可登录系统</option>
                                               		<option value="0">不可登录系统</option>
                                               		<option value="3">删除状态</option>
                                               </select>
                                        </td>
                                 </tr>
                                
                </table>
				</form>
               
                 <table id="table2" style="width: 100%;" cellpadding="0" cellspacing="0" class="tableList">
            		<tr>
                		<td style="padding-top: 2px; padding-left: 2px; text-align: center;"colspan="2">
                			<input type="button" value=" 保存 " onclick="Save()" class="btn btn-2" />
                 		</td>
            		</tr>
        		</table>
				</div>				
			</div>
		</div>
	</div>
</div>
