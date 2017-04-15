package com.hl.loan.service;

import java.util.List;

import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.pojo.CollectLoanInfo;
import com.hl.loan.util.PageModel;

public interface CollectLoanService {
	
	public PageModel<ApplyInfo> getApplyInfoList( PageModel<ApplyInfo> pm,ApplyInfo applyInfo);
	
	public boolean addCollectLoanInfo(CollectLoanInfo collectLoanInfo);

}
