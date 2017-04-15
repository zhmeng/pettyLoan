package com.hl.loan.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hl.loan.dao.CustomerLoanDao;
import com.hl.loan.pojo.CustomerLoan;

@Repository
public class CustomerLoanDaoImpl extends BaseDaoImpl<CustomerLoan> implements CustomerLoanDao{
	@Override
	public Long saveLoan(CustomerLoan loan){
		//this.save(loan);
		//this.getHibernateTemplate().persist(loan);
		this.persit(loan);
		Long lid=loan.getId();
		return lid;
	}
	@Override
	public void updateLoan(CustomerLoan loan){
		this.update(loan);
	}
	@Override
	public void delLoan(CustomerLoan loan){
		this.delete(loan);
	}
	@Override
	public List<CustomerLoan> getListLoan(Long custID){
		String sql="from CustomerLoan where custID=?";
		Query query=this.getSession().createQuery(sql);
		query.setParameter(0, custID);
		return query.list();
	}
}




