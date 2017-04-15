package com.hl.loan.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hl.loan.dao.RoleDao;
import com.hl.loan.pojo.SysRole;
import com.hl.loan.util.PageModel;

import org.hibernate.Query;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<SysRole> implements RoleDao{


	@Override
	public PageModel<SysRole> showRole(PageModel<SysRole> pm, SysRole sysRole) {
		
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		StringBuffer hql= new StringBuffer("from SysRole where 1=1 and RoleState = 0");
		
		List ulist=new ArrayList();
		if(sysRole!=null){
			if(sysRole.getRoleId()!=null && !sysRole.getRoleId().equals("")){
				ulist.add(sysRole.getRoleId());
				hql.append(" and roleId=?");
			}
		/*List lists=this.pageSearchCriteriaByHQL(hql.toString(), ulist, pageno, size);
		int count=this.countSum(hql, ulist);*/
			if(sysRole.getRoleName()!=null && !sysRole.getRoleName().equals("")){
				hql.append(" and roleName like :roleName");
			}
		}
		Query query=this.getSession().createQuery(hql.toString()).setFirstResult(startNumber).setMaxResults(size);
		Query querys=this.getSession().createQuery(hql.toString());
		if(ulist!=null && ulist.size()>0){
			for(int i=0;i<ulist.size();i++){
				query.setParameter(i, ulist.get(i));
				querys.setParameter(i, ulist.get(i));
			}
		}
		if(sysRole!=null){
			if(sysRole.getRoleName()!=null && !sysRole.getRoleName().equals("")){
				query.setParameter("roleName", "%"+sysRole.getRoleName()+"%");
				querys.setParameter("roleName", "%"+sysRole.getRoleName()+"%");
			}
		}
		List<SysRole> list=query.list();
		int countSum=querys.list().size();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(countSum);
		return pm;
	}
	
	
	@Override
	public int updateRoleById(String roleId,SysRole sysRole) {
		this.getSession().saveOrUpdate(roleId.toString(), sysRole);
		return 1;
	}


	@Override
	public List<SysRole> getRoleByID(String RoleID) {
			Query query=this.getSession().createQuery(" from SysRole where 1=1 and RoleID=?");
			query.setParameter(0, RoleID);
			return query.list();
		}
	
	@Override
	public int deleteRole(String roleId) {
		String sql=" update SysRole set RoleState=3 where 1=1 and RoleID=?";
		Query query = this.getSession().createQuery(sql);
		query.setParameter(0, roleId);
		query.executeUpdate();
		return 1;
	}
	
	@Override
	public void addRole(SysRole role) {
		this.getHibernateTemplate().persist(role);
	}
	
	@Override
	public List<SysRole> getAllRole(){
		return this.getHibernateTemplate().find("from SysRole");
	}
}
