package com.hl.loan.dao;

import java.util.List;

import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.pojo.CollectLoanInfo;
import com.hl.loan.util.PageModel;


public interface CollectLoanDao extends BaseDao{
	
	public PageModel<ApplyInfo> getApplyInfoList(PageModel<ApplyInfo> pm,ApplyInfo applyInfo);
	
	public boolean addCollectLoanInfo(CollectLoanInfo collectLoanInfo);

}
