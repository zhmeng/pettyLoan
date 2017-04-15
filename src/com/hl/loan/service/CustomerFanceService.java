package com.hl.loan.service;

import com.hl.loan.pojo.CustomerFance;

public interface CustomerFanceService {

	public Long saveFance(CustomerFance fance);
	public void updateFance( CustomerFance fance);
	
	public CustomerFance getCustomerFanceByAplyID(Long applyID);//根据applyid得到fance信息
}
