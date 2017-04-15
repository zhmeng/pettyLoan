package com.hl.loan.service;

import java.util.Date;

import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.util.PageModel;

public interface SendLoanService {

	public PageModel<ApplyInfo> getApplyInfoList( PageModel<ApplyInfo> pm,ApplyInfo applyInfo);
	
	public void confSendApplyLoan(String applyID,Date sendDate);
}
