package com.hl.loan.dao;

import com.hl.loan.vi.Procedure;

public interface ProcedureDao {

	public void processOa(Procedure proc);

	public int processPayments(Long applyId);

}
