package com.hl.loan.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.hl.loan.dao.ContractDao;
import com.hl.loan.pojo.Contract;
import com.hl.loan.util.PageModel;
import org.hibernate.Query;

@SuppressWarnings("unchecked")
@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao {

	@Override
	public PageModel<Contract> showContract(PageModel<Contract> pm, Contract contract) {
		int size = pm.getPageSize();
	    int pageno = pm.getPageNo();
	    if(pageno<=0){
	    	pageno=1;
	    }
	    int startNumber = (pageno - 1) * size;
		StringBuffer hql = new StringBuffer("from Contract where 1=1 and status!=5");
		List ulist = new ArrayList();
		if (contract != null) {
			if (contract.getContractNo() != null && !contract.getContractNo().equals("")) {
				ulist.add(contract.getContractNo());
				hql.append(" and contractNo=?");
			}

			if (contract.getContractName() != null && !contract.getContractName().equals("")) {
				hql.append(" and contractName like :contractName");
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
		if (contract != null) {
			if (contract.getContractName() != null && !contract.getContractName().equals("")) {
				query.setParameter("contractName", "%" + contract.getContractName() + "%");
				querys.setParameter("contractName", "%" + contract.getContractName() + "%");
			}
		}
		List<Contract> list = query.list();
		int countSum = querys.list().size();
		pm.setDatas(list);
		pm.setPageNo(pageno);
		pm.setPageSize(size);
		pm.setRecordCount(countSum);
		return pm;
	}

	@Override
	public void addContract(Contract contract) {
		this.getHibernateTemplate().persist(contract);
	}

	@Override
	public int delContract(String contractID) {
		Query query = this.getSession().createQuery("update Contract set Status=5 where 1=1 and ContractID=?");
		query.setParameter(0, contractID);
		return query.executeUpdate();
	}

	@Override
	public int updateContractByID(String contractID, Contract contract) {
		this.getSession().saveOrUpdate(contractID, contract);
		return 1;
	}

	@Override
	public Contract load(String contractID) {
		return (Contract) this.getHibernateTemplate().get(Contract.class, Long.parseLong(contractID));
	}
	
	@Override
	public Contract getContractByApplyID(Long applyID) {
		Query query = this.getSession().createQuery(" from Contract where applyID=?");
		Contract contract = (Contract) query.setParameter(0, applyID).uniqueResult();
		return contract;
	}
}
