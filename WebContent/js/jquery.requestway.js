/**
 * 根据jquery编写对象
 * 用户通用的json交互
 */
var param = {};
$.jsonGet = function(url,param,call){
	ajaxRequest("get","json",url,param,call);
}
$.jsonPost = function(url,param,call){
	ajaxRequest("post","json",url,param,call);
}
$.requestPost = function(url,param,callBack){
	url = url+"?shoveDate"+new Date().getTime();
	$.post(url,param,function(data){
		callBack(data);
	});
}
function ajaxRequest(typeref,dataTyperef,urlref,param,callBack){
	$.ajax({
		  async:false,
		  type: typeref,
		  url: urlref,
		  cache: false,
		  data:param,
		  dataType: dataTyperef,
		  success:function(data){
			  callBack(data);
		  },
		  error:function(data){
			  callBack(data);
		  }
		});
}
// 分页
/**
function goPage(i){
	//回调页面方法
	var param = getParam();
	param["curPage"]=i;
	initcallBank(param);
}
**/