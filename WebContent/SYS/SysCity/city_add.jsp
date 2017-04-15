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
<script type="text/javascript" src="${path}/SYS/SysCity/sys_city.js"></script>
<script type="text/javascript">

	/* function add_contract() {
		
		var DeptName = $('#DeptName').val();
		var DeptMG =$('#DeptMG').val(); //定位id
		//var DeptID = $('#DeptID').val();
		var DeptMGTel = $('#DeptMGTel').val();
		var DeptTel = $('#DeptTel').val();
		var DeptFax = $('#DeptFax').val();
		var DeptAddr = $('#DeptAddr').val();
		var DeptPost = $('#DeptPost').val();
		var DeptBranchID = $('#DeptBranchID').val();
		
		var DeptFlag = $('#DeptFlag').val();
		var DeptIsBR = $('#DeptIsBR').val();
		var DeptIsCR = $('#DeptIsCR').val();
		var DeptIsCS = $('#DeptIsCS').val();
		var DeptDesc = $('#DeptDesc').val();
		
		if(DeptName == ""|| DeptName==null){
			alert("请填写部门名称");
			return;
		}
		if(DeptMG == ""|| DeptMG==null){
			alert("请选择部门负责人");
			return;
		}
		if(DeptMGTel == ""|| DeptMGTel==null){
			alert("请填写部门负责人电话");
			return;
		}
		if(DeptFax == ""|| DeptFax==null){
			alert("请填写部门传真");
			return;
		}
		/* if ($("#DeptID").find("option:selected").attr("value")=="0") {
			alert("请选择部门负责人");
			return;
		} 
		if(DeptPost == ""|| DeptPost==null){
			alert("请填写邮编");
			return;
		}
		/* if ($("#DeptBranchID").find("option:selected").attr("value")=="0") {
			alert("请选择网点");
			return;
		} 
		
		var param = {};
		param["DeptName"] = DeptName;
		param["DeptMG"] = DeptMG;
		//param["DeptID"] = DeptID;
		param["DeptMGTel"] = DeptMGTel;
		param["DeptTel"] = DeptTel;
		param["DeptFax"] = DeptFax;
		param["DeptAddr"] = DeptAddr;
		param["DeptPost"] = DeptPost;
		param["DeptBranchID"] = DeptBranchID;
		param["DeptFlag"] = DeptFlag;
		param["DeptIsBR"] = DeptIsBR;
		param["DeptIsCR"] = DeptIsCR;
		param["DeptIsCS"] = DeptIsCS;
		param["DeptDesc"] = DeptDesc;
		
		// 加载渠道管理用户
		
		jQuery.ajax({
			type : "post", // 请求方式
			url : basePath+"action/dept/AddDept", // Ajax访问地址
			data : param, // 参数
			dataType : "json", // 指定返回数据类型
			error : function() { // 出现错误时运行
				alert("保存异常");
			},
			success : function(data) { // 返回成功时运行，主要接受结果
				if(data.success){
					alert(data.msg);
					dialogclose();
				}else{
					alert('保存异常2');
				}
			}
		}); 
	} 

	/* var api = frameElement.api, W = api.opener;

	function dialogclose() {
		W.$.post("dept/goDept", function(data) {
			dictIndex(data);
		}, 'html');
		api.close();
	};

	function dictIndex(data) {
		var result = pageSystemVerify(data);
		if (result) {
			W.$("#tb_dept_div").html(data);
		}
	}; */
</script>

<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
			<input id="basePath" type="hidden" value="${basePath}"/>
					<div class="infotitle">
						<h3>添加城市</h3>
					</div>
					<div class="infocontent">
						<%-- <c:forEach var="list"  items="${sysDept}"> --%>
						<table id="table1" style="width: 100%;" cellpadding="0" cellspacing="0" 
                  			  class="tableList">
                   	 <tr>
                        <td style="font-size: 14pt; font-weight: bold; background:url(../images/tit_bg.png) repeat-x; color:#ffffff" colspan="4">
                           		城市信息
                        </td>
                    </tr>
                     <tr>
                     
                     <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right" >
                            	选择区域：
                        </td>
                         <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                           		<select id="areaName" name="areaName">
                           			<option value="0">请选择</option>
							 	<c:forEach var="areas" items="${areas }">
										<option	value="${areas.areaID }">${areas.areaName }</option>
								</c:forEach>
                           		</select>
                           </td>
                     
                     <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right" >
                            	城市ID：
                        </td>
                        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
                            <input type="text" id="cityID" name="cityID"/>
                        </td>
						<td style="font-weight: bold; border-right: #ccc 1px solid;" align="right" >
                            	城市名称：
                        </td>
                        <td style="padding-top: 2px; padding-left: 2px;" class="style2">
                            <input type="text" id="cityName" name="cityName"/>
                        </td>
                        <td style="font-weight: bold; border-right: #ccc 1px solid;" align="right" >
                            	城市状态：
                        </td>
                         <td class="style2" style="padding-top: 2px; padding-left: 2px;">
                           		<select id="cityState" name="cityState">
                           			<option value="0">启用</option>
									<option	value="3">关闭</option>
                           		</select>
                           </td>
                        
					</tr>
						  </table>
				</div>				
			</div>
		</div>
		<div class="box_btn">
			<input type="button" class="btn btn_green" value="保&nbsp;&nbsp;存"
				onclick="add_contract()" /> <input type="button" id="reset" onclick="dialogclose()"
				class="btn btn_gray mgl-30" value="取&nbsp;&nbsp;消" />
		</div>
	</div>
</div>
