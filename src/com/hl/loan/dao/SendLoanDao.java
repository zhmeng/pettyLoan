package com.hl.loan.dao;

import java.util.Date;

import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.util.PageModel;

public interface SendLoanDao {

	public PageModel<ApplyInfo> getApplyInfoList( PageModel<ApplyInfo> pm,ApplyInfo applyInfo);
	
	public void confSendApplyLoan(String applyID,Date sendDate);
}
