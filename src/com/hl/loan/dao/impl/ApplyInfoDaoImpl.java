package com.hl.loan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hl.loan.dao.ApplyInfoDao;
import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.pojo.City;
import com.hl.loan.pojo.ComLp;
import com.hl.loan.pojo.Company;
import com.hl.loan.pojo.CustomerCompany;
import com.hl.loan.pojo.CustomerFance;
import com.hl.loan.pojo.NoteAndUser;
import com.hl.loan.pojo.Product;
import com.hl.loan.pojo.SysDept;
import com.hl.loan.util.PageModel;

@Repository
public class ApplyInfoDaoImpl extends BaseDaoImpl<ApplyInfo> implements ApplyInfoDao {

	@Override
	public PageModel<ApplyInfo> showApplyInfo(PageModel<ApplyInfo> pm, ApplyInfo applyInfo) {
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		StringBuffer hql = new StringBuffer("from ApplyInfo where 1=1");
		List ulist = new ArrayList();
		if (applyInfo != null) {
			if (applyInfo.getApplyCode() != null
					&& !applyInfo.getApplyCode().equals("")) {
				ulist.add(applyInfo.getApplyCode());
				hql.append(" and applyCode=?");
			}
			if(applyInfo.getStatus()!=null && applyInfo.getStatus()!=0){
				ulist.add(applyInfo.getStatus());
				hql.append(" and status=?");
			}
			if(applyInfo.getuName()!=null && !applyInfo.getuName().equals("")){
				hql.append(" and uName like :uName");
			}
			if(applyInfo.getProjectName()!=null && applyInfo.getProjectName().trim().length()>0){
				hql.append(" and projectName like :ProjectName");
			}
		}
		hql.append(" order by ApplyID desc ");
		Query query = this.getSession().createQuery(hql.toString()).setFirstResult(startNumber).setMaxResults(size);
		Query querys = this.getSession().createQuery(hql.toString());
		if (ulist != null && ulist.size() > 0) {
			for (int i = 0; i < ulist.size(); i++) {
				query.setParameter(i, ulist.get(i));
				querys.setParameter(i, ulist.get(i));
			}
		}
		if (applyInfo != null) {
			if(applyInfo.getuName()!=null && applyInfo.getuName().trim().length()>0){
				query.setParameter("uName", "%"+applyInfo.getuName()+"%");
				querys.setParameter("uName", "%"+applyInfo.getuName()+"%");
			}
			if(applyInfo.getProjectName()!=null && applyInfo.getProjectName().trim().length()>0){
				query.setParameter("uName", "%"+applyInfo.getuName()+"%");
				querys.setParameter("projectName", "%"+applyInfo.getProjectName()+"%");
			}
		}
		List<ApplyInfo> list = query.list();
		int countSum = querys.list().size();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(countSum);
		return pm;
	}

	@Override
	public Long savaAppply(ApplyInfo applyInfo) {
		this.persit(applyInfo);
		Long applyID = applyInfo.getApplyID();
		return applyID;
	}

	@Override
	public void updateAppply(ApplyInfo applyInfo) {
		this.update(applyInfo);
	}

	@Override
	public void addAppplyInfo(ApplyInfo applyInfo) {
		this.getHibernateTemplate().persist(applyInfo);
	}

	@Override
	public ApplyInfo load(String applyID) {
		return (ApplyInfo) this.getHibernateTemplate().get(ApplyInfo.class, Long.parseLong(applyID));
	}

	@Override
	public int delApplyInfo(String applyID) {
		Query query = this.getSession().createQuery("update ApplyInfo set Status=10 where 1=1 and ApplyID=?");
		query.setParameter(0, applyID);
		return query.executeUpdate();
	}
	//得到需要审批流程
	@Override
	public PageModel<ApplyInfo> showApplyOaInfo(PageModel<ApplyInfo> pm,List<NoteAndUser> ntlist,int userId,ApplyInfo applyInfo){
		int size = pm.getPageSize();
		int pageno = (pm.getPageNo() - 1) * size;
		String strStatus="";
		for (NoteAndUser nt : ntlist) {
			String status=nt.getStatus()+",";
			strStatus=strStatus+status;
		}
		List ulist = new ArrayList();
		strStatus=strStatus+"0";
		//System.out.println(strStatus);
		//查看次状态下的所有审批
		StringBuffer hql =new StringBuffer("from ApplyInfo where (status in("+strStatus+") or (firstUserId=? and status=9))  ");
		if (applyInfo != null) {
			if (applyInfo.getApplyCode() != null
					&& !applyInfo.getApplyCode().equals("")) {
				ulist.add(applyInfo.getApplyCode());
				hql.append(" and applyCode=?");
			}
			if(applyInfo.getStatus()!=null && applyInfo.getStatus()!=0){
				ulist.add(applyInfo.getStatus());
				hql.append(" and status=?");
			}
			if(applyInfo.getuName()!=null && applyInfo.getuName().trim().length()>0){
				hql.append(" and uName like :uName");
			}
			if(applyInfo.getProjectName()!=null && applyInfo.getProjectName().trim().length()>0){
				hql.append(" and projectName like :ProjectName");
			}
		}
		Query query=this.getSession().createQuery(hql.toString());
		//query.setParameter(0, strStatus);
		query.setParameter(0, userId);
		if (ulist != null && ulist.size() > 0) {
			for (int i = 0; i < ulist.size(); i++) {
				query.setParameter(i+1, ulist.get(i));
			}
		}
		if (applyInfo != null) {
			if(applyInfo.getuName()!=null && applyInfo.getuName().trim().length()>0){
				query.setParameter("uName", "%"+applyInfo.getuName()+"%");
			}
			if(applyInfo.getProjectName()!=null && applyInfo.getProjectName().trim().length()>0){
				query.setParameter("uName", "%"+applyInfo.getuName()+"%");
			}
		}
		int count=query.list().size();
		query.setFirstResult(pageno);
		query.setMaxResults(size);
		List<ApplyInfo> list=query.list();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(count);
		return pm;
	}
	//查看所有自己审批
	@Override
	public List<ApplyInfo> getAllMyOa(List<NoteAndUser> ntlist,int userId,ApplyInfo applyInfo){
		String strStatus="";
		List ulist = new ArrayList();
		for (NoteAndUser nt : ntlist) {
			String status=nt.getStatus()+",";
			strStatus=strStatus+status;
		}
		strStatus=strStatus+"0";
		//System.out.println(strStatus);
		//查看次状态下的所有审批
		StringBuffer hql =new StringBuffer("from ApplyInfo where (status in("+strStatus+") or (firstUserId=? and status=9)) ");
		if (applyInfo != null) {
			if (applyInfo.getApplyCode() != null
					&& !applyInfo.getApplyCode().equals("")) {
				ulist.add(applyInfo.getApplyCode());
				hql.append(" and applyCode=?");
			}
			if(applyInfo.getStatus()!=null && applyInfo.getStatus()!=0){
				ulist.add(applyInfo.getStatus());
				hql.append(" and status=?");
			}
			if(applyInfo.getuName()!=null && applyInfo.getuName().trim().length()>0){
				hql.append(" and uName like :uName");
			}
			if(applyInfo.getProjectName()!=null && applyInfo.getProjectName().trim().length()>0){
				hql.append(" and projectName like :ProjectName");
			}
		}
		Query query=this.getSession().createQuery(hql.toString());
		//query.setParameter(0, strStatus);
		query.setParameter(0, userId);
		if (ulist != null && ulist.size() > 0) {
			for (int i = 0; i < ulist.size(); i++) {
				query.setParameter(i+1, ulist.get(i));
			}
		}
		if (applyInfo != null) {
			if(applyInfo.getuName()!=null && applyInfo.getuName().trim().length()>0){
				query.setParameter("uName", "%"+applyInfo.getuName()+"%");
			}
			if(applyInfo.getProjectName()!=null && applyInfo.getProjectName().trim().length()>0){
				query.setParameter("uName", "%"+applyInfo.getuName()+"%");
			}
		}
		List<ApplyInfo> list=query.list();
		return list;
		
	}

	@Override
	public Company getCompanyByApplyID(Long CompanyID) {
		return (Company) this.getHibernateTemplate().get(Company.class, CompanyID);
	}

	@Override
	public City getCityByCityID(Long CityID) {
		
		Query query=this.getSession().createQuery(" from City where ID=?");
		City city=(City) query.setParameter(0, CityID).uniqueResult();
		return city;
	}

	@Override
	public ComLp getComLpByApplyID(Long LpID) {
		return (ComLp) this.getHibernateTemplate().get(ComLp.class, LpID);
	}

	@Override
	public Product getProductByProductID(Long ProductID) {
		return (Product) this.getHibernateTemplate().get(Product.class, ProductID);
	}
	
	
}








