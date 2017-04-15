package com.hl.loan.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hl.loan.dao.BaseDao;


public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	@Override
	protected void initDao() throws Exception {
		// nothing
	}
	
	/**
	 * 
	 * @param sessionFactory
	 */
    @Resource(name = "sessionFactory")  
	public void setSuperSessionFactory(SessionFactory sessionFactory) {  
	   super.setSessionFactory(sessionFactory);  
	}  
	
    
	/**
	 *
	 * 
	 * @param entityClass
	 *            
	 * @param id
	 * @return 
	 */
	/*@Override
	public T findById(Class<T> entityClass, Serializable id) {
		return entityClass.cast(super.getHibernateTemplate().get(entityClass, id));
	}*/
	
	/**
     *
     * 
     * @param entityClass
     * @return
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByExample(Object entity) {
		return getHibernateTemplate().findByExample(entity);
	}
	
	/**
	 * 
	 * 
	 * @param entityClass
	 *           
	 * @return
	 */
	@Override
	public List findAll(Class entityClass) {
		String queryString = "from " + entityClass.getSimpleName();
		return  super.getHibernateTemplate().find(queryString);
	}

	/**
	 * 
	 * 
	 * @param entityClass
	 *            
	 * @param orderBy
	 *           
	 * @param isAsc
	 *           
	 * @return
	 */
	@Override
	public List findAll(Class entityClass, String orderByProperty,
			boolean isAsc) {
		return isAsc ? super.getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(entityClass).addOrder(
						Order.asc(orderByProperty))) : super
				.getHibernateTemplate().findByCriteria(
						DetachedCriteria.forClass(entityClass).addOrder(
								Order.desc(orderByProperty)));
	}

	/**
	 * 
	 * 
	 * @param entityClass
	 *           
	 * @param hql���
	 * @param params
	 * @return 
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public List find(String hql,Object... params) {
		return getHibernateTemplate().find(hql,params);
	}
	
	/**
	 *
	 * 
	 * @param entityClass
	 *            
	 * @param 
	 * @return 
	 */
	@SuppressWarnings({ "rawtypes" })
	public Object findObj(String hql,Object...params) {
		List list = getHibernateTemplate().find(hql,params);
		if(list.size() > 0){
			return list.get(0);
		}else {
			return null;
		}
	}

	/**
	 * 
	 * @param entityClass 
	 * @param
	 * @param ֵ
	 * @return 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findByProperty(Class entityClass,String propertyName,Object value) {
		String queryString = "from "+entityClass.getSimpleName()+" as model where model."
				+ propertyName + "= ?";
		return super.getHibernateTemplate().find(queryString, value);
	}

	/**
	 * 
	 * 
	 * @param allSizeHql
	 *            
	 * @param queryListHql
	 *           
	 * @param page
	 *           
	 * @param size
	 *            
	 * @return Map<String,Object>
	 *        �
	 */
	/**
	 * 
	 * 
	 * @param
	 * @return
	 */
	/*@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public PagingResults paging(final PagingParams params) {
		return (PagingResults) getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				int currentPage = params.getNextPage();

				Query query = session.createQuery(params.getAllSizeHql());
				// �ܼ�¼��
				Integer allSize = Integer.parseInt(query.list().get(0)
						.toString());
				// ÿҳ��ʾ�ļ�¼��
				int size = params.getPageSize();
				Integer pages = allSize % size == 0 ? allSize / size : allSize
						/ size + 1;

				if (currentPage > pages) {
					currentPage = pages;
				} else if (currentPage <= 0) {
					currentPage = 1;
				}

				// �õ���ҳ��list
				Query listQuery = session.createQuery(params.getQueryHql());
				listQuery.setFirstResult((currentPage - 1) * size).setMaxResults(size);
				List list = listQuery.list();
				PagingResults results = new PagingResults();
				results.setCurrentPage(currentPage);
				results.setTotalPages(pages);
				results.setTotalSize(allSize);
				results.setList(list);
				
				return results;
			}
		});
	}*/
	/**
	 *
	 * 
	 * @param obj
	 *           
	 * 
	 */
	@Override
	public void save(Object obj) {
		super.getHibernateTemplate().save(obj);
	}

	/**
	 * 
	 * 
	 * @param entityClass
	 *            
	 * @param obj
	 *            
	 * @return 
	 */
	/*@Override
	public T merge(Class<T> entityClass, Object obj) {
		return entityClass.cast(super.getHibernateTemplate().merge(obj));
	}*/

	/**
	 * 
	 * 
	 * @param obj
	 *            
	 */
	@Override
	public void update(Object obj) {
		super.getHibernateTemplate().update(obj);
	}

	/**
	 * ɾ�����
	 * 
	 * @param obj
	 *            ʵ�����
	 */
	@Override
	public void delete(Object obj) {
		super.getHibernateTemplate().delete(obj);
	}

	/**
	 * ɾ�����
	 * 
	 * @param entityClass
	 *            ʵ�������
	 * @param id
	 */
	/*@Override
	public void deleteById(Class entityClass, Serializable id) {
		super.getHibernateTemplate().delete(findById(entityClass, id));
	}*/

	/**
	 * ���IDɾ���������
	 * 
	 * @param entityClass
	 * @param ids �Զ��Ÿ��� 1,2,3  ������ַ�'hwt001','hwt002'
	 */
	@Override
	public void deleteByIds(Class entityClass, String idName ,Serializable[] ids) {
		String id = "?";
		for (int i = 0 ; i < ids.length -1 ; i++) {
			id = id + ",?";
		}
		
		String hql = "delete from " + entityClass.getSimpleName() + " where " + idName + " in ("
				+ id + ")";
		getHibernateTemplate().bulkUpdate(hql,ids);
	}

	/**
	 * �õ���ǰsession
	 * 
	 * @return session
	 */
	@Override
	public Session getCurrentSession() {
		return super.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	/**
	 * ˢ�»���
	 */
	@Override
	public void flush() {
		super.getHibernateTemplate().flush();

	}

	/**
	 * �����еĶ���
	 */
	@Override
	public void clear() {
		super.getHibernateTemplate().clear();
	}

	/**
	 * ��ȡ��ǰ���뵥����ˮ��
	 * @author IRun 
	 * @param sheetcode �?���룬��01
	 * @param columnname ����,��Ӧpojoʵ������ֶ�
	 * @param t ����
	 * @return ���뵥��
	 */
	public  String getApplyNo(String sheetcode, Class t,String columnname){
		// ���ڸ�ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//��ȡ����
       String tablename=t.getSimpleName();
		// ��ѯ�����������뵥��ˮ��
		String hql = "select max(substr(tb."+columnname+",11,4)) from "+tablename+" tb"
				+ " where tb."+columnname+" like ?";
		Session session = getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0,"%"+sdf.format(new Date())+sheetcode+"%");
		Object applyno= query.uniqueResult();
		
		//������뵥��
		if (applyno == null) {
				return sdf.format(new Date())+sheetcode+"0001";
		} else {
			String runingNum = applyno.toString();
			Integer no = Integer.parseInt(runingNum) + 1;
			String noStr = no.toString();
			if (noStr.length() == 1) {
				noStr = "000" + noStr;
			} else if (noStr.length() == 2) {
				noStr = "00" + noStr;
			} else if(noStr.length() == 3){
				noStr = "0" +noStr;
			}
			return sdf.format(new Date())+sheetcode+noStr;
		}
	}

	/**
	 * ��������
	 * @param objs ��Ҫ���µĶ��󼯺�
	 */
	@Override
	public void batchUpdate(final List objs) {
		getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				int len = objs.size();
				for (int i = 0; i < len; i++) {
					session.update(objs.get(i));
					if (i % 15 == 0) {
						session.flush();
						session.clear();
					}
				}
				return null;
			}
		});
	}

	/**
	 * ��������
	 * @param objs ��Ҫ����Ķ��󼯺�
	 */
	@Override
	public void batchInsert(final List objs) {
		getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				int len = objs.size();
				for (int i = 0; i < len; i++) {
					session.save(objs.get(i));
					if (i % 15 == 0) {
						session.flush();
						session.clear();
					}
				}
				return null;
			}
		});
	}
	@Override
	public List pageSearchCriteriaByHQL(String hql, List argsList,
			Integer pageNo, Integer pageSize) {
		try {
			if (pageSize == 0) {
				pageSize = 10;
			}
			Query query = this.getSession().createQuery(hql)
					.setFirstResult((pageNo - 1) * pageSize)
					.setMaxResults(pageSize);
			if (null != argsList && argsList.size() > 0) {
				int size = argsList.size();
				for (int i = 0; i < size; i++) {
					query.setParameter(i, argsList.get(i));
				}
			} 
			return query.list();
		} catch (Exception e) {
			System.out.println("List条件查询异常。");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int countSum(String hql, List argsList){
		try {
			Query query = this.getSession().createQuery(hql);
			if (null != argsList && argsList.size() > 0) {
				int size = argsList.size();
				for (int i = 0; i < size; i++) {
					query.setParameter(i, argsList.get(i));
				}
			} 
			return query.list().size();
		} catch (Exception e) {
			System.out.println("List条件查询异常。");
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public void persit(Object obj){
		this.getHibernateTemplate().persist(obj);
	}
}






