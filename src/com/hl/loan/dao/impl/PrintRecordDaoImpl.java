package com.hl.loan.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.hl.loan.dao.PrintRecordDao;
import com.hl.loan.pojo.PrintRecord;

@Repository
public class PrintRecordDaoImpl extends BaseDaoImpl<PrintRecord> implements PrintRecordDao {

	@Override
	public void addPrintRecord(PrintRecord printRecord) {
		this.getHibernateTemplate().persist(printRecord);
	}

	@Override
	public List<PrintRecord> getPrintRecordByApplyCode(String applyCode) {
		Query query = this.getSession().createQuery(" from PrintRecord where 1=1 and contractNo=?");
		query.setParameter(0, applyCode);
		return query.list();
	}
}
