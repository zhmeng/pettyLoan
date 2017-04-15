package com.hl.loan.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.hl.loan.pojo.FileNamesLog;
import com.hl.loan.pojo.SysRights;




public interface BaseDao<T>  {


	/**
	 * 根据ID查找对象
	 * 
	 * @param entityClass 
	 * @param id
	 * @return 
	 */
	//public T findById(Class<T> entityClass,Serializable id);
	
	/**
	 *
	 * 
	 * @param entityClass
	 * @return
	 */
	public List findAll(Class entityClass);

    /**
     * 获取所有对象
     * isASC表示升序降序
     * @param entityClass 
     * @param orderBy 
     * @param isAsc 
     * @return 
     */
    public List findAll(Class entityClass, String orderByProperty, boolean isAsc);
    
    /**
     *
     * @param entityClass 
     * @return 
     */
    public List<T> findByExample(Object entity);
    
    /**
     * 根据实例查询（不支持主键，不支持关联，不支持null）
     * 
     * @param hql
     * @param params
     * @return 
     */
    public List find(String hql,Object... params);

    /**
     * 
     * 
     * @param hql
     * @param entityClass 实体
     * @return
     */
	public Object findObj(String hql,Object...params);
    
	/**
	 * 自定义查询
	 * @param entityClas
	 * @param
	 * @param ֵ
	 * @return
	 */
    public List findByProperty(Class entityClass,String propertyName,Object value);
    
    /**
     * 
     * 
  	 * @param   params 
  	 * @return  
     */
   // public PagingResults paging(final PagingParams params) ;
    
    /**
     * 保存数据
     * @param obj 
     * 
     */
    public void save(Object obj);
    
    /**
     * 
     * @param entityClass
     * @param obj 
     * @return 
     */
    //public T merge(Class<T> entityClass,Object obj);
    
    /**
     * 修改
     * @param obj 
     */
    public void update(Object obj);
    
    /**
     * 删除
     * @param obj 
     */
    public void delete(Object obj);
    
    /**
     *
     * @param entityClass 
     * @param id 
     */
   // public void deleteById(Class entityClass,Serializable id);
    
    /**
     * 
     * @param entityClass
     * @param ID
     * @param ids 
     */
    public void deleteByIds(Class entityClass, String idName , Serializable[] ids);
    
    /**
     * 批量更新对象
     * @objs 
     */
    public void batchUpdate(final List objs);
    
    /**
     * 批量插入对象
     * @objs
     */
    public void batchInsert(final List objs);
    
    /**
     * 
     * @return session
     */
    public Session getCurrentSession();
    
    /**
     * 
     */
    public void flush();
    
    /**
     * 
     */
    public void clear();

	public List pageSearchCriteriaByHQL(String hql, List argsList, Integer pageNo,
			Integer pageSize);

	public int countSum(String hql, List argsList);


	public void persit(Object obj);

	

	//PagingResults paging(PagingParams params);
}




