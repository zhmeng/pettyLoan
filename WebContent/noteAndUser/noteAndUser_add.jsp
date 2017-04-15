<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", path);
	request.setAttribute("basePath", basePath);
%>
<link rel="stylesheet" href="${path}/css/default.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/outReg.css" type="text/css" />
<link rel="stylesheet" href="${path}/css/Css.css" type="text/css" />
<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/noteAndUser/noteAndUser.js"></script>

<script type="text/javascript">
function leftMove(){
    var userSelect1 = document.getElementById("userSelect1");  
    var userSelect2 = document.getElementById("userSelect2");
    for(var i=0;i<userSelect2.options.length;i++){  
		var cur = userSelect2.options[i];
        if(cur.selected){  
            var opt = document.createElement("option");  
            opt.value = cur.value;  
            opt.text = cur.text;  
            userSelect1.add(opt);
			cur.parentNode.removeChild(cur);
        }  
    }  
}  

function rightMove(){  
    var userSelect1 = document.getElementById("userSelect1");  
    var userSelect2 = document.getElementById("userSelect2");  
    for(var i=0;i<userSelect1.options.length;i++){  
		var cur = userSelect1.options[i];
        if(cur.selected){  
            var opt = document.createElement("option");  
            opt.value = cur.value;  
            opt.text = cur.text;  
            userSelect2.add(opt);  
            cur.parentNode.removeChild(cur);
        }  
    }  
}

function addNoteAndUser() {
	var basePath = $("#basePath").val();
	var status = $("#status").val();
	var userSelect1 = document.getElementById("userSelect1");
	var userSelect1str = "";
	for(var i=0;i<userSelect1.options.length;i++) {
		userSelect1str += userSelect1.options[i].value + ",";
	}
	
	var param = {};
	param["userSelect1"] = userSelect1str;
	param["status"] = status;

	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/noteAndUser/addNoteAndUser", // Ajax访问地址
		data : param, // 参数
		dataType : "json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert("保存异常");
		},
		success : function(data) { // 返回成功时运行，主要接受结果
			if (data.success) {
				alert(data.msg);
				window.close();
			} else {
				alert('保存异常');
			}
		}
	});
}

function getNoteAndUserByStatus(status) {
	var basePath = $("#basePath").val();
	var data = {
		status : status,
	};
	jQuery.ajax({
		type : "post", // 请求方式
		url : basePath + "action/noteAndUser/getNoteAndUserByStatus", // Ajax访问地址
		data : data, // 参数
		dataType : "json", // 指定返回数据类型
		error : function() { // 出现错误时运行
			alert("出错了");
		},
		success : function(data) { // 返回成功时运行，主要接受结果
			if (data.success) {					
				var str = data.msg.split(';');
				// right
				$("#userSelect1 option").remove();
				$("#userSelect1").append(str[0]);
				// left
				$("#userSelect2 option").remove();
				$("#userSelect2").append(str[1]);
				return;
			}
			alert("出错了");
		}
	});
}
$(function(){
	getNoteAndUserByStatus($("#status").val());
})
</script>
<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
				<input id="basePath" type="hidden" value="${basePath}"/>
				<div class="infotitle">
					<h3>添加节点</h3>
				</div>
				<div class="infocontent">
					<table id="table1" style="width:100%;" class="tableList">
						<tr>
		                    <td align="right">选择节点</td>
							<td colspan="2">
								<select name="status" id="status" onchange="getNoteAndUserByStatus(this.value)">									
							    	<option value="201">审批专员</option>	
							    	<option value="202">审批主管</option>
							    	<option value="203">审批经理</option>			 
					        	</select>
							</td>
						</tr>
	                    <tr>
		                    <td align="right">
						未选择人员<select id="userSelect2" multiple size="10" style="width: 100px;height: 200px;"></select>
							</td>
							<td align="center">
								<input type="button" value="&gt" style="width:80px;height:20px" onclick="leftMove();"/><br><br> 
								<input type="button" value="&lt" style="width:80px;height:20px" onclick="rightMove();"/><br><br>  
							</td>
							<td align="left">
								<select id="userSelect1" multiple size="10" style="width: 100px;height: 200px;">  	
						    		<c:forEach var="bean" items="${noteUserList}">
						    			<option value="<c:out value='${bean.userId}'/>"><c:out value='${bean.userName}'/></option>						    		
						    		</c:forEach>
						        </select>已选择人员
							</td>
						</tr>
					</table>
				</div>				
			</div>
		</div>&nbsp;
		<div class="box_btn" align="center">
			<input type="button" value="保&nbsp;&nbsp;存" onclick="addNoteAndUser()"/> 
			<input type="button" id="reset" onclick="window.close()" value="取&nbsp;&nbsp;消"/>
		</div>
	</div>
</div>