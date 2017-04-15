package com.hl.loan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hl.loan.dao.CustomerFanceDao;
import com.hl.loan.pojo.CustomerFance;
import com.hl.loan.service.CustomerFanceService;

@Service("customerFanceService")
public class CustomerFanceServiceImpl implements CustomerFanceService{
	@Resource
	private CustomerFanceDao customerFanceDao;
	@Override
	public Long saveFance( CustomerFance fance){
		return customerFanceDao.saveFance(fance);
	}
	@Override
	public void updateFance(CustomerFance fance) {
		// TODO Auto-generated method stub
		customerFanceDao.updateFance(fance);
	}
	@Override
	public CustomerFance getCustomerFanceByAplyID(Long applyCustID) {
		return customerFanceDao.getCustomerFanceByAplyID(applyCustID);
	}
	
}
