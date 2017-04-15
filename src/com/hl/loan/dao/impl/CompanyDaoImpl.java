package com.hl.loan.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.hl.loan.dao.CompanyDao;
import com.hl.loan.pojo.Company;
import com.hl.loan.util.PageModel;
import org.hibernate.Query;

@SuppressWarnings("unchecked")
@Repository
public class CompanyDaoImpl extends BaseDaoImpl<Company> implements CompanyDao {

	@Override
	public PageModel<Company> showCompany(PageModel<Company> pm, Company company) {
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		StringBuffer hql = new StringBuffer("from Company where 1=1 and companyState!=4");
		List ulist = new ArrayList();
		if (company != null) {
			if (company.getCompanyKey() != null && !company.getCompanyKey().equals("")) {
				ulist.add(company.getCompanyKey());
				hql.append(" and companyKey=?");
			}

			if (company.getCompanyName() != null && !company.getCompanyName().equals("")) {
				hql.append(" and companyName like :companyName");
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
		if (company != null) {
			if (company.getCompanyName() != null && !company.getCompanyName().equals("")) {
				query.setParameter("companyName", "%" + company.getCompanyName() + "%");
				querys.setParameter("companyName", "%" + company.getCompanyName() + "%");
			}
		}
		List<Company> list = query.list();
		int countSum = querys.list().size();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(countSum);
		return pm;
	}

	@Override
	public List<Company> getAllCompany() {
		return this.getHibernateTemplate().find(" from Company where 1=1 and companyState!=4");
	}

	@Override
	public void addCompany(Company company) {
		this.getHibernateTemplate().persist(company);
	}

	@Override
	public int delCompany(String companyID) {
		Query query = this.getSession().createQuery("update Company set CompanyState=4 where 1=1 and CompanyID=?");
		query.setParameter(0, companyID);
		return query.executeUpdate();
	}

	@Override
	public List<Company> getCompanyByID(String companyID) {
		Query query = this.getSession().createQuery(" from Company where 1=1 and CompanyID=?");
		query.setParameter(0, companyID);
		return query.list();
	}

	@Override
	public int updateCompanyByID(String companyID, Company company) {
		this.getSession().saveOrUpdate(companyID, company);
		return 1;
	}

	public Company load(String companyID) {
		return (Company) this.getHibernateTemplate().get(Company.class, Long.parseLong(companyID));
	}
}