package com.hl.loan.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.hl.loan.dao.PostDao;
import com.hl.loan.pojo.SysPost;
import com.hl.loan.pojo.SysUser;

import org.hibernate.Query;

@Repository
public class PostDaoImpl extends BaseDaoImpl<SysUser> implements PostDao{

	@Override
	public List<SysPost> getAllPost() {
		return this.getHibernateTemplate().find(" from SysPost");
	}

	@Override
	public List getPost(String PostName, String PostIsDept) {
		String hql = " from SysPost";
		if(PostName!=null && !PostName.equals("")){
			hql+="where PostName=?";
		}
		if(PostIsDept!=null && !PostIsDept.equals("")){
			hql+="and PostIsDept=?";
		}
		Query query=this.getSession().createQuery(hql);
		query.setParameter(0, PostName);
		query.setParameter(1, PostIsDept);
		return query.list();
	}

	@Override
	public void addPost(SysPost post) {
		this.getHibernateTemplate().persist(post);
	}

}
