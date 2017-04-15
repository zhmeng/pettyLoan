package com.hl.loan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.loan.dao.ProcedureDao;
import com.hl.loan.service.ProcedureService;
import com.hl.loan.vi.Procedure;

@Service("procedureService")
public class ProcedureServiceImpl implements ProcedureService{
	@Autowired
	private ProcedureDao procedureDao;
	@Override
	public void processOa(Procedure proc){
		procedureDao.processOa(proc);
	}
	@Override
	public int processPayments(Long applyId){
		return procedureDao.processPayments(applyId);
	}
}
