package com.hl.loan.dao;

import com.hl.loan.pojo.APPLYCustInfo;

public interface APPLYCustInfoDao extends BaseDao<APPLYCustInfo>{

	public Long saveAppplyCust(APPLYCustInfo apply);

	public void updateAppplyCust(APPLYCustInfo apply);
	
	public APPLYCustInfo getCustInfoByAplyID(Long applyID);
}
