//列表的每页展示的条数
var pagesize=15;
var gridHeight=462;
var gridWidth="100%";

//定义要过滤的特殊字符
var speStr="<|>|'|;|&|#|\"|'";

/**
* 得到字符串的真实长度（双字节字符如汉字换算成两个单字节字符）.
*/
String.prototype.len = (function() {
    var re = /[^\x00-\xff]/g, xx = 'xx';

    return function() {
        return this.replace(re, xx).length;
    };
})();
String.prototype.getLength = String.prototype.len;

/**
 判断字符串是否以某个字符结尾
**/
String.prototype.endwith=function(oString){
   var reg=new RegExp(oString+"$");
   return reg.test(this);
}

function initDataPicker(){//alert("sdf");
	//处理日期
	$('.date-pick').each(function() {//alert("sdf");
		$(this).datepick({dateFormat: 'yy-mm-dd'
/*			closeAtTop:false,
			showOtherMonths:true,
			showBigPrevNext:true,
			showOn:'focus'
			showOn:'button',
			buttonImageOnly:true,
			buttonImage: '/hsls/images/icon/calendar.gif'*/
		});			
	});
}
//将所有的输入框设为只读，用在显示页面
function initinputreadonly(){
	//所有input
	$('input').attr("readonly","readonly");
	$('textarea').attr("readonly","readonly");
}
//重置表单的项为空，用在搜索那
function ResetControl() {   
     var v = document.forms[0].elements;   
     for (var i = 0; i < v.length; i++) {
         
         if (v[i].type == "text") {   
             v[i].value = "";   
         } else if (v[i].type == "select-one") {
             if (v[i].options.length>0)
             {
                 v[i].options[0].selected = true;
             }        
         }
         else if (v[i].type == "hidden") {
             v[i].value = "";
         }
     }   
  }   

/**
    限制输入字符长度  
    
    wangws  2010-005-07
**/
function  restrictStrMaxLength(obj,maxlength)
{
    if(obj.value.length >= maxlength)
    {
        obj.innerText =  obj.value.substr(maxlength);
    }
    
}

//检测是否输入数字--可用于在输入框内限制只能输入数字
function checkIsNum() {
    if (event.keyCode != 46 && event.keyCode != 8 && event.keyCode != 37 && event.keyCode != 39) {
        if (!((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105))) {
            event.returnValue = false;
        }
    }
}



/**
* 格式化字符串中的表达式：{0}、{1}、{2}...
*/
String.prototype.format = (function() {
    var re = /\{(\d+)\}/g;

    return function() {
        var args = arguments;

        if (args.length == 0) {
            return this;
        }

        return this.replace(re, function(m, i) {
            return args[i] != null ? args[i] : m;
        });
    };
})();

String.format = function(source) {
    if (source == null || source.trim() == '') {
        return '';
    }

    return String.prototype.format.apply(
		source, Array.prototype.slice.call(arguments, 1)
	);
};
/**
* 去掉字符串前后空格.
*/
String.prototype.trim = (function() {
    var re = /^\s+|\s+$/g, s = '';

    return function() {
        return this.replace(re, s);
    };
})();

/**
* 去掉字符串左边空格.
*/
String.prototype.trimLeft = (function() {
    var re = /^\s+/g, s = '';

    return function() {
        return this.replace(re, s);
    };
})();

/**
* 去掉字符串右边空格.
*/
String.prototype.trimRight = (function() {
    var re = /\s+$/g, s = '';

    return function() {
        return this.replace(re, s);
    };
})();

//去除前后空格
function Trim(Str)
{
  return Str.replace(/^[\s]+|[\s]+$/g,'');
}

/**
* 去掉字符串中的html标签.
*/
String.prototype.stripHTML = (function() {
    var re = /<(?:.|\s)*?>/g, s = '';

    return function() {
        return this.replace(re, s);
    };
})();

// 反格式化数字
 function formatR(str)
{

    while(str.indexOf(",")>=0)
    {
        str = str.replace(",","");
    }
    
    while(str.indexOf(".")>=0)
    {
        str = str.replace(".","");
    }
    
    
     return str;
}


/**
* 格式化数字（默认格式为：#,###.##）.
* 
* @param num 数字
* @param iScale 精度位数
*/
Number.format = function(num, iScale) {
    var fNum = num;

    // 不是有效数字，返回该num
    if (typeof (fNum) != 'number') {
        var sNum = String(fNum);

        if (sNum.trim() == '' || isNaN(sNum)) {
            return sNum;
        }

        fNum = Number(sNum);
    }

    // 如果指定了精度

    if (typeof (iScale) == 'number') {
        fNum = fNum.toFixed(iScale);
    }
    else {
        fNum = String(fNum);
    }

    // 分开整数部分和小数部分

    var ps = fNum.split('.'),
		zs = ps[0],
		xs = (ps[1] ? '.' + ps[1] : ''),
		re = /(\d+)(\d{3})/;

    // 整数部分每3位插入一个逗号
    while (re.test(zs)) {
        zs = zs.replace(re, '$1' + ',' + '$2');
    }

    // 销毁变量

    fNum = null; ps = null; re = null;

    return zs + xs;
};

/**
* 格式化成金额格式，前缀可以指定，默认为￥符号.
* 用法：(1) Number.money(123.45, 2);
* 		(2) Number.money(123.45, '$');
* 		(3) Number.money(123.45, 2, '$');
* 
* @param num 数字
* @param iScale 精度
* @param sSymbol 金额符号
*/
Number.money = function(num, iScale, sSymbol) {
    var v;

    if (typeof (iScale) == 'number') {
        v = Number.format(num, iScale);

        if (sSymbol == null) {
            sSymbol = '￥';
        }
    }
    else {
        v = Number.format(num);
        sSymbol = iScale;
    }

    if (v.charAt(0) == '-') {
        return '-' + sSymbol + v.substring(1);
    }
    return sSymbol + v;
};

/**
* 设置浮点数的精度.
* 
* @param iScale 精度
*/
Number.prototype.setScale = function(iScale) {
    return Number(this.toFixed(iScale));
};

/**
* 1. 取子字符串.
* 2. 子字符串 + ... + title提示
* 
* @param is 开始位置（下标从0开始）
* @param ie 结束位置
* @param showTitle 是否显示title提示。true：显示、false：不显示。默认false
* @deprecated
*/
String.prototype.substring2 = function(is, ie, showTitle) {
    if (arguments.length == 0) {
        return '';
    }

    if (arguments.length == 1) {
        ie = this.length;
    }

    if (typeof (is) != 'number' ||
		typeof (ie) != 'number') {
        return '';
    }

    if (typeof (showTitle) == 'undefined' ||
		typeof (showTitle) != 'boolean') {
        showTitle = false;
    }

    if (is < 0) is = 0;
    if (is > ie) is = ie;

    if (this.len() <= ie) {
        return this;
    }

    var sSource = this.substring(is);

    var str = '', c = '', len = 0;
    var reg = /[^\x00-\xff]/;

    for (var i = 0; c = sSource.charAt(i); i++) {
        str += c;
        len += (c.match(reg) != null ? 2 : 1);

        if (len >= ie) break;
    }

    if (showTitle) {
        return '<span title="' + this + '">' + str + '...<span>';
    }

    return str;
};

 //通过ID获取对象
 function $get(id)
 {
   return document.getElementById(id);
 }
 
 String.prototype.gblen=function()
 {
   var len=0;
   for(var i=0;i<this.length;i++)
   {
     if(this.charCodeAt(i)>127||this.charCodeAt(i)==94)
       len+=2;
      else
       len++;
   }
  return len; 
 }
 
 //中文字符长度
 function gblen(str)
 {
  var len=0;
  str=Trim(str);
   for(var i=0;i<str.length;i++)
   {
     if(str.charCodeAt(i)>127||str.charCodeAt(i)==94)
       len+=2;
      else
       len++;
   }
   return len; 
 }
 
 //验证是否为图片

 function ExPic(Picstr)
  {
         var regPhoto=new RegExp("(^.jpg$)|(^.gif$)|(^.png)|(^.bmp)","i");
         Picstr=Picstr.substring(Picstr.length-4,Picstr.length);
         return regPhoto.test(Picstr);
  }
  
  //验证是否为Excel文件
  function ExExcelFile(fileUrl)
  {
    var regExFile=new RegExp("(^.xls$)","i");
    fileUrl=fileUrl.substring(fileUrl.length-4,fileUrl.length);
    return regExFile.test(fileUrl); 
  }
  
  //验证是否为TXT文件
  function ExTxtFile(fileUrl)
  {
    var regExFile=new RegExp("(^.txt$)","i");
    fileUrl=fileUrl.substring(fileUrl.length-4,fileUrl.length);
    return regExFile.test(fileUrl); 
  }
  
  //验证是否为数字与字符组成的字符串 
 function ExName(Namestr)
  {
     var regName=new RegExp("[A-Za-z0-9]+","i");
     return regName.test(Namestr);
 }


function   checkkey(obj){ 

  return true;
                  var   key   =   event.keyCode; 
                  if(   (key   >   95   &&   key   <   106)   || 
                          (key   >   47   &&   key   <   60)   || 
                          (key   ==   110   &&   obj.value.indexOf( ".")   <   0   )|| 
                          (key   ==   190   &&   obj.value.indexOf( ".")   <   0   )){ 
                          
                  }else   if(key   !=   8){ 
                        //alert(key); 
                        event.returnValue   =   false; 
                    } 
} 




 //验证是否为数字

 function isNumber(str) {
     var regName = new RegExp("^[0-9]+.?[0-9]*$", "i");
     if (isNaN(str))
         return false;
     return regName.test(str);
 }

 //验证是否为正整数
 function isINumber(str) {
     var regName = new RegExp("^\\d+$", "i");
     return regName.test(str);
 } 
 
   
//是否是合法邮箱

function isEmail(s)
{
  var patrn=new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/);
  return patrn.test(s);
}

//是否包含中文
function ExChinese(str)
{
  var regName=new RegExp("([\u4e00-\u9fa5])+","i")
  return regName.test(str);
}

//验证组织机构代码格式是否正确
function isValidEntpCode(code) {
    var codeArray = new Array(8);
    var codeFactor = new Array(8);
    var verifyChar;
    var reg = /^([0-9A-Z]){8}-[0-9|X]$/;
    if (!reg.test(code)) {
        return false;
    }

    code = code.replace('-', '');

    for (var i = 0; i < 8; i++) {
        var tmpChar = code.substring(i, i + 1);
        if (isNaN(tmpChar)) {
            codeArray[i] = tmpChar.charCodeAt(0) - 65 + 10;
        } else {
            codeArray[i] = parseInt(tmpChar);
        }
    }


    endChar = code.substring(8, 9);
    codeFactor[0] = 3;
    codeFactor[1] = 7;
    codeFactor[2] = 9;
    codeFactor[3] = 10;
    codeFactor[4] = 5;
    codeFactor[5] = 8;
    codeFactor[6] = 4;
    codeFactor[7] = 2;
    var j1 = 0;
    for (var i = 0; i < 8; i++) {
        j1 = j1 + codeArray[i] * codeFactor[i];
    }
    j1 = j1 % 11;
    j1 = 11 - j1;
    switch (j1) {
        case 11:
            verifyChar = "0";
            break;
        case 10:
            verifyChar = "X";
            break
        default:
            verifyChar = String(j1);
    }
    if (endChar == verifyChar) {
        return true;
    } else {
        return false;
    }
}


function stopBubble(e) {
    if (e && e.stopPropagation) {
        e.stopPropagation();
    } else {
        window.event.cancelBubble = true;
    }
}

function isNum(e, o, c) {
    if (o.createTextRange) {
        var r = document.selection.createRange();
        var n = 0;
        var r2 = o.createTextRange();
        r2.collapse();
        while(r2.compareEndPoints("StartToStart",r)<0){
            r2.moveStart("character", 1);
            n++;
        }
    }
    n = n == undefined ? -99999 : n;
    var re = [];
    re.push('/^\\d');
    re.push(n <= o.value.indexOf('.') ? '' : '(?!\\d*\\.\\d{' + (c || 2) + '}$)');
    if(window.navigator.userAgent.toLowerCase().indexOf("msie")>=1){
      re.push('|^\\.\\d+(?!\\d*\\.)/.test("' + (String.fromCharCode(e.keyCode) + o.value) + '")');
    }
    else{
      re.push('|^\\.\\d+(?!\\d*\\.)/.test("' + (String.fromCharCode(e.which) + o.value) + '")');
    }
    return eval(re.join(''));
}

//验证是否包含特殊字符
function isSpecialChar(str)
{
  var reg=new RegExp(speStr,"i")
  return reg.test(str);
}

//替换特殊字符为空
function repalceUnsafeChar(obj)
{  
 //alert(event.keyCode);
  var keyNum=event.keyCode;

    if(keyNum==37||keyNum==38||keyNum==39||keyNum==40||keyNum==13||keyNum==8)
      return;
    obj.value = obj.value.replace(/[^a-zA-Z0-9@ \。\，\/\,\.\:\_\-\u4E00-\u9FA5]*$/, '');
}

function appendZero(s){ return ("00"+s).substr((s+"").length);}

function DateFormat(dateStr)
{
  if(dateStr.trim().length==0)
    return "";
  
  var year=dateStr.split("-")[0];
  var month=appendZero(dateStr.split("-")[1]);
  var day=appendZero(dateStr.split("-")[2]);
  
  return year+"-"+month+"-"+day;
}

function OpenFullWindow(url) {
    window.open(url, "", 'height=' + screen.availHeight + ', width=' + screen.availWidth + ', top=0, left=0,toolbar=no, menubar=no, scrollbars=yes, resizable=yes, location=no, status=yes'); if (event) event.returnValue = false;
}


Date.prototype.addMonths=function(n){
    this.setMonth(this.getMonth()+n);
    return this;
  }

 /*
    dateStr格式：yyyy-mm-dd
    返回:yyyy-mm-dd
  */
  function addMonth(dateStr,month)
  {
    var sYear=parseInt(dateStr.split('-')[0],10);
    var sMonth=parseInt(dateStr.split('-')[1],10);
    var sDay=parseInt(dateStr.split('-')[2],10);
    
    sMonth=sMonth+parseInt(month);
    
  
    while(sMonth>12)
    {
      sYear=sYear+1;
      sMonth=sMonth-12;
    }
    
   
    return DateFormat(sYear+"-"+sMonth+"-"+sDay);
    
  }
  
  

/**
formObj：form对象， exceptObjName： 不检查的对象名称
*/
function isFormChanged(formObj, exceptObjName) {
    if (formObj == null) formObj = document.forms[0];
    if (exceptObjName == null) exceptObjName == "";
    var selectObjs = formObj.getElementsByTagName("SELECT"); //For Select Obj
    for (var i = 0; i < selectObjs.length; i++) {
        if ((selectObjs[i].name == "") || (eval("/(^|,)" + selectObjs[i].name + "(,|$)/g").test(exceptObjName))) continue;
        if (selectObjs[i].value == selectObjs[i].defaultValue) continue;
        for (var j = 1; j < selectObjs[i].length; j++) {
            if (selectObjs[i].options[j].defaultSelected != selectObjs[i].options[j].selected)
                return true;
        }
    }

    var inputObjs = formObj.getElementsByTagName("INPUT"); //For input Obj
    for (var i = 0; i < inputObjs.length; i++) {
        if ((inputObjs[i].name == "") || (eval("/(^|,)" + inputObjs[i].name + "(,|$)/g").test(exceptObjName))) continue;
        if ((inputObjs[i].type.toUpperCase() == "TEXT") && (inputObjs[i].defaultValue != inputObjs[i].value))
            return true;

        else if (((inputObjs[i].type.toUpperCase() == "RADIO") || (inputObjs[i].type.toUpperCase() == "CHECKBOX"))
			&& (inputObjs[i].defaultChecked != inputObjs[i].checked))
            return true;

    }

    var textareaObjs = formObj.getElementsByTagName("TEXTAREA"); //For Select Obj
    for (var i = 0; i < textareaObjs.length; i++) {
        if ((textareaObjs[i].name == "") || (eval("/(^|,)" + textareaObjs[i].name + "(,|$)/g").test(exceptObjName))) continue;
        if (textareaObjs[i].defaultValue != textareaObjs[i].value)
            return true;

    }
    return false;
}

/**
判断日期是否合法 格式：YYYY-MM-DD
调用：IsDate("2010-10-10")
**/
function IsDate(str){
    var re = /^\d{4}-\d{1,2}-\d{1,2}$/;
    if(re.test(str)){
        //判断是否合法日期
        var array=str.split('-');
        var date=new Date(array[0],parseInt(array[1],10)-1,array[2]);
        if(!((date.getFullYear()==parseInt(array[0],10)) 
            && ((date.getMonth()+1)==parseInt(array[1],10)) 
            && (date.getDate()==parseInt(array[2],10)))){
            //不是有效日期
            return false;
        }
        
        if(parseInt(array[1])==2&&parseInt(array[2])>daysFebruary(parseInt(array[0])))
          return false;
        
        return true;
    }
    //日期格式错误
    return false;
}


function daysFebruary(year){
  return (((year%4==0)&&((!(year%100==0))||(year%400==0)))?29:28);
 //return 28;
}


/********
日期验证
格式为：2009-01-01,
调用：isDate("2009-01-01");
如果要设置判断年段(默认为：从101年前到现在1年前)，则为

 dtCh='-';//日期分隔符

 minYear=1900;//开始年限

 maxYear=2009;//结束年限
*******/
    var dtCh='-';
    var minYear=new Date().getFullYear()-101;
    var maxYear=new Date().getFullYear()-1;
    function DaysArrary(n){
         var days=new Array();
         for(var i=1;i<=n;i++)
         {
           days[i]=31;
           if(i==4||i==6||i==9||i==11)
             days[i]=30;
           if(i==2)
             days[i]=29;
         }
        return days;
      }
      
    function stripCharInbag(s,bag){
      var str="";
      for(var i=0;i<s.length;i++)
      {
       var c=s.charAt(i);
        if(c.indexOf(bag)==-1)
          str+=c;
      }
      return str;
    }
    
     function isFeb(year){
       return (((year%4==0)&&(!(year%100==0)||(year%4==0)))?29:28)
     } 
     
     
     function isInt(s){
        for(var i=0;i<s.length;i++)
        {
          var c=s.charAt(i);
          if((c<"0")||(c>"9"))
            return false;
        }
        return true;
     }
     
     function toInt(s)
     {
       for(var i=0;i<s.length;i++)
        {
          var c=s.charAt(i);
          if((c<"0")||(c>"9"))
            return false;
        }
     }
     
     function isDate(dtStr)
     {
        var daysInMonth=DaysArrary(12);
        var pos1=dtStr.indexOf(dtCh);
        var pos2=dtStr.indexOf(dtCh,pos1+1);
        var strYear=dtStr.substring(0,pos1);
        var strMonth=dtStr.substring(pos1+1,pos2);
        var strDay=dtStr.substring(pos2+1);
        
        
        
        if(!isInt(strYear))
          return false;
        
        if(!isInt(strMonth))
          return false;
          
        if(!isInt(strDay))
         return false;
        
       
        
        year=parseFloat(strYear);
        month=parseFloat(strMonth);
        day=parseFloat(strDay);
        

        
        if(pos1==-1||pos2==-1)
          return false;
        
        if(month<1||month>12)
          return false;
          
       
         
        if(day<1||day>31||(month==2&&day>isFeb(year))||day>daysInMonth[month])
          return false;
       
        if(strYear.length!=4||year==0||year<minYear||year>maxYear)
          return false;
          
       if(dtStr.indexOf(dtCh,pos2+1)!=-1||isInt(stripCharInbag(dtStr,dtCh))==false)
        return false;
       
         return true;
      }
      
    /**********日期验证程序结束*********/




//用于textrea字符串长度控制

function truncateInput(obj, maxLength) {
    if (obj.value.length > maxLength) {
        obj.value = obj.value.substr(0, maxLength);
    }
}

function getCheckedValue(radioObj) {
	if(!radioObj)
		return "";
	var radioLength = radioObj.length;
	if(radioLength == undefined)
		if(radioObj.checked)
			return radioObj.value;
		else
			return "";
	for(var i = 0; i < radioLength; i++) {
		if(radioObj[i].checked) {
			return radioObj[i].value;
		}
	}
	return "";
}


function setCheckedValue(radioObj, newValue) {

 
	if(!radioObj)
		return;
	var radioLength = radioObj.length;
	if(radioLength == undefined) {
		radioObj.checked = (radioObj.value == newValue.toString());
		return;
	}
	for(var i = 0; i < radioLength; i++) {
		radioObj[i].checked = false;
		
		if(radioObj[i].value == newValue.toString()) {
			radioObj[i].checked = true;
		}
	}
}

function setSelectControlValue(obj,val)
{
 

 for(var i=0;i<obj.length;i++)
 {
   if(obj[i].value==val)
   {
     obj.selectedIndex=i;
     break;
   }
 }

}


function NewOpenBySize(url,target,width,height){
        var tt,w,left,top;
		if (!width) width=screen.width;
		if (!height) height=screen.height-60;
		left=(screen.width-width)/2;
		if(left<0){ left=0;}

		top=(screen.height-60-height)/2;
		if(top<0){ top=0;}

		tt = "toolbar=no, menubar=no, scrollbars=yes,resizable=no,location=no, status=no,";
		tt = tt + "width=" + width + ",height=" + height + ",left=" + left + ",top=" + top;
		//alert(tt);
	    w=window.open(url,target,tt);
		try{
			w.focus();
		}catch(e){}
}


//限制输入 数字和小数点方法二
function clearNoNum(obj) 
{ 
   obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符 
   obj.value = obj.value.replace(/^\./g,"");  //验证第一个字符是数字而不是. 
   obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的. 
   obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");

}
// function clearNoNum(obj)
//    {
// 只能输入小数点2位
//        obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');
//先把非数字的都替换掉，除了数字和.
//        obj.value = obj.value.replace(/[^\d.]/g,"");
//必须保证第一个为数字而不是.
//        obj.value = obj.value.replace(/^\./g,"");
//保证只有出现一个.而没有多个.
//        obj.value = obj.value.replace(/\.{2,}/g,".");
//保证.只出现一次，而不能出现两次以上
//        obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
//    }

//限制输入 数字
function clearNoInt(obj) 
{ 
   obj.value = obj.value.replace(/[^\d]/g,"");  //清除“数字”和“.”以外的字符 
   obj.value = obj.value.replace(/^\./g,"");  //验证第一个字符是数字而不是. 
   obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的. 
   obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
}


function isMatch(str1,str2){
        var index = str1.indexOf(str2);
        if(index==-1) return false;
        return true;
    }
    
String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {
     if (!RegExp.prototype.isPrototypeOf(reallyDo)) {
         return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi": "g")), replaceWith);
    } else {
         return this.replace(reallyDo, replaceWith);
     }
}

function GetRadioValue(objname){
    var v=document.getElementsByName(objname);
    for (var i=0;i<v.length;i++){
     if(v.item(i).checked){
       return v.item(i).value;
     }
    }
    return "";
}
 function SetRadioValue(objname,val){
    var v=document.getElementsByName(objname);
    for(var i=0;i<v.length;i++){
        if (val == v.item(i).value) {           
       v.item(i).checked=true;
     }
    }    
}

function isCharsInBag(s, bag) {
    var i, c;
    for (i = 0; i < s.length; i++) {
        c = s.charAt(i); //字符串s中的字符
        if (bag.indexOf(c) > -1)
            return c;
    }
    return "";
}
function ischinese(s) {
    var errorChar;
    var badChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789><, 　[]{}?/+=|\\'\":;~!#$%()`";
    errorChar = isCharsInBag(s, badChar);
    if (errorChar != "") {
        //report = report + "请重新输入中文\n"; 
        return false;
    }
    return true;
}

function OpenDiv(div) {
    var $divUrget = $("#" + div);
    $divUrget.show();

    var divId = $divUrget.get(0);
    //alert(divId.id);
    var rr = new getClientBoundsWH();
    divId.style.display = 'block';
    divId.style.left = (rr.width - divId.clientWidth) / 2 + document.body.scrollLeft;
    divId.style.top = (rr.height - divId.clientHeight) / 2 + document.body.scrollTop;
}

/*设置客户端的高和宽*/
function getClientBoundsWH() {
    var clientWidth;
    var clientHeight;

    clientWidth = document.compatMode == "CSS1Compat" ? document.documentElement.clientWidth : document.body.clientWidth;
    clientHeight = document.compatMode == "CSS1Compat" ? document.documentElement.clientHeight : document.body.clientHeight;

    return { width: clientWidth, height: clientHeight };
}
//格式化数字格式为千分 逗号
function MilliFormat(fSum) {
    //var re = new RegExp("^(-?\\d+)(\\.\\d+)?{1}");
    var strSum;
    var behind = "";
    //if (re.test(fSum)) {
        strSum = new String(fSum);
    //}
    //else {
    //    return "";
    //}

    if (strSum.indexOf(".") > -1) {
        behind = strSum.split(".")[1];
        strSum = strSum.split(".")[0];
    }
    var len;
    var result = "";
    var temp = "";
    len = strSum.length;
    while (len > 3) {
        temp = "," + strSum.substring(len - 3, len);
        strSum = strSum.substring(0, len - 3);
        result = temp + result;
        len = strSum.length;
    }
    if (len > 0) {
        result = strSum + result;
    }
    if (behind != "")
        result += "." + behind;

    return result;
}