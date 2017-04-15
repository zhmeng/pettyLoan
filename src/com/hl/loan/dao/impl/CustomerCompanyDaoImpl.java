package com.hl.loan.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hl.loan.dao.CustomerCompanyDao;
import com.hl.loan.pojo.CustomerCompany;
import com.hl.loan.pojo.CustomerFance;
@Repository
public class CustomerCompanyDaoImpl extends BaseDaoImpl<CustomerCompany> implements CustomerCompanyDao{
	@Override
	public Long saveCompany(CustomerCompany company){
		//this.save(company);
		//this.getHibernateTemplate().persist(company);
		this.persit(company);
		Long cid=company.getId();
		return cid;
	}
	//修改
	@Override
	public void updateCompany(CustomerCompany company){
		this.update(company);
	}
	@Override
	public CustomerCompany getCustomerCompanyByAplyID(Long applyID) {
		//return (CustomerCompany) this.getHibernateTemplate().get(CustomerCompany.class, applyID);
		Query query=this.getSession().createQuery(" from CustomerCompany where custID=?");
		CustomerCompany customerCompany=(CustomerCompany) query.setParameter(0, applyID).uniqueResult();
		return customerCompany;
	}
}
