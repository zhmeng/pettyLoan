package com.hl.loan.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hl.loan.dao.APPLYCustInfoDao;
import com.hl.loan.pojo.APPLYCustInfo;
import com.hl.loan.service.APPLYCustInfoService;

@Service("aPPLYCustInfoService")
public class APPLYCustInfoServiceImpl implements APPLYCustInfoService {
	@Resource
	private APPLYCustInfoDao aPPLYCustInfoDao;

	@Override
	public Long saveAppplyCust(APPLYCustInfo applyCust) {
		return aPPLYCustInfoDao.saveAppplyCust(applyCust);
	}

	
	
	@Override
	public void updateAppplyCust(APPLYCustInfo apply) {
		aPPLYCustInfoDao.updateAppplyCust(apply);
	}
	
	@Override
	public APPLYCustInfo getCustInfoByAplyID(Long applyID) {
		return aPPLYCustInfoDao.getCustInfoByAplyID(applyID);
	}
}
