package com.hl.loan.dao.impl;

import com.hl.loan.dao.FileNamesDao;
import com.hl.loan.pojo.FileNames;
import com.hl.loan.util.PageModel;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FileNamesDaoImpl extends BaseDaoImpl<FileNames> implements FileNamesDao{
  	
  public FileNames addFilesName(FileNames fileNames)
  {
    this.getHibernateTemplate().persist(fileNames);
    return fileNames;
  }

  public PageModel<FileNames> showFiles(PageModel<FileNames> pm, FileNames file, String depId) {
    int size = pm.getPageSize();
    int pageno = pm.getPageNo();
    if(pageno<=0){
    	pageno=1;
    }
    int startNumber = (pageno - 1) * size;
    StringBuffer hql = new StringBuffer("from FileNames where 1=1 and (fmonily!=2 or fstate!=2)");
    StringBuffer chql = new StringBuffer("select count(*) from FileNames where 1=1 and (fmonily!=2 or fstate!=2)");
    List ulist = new ArrayList();
    int flag=0;
    List<Long> elist=new ArrayList<Long>();
    if (file != null) {
      String exsql="select file_id from excel where clss=1 ";
      if ((file.getId() != null) && (!file.getId().equals(""))) {
        ulist.add(file.getId());
        hql.append(" and id=?");
        chql.append(" and id=?");
      }
      if ((file.getFbak1() != null) && (!file.getFbak1().equals(""))) {
    	  exsql=exsql+" and down_time >='"+file.getFbak1()+"' ";
    	  flag=1;
        }
      if ((file.getZipCode() != null) && (!file.getZipCode().equals(""))) {
     	  exsql=exsql+" and down_time <='"+file.getZipCode() +"' ";
     	  flag=1;
         }
      if ((file.getCompnyName() != null) && (!file.getCompnyName().equals(""))) {
        hql.append(" and compnyName like :compnyName");
        chql.append(" and compnyName like :compnyName");
      }

      if ((file.getDepartment() != null) && (!file.getDepartment().equals(""))) {
        hql.append(" and department like :department");
        chql.append(" and department like :department");
      }
      if ((file.getLinkmn() != null) && (!file.getLinkmn().equals(""))) {
        hql.append(" and linkmn like :linkmn");
        chql.append(" and linkmn like :linkmn");
      }
      if ((file.getAddress() != null) && (!file.getAddress().equals(""))) {
        hql.append(" and address like :address");
        chql.append(" and address like :address");
      }
      if ((file.getCompClass() != null) && (!file.getCompClass().equals(""))) {
        hql.append(" and compClass like :compClasses");
        chql.append(" and compClass like :compClasses");
      }
      if ((file.getPost() != null) && (!file.getPost().equals(""))) {
        hql.append(" and post like :post");
        chql.append(" and post like :post");
      }
      if ((file.getFbak2() != null) && (!file.getFbak2().equals(""))) {
        hql.append(" and ( pid in(select id from FileNames where compnyName like :fbak2) or compnyName like :fbak3)");
        chql.append(" and ( pid in(select id from FileNames where compnyName like :fbak2) or compnyName like :fbak3)");
      }
      
      if ((file.getIsdelete() != null) && (!file.getIsdelete().equals("") )) {
    	  exsql=exsql+" and status="+file.getIsdelete();
    	  flag=1;
      }
      if(flag==1){
    	  elist.add((long) 0);
    	  Session session = this.getSession();
    	  Connection con =session.connection();
    	  PreparedStatement ps;
    	  try {
    		 System.out.println("========"+exsql);
		     ps = con.prepareStatement(exsql);
			 ResultSet rs = ps.executeQuery();
		     while(rs.next()){
		    	 elist.add(rs.getLong("file_id"));
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
    	  hql.append(" and id in (:list)");
    	  chql.append(" and id in (:list)");
      }
      if ((file.getOfficePhone() != null) && (!file.getOfficePhone().equals("") )) {
          hql.append(" and  (officePhone like :officePhone or phone like :phone)");
          chql.append(" and  (officePhone like :officePhone or phone like :phone)");
    	 
      }
      
    }
    
    if ((depId != null) && (!depId.equals(""))) {
      hql.append(" and compClass like :compClass");
    }
    if (file != null) {
    	if(file.getPid()!=null && file.getPid()==2){
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
    if (file != null) {
      if ((file.getCompnyName() != null) && (!file.getCompnyName().equals(""))) {
        query.setParameter("compnyName", "%" + file.getCompnyName().trim() + "%");
        querys.setParameter("compnyName", "%" + file.getCompnyName().trim() + "%");
      }
      if ((file.getDepartment() != null) && (!file.getDepartment().equals(""))) {
        query.setParameter("department", "%" + file.getDepartment().trim() + "%");
        querys.setParameter("department", "%" + file.getDepartment().trim() + "%");
      }
      if ((file.getLinkmn() != null) && (!file.getLinkmn().equals(""))) {
        query.setParameter("linkmn", "%" + file.getLinkmn().trim() + "%");
        querys.setParameter("linkmn", "%" + file.getLinkmn().trim() + "%");
      }
      if ((file.getAddress() != null) && (!file.getAddress().equals(""))) {
        query.setParameter("address", "%" + file.getAddress().trim() + "%");
        querys.setParameter("address", "%" + file.getAddress().trim() + "%");
      }
      if ((file.getCompClass() != null) && (!file.getCompClass().equals(""))) {
        query.setParameter("compClasses", "%" + file.getCompClass().trim() + "%");
        querys.setParameter("compClasses", "%" + file.getCompClass().trim() + "%");
      }
      if ((file.getPost() != null) && (!file.getPost().equals(""))) {
        query.setParameter("post", "%" + file.getPost().trim() + "%");
        querys.setParameter("post", "%" + file.getPost().trim() + "%");
      }
      if ((file.getFbak2() != null) && (!file.getFbak2().equals(""))) {
        query.setParameter("fbak2", "%" + file.getFbak2() + "%");
        querys.setParameter("fbak2", "%" + file.getFbak2() + "%");
        query.setParameter("fbak3", "%" + file.getFbak2() + "%");
        querys.setParameter("fbak3", "%" + file.getFbak2() + "%");
      }
      if ((file.getOfficePhone() != null) && (!file.getOfficePhone().equals("") )) {
    	  query.setParameter("officePhone", "%" + file.getOfficePhone() + "%");
    	  query.setParameter("phone", "%" + file.getOfficePhone() + "%");
    	  querys.setParameter("officePhone", "%" + file.getOfficePhone() + "%");
          querys.setParameter("phone", "%" + file.getOfficePhone() + "%");
      }
      if(flag==1){
    	  query.setParameterList("list",  elist);
    	  querys.setParameterList("list",  elist);
      }
    }

    if ((depId != null) && (!depId.equals(""))) {
      query.setParameter("compClass", "%" + depId + "%");
      querys.setParameter("compClass", "%" + depId + "%");
    }
    List<FileNames> list = query.list();
    long count=(long) querys.iterate().next();
    int countSum = (int) count;
    pm.setDatas(list);
    pm.setPageNo(pageno);
    pm.setPageSize(size);
    pm.setRecordCount(countSum);
    return pm;
  }

  public int updateFileByID(String id, FileNames file) {
    this.getSession().saveOrUpdate(id, file);
    return 1;
  }

  public FileNames getFileNamesByID(Long id)
  {
    return (FileNames) this.getHibernateTemplate().get(FileNames.class, id);
  }

  public int updateFile(Long id, int fstate, Date time,int fmo) {
	String sql="update FileNames set fstate=?,changeTime=?";
	if(fmo>0){
		sql=sql+",fmonily=?";
	}
	sql=sql+" where  id=?";
    Query query = this.getSession().createQuery(sql);
    query.setParameter(0, Integer.valueOf(fstate));
    query.setParameter(1, time);
    if(fmo>0){
    	query.setParameter(2, fmo);
    	 query.setParameter(3, id);
    }else{
    	 query.setParameter(2, id);
    }
    
    return query.executeUpdate();
  }

  public void updateByFiles(FileNames fileNames) {
    getSession().update(fileNames);
  }

  public void updateAll(FileNames fileNames) {
    getSession().saveOrUpdate(fileNames);
  }

  public List<FileNames> getAllFileNames() {
    String hql = "from FileNames";
    Query query = this.getSession().createQuery(hql);
    return query.list();
  }

  public List<FileNames> insertExcelFiles(FileNames file)
  {
    StringBuffer hql = new StringBuffer("from FileNames where 1=1 and fmonily!=2 and fstate=2");
    List ulist = new ArrayList();
    int flag=0;
    List<Long> elist=new ArrayList<Long>();
    if (file != null) {
        String exsql="select file_id from excel where clss=1 ";
        if ((file.getId() != null) && (!file.getId().equals(""))) {
          ulist.add(file.getId());
          hql.append(" and id=?");
        }
        if ((file.getFbak1() != null) && (!file.getFbak1().equals(""))) {
      	  exsql=exsql+" and down_time >='"+file.getFbak1()+"' ";
      	  flag=1;
          }
        if ((file.getZipCode() != null) && (!file.getZipCode().equals(""))) {
       	  exsql=exsql+" and down_time <='"+file.getZipCode() +"' ";
       	  flag=1;
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
        if ((file.getCompClass() != null) && (!file.getCompClass().equals(""))) {
          hql.append(" and compClass like :compClasses");
        }
        if ((file.getPost() != null) && (!file.getPost().equals(""))) {
          hql.append(" and post like :post");
        }
        if ((file.getFbak2() != null) && (!file.getFbak2().equals(""))) {
          hql.append(" and ( pid in(select id from FileNames where compnyName like :fbak2) or compnyName like :fbak3)");
        }
        
        if ((file.getIsdelete() != null) && (!file.getIsdelete().equals("") )) {
      	  exsql=exsql+" and status="+file.getIsdelete();
      	  flag=1;
        }
        if(flag==1){
      	  elist.add((long) 0);
      	  Session session = this.getSession();
      	  Connection con =session.connection();
      	  PreparedStatement ps;
      	  try {
      		 System.out.println("========"+exsql);
  		     ps = con.prepareStatement(exsql);
  			 ResultSet rs = ps.executeQuery();
  		     while(rs.next()){
  		    	 elist.add(rs.getLong("file_id"));
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
      	  hql.append(" and id in (:list)");
        }
        if ((file.getOfficePhone() != null) && (!file.getOfficePhone().equals("") )) {
            hql.append(" and  (officePhone like :officePhone or phone like :phone)");
      	 
        }
        
      }
      

    if (file != null) {
    	if(file.getPid()!=null && file.getPid()==2){
    		hql.append(" order by compnyName desc");
    	}else{
    		hql.append(" order by changeTime desc");
    	}
    }else{
    	hql.append(" order by changeTime desc");
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
        if ((file.getCompClass() != null) && (!file.getCompClass().equals(""))) {
          query.setParameter("compClasses", "%" + file.getCompClass().trim() + "%");
        }
        if ((file.getPost() != null) && (!file.getPost().equals(""))) {
          query.setParameter("post", "%" + file.getPost().trim() + "%");
        }
        if ((file.getFbak2() != null) && (!file.getFbak2().equals(""))) {
          query.setParameter("fbak2", "%" + file.getFbak2() + "%");
          query.setParameter("fbak3", "%" + file.getFbak2() + "%");
        }
        if ((file.getOfficePhone() != null) && (!file.getOfficePhone().equals("") )) {
      	  query.setParameter("officePhone", "%" + file.getOfficePhone() + "%");
      	  query.setParameter("phone", "%" + file.getOfficePhone() + "%");
        }
        if(flag==1){
      	  query.setParameterList("list",  elist);
        }
    }
    List<FileNames> list = query.list();
    return list;
  }
  @Override
  public Long getIdByName(String dpName){
	  Long pid=null;
	  StringBuffer hql = new StringBuffer("from FileNames where compnyName=?");
	  Query query=this.getSession().createQuery(hql.toString());
	  query.setParameter(0, dpName);
	  List<FileNames> list=query.list();
	  if(list!=null && list.size()>0){
		  pid=list.get(0).getId();
	  }
	  return pid;
  }
  @Override
  public List<FileNames> getByName(String compnyName){
	  Long pid=null;
	  StringBuffer hql = new StringBuffer("from FileNames where compnyName=?");
	  Query query=this.getSession().createQuery(hql.toString());
	  query.setParameter(0, compnyName);
	  List<FileNames> list=query.list();
	  return list;
  }
  @Override
  public void updateAllExam(FileNames file){
	 
	  StringBuffer hql=new StringBuffer("update FileNames set fstate=2,changeTime='"+file.getFbak2()+"' where fstate=1 ");
	  List ulist = new ArrayList();
	    if (file != null) {
	      if ((file.getId() != null) && (!file.getId().equals(""))) {
	        ulist.add(file.getId());
	        hql.append(" and id=?");
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
  
  
  
  
  
  
}


