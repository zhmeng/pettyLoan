package com.hl.loan.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.hl.loan.dao.ImgInfoDao;
import com.hl.loan.pojo.ImgInfo;
import com.hl.loan.util.PageModel;

@Repository
public class ImgInfoDaoImpl extends BaseDaoImpl<ImgInfo> implements ImgInfoDao {

	@Override
	public PageModel<ImgInfo> showImgInfo(PageModel<ImgInfo> pm, ImgInfo img) {
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		StringBuffer hql = new StringBuffer("from ImgInfo where 1=1 and type=1");
		List ulist = new ArrayList();
		if (img != null) {
			if (img.getImgChinaName() != null && !img.getImgChinaName().equals("")) {
				ulist.add(img.getImgChinaName());
				hql.append(" and imgChinaName=?");
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
		if (img != null) {
			if (img.getImgChinaName() != null && !img.getImgChinaName().equals("")) {
				query.setParameter("imgChinaName", "%" + img.getImgChinaName() + "%");
				querys.setParameter("imgChinaName", "%" + img.getImgChinaName() + "%");
			}
		}
		List<ImgInfo> list = query.list();
		int countSum = querys.list().size();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(countSum);
		return pm;
	}
	
	@Override
	public void addimg(ImgInfo img) {
		this.getHibernateTemplate().persist(img);
	}

	@Override
	public List<ImgInfo> getImgInfos(Long applyId, int type) {
		Query query = this.getSession().createQuery(" from ImgInfo where 1=1 and applyId=? and type=?");
		query.setParameter(0, applyId);
		query.setParameter(1, type);
		return query.list();
	}

	@Override
	public ImgInfo load(String imgID) {
		return (ImgInfo) this.getHibernateTemplate().get(ImgInfo.class, Long.parseLong(imgID));
	}
	
	public void deleteById(Long id){
		ImgInfo ImgInfo = this.load(id.toString());
		this.delete(ImgInfo);
	}

	@Override
	public List<ImgInfo> getImgInfoListByType(int type) {
		Query query = this.getSession().createQuery(" from ImgInfo where 1=1 and type=?");
		query.setParameter(0, type);
		return query.list();
	}
	
	@Override
	public List<ImgInfo> getImgInfoListByProductId(Long productId) {
		Query query = this.getSession().createQuery(" from ImgInfo where productId=? and type=3");
		query.setParameter(0, productId);
		return query.list();
	}
}
