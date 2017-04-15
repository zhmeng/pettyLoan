package com.hl.loan.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hl.loan.dao.CustomerFanceDao;
import com.hl.loan.pojo.APPLYCustInfo;
import com.hl.loan.pojo.Company;
import com.hl.loan.pojo.CustomerFance;

@Repository
public class CustomerFanceDaoImpl extends BaseDaoImpl<CustomerFance> implements CustomerFanceDao{
	@Override
	public Long saveFance( CustomerFance fance){
		//this.save(fance);
		//this.getHibernateTemplate().persist(fance);
		this.persit(fance);
		Long fid=fance.getId();
		return fid;
	}
	//修改
	@Override
	public void updateFance( CustomerFance fance){
		this.update(fance);
	}
	@Override
	public CustomerFance getCustomerFanceByAplyID(Long applyCustID) {
		//return (CustomerFance) this.getHibernateTemplate().get(CustomerFance.class, applyID);
		Query query=this.getSession().createQuery(" from CustomerFance where custID=?");
		CustomerFance customerFance=(CustomerFance) query.setParameter(0, applyCustID).uniqueResult();
		return customerFance;
	}
}
