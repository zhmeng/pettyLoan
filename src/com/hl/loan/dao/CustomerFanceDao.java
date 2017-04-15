package com.hl.loan.dao;

import com.hl.loan.dao.impl.BaseDaoImpl;
import com.hl.loan.pojo.CustomerFance;

public interface CustomerFanceDao extends BaseDao<CustomerFance>{

	public Long saveFance(CustomerFance fance);

	public void updateFance(CustomerFance fance);
	
	public CustomerFance getCustomerFanceByAplyID(Long applyID);//根据applyID得到fance信息

}
