package com.hl.loan.dao.impl;

import com.hl.loan.dao.ExcelDao;
import com.hl.loan.pojo.Excel;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExcelDaoImpl extends BaseDaoImpl<Excel>
  implements ExcelDao
{
  public Excel saveExcel(Excel excel)
  {
	  this.getHibernateTemplate().persist(excel);
      return excel;
  }

  public List<Excel> getExcel(Long fileId,int states) {
    Query query = getSession().createQuery("from Excel where fileId=? and clss=? order by downTime desc");
    query.setParameter(0, fileId);
    query.setParameter(1, states);
    return query.list();
  }
  public void updateExcel(Long id){
	  Query query = getSession().createQuery("update Excel set status=2 where id=?");
	  query.setParameter(0, id);
	  query.executeUpdate();
  }
  public void updateState(Long id,int status){
	  Query query = getSession().createQuery("update Excel set status=? where id=?");
	  query.setParameter(0,status);
	  query.setParameter(1, id);
	  query.executeUpdate();
  }
}


