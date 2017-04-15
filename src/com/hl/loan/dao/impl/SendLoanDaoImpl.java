package com.hl.loan.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hl.loan.dao.SendLoanDao;
import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.util.PageModel;

@Repository
public class SendLoanDaoImpl extends BaseDaoImpl implements SendLoanDao {

	@Override
	public PageModel<ApplyInfo> getApplyInfoList(PageModel<ApplyInfo> pm,
			ApplyInfo applyInfo) {
		//获取代发放
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		StringBuffer hql = new StringBuffer("from ApplyInfo info where 1=1 and info.status=402");
	
		if (applyInfo != null) {
			if (applyInfo.getApplyCode()!= null && !applyInfo.getApplyCode().equals("")) {
				
				hql.append(" and info.applyCode like '%"+applyInfo.getApplyCode()+"%'");
			}
		
		}
		Query query = this.getSession().createQuery(hql.toString()).setFirstResult(startNumber).setMaxResults(size);
		Query querys = this.getSession().createQuery(hql.toString());

		List<ApplyInfo> list = query.list();
		int countSum = querys.list().size();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(countSum);
		return pm;
	}

	@Override
	public void confSendApplyLoan(String applyID, Date sendDate) {
		ApplyInfo applyInfo=(ApplyInfo) this.getSession().get(ApplyInfo.class, Long.parseLong(applyID));
		if(applyInfo!=null){
			applyInfo.setSendDate(sendDate);
			applyInfo.setStatus(5);
		}
		
		
	}

}
