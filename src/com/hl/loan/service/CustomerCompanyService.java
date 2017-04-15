package com.hl.loan.service;

import com.hl.loan.pojo.CustomerCompany;
import com.hl.loan.pojo.CustomerFance;

public interface CustomerCompanyService {

	public Long saveCompany(CustomerCompany company);

	public void updateCompany(CustomerCompany company);

	public CustomerCompany getCustomerCompanyByAplyID(Long applyID);//根据applyid得到company信息
}
