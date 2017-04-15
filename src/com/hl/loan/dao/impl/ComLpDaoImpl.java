package com.hl.loan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hl.loan.dao.ComLpDao;
import com.hl.loan.pojo.ComLp;
import com.hl.loan.util.PageModel;

import org.hibernate.Query;

@SuppressWarnings("unchecked")
@Repository
public class ComLpDaoImpl extends BaseDaoImpl<ComLp> implements ComLpDao {

	@Override
	public PageModel<ComLp> showComLp(PageModel<ComLp> pm, ComLp comLp) {
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		StringBuffer hql = new StringBuffer("from ComLp where 1=1 and lpState!=4");
		List ulist = new ArrayList();
		if (comLp != null) {
			if (comLp.getLpKey() != null && !comLp.getLpKey().equals("")) {
				ulist.add(comLp.getLpKey());
				hql.append(" and lpKey=?");
			}

			if (comLp.getLpName() != null && !comLp.getLpName().equals("")) {
				hql.append(" and lpName like :lpName");
			}
		}
		Query query = this.getSession().createQuery(hql.toString()).setFirstResult(startNumber).setMaxResults(size);
		Query querys = this.getSession().createQuery(hql.toString());
		if (ulist != null && ulist.size() > 0) {
			for (int i = 0; i < ulist.size(); i++) {
				query.setParameter(i, ulist.get(i));
				querys.setParameter(i, ulist.get(i));
			}
		}
		if (comLp != null) {
			if (comLp.getLpName() != null && !comLp.getLpName().equals("")) {
				query.setParameter("lpName", "%" + comLp.getLpName() + "%");
				querys.setParameter("lpName", "%" + comLp.getLpName() + "%");
			}
		}
		List<ComLp> list = query.list();
		int countSum = querys.list().size();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(countSum);
		return pm;
	}

	@Override
	public void addComLp(ComLp comLp) {
		this.getHibernateTemplate().persist(comLp);
	}

	@Override
	public int delComLp(String lpID) {
		Query query = this.getSession().createQuery("update ComLp set LpState=4 where 1=1 and LpID=?");
		query.setParameter(0, lpID);
		return query.executeUpdate();
	}

	@Override
	public List<ComLp> getComLpByID(String lpID) {
		Query query = this.getSession().createQuery(" from ComLp where 1=1 and LpID=?");
		query.setParameter(0, lpID);
		return query.list();
	}

	@Override
	public int updateComLpByID(String lpID, ComLp comLp) {
		this.getSession().saveOrUpdate(lpID, comLp);
		return 1;
	}

	public ComLp load(String lpID) {
		return (ComLp) this.getHibernateTemplate().get(ComLp.class, Long.parseLong(lpID));
	}

	@Override
	public List<ComLp> getAllLp() {
		return this.getHibernateTemplate().find(" from ComLp");
	}

	@Override
	public List<ComLp> getAllLnapByCityID(Long cityID) {
		Query query = this.getSession().createQuery(" from ComLp where 1=1 and cityID=? and lpState = 1");
		query.setParameter(0, cityID);
		return query.list();
	}
}