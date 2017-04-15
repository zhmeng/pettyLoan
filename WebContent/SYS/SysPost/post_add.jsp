<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">

	function add_contract() {
		
		var PostName = $('#PostName').val();
		var PostIsDept = $('#PostIsDept').val();
		
		if(PostName == ""|| PostName==null){
			alert("请填写职位名称");
			return;
		}
		if(PostIsDept == ""|| PostIsDept==null){
			alert("请填写所属部门");
			return;
		}
		
		var param = {};
		param["PostName"] = PostName;
		param["PostIsDept"] = PostIsDept;
		
		// 加载渠道管理用户
		
		jQuery.ajax({
			type : "post", // 请求方式
			url : "action/post/AddPost", // Ajax访问地址
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

	var api = frameElement.api, W = api.opener;

	function dialogclose() {
		W.$.post("action/post/goPost", function(data) {
			dictIndex(data);
		}, 'html');
		api.close();
	};

	function dictIndex(data) {
		var result = pageSystemVerify(data);
		if (result) {
			W.$("#tb_post_div").html(data);
		}
	};
</script>

<div class="mainbox">
	<div class="box90 bkCenter">
		<div class="infobox">
			<div class="infocontent">
			
					<div class="infotitle">
						<h3>添加部门</h3>
					</div>
					<div class="infocontent">
						<c:forEach var="list"  items="${sysDept}">
							 <label>职位名称：</label><input name="PostName" id="PostName" />
							 <label>所属部门：</label><input name="PostIsDept" id="PostIsDept" />
						  </c:forEach>
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
