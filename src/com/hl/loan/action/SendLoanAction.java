package com.hl.loan.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.service.ApplyInfoService;
import com.hl.loan.service.CollectLoanService;
import com.hl.loan.service.SendLoanService;
import com.hl.loan.util.PageModel;
import com.hl.loan.vi.Buttons;

@Namespace("/action/send")
@ResultPath("/")
public class SendLoanAction extends BaseAction {
	
	@Autowired
	private SendLoanService sendLoanService;
	private PageModel<ApplyInfo> pm;
	private ApplyInfo applyInfo;

	@Action(value="goSendList", results={
			@Result(name="success",location="/send/sendLoanInfo_List.jsp")
	})
	public String goSendList(){
        List<Buttons> blist=this.getUrlRight(1);//权限控制
		
		ApplyInfo applyInfo=getApplyInfo();
		PageModel<ApplyInfo> pm = new PageModel<>();
		if (getPm() != null) {
			pm = getPm();
		}
		pm=sendLoanService.getApplyInfoList(pm,applyInfo);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("blist", blist);
		return "success";
	}

	@Action(value="confSendApplyLoan")
	public void confSendApplyLoan() {
        //this.getUrlRight(512);//权限控制
		String applyID=this.getRequest().getParameter("applyID");
		String sendDate=this.getRequest().getParameter("sendDate");
		SimpleDateFormat spmt=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		try{
		Date sendDate2=spmt.parse(sendDate);
		sendLoanService.confSendApplyLoan(applyID, sendDate2);
		writeResult(true, "放款成功!", this.getResponse());
		}catch(Exception e){
		 e.printStackTrace();
		}
		
	
	}
	public SendLoanService getSendLoanService() {
		return sendLoanService;
	}

	public void setSendLoanService(SendLoanService sendLoanService) {
		this.sendLoanService = sendLoanService;
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
	
	
}
