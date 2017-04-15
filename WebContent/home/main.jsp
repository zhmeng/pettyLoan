<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", path);
	request.setAttribute("basePath", basePath);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link href="${basePath}/css/style-theme-lx.css" rel="stylesheet" type="text/css" />
    <link href="../css/home.css" rel="stylesheet" type="text/css" />
    <link href="../css/Css.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${basePath}js/jquery.js"></script>
    <script type="text/javascript" src="${basePath}js/Util.js"></script>
    <script src="${basePath}js/idCardValidate.js" type="text/javascript"></script>
    <link href="../css/public_xe.css" rel="stylesheet" />
    <link href="../css/style.css" rel="stylesheet" />
    <script type="text/javascript">
        function toSearch(flag) {
            var custName = "";
            var custNo = "";
            var ApplyNO = "";
            var DH = ""; var DW = "";
            var addr = "";

            var url = "";
            var n = 0;
            var obj = null;

            custName = $get("txt_CustName").value.trim();
            custNo = $get("txt_CustNo").value.trim();
            ApplyNO = $get("txt_ApplyNO").value.trim();
            DH = $get("txt_DH").value.trim();
            DW = $get("txt_DW").value.trim();
            addr = $get("txt_addr").value.trim();
            obj = $get("sel_operType");
            if (obj.options[obj.selectedIndex].value.trim() == "") {
                alert("您没有相关的权限，请与管理员联系。");
                return;
            } else {
                n = parseInt(obj.options[obj.selectedIndex].value);
                switch (n) {
                    case 1:
                        url = "../Apply/ApplyCheckCustOrNoView.aspx?custname=" + escape(custName) + "&addr=" + escape(addr) + "&custno=" + escape(custNo) + "&DH=" + escape(DH) + "&DW=" + escape(DW);
                        break;
                    case 2:
                        url = "../Apply/ApplyList.aspx?custname=" + escape(custName) + "&custno=" + escape(custNo) + "&ApplyNO=" + escape(ApplyNO);
                        break;
                    case 3:
                        url = "../Finance/DetailList.aspx?custname=" + escape(custName) + "&ApplyNO=" + escape(ApplyNO) + "&custno=" + escape(custNo);
                        break;
                    case 4:
                        url = "../Apply/SearchAll.aspx?custname=" + escape(custName) + "&addr=" + escape(addr) + "&custno=" + escape(custNo) + "&DH=" + escape(DH) + "&DW=" + escape(DW);
                        break;
                }
                location.href = url;
                return false;            
            }
        }
        function toReturn(flag) {
            var custName = "";
            var custNo = "";
            var ApplyNO = "";
            var DH = ""; var DW = "";
            var addr = "";

            var url = "";
            var n = 0;
            var obj = null;

            custName = $get("Text1").value.trim();
            custNo = $get("Text2").value.trim();
            ApplyNO = $get("Text3").value.trim();
            PayDate = $get("txtPayDate").value.trim();
            obj = $get("Select1");

            if (custName == "" && custNo == "" && ApplyNO=="") {
                alert("姓名、证件号码、贷款申请号至少应填写一项！");
                return;
            } else {
                n = parseInt(obj.options[obj.selectedIndex].value);
                url = "../Apply/ApplyList.aspx?custname=" + escape(custName) + "&custno=" + escape(custNo) + "&ApplyNO=" + escape(ApplyNO) + "&IntType=" + n + "&PayDate=" + escape(PayDate);
                
                return false;
            }
        }
        function searchform() {
        }
        function OpenDialog(Url) {
            var url = Url + "?new=" + Math.random();
            var result = window.showModalDialog(url, "RESETPWD", "status=no;scroll=no;resizable=no;center:yes;dialogHeight:350px;dialogWidth:400px;");
            //alert(result);
            if (result == null || result == "undefined" || result.trim() == '') {
//                return;
//            }
//            else if (result == "refresh") {
                window.location.herf = "../login.aspx";
                }
        }     

  </script>

</head>
<body>
   
              
    <script>
    
//OpenDialog('../home/ResetPwd.aspx');
//top.$.jBox("iframe:../home/ResetPwd.aspx", {
//    title: "百度一下",
//    width: 400,
//    showClose: false,
//    height: 250,
//    buttons: false,
//    showScrolling: false
//});


</script>
</body>
</html>
