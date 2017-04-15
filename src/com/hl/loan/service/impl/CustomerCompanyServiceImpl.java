package com.hl.loan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hl.loan.dao.CustomerCompanyDao;
import com.hl.loan.pojo.CustomerCompany;
import com.hl.loan.service.CustomerCompanyService;

@Service("customerCompanyService")
public class CustomerCompanyServiceImpl implements CustomerCompanyService{
	@Resource
	private CustomerCompanyDao customerCompanyDao; 
	@Override
	public Long saveCompany(CustomerCompany company){
		return customerCompanyDao.saveCompany(company);
	}
	@Override
	public void updateCompany(CustomerCompany company){
		customerCompanyDao.update(company);
	}
	@Override
	public CustomerCompany getCustomerCompanyByAplyID(Long applyID) {
		return customerCompanyDao.getCustomerCompanyByAplyID(applyID);
	}
}
