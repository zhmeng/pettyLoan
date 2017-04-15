package com.hl.loan.dao;

import java.util.List;

import com.hl.loan.pojo.CustomerLoan;

public interface CustomerLoanDao extends BaseDao<CustomerLoan>{

	public Long saveLoan(CustomerLoan loan);

	public void updateLoan(CustomerLoan loan);

	public void delLoan(CustomerLoan loan);

	public List<CustomerLoan> getListLoan(Long custID);

}
