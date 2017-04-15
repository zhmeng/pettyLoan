package com.hl.loan.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hl.loan.dao.CollectLoanDao;
import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.pojo.CollectLoanInfo;
import com.hl.loan.pojo.ShouldRepayInfo;
import com.hl.loan.util.PageModel;

@Repository
public class CollectLoanDaoImpl  extends BaseDaoImpl implements CollectLoanDao {

	
	public PageModel<ApplyInfo> getApplyInfoList(PageModel<ApplyInfo> pm, ApplyInfo applyInfo ) {
		
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		StringBuffer hql = new StringBuffer("from ApplyInfo info where 1=1 and info.status=401");
	
		if (applyInfo != null) {
			if (applyInfo.getApplyCode()!= null && !applyInfo.getApplyCode().equals("")) {
				
				hql.append(" and info.applyCode like '%"+applyInfo.getApplyCode()+"%'");
			}
        if (applyInfo.getApplyDateStart()!= null && !applyInfo.getApplyDateStart().equals("")) {
				
				hql.append(" and info.ApplyDate >='"+applyInfo.getApplyDateStart()+"'" );
			}
        if (applyInfo.getApplyDateEnd()!= null && !applyInfo.getApplyDateEnd().equals("")) {
			
			hql.append(" and info.ApplyDate <='"+applyInfo.getApplyDateEnd()+" "+"23:59"+"'");
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
	public boolean addCollectLoanInfo(CollectLoanInfo collectLoanInfo) {
		boolean flage=true;
		ApplyInfo applyInfo=(ApplyInfo) this.getSession().get(ApplyInfo.class, collectLoanInfo.getApplyID());
		try{
		if(applyInfo!=null){
			applyInfo.setStatus(402);
			//updateShouldRepayInfo(applyInfo);
		}else{
			return false;
		}
		 this.getSession().save(collectLoanInfo);
		}catch(Exception e){
			flage=false;
			e.printStackTrace();
		}
		return flage;
	}
	/**
	 * 修改应还表确定还款状态
	 * @param applyInfo
	 */
  private void updateShouldRepayInfo(ApplyInfo applyInfo){
	  String hql="from  ShouldRepayInfo inf where inf.applyID="+applyInfo.getApplyID()+"and inf.loanTime=0";
	  ShouldRepayInfo shouldRepayInfo= (ShouldRepayInfo) this.getSession().createQuery(hql).uniqueResult();
	  shouldRepayInfo.setStyle(1);
	  this.getSession().saveOrUpdate(shouldRepayInfo);

  }

}
