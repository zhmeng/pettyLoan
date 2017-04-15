package com.hl.loan.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author MingJun_Guo
 * @Mail:guomingjun1990@126.com
 * @创建日期：2014年2月25日 上午9:19:41
 * 
 * @类说明：页面分页tag实体类
 */
public class Pager extends TagSupport {

	private static final long serialVersionUID = -2613705016796991725L;
	private Integer curPage;
	private Integer totalPage;
	private Integer pageSize = 10;// 后续系统参数配置
	private Integer totalCount = 0;

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();

		int pageNumber = 0;
		if (totalPage % pageSize == 0) {
			pageNumber = totalPage / pageSize;
		} else {
			pageNumber = (totalPage / pageSize) + 1;
		}
		if (curPage < 1) {
			curPage = 1;
		}

		try {
			if (pageNumber > 0) {
				
				out.print("<div class=\"pagination\"><ul>");
				int start = 1;
				int end = totalPage;
				for (int i = 4; i >= 1; i--) {
					if ((curPage - i) >= 1) {
						start = curPage - i;
						break;
					}
				}
				for (int i = 4; i >= 1; i--) {
					if ((curPage + i) <= totalPage) {
						end = curPage + i;
						break;
					}
				}
				// 如果小于9则右侧补齐
				if (end - start + 1 <= 9) {
					Integer padLen = 9 - (end - start + 1);
					for (int i = padLen; i >= 1; i--) {
						if ((end + i) <= totalPage) {
							end = end + i;
							break;
						}
					}
				}

				// 如果还小于9左侧补齐
				if (end - start + 1 <= 9) {
					Integer padLen = 9 - (end - start + 1);
					for (int i = padLen; i >= 1; i--) {
						if ((start - i) >= 1) {
							start = start - i;
							break;
						}
					}
				}

				if (curPage > 1) {
					if (start >= 1) {
						out.print("<a href='javascript:goPage(1)' class=\"pagebtn\">首页</a>");
					}
					out.print("<a href='javascript:goPage(" + (curPage - 1)
							+ ")' class=\"pagebtn\">上一页</a>");
				}

				if (end > start) {
					out.print("<div class=\"page_num\">");
				}
				for (int i = start; i <= end; i++) {
					if (i == curPage) {
						if(curPage!=end){
							out.print("<a href='javascript:void(0);' class='page_cur'>" + i + "</a>");
						}
						if(i!=end){
							out.print("<span>|</span>");
						}else if(i==end && i != 1){
							out.print("<a href='javascript:void(0);' class='page_cur'>" + i + "</a>");
						}
					} else {
						if(i==end){
							out.print("<a href='javascript:goPage(" + i + ")'>" + i + "</a>");
						}else{
							out.print("<a href='javascript:goPage(" + i + ")'>" + i + "</a>");
							out.print("<span>|</span>");
						}
					}
				}
				if (end > start) {
					out.print("</div>");
				}
				if (curPage < totalPage) {
					out.print("<a href='javascript:goPage(" + (curPage + 1)+ ")' class='pagebtn'>下一页</a>");
					if (end <= totalPage) {
						out.print("<a href='javascript:goPage(" + totalPage + ")' class='pagebtn'>尾页</a>");
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.doStartTag();

	}

	public static Integer getStartIndex(Integer pageNum, Integer pageSize) {
		Integer res = 0;
		if (pageNum > 0) {
			res = (pageNum - 1) * pageSize;
		}
		return res;
	}

}
