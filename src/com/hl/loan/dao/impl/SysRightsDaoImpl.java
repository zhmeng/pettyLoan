package com.hl.loan.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.hl.loan.dao.SysModuleDao;
import com.hl.loan.dao.SysRightsDao;
import com.hl.loan.pojo.SysModule;
import com.hl.loan.pojo.SysRights;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.util.PageModel;

@Repository
public class SysRightsDaoImpl extends BaseDaoImpl<SysRights> implements SysRightsDao{

	@Override
	public List<SysRights> getSysRightsByID(String RoleID) {
		Query query=this.getSession().createQuery(" from SysRights where 1=1  and rightsRoleOrUser=0 and RightsRoleID=?");
		query.setParameter(0, RoleID);
		return query.list();
	}
	/*
	 * right :	2角色    1个人
	 * isRight  :1有效    2.无效    3.所有
	 */
	@Override
	public List<SysRights> getSysRightById(int right,int id,int isRight){				
		StringBuffer sb=new StringBuffer(" from SysRights where 1=1");
		if(right==1){
			sb.append(" and rightsRoleOrUser=? and rightsUserID=?");
		}else if(right==2){
			sb.append(" and rightsRoleOrUser=? and rightsRoleID=?");
		}
		if(isRight!=3){
			sb.append(" and isRight=?");
		}
		Query query=this.getSession().createQuery(sb.toString());
		query.setParameter(0, right);
		query.setParameter(1, id);
		if(isRight!=3){
			query.setParameter(2, isRight);
		}
		return query.list();
	}
	@Override
	public List<SysRights> getSysRightById(int right,int id,int isRight,int mid){				
		StringBuffer sb=new StringBuffer(" from SysRights where 1=1");
		if(right==1){
			sb.append(" and rightsRoleOrUser=? and rightsUserID=?");
		}else if(right==2){
			sb.append(" and rightsRoleOrUser=? and rightsRoleID=?");
		}
		sb.append(" and rightsModID=?");
		if(isRight!=3){
			sb.append(" and isRight=?");
		}
		Query query=this.getSession().createQuery(sb.toString());
		query.setParameter(0, right);
		query.setParameter(1, id);
		query.setParameter(2, isRight);
		if(isRight!=3){
			query.setParameter(3, isRight);
		}
		return query.list();
	}
	@Override
	public List<SysRights> getSysRightByIds(int right,int id,String  rightMidId){
		StringBuffer sb=new StringBuffer(" from SysRights where 1=1");
		if(right==1){
			sb.append(" and rightsRoleOrUser=? and rightsUserID=? and rightsModID=?");
		}else if(right==2){
			sb.append(" and rightsRoleOrUser=? and rightsRoleID=? and rightsModID=?");
		}
		Query query=this.getSession().createQuery(sb.toString());
		query.setParameter(0, right);
		query.setParameter(1, id);
		query.setParameter(2, rightMidId);
		return query.list();
	}
	@Override
	public void add(SysRights sysRights) {
		this.getHibernateTemplate().persist(sysRights);
	}

	@Override
	public List<SysRights> getAllsysrigh() {
		return this.getHibernateTemplate().find(" from SysRights");
	}

	@Override
	public List<SysRights> getSysRightsByModID(String RightsModID) {
		Query query=this.getSession().createQuery(" from SysRights where 1=1 and rightsRoleOrUser=2 and rightsModID=?");
		query.setParameter(0, RightsModID);
		return query.list();
	}

	@Override
	public int updateCheck(SysRights sysright,Integer roleID, Integer roleOruser, String mid) {
		//先查到类
		StringBuffer sb=new StringBuffer(" from SysRights where 1=1");
		if(roleOruser==2){
			sb.append(" and rightsRoleOrUser=2 and rightsRoleID=? and  rightsModID=?");
		}else if(roleOruser==1){
			sb.append(" and rightsRoleOrUser=1 and rightsUserID=? and  rightsModID=?");
		}
		Query query=this.getSession().createQuery(sb.toString());
		query.setParameter(0, roleID);
		query.setParameter(1, mid);
		List<SysRights> list=query.list();
		SysRights rights=list.get(0);
		sysright.setRightsID(rights.getRightsID());
		return rights.getRightsID();
	}
	@Override
	public void updates(SysRights sysright){
		this.getSession().clear();
		this.getHibernateTemplate().saveOrUpdate(sysright);
	}
}




