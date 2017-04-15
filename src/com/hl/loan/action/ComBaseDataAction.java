package com.hl.loan.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.ComBaseData;
import com.hl.loan.service.ComBaseDataDaoService;
import com.hl.loan.util.PageModel;
import com.hl.loan.vi.Buttons;

@Namespace("/action/comBase")
@ResultPath("/")
public class ComBaseDataAction extends BaseAction{
	@Autowired
	private ComBaseDataDaoService comBaseDataDaoService;
	
	private PageModel<ComBaseData> pm;
	private ComBaseData cbd;
	public ComBaseData getCbd() {
		return cbd;
	}
	public void setCbd(ComBaseData cbd) {
		this.cbd = cbd;
	}
	public PageModel getPm() {
		return pm;
	}
	public void setPm(PageModel pm) {
		this.pm = pm;
	}
	@Action(value="showBase", results={
			@Result(name="success",location="/SYS/number/showBase.jsp")
	})
	public String showBase() throws IOException{
		//returnPopupMessage("<script type='text/javascript'>alert('保存成功!');</script>");
		List<Buttons> blist=this.getUrlRight(1);					//判断有没有权限
		if(blist==null || blist.size()==0){
			return null;
		}
		ComBaseData cbd=new ComBaseData();
		if(getCbd()!=null){
			cbd=getCbd();
		}
		PageModel<ComBaseData> pm=new PageModel<>();
		if(getPm()!=null){
			pm=getPm();
		}
		pm=comBaseDataDaoService.showBase(pm, cbd);
		this.getRequest().setAttribute("blist", blist);
		this.pm=pm;
		this.cbd=cbd;
		return SUCCESS;
	}

}




