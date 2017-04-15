package com.hl.loan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hl.loan.dao.CityDao;
import com.hl.loan.pojo.Area;
import com.hl.loan.pojo.City;
import com.hl.loan.util.PageModel;

import org.hibernate.Query;

@Repository
public class CityDaoImpl extends BaseDaoImpl<City> implements CityDao {

	@Override
	public PageModel<City> showCity(PageModel<City> pm, City city) {
		
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		/*StringBuffer hql= new StringBuffer("select a.AreaName,c.CityID,c.CityName from City c join fetch c.Area a where c.Father = a.AreaID");*/
		StringBuffer hql= new StringBuffer("from City where 1=1 and cityState=0");
		List ulist=new ArrayList();
		if(city!=null){
			if(city.getCityID()!=null && !city.getCityID().equals("")){
				ulist.add(city.getCityID());
				hql.append(" and cityID=?");
			}
		/*List lists=this.pageSearchCriteriaByHQL(hql.toString(), ulist, pageno, size);
		int count=this.countSum(hql, ulist);*/
			if(city.getCityName()!=null && !city.getCityName().equals("")){
				hql.append(" and cityName like :cityName");
			}
		}
		Query query=this.getSession().createQuery(hql.toString()).setFirstResult(startNumber).setMaxResults(size);
		Query querys=this.getSession().createQuery(hql.toString());
		if(ulist!=null && ulist.size()>0){
			for(int i=0;i<ulist.size();i++){
				query.setParameter(i, ulist.get(i));
				querys.setParameter(i, ulist.get(i));
			}
		}
		if(city!=null){
			if(city.getCityName()!=null && !city.getCityName().equals("")){
				query.setParameter("cityName", "%"+city.getCityName()+"%");
				querys.setParameter("cityName", "%"+city.getCityName()+"%");
			}
		}
		List<City> list=query.list();
		int countSum=querys.list().size();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(countSum);
		return pm;
	}

	@Override
	public List<City> getCityByID(String cityID) {
		Query query = this.getSession().createQuery(" from City where 1=1 and CityID=?");
		query.setParameter(0, cityID);
		return query.list();
	}
	
	@Override
	public int updateCityByID(String cityID,City city) {
		this.getSession().saveOrUpdate(cityID.toString(), city);
		return 1;
	}
	
	@Override
	public void addCity(City city) {
		this.getHibernateTemplate().persist(city);
	}

	@Override
	public int deleteCity(String cityID) {
		String sql=" update City set CityState=3 where 1=1 and cityID=?";
		Query query = this.getSession().createQuery(sql);
		query.setParameter(0, cityID);
		query.executeUpdate();
		return 1;
	}
	
	@Override
	public List<Area> getAllArea(){
		return this.getHibernateTemplate().find("from Area");
	}
	
	@Override
	public List<City> getAllCity() {
		return this.getHibernateTemplate().find(" from City");
	}

}
