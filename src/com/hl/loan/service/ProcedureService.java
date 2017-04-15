package com.hl.loan.service;

import com.hl.loan.vi.Procedure;

public interface ProcedureService {

	public void processOa(Procedure proc);

	public int processPayments(Long applyId);

}
