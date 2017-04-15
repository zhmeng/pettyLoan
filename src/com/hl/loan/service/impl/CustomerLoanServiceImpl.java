package com.hl.loan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hl.loan.dao.CustomerLoanDao;
import com.hl.loan.pojo.CustomerLoan;
import com.hl.loan.service.CustomerLoanService;

@Service("customerLoanService")
public class CustomerLoanServiceImpl implements CustomerLoanService{
	@Resource
	private CustomerLoanDao customerLoanDao;
	@Override
	public Long saveLoan(CustomerLoan loan){
		return customerLoanDao.saveLoan(loan);
	}
	@Override
	public void updateLoan(CustomerLoan loan) {
		// TODO Auto-generated method stub
		customerLoanDao.updateLoan(loan);
	}
	@Override
	public void delLoan(CustomerLoan loan){
		customerLoanDao.delLoan(loan);
	}
	@Override
	public List<CustomerLoan> getListLoan(Long custID){
		return customerLoanDao.getListLoan(custID);
	}
}
