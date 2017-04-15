package com.hl.loan.service;

import com.hl.loan.pojo.APPLYCustInfo;

public interface APPLYCustInfoService {

	public Long saveAppplyCust(APPLYCustInfo apply);

	public void updateAppplyCust(APPLYCustInfo apply);
	
	public APPLYCustInfo getCustInfoByAplyID(Long applyID);
	
}
