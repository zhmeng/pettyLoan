package com.hl.loan.service;

import java.util.List;

import com.hl.loan.pojo.CustomerLoan;

public interface CustomerLoanService {

	public Long saveLoan(CustomerLoan loan);
	public void updateLoan(CustomerLoan loan);
	public void delLoan(CustomerLoan loan);
	public List<CustomerLoan> getListLoan(Long custID);
}
