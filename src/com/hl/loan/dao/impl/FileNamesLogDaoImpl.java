package com.hl.loan.dao.impl;

import com.hl.loan.dao.FileNamesLogDao;
import com.hl.loan.pojo.FileNames;
import com.hl.loan.pojo.FileNamesLog;
import com.hl.loan.util.PageModel;
import com.hl.loan.vi.TotalSum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class FileNamesLogDaoImpl extends BaseDaoImpl<FileNames> implements FileNamesLogDao{
  public FileNamesLog addFilesName(FileNamesLog fileNamesLog)
  {
    this.getHibernateTemplate().persist(fileNamesLog);
    return fileNamesLog;
  }

  public PageModel<FileNamesLog> showFiles(PageModel<FileNamesLog> pm, FileNamesLog fileLog) {
    int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	int startNumber = (pageno - 1) * size;
    StringBuffer hql = new StringBuffer("from FileNamesLog where 1=1");
    StringBuffer chql = new StringBuffer("select count(*) from FileNamesLog where 1=1 ");
    List ulist = new ArrayList();
    if (fileLog != null) {
      if ((fileLog.getId() != null) && (!fileLog.getId().equals(""))) {
        ulist.add(fileLog.getId());
        hql.append(" and id=?");
        chql.append(" and id=?");
      }
      
      if ((fileLog.getFmonily() != null) && (!fileLog.getFmonily().equals(""))) {
        ulist.add(fileLog.getFmonily());
        hql.append(" and fmonily=?");
        chql.append(" and fmonily=?");
      }
      if ((fileLog.getFstate() != null) && (!fileLog.getFstate().equals(""))) {
        ulist.add(fileLog.getFstate());
        hql.append(" and fstate=?");
        chql.append(" and fstate=?");
      }
      if ((fileLog.getFbak1() != null) && (!fileLog.getFbak1().equals(""))) {
        ulist.add(fileLog.getFbak1());
        hql.append(" and DATE_FORMAT(changeTime,'%Y-%m-%d')=?");
        chql.append(" and DATE_FORMAT(changeTime,'%Y-%m-%d')=?");
      }
      if ((fileLog.getCompnyName() != null) && (!fileLog.getCompnyName().equals(""))) {
        hql.append(" and compnyName like :compnyName");
        chql.append(" and compnyName like :compnyName");
      }

      if ((fileLog.getDepartment() != null) && (!fileLog.getDepartment().equals(""))) {
        hql.append(" and department like :department");
        chql.append(" and department like :department");
      }
      if ((fileLog.getLinkmn() != null) && (!fileLog.getLinkmn().equals(""))) {
        hql.append(" and linkmn like :linkmn");
        chql.append(" and linkmn like :linkmn");
      }
      if ((fileLog.getAddress() != null) && (!fileLog.getAddress().equals(""))) {
        hql.append(" and address like :address");
        chql.append(" and address like :address");
      }
    }
    if (fileLog != null) {
    	if(fileLog.getPid()!=null && fileLog.getPid()==2){
    		hql.append(" order by compnyName desc");
    	}else{
    		hql.append(" order by changeTime desc");
    	}
    }else{
    	hql.append(" order by changeTime desc");
    }
    Query query = this.getSession().createQuery(hql.toString()).setFirstResult(startNumber).setMaxResults(size);
    Query querys = this.getSession().createQuery(chql.toString());
    if ((ulist != null) && (ulist.size() > 0)) {
      for (int i = 0; i < ulist.size(); i++) {
        query.setParameter(i, ulist.get(i));
        querys.setParameter(i, ulist.get(i));
      }
    }
    if (fileLog != null) {
      if ((fileLog.getCompnyName() != null) && (!fileLog.getCompnyName().equals(""))) {
        query.setParameter("compnyName", "%" + fileLog.getCompnyName().trim() + "%");
        querys.setParameter("compnyName", "%" + fileLog.getCompnyName().trim() + "%");
      }
      if ((fileLog.getDepartment() != null) && (!fileLog.getDepartment().equals(""))) {
        query.setParameter("department", "%" + fileLog.getDepartment().trim() + "%");
        querys.setParameter("department", "%" + fileLog.getDepartment().trim() + "%");
      }
      if ((fileLog.getLinkmn() != null) && (!fileLog.getLinkmn().equals(""))) {
        query.setParameter("linkmn", "%" + fileLog.getLinkmn().trim() + "%");
        querys.setParameter("linkmn", "%" + fileLog.getLinkmn().trim() + "%");
      }
      if ((fileLog.getAddress() != null) && (!fileLog.getAddress().equals(""))) {
        query.setParameter("address", "%" + fileLog.getAddress().trim() + "%");
        querys.setParameter("address", "%" + fileLog.getAddress().trim() + "%");
      }
    }
    List list = query.list();
    long count=(long) querys.iterate().next();
    int countSum = (int) count;
    pm.setDatas(list);
    pm.setPageNo(pageno);
    pm.setPageSize(size);
    pm.setRecordCount(countSum);
    return pm;
  }

  public int updateFileByID(String id, FileNamesLog fileLog) {
	  this.getSession().save(id, fileLog);
    return 1;
  }

  public FileNamesLog getFileNamesLogByID(Long id)
  {
    return (FileNamesLog)getHibernateTemplate().get(FileNamesLog.class, id);
  }

  public int updateFileLogs(Long id, int fstate, Date time) {
    Query query = this.getSession().createQuery("update FileNamesLog set fstate=?,changeTime=? where id=?");
    query.setParameter(0, Integer.valueOf(fstate));
    query.setParameter(1, time);
    query.setParameter(2, id);
    return query.executeUpdate();
  }

  public void updateByFiles(FileNamesLog fileNamesLog) {
	  this.getSession().update(fileNamesLog);
  }

  public void updateAllLog(FileNamesLog fileNamesLog) {
	  this.getSession().saveOrUpdate(fileNamesLog);
  }

  public List<FileNamesLog> showByFileID(Long fileId) {
    Query query = this.getSession().createQuery("from FileNamesLog where fileId=? order by changeTime desc ");
    query.setParameter(0, fileId);
    return query.list();
  }
  @Override
  public void updateAllExamLog(FileNamesLog file){
	  StringBuffer hql=new StringBuffer("update FileNamesLog set fstate=2,changeTime='"+file.getFbak2()+"' where fstate=1 ");
	  List ulist = new ArrayList();
	    if (file != null) {
	      if ((file.getId() != null) && (!file.getId().equals(""))) {
	        ulist.add(file.getId());
	        hql.append(" and id=?");
	      }
	      if ((file.getPid() != null) && (!file.getPid().equals(""))) {
		        ulist.add(file.getPid());
		        hql.append(" and pid=?");
		  }
	      if ((file.getFmonily() != null) && (!file.getFmonily().equals(""))) {
	        ulist.add(file.getFmonily());
	        hql.append(" and fmonily=?");
	      }
	      if ((file.getFstate() != null) && (!file.getFstate().equals(""))) {
	        ulist.add(file.getFstate());
	        hql.append(" and fstate=?");
	      }
	      if ((file.getFbak1() != null) && (!file.getFbak1().equals(""))) {
	        ulist.add(file.getFbak1());
	        hql.append(" and DATE_FORMAT(changeTime,'%Y-%m-%d')=?");
	      }
	      if ((file.getCompnyName() != null) && (!file.getCompnyName().equals(""))) {
	        hql.append(" and compnyName like :compnyName");
	      }

	      if ((file.getDepartment() != null) && (!file.getDepartment().equals(""))) {
	        hql.append(" and department like :department");
	      }
	      if ((file.getLinkmn() != null) && (!file.getLinkmn().equals(""))) {
	        hql.append(" and linkmn like :linkmn");
	      }
	      if ((file.getAddress() != null) && (!file.getAddress().equals(""))) {
	        hql.append(" and address like :address");
	      }
	    }
	    Query query = this.getSession().createQuery(hql.toString());
	    if ((ulist != null) && (ulist.size() > 0)) {
	      for (int i = 0; i < ulist.size(); i++) {
	        query.setParameter(i, ulist.get(i));
	      }
	    }
	    if (file != null) {
	      if ((file.getCompnyName() != null) && (!file.getCompnyName().equals(""))) {
	        query.setParameter("compnyName", "%" + file.getCompnyName().trim() + "%");
	      }
	      if ((file.getDepartment() != null) && (!file.getDepartment().equals(""))) {
	        query.setParameter("department", "%" + file.getDepartment().trim() + "%");
	      }
	      if ((file.getLinkmn() != null) && (!file.getLinkmn().equals(""))) {
	        query.setParameter("linkmn", "%" + file.getLinkmn().trim() + "%");
	      }
	      if ((file.getAddress() != null) && (!file.getAddress().equals(""))) {
	        query.setParameter("address", "%" + file.getAddress().trim() + "%");
	      }
	    }
	    query.executeUpdate();
  }
  @Override
  public List<FileNamesLog> lookLog(FileNamesLog file){
	  StringBuffer hql=new StringBuffer("from FileNamesLog  where 1=1 ");
	  List ulist = new ArrayList();
	    if (file != null) {
	      if ((file.getId() != null) && (!file.getId().equals(""))) {
	        ulist.add(file.getId());
	        hql.append(" and id=?");
	      }
	      if ((file.getFileId() != null) && (!file.getFileId().equals(""))) {
		        ulist.add(file.getFileId());
		        hql.append(" and fileId=?");
		      }
	      if ((file.getPid() != null) && (!file.getPid().equals(""))) {
		        ulist.add(file.getPid());
		        hql.append(" and pid=?");
		  }
	      if ((file.getFmonily() != null) && (!file.getFmonily().equals(""))) {
	        ulist.add(file.getFmonily());
	        hql.append(" and fmonily=?");
	      }
		
	      if ((file.getFstate() != null) && (!file.getFstate().equals(""))) {
	        ulist.add(file.getFstate());
	        hql.append(" and fstate=?");
	      }
	      if ((file.getFbak1() != null) && (!file.getFbak1().equals(""))) {
	        ulist.add(file.getFbak1());
	        hql.append(" and DATE_FORMAT(changeTime,'%Y-%m-%d')=?");
	      }
	      if ((file.getCompnyName() != null) && (!file.getCompnyName().equals(""))) {
	        hql.append(" and compnyName like :compnyName");
	      }

	      if ((file.getDepartment() != null) && (!file.getDepartment().equals(""))) {
	        hql.append(" and department like :department");
	      }
	      if ((file.getLinkmn() != null) && (!file.getLinkmn().equals(""))) {
	        hql.append(" and linkmn like :linkmn");
	      }
	      if ((file.getAddress() != null) && (!file.getAddress().equals(""))) {
	        hql.append(" and address like :address");
	      }
	    }
	    Query query = this.getSession().createQuery(hql.toString());
	    if ((ulist != null) && (ulist.size() > 0)) {
	      for (int i = 0; i < ulist.size(); i++) {
	        query.setParameter(i, ulist.get(i));
	      }
	    }
	    if (file != null) {
	      if ((file.getCompnyName() != null) && (!file.getCompnyName().equals(""))) {
	        query.setParameter("compnyName", "%" + file.getCompnyName().trim() + "%");
	      }
	      if ((file.getDepartment() != null) && (!file.getDepartment().equals(""))) {
	        query.setParameter("department", "%" + file.getDepartment().trim() + "%");
	      }
	      if ((file.getLinkmn() != null) && (!file.getLinkmn().equals(""))) {
	        query.setParameter("linkmn", "%" + file.getLinkmn().trim() + "%");
	      }
	      if ((file.getAddress() != null) && (!file.getAddress().equals(""))) {
	        query.setParameter("address", "%" + file.getAddress().trim() + "%");
	      }
	    }
		return query.list();
  }
  @Override
  public PageModel<FileNamesLog> sumFile(PageModel<FileNamesLog> pm,FileNamesLog file){
	  int size = pm.getPageSize();
	  int pageno = pm.getPageNo();
	  if(pageno<=0){
		  pageno=1;
	  }
	  int startNumber = (pageno - 1) * size;
	  String csql="SELECT count(*) FROM sumFile sf LEFT JOIN upsumFile up ON sf.userId=up.userId AND sf.times=up.times ";
	  csql+=" LEFT JOIN addsumFile ad on sf.userId=ad.userId AND sf.times=ad.times LEFT JOIN  passsumFile pa ON sf.userId=pa.userId AND sf.times=pa.times where 1=1 ";
	  String sql="SELECT sf.ct sum,up.ct upsum,ad.ct addsum,pa.ct passsum,sf.times times,sf.userId userId FROM sumFile sf LEFT JOIN upsumFile up ON sf.userId=up.userId AND sf.times=up.times";
	  sql+=" LEFT JOIN addsumFile ad on sf.userId=ad.userId AND sf.times=ad.times LEFT JOIN  passsumFile pa ON sf.userId=pa.userId AND sf.times=pa.times where 1=1 ";
	  List pareList=new ArrayList();
	  if (file != null) {
		  if ((file.getFbak1() != null) && (!file.getFbak1().equals(""))) {
		    	 sql+=" and sf.times='"+file.getFbak1()+"'";
		    	 csql+=" and sf.times='"+file.getFbak1()+"'";
			 }
	     if ((file.getUserId() != null) && (!file.getUserId().equals(""))) {
	    	 sql+=" and sf.userId="+file.getUserId();
	    	 csql+=" and sf.userId="+file.getUserId();
		 }
	  }
	  sql+=" limit "+startNumber+" ,"+size;
	  Session session = this.getSession();
  	  Connection con =session.connection();
  	  PreparedStatement ps;
  	  Query query = getSession().createSQLQuery(csql);
  	  try {
		   ps = con.prepareStatement(sql);
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()){
			   TotalSum ts=new TotalSum();
			   ts.setSum(rs.getInt("sum"));
			   ts.setUpsum(rs.getInt("upsum"));
			   ts.setAddsum(rs.getInt("addsum"));
			   ts.setPasssum(rs.getInt("passsum"));
			   ts.setUserId(rs.getInt("userId"));
			   ts.setTimes(rs.getString("times"));
			   pareList.add(ts);
		   }
  	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
  	  }finally{
			try{
				con.close(); 
			}catch(Exception ce){
				ce.printStackTrace();
			}
  	  }  
	  Integer count=Integer.parseInt(query.uniqueResult().toString());
	  /*int countSum = (int) count;*/
  	  pm.setDatas(pareList);
      pm.setPageNo(pageno);
      pm.setPageSize(size);
      pm.setRecordCount(count);
	  return pm;
  }
}






