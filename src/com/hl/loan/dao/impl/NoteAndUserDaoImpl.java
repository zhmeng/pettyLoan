package com.hl.loan.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.hl.loan.dao.NoteAndUserDao;
import com.hl.loan.pojo.NoteAndUser;
import com.hl.loan.util.PageModel;

@Repository
public class NoteAndUserDaoImpl extends BaseDaoImpl<NoteAndUser> implements NoteAndUserDao {

	@Override
	public PageModel<NoteAndUser> showNoteAndUser(PageModel<NoteAndUser> pm, NoteAndUser noteAndUser) {
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		StringBuffer hql = new StringBuffer("from NoteAndUser where 1=1");
		List ulist = new ArrayList();
		if (noteAndUser != null) {
			if (noteAndUser.getStatus() != null && !noteAndUser.getStatus().equals("")) {
				ulist.add(noteAndUser.getStatus());
				hql.append(" and status=?");
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
		List<NoteAndUser> list = query.list();
		int countSum = querys.list().size();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(countSum);
		return pm;
	}

	// 增
	@Override
	public void addNote(NoteAndUser nau) {
		this.persit(nau);
	}

	// 根据用户ID得到审批的ID
	@Override
	public List<NoteAndUser> getNoteByUser(int userId) {
		String hql = "from NoteAndUser where userId=?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, userId);
		return query.list();
	}
	
	@Override
	public List<NoteAndUser> getAllNoteAndUser() {
		return this.getHibernateTemplate().find(" from NoteAndUser");
	}

	@Override
	public NoteAndUser getNoteAndUserById(String id) {
		return (NoteAndUser) this.getHibernateTemplate().get(NoteAndUser.class, Long.parseLong(id));
	}

	@Override
	public List<NoteAndUser> getNoteAndUserByStatus(int status) {
		String hql = "from NoteAndUser where status=?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, status);
		return query.list();
	}

	@Override
	public void delNoteAndUser(NoteAndUser noteAndUser) {
		this.getSession().delete(noteAndUser);
	}

	@Override
	public NoteAndUser getNoteByUser(int userId, int status) {
		String sql = " from NoteAndUser n " + "where n.userId = " + userId + " and n.status = " + status + "";
		List list = getHibernateTemplate().find(sql);
		if (list != null && list.size() != 0) {
			NoteAndUser noteAndUser = (NoteAndUser) list.iterator().next();
			if (noteAndUser != null)
				return noteAndUser;
		}
		return null;
	}
}