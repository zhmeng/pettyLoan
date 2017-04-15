package com.hl.loan.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.hibernate.dialect.IngresDialect;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.pojo.CollectLoanInfo;
import com.hl.loan.pojo.ComLp;
import com.hl.loan.service.ApplyInfoService;
import com.hl.loan.service.CollectLoanService;
import com.hl.loan.util.PageModel;
import com.hl.loan.vi.Buttons;



@Namespace("/action/collect")
@ResultPath("/")
public class CollectLoanAction extends BaseAction {
	
	@Autowired
	private CollectLoanService collectLoanService;
	
	@Autowired
	private ApplyInfoService applyInfoService;
	
	private PageModel<ApplyInfo> pm;
	private ApplyInfo applyInfo;
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value = "goCollectList", results = { @Result(name = "success", location = "/collect/collectLoanInfo_List.jsp") })
	public String goCollectList(){
		List<Buttons> blist=this.getUrlRight(1);//权限控制
		
		ApplyInfo applyInfo=getApplyInfo();
		PageModel<ApplyInfo> pm = new PageModel<ApplyInfo>();
		if (getPm() != null) {
			pm = getPm();
		}
		pm=collectLoanService.getApplyInfoList(pm,applyInfo);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("blist", blist);
		return "success";
		
	}
	@Action(value = "toConfCollectapplyLoan", results = { @Result(name = "success", location = "/collect/ConfCollectApplyLoan.jsp") })
	public String toConfCollectapplyLoan(){
		//this.getUrlRight(1)//判断权限
		String applyID=this.getRequest().getParameter("applyID");
		ApplyInfo applyInfo=null;
		if(applyID!=null&&!"".equals(applyID)){
			applyInfo= applyInfoService.getApplyInfoByID(applyID);
		}
		this.getRequest().setAttribute("applyInfo", applyInfo);
		return "success";
	}
	
	
	@Action(value = "confCollectApplyLoan")
	public void confCollectApplyLoan(){
		boolean falge=true;
		//this.getUrlRight(256);
		String applyID=this.getRequest().getParameter("applyID");
		String applyCode=this.getRequest().getParameter("applyCode");
		String loanTime=this.getRequest().getParameter("loanTime");
		String collectLoanDate=this.getRequest().getParameter("collectLoanDate");
		Double collectLoanInterest=Double.parseDouble(this.getRequest().getParameter("collectLoanInterest")==null||"".equals(this.getRequest().getParameter("collectLoanInterest"))?"0.00":this.getRequest().getParameter("collectLoanInterest"));
		
		CollectLoanInfo collectLoanInfo=new CollectLoanInfo();
	
		collectLoanInfo.setApplyID(Long.parseLong(applyID));
		collectLoanInfo.setApplyCode(applyCode);
		collectLoanInfo.setLoanTime(Integer.parseInt(loanTime==null||"".equals(loanTime)?"0":loanTime));
		collectLoanInfo.setCollectLoanDate(collectLoanDate);
		collectLoanInfo.setCollectLoanInterest(BigDecimal.valueOf(collectLoanInterest));
		collectLoanInfo.setStatus(1);//费用标示
		falge=collectLoanService.addCollectLoanInfo(collectLoanInfo);
		
		try {
				if(falge){
				writeResult(true, "收款成功！", this.getResponse());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public CollectLoanService getCollectLoanService() {
		return collectLoanService;
	}

	public void setCollectLoanService(CollectLoanService collectLoanService) {
		this.collectLoanService = collectLoanService;
	}
	
	
	public PageModel<ApplyInfo> getPm() {
		return pm;
	}

	public void setPm(PageModel<ApplyInfo> pm) {
		this.pm = pm;
	}

	public ApplyInfo getApplyInfo() {
		return applyInfo;
	}

	public void setApplyInfo(ApplyInfo applyInfo) {
		this.applyInfo = applyInfo;
	}
	public ApplyInfoService getApplyInfoService() {
		return applyInfoService;
	}
	public void setApplyInfoService(ApplyInfoService applyInfoService) {
		this.applyInfoService = applyInfoService;
	}

}
