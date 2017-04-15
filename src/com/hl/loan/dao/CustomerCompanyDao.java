package com.hl.loan.dao;

import com.hl.loan.pojo.CustomerCompany;

public interface CustomerCompanyDao extends BaseDao<CustomerCompany>{

	public Long saveCompany(CustomerCompany company);

	public void updateCompany(CustomerCompany company);
	
	public CustomerCompany getCustomerCompanyByAplyID(Long applyID);//根据applyid得到company信息

}
