package com.hl.loan.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.hl.loan.dao.APPLYCustInfoDao;
import com.hl.loan.pojo.APPLYCustInfo;

@Repository
public class APPLYCustInfoDaoImpl extends BaseDaoImpl<APPLYCustInfo> implements APPLYCustInfoDao {
	// 保存基本信息
	@Override
	public Long saveAppplyCust(APPLYCustInfo apply) {
		// this.save(apply);
		// this.getHibernateTemplate().persist(apply);
		this.persit(apply);
		Long custID = apply.getApplyID();
		return custID;
	}

	// 修改
	@Override
	public void updateAppplyCust(APPLYCustInfo apply) {
		this.update(apply);
	}
	
	@Override
	public APPLYCustInfo getCustInfoByAplyID(Long applyID) {
		Query query=this.getSession().createQuery(" from APPLYCustInfo where ApplyID=?");
		APPLYCustInfo applyCustInfo=(APPLYCustInfo) query.setParameter(0, applyID).uniqueResult();
		return applyCustInfo;
	}
}
