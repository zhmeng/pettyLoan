package com.hl.loan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.loan.dao.CollectLoanDao;
import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.pojo.CollectLoanInfo;
import com.hl.loan.service.CollectLoanService;
import com.hl.loan.util.PageModel;

@Service("collectLoanService")
public class CollectLoanServiceImpl implements CollectLoanService {
	
	@Autowired
	private CollectLoanDao collectLoanDao;

	@Override
	public PageModel<ApplyInfo> getApplyInfoList(PageModel<ApplyInfo> pm,ApplyInfo applyInfo) {
		// TODO Auto-generated method stub
		return collectLoanDao.getApplyInfoList(pm,applyInfo);
	}

	public CollectLoanDao getCollectLoanDao() {
		return collectLoanDao;
	}

	public void setCollectLoanDao(CollectLoanDao collectLoanDao) {
		this.collectLoanDao = collectLoanDao;
	}

	@Override
	public boolean addCollectLoanInfo(CollectLoanInfo collectLoanInfo) {
		// TODO Auto-generated method stub
		return collectLoanDao.addCollectLoanInfo(collectLoanInfo);
	}

}
