package com.hl.loan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hl.loan.dao.SysUserDao;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.util.MethoeUtil;
import com.hl.loan.util.PageModel;

@Repository
public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao {
	// 用户登录

	@Override
	public List<SysUser> sysLogin(SysUser sysUser) {
		Query query = this.getSession().createQuery(
				"from SysUser where userName=? and userPWD=?");
		query.setParameter(0, sysUser.getUserName());
		query.setParameter(1, sysUser.getUserPWD());
		return query.list();
	}

	@Override
	public List<SysUser> getAllUser() {
		return this.getHibernateTemplate().find(" from SysUser where userState=1");
	}

	@Override
	public SysUser getUser(String UserNO, String UserName, String UserMob) {
		String hql = " from SysUser where userState=1 ";
		List ulist = new ArrayList();
		if (UserNO != null && !UserNO.equals("")) {
			ulist.add(UserNO);
			hql += " and UserNO=?";
		}
		if (UserName != null && !UserName.equals("")) {
			ulist.add(UserName);
			hql += "and UserName=?";
		}
		if (UserMob != null && !UserMob.equals("")) {
			ulist.add(UserMob);
			hql += "and UserMob=?";
		}

		Query query = this.getSession().createQuery(hql);
		if ((ulist != null) && (ulist.size() > 0)) {
		      for (int i = 0; i < ulist.size(); i++) {
		        query.setParameter(i, ulist.get(i));
		      }
		}
		List<SysUser> list=query.list();
		SysUser sysUser=null;
		if(list!=null &&list.size()>0){
			sysUser =list.get(0);
		}
		/*SysUser sysUser = (SysUser) query.uniqueResult();*/
		return sysUser;
	}

	@Override
	public void addUser(SysUser user) {
		this.getHibernateTemplate().persist(user);
	}

	@Override
	public SysUser getUserByID(String UserID) {
		Query query = this.getSession().createQuery(
				" from SysUser where UserID=?");
		SysUser sysUser = (SysUser) query.setParameter(0, UserID)
				.uniqueResult();
		return sysUser;
	}

	// userName userPWD userNO userFullName userIsDept userIsPost userisRole
	// userRights
	// userWork userState userHomeTel userTel userMob userMail userAddr userPost
	// userQQ
	@Override
	public int updateUserByID(String UserID, SysUser sysUser) {
		/*
		 * this.update(sysUser); return 1;
		 */
		Query query = this
				.getSession()
				.createQuery(
						"update SysUser set UserName=?,UserFullName=?,UserisRole=?, UserMob=?, UserAddr=?, UserQQ=?, UserSex=?, UserIDCard=?, UserState=?, UserRights=?, UserWork=? where 1=1 and UserID=?");
		query.setParameter(0, sysUser.getUserName());
		query.setParameter(1, sysUser.getUserFullName());
		query.setParameter(2, sysUser.getUserisRole());
		query.setParameter(3, sysUser.getUserMob());
		query.setParameter(4, sysUser.getUserAddr());
		query.setParameter(5, sysUser.getUserQQ());
		query.setParameter(6, sysUser.getUserSex());
		query.setParameter(7, sysUser.getUserIDCard());
		query.setParameter(8, sysUser.getUserState());
		query.setParameter(9, sysUser.getUserRights());
		query.setParameter(10, sysUser.getUserWork());
		query.setParameter(11, sysUser.getUserID());
		return query.executeUpdate();
	}

	@Override
	public int deleteUserByID(String UserID) {
		String sql = " update SysUser set UserState=3 where 1=1 and UserID=?";
		Query query = this.getSession().createQuery(sql);
		query.setParameter(0, UserID);
		query.executeUpdate();
		return 1;
	}
	@Override
	public void updateById(Long userId){
		String password="123456";
		String userPwd=MethoeUtil.getMD5(password, null, 1);
		String sql = " update SysUser set userPWD=? where 1=1 and UserID=?";
		Query query = this.getSession().createQuery(sql);
		query.setParameter(0, userPwd);
		query.setParameter(1, userId);
		query.executeUpdate();
	}
	// 得到员工信息
	@Override
	public PageModel<SysUser> showUser(PageModel<SysUser> pm, SysUser users) {
		int size = pm.getPageSize();
		int pageno = (pm.getPageNo() - 1) * size;
		StringBuffer hql = new StringBuffer(
				"from SysUser where 1=1 and userState=1");
		List ulist = new ArrayList();
		if (users != null) {
			if (users.getUserNO() != null && !users.getUserNO().equals("")) {
				ulist.add(users.getUserNO());
				hql.append(" and userNO=?");
			}
			if (users.getUserMob() != null && !users.getUserMob().equals("")) {
				ulist.add(users.getUserMob());
				hql.append(" and userMob=?");
			}
			/*
			 * List lists=this.pageSearchCriteriaByHQL(hql.toString(), ulist,
			 * pageno, size); int count=this.countSum(hql, ulist);
			 */
			if (users.getUserName() != null && !users.getUserName().equals("")) {
				// ulist.add(users.getUserName());
				hql.append(" and userName like :name");
			}
		}
		// String hql="from SysUser";
		Query query = this.getSession().createQuery(hql.toString())
				.setFirstResult(pageno).setMaxResults(size);
		Query querys = this.getSession().createQuery(hql.toString());
		if (ulist != null && ulist.size() > 0) {
			for (int i = 0; i < ulist.size(); i++) {
				query.setParameter(i, ulist.get(i));
				querys.setParameter(i, ulist.get(i));
			}

		}
		if (users != null) {
			if (users.getUserName() != null && !users.getUserName().equals("")) {
				query.setParameter("name", "%" + users.getUserName() + "%");
				querys.setParameter("name", "%" + users.getUserName() + "%");
			}
		}
		List<SysUser> list = query.list();
		int countSum = querys.list().size();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(countSum);
		return pm;
	}

	@Override
	public List<SysUser> getAllUserNo() {
		Query query = this.getSession().createQuery(
				"select userNO from SysUser where  userState=1");
		return query.list();
	}
	
	@Override
	public List<SysUser> exists(int status) {
		return getHibernateTemplate()
				.find(" from SysUser u where userId not in (select userId from NoteAndUser where status="
						+ status + ")");
	}
	public void updatePassword(SysUser sysUser){
		 this.getSession().update(sysUser);
	}
}



