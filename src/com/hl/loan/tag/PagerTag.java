package com.hl.loan.tag;   
  
import java.io.IOException;   
import java.util.Enumeration;   
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.jsp.JspException;   
import javax.servlet.jsp.tagext.TagSupport;   
  
/**  
 * 分页标签处理类  
 */
public class PagerTag extends TagSupport {   
    private static final long serialVersionUID = 5729832874890369508L;   
    private String url;         //请求URl   
    private int pageNo = 1;     //当前页号   
    private int recordCount;    //总记录数   
    private int pageSize = 10;  //每页要显示的记录数
    @SuppressWarnings("unchecked")   
    public int doStartTag() throws JspException {   
    	
    	if(pageSize == 0){ 
    		pageSize = 10;
    	}
    	
        int pageCount = recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1;  //计算总页数   
           
        //拼写要输出到页面的HTML文本   
        StringBuilder sb = new StringBuilder();   
           
           
        sb.append("<style type=\"text/css\">");   
        sb.append(".pagination {padding: 5px;float:center;font-size:12px;position:relative; }");   
        sb.append(".pagination a, .pagination a:link, .pagination a:visited {padding:2px 5px;margin:2px;border:1px solid #aaaadd;text-decoration:none;color:#006699;}");   
        sb.append(".pagination a:hover, .pagination a:active {border: 1px solid #ff0000;color: #000;text-decoration: none;}");   
        sb.append(".pagination span.current {padding: 2px 5px;margin: 2px;border: 1px solid #5997C5;font-weight: bold;background-color: #5997C5;color: #FFF;}");   
        sb.append(".pagination span.disabled {padding: 2px 5px;margin: 2px;border: 1px solid #eee; color: #ddd;}");   
        sb.append("</style>\r\n");  
        sb.append("<p></p>");
        sb.append("<div class=\"pagination\"  align=\"center\">\r\n");   
        if(recordCount == 0){   
        	
        	/*sb.append(" <table class=\"table01\" width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"3\">");
        	sb.append("<tr> <td  class=\"td_content\" ><h3>没有可显示的项目</h3></td></tr></table>");*/
            sb.append("<strong>没有可显示的项目</strong>\r\n");   
        }else{   
            //页号越界处理   
            if(pageNo > pageCount){      pageNo = pageCount; }   
            if(pageNo < 1){      pageNo = 1; }   
               
            sb.append("<form id=\"pageForm\" method=\"post\" action=\"").append(this.url)   
                .append("\" name=\"qPagerForm\">\r\n");   
               
            //获取请求中的所有参数   
            HttpServletRequest request = (HttpServletRequest) pageContext   
                    .getRequest();   
            Enumeration<String> enumeration = request.getParameterNames();   
            String name = null;  //参数名   
            String value = null; //参数值   
            //把请求中的所有参数当作隐藏表单域   
            while (enumeration.hasMoreElements()) {   
                name =  enumeration.nextElement();   
                value = request.getParameter(name);   
                // 去除页号   
                if (name.equals("pageNo")) {   
                    if (null != value && !"".equals(value)) {   
                        pageNo = Integer.parseInt(value);   
                    }   
                    continue;   
                }   
                if (name.equals("pageNo")) { 
                sb.append("<input type=\"hidden\" id=\"pageNo\" name=\"pm.")   
                  .append(name)   
                  .append("\" value=\"")   
                  .append(value)   
                  .append("\"/>\r\n");   
                }   
            }   
       
            // 把当前页号设置成请求参数   
            sb.append("<input  name=\"pm.pageNo\" id=\"pageNo\" type=\"hidden\"")
                .append(" value=\"").append(pageNo).append("\"/>\r\n");   
           
            // 输出统计数据   
            sb.append("&nbsp;共<strong>").append(recordCount)   
	            .append("</strong>项")   
	            .append(",<strong>")
	            .append("<strong>")   
                .append(pageCount)   
                .append("</strong>页:&nbsp;\r\n")
                .append("每页显示：<input name=\"pm.pageSize\" id=\"pageSize\" size=\"1\" value=\"").append(pageSize).append("\" onkeydown=\"enterNumber();\" onkeyup=\"checkPageSize(this);\"/>条\r\n");   
               
            //上一页处理   
            if (pageNo == 1) {   
                sb.append("<span class=\"disabled\">&laquo;&nbsp;上一页")   
                    .append("</span>\r\n");   
            } else {   
                sb.append("<a href=\"javascript:turnOverPage(")   
                  .append((pageNo - 1))   
                  .append(")\">&laquo;&nbsp;上一页</a>\r\n");   
            }   
               
            //如果前面页数过多,显示"..."   
            int start = 1;    
            if(this.pageNo > 8){   
                start = this.pageNo - 1;   
                sb.append("<a href=\"javascript:turnOverPage(1)\">1</a>\r\n");   
                sb.append("<a href=\"javascript:turnOverPage(2)\">2</a>\r\n");   
                sb.append("&hellip;\r\n");   
            }   
            //显示当前页附近的页   
            int end = this.pageNo + 4;   
            if(end > pageCount){   
                end = pageCount;   
            }   
            for(int i = start; i <= end; i++){   
                if(pageNo == i){   //当前页号不需要超链接   
                    sb.append("<span class=\"current\">")   
                        .append(i)   
                        .append("</span>\r\n");   
                }else{   
                    sb.append("<a href=\"javascript:turnOverPage(")   
                        .append(i)   
                        .append(")\">")   
                        .append(i)   
                        .append("</a>\r\n");   
                }   
            }   
            //如果后面页数过多,显示"..."   
            if(end < pageCount - 4){   
                sb.append("&hellip;\r\n");   
            }   
            if(end < pageCount - 1){   
                sb.append("<a href=\"javascript:turnOverPage(")   
                .append(pageCount - 1)   
                .append(")\">")   
                .append(pageCount - 1)   
                .append("</a>\r\n");   
            }   
            if(end < pageCount){   
                sb.append("<a href=\"javascript:turnOverPage(")   
                .append(pageCount)   
                .append(")\">")   
                .append(pageCount)   
                .append("</a>\r\n");    
            }   
               
            //下一页处理   
            if (pageNo == pageCount) {   
                sb.append("<span class=\"disabled\">下一页&nbsp;&raquo;")   
                    .append("</span>\r\n");   
            } else {   
                sb.append("<a href=\"javascript:turnOverPage(")   
                   .append((pageNo + 1))   
                    .append(")\">下一页&nbsp;&raquo;</a>\r\n");   
            }   
            sb.append("转到第 <input size='1' value=\"").append(pageNo)
            .append("\" name=\"goValue\" id=\"goValue\" onkeydown=\"enterNumber()\"/> 页 <a href=\"javascript:submitValue()\">GO</a>")
            .append(" <span style=\"color: #FF0000;\"><div  id=\"pageMessage\">&nbsp;</div></span>");
            sb.append("<div id=\"para\"></div>\r\n"); 
            sb.append("</form>\r\n");   
       
            // 生成提交表单的JS   
//            sb.append("<script type=\"text/javascript\" src=\"js/jquery.js\"></script>\r\n");
            /*sb.append("<script type=\"text/javascript\" src=\"/xnoa/js/jquery-1.4.4.min.js\"></script>\r\n");*/
            sb.append("<script language=\"javascript\">\r\n");   
            sb.append("  function turnOverPage(no){\r\n");   
            sb.append("    if(no>").append(pageCount).append("){");   
            sb.append("      no=").append(pageCount).append(";}\r\n");   
            sb.append("    if(no<1){no=1;}\r\n");   
            sb.append("    pageFormPara();\r\n");   
            //sb.append("    document.qPagerForm.pageNo.value=no;\r\n"); 
            sb.append("$(\"#pageNo\").val(no);\r\n");
            sb.append("    $(\"#pageForm\").submit();\r\n");   
            sb.append("  }\r\n");   
            
            sb.append("  function pageFormPara(){\r\n");   
            sb.append("     var searchForm = $(\"#searchForm\");\r\n");  
            sb.append("     if(searchForm != undefined){\r\n");  
            sb.append("          var arrays = searchForm.serializeArray();\r\n");
            sb.append("          var datas = [];\r\n");  
            sb.append("          $.each(arrays, function(i, field){\r\n");  
            sb.append("              datas.push('<input type=\"hidden\" name=\"'+field.name+'\" value=\"'+field.value+'\" />');\r\n");
            sb.append("          });\r\n");
            sb.append("          $(\"#para\").html(\"\").append(datas.join(\"\"));\r\n");
            sb.append("     } \r\n"); 
            sb.append("  }\r\n"); 
            
            sb.append("  function submitValue(){\r\n");   
            sb.append("  var pages = document.getElementById(\"goValue\").value;\r"); 
            sb.append("  turnOverPage(pages);");
            sb.append("  }\r\n");  
            
            //每页显示条数检查
            sb.append("  function checkPageSize(obj){ ");
            sb.append("  if(obj.value <= 0){obj.value = 1;} ");
            sb.append("  if(obj.value > 50){ ");
            sb.append(" document.getElementById(\"pageMessage\").innerHTML =\" 每页显示条数最多50条。 \";");
            sb.append(" obj.value = 50;");
            sb.append(" setTimeout(function(){document.getElementById(\"pageMessage\").innerHTML =\"\";},2000);}}");
            //只能输入0-9数字
            sb.append("  function enterNumber(){ ");
            sb.append("  if(event.keyCode == 46||event.keyCode<48||event.keyCode>57 && event.keyCode<96||event.keyCode>105 ){ ");
            sb.append("  if(event.keyCode!=8){");
            sb.append(" document.getElementById(\"pageMessage\").innerHTML =\" 请输入数字。 \";");
            sb.append("   event.returnValue = false;setTimeout(function(){document.getElementById(\"pageMessage\").innerHTML =\"\";},2000);}}}");
            sb.append("</script>\r\n");   
        }   
        sb.append("</div>\r\n");   
           
        //把生成的HTML输出到响应中   
        try {   
            pageContext.getOut().println(sb.toString());   
        } catch (IOException e) {   
            throw new JspException(e);   
        }   
        return SKIP_BODY;  //本标签主体为空,所以直接跳过主体   
    }   
  
    public void setUrl(String url) {   
        this.url = url;   
    }   
    public void setPageSize(int pageSize) {   
        this.pageSize = pageSize;   
    }   
    public void setPageNo(int pageNo) {   
        this.pageNo = pageNo;   
    }   
    public void setRecordCount(int recordCount) {   
        this.recordCount = recordCount;   
    }   
}