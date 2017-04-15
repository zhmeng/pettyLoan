package com.hl.loan.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.hl.loan.dao.NotesDao;
import com.hl.loan.pojo.Notes;

@Repository
public class NotesDaoImpl extends BaseDaoImpl<Notes> implements NotesDao {
	// 查询出步骤中最后一个流程
	@Override
	public int getlastNote(Long applyID) {
		String sql = "from Notes where  applyID=? order by nID desc"; // order by nID desc
		List<Notes> list = null;
		try {
			Query query = this.getSession().createQuery(sql);
			query.setParameter(0, applyID);
			query.setFirstResult(0);
			query.setMaxResults(1);
			list = query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int statues = 0;
		if (list != null && list.size() > 0) {
			Notes nots = list.get(0);
			nots.getStatus();
		}
		return statues;
	}

	@Override
	public Notes getNotesByApplyID(Long applyID, int notClass) {
		String sql = " from Notes n where n.applyID=" + applyID + " and n.noteClass=" + notClass;
		List list = getHibernateTemplate().find(sql);
		if (list.size() == 0)
			return null;
		return (Notes) list.iterator().next();
	}
	@Override
	public List<Notes> getOaNotes(Long applyID, int notClass){
		String sql = " from Notes n where n.applyID=" + applyID ;
		if(notClass!=0){
			sql=sql+" and n.noteClass=" + notClass;
		}
		Query query=this.getSession().createQuery(sql);
		return query.list();
	}
}




