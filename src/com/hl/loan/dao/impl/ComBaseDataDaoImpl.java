package com.hl.loan.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hl.loan.dao.ComBaseDataDao;
import com.hl.loan.pojo.ComBaseData;
import com.hl.loan.util.PageModel;

@Repository
public class ComBaseDataDaoImpl extends BaseDaoImpl<ComBaseData> implements ComBaseDataDao{
	//查看数字字典
	@Override
	public PageModel<ComBaseData> showBase(PageModel<ComBaseData> pm,ComBaseData cbd){
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		StringBuffer sb=new StringBuffer("from ComBaseData where 1=1 ");
		String baseDataList=cbd.getBaseDataList();
		String baseName=cbd.getBaseName();
		if(baseDataList!=null && baseDataList.trim().length()>0){
			sb.append(" and baseDataList=?");
		}
		if(baseName!=null && baseName.trim().length()>0){
			sb.append(" and baseName like :baseName");
		}
		Query query=this.getSession().createQuery(sb.toString());
		if(baseDataList!=null && baseDataList.trim().length()>0){
			query.setParameter(0, baseDataList);
		}
		if(baseName!=null && baseName.trim().length()>0){
			query.setParameter("baseName", "%"+baseName+"%");
		}
		int count=query.list().size();
		query.setFirstResult(pageno);
		query.setMaxResults(size);
		List<ComBaseData> list=query.list();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(count);
		return pm;
	}
	//根据字典类型得到
	@Override
	public List<ComBaseData> getByClass(String baseDataList){
		String hql="from ComBaseData where baseDataList=? ";
		Query query=this.getSession().createQuery(hql);
		query.setParameter(0, baseDataList);
		return query.list();
	}
	@Override
	public int getBaseCount(String baseDataList){
		String hql="from ComBaseData where baseDataList=? ";
		Query query=this.getSession().createQuery(hql);
		query.setParameter(0, baseDataList);
		return query.list().size();
	}
	@Override
	public void addBase(ComBaseData comb){
		this.persit(comb);
	}
}




