package com.hl.loan.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.hl.loan.dao.DeptDao;
import com.hl.loan.pojo.SysDept;
import com.hl.loan.util.PageModel;
import org.hibernate.Query;

@Repository
public class DeptDaoImpl extends BaseDaoImpl<SysDept> implements DeptDao {

	@Override
	public PageModel<SysDept> showDept(PageModel<SysDept> pm, SysDept dept) {
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		StringBuffer hql = new StringBuffer("from SysDept where 1=1 and deptState=0");
		List ulist = new ArrayList();
		if (dept != null) {
			if (dept.getDeptID() != null && !dept.getDeptID().equals("")) {
				ulist.add(dept.getDeptID());
				hql.append(" and deptID=?");
			}

			if (dept.getDeptName() != null && !dept.getDeptName().equals("")) {
				hql.append(" and deptName like :deptName");
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
		if (dept != null) {
			if (dept.getDeptName() != null && !dept.getDeptName().equals("")) {
				query.setParameter("deptName", "%" + dept.getDeptName().trim() + "%");
				querys.setParameter("deptName", "%" + dept.getDeptName().trim() + "%");
			}
		}
		List<SysDept> list = query.list();
		int countSum = querys.list().size();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(countSum);
		return pm;
	}

	@Override
	public List<SysDept> getDept(String deptID, String deptName) {
		String sql = " from SysDept where 1=1 and DeptState = 0";
		Query query = null;
		if (deptID != null && !deptID.equals("")) {
			sql += " and DeptID like '%" + deptID + "%' ";
		}
		if (deptName != null && !deptName.equals("")) {
			sql += " and DeptName like '%" + deptName + "%' ";
		}
		query = this.getSession().createQuery(sql);
		return query.list();
	}

	@Override
	public List<SysDept> getAllDept() {
		return this.getHibernateTemplate().find(" from SysDept where deptState = 0");
	}

	@Override
	public void addDept(SysDept dept) {
		this.getHibernateTemplate().persist(dept);
	}

	@Override
	public int updateDeptByID(String deptID, SysDept dept) {
		this.getSession().saveOrUpdate(deptID, dept);
		return 1;
	}

	@Override
	public int deleteDept(String deptID) {
		String sql = " update SysDept set deptState=3 where 1=1 and deptID=?";
		Query query = this.getSession().createQuery(sql);
		query.setParameter(0, deptID);
		return query.executeUpdate();
	}

	@Override
	public SysDept getDeptByID(String deptID) {
		return (SysDept) this.getHibernateTemplate().get(SysDept.class, deptID);
	}
}