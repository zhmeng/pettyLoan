package com.hl.loan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hl.loan.dao.PrintRecordDao;
import com.hl.loan.pojo.PrintRecord;
import com.hl.loan.service.PrintRecordService;

@Service("printRecordDao")
public class PrintRecordServiceImpl implements PrintRecordService {
	
	@Autowired
	private PrintRecordDao printRecordDao;

	@Override
	public void addPrintRecord(PrintRecord printRecord) {
		printRecordDao.addPrintRecord(printRecord);
	}

	@Override
	public List<PrintRecord> getPrintRecordByApplyCode(String applyCode) {
		return printRecordDao.getPrintRecordByApplyCode(applyCode);
	}
}
